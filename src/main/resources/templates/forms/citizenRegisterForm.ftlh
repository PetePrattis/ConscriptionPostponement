<#import "/spring.ftl" as spring />

<h4 class="mb-3">Register Citizen</h4>
<form id="createForm" name="citizenForm" class="needs-validation" action="/register" method="post" novalidate>

<#if errorMessage??>
    <h4 class="validationmsg">${errorMessage}</h4>
</#if>

<div class="form-row">
    <div class="col-md-4 mb-3">
        <label for="first-name">First Name</label>
        <@spring.bind "citizenForm.firstName"/>

        <input type="text" class="form-control" id="first-name" name="firstName" placeholder="First Name" value="${citizenForm.firstName!''}" required>
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
    <label for="last-name">Last Name</label>
    <@spring.bind "citizenForm.lastName"/>

    <div class="input-group">
        <input type="text" class="form-control" id="last-name" name="lastName" placeholder="Last Name" value="${citizenForm.lastName!''}" required>
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

<div class="form-row">
    <div class="col-md-4 mb-3">
        <label for="email">Email</label>
        <@spring.bind "citizenForm.email"/>
        <input type="text" class="form-control" id="email" name="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" placeholder="Email" value="${citizenForm.afm!''}" required>
        <#if spring.status.error>
        <ul>
            <#list spring.status.errorMessages as error>
            <li style="color: #dc3545">${error}</li>
        </#list>
        </ul>
    </#if>
    <div class="invalid-feedback">
        Please provide a valid afm.
    </div>
</div>
</div>
</div>

<button class="btn btn-primary btn-lg mt-4" type="submit">Register</button>
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