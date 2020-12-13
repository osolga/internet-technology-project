/*
Show input password
*/

var state= false;
  function showPassword(){
      if(state){
    document.getElementById("password").setAttribute("type","password");
    document.getElementById("eye").style.color='#a1045a';
    state = false;
       }
       else{
    document.getElementById("password").setAttribute("type","text");
    document.getElementById("eye").style.color= '#4B0082';
    state = true;
       }
  }


  var state= false;
  function showPassword02(){
      if(state){
    document.getElementById("password02").setAttribute("type","password");
    document.getElementById("eye02").style.color='#a1045a';
    state = false;
       }
       else{
    document.getElementById("password02").setAttribute("type","text");
    document.getElementById("eye02").style.color= '#4B0082';
    state = true;
       }
  }
