<%--
  Created by IntelliJ IDEA.
  User: chinalife
  Date: 2017/5/23
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

</head>
<body>
<div class="footer">
    version：<span id="versionID"></span> 版权所有&copy; 中国人寿保险股份有限公司 Copyright (c) China Life Insurance Company Ltd. All Rights Reserved.
</div>
</body>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
                  $.ajax({
                     url:"/seckill/getVersionID",
                     type:"get",
                     dataType:"json",
                     async: true,
                     success:function(data) {
                         alert("正确!");
                         $("#versionID").html(data.versionID);
                     },
                     error:function() {
                         alert("错误！");
                     }
                      });

    });



</script>
</html>
