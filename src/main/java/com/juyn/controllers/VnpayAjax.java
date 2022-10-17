package com.juyn.controllers;

import com.juyn.pojo.Order;
import com.juyn.service.CommonService;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
//import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
//import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VnpayAjax {

    @Autowired
    private CommonService commonService;

    @PostMapping(path = "/api/vnpay", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, String>> ApiVnpay(@RequestBody Map<String, String> req, HttpSession session) throws ServletException, IOException {

        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        //String vnp_Command = "genqr";
        //String vnp_OrderInfo = "Test San Pham";       //req.getParameter("vnp_OrderInfo");
        String orderType = "Test Type";                 //req.getParameter("ordertype");
        String vnp_TxnRef = VnpayConfig.getRandomNumber(8);
        //int mcId = Integer.parseInt(VnpayConfig.getRandomNumber(8));
        //int amountmc = Integer.parseInt(req.get("amount"));
        String vnp_IpAddr = "192.168.1.19";
        String vnp_TmnCode = VnpayConfig.vnp_TmnCode;
        Long amount = Long.parseLong(ApiHandlers.orderStatus((Map<Integer, Order>) session.getAttribute("order")).get("priceOrder")) *100; //req.get("amount")
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        String bank_code = req.get("bankcode");
        String idUser = req.get("idUser");
        if (bank_code != null && !bank_code.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bank_code);
        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", idUser);        // vnp_OrderInfo => GET_ID_USER
        vnp_Params.put("vnp_OrderType", orderType);

        String locate = req.get("language");
        if (locate != null && !locate.isEmpty()) {
            vnp_Params.put("vnp_Locale", locate);
        } else {
            vnp_Params.put("vnp_Locale", "vn");
        }
        vnp_Params.put("vnp_ReturnUrl", VnpayConfig.vnp_Returnurl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Date dt = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(dt);
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        Calendar cldvnp_ExpireDate = Calendar.getInstance();
        cldvnp_ExpireDate.add(Calendar.SECOND, 30);
        Date vnp_ExpireDateD = cldvnp_ExpireDate.getTime();
        String vnp_ExpireDate = formatter.format(vnp_ExpireDateD);

        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                //hashData.append(fieldValue); //sử dụng 2.0.0 và 2.0.1 checksum sha256
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString())); //sử dụng v2.1.0  check sum sha512
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        //String vnp_SecureHash = VnpayConfig.Sha256(VnpayConfig.vnp_HashSecret + hashData.toString());
        String vnp_SecureHash = VnpayConfig.hmacSHA512(VnpayConfig.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VnpayConfig.vnp_PayUrl + "?" + queryUrl;

        Map<String, String> send = new HashMap<>();
        send.put("code", "00");
        send.put("message", "success");
        send.put("url", paymentUrl);
        return new ResponseEntity<>(send, HttpStatus.OK);
    }

    @PostMapping("/api/pay/{idUser}")
    public String pay(HttpSession session, @PathVariable(value = "idUser") int idUser) {
        if (this.commonService.addReceipt((Map<Integer, Order>) session.getAttribute("order"), idUser) != 0) {
            session.removeAttribute("order");
            return "VnpayReturnUrl";
        } else {
            return "Thanh Toan That Bai";
        }
    }
}
