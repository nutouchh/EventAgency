<#macro template user>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/static/css/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
        <title>Event agency</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="icon" href="https://drive.google.com/drive/u/0/folders/1a8UV1i3yiDBXtM-HutFS-hjwUb6UJjQP">
    </head>
    <body class=" m-0 border-0 font-monospace" style="font-family: 'Ysabeau', sans-serif;">
    <nav class="navbar bg-info bg-gradient fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand fw-bold" href="/">EVENT AGENCY</a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                </ul>
            </div>
            <a class="btn btn-outline-dark" href="/callback">Оставить заявку</a>
        </div>
    </nav>
    <br><br>
    <div class="container mt-4">
        <#nested/>
        <br>
        <#if user.email??>
            <#if user.isAdmin()>
                <div class="d-grid gap-2">
                    <a href="/admin" class="btn btn-outline-warning">Панель администратора</a>
                </div>
            </#if>
            <hr>
            <form action="/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input class="btn btn-outline-danger" type="submit" value="Выйти"/>
            </form>
        </#if>
    </div>
    <br>
    </body>
    </html>

</#macro>