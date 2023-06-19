<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<title>List todos - page</title>
</head>
<body>
<div class="container p-4">

<h1>Todo Details</h1>

<form method="post">

 <label for="description" class="form-label">Description</label>
  <input type="text" class="form-control" id="description">

  <input type="submit" class="btn btn-success mt-2" />

</form>

</div>


<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
