/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.entities;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import utils.Constant;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tguser")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByFullname", query = "SELECT u FROM User u WHERE u.fullname = :fullname"),
    @NamedQuery(name = "User.findByAverageSpeed", query = "SELECT u FROM User u WHERE u.averageSpeed = :averageSpeed"),
    @NamedQuery(name = "User.findByBestSpeed", query = "SELECT u FROM User u WHERE u.bestSpeed = :bestSpeed"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByRegisterDate", query = "SELECT u FROM User u WHERE u.registerDate = :registerDate"),
    @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status")})
public class User extends core.entities.User {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "Fullname")
    private String fullname;
    @Column(name = "AverageSpeed")
    private Integer averageSpeed;
    @Column(name = "BestSpeed")
    private Integer bestSpeed;
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "RegisterDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    @Basic(optional = false)
    @Column(name = "Status")
    private int status;
    @JoinTable(name = "tguserinrole", joinColumns = {
        @JoinColumn(name = "UserId", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "RoleId", referencedColumnName = "Id")})
    @ManyToMany
    private List<Role> roleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Result> resultList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Match> matchList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Article> articleList;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String password, String fullname, Date registerDate, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.registerDate = registerDate;
        this.status = status;
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
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getFullname() {
        return fullname;
    }

    @Override
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public Integer getAverageSpeed() {
        return averageSpeed;
    }

    /**
     *
     * @param speed
     * @param resultNum
     */
    @Override
    public void setAverageSpeed(int speed, int resultNum) {
        if (averageSpeed == 0) {
            averageSpeed = speed;
        } else {
            averageSpeed = (averageSpeed * resultNum + speed) / (resultNum + 1);
        }
    }

    @Override
    public void setAverageSpeed(Integer averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @Override
    public Integer getBestSpeed() {
        return bestSpeed;
    }

    @Override
    public void setBestSpeed(int bestSpeed) {
        if (this.bestSpeed < bestSpeed) {
            this.bestSpeed = bestSpeed;
        }
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Date getRegisterDate() {
        return registerDate;
    }

    @Override
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ id=" + id + " ]";
    }

    /**
     * Return true if user has role Player
     *
     * @return boolean
     */
    @Override
    public boolean isPlayer() {
        for (Role role : roleList) {
            if (role.getName().equalsIgnoreCase(Constant.ROLE_PLAYER)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return true if user has role admin
     *
     * @return boolean
     */
    @Override
    public boolean isAdmin() {
        for (Role role : roleList) {
            if (role.getName().equalsIgnoreCase(Constant.ROLE_ADMIN)) {
                return true;
            }
        }
        return false;
    }
    
        /**
     * Return true if user is active
     *
     * @return boolean
     */
    @Override
    public boolean isActive() {
        return getStatus() == 1;
    }

    @Override
    public List<core.entities.Role> getCoreRoleList() {
        return (List<core.entities.Role>) (List<?>) roleList;
    }

    @Override
    public void setCoreRoleList(List<core.entities.Role> roleList) {
        this.roleList = (List<Role>) (List<?>) roleList;
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
    public List<core.entities.Match> getCoreMatchList() {
        return (List<core.entities.Match>) (List<?>) matchList;
    }

    @Override
    public void setCoreMatchList(List<core.entities.Match> matchList) {
        this.matchList = (List<Match>) (List<?>) matchList;
    }

    @Override
    public List<core.entities.Article> getCoreArticleList() {
        return (List<core.entities.Article>) (List<?>) articleList;
    }

    @Override
    public void setCoreArticleList(List<core.entities.Article> articleList) {
        this.articleList = (List<Article>) (List<?>) articleList;
    }

    @Override
    public int getWinNum() {
        return winNum;
    }

    @Override
    public void setWinNum(int winNum) {
        this.winNum = winNum;
    }

}
