/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.idao;

import core.entities.Match;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public interface IMatchDao {

    public Match getMatch(int id);

    public List<Match> getMatches(Map<String, Object> params);

    public List<Match> getInvitedMatches(int userId);

    public List<Match> getUnplayedMatches(int userId);

    public Match insertMatch(Match match);

    public boolean insertMatchs(List<Match> matches);

    public boolean deleteMatch(int id);

    public boolean deleteMatchs(List<Integer> ids);

    public boolean updateMatch(Match match);

    //MinhHV
    public List<Match> getRecentMatch(int id);

}
