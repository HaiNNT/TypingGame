/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.iservice;

import core.entities.Match;
import core.entities.User;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IProfileService {
   public User getProfile(int id);
   public boolean updateProfile(int id, String newFullname , String newPassword,String newEmail);
   public int getMinSpeed(int minspeed);
   public int getRate(int id);
   public int getmatchWin(int id);
   public int getmatchLoose(int id);
   public List<Match> getRecentMatch(int id);  
}
