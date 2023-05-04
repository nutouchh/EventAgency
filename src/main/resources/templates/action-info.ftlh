<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Услуга: ${action.title}</title>
</head>
<body>
<h1>Услуга: ${action.title}</h1>
<hr>

<#-- фоточки выводит -->
<#--<#list image as img>-->
<img src="/images/${image.id}" height="150px"/><br><br>
<input type="hidden" name="_csrf" value="${_csrf.token}">
<#--</#list>-->


<b>Название услуги:</b> ${action.title}<br>
<b>Описание услуги:</b> ${action.description}<br>
<b>Цена услуги:</b> ${action.price}<br>
<b>Категория:</b> ${action.event.title}<br>

<#if user.email??>
    <#if user.isAdmin()>
        <hr>
        <form action="/action/delete/${action.id}" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Удалить услугу">
        </form>
    </#if>
</#if>

</body>
</html>