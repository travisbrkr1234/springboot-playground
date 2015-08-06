<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome to Ravenholm</title>
  <link href="${pageContext.request.contextPath}/resources/static/css/main.css" rel="stylesheet" type="text/css" >
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

  <style>

  </style>
</head>
<body class="align">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<div class="site__container">
  <div class="grid__container">
    <form action="wizardoptions" method="get" class="form form--login">
      <span class="fa-stack fa-5x" id="logo">
        <i class="fa fa-internet-explorer fa-stack-1x"></i>
        <i class="fa fa-ban fa-spin fa-stack-2x text-danger"></i>
      </span>
      <div class="form__field">
        <label class="fa fa-rebel" for="login__username"><span class="hidden">Username</span></label>
        <input type="text" id="login__username" class="form__input" placeholder="Username" required>
      </div>
      <div class="form__field">
        <label class="fa fa-empire" for="login__password"><span class="hidden">Password</span></label>
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
