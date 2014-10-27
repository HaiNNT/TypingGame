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
        return uDao.getRecentUsers();
    }

    @Override
    public List<Article> getRecentArticles() {
        return aDao.getRecentArticles();
    }

    @Override
    public boolean updateUser(String userId, boolean active) {
        if (active) {
            return uDao.activeUser(userId);
        } else {
            return uDao.unactiveUser(userId);
        }
    }

    @Override
    public boolean createArticle(String name, String content) {
        return aDao.insertArticle(name, content);
    }

    @Override
    public boolean updateArticle(String id, String content) {
        return aDao.updateArticle(id, content);
    }

    @Override
    public List<User> searchUser(String username) {
        return uDao.getUsers(username);
    }

    @Override
    public List<Article> searchArticle(String name) {
        return aDao.getArticles(name);
    }

    @Override
    public Article getArticle(String id) {
        try {
            return aDao.getArticle(Integer.parseInt(id));
        } catch (Exception e) {
            return null;
        }
    }
}
