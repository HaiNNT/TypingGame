<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : header
    Created on : Oct 21, 2014, 2:14:28 PM
    Author     : HaiNNT
--%>
<c:set var="user" value="${sessionScope.user}"></c:set>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="UTF-8">
        <title>Typing Game</title>

        <link href="style/style.css" rel="stylesheet" type="text/css">
        <link href="style/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <header>
            <div id="logo-div">
                <a href="Home">
                    <img id="logo-img" src="image/logo.png">
                </a>
            </div>
            <c:if test="${not empty user}">
                <div id="user-main-div">
                    <c:if test="${ not empty user.matchList}">
                        <i id="user-notification" class="fa fa-globe" onclick="showInvitedMatch()"></i>
                        <ul id="invited-match" class="hidden">
                            <c:forEach var="item" items="${user.matchList}">
                                <%--<c:if test="not empty ${item}">--%>

                                <li class="invited-item">
                                    <a href="Game?action=match&txtMatchId=${item.id}">
                                        <div style="padding: 10px;">

                                            <c:choose>
                                                <c:when test="${item.userId.username == user.username}">
                                                    <span style="color: red; font-size: 15px; font-weight: bold;">You</span>
                                                    not played
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="invited-user">${item.userId.username}</span>
                                                    invited you in
                                                </c:otherwise>
                                            </c:choose>

                                            <span class="invited-article">${item.articleId.name}</span><br><br>
                                            <span class="invited-time">${item.createdDate}</span>
                                        </div>
                                    </a>
                                </li>
                                <%--</c:if>--%>
                            </c:forEach>
                        </c:if>
                    </ul>
                    <div id="user-sub-div">
                        <c:choose>
                            <c:when test="${user.player}">
                                <a id="user-name" href="Profile?action=view">${user.username}</a>
                            </c:when>
                            <c:otherwise>
                                <a id="user-name" href="#">${user.username}</a>
                            </c:otherwise>
                        </c:choose>
                        <i id="user-menu-i" class="fa fa-chevron-down" onclick="showProfileMenu()"></i>
                    </div>
                    <ul id="profile-menu" class="hidden">
                        <c:if test="${user.player}">                       
                            <li class="profile-menu-item">
                                <a href="Profile?action=view">
                                    <div style="padding: 10px;">Profile</div>
                                </a>
                            </li>
                        </c:if>
                        <li class="profile-menu-item">
                            <a href="Authentication?action=logout">
                                <div style="padding: 10px;">Log out</div>
                            </a>
                        </li>
                    </ul>
                </div>
            </c:if>
            <div style="clear: both;"></div>
        </header>
