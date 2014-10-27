/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.idao;

import core.entities.Role;
import core.entities.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IUserDao {

    //HaiNNT
    public User getRandomUser(String username);

    //HaiNNT
    public User getUser(String username);

    //HaiNNT
    public boolean updateUser(User user);

    //MinhHV
    public User getOneUser(int id);

    //MinhHV
    public boolean updateUser(int id, String newFullname, String newPassword, String newEmail);

    //MinhHV
    public int getMinSpeed(int id);

    //MinhHV
    public int getRate(int minspeed);

    //MinhHV
    public int matchWin(int id);

    //MinhHV
    public int matchLoose(int id);

    //ThangNT
    public User login(String username, String password);

    //ThangNT
    public User register(String username, String password, String fullname, String email, Date date, Role role);

    //ThangNT
    public List<User> getTopSpeed();

    //ThangNT
    public List<User> getTopScore();

    //ThangNT
    public User getUserByUsername(String username);

    //PhucTQ
    public List<User> getRecentUsers();

    //PhucTQ
    public boolean activeUser(String userId);

    //PhucTQ
    public boolean unactiveUser(String userId);

    //PhucTQ
    public List<User> getUsers(String username);
}
