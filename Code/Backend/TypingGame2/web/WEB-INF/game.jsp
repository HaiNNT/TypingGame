<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : game
    Created on : Oct 21, 2014, 10:53:35 AM
    Author     : HaiNNT
--%>
<jsp:include page="template/header.jsp" ></jsp:include>
    <div id="body">
        <section id="game-section">
            <div class="panel panel-dark-blue">
                <div class="panel-header">
                    <h3>Game</h3>
                    <div style="clear: both;"></div>
                </div>
                <div class="panel-body">
                    <form id="game-form" class="form" action="Game" method="post">
                        <div id="you-progress" class="form-group">
                            <label>You</label>
                            <progress value="0" max="100"></progress>
                            <div style="clear: both;"></div>
                        </div>
                        <div id="competitor-progress" class="form-group">

                        <c:choose>
                            <c:when test="${not empty requestScope.match}">
                                <label id="competitor-name">${requestScope.comResult.userId.username}<c:if test="${requestScope.comResult.speed != '-1'}">
                                    - ${requestScope.comResult.speed}</c:if></label>
                            </c:when>
                            <c:otherwise>
                                <input type="text" name="txtUsername" placeholder="Competitor">
                            </c:otherwise>
                        </c:choose>

                        <progress value="0" max="100"></progress>
                        <div style="clear: both;"></div>
                    </div>
                    <div class="form-group">
                        <div id="game-article-content">
                            
                            <c:if test="${not empty requestScope.match}">
                                <div id="article-content-div" class="hidden">
                                    <span id="checked-paragraph"></span>
                                    <span id="unChecked-paragraph">${requestScope.match.articleId.content}</span>
                                </div>
                            </c:if>

                            <c:choose>
                                <c:when test="${not empty requestScope.match}">
                                    <div id="count-down">Click "Play" and wait 3 seconds to play.</div>
                                </c:when>
                                <c:otherwise>
                                    <div id="help">Click "Begin" to begin game and invite competitor.</div>
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </div>
                    <div class="button-group">

                        <c:choose>
                            <c:when test="${not empty requestScope.match}">
                                <input id="input-text" type="text" style="float: left; margin-left: 20px; padding: 5px;" placeholder="You type here">
                                <input id="play-button" type="button" value="Play" class="btn btn-submit" onclick="startGame()">
                                <input id="quit-button" type="button" value="Quit" class="btn btn-cancel" onClick="sendResult()">
                                <a id="new-match" href="Game?action=view" class="btn btn-submit hidden">New Game</a>
                            </c:when>
                            <c:otherwise>
                                <input type="hidden" name="action" value="create-match">
                                <input id="begin-button" type="submit" value="Begin" class="btn btn-submit">
                            </c:otherwise>
                        </c:choose>

                        <div style="clear: both;"></div>
                    </div>

                    <c:if test="${not empty requestScope.match}">
                        <div id="hidden-param">
                            <span id="competitor-speed" class="hidden">${requestScope.comResult.speed}</span>
                            <input id="speed" type="hidden" name="txtSpeed" value="0">
                            <input id="matchId" type="hidden" name="txtMatchId" value="${requestScope.match.id}">
                        </div>
                    </c:if>

                </form>
            </div>
            <div class="panel-footer"></div>
        </div>
    </section>
</div>
<jsp:include page="template/footer.jsp" ></jsp:include>