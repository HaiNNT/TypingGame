/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tgmatch")
@NamedQueries({
    @NamedQuery(name = "Match.findAll", query = "SELECT m FROM Match m"),
    @NamedQuery(name = "Match.findById", query = "SELECT m FROM Match m WHERE m.id = :id"),
    @NamedQuery(name = "Match.findByMode", query = "SELECT m FROM Match m WHERE m.mode = :mode"),
    @NamedQuery(name = "Match.findByCreatedDate", query = "SELECT m FROM Match m WHERE m.createdDate = :createdDate")})
public class Match extends core.entities.Match{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Mode")
    private String mode;
    @Basic(optional = false)
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matchId")
    private List<Result> resultList;
    @JoinColumn(name = "ArticleId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Article articleId;
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User userId;

    public Match() {
    }

    public Match(Integer id) {
        this.id = id;
    }

    public Match(Integer id, String mode, Date createdDate) {
        this.id = id;
        this.mode = mode;
        this.createdDate = createdDate;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getMode() {
        return mode;
    }

    @Override
    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public Article getArticleId() {
        return articleId;
    }

    public void setArticleId(Article articleId) {
        this.articleId = articleId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Match)) {
            return false;
        }
        Match other = (Match) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Match[ id=" + id + " ]";
    }

    @Override
    public void updateResults() {
        boolean check = true;
        for (Result result : resultList) {
            if (result.getSpeed() < 0) {
                check = false;
            }
        }
        if (check) {
            Collections.sort(resultList, new Comparator<Result>() {
                @Override
                public int compare(Result result1, Result result2) {
                    return ((Integer) (result1.getSpeed())).compareTo(result2.getSpeed());
                }
            });
            int i = resultList.size();
            for (Result result : resultList) {
                result.setRate(i--);
            }
        }
    }

    public Result getCompetitorResult() {
        for (Result result : resultList) {
            if (!result.getUserId().equals(userId)) {
                return result;
            }
        }
        return null;
    }

    public Result getCreaterResult() {
        for (Result result : resultList) {
            if (result.getUserId().equals(userId)) {
                return result;
            }
        }
        return null;
    }

    public void addResult(Result result) {
        if (resultList == null) {
            List<Result> list = new ArrayList<Result>();
            list.add(result);
            this.resultList = list;
        } else {
            this.resultList.add(result);
        }
    }

    public boolean isPlayedMatch() {
        for (Result result : resultList) {
            if (null == result.getRate()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<core.entities.Result> getCoreResultList() {
        return (List<core.entities.Result>) (List<?>) resultList;
    }

    @Override
    public void setCoreResultList(List<core.entities.Result> resultList) {
        this.resultList = (List<Result>) (List<?>) resultList;
    }

    @Override
    public core.entities.Article getCoreArticleId() {
        return (core.entities.Article) articleId;
    }

    @Override
    public void setCoreArticleId(core.entities.Article articleId) {
        this.articleId = (Article) articleId;
    }

    @Override
    public core.entities.User getCoreUserId() {
        return (core.entities.User) userId;
    }

    @Override
    public void setCoreUserId(core.entities.User userId) {
        this.userId = (User) userId;
    }

    @Override
    public core.entities.Result getCoreCompetitorResult(String username) {
        for (Result result : resultList) {
            if (!result.getUserId().getUsername().equals(username)) {
                return (core.entities.Result) result;
            }
        }
        return null;
    }

    @Override
    public core.entities.Result getCoreCreaterResult() {
        for (Result result : resultList) {
            if (result.getUserId().equals(userId)) {
                return (core.entities.Result) result;
            }
        }
        return null;
    }

    @Override
    public void addCoreResult(core.entities.Result result) {
               if (resultList == null) {
            List<Result> list = new ArrayList<Result>();
            list.add((Result)result);
            this.resultList = list;
        } else {
            this.resultList.add((Result)result);
        }
    }
}
