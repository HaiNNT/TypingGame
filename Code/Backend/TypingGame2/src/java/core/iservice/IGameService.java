/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.iservice;

import core.entities.Match;
import core.entities.User;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IGameService {
    public Match getMatch(User user, String username);
    public Match getMatch(int Id);
    public boolean setResult(int matchId, User user, int speed);
    public List<Match> getNotificationMatches(int userId);
}
