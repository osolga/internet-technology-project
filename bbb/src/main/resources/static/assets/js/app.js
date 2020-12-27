serviceEndpointURL = window.location.protocol + "//" + window.location.host;

//Admin login
function loginAdmin(username, password, remember, callback) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/login",
        data: JSON.stringify({
            "username": username,
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

//validate admin login after update the Profile
function validateAdminLogin(callback) {
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


//Admin Register
function registerAdmin(username, email, password, callbackSuccess, callbackError) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/user/register",
        data: JSON.stringify({
            "name": username,
            "email": email,
            "password": password
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



//after Admin edit or update profile
function getAdminProfile(callback) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: serviceEndpointURL + "/profile",
        success: function (data, textStatus, response) {
            callback(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
        }
    });
}

//after Admin edit or update profile
function putAdminProfile(username, email, password, callbackSuccess, callbackError) {
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/profile",
        data: JSON.stringify({
            "name": username,
            "email": email,
            "password": password
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

//Customer login
function loginCustomer(email, password, remember, callback) {
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


//Customer register
function registerCustomer(username, firstname, lastname, email, tel, password, callbackSuccess, callbackError){
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/user/register",
        data: JSON.stringify({
            "name": username,
            "firstname": firstname,
            "lastname": lastname,
            "email": email,
            "tel": tel,
            "password": password
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


//validate Customer login after update the Profile
function validateCusLogin(callback) {
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

//after Customer edit or update profile
function getCusProfile(callback) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: serviceEndpointURL + "/profile",
        success: function (data, textStatus, response) {
            callback(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
        }
    });
}

//after Customer edit or update profile
function putCusProfile(firstname, lastname, email, tel, newPassword, callbackSuccess, callbackError) {
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/profile",
        data: JSON.stringify({
            "firstname": firstname,
            "lastname" : lastname,
            "email": email,
            "tel" : tel,
            "newPassword": newPassword
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


//Reservation register
// QUESTION: Where to add bar table, customers can not choose it, how would they know which table to choose?

function postReseravation(firstName, lastName, email, phone, guests, date, time, callbackSuccess, callbackError) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "",

        data: JSON.stringify({
            "firstName": firstName,
            "lastName": lastName,
            "email": email,
            "phone": phone,
            "guests": guests,
            "date": date,
            "time": time

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

// QUESTION: how to get reservation? where to store reservationID? How to assign an ID to reservation?

// function getReservation(reservationID, callback) {
//     $.ajax({
//         type: "GET",
//         dataType: "json",
//         url: serviceEndpointURL + "" + reservationID,
//         success: function (data, textStatus, response) {
//             callback(data);
//         },
//         error: function (jqXHR, textStatus, errorThrown) {
//             console.log(jqXHR, textStatus, errorThrown);
//         }
//     });
// }

function getReservation(callback) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: serviceEndpointURL + "",
        success: function (data, textStatus, response) {
            callback(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
        }
    });
}

function putReservation(firstName, lastName, email, phone, guests, date, time, callbackSuccess, callbackError) {
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "",
        
        data: JSON.stringify({
            "firstName": firstName,
            "lastName": lastName,
            "email": email,
            "phone": phone,
            "guests": guests,
            "date": date,
            "time": time

        }),

        success: function (data, textStatus, response) {
            callbackSuccess(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callbackError(jqXHR.responseJSON.message);
        }
    });
}

// QUESTION: how to delete reservation? where to store reservationID? How to assign an ID to reservation?

// function deleteReservation(reservationID, callback) {
//     $.ajax({
//         type: "DELETE",
//         headers: {
//             "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
//         },
//         url: serviceEndpointURL + "/api/reservation/" + reservationID,
//         success: function (data, textStatus, response) {
//             callback(data);
//         },
//         error: function (jqXHR, textStatus, errorThrown) {
//             console.log(jqXHR, textStatus, errorThrown);
//         }
//     });
// }

function getReservationJSON(firstName, lastName, email, phone, guests, date, time) {
    if (id === null) {
        return JSON.stringify({
            "firstName": firstName,
            "lastName": lastName,
            "email": email,
            "phone": phone,
            "guests": guests,
            "date": date,
            "time": time

        });
    }
    return JSON.stringify({
        "firstName": firstName,
        "lastName": lastName,
        "email": email,
        "phone": phone,
        "guests": guests,
        "date": date,
        "time": time

    });
}



function getURLParameter(name) {
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [, ""])[1].replace(/\+/g, '%20')) || null;
}

function getCookie(name) {
    var match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
    if (match) return match[2];
}
