    /*Extend menu bar by jquery*/

$(document).ready(function(){
    
    const $menuRqst = $('#menubtn');
    const $menuinfo = $('#detailmenu');
    
    

   

    function completeFunction(responseText, textStatus, request){
        $menuinfo.css('boder', '1px solid #e8e8e8');

        if(textStatus == 'error'){
            $menuinfo.text('An error occured during your request: ' + request.status + ' ' + request.statusText)
        }
    }

    
    $menuRqst.on('click', function(){
        $menuinfo.load('menu.html div#menucard' , completeFunction);
    });

});

function closeMenuCard(){
    const closemenuinfo = document.getElementById('detailmenu');
    if(closemenuinfo.style.display === "none") {
        closemenuinfo.style.display = "block";
    } else {
        closemenuinfo.style.display = "none";
          }
}

