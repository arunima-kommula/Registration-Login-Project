package com.register.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.register.dao.*;

import com.register.model.LoginBean;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
    	response.getWriter().append("Served at:  ").append(request.getContextPath());
    	
    	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/loginpro.jsp");
    	dispatcher.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("userid");
        String password = request.getParameter("pass");
        LoginBean loginBean = new LoginBean();
        loginBean.setUserid(username);
        loginBean.setPass(password);

        try {
            if (loginDao.validate(loginBean)) {
                //HttpSession session = request.getSession();
                 //session.setAttribute("userid",username);
            	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/loginsuccess.jsp");
            	dispatcher.forward(request,response);
            } else {
                //HttpSession session = request.getSession();
                //session.setAttribute("userid", username);
            	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/loginpro.jsp");
            	dispatcher.forward(request,response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}