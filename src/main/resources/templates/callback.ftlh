<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h3 style="text-align: center">Заполните форму и скоро с Вами свяжется наш менеджер!</h3>
    <hr>
    <form action="/callback/create" method="post" enctype="multipart/form-data">
        <div class="form-floating mb-3">
            <input type="text" name="name" class="form-control" id="floatingName" required>
            <label for="floatingName">Имя</label>
        </div>
        <div class="form-floating mb-3">
            <input type="email" name="email" class="form-control" id="floatingEm" required>
            <label for="floatingEm">Email</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" name="phone" class="form-control" id="floatingPh" required>
            <label for="floatingPh">Телефон</label>
        </div>
        <div class="form-floating">
            <input type="text" name="comment" class="form-control" id="floatingCom" required>
            <label for="floatingCom">Комментарий</label>
        </div>
        <br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="mb-3">
            <button class="btn btn-outline-info" type="submit">Отправить</button>
        </div>
    </form>
</@t.template>