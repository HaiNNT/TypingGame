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
public abstract class Article implements Serializable {

    public abstract Integer getId();

    public abstract void setId(Integer id);

    public abstract String getContent();

    public abstract void setContent(String content);

    public abstract Date getDateCreated();

    public abstract void setDateCreated(Date dateCreated);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract List<Match> getCoreMatchList();

    public abstract void setCoreMatchList(List<Match> matchList);

    public abstract User getCoreUserId();

    public abstract void setCoreUserId(User userId);

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object object);

    @Override
    public abstract String toString();

}
