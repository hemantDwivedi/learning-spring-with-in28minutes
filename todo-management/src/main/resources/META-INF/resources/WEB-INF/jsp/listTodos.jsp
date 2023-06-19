<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>List todos - page</title>
</head>
<body>
<h1>Welcome ${name}</h1>
<div>

<table>
<thead>
<tr>
<th>id</th>
<th>description</th>
<th>target date</th>
<th>Done</th>
</tr>
</thead>
<tbody>
<c:forEach items="${todos}" var="todo">
<tr>
<td>${todo.id}</td>
<td>${todo.description}</td>
<td>${todo.targetDate}</td>
<td>${todo.done}</td>
</tr>
</c:forEach>
</tbody>
</table>

</div>
</body>
</html>