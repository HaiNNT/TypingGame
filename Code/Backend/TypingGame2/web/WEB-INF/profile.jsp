<%-- 
    Document   : profile
    Created on : Oct 21, 2014, 10:53:04 AM
    Author     : MinhHV
--%>
<%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"></jsp:include>
<a:set var="update" value="${requestScope.user}"/>
<div id="body">
    <section id="profile-section" class="left-section">
        <div class="panel panel-dark-blue">
            <div class="panel-header">
                <h3>
                    Profile
                </h3>
                <i id="edit-profile-i" class="fa fa-edit" onclick="editProfile()"></i>
                <div style="clear: both;"></div>
            </div>
            <div class="panel-body">
                <form id="profile-form" class="form hidden" action="Profile" method="post">
                    <a:if test="${not empty requestScope.message}">
                        <div style="color: red;">${requestScope.message}</div>
                    </a:if>
                    <div id="fullname-group" class="form-group">
                        <input type="text" name="txtFullname" value="${update.fullname}" placeholder="${update.fullname}">     
                    </div>
                    <div id="email-group" class="form-group">
                        <input type="text" name="txtEmail" value="${update.email}" placeholder="${update.email}">
                    </div>
                    <div id="password-group" class="form-group">
                        <input type="password" name="txtPassword" placeholder="Current Password">
                    </div>
                    <div id="new-password-group" class="form-group">
                        <input type="password" name="txtNewPassword" placeholder="New Password">
                    </div>
                    <div id="confirm-password-group" class="form-group">
                        <input type="password" name="txtConfirm" placeholder="Confirm New Password">
                    </div>
                    <div id="button-group" class="button-group">
                        <input type="hidden" name="action" value="edit">
                        <input type="button" class="btn btn-cancel" value="Cancel" onclick="cancelEditProfile()">
                        <input type="submit" class="btn btn-submit" value="Save">
                        <div style="clear: both;"></div>
                    </div>
                </form>
                <div id="profile-info">

                    <div><label>Full Name:</label><span>${update.fullname}</span></div>
                    <div><label>Email:</label><span>${update.email}</span></div>
                    <div><label>Rank:</label><span>${requestScope.rate}</span></div>
                    <div><label>Win/Lose:</label><span>${requestScope.matchWin}/${requestScope.matchLoose}</span></div>
                    <div><label>Average Speed:</label><span>${update.averageSpeed}</span></div>
                    <div><label>Best Speed:</label><span>${update.bestSpeed}</span></div>
                    <div><label>Registered Date:</label><span>${update.registerDate}</span></div>
                </div>
            </div>
            <div class="panel-footer"></div>
        </div>
    </section>
    <section id="recent-matches-section" class="right-section">
        <div class="panel panel-dark-blue">
            <div class="panel-header">
                <h3>Recent Matches</h3>
                <div style="clear: both;"></div>
            </div>
            <div class="panel-body">
                <div id="recent-matches">                              
                    <a:forEach items="${listRecentMatch}" var="item">    
                        <div class="item">
                            <span class="time"><a:out value="${item.createdDate}" /></span><a:choose>
                                <a:when test="${item.resultList[1].userId.username == sessionScope.user.username}">
                                    <span class="competitor"><a:out value="${item.resultList[0].userId.username}" /></span>
                                </a:when>
                                <a:otherwise>
                                    <span class="competitor"><a:out value="${item.resultList[1].userId.username}" /></span>
                                </a:otherwise>
                            </a:choose>
                            <span class="name"><a:out value="${item.articleId.name}" /></span>
                        </div>   
                    </a:forEach>
                </div>
            </div>
            <div class="panel-footer"></div>
        </div>
    </section>
    <div style="clear: both;"></div>
</div>

<jsp:include page="template/footer.jsp"></jsp:include>