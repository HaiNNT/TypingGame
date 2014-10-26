/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.iservice;

import core.entities.User;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IHomeService {

    //ThangNT
    public List<User> getTopSpeed();

    //ThangNT
    public List<User> getTopScore();
}
