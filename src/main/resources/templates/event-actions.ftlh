<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${event.title}</title>
</head>
<body>
<h1>${event.title}</h1>
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


<#-- фоточки выводит -->
<#--<#list image as img>-->
<img src="/images/${image.id}" height="150px"/><br><br>
<input type="hidden" name="_csrf" value="${_csrf.token}">
<#--</#list>-->


<b>Название услуги:</b> ${event.title}<br>
<b>Описание услуги:</b> ${event.description}<br>
<#--<b>Цена услуги:</b> ${event.price}<br>-->

<#--<#if user.email??>-->
<#--    <#if user.isAdmin()>-->
<#--        <hr>-->
<#--        <form action="/event/delete/${event.id}" method="post">-->
<#--            <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--            <input type="submit" value="Удалить услугу">-->
<#--        </form>-->
<#--    </#if>-->
<#--</#if>-->

<hr>

<#list actions as action>
    <div>
        <p>
            <b>${action.title}</b> ${action.price} | <a href="/action/${action.id}">Подробнее...</a>
        </p>
    </div>
<#else>
    <h3>К сожалению, в этой категории пока нет услуг</h3>
</#list>

<#if user.email??>
    <#if user.isAdmin()>
        <hr>
        <p>
            <a href="/create/action">Создать новую услугу</a>
        </p>
        <hr>
    <#-- создание нового товара -->
<#--        <h3>Создать новую услугу</h3>-->
<#--        <form action="/action/create" method="post" enctype="multipart/form-data">-->
<#--            Название услуги: <input required type="text" name="title"><br><br>-->
<#--            Описание услуги: <input required type="text" name="description"><br><br>-->
<#--            Цена услуги: <input required type="number" name="price"><br><br>-->
<#--            Категория мероприятия: <input required type="text" name="eventTitle"><br><br>-->
<#--            Фото услуги: <input required type="file" name="file"><br><br>-->
<#--            &lt;#&ndash;            Фото услуги 2: <input type="file" name="file2"><br><br>&ndash;&gt;-->
<#--            &lt;#&ndash;            Фото услуги 3: <input type="file" name="file3"><br><br>&ndash;&gt;-->
<#--            <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--            <input type="submit" value="Добавить услугу">-->
<#--        </form>-->
        <br>
        <hr>
        <form action="/event/delete/${event.id}" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Удалить категорию и все соответствующие услуги">
        </form>
    </#if>
</#if>

</body>
</html>