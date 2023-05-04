<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создание</title>
</head>
<body>
<h1>Создание мероприятий и услуг</h1>
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

<#-- поиск услуги по названию -->
<#--<form action="/" method="get">-->
<#--    Поиск услуги: <input type="text" name="title"><br>-->
<#--    <input type="submit" value="Поиск">-->
<#--</form>-->

<#-- показ всех услуг -->
<#--<#list actions as action>-->
<#--    <div>-->
<#--        <p>-->
<#--            <b>${action.title}</b> ${action.price} | <a href="/action/${action.id}">Подробнее...</a>-->
<#--        </p>-->
<#--    </div>-->
<#--<#else>-->
<#--    <h3>Услуг нет, но вы держитесь</h3>-->
<#--</#list>-->



<#-- создание нового товара -->
<hr>
<h3>Создать новую услугу</h3>
<form action="/action/create" method="post" enctype="multipart/form-data">
    Название услуги: <input required type="text" name="title"><br><br>
    Описание услуги: <input required type="text" name="description"><br><br>
    Цена услуги: <input required type="number" name="price"><br><br>
    Категория мероприятия :
<#--    <input required type="text" name="eventTitle"><br><br>-->

    <select name="eventTitle">
        <#list events as event>
            <option>
                ${event.title}
            </option>
<#--        <#else>-->
<#--            <h3>Услуг нет, но вы держитесь</h3>-->
        </#list>
    </select><br><br>

    Фото услуги: <input required type="file" name="file"><br><br>
    <#--            Фото услуги 2: <input type="file" name="file2"><br><br>-->
    <#--            Фото услуги 3: <input type="file" name="file3"><br><br>-->
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить услугу">
</form>

</body>
</html>