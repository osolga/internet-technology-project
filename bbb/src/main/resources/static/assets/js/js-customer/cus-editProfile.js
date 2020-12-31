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



var alert_items = document.querySelectorAll(".alert_item");
var btns = document.querySelectorAll(".btn_saveChange");
var alert_wrapper = document.querySelector(".alert_wrapper");
var close_btns = document.querySelectorAll(".close");

btns.forEach(function(btn, btn_index){
    btn.addEventListener("click", function(){
        alert_wrapper.classList.add("active");

        alert_items.forEach(function(alert_item, alert_index){
            if(btn_index == alert_index){
                alert_item.style.top = "50%";
            }
            else{
                alert_item.style.top = "-100%";
            }
        })
    })
})

close_btns.forEach(function(close, close_index){
    close.addEventListener("click", function(){
        alert_wrapper.classList.remove("active");

        alert_items.forEach(function(alert_item, alert_index){
            alert_item.style.top = "-100%";
        })
    })
})