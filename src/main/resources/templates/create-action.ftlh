<#import "blocks/template.ftlh" as t>
<@t.template user>

    <h3>Создать новую услугу</h3><hr>

    <form action="/action/create" method="post" enctype="multipart/form-data" class="was-validated">
        <div class="mb-3">
            <label for="validationTextarea" class="form-label">Название услуги</label>
            <input type="text" name="title" class="form-control" id="validationTextarea" placeholder="Фуршет" required>
        </div>

        <div class="mb-3">
            <label for="validationTextarea" class="form-label">Описание услуги</label>
            <input type="text" name="description" class="form-control" id="validationTextarea" placeholder="Это..." required>
        </div>

        <div class="mb-3">
            <label for="validationTextarea" class="form-label">Стоимость услуги</label>
            <input type="number" name="price" class="form-control" id="validationTextarea" placeholder="10000" required>
        </div>

        <div class="mb-3">
            <label for="t1" class="form-label">Категория услуги</label>
            <select id="t1" name="eventTitle" class="form-select" required aria-label="select example">
                <#list events as event>
                    <option>
                        ${event.title}
                    </option>
                </#list>
            </select>
        </div>

        <div class="mb-3">
            <label for="t2" class="form-label">Фото услуги</label>
            <input id="t2" type="file" name="file" class="form-control" aria-label="file example" required>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="mb-3">
            <button class="btn btn-outline-info" type="submit">Добавть услугу</button>
        </div>
    </form>
</@t.template>