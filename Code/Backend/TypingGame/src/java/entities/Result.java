/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tgresult")
@NamedQueries({
    @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r"),
    @NamedQuery(name = "Result.findById", query = "SELECT r FROM Result r WHERE r.id = :id"),
    @NamedQuery(name = "Result.findByRate", query = "SELECT r FROM Result r WHERE r.rate = :rate"),
    @NamedQuery(name = "Result.findBySpeed", query = "SELECT r FROM Result r WHERE r.speed = :speed")})
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Rate")
    private int rate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Speed")
    private int speed;
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

    public Result(Integer id, int rate, int speed) {
        this.id = id;
        this.rate = rate;
        this.speed = speed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
    
}
