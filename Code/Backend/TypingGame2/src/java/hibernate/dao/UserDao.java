/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.dao;

import core.entities.Role;
import core.entities.User;
import core.idao.IUserDao;
import java.math.BigInteger;
import java.util.ArrayList;
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
public class UserDao implements IUserDao {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("TypingGamePU");

    //HaiNNT
    @Override
    public User getRandomUser(String username) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createNativeQuery("Select a.* from "
                    + "(SELECT * "
                    + "From tguser u "
                    + "where u.Username <> ? "
                    + "ORDER BY RAND()) a limit 1", hibernate.entities.User.class)
                    .setParameter(1, username);
            User user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    //HaiNNT
    @Override
    public User getUser(String username) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createNativeQuery("Select * "
                    + "From tguser "
                    + "Where tguser.Username = ?", hibernate.entities.User.class)
                    .setParameter(1, username);
            User user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    //HaiNNT
    @Override
    public boolean updateUser(User user) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            User u = manager.find(hibernate.entities.User.class, user.getId());
            u.setBestSpeed(user.getBestSpeed());
            u.setAverageSpeed(user.getAverageSpeed());
            manager.merge(u);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            return false;
        } finally {
            manager.close();
        }

    }

    //MinhHV
    @Override
    public User getOneUser(int id) {
        EntityManager manager = factory.createEntityManager();
        try {
            User user = manager.find(hibernate.entities.User.class, id);
            return user;
        } catch (Exception e) {
            return null;
        }

    }

    //MinhHV
    @Override
    public boolean updateUser(int id, String newFullname, String newPassword, String newEmail) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            User user = manager.find(hibernate.entities.User.class, id);
            if (user == null) {
                return false;
            }
            user.setFullname(newFullname);
            user.setPassword(newPassword);
            user.setEmail(newEmail);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            return false;
        } finally {
            manager.close();
        }

    }

    //MinhHV
    @Override
    public int getMinSpeed(int id) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery("select min(u.averageSpeed) from User u ");
            int count = (Integer) query.getSingleResult();
            return count;
        } catch (Exception e) {
            return -1;
        }

    }

    //MinhHV
    @Override
    public int getRate(int minspeed) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery("select count(u) "
                    + "from User u "
                    + "where u.averageSpeed > :minspeed");
            query.setParameter("minspeed", minspeed);
            int count = Integer.parseInt(query.getSingleResult().toString());
            return count;
        } catch (Exception e) {
            return -1;
        }
    }

    //MinhHV
    @Override
    public int matchWin(int id) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery("SELECT count(r) "
                    + "FROM Result r "
                    + "WHERE r.rate = 1 "
                    + "and r.userId.id=:userId");
            query.setParameter("userId", id);
            int count = Integer.parseInt(query.getSingleResult().toString());
            return count;
        } catch (Exception e) {
            return -1;
        }
    }

    //MinhHV
    @Override
    public int matchLoose(int id) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery("SELECT count(r) "
                    + "FROM Result r "
                    + "WHERE r.rate != 1 "
                    + "and r.userId.id=:userId");
            query.setParameter("userId", id);
            int count = Integer.parseInt(query.getSingleResult().toString());
            return count;
        } catch (Exception e) {
            return -1;
        }
    }

    //ThangNT
    @Override
    public User login(String username, String password) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery("select t "
                    + "from User t "
                    + "where t.username=:username "
                    + "and t.password=:password ", hibernate.entities.User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    //ThangNT  
    @Override
    public User register(String username, String password, String fullname, String email, Date date, Role role) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            hibernate.entities.User user = new hibernate.entities.User();

            user.setEmail(email);
            user.setFullname(fullname);
            user.setPassword(password);
            user.setRegisterDate(date);
            user.setUsername(username);

            List<Role> roles = new ArrayList<Role>();
            roles.add(role);

            user.setCoreRoleList(roles);

            manager.persist(user);
            manager.getTransaction().commit();
            return user;
        } catch (NoResultException e) {
            manager.getTransaction().rollback();
            return null;
        }
    }

    //ThangNT
    @Override
    public List<User> getTopSpeed() {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery("SELECT t "
                    + "FROM User t "
                    + "Inner Join t.roleList r "
                    + "Where r.name = 'player' "
                    + "AND t.averageSpeed is not null "
                    + "ORDER BY t.averageSpeed DESC ")
                    .setMaxResults(10);
            List<User> list = query.getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        }

    }

    //ThangNT
    @Override
    public List<User> getTopScore() {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createNativeQuery("Select u.* "
                    + "From tgresult r, tguser u "
                    + "where r.Rate = 1 AND r.UserId = u.Id "
                    + "Group By r.UserId "
                    + "Order By Count(*) Desc", hibernate.entities.User.class)
                    .setMaxResults(10);
            List<User> list = query.getResultList();

            query = manager.createNativeQuery("Select Count(*) as WinNum "
                    + "From tgresult r, tguser u "
                    + "where r.Rate = 1 AND r.UserId = u.Id "
                    + "Group By r.UserId "
                    + "Order By WinNum Desc")
                    .setMaxResults(10);
            List<BigInteger> winNumList = query.getResultList();

            for (int i = 0; i < list.size(); i++) {
                list.get(i).setWinNum(winNumList.get(i).intValue());
            }

            return list;
        } catch (NoResultException e) {
            return null;
        }
    }

    //ThangNT
    @Override
    public User getUserByUsername(String username) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery("select t FROM User t "
                    + "where t.username=:username");
            query.setParameter("username", username);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<User> getRecentUsers() {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery("SELECT u FROM User u "
                    + "ORDER BY u.registerDate")
                    .setMaxResults(10);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public boolean activeUser(String userId) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            User user = manager.find(hibernate.entities.User.class,  Integer.parseInt(userId));
            if (user == null) {
                return false;
            }
            user.setStatus(1);
            manager.merge(user);
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
    public boolean unactiveUser(String userId) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            User user = manager.find(hibernate.entities.User.class,  Integer.parseInt(userId));
            if (user == null) {
                return false;
            }
            user.setStatus(0);
            manager.merge(user);
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
    public List<User> getUsers(String username) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery("SELECT t FROM User t "
                    + "WHERE t.username LIKE :username")
                    .setParameter("username", "%" + username + "%")
                    .setMaxResults(10);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
