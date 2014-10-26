/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.dao;

import core.entities.Match;
import core.entities.Result;
import core.entities.User;
import core.idao.IResultDao;
import java.math.BigInteger;
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
public class ResultDao implements IResultDao {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("TypingGamePU");

    @Override
    public Result insertResult(Match match, User user) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            hibernate.entities.Result result = new hibernate.entities.Result();
            result.setCoreMatchId(match);
            result.setCoreUserId(user);
            result.setSpeed(-1);
            manager.persist(result);
            manager.flush();
            manager.getTransaction().commit();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            manager.close();
        }
    }

    @Override
    public List<Result> getResults(Match match) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createNativeQuery("Select * From tgresult "
                    + "Where MatchId = ?", hibernate.entities.Result.class)
                    .setParameter(1, match.getId());
            return (List<Result>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Result getResult(int matchId, int userId) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createNativeQuery("Select * From tgresult "
                    + "Where MatchId = ? "
                    + "AND UserId = ?", hibernate.entities.Result.class)
                    .setParameter(1, matchId)
                    .setParameter(2, userId);
            return (Result) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public boolean updateResult(Result result) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            Result r = getResult(result.getCoreMatchId().getId(), result.getCoreUserId().getId());
            r.setCoreResult(result);
            manager.merge((hibernate.entities.Result) r);
            manager.getTransaction().commit();
            return true;
        } catch (NoResultException e) {
            return false;
        } finally {
            manager.close();
        }
    }

    @Override
    public int countResult(int userId) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createNativeQuery("Select count(*) "
                    + "From tgresult Where UserId = ?")
                    .setParameter(1, userId);
            return ((BigInteger)query.getSingleResult()).intValue();
        } catch (NoResultException e) {
            return -1;
        } finally {
            manager.close();
        }
    }

    @Override
    public boolean updateResults(List<Result> results) {
        for (Result result : results) {
            updateResult(result);
        }
        return true;
    }

}
