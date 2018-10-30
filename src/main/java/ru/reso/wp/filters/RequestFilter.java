package ru.reso.wp.filters;

import ru.reso.wp.consts.Consts;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Главный фильтр-обработчик всех запросов к приложению
 * Если Session-timeout истек отправляем пользователя на страницу авторизации
 */
@WebFilter("/modules/*")
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            HttpSession session = request.getSession(false);
            String loginURI = request.getContextPath() + Consts.URL_LOGIN_PAGE;

            boolean loggedIn = session != null && session.getAttribute("user") != null;
            boolean loginRequest = request.getRequestURI().equals(loginURI);

            if (loggedIn || loginRequest) {
                filterChain.doFilter(request, response);
            } else {
                response.sendRedirect(loginURI);
            }
        }
    }
}
