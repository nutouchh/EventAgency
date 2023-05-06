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


<h2>Успех!! Ожидайте звонка менеджера!</h2>

<hr>
<h4>
    <a href="/">Вернуться на главную страницу</a>
</h4>
<hr>

<hr>
</body>
</html>