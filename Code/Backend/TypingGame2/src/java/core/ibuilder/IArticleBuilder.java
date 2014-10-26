/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.ibuilder;

import core.entities.User;
import core.entities.Article;
import core.entities.Match;
import java.util.List;
/**
 *
 * @author Administrator
 */
public interface IArticleBuilder {
    public Article buildCoreArticle();
    public IArticleBuilder clearBuilder();
    public IArticleBuilder setId(Integer id);
    public IArticleBuilder setName(String name);
    public IArticleBuilder setContent(String content);
    public IArticleBuilder setDateCreated();
    public IArticleBuilder setUser(User user);
    public IArticleBuilder setMatches(List<Match> matches);
}
