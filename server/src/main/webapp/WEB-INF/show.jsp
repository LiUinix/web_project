<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@page import="java.util.*,test_server.*" %>
	
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Student数据库</title>
<style>
.container {
    margin: 10px auto;
    
    text-align: center;
}

table {
    margin: 0 auto;
}

h1 {
    text-align: center;
    margin-bottom: 20px;
    margin-top: 100px;
}

.welcome {
    text-align: center;
    margin-top: 20px;
}
#btns{
 	text-align: center;
    margin-top: 20px;

}
</style>
<script type="text/javascript">
function showAdd(){
location.href="server?type=showAdd";

}
function showDel(){
	location.href="server?type=showDel";

	}
function showUp(){
	location.href="server?type=showUp";

	}
</script>
</head>
<body class='contaniner'>
	<%List<Student> list=(List<Student>)request.getAttribute("student"); %>
	<h1>数据库查询结果</h1>
	<table>
		<%for(int i=0;i<list.size();i++) {%>
		
		<tr>
		<td><%=list.get(i).getId() %> </td>
		<td> <%=list.get(i).getName() %> </td>
		<td> <%=list.get(i).getGender() %> </td>
		<td><%=list.get(i).getAge() %> </td>
		</tr>
	
	
	<%}%>
	
	
	</table>
	<div id='btns'>
	<button onclick="showAdd()">插入数据</button>
	<button onclick="showDel()">删除数据</button>
	<button onclick="showUp()">修改数据</button>
	</div>
	<br/>
	<div class='welcome'>---欢迎你使用Mysql查询系统---</div>
</body>
</html>
