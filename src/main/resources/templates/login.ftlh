<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html>
<head>
<title>Army</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

body{
    background: gainsboro;
}

.form-signin{
    width: 50%;
    left: 113px;
    position: relative;
    left: 25%;
    background: ivory;
    border-radius: 25px;
}

.input
{
    border-radius: 10px;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
}

#errormsg {
  text-align: center;
  color: firebrick;
}

</style>
</head>
<body>

<#if errorMessage??>
    <h4 id="errormsg">${errorMessage}</h4>
</#if>

<form name="login" class="form-signin" method="post" action="/login">
  <div class="imgcontainer">
    <img src="/images/logo.png" alt="Logo Image" class="avatar">
  </div>

  <div class="container">
    <label class="sr-only" for="email"><b>Email</b></label>
    <input class="input" type="text" placeholder="Enter Email" id="email" name="email" required autoFocus>

    <label class="sr-only" for="password"><b>Password</b></label>
    <input class="input" type="password" id="password" placeholder="Enter Password" name="password" required>

    <button type="submit">Login</button>
    <label>
      <input type="checkbox" name="remember" onclick="myFunction()">Show Password
    </label>
    <span class="psw">Not Enlisted? <a href="#">Register Now!</a></span>
  </div>

</form>

</body>
</html>

<script>
function myFunction() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
