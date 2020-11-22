var state= false;
function showPassword1()  {
    if(state){
  document.getElementById("inputPassword1").setAttribute("type","password");
  document.getElementById("eye").style.color='#a1045a';
  state = false;
     }
     else{
  document.getElementById("inputPassword1").setAttribute("type","text");
  document.getElementById("eye").style.color= '#4B0082';
  state = true;
     }
}



(function () {
    'use strict'
  
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation')
  
    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
      .forEach(function (form) {
        form.addEventListener('submit', function (event) {
          if (!form.checkValidity()) {
            event.preventDefault()
            event.stopPropagation()
          }
  
          form.classList.add('was-validated')
        }, false)
      })
  })()

  const newPassword = document.getElementById("newPassword");
  const cfPassword = document.getElementById("cfPassword");
  function checkPWDMatch(){
      if(newPassword.value != cfPassword.value ){
          alert("Password does not match");
      }
  }