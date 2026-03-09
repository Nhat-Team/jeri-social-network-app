package io.github.nhatteam.project.core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Collections;

@Component
public class HeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String getSub = request.getHeader("X-Sub");

        if(getSub != null) {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(getSub, null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        return true;
    }
}
