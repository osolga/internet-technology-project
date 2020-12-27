$(document).ready(function () {
    $("#form").submit(function (event) {
        registerAdmin($('input[name=username]').val(), $('input[name=email]').val(), $('input[name=password]').val(), $('input[name=confirmPassword]').val(), function (result) {
            window.location.replace("../");
        }, function (error) {
            $("#error-modal").modal('show');
            $("#error-text").text(error);
        });
        event.preventDefault();
    });
});






serviceEndpointURL = window.location.protocol + "//" + window.location.host;




function registerAdmin(username, email, password, callbackSuccess, callbackError) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/admin/register",
        data: JSON.stringify({
            "username": username,
            "email": email,
            "password": password,
            "confirmPassword" : confirmPassword,
        }),
        success: function (data, textStatus, response) {
            callbackSuccess(true);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callbackError(jqXHR.responseJSON.message);
        }
    });
}




/*
Show input password
*/

var state= false;
function showPassword(){
    if(state){
        document.getElementById("inputPassword").setAttribute("type","password");
        document.getElementById("eye").style.color='#a1045a';
        state = false;
    }
    else{
        document.getElementById("inputPassword").setAttribute("type","text");
        document.getElementById("eye").style.color= '#4B0082';
        state = true;
    }
}


var state= false;
function showPassword02(){
    if(state){
        document.getElementById("inputRepeatPassword").setAttribute("type","password");
        document.getElementById("eye02").style.color='#a1045a';
        state = false;
    }
    else{
        document.getElementById("inputRepeatPassword").setAttribute("type","text");
        document.getElementById("eye02").style.color= '#4B0082';
        state = true;
    }
}


function Validate() {
    var password = document.getElementById("inputPassword").value;
    var confirmPassword = document.getElementById("inputRepeatPassword").value;
    if (password != confirmPassword) {
        alert("Passwords do not match.");
        return false;
    }
    return true;
}



/*
$(function () {
    $("#btnSubmit").click(function () {
        var password = $("#inputPassword").val();
        var confirmPassword = $("#inputRepeatPassword").val();
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    });
});

 */