/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.ibuilder;

import core.entities.Article;
import core.entities.Match;
import core.entities.Result;
import core.entities.Role;
import core.entities.User;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IUserBuilder {
    public User buildCoreUser();
    public IUserBuilder clearBuilder();
    public IUserBuilder setId(Integer id);
    public IUserBuilder setUsername(String username);
    public IUserBuilder setPassword(String password);
    public IUserBuilder setFullname(String fullname);
    public IUserBuilder setEmail(String email);
    public IUserBuilder setAverageSpeed(Integer averageSpeed);
    public IUserBuilder setBestSpeed(Integer bestSpeed);
    public IUserBuilder setDateRegisted();
    public IUserBuilder setStatus(int status);
    public IUserBuilder setRoles(List<Role> roles);
    public IUserBuilder setResults(List<Result> results);
    public IUserBuilder setMatches(List<Match> matches);
    public IUserBuilder setArticles(List<Article> articles);
}
