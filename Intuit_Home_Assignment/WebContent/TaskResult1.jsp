<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Van Deli's Corner</title>
</head>
<body>
    <center>
        <h1>Van Deli's Order Analysis App</h1>
        <h2>
            <a href="/Task1">Query Result 1: Most purchased item on the menu and Purchase Count</a>
			<hr />
            <a href="/Task2">Query Result 2: Display data in the required format</a>     
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="2">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>Product Name</th>
                <th>Purchase Count</th>
            </tr>
            <c:forEach var="row" items="${task1Result}">
                <tr>
                    <td><c:out value="${row.product_name}" /></td>
                    <td><c:out value="${row.purchase_count}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>