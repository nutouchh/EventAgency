<#import "blocks/template.ftlh" as t>
<@t.template user>

<#--    <img src="/images/${image.id}" height="150px"/><br><br>-->
    <div style="text-align: center">
        <h1 class="text-uppercase">${action.title}</h1><br>
        <h4>${action.description}</h4><br>
        <h3>от ${action.price} рублей</h3><br>
    </div>
    <hr>
    <div class="d-grid gap-2">
        <a href="/callback" class="btn btn-outline-info" role="button">Оставить заявку на консультацию со специалистом</a>
    </div>

    <#if user.email??>
        <#if user.isAdmin()>
            <hr>
            <form action="/action/delete/${action.id}" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <div class="d-grid gap-2">
                    <input class="btn btn-danger" type="submit" value="Удалить услугу">
                </div>
            </form>
        </#if>
    </#if>
</@t.template>