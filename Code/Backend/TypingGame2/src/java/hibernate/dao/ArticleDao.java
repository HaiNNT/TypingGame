/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.dao;

import core.entities.Article;
import core.entities.User;
import core.idao.IArticleDao;
import java.util.Date;
import java.util.List;
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
        EntityManager manager = factory.createEntityManager();
        try {
            Article article = manager.find(hibernate.entities.Article.class, id);
            return article;
        } catch (NoResultException e) {
            return null;
        }
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

    @Override
    public List<Article> getRecentArticles() {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery("SELECT a FROM Article a "
                    + "ORDER BY a.dateCreated")
                    .setMaxResults(10);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public boolean insertArticle(String name, String content, int userId) {
        EntityManager manager = factory.createEntityManager();
        try {
            Article article = new hibernate.entities.Article(content, new Date(), name);
            User user = manager.find(hibernate.entities.User.class, userId);
            article.setCoreUserId(user);
            manager.getTransaction().begin();
            manager.persist(article);
            manager.flush();
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            return false;
        } finally {
            manager.close();
        }
    }

    @Override
    public boolean updateArticle(String id, String content) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            Article article = manager.find(hibernate.entities.Article.class, Integer.parseInt(id));
            article.setContent(content);
            manager.flush();
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            return false;
        } finally {
            manager.close();
        }
    }

    @Override
    public List<Article> getArticles(String name) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery("SELECT a FROM Article a "
                    + "WHERE a.name LIKE :name")
                    .setParameter("name", "%" + name + "%")
                    .setMaxResults(10);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
