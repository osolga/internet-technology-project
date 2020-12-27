/*
Show input password
*/

var state= false;
function showCurrentPassword(){
    if(state){
        document.getElementById("inputCurrentPassword").setAttribute("type","password");
        document.getElementById("eye1").style.color='#a1045a';
        state = false;
    }
    else{
        document.getElementById("inputCurrentPassword").setAttribute("type","text");
        document.getElementById("eye1").style.color= '#4B0082';
        state = true;
    }
}


var state= false;
function showNewPassword01(){
    if(state){
        document.getElementById("inputNewPassword").setAttribute("type","password");
        document.getElementById("eye2").style.color='#a1045a';
        state = false;
    }
    else{
        document.getElementById("inputNewPassword").setAttribute("type","text");
        document.getElementById("eye2").style.color= '#4B0082';
        state = true;
    }
}


var state= false;
function showNewPassword02(){
    if(state){
        document.getElementById("inputCFPassword").setAttribute("type","password");
        document.getElementById("eye3").style.color='#a1045a';
        state = false;
    }
    else{
        document.getElementById("inputCFPassword").setAttribute("type","text");
        document.getElementById("eye3").style.color= '#4B0082';
        state = true;
    }
}





function Validate() {
    var password = document.getElementById("inputNewPassword").value;
    var confirmPassword = document.getElementById("inputCFPassword").value;
    if (password != confirmPassword) {
        alert("Passwords do not match.");
        return false;
    }
    return true;
}