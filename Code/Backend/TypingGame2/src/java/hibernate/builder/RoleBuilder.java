/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.builder;

import core.entities.Role;
import core.entities.User;
import core.ibuilder.IRoleBuilder;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class RoleBuilder implements core.ibuilder.IRoleBuilder {
    private hibernate.entities.Role role = new hibernate.entities.Role();
    @Override
    public Role buildCoreRole() {
        return (Role) role;
    }

    @Override
    public IRoleBuilder setName(String name) {
        role.setName(name);
        return this;
    }

    @Override
    public IRoleBuilder setUsers(List<User> users) {
        role.setUserList((List<hibernate.entities.User>)(List<?>) users);
        return this;
    }

    @Override
    public IRoleBuilder setId(Integer id) {
        role.setId(id);
        return this;
    }

    @Override
    public IRoleBuilder clearBuilder() {
        role = new hibernate.entities.Role();
        return this;
    }
    
}
