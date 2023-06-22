<%@ include file="common/header.jspf" %>
  <%@ include file="common/navigation.jspf" %>
<div class="container p-5">
<h1>Welcome ${name}</h1>
<div>

<table class="table">
<thead>
<tr>
<th>description</th>
<th>target date</th>
<th>Done</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach items="${todos}" var="todo">
<tr>
<td>${todo.description}</td>
<td>${todo.targetDate}</td>
<td>${todo.done}</td>
<td>
<a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a>
<a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="add-todo" class="btn btn-dark">Add</a>
</div>
</div>
<%@ include file="common/footer.jspf" %>