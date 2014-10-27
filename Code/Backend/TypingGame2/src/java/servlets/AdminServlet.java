/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import core.entities.Article;
import core.entities.User;
import core.iservice.IAdminService;
import core.iservice.IAuthenticationService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import typinggame.services.AdminService;
import typinggame.services.AuthenticationService;
import utils.Constant;

/**
 *
 * @author Administrator
 */
public class AdminServlet extends HttpServlet {

    IAdminService adService;
    IAuthenticationService auService;

    public AdminServlet() {
        adService = AdminService.getInstance();
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

        User user = (User) request.getSession().getAttribute("user");
        if (auService.validAdmin(user)) {
            String action = request.getParameter("action") == null ? "view" : request.getParameter("action");
            if (action.equalsIgnoreCase("view")) {
                List<User> users = adService.getRecentUsers();
                request.getSession().setAttribute("users", users);
                request.getRequestDispatcher(Constant.JSP_ADMIN).forward(request, response);
            } else if (action.equalsIgnoreCase("update-user")) {
                String userId = request.getParameter("txtUserId");
                boolean active = request.getParameter("txtActive").equalsIgnoreCase("true");
                adService.updateUser(userId, active);
                response.sendRedirect("Admin");
            } else if (action.equalsIgnoreCase("create")) {
                String name = request.getParameter("txtName");
                String content = request.getParameter("txtContent");
                if (name.equals("") || content.equals("")) {
                    String message = "Invalid Name or Content!";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher(Constant.JSP_ADMIN).forward(request, response);
                } else {
                    adService.createArticle(name, content);
                    response.sendRedirect("Admin");
                }
            } else if (action.equalsIgnoreCase("update")) {
                String id = request.getParameter("txtId");
                String content = request.getParameter("txtContent");
                if (id.equals("") || content.equals("")) {
                    String message = "Invalid Content!";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher(Constant.JSP_ADMIN).forward(request, response);
                } else {
                    adService.updateArticle(id, content);
                    response.sendRedirect("Admin");
                }
            } else if (action.equalsIgnoreCase("search-user")) {
                String username = request.getParameter("txtUsername") == null ? "" : request.getParameter("txtUsername");
                List<User> users = adService.searchUser(username);
                request.getSession().setAttribute("resultUsers", users);
                response.sendRedirect("Admin");
            } else if (action.equalsIgnoreCase("search")) {
                String name = request.getParameter("txtName") == null ? "" : request.getParameter("txtName");
                List<Article> articles = adService.searchArticle(name);
                request.getSession().setAttribute("articles", articles);
                response.sendRedirect("Admin");
            }else if(action.equalsIgnoreCase("get-article")){
                String id = request.getParameter("txtId");
                Article article = adService.getArticle(id);
                request.setAttribute("article", article);
                request.getRequestDispatcher(Constant.JSP_ADMIN).forward(request, response);
            }
        } else {
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
