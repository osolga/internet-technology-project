
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