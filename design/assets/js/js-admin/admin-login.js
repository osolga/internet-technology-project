$(document).ready(function () {
    $("#form").submit(function (event) {
        login($('input[name=username]').val(), $('input[name=password]').val(), $('input[name=remember]').is(":checked"), function (result) {
            if(result) {
                window.location.replace("../");
            }
            else {
                $("#error-modal").modal('show');
                $("#error-text").text("Bad credentials!");
            }
        });
        event.preventDefault();
    });
});


validateLogin(function (result) {
    if (!result) {
        window.location.replace("../login");
    }
});



serviceEndpointURL = window.location.protocol + "//" + window.location.host;

function login(email, password, remember, callback) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/login",
        data: JSON.stringify({
            "email": email,
            "password": password,
            "remember": remember
        }),
        success: function (data, textStatus, response) {
            callback(true);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callback(false);
        }
    });
}

function getCookie(name) {
    var match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
    if (match) return match[2];
}


function validateLogin(callback) {
    $.ajax({
        type: "HEAD",
        url: serviceEndpointURL + "/validate",
        success: function (data, textStatus, response) {
            callback(true);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            callback(false);
        }
    });
}




