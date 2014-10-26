/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.ibuilder;

import core.entities.Article;
import core.entities.Match;
import core.entities.Result;
import core.entities.User;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IMatchBuilder {
    
    public Match buildCoreMatch();
    public IMatchBuilder clearBuilder();
    public IMatchBuilder setId(Integer id);
    public IMatchBuilder setMode(String mode);
    public IMatchBuilder setDateCreated();
    public IMatchBuilder setResults(List<Result> results);
    public IMatchBuilder setUser(User user);
    public IMatchBuilder setArticle(Article article);
    
}
