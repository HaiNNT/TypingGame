/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import core.entities.Match;
import core.entities.User;
import core.iservice.IAuthenticationService;
import core.iservice.IProfileService;
import utils.Constant;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import typinggame.services.AuthenticationService;
import typinggame.services.ProfileService;

/**
 *
 * @author Administrator
 */
public class ProfileServlet extends HttpServlet {

    IProfileService pService;
    IAuthenticationService auService;

    public ProfileServlet() {
        pService = ProfileService.getInstance();
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
        String action = request.getParameter("action") == null ? "view" : request.getParameter("action");

        User user = (User) request.getSession().getAttribute("user");
        if (!auService.validPlayer(user)) {
            response.sendRedirect("Home");
            return;
        } else {
        //Get profile user 
            // MinhHV - 10-22-2014
            if (action.equalsIgnoreCase("view")) {
                int userId = user.getId();
                int matchWin = pService.getmatchWin(userId);
                int matchLoose = pService.getmatchLoose(userId);
                int minSpeed = pService.getMinSpeed(userId);
                int rate = pService.getRate(minSpeed) + 1;
                List<Match> list = pService.getRecentMatch(userId);
                request.setAttribute("user", user);
                request.setAttribute("matchWin", matchWin);
                request.setAttribute("matchLoose", matchLoose);
                request.setAttribute("rate", rate);
                request.setAttribute("listRecentMatch", list);
                RequestDispatcher dis = request.getRequestDispatcher(Constant.JSP_PROFILE);
                dis.forward(request, response);
            } else if (action.equalsIgnoreCase("edit")) {// Change password - MinhHV - 10-22-2014
                int userId = user.getId();
                String fullname = request.getParameter("txtFullname") == null ? "" : request.getParameter("txtFullname");
                String email = request.getParameter("txtEmail") == null ? "" : request.getParameter("txtEmail");
                String oldpassword = request.getParameter("txtPassword") == null ? "" : request.getParameter("txtPassword");
                String newpassword = request.getParameter("txtNewPassword") == null ? "" : request.getParameter("txtNewPassword");
                String confirmpassword = request.getParameter("txtConfirm") == null ? "" : request.getParameter("txtConfirm");

                if (!fullname.equals("") && !email.equals("")) {
                    pService.updateProfile(userId, fullname, user.getPassword(), email);
                } else {
                    String message = "Invalid Fullname or Email!";
                    request.setAttribute("message", message);
                }
                if (!oldpassword.equals("")) {
                    if (newpassword.equalsIgnoreCase(confirmpassword) && user.getPassword().equalsIgnoreCase(oldpassword)) {
                        pService.updateProfile(userId, fullname, newpassword, email);
                    } else {
                        String message = "Wrong Current Password or Confirm Password!";
                        request.setAttribute("message", message);
                    }
                }
                response.sendRedirect("Profile");
            }
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
