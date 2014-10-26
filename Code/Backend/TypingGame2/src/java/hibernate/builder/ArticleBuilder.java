/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.builder;

import core.entities.Article;
import core.entities.Match;
import core.entities.User;
import core.ibuilder.IArticleBuilder;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ArticleBuilder implements core.ibuilder.IArticleBuilder {
    
    private hibernate.entities.Article article = new hibernate.entities.Article();
    
    @Override
    public Article buildCoreArticle() {
        return (Article) article;
    }

    @Override
    public IArticleBuilder setName(String name) {
        article.setName(name);
        return this;
    }

    @Override
    public IArticleBuilder setContent(String content) {
        article.setContent(content);
        return this;
    }

    @Override
    public IArticleBuilder setDateCreated() {
        article.setDateCreated(new Date());
        return this;
    }

    @Override
    public IArticleBuilder setUser(User user) {
        article.setUserId((hibernate.entities.User) user);
        return this;
    }

    @Override
    public IArticleBuilder setMatches(List<Match> matches) {
        article.setMatchList((List<hibernate.entities.Match>)(List<?>) matches);
        return this;
    }

    @Override
    public IArticleBuilder setId(Integer id) {
        article.setId(id);
        return this;
    }

    @Override
    public IArticleBuilder clearBuilder() {
        article = new hibernate.entities.Article();
        return this;
    }
    
    
}
