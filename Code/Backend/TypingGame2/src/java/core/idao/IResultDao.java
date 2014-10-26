/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.idao;
import core.entities.Match;
import core.entities.User;
import core.entities.Result;
import java.util.List;
/**
 *
 * @author Administrator
 */
public interface IResultDao {
    public Result insertResult(Match match, User user);
    public Result getResult(int matchId, int userId);
    public List<Result> getResults(Match match);
    public boolean updateResult(Result result);
    public int countResult(int userId);
    public boolean updateResults(List<Result> results);
}
