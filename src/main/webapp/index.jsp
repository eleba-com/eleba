<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>


<html>

<body>
<h2>Hello World!上传测试</h2>
<%--<form action="/uploadImage" method="post" enctype="multipart/form-data">--%>
    <%--<input type="file" name="imageFile">--%>
    <%--<input type="submit">--%>
    <%--<image src="/upload/images/1544427065757.jpeg" style="width: 100%;height: 100%"></image>--%>
<%--</form>--%>
<div style="margin-left: 100px;margin-top: 100px">

    <%--<strong>--%>
<%--<h1>今晚打边炉了喂！</h1>--%>
    <%--</strong>--%>
        pid=2,numbers=50,uid=1,status1=0,price=51,photo_addr=/tmp1&uid=1&addr=海大&total_price=2550&mid=2

        <form action="/insertOrder" method="post">
            <p>订单项pid<input type="text" name="pid" /></p>
            <p>订单项number<input type="text" name="numbers" /></p>
            <p>订单项uid<input type="text" name="uid" /></p>
            <p>订单项status1<input type="text" name="status1" /></p>
            <p>订单项price<input type="text" name="price" /></p>
            <p>订单项photo_addr=<input type="text" name="photo_addr" /></p>

            <p>uid<input type="text" name="uid" /></p>
            <p>total_price<input type="text" name="total_price" /></p>
            <p>mid<input type="text" name="mid" /></p>
            <p>地址<input type="text" name="addr" /></p>
            <input type="submit" value="Submit" />
        </form>
</div>
</body>
</html>
