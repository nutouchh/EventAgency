<#import "blocks/template.ftlh" as t>
<@t.template user>

<#--    <img src="/images/${image.id}" height="150px"/><br><br>-->
    <div style="text-align: center">
        <h1 class="text-uppercase">${event.title}</h1><hr><br>
        <h4>${event.description}</h4><br>
    </div>
    <hr>

    <div class="row row-cols-1 row-cols-md-4 g-4">
        <#list actions as action>
            <div class="col">
                <div class="card">
                    <img src="/images/${action.image.id}" class="card-img-top event" alt="...">
                    <div class="card-body">
                        <h2 style="text-align: center" class="card-title text-uppercase">${action.title}</h2>
                        <h5 class="card-text">от ${action.price} рублей</h5>
                        <div class="d-grid gap-2">
                            <a href="/action/${action.id}" class="btn btn-outline-info" role="button">Подробнее об услуге...</a>
                        </div>
                    </div>
                </div>
            </div>
        <#else>
            <h3 style="text-align: center">К сожалению, в этой категории пока нет услуг</h3>
        </#list>
    </div>
    <hr>
    <div class="d-grid gap-2">
        <a href="/callback" class="btn btn-outline-dark" role="button">Оставить заявку на консультацию со
            специалистом</a>
    </div>

    <#if user.email??>
        <#if user.isAdmin()>
            <hr>
            <form action="/event/delete/${event.id}" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <div class="d-grid gap-2">
                    <input class="btn btn-danger" type="submit" value="Удалить категорию и все соответствующие услуги">
                </div>
            </form>
            <br>
            <div class="d-grid gap-2">
                <a href="/create/action" class="btn btn-outline-warning" role="button">Создать новую услугу</a>
            </div>
        </#if>
    </#if>

</@t.template>