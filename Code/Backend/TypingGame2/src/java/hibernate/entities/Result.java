/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tgresult")
@NamedQueries({
    @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r"),
    @NamedQuery(name = "Result.findByRate", query = "SELECT r FROM Result r WHERE r.rate = :rate"),
    @NamedQuery(name = "Result.findBySpeed", query = "SELECT r FROM Result r WHERE r.speed = :speed"),
    @NamedQuery(name = "Result.findById", query = "SELECT r FROM Result r WHERE r.id = :id")})
public class Result extends core.entities.Result {

    private static final long serialVersionUID = 1L;
    @Column(name = "Rate")
    private Integer rate;
    @Basic(optional = false)
    @Column(name = "Speed")
    private int speed;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @JoinColumn(name = "MatchId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Match matchId;
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User userId;

    public Result() {
    }

    public Result(Integer id) {
        this.id = id;
    }

    public Result(Integer id, int speed) {
        this.id = id;
        this.speed = speed;
    }

    @Override
    public Integer getRate() {
        return rate;
    }

    @Override
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Match getMatchId() {
        return matchId;
    }

    public void setMatchId(Match matchId) {
        this.matchId = matchId;
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
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Result[ id=" + id + " ]";
    }

    public void setResult(Result result) {
        this.rate = result.getRate();
        this.speed = result.getSpeed();
    }

    @Override
    public core.entities.Match getCoreMatchId() {
        return (core.entities.Match) matchId;
    }

    @Override
    public void setCoreMatchId(core.entities.Match matchId) {
        this.matchId = (Match) matchId;
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
    public void setCoreResult(core.entities.Result result) {
        this.rate = result.getRate();
        this.speed = result.getSpeed();
    }

}
