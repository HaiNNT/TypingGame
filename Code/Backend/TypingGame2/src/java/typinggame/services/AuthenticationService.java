/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typinggame.services;

import core.entities.Role;
import hibernate.dao.UserDao;
import core.entities.User;
import core.idao.IRoleDao;
import core.idao.IUserDao;
import core.iservice.IAuthenticationService;
import hibernate.dao.RoleDao;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class AuthenticationService implements IAuthenticationService {

    IUserDao uDao;
    IRoleDao rDao;

    private AuthenticationService() {
        uDao = new UserDao();
        rDao = new RoleDao();
    }

    private static class Holder {

        private static final AuthenticationService INSTANCE = new AuthenticationService();
    }

    public static AuthenticationService getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public boolean validPlayer(User user) {
        if (user == null) {
            return false;
        }
        return user.isPlayer() && user.isActive();
    }

    @Override
    public boolean validAdmin(User user) {
        if (user == null) {
            return false;
        }
        return user.isAdmin() && user.isActive();
    }

    @Override
    public User login(String username, String password) {
        User obj = uDao.login(username, password);
        //obj.setCoreRoleList(rDao.getUserRoles(username));
        return obj;
    }

    @Override
    public User register(String username, String password, String fullname, String email, Date date, Role role) {
        User obj = uDao.register(username, password, fullname, email, date, role);
        return obj;
    }

    @Override
    public boolean checkDuplicate(String username) {
        Object obj = uDao.getUserByUsername(username);
        return obj == null;
    }

}
