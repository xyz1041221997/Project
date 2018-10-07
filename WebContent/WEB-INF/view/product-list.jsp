<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  type="text/css" href="a/css/index1.css">
</head>
<body>
<table border="1">
      <tr>
             <td>name</td>
             <td>price</td>
             <td>createtime</td>
             <td>detail</td>  
             <th>产品分类</th>
             <th>操作 <a href="/ProductsSSM/jsps/insert-form.jsp">添加</a></th>           
      <tr>
       <c:forEach items="${products}"  var="product">
		  		<tr>
		  		       <th>${product.name }</th>
		  		       <th>${product.price }</th>
		  		       <th>${product.createtime }</th>
		  		       <th>${product.detail }</th>
		  		       <th>
		  		            <c:forEach items="${product.categorys}"  var="pre">
		  		                   ${pre.name}
		  		            </c:forEach>      
		  		       </th>
		  		       <th><a href="/ProductsSSM/getupdate.do?id=${product.id }">修改</a>  
		  		       <a href="/ProductsSSM/deleteProduct.do?id=${product.id }">刪除</a></th>
		  		</tr>
		</c:forEach>
</table>

</body>
</html>