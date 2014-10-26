/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.builder;

import core.entities.Match;
import core.entities.Result;
import core.entities.User;
import core.ibuilder.IResultBuilder;

/**
 *
 * @author Administrator
 */
public class ResultBuilder implements core.ibuilder.IResultBuilder {
    private hibernate.entities.Result result = new hibernate.entities.Result();
    @Override
    public Result buildCoreResult() {
        return (Result) result;
    }

    @Override
    public IResultBuilder setRate(Integer rate) {
        result.setRate(rate);
        return this;
    }

    @Override
    public IResultBuilder setSpeed(int speed) {
        result.setSpeed(speed);
        return this;
    }

    @Override
    public IResultBuilder setMatch(Match match) {
        result.setMatchId((hibernate.entities.Match) match);
        return this;
    }

    @Override
    public IResultBuilder setUser(User user) {
        result.setUserId((hibernate.entities.User) user);
        return this;
    }

    @Override
    public IResultBuilder setId(Integer id) {
        result.setId(id);
        return this;
    }

    @Override
    public IResultBuilder clearBuilder() {
        result = new hibernate.entities.Result();
        return this;
    }
    
}
