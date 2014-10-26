/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typinggame.services;

import core.entities.User;
import core.idao.IUserDao;
import core.iservice.IHomeService;
import hibernate.dao.UserDao;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class HomeService implements IHomeService {

    IUserDao uDao;

    private HomeService() {
        uDao = new UserDao();
    }

    private static class Holder {

        private static final HomeService INSTANCE = new HomeService();
    }

    public static HomeService getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public List<User> getTopSpeed() {
        List<User> users = uDao.getTopSpeed();
        return users;
    }

    @Override
    public List<User> getTopScore() {
        List<User> users = uDao.getTopScore();
        return users;
    }
}
