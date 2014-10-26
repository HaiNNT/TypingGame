/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.ibuilder;

import core.entities.Role;
import core.entities.User;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IRoleBuilder {
    public Role buildCoreRole();
    public IRoleBuilder clearBuilder();
    public IRoleBuilder setId(Integer id);
    public IRoleBuilder setName(String name);
    public IRoleBuilder setUsers(List<User> users);
}
