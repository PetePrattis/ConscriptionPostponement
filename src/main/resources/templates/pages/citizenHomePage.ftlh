<#import "/spring.ftl" as spring />
<html>
<head>
    <#include "../partials/head.ftlh">
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h3 class="mb-3">Application</h3>
            <#if applicationList?has_content>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>Document</th>
                        <th>Birthday</th>
                        <th>Validated</th>
                        <th>Approved</th>
                    </tr>
                    </thead>
                    <tbody id="myTable">
                    <#list applicationList as application>
                    <tr data-id="${application.id}">
                        <td>${application.document}</td>
                        <td>${application.birthday}</td>
                        <td>${application.validated}</td>
                        <td>${application.approved}</td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <#else>
            No application found!
        </#if>
        </main>
    </div>
</div>

<#include "../partials/scripts.ftlh">
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
</body>
</html>