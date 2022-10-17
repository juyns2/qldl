

package com.juyn.configs.handlersAfterLoginLogout;

import com.juyn.pojo.User;
import com.juyn.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class AfterLogin implements AuthenticationSuccessHandler{

    @Autowired
    private UserService userDetailsService;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        User u = this.userDetailsService.getUser(a.getName()).get(0);
        request.getSession().setAttribute("currentUser", u);            // HttpSession Alway in Controller
        request.getSession().setAttribute("order", null);
        response.sendRedirect("/qldl");
    }

}
