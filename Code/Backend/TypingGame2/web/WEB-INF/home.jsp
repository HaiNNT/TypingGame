<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : home.jsp
    Created on : Oct 21, 2014, 10:52:52 AM
    Author     : ThangNT
--%>

<jsp:include page="template/header.jsp"></jsp:include>
    <div id="body">
    <c:if test="${empty sessionScope.user}">
        <section id="authen-section" class="left-section">
            <div class="panel panel-dark-blue">
                <div class="panel-header">
                    <h3>Login</h3>
                    <div style="clear: both;"></div>
                </div>
                <div class="panel-body">
                    <c:set var="mess" value="${sessionScope.message}" />
                    <div id="errorMess" style="color: red"><c:out value="${mess}"/></div>
                    <form id="authen-form" class="form" action="Authentication" method="post">
                        <div id="username-group" class="form-group">
                            <input type="text" name="txtUsername" placeholder="Username">
                        </div>
                        <div id="password-group" class="form-group">
                            <input type="password" name="txtPassword" placeholder="Password">
                        </div>
                        <div id="type-group" class="form-group">
                            <input style="width: 15px; height: 15px;" id="register" type="checkbox"
                                   onclick="chooseRegister()">
                            <label for="register">Don't have account</label>
                            <input type="hidden" value="login" name="action" id="action-type">
                        </div>
                        <div id="register-param" class="hidden">
                            <div id="confirm-password-group" class="form-group">
                                <input type="password" name="txtConfirmPassword" placeholder="Confirm Password">
                            </div>
                            <div id="fullname-group" class="form-group">
                                <input type="text" name="txtFullName" placeholder="Full name">
                            </div>
                            <div id="email-group" class="form-group">
                                <input type="text" name="txtEmail" placeholder="Email">
                            </div>
                        </div>
                        <div id="button-group" class="button-group">
                            <input name ="action" type="submit" class="btn btn-submit" value="login">

                            <div style="clear: both;"></div>
                        </div>
                    </form>
                </div>
                <div class="panel-footer"></div>
            </div>
        </section>
    </c:if>
    <c:choose>
        <c:when test="${empty sessionScope.user}">
            <section id="info-section" class="right-section">
            </c:when>
            <c:otherwise>
                <section id="info-section" class="right-section" style="width: 99%;">
                </c:otherwise>
            </c:choose>

            <div class="panel panel-dark-blue">
                <div class="panel-header">
                    <h3>Top 10 players</h3>
                    <c:if test="${not empty sessionScope.user}">
                        <a id="play-now" href="Game"><div class="btn btn-play">Play Now!</div></a>
                    </c:if>
                    <div style="clear: both;"></div>
                </div>
                <div class="panel-body">
                    <div id="top-speed-player">
                        <h3>Top 10 speed</h3>
                        <table>
                            <thead>
                            <td>No</td>
                            <td>Username</td>
                            <td>Speed</td>
                            </thead>
                            <tbody>
                                <c:set var="count" value="0"/>
                                <c:forEach var="user" items="${requestScope.topSpeed}">
                                    <c:set var="count" value="${count + 1}"/>
                                    <tr class="top-player-item">
                                        <td class="no">${count}</td>
                                        <td class="name">${user.username}</td>
                                        <td class="speed">${user.averageSpeed}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <div id="top-winner-player">
                        <h3>Top 10 winners</h3>
                        <table>
                            <thead>
                            <td>No</td>
                            <td>Username</td>
                            <td>Winner</td>
                            </thead>
                            <tbody>
                                <c:set var="count" value="0"/>
                                <c:forEach var="user" items="${requestScope.topScore}">
                                    <c:set var="count" value="${count + 1}"/>
                                    <tr class="top-player-item">
                                        <td class="no">${count}</td>
                                        <td class="name">${user.username}</td>
                                        <td class="speed">${user.winNum}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div style="clear: both;"></div>
                </div>
                <div class="panel-footer"></div>
            </div>
        </section>
        <div style="clear: both;"></div>

</div>

<jsp:include page="template/footer.jsp"></jsp:include>