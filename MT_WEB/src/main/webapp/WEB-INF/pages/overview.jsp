<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 数据概览 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel-menu">
                <div class="row">
                    <canvas id="myChart"></canvas>>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ${labels},
            datasets: [
                {label: '用户数',
                    backgroundColor: 'rgb(255,181,178)',
                    borderColor: 'rgb(255,181,178)',
                    data: ${userData}
                },
                {label: '科技专家数',
                    backgroundColor: 'rgb(187,241,255)',
                    borderColor: 'rgb(187,241,255)',
                    data: ${professorData}
                },
                {label: '科技成果数',
                    backgroundColor: 'rgb(255,243,198)',
                    borderColor: 'rgb(255,243,198)',
                    data: ${scienceData}
                }
            ]
        },
        options: {}
    });
</script>

<jsp:include page="bottom.jsp"/>