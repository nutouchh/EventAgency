<#import "blocks/template.ftlh" as t>
<@t.template user>

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
            <label for="t2" class="form-label">Фото мероприятия</label>
            <input id="t2" type="file" name="file" class="form-control" aria-label="file example" required>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="mb-3">
            <button class="btn btn-outline-info" type="submit">Добавть мероприятие</button>
        </div>
    </form>
    <hr>

</@t.template>