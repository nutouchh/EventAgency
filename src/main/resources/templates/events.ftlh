<#import "blocks/template.ftlh" as t>
<@t.template user>
    <div style="text-align: center">
        <h1>Агенство по организации мероприятий</h1><br>
        <h4>Добро пожаловать! Наша компания предоставляет целый спкетр идей для Вашего праздника!</h4><br>
    </div>
    <hr>
    <div class="row row-cols-1 row-cols-md-4 g-4">
        <#list events as event>
            <div class="col">
                <div class="card">
                    <img src="/images/${event.image.id}" class="card-img-top event" alt="...">
                    <div class="card-body">
                        <h2 style="text-align: center" class="card-title text-uppercase">${event.title}</h2>
<#--                        <p class="card-text" style="text-align:justify">${event.description}</p>-->
                        <div class="d-grid gap-2">
                            <a href="/event/${event.id}" class="btn btn-outline-info" role="button">Подробнее о
                                мероприятии...</a>
                        </div>
                    </div>
                </div>
            </div>
        <#else>
            <h3 style="text-align: center">На данный момент мы не предоставляем никаих услуг :(</h3>
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
            <div class="d-grid gap-2">
                <a href="/create/event" class="btn btn-outline-warning" role="button">Создать новую event-категорию</a>
            </div>
        </#if>
    </#if>
</@t.template>