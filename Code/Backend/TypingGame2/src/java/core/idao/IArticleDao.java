/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.idao;

import core.entities.Article;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IArticleDao {
    public Article getArticle(int id);
    public Article getRandomArticle();   

    public List<Article> getRecentArticles();

    public boolean insertArticle(String name, String content, int userId);

    public boolean updateArticle(String id, String content);

    public List<Article> getArticles(String name);
}
