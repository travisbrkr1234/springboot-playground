<html>
<head>
    <meta charset="UTF-8">
    <title>Export Wizard</title>
    <link href="${pageContext.request.contextPath}/resources/static/css/loginStyle.css" rel="stylesheet" type="text/css" >
</head>
<body>
<body class="align">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<div class="site__container">
    <center><p>Enter the information to retrieve data</p></center>
    <div class="grid__container">
        <form action="export" method="get" class="form form--login">
            <div class="form__field">
                <label class="fontawesome-user" for="login__username"><span class="hidden">Username</span></label>
                <input id="login__username" type="text" class="form__input" placeholder="App Name" required>
            </div>
            <div class="form__field">
                <label class="fontawesome-lock" for="login__password"><span class="hidden">Password</span></label>
                <input id="login__password" type="password" class="form__input" placeholder="Api Key" required>
            </div>
            <div class="form__field">
                <input type="submit" value="Gimmie my data!">
            </div>
        </form>
    </div>
</div>
</body>
</body>
</html>
