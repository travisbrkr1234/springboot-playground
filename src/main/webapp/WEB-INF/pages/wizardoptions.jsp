<html>

<head>
  <meta charset="UTF-8">
  <title>Export Wizard</title>
  <link href="${pageContext.request.contextPath}/resources/static/css/main.css" rel="stylesheet" type="text/css">
</head>


  <body class="align">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <div class="site__container">
      <p>Select an option to begin</p>
      <div class="wizard__container">
        <form action="export" method="get" class="form--login">
          <!--<div class="form__field">-->
            <p><input id="optionsW" type="submit" value="Export Data"></p>
            <p><input id="optionsW" type="submit" value="Import Data"></p>
            <p><input id="optionsW" type="submit" value="Clean CSV"></p>
          <!--</div>-->
        </form>
      </div>
    </div>
  </body>


</html>
