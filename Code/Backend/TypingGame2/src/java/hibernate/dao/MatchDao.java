/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.dao;

import core.entities.Match;
import core.idao.IMatchDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class MatchDao implements IMatchDao {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("TypingGamePU");

    @Override
    public Match getMatch(int id) {
        EntityManager manager = factory.createEntityManager();
        try {
            Match match = manager.find(hibernate.entities.Match.class, id);
            return match;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Match> getMatches(Map<String, Object> params) {
        //Not implemented yet
        return null;
    }

    @Override
    public Match insertMatch(Match match) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(match);
            manager.flush();
            manager.getTransaction().commit();
            return match;
        } catch (Exception e) {
            return null;
        } finally {
            manager.close();
        }
    }

    @Override
    public boolean insertMatchs(List<Match> matches) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteMatch(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteMatchs(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateMatch(Match match) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            Match m = manager.find(Match.class, match.getId());
            m.setCoreResultList(match.getCoreResultList());
            manager.getTransaction().begin();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            manager.close();
        }
    }

    @Override
    public List<Match> getInvitedMatches(int userId) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createNativeQuery("Select tgmatch.* "
                    + "From tgmatch, tgresult "
                    + "Where tgmatch.Id = tgresult.MatchId "
                    + "AND tgmatch.UserId <> ? "
                    + "AND tgresult.UserId = ? "
                    + "AND tgresult.speed = -1", hibernate.entities.Match.class)
                    .setParameter(1, userId)
                    .setParameter(2, userId);
            if (query.getResultList() == null) {
                return new ArrayList<Match>();
            }
            return (List<Match>) query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Match> getUnplayedMatches(int userId) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createNativeQuery("Select tgmatch.* "
                    + "From tgmatch, tgresult "
                    + "Where tgmatch.Id = tgresult.MatchId "
                    + "AND tgmatch.UserId = ? "
                    + "AND tgresult.UserId = ? "
                    + "AND tgresult.speed = -1", hibernate.entities.Match.class)
                    .setParameter(1, userId)
                    .setParameter(2, userId);
            if (query.getResultList() == null) {
                return new ArrayList<Match>();
            }
            return (List<Match>) query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    
    //MinhHV
    @Override
    public List<Match> getRecentMatch(int id) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createNativeQuery("select distinct m.* "
                    + "from tgmatch m, tgresult r "
                    + "where m.Id = r.MatchId "
                    + "AND r.UserId = ? "
                    + "AND r.Rate Is not null limit 10", hibernate.entities.Match.class).setParameter(1, id);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
