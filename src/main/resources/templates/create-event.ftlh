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

    <h3>Создать новую event-категорию</h3><hr>

    <form action="/event/create" method="post" enctype="multipart/form-data" class="was-validated">
        <div class="mb-3">
            <label for="validationTextarea" class="form-label">Название мероприятия</label>
            <input type="text" name="title" class="form-control" id="validationTextarea" placeholder="Свадьба" required>
        </div>

        <div class="mb-3">
            <label for="validationTextarea" class="form-label">Описание мероприятия</label>
            <input type="text" name="description" class="form-control" id="validationTextarea" placeholder="Это..."
                   required>
        </div>
        <div class="mb-3">
            <button class="btn btn-outline-info" type="submit">Добавть мероприятие</button>
        </div>
    </form>
    <hr>
    <br>
    <hr>
</div>
<br>
</body>
</html>

