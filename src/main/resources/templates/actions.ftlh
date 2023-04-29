<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Услуги</title>
</head>
<body>
<h1>ЭТА МАИ УСЛУГИ ПАКУПАЙТИ ПАЖАЛУСТА</h1><hr>
<h3>вот они</h3>
<#list actions as action>
    <div>
        <p>
            <b>${action.title}</b> ${action.price} | <a href = "/action/${action.id}">Подробнее...</a>
        </p>
    </div>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/action/create" method="post">
    Название услуги: <input type="text" name="title"><br><br>
    Описание услуги: <input type="text" name="description"><br><br>
    Цена услуги: <input type="number" name="price"><br><br>
    <input type="submit" value="Добавить услугу">
</form>
</body>
</html>