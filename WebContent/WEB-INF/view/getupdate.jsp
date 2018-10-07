<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="/ProductsSSM/a/css/index1.css">
<script type="text/javascript" src="/ProductsSSM/a/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="/ProductsSSM/a/My97DatePicker/WdatePicker.js"></script>
<body>
<script type="text/javascript">
      $(function(){
    	    if($("#1").val()!=null){
    	    	$(":checkbox[value=1]").attr("checked",true);
    	    }
    	    if($("#2").val()!=null){
    	    	$(":checkbox[value=2]").attr("checked",true);
    	    }
    	    if($("#3").val()!=null){
    	    	$(":checkbox[value=3]").attr("checked",true);
    	    }
    	    $("#1,#2,#3").hide();
      })

</script>
<form action="updateProduct.do">
<table>
        <tr>
    		    <td>產品名稱</td>
    		   <td> <input type="text" name="name" value="${product.name }"></td>
        </tr>
          <tr>
                 <td>產品價格</td>
    		   <td> <input type="text" name="price" value="${product.price }"></td>
        </tr>
           <tr>
                 <td>產品生產時間</td>
    		   <td> <input type="text" name="createtime" value="${product.createtime }" onclick="WdatePicker()"></td>
        </tr>
          <tr>
                 <td>產品評價</td>
    		   <td> <input type="text" name="detail" value="${product.detail }"></td>
        </tr>
        <tr>
                 <td>产品分类</td>
                 <td>
                     <input type="checkbox" name="cids" value="1"/><span>手机</span>
                      <input type="checkbox" name="cids" value="2"/><span>电子产品</span>
                      <input type="checkbox" name="cids" value="3"/><span>电脑</span>
                      <c:forEach items="${product.categorys}" var="categorys">
                                <span id="${categorys.id }" >${categorys.name }</span>
                      </c:forEach>
                 </td>
                
        </tr>
          <tr>
                 <td><input type="text" name="id" value="${product.id }" hidden="hidden"></td>
    		     <td> <input type="submit" value="確定" onclick="put()"></td>
        </tr>
</table>
</form>
</body>
</html>