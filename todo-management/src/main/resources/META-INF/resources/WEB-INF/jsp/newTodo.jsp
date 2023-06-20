<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<title>Add todos - page</title>
</head>
<body>
<div class="container p-4">

<h1>Todo Details</h1>

<form:form method="post" modelAttribute="todo">

 <label for="description" class="form-label">Description</label>

  <form:input type="text" class="form-control" id="description"  path="description"  required="required" />

 <form:errors path="description" cssClass="text-warning" />

  <form:input type="hidden" class="form-control" id="done"  path="done" />

  <input type="submit" class="btn btn-success mt-2" />

</form:form>

</div>


<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
