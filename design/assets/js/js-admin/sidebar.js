/*------------------------------------------------------------------
* Bootstrap Simple Admin Template
* Version: 2.0
* Author: Alexis Luna
* Copyright 2020 Alexis Luna
* Website: https://github.com/alexis-luna/bootstrap-simple-admin-template
-------------------------------------------------------------------*/
// Toggle sidebar on Menu button click
$('#sidebarCollapse').on('click', function() {
    $('#sidebar').toggleClass('active');
    $('#body').toggleClass('active');
});

