/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import core.entities.User;
import core.iservice.IAuthenticationService;
import core.iservice.IGameService;
import core.iservice.IHomeService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import typinggame.services.AuthenticationService;
import typinggame.services.GameService;
import typinggame.services.HomeService;
import utils.Constant;

/**
 *
 * @author Administrator
 */
public class HomeServlet extends HttpServlet {

    IHomeService hService;
    IAuthenticationService aService;
    IGameService gService;

    public HomeServlet() {
        hService = HomeService.getInstance();
        aService = AuthenticationService.getInstance();
        gService = GameService.getInstance();
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

        //Get session attr
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (aService.validPlayer(user)) {
            user.setCoreMatchList(gService.getNotificationMatches(user.getId()));
            session.setAttribute("user", user);
        } else if (aService.validAdmin(user)) {
            response.sendRedirect("Admin");
        }
        List<User> users = hService.getTopSpeed();
        request.setAttribute("topSpeed", users);
        List<User> users1 = hService.getTopScore();
        request.setAttribute("topScore", users1);
        request.getRequestDispatcher(Constant.JSP_HOME).forward(request, response);
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
