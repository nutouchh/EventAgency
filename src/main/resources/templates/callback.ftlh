<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Успех!</title>
</head>
<body>
<h1>Event Agency</h1>
<hr>

<#if user.email??>
    <h3>Имя пользователя: <i>${user.name}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти"/>
    </form>
    <#if user.isAdmin()>
        <a href="/admin">Панель администратора</a>
    </#if>
<#else>
    <h1><a href="/login">Войти</a></h1>
</#if>
<hr>
<#--<h3>Добро пожаловать в личный кабинет, господин администратор!</h3>-->
<hr>
<h3>Заполните форму и скоро с Вами свяжется наш менеджер!</h3>
<hr>

<form action="/callback/create" method="post" enctype="multipart/form-data">
    <#--    <div class="form-floating">-->
    <input class="form-control" type="text" name="name" placeholder="Имя" required>
    <#--    </div>-->
    <#--    <div class="form-floating">-->
    <input class="form-control" type="text" name="email" placeholder="Почта" required>
    <#--    </div>-->
    <#--    <div class="form-floating">-->
    <input class="form-control" type="text" name="phone" placeholder="Телефон" required>
    <#--    </div>-->
    <#--    <div class="form-floating">-->
    <input class="form-control" type="text" name="comment" placeholder="Комментарий" required>
    <#--    </div>-->
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Отправить заявку">
</form>

<hr>
</body>
</html>