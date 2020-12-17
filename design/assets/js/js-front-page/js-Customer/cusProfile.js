 $(document).ready(function () {
            $(loadData());

            function loadData() {
                getCustomers(function (result) {
                    $("#tableData").empty();
                    $.each(result, function (i, item) {
                        $("#tableData").append($("<tr>").append($("<td>").text(item.id)).append($("<td>").text(item.name)).append($("<td>").text(item.email)).append($("<td>").text(item.mobile)).append($(
                            "<td>\n" +
                            "<div class=\"btn-group btn-group-sm\" role=\"group\"><a class=\"btn btn-light\" role=\"button\" href=\"/customer/edit?id=" + item.id + "\"> <i class=\"fa fa-edit\"></i></a><button class=\"btn btn-light\" type=\"button\" data-target=\"#confirm-modal\" data-toggle=\"modal\" data-id=\"" + item.id + "\"> <i class=\"fa fa-trash\"></i></button></div>\n" +
                            "</td></tr>"
                        )));
                    });
                });
            }

            $("#deleteData").click(function () {
                deleteCustomer($(this).attr('data-id'), function (result) {
                    $('#confirm-modal').modal('hide');
                    loadData();
                });
            });
        });