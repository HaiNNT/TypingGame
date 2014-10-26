<%-- 
    Document   : admin
    Created on : Oct 21, 2014, 10:53:27 AM
    Author     : Administrator
--%>
<jsp:include page="template/header.jsp" ></jsp:include>
<div id="body">
    <section id="manage-user-section" class="left-section">
        <div class="panel panel-dark-blue">
            <div class="panel-header"><h3>Manage User</h3></div>
            <div class="panel-body">
                <form id="manage-user-form" class="form" action="admin" method="post">
                    <div id="search-user-div" class="form-group">
                        <i id="search-user-i" class="fa fa-search search-i"></i>
                        <input type="text" name="txtUsername" placeholder="Username">
                        <input type="hidden" name="action" value="search">
                        <input type="hidden" name="txtType" value="user">
                    </div>
                    <ul id="recent-users">
                        <h4>Recent Registered Users</h4>
                        <li><span>21/10/2014</span><label>MinhHV</label><a href="#"><i class="fa"></i></a></li>
                        <li><span>21/10/2014</span><label>MinhHV</label><a href="#"><i class="fa"></i></a></li>
                        <li><span>21/10/2014</span><label>MinhHV</label><a href="#"><i class="fa"></i></a></li>
                        <li><span>21/10/2014</span><label>MinhHV</label><a href="#"><i class="fa"></i></a></li>
                        <li><span>21/10/2014</span><label>MinhHV</label><a href="#"><i class="fa"></i></a></li>
                    </ul>
                    <ul id="result-users" class="hidden">
                        <h4>Result</h4>
                        <li><span>21/10/2014</span><label>MinhHV</label><a href="#"><i class="fa"></i></a></li>
                        <li><span>21/10/2014</span><label>MinhHV</label><a href="#"><i class="fa"></i></a></li>
                        <li><span>21/10/2014</span><label>MinhHV</label><a href="#"><i class="fa"></i></a></li>
                        <li><span>21/10/2014</span><label>MinhHV</label><a href="#"><i class="fa"></i></a></li>
                        <li><span>21/10/2014</span><label>MinhHV</label><a href="#"><i class="fa"></i></a></li>
                    </ul>
                </form>
            </div>
            <div class="pannel-footer"></div>
            </div>
    </section>

    <section id="manage-article-section" class="right-section">
        <div class="panel panel-dark-blue">
            <div class="panel-header"><h3>Manage Article</h3></div>
            <div class="panel-body">
                <form id="manage-article-form" class="form" action="admin" method="post">
                    <div id="search-article-div" class="form-group">
                        <i id="search-article-i" class="fa fa-search search-i"></i>
                        <input type="text" name="txtUsername" placeholder="Article name">
                        <input type="hidden" name="action" value="search">
                        <input type="hidden" name="txtType" value="article">
                    </div>
                    <div class="form-group">
                        <div style="font-weight: bold;">Content</div>
                        <textarea id="article-content" rows="10"></textarea>
                    </div>
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