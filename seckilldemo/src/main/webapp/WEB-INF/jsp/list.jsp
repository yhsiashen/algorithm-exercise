<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>抢票通主页</title>
     <%@include file="common/head.jsp" %>
         
</head>
<body>
    <!-- 用bootstrap的组件写页面 -->
    <div class="container" >
        <div class="panel panel-default" >
            <div class="panel-heading text-center">
                <h2>抢票通</h2>
            </div>
            <div class="panel-body">
              <table class="table table-cover">
                  <thead>
                    <tr>
                        <th>名称</th>
                        <th>库存</th>
                        <th>秒杀开启时间</th>
                        <th>秒杀结束时间</th>
                        <th>创建时间</th>
                        <th>详情页</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="sk" items="${list}">
                      <tr>
                        <td>${sk.name}</td>
                        <td>${sk.seckillNumber}</td>
                        <td>
                            <fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                        </td>
                        <td>
                            <fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                        </td>
                          <td>
                              <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                          </td>
                          <td>
                              <a class="btn btn-warning" href="/seckill/${sk.seckillId}/detail" target="_blank">
                                  <span class="glyphicon glyphicon-star">link</span>
                              </a>
                          </td>
                      </tr>
                    </c:forEach>
                  </tbody>
              </table>
            </div>
        </div>
    </div>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</html>