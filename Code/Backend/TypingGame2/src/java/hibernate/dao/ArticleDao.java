/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.dao;

import core.entities.Article;
import core.idao.IArticleDao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class ArticleDao implements IArticleDao {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("TypingGamePU");

    @Override
    public Article getArticle(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Article getRandomArticle() {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createNativeQuery("Select a.* from "
                    + "(SELECT * From tgarticle "
                    + "ORDER BY RAND()) a limit 1", hibernate.entities.Article.class);
            Article article = (hibernate.entities.Article) query.getSingleResult();
            return article;
        } catch (NoResultException e) {
            return null;
        }
    }

}
