/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.entities;


import java.io.Serializable;
import java.util.List;


/**
 *
 * @author Administrator
 */

public abstract class Role implements Serializable {

    public abstract Integer getId();

    public abstract void setId(Integer id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract List<User> getCoreUserList();

    public abstract void setCoreUserList(List<User> userList);

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object object);

    @Override
    public abstract String toString();
    
}
