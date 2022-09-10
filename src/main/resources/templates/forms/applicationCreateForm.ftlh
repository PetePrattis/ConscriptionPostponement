<#import "/spring.ftl" as spring />

<h4 class="mb-3">Register Citizen</h4>
<form id="createForm" name="applicationForm" class="needs-validation" action="/citizen/create" method="post" novalidate>

    <#if errorMessage??>
    <h4 class="validationmsg">${errorMessage}</h4>
</#if>

<div class="form-row">
    <div class="col-md-4 mb-3">
        <label for="document">Document</label>
        <@spring.bind "applicationForm.document"/>

        <input type="text" class="form-control" id="document" name="document" placeholder="Document" value="${applicationForm.document!''}" required>
        <#if spring.status.error>
        <ul>
            <#list spring.status.errorMessages as error>
            <li style="color: #dc3545">${error}</li>
        </#list>
        </ul>
    </#if>
    <div class="invalid-feedback">
        This field is required.
    </div>
</div>
<div class="col-md-4 mb-3">
    <label for="birthday">Birthday</label>
    <@spring.bind "applicationForm.birthday"/>

    <div class="input-group">
        <input type="text" class="form-control" id="birthday" name="birthday" placeholder="Birthday" value="${applicationForm.birthday!''}" required>
        <#if spring.status.error>
        <ul>
            <#list spring.status.errorMessages as error>
            <li style="color: #dc3545">${error}</li>
        </#list>
        </ul>
    </#if>
    <div class="invalid-feedback">
        This field is required.
    </div>
</div>
</div>
</div>


<button class="btn btn-primary btn-lg mt-4" type="submit">Create</button>
</form>

<script>
//JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>