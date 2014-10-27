/**
 * Created by HaiNNT on 10/19/2014.
 */

/*
Show invited matches in notification at home page
 */
function showInvitedMatch(){
    var list = $("#invited-match");
    if(list.hasClass("hidden")){
        list.removeClass("hidden");
    }else{
        list.addClass("hidden");
    }
    var icon = $("#user-notification");
    if(icon.hasClass("user-notification-click")){
        icon.removeClass("user-notification-click");
    }else{
        icon.addClass("user-notification-click");
    }
}

/*
 Show profile menu at home page
 */
function showProfileMenu(){
    var list = $("#profile-menu");
    if(list.hasClass("hidden")){
        list.removeClass("hidden");
    }else{
        list.addClass("hidden");
    }
    var icon = $("#user-menu-i");
    if(icon.hasClass("user-notification-click")){
        icon.removeClass("user-notification-click");
    }else{
        icon.addClass("user-notification-click");
    }
}

/*
Switch between register mode and login mode at home page
 */
function chooseRegister(){
    var register = $("#register");
    if(register.prop('checked') == true){
        $("#authen-section .panel-header h3").text("Register");
        $("#button-group input").val("Register");
        $("#register-param").removeClass("hidden");
        $("#action-type").val("register");
    }else{
        $("#authen-section .panel-header h3").text("Login");
        $("#button-group input").val("Login");
        $("#register-param").addClass("hidden");
        $("#action-type").val("login");
    }
}

/*
Enable edit profile at profile page
 */
function editProfile(){
    $("#profile-info").addClass("hidden");
    $("#profile-form").removeClass("hidden");
}

/*
Cancel edit profile at profile page
 */
function cancelEditProfile(){
    $("#profile-info").removeClass("hidden");
    $("#profile-form").addClass("hidden");
}

/*
 * Submit a form with form id
 */
function submitFrom(id){
    $(id).submit();   
}

