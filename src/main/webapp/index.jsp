<%--
  Created by IntelliJ IDEA.
  User: nero
  Date: 2018/1/29
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
    welcome to cloudtogo ide
</body>
<script>
    $(function () {
        $.ajax({
            url :"/cloudtogo",
            type : "get",
            dataType :'json',
            contentType :'application/json',
            data : "",
            success : function(data){
                console.info(data)
            },
            error : function () {
            }
        });
    });
</script>
</html>
