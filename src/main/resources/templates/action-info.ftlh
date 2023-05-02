<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Подробная информация об услуге</title>
</head>
<body>
<h1>ЭТА МАИ УСЛУГИ ПАКУПАЙТИ ПАЖАЛУСТА</h1><hr>


<#-- фоточки выводит -->
<#list images as img>
    <img src="/images/${img.id}" height="150px"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</#list>


<b>Название услуги:</b> ${action.title}<br>
<b>Описание услуги:</b> ${action.description}<br>
<b>Цена услуги:</b> ${action.price}<br>
<hr>
<form action="/action/delete/${action.id}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить услугу">
</form>
</body>
</html>