<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  type="text/css" href="/ProductsSSM/a/css/index1.css">
<script type="text/javascript" src="/ProductsSSM/a/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="/ProductsSSM/a/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form action="/ProductsSSM/insertProduct.do">
      <table>
            <tr>
                    <th>產品名字</th>
                    <th><input type="text" name="name"></th>
            </tr>
            <tr>
                    <th>產品價格</th>
                    <th><input type="text" name="price"></th>
            </tr>
            <tr>
                    <th>生產時間</th>
                    <th><input type="text" name="createtime" onclick="WdatePicker()"></th>
            </tr>
             <tr>
             <th>產品細節</th>
                    <th><input type="text" name="detail"></th>
            </tr>
            <tr>
                  <th>产品分类</th>
                    <th> <input type="checkbox" name="cids" value="1"/><span>手机</span>
                      <input type="checkbox" name="cids" value="2"/><span>电子产品</span>
                      <input type="checkbox" name="cids" value="3"/><span>电脑</span>
                      </th>
           </tr>
            <tr>
                <th><input type="submit" value="提交"></th>
             </tr>           
      </table>
</form>
</body>
</html>