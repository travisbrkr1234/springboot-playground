<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome to Ravenholm</title>
  <link href="${pageContext.request.contextPath}/resources/static/css/main.css" rel="stylesheet" type="text/css" >
  <style>

  </style>
</head>
<body class="align">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<div class="site__container">
  <div class="grid__container">
    <form action="wizardoptions" method="get" class="form form--login">
      <div class="form__field">
        <label class="fontawesome-user" for="login__username"><span class="hidden">Username</span></label>
        <input type="text" id="login__username" class="form__input" placeholder="Username" required>
      </div>
      <div class="form__field">
        <label class="fontawesome-lock" for="login__password"><span class="hidden">Password</span></label>
        <input type="password" id="login__password" class="form__input" placeholder="Password" required>
      </div>
      <div class="form__field">
        <input type="submit" value="Sign In">
      </div>
    </form>
  </div>
</div>
</body>
</html>