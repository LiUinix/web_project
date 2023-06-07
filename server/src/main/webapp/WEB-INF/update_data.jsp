<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@page import="java.util.*,test_server.*" %>
	
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>更新数据</title>
<style>
form {
    margin: 100px auto;
    text-align: center;
}

label {
    margin-right: 20px;
}

div {
    margin-top: 20px;
}

input[type="text"],
select {
    height: 30px;
    width: 150px;
    box-sizing: border-box;
}

input#Submit {
    height: 30px;
    width: 100px;
}
</style>
<script type="text/javascript">

}
</script>
</head>
<body>
	<form>
	<input type="hidden" name="type" value="Up">
	<div><label>姓名</label><input type="text" name="name"/></div>
	<div><label>年龄</label><input type="text" name="age"/></div>
	<div><label>性别</label>
	<select name="gender">
		<option>
		男
		</option>
		<option>
		女
		</option>
	</select>
	</div>
	<div><label>编号ID</label><input type="text" name="id"/></div>
	<div><input id="Submit" type="submit" value="提交"/></div>
	
	</form>
</body>
</html>
