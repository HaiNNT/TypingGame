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

public abstract class Match implements Serializable {

    public abstract Integer getId();

    public abstract void setId(Integer id);

    public abstract String getMode();

    public abstract void setMode(String mode);

    public abstract Date getCreatedDate();

    public abstract void setCreatedDate(Date createdDate);

    public abstract List<Result> getCoreResultList();

    public abstract void setCoreResultList(List<Result> resultList);
    
    public abstract Article getCoreArticleId();

    public abstract void setCoreArticleId(Article articleId);

    public abstract User getCoreUserId();

    public abstract void setCoreUserId(User userId);

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object object);

    @Override
    public abstract String toString();

    public abstract void updateResults();

    public abstract Result getCoreCompetitorResult(String username);

    public abstract Result getCoreCreaterResult();

    public abstract void addCoreResult(Result result);
    
    public abstract boolean isPlayedMatch();
}
