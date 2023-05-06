<#import "blocks/template.ftlh" as t>
<@t.template user>

    <h2>Объект успешно создан!</h2>
    <hr>
    <div class="d-grid gap-2">
        <a href="/create/action" class="btn btn-outline-info" role="button">Создать новую услугу</a>
    </div>
    <hr>
    <div class="d-grid gap-2">
        <a href="/create/event" class="btn btn-outline-info" role="button">Создать новую event-категорию</a>
    </div>
    <hr>
    <div class="d-grid gap-2">
        <a href="/" class="btn btn-outline-info" role="button">Вернуться на главную страницу</a>
    </div>

</@t.template>