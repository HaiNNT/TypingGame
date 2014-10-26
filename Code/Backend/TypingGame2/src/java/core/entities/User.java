/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public abstract class User implements Serializable {

    protected int winNum;

    public abstract int getWinNum();

    public abstract void setWinNum(int winNum);

    public abstract Integer getId();

    public abstract void setId(Integer id);

    public abstract String getUsername();

    public abstract void setUsername(String username);

    public abstract String getPassword();

    public abstract void setPassword(String password);

    public abstract String getFullname();

    public abstract void setFullname(String fullname);

    public abstract Integer getAverageSpeed();

    public abstract void setAverageSpeed(int speed, int resultNum);

    public abstract void setAverageSpeed(Integer averageSpeed);

    public abstract Integer getBestSpeed();

    public abstract void setBestSpeed(int bestSpeed);

    public abstract String getEmail();

    public abstract void setEmail(String email);

    public abstract Date getRegisterDate();

    public abstract void setRegisterDate(Date registerDate);

    public abstract int getStatus();

    public abstract void setStatus(int status);

    public abstract List<Role> getCoreRoleList();

    public abstract void setCoreRoleList(List<Role> roleList);

    public abstract List<Result> getCoreResultList();

    public abstract void setCoreResultList(List<Result> resultList);

    public abstract List<Match> getCoreMatchList();

    public abstract void setCoreMatchList(List<Match> matchList);

    public abstract List<Article> getCoreArticleList();

    public abstract void setCoreArticleList(List<Article> articleList);

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object object);

    @Override
    public abstract String toString();

    /**
     * Return true if user has role Player
     *
     * @return boolean
     */
    public abstract boolean isPlayer();

    /**
     * Return true if user has role Admin
     *
     * @return boolean
     */
    public abstract boolean isAdmin();

    /**
     * Return true if user is active
     *
     * @return boolean
     */
    public abstract boolean isActive();
}
