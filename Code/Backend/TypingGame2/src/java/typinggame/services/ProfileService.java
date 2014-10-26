/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typinggame.services;

import core.entities.Match;
import core.entities.User;
import core.idao.IMatchDao;
import core.idao.IUserDao;
import core.iservice.IProfileService;
import hibernate.dao.MatchDao;
import hibernate.dao.UserDao;
import java.util.List;

/**
 *
 * @author MinhHV
 */
public class ProfileService implements IProfileService {

    IUserDao uDao;
    IMatchDao mDao;

    private ProfileService() {
        uDao = new UserDao();
        mDao = new MatchDao();
    }

    private static class Holder {

        private static final ProfileService INSTANCE = new ProfileService();
    }

    public static ProfileService getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public User getProfile(int id) {
        return uDao.getOneUser(id);
    }

    @Override
    public boolean updateProfile(int id, String newFullname, String newPassword, String newEmail) {
        uDao.updateUser(id, newFullname, newPassword, newEmail);
        return true;
    }

    @Override
    public int getMinSpeed(int id) {
        return uDao.getMinSpeed(id);
    }

    @Override
    public int getRate(int minspeed) {
        return uDao.getRate(minspeed);
    }

    @Override
    public int getmatchWin(int id) {
        return uDao.matchWin(id);
    }

    @Override
    public int getmatchLoose(int id) {
        return uDao.matchLoose(id);
    }

    @Override
    public List<Match> getRecentMatch(int id) {
        return mDao.getRecentMatch(id);
    }
}
