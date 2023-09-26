<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <title>Event agency</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="icon" href="https://illustimage.com/photo/12049.png">
</head>
<body class=" m-0 border-0 font-monospace" style="font-family: 'Ysabeau', sans-serif;">
<nav class="navbar bg-info bg-gradient fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold" href="/">EVENT AGENCY</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            </ul>
        </div>
    </div>
</nav>
<br><br>
<div class="container mt-4">
    <br>
    <div style="text-align: center">
        <h1>Агентство по организации мероприятий</h1><br>
        <h4>Добро пожаловать! Наша компания предоставляет целый спкетр идей для Вашего праздника!</h4><br>
    </div>
    <hr>
    <div class="row row-cols-1 row-cols-md-4 g-4">
        <#list events as event>
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <h2 style="text-align: center" class="card-title text-uppercase">${event.title}</h2>
                        <div class="d-grid gap-2">
                            <a href="/event/${event.id}" class="btn btn-outline-info" role="button">Подробнее о
                                мероприятии...</a>
                        </div>
                    </div>
                </div>
            </div>
        <#else>
            <div style="text-align: center">
                <h3 style="text-align: center">На данный момент мы не предоставляем никаих услуг :(</h3>
            </div>
        </#list>
    </div>

    <hr>
    <hr>
    <div class="d-grid gap-2">
        <a href="/create/event" class="btn btn-outline-warning" role="button">Создать новую event-категорию</a>
    </div>
    <hr>
</div>
<br>
</body>
</html>
