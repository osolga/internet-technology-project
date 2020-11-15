/*
 * This is function to repose information required 
 * at Sign-up page
 */

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

  const password = document.getElementById("password");
  const password02 = document.getElementById("password02");
  function checkPWDMatch(){
      if(password.value != password02.value ){
          alert("Password does not match");
      }
  }