/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typinggame.services;

import core.entities.Article;
import core.entities.User;
import core.idao.IArticleDao;
import core.idao.IUserDao;
import core.iservice.IAdminService;
import hibernate.dao.ArticleDao;
import hibernate.dao.UserDao;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class AdminService implements IAdminService {

    IUserDao uDao;
    IArticleDao aDao;

    private AdminService() {
        uDao = new UserDao();
        aDao = new ArticleDao();
    }

    private static class Holder {

        private static final AdminService INSTANCE = new AdminService();
    }

    public static AdminService getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public List<User> getRecentUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Article> getRecentArticles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateUser(String userId, boolean active) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createArticle(String name, String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateArticle(String id, String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteArticle(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> searchUser(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Article> searchArticle(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
