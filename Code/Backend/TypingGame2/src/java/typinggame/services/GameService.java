/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typinggame.services;

import core.idao.IUserDao;
import core.idao.IArticleDao;
import core.idao.IMatchDao;
import core.idao.IResultDao;
import core.ibuilder.*;
import hibernate.dao.ArticleDao;
import hibernate.dao.MatchDao;
import hibernate.dao.ResultDao;
import hibernate.dao.UserDao;
import core.entities.Article;
import core.entities.Match;
import core.entities.Result;
import core.entities.User;
import core.iservice.IGameService;
import hibernate.builder.ArticleBuilder;
import hibernate.builder.MatchBuilder;
import hibernate.builder.ResultBuilder;
import hibernate.builder.UserBuilder;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HaiNNT
 */
public class GameService implements IGameService {

    IMatchDao mDao;
    IArticleDao aDao;
    IResultDao rDao;
    IUserDao uDao;
    IArticleBuilder aBuilder;
    IMatchBuilder mBuilder;
    IResultBuilder rBuilder;
    IUserBuilder uBuilder;

    private GameService() {
        mDao = new MatchDao();
        aDao = new ArticleDao();
        rDao = new ResultDao();
        uDao = new UserDao();
        aBuilder = new ArticleBuilder();
        mBuilder = new MatchBuilder();
        rBuilder = new ResultBuilder();
        uBuilder = new UserBuilder();
    }
    
    private static class Holder{
        private static final GameService INSTANCE = new GameService();
    }
    
    public static GameService getInstance(){
        return Holder.INSTANCE;
    }

    @Override
    public Match getMatch(User user, String username) {
        User competitor;
        Article article = aDao.getRandomArticle();
        Match match = mBuilder.clearBuilder().buildCoreMatch();
        match.setCoreUserId(user);
        match.setCoreArticleId(article);
        match.setCreatedDate(new Date());
        if (username.equals("") || username.equals(user.getUsername())) {
            match.setMode("random");
            competitor = uDao.getRandomUser(username);
        } else {
            match.setMode("friend");
            competitor = uDao.getUser(username);
        }
        match = mDao.insertMatch(match);
        while (user.equals(competitor) || !competitor.isPlayer()) {
            competitor = uDao.getRandomUser(user.getUsername());
        }

        if (competitor == null) {
            return null;
        }

        match.addCoreResult(rDao.insertResult(match, user));
        match.addCoreResult(rDao.insertResult(match, competitor));

        return match;
    }

    @Override
    public Match getMatch(int matchId) {
        Match match = mDao.getMatch(matchId);
        match.setCoreResultList(rDao.getResults(match));
        if (match.isPlayedMatch()) {
            return null;
        }
        return match;
    }

    private boolean updateMatch(int matchId, int userId, int speed) {
        Match match = mDao.getMatch(matchId);
        if (!match.getCoreUserId().getId().equals(userId)) {
            match.setCoreResultList(rDao.getResults(match));
            match.updateResults();
            rDao.updateResults(match.getCoreResultList());
            return mDao.updateMatch(match);
        }
        return true;
    }

    private boolean updateUser(User user, int speed) {
        int resultNum = rDao.countResult(user.getId());
        user.setBestSpeed(speed);
        user.setAverageSpeed(speed, resultNum);
        return uDao.updateUser(user);
    }

    private boolean updateResult(int userId, int matchId, int speed) {
        Result result = rBuilder.clearBuilder().setMatch(mBuilder.clearBuilder().setId(matchId).buildCoreMatch())
                .setUser(uBuilder.clearBuilder().setId(userId).buildCoreUser())
                .setSpeed(speed)
                .buildCoreResult();
        return rDao.updateResult(result);
    }

    @Override
    public boolean setResult(int matchId, User user, int speed) {
        if (!updateResult(user.getId(), matchId, speed)) {
            return false;
        }
        if (!updateMatch(matchId, user.getId(), speed)) {
            return false;
        }
        return updateUser(user, speed);
    }

    public List<Match> getInvitedMatches(int userId) {
        return mDao.getInvitedMatches(userId);
    }

    public List<Match> getUnplayedMatches(int userId) {
        return mDao.getUnplayedMatches(userId);
    }

    @Override
    public List<Match> getNotificationMatches(int userId) {
        List<Match> match = getInvitedMatches(userId);
        match.addAll(getUnplayedMatches(userId));
        return match;
    }

}
