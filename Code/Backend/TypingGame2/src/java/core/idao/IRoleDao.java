/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.idao;

import core.entities.Role;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IRoleDao {
    public List<Role> getUserRoles(String username);
}
