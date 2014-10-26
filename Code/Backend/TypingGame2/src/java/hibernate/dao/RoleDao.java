/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.dao;

import core.entities.Role;
import core.idao.IRoleDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class RoleDao implements IRoleDao {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("TypingGamePU");

    @Override
    public List<Role> getUserRoles(String username) {
        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery("SELECT R FROM Role R "
                    + "INNER JOIN User U "
                    + "WHERE U.username = :username")
                    .setParameter("username", username);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
