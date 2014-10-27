/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.iservice;

import core.entities.Article;
import core.entities.User;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IAdminService {

    public List<User> getRecentUsers();

    public List<Article> getRecentArticles();

    public boolean updateUser(String userId, boolean active);

    public boolean createArticle(String name, String content, int userId);

    public boolean updateArticle(String id, String content);

    public List<User> searchUser(String username);

    public List<Article> searchArticle(String name);

    public Article getArticle(String id);
    
}
