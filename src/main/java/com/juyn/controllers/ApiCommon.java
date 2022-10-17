package com.juyn.controllers;

import com.juyn.pojo.BillOrder;
import com.juyn.pojo.Comment;
import com.juyn.pojo.Order;
import com.juyn.pojo.Tour;
import com.juyn.repository.CommonRepository;
//import com.juyn.pojo.User;
import com.juyn.service.CommentService;
import com.juyn.service.TourService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiCommon {

    @Autowired
    private CommentService commentService;
    @Autowired
    private TourService tourservice;

    @GetMapping("/api/tour")
    public ResponseEntity<List<Tour>> listTour() {
        return new ResponseEntity<>(this.tourservice.getTour(), HttpStatus.OK);
    }

    @GetMapping("/api/order")
    public int order(HttpSession session) {
        Map<Integer, Order> order = (Map<Integer, Order>) session.getAttribute("order");
        return ApiHandlers.countOrder(order);
    }

    @GetMapping("/api/order/{tourId}")
    public int order(@PathVariable(value = "tourId") Integer tourId, HttpSession session) { //Void
        Map<Integer, Order> order = (Map<Integer, Order>) session.getAttribute("order");
        if (order == null) {
            order = new HashMap<>();
        }
        if (order.containsKey(tourId) == true) {
            // Tour da co trong Order
            Order o = order.get(tourId);
            o.setCount(o.getCount() + 1);
        } else {
            // Tour chua co trong Order
            Tour t = this.tourservice.getTourIndex(tourId);
            Order o = new Order();
            //LocalDateTime now = LocalDateTime.now();  
            o.setTourId(t.getId());
            o.setName(t.getName());
            o.setPrice(t.getPrice());
            o.setCount(1);
            o.setTimeStart(new Date());
            order.put(tourId, o);
        }
        session.setAttribute("order", order);
        return ApiHandlers.countOrder(order);
    }

    @PutMapping("/api/order")
    //@ResponseStatus(HttpStatus.OK) // Void => Return == HttpStatus
    public ResponseEntity<Map<String, String>> updateOrder(@RequestBody Order params, HttpSession session) {
        Map<Integer, Order> order = (Map<Integer, Order>) session.getAttribute("order");
        if (order == null) {
            order = new HashMap<>();
        }
        int tourId = params.getTourId();
        if (order.containsKey(tourId) == true) {
            Order o = order.get(tourId);
            o.setCount(params.getCount());
        }
        session.setAttribute("order", order);
        return new ResponseEntity<>(ApiHandlers.orderStatus(order), HttpStatus.OK);
    }

    @DeleteMapping("/api/order/{tourId}")
    public ResponseEntity<Map<String, String>> deleteOrder(@PathVariable(value = "tourId") int tourId, HttpSession session) {
        Map<Integer, Order> order = (Map<Integer, Order>) session.getAttribute("order");
        if (order.containsKey(tourId)) {
            order.remove(tourId);
            session.setAttribute("order", order);
        }
        return new ResponseEntity<>(ApiHandlers.orderStatus(order), HttpStatus.OK);
    }

    @PostMapping(path = "/api/add-comment", produces = {MediaType.APPLICATION_JSON_VALUE}) //Default ("/xxx") /xxx <=> =path | Many params => pr1 = "", pr2 = {}, pr3 = ???...
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params) {
        try {
            String content = params.get("content");
            int tourId = Integer.parseInt(params.get("tourId"));
            int userId = Integer.parseInt(params.get("userId"));
            Comment c = this.commentService.addComment(content, tourId, userId);

            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (NumberFormatException ex) {}
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    // GET JSON TEST
    @Autowired
    private CommonRepository commonRepository;

    @GetMapping("/api/getBill")
    @Transactional
    public ResponseEntity<BillOrder> getBill() {
        //Session session = this.sessionFactory.getObject().getCurrentSession();
        return new ResponseEntity<>(this.commonRepository.getBill().get(1), HttpStatus.OK);
    }
    
    @GetMapping("/api/getComment")
    public ResponseEntity<Comment> getComment() {
        return new ResponseEntity<>(this.commonRepository.getComment().get(1), HttpStatus.OK);
    }
    
    @GetMapping("/api/getTour")
    public ResponseEntity<Tour> getTour() {
        return new ResponseEntity<>(this.tourservice.getTour().get(0), HttpStatus.OK);
    }
}
