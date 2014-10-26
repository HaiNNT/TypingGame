/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.entities;


import java.io.Serializable;

/**
 *
 * @author Administrator
 */

public abstract class Result implements Serializable {

    public abstract Integer getRate();

    public abstract void setRate(Integer rate);

    public abstract int getSpeed();

    public abstract void setSpeed(int speed);

    public abstract Integer getId();

    public abstract void setId(Integer id);

    public abstract Match getCoreMatchId();

    public abstract void setCoreMatchId(Match matchId);

    public abstract User getCoreUserId();

    public abstract void setCoreUserId(User userId);
    
    public abstract void setCoreResult(Result result);

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object object);

    @Override
    public abstract String toString();

}
