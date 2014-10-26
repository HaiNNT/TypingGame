/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import hibernate.entities.Role;
import core.entities.User;
import core.iservice.IAuthenticationService;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import typinggame.services.AuthenticationService;
import utils.Constant;

/**
 *
 * @author Administrator
 */
public class AuthenticationServlet extends HttpServlet {

    IAuthenticationService auService;

    public AuthenticationServlet() {
        auService = AuthenticationService.getInstance();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        //Login
        if (action.equalsIgnoreCase("login")) {
            String errorMessage = "";
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            User user = auService.login(username, password);
            if (user != null) {
                request.getSession(true).setAttribute("user", user);
                if (user.isAdmin()) {
                    response.sendRedirect("Admin");
                } else {
                    response.sendRedirect("Home");
                }
            } else {
                errorMessage = "* Username or Password are wrong!";
                request.getSession().setAttribute("message", errorMessage);
                response.sendRedirect("Home");
            }
        } else if (action.equalsIgnoreCase("register")) {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confirmPassword = request.getParameter("txtConfirmPassword");
            String fullname = request.getParameter("txtFullName");
            String email = request.getParameter("txtEmail");
            Date date = new Date();
            boolean flag = true;
            String errorMessage = "";

            if (username.equals("") || password.equals("") || confirmPassword.equals("") || fullname.equals("") || email.equals("")) {
                errorMessage = "* Required field cannot blank!";
                flag = false;
            } else {
                if (!confirmPassword.equals(password)) {
                    errorMessage = "* Password and ConfirmPassword are not match!";
                    flag = false;
                }
                boolean check = auService.checkDuplicate(username);
                if (!check) {
                    errorMessage = "* Username are unavailable!";
                    flag = false;
                }
            }

            if (flag) {
                User result = auService.register(username, password, fullname, email, date, new Role(1, Constant.ROLE_PLAYER));
                if (result != null) {
                    request.getSession(true).setAttribute("user", result);
                    response.sendRedirect("Home");
                }
            } else {
                request.getSession().setAttribute("message", errorMessage);
                response.sendRedirect("Home");
            }
        } else if (action.equalsIgnoreCase("logout")) {
            request.getSession().setAttribute("user", null);
            response.sendRedirect("Home");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
