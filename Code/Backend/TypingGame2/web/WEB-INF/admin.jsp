
<%-- 
    Document   : admin
    Created on : Oct 21, 2014, 10:53:27 AM
    Author     : Administrator
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="template/header.jsp" ></jsp:include>
    <div id="body">
        <section id="manage-user-section" class="left-section">
            <div class="panel panel-dark-blue">
                <div class="panel-header">
                    <h3>Manage User</h3>
                    <div style="clear: both;"></div>
                </div>
                <div class="panel-body">
                    <form id="manage-user-form" class="form" action="Admin" method="post">
                        <div id="search-user-div" class="form-group">
                            <i  id="search-user-i" class="fa fa-search search-i" onclick="submitFrom('#manage-user-form')"></i>
                            <input type="hidden" name="action" value="search-user">
                            <input type="text" name="txtUsername" placeholder="Username">
                        </div>
                    <c:choose>
                        <c:when test="${not empty sessionScope.resultUsers}">

                            <ul id="result-users">
                                <h4>Result</h4>
                                <c:forEach var="user" items="${sessionScope.resultUsers}">
                                    <c:choose>
                                        <c:when test="${user.active}">
                                            <li>
                                                <span>${fn:substring(user.registerDate,0,10)}</span>
                                                <label>${user.username}</label>
                                                <a href="Admin?action=update-user&txtUserId=${user.id}&txtActive=false">
                                                    <i class="fa fa-check"></i>
                                                </a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li>
                                                <span>${fn:substring(user.registerDate,0,10)}</span>
                                                <label>${user.username}</label>
                                                <a href="Admin?action=update-user&txtUserId=${user.id}&txtActive=true">
                                                    <i class="fa fa-ban"></i>
                                                </a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <ul id="recent-users">
                                <h4>Recent Registered Users</h4>

                                <c:forEach var="user" items="${sessionScope.users}">
                                    <c:choose>
                                        <c:when test="${user.active}">
                                            <li>
                                                <span>${fn:substring(user.registerDate,0,10)}</span>
                                                <label>${user.username}</label>
                                                <a href="Admin?action=update-user&txtUserId=${user.id}&txtActive=false">
                                                    <i class="fa fa-check"></i>
                                                </a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li>
                                                <span>${fn:substring(user.registerDate,0,10)}</span>
                                                <label>${user.username}</label>
                                                <a href="Admin?action=update-user&txtUserId=${user.id}&txtActive=true">
                                                    <i class="fa fa-ban"></i>
                                                </a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </ul>
                        </c:otherwise>
                    </c:choose>
                </form>
            </div>
            <div class="pannel-footer"></div>
        </div>
    </section>

    <section id="manage-article-section" class="right-section">
        <div class="panel panel-dark-blue">
            <div class="panel-header">
                <h3>Manage Article</h3>
                <div style="clear: both;"></div>
            </div>
            <div class="panel-body">
                <form id="search-article-form" class="form" action="Admin" method="post">
                    <div id="search-article-div" class="form-group">
                        <i  id="search-user-i" class="fa fa-search search-i" onclick="submitFrom('#search-article-form')"></i>
                        <input type="hidden" name="action" value="search">
                        <input type="text" name="txtName" placeholder="Search Article Name">
                    </div>
                </form>
                <form id="manage-article-form" class="form" action="Admin" method="post">
                    <div class="form-group">

                        <c:choose>
                            <c:when test="${not empty requestScope.article}">
                                <div style="font-weight: bold;">${requestScope.article.name}</div>
                                <input type="hidden" value="update" name="action">
                                <input type="hidden" value="${requestScope.article.id}" name="txtId" />
                                <textarea id="article-content" rows="10" name="txtContent">${requestScope.article.content}</textarea>
                            </c:when>
                            <c:otherwise>
                                <input type="text" name="txtName" placeholder="Article Name" />
                                <input type="hidden" name="action" value="create" />
                                <textarea id="article-content" rows="10" name="txtContent"></textarea>
                            </c:otherwise>
                        </c:choose>

                    </div>

                    <c:if test="${not empty sessionScope.articles}">

                        <div class="form-group">
                            <ul>
                                <c:forEach var="article" items="${sessionScope.articles}">
                                    <li>
                                        <a href="Admin?action=get-article&txtId=${article.id}">
                                            <span>${article.dateCreated}</span>
                                            <label>${article.name}</label>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>

                    <div class="button-group">
                        <input type="submit" value="Save" class="btn btn-submit">
                        <div style="clear: both;"></div>
                    </div>
                </form>
            </div>
            <div class="panel-footer"></div>
        </div>
    </section>
    <div style="clear: both;"></div>
</div>
<jsp:include page="template/footer.jsp" ></jsp:include>