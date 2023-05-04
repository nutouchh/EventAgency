<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Event Agency</title>
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
    <a href="/login">Войти</a></h1>
</#if>
<hr>
<h2>Агенство по организации мероприятий</h2>
<h4>Наша компания предоставляет целый спкетр идей для Вашего праздника!</h4>
<#-- поиск услуги по названию -->
<form action="/" method="get">
    Поиск услуги: <input type="text" name="title"><br>
    <input type="submit" value="Поиск">
</form>

<#-- показ всех услуг -->
<#list events as event>
    <div>
        <p>
            <b>${event.title}</b> | <a href="/event/${event.id}">Подробнее...</a>
        </p>
    </div>
<#else>
    <h3>На данный момент мы не предоставляем никаих услуг :(</h3>
</#list>

<#if user.email??>
    <#if user.isAdmin()>
        <hr>
        <p>
            <a href="/create/event">Создать новую event-категорию</a>
        </p>
        <hr>
<#--        <h3>Создать новую event-категорию</h3>-->
<#--        <form action="/event/create" method="post" enctype="multipart/form-data">-->
<#--            Название мероприятия: <input required type="text" name="title"><br><br>-->
<#--            Описание мероприятия: <input required type="text" name="description"><br><br>-->
<#--&lt;#&ndash;            Цена услуги: <input required type="number" name="price"><br><br>&ndash;&gt;-->
<#--            Фото мероприятия: <input required type="file" name="file"><br><br>-->
<#--&lt;#&ndash;            Фото услуги 2: <input type="file" name="file2"><br><br>&ndash;&gt;-->
<#--&lt;#&ndash;            Фото услуги 3: <input type="file" name="file3"><br><br>&ndash;&gt;-->
<#--            <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--            <input type="submit" value="Добавить мероприятие">-->
<#--        </form>-->
    </#if>
</#if>
</body>
</html>