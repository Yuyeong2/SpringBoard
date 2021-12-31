<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
    <h1>회원가입</h1>
    <div>${requestScope.msg}</div>
    <form action="/user/join" method="post">
        <div><input type="text" name="uid" placeholder="ID"></div>
        <div><input type="password" name="upw" placeholder="PASSWORD"></div>
        <div><input type="text" name="nm" placeholder="NAME"></div>
        <div>
            <label>Female<input type="radio" name="gender" value="2"></label>
            <label>Male<input type="radio" name="gender" value="1"></label>
        </div>
        <div><input type="submit" value="확인"></div>
    </form>

</body>
</html>
