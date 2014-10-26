/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import core.entities.Match;
import core.entities.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import core.iservice.IAuthenticationService;
import core.iservice.IGameService;
import javax.servlet.http.HttpSession;
import typinggame.services.AuthenticationService;
import typinggame.services.GameService;
import utils.Constant;

/**
 *
 * @author Administrator
 */
public class GameServlet extends HttpServlet {

    IGameService gService;
    IAuthenticationService aService;

    public GameServlet() {
        gService = GameService.getInstance();
        aService = AuthenticationService.getInstance();
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
        String matchId;
        String action;
        String username;
        String speed;

        //Get session attr
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        //Get action parameter from request
        action = request.getParameter("action") == null ? "view" : request.getParameter("action");

        //Check user is player or not
        if (!aService.validPlayer(user)) {
            response.sendRedirect("Home");
        } else {
            user.setCoreMatchList(gService.getNotificationMatches(user.getId()));
            session.setAttribute("user", user);
            if (action.toLowerCase().equals("") || action.toLowerCase().equals("view")) {
                request.getRequestDispatcher(Constant.JSP_GAME).forward(request, response);
            } else if (action.toLowerCase().equals("create-match")) {
                username = request.getParameter("txtUsername") == null ? "" : request.getParameter("txtUsername");
                Match match = gService.getMatch(user, username);
                if (match == null) {
                    request.getRequestDispatcher(Constant.JSP_GAME).forward(request, response);
                }
                request.setAttribute("match", match);
                request.setAttribute("comResult", match.getCoreCompetitorResult(user.getUsername()));
                request.getRequestDispatcher(Constant.JSP_GAME).forward(request, response);
            } else if (action.toLowerCase().equals("match")) {
                matchId = request.getParameter("txtMatchId") == null ? "" : request.getParameter("txtMatchId");
                if (matchId.equals("")) {
                    response.sendRedirect(Constant.JSP_ERROR);
                } else {
                    Match match = gService.getMatch(Integer.parseInt(matchId));
                    if (match == null) {
                        request.getRequestDispatcher(Constant.JSP_GAME).forward(request, response);
                    } else {
                        request.setAttribute("match", match);
                        request.setAttribute("comResult", match.getCoreCompetitorResult(user.getUsername()));
                        request.getRequestDispatcher(Constant.JSP_GAME).forward(request, response);
                    }
                }
            } else if (action.toLowerCase().equals("send-result")) {
                matchId = request.getParameter("txtMatchId") == null ? "" : request.getParameter("txtMatchId");
                speed = request.getParameter("txtSpeed") == null ? "" : request.getParameter("txtSpeed");
                if (matchId.equals("") || speed.equals("")) {
                    response.sendRedirect(Constant.JSP_ERROR);
                } else {
                    if (gService.setResult(Integer.parseInt(matchId), user, Integer.parseInt(speed))) {
                        response.getWriter().println("done");
                    } else {
                        response.sendRedirect(Constant.JSP_ERROR);
                    }
                }
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
