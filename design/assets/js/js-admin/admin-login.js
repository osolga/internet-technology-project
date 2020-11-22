$(".toggle-password").click(function() {

    $(this).toggleClass("fa-eye fa-eye-slash");
    var input = $($(this).attr("toggle"));
    if (input.attr("type") == "password") {
      input.attr("type", "text");
    } else {
      input.attr("type", "password");
    }
  });


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