/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.ibuilder;

import core.entities.Match;
import core.entities.Result;
import core.entities.User;

/**
 *
 * @author Administrator
 */
public interface IResultBuilder {
    public Result buildCoreResult();
    public IResultBuilder clearBuilder();
    public IResultBuilder setId(Integer id);
    public IResultBuilder setRate(Integer rate);
    public IResultBuilder setSpeed(int speed);
    public IResultBuilder setMatch(Match match);
    public IResultBuilder setUser(User user);
    
}
