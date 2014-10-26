/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.builder;

import core.entities.Article;
import core.entities.Match;
import core.entities.Result;
import core.entities.Role;
import core.entities.User;
import core.ibuilder.IUserBuilder;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class UserBuilder implements core.ibuilder.IUserBuilder {

    private hibernate.entities.User user = new hibernate.entities.User();

    @Override
    public User buildCoreUser() {
        return (User) user;
    }

    @Override
    public IUserBuilder setUsername(String username) {
        user.setUsername(username);
        return this;
    }

    @Override
    public IUserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }

    @Override
    public IUserBuilder setFullname(String fullname) {
        user.setFullname(fullname);
        return this;
    }

    @Override
    public IUserBuilder setEmail(String email) {
        user.setEmail(email);
        return this;
    }

    @Override
    public IUserBuilder setAverageSpeed(Integer averageSpeed) {
        user.setAverageSpeed(averageSpeed);
        return this;
    }

    @Override
    public IUserBuilder setBestSpeed(Integer bestSpeed) {
        user.setBestSpeed(bestSpeed);
        return this;
    }

    @Override
    public IUserBuilder setDateRegisted() {
        user.setRegisterDate(new Date());
        return this;
    }

    @Override
    public IUserBuilder setStatus(int status) {
        user.setStatus(status);
        return this;
    }

    @Override
    public IUserBuilder setRoles(List<Role> roles) {
        user.setRoleList((List<hibernate.entities.Role>) (List<?>) roles);
        return this;
    }

    @Override
    public IUserBuilder setResults(List<Result> results) {
        user.setResultList((List<hibernate.entities.Result>) (List<?>) results);
        return this;
    }

    @Override
    public IUserBuilder setMatches(List<Match> matches) {
        user.setMatchList((List<hibernate.entities.Match>) (List<?>) matches);
        return this;
    }

    @Override
    public IUserBuilder setArticles(List<Article> articles) {
        user.setArticleList((List<hibernate.entities.Article>) (List<?>) articles);
        return this;
    }

    @Override
    public IUserBuilder setId(Integer id) {
        user.setId(id);
        return this;
    }

    @Override
    public IUserBuilder clearBuilder() {
        user = new hibernate.entities.User();
        return this;
    }

}
