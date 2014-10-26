/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.builder;

import core.entities.Article;
import core.entities.Match;
import core.entities.Result;
import core.entities.User;
import core.ibuilder.IMatchBuilder;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class MatchBuilder implements core.ibuilder.IMatchBuilder {
    
    private hibernate.entities.Match match = new hibernate.entities.Match();
    
    @Override
    public Match buildCoreMatch() {
        return (Match) match;
    }

    @Override
    public IMatchBuilder setMode(String mode) {
        match.setMode(mode);
        return this;
    }

    @Override
    public IMatchBuilder setDateCreated() {
        match.setCreatedDate(new Date());
        return this;
    }

    @Override
    public IMatchBuilder setResults(List<Result> results) {
        match.setResultList((List<hibernate.entities.Result>)(List<?>)results);
        return this;
    }

    @Override
    public IMatchBuilder setUser(User user) {
        match.setUserId((hibernate.entities.User) user);
        return this;
    }

    @Override
    public IMatchBuilder setArticle(Article article) {
        match.setArticleId((hibernate.entities.Article) article);
        return this;
    }

    @Override
    public IMatchBuilder setId(Integer id) {
        match.setId(id);
        return this;
    }

    @Override
    public IMatchBuilder clearBuilder() {
        match = new hibernate.entities.Match();
        return this;
    }
    
}
