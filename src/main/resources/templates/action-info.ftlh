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

    <div style="text-align: center">
        <h1 class="text-uppercase">${action.title}</h1><br>
        <h4>${action.description}</h4><br>
        <h3>от ${action.price} рублей</h3><br>
    </div>
    <hr>

    <hr>
    <form action="/action/delete/${action.id}" method="post">
        <div class="d-grid gap-2">
            <input class="btn btn-danger" type="submit" value="Удалить услугу">
        </div>
    </form>
    <br>
    <hr>
</div>
<br>
</body>
</html>
