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
<h4>已连接到MySQL(JAVA):</h4>
<h5 id="version" ></h5>
<h5 id="os" ></h5>
<h5 id="comment" ></h5>
<h5 id="uptime" ></h5>
<h5 id="received" ></h5>
<h5 id="sent" ></h5>
<table id="data" border="1" width="30%">
    <tr>
        <td width="20%" >id</td>
        <td width="20%" >framework</td>
        <td width="20%" >language</td>
        <td width="40%" >create_time</td>
    </tr>
</table>
</body>
<script>
    $(function () {
        $.ajax({
            url: "/cloudtogo",
            type: "get",
            dataType: 'json',
            contentType: 'application/json',
            data: "",
            success: function (data) {
                $("#version").html("version : " + data.version);
                $("#os").html("version_compile_os : " + data.version_compile_os);
                $("#comment").html("version_comment : " + data.version_comment);
                $("#uptime").html("Uptime : " + data.Uptime);
                $("#received").html("Bytes_received : " + data.Bytes_received);
                $("#sent").html("Bytes_sent : " + data.Bytes_sent);

                var trHtml = "";
                for (var i=0;i<data.data.length;i++){
                    trHtml += "<tr><td>"+data.data[i].id+"</td>";
                    trHtml += "<td>"+data.data[i].framework+"</td>";
                    trHtml += "<td>"+data.data[i].language+"</td>";
                    trHtml += "<td>"+data.data[i].createTime+"</td></tr>";
                }

                $("#data").append(trHtml);
                console.info(data)
            },
            error: function () {
            }
        });
    });
</script>
</html>
