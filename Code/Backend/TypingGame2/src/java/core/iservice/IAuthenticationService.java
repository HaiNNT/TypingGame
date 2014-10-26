/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.iservice;

import core.entities.Role;
import core.entities.User;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public interface IAuthenticationService {

    //HaiNNT
    public boolean validPlayer(User user);

        //HaiNNT
    public boolean validAdmin(User user);

    //ThangNT
    public User login(String username, String password);

    //ThangNT
    public User register(String username, String password, String fullname, String email, Date date, Role role);

    //ThangNT
    public boolean checkDuplicate(String username);
}
