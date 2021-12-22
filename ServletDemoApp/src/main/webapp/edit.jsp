<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Create/Edit</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
<div class="card mt-3">
 <div class="card-header">
    Employee Information
  </div>
  <div class="card-body">
  <form action="employee" method="post">

<div class="row">
    <div class="col">
    <label for="inputEmail4">Name</label>
      <input type="text" class="form-control" name="name" value="${employee.name }"  placeholder="name">
    </div>
    <div class="col">
    <label for="inputEmail4">Position</label>
      <input type="text" class="form-control" name="position" value="${employee.position}" placeholder="position">
    </div> 
  </div>
  <div class="row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Company</label>
      <input type="text" class="form-control" name="company" value="${employee.company}" id="inputEmail4" placeholder="company">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Department</label>
      <input type="text" class="form-control" name="department" value="${employee.department }" id="inputPassword4" placeholder="department">
    </div>
  </div>
  <input type="hidden" name="id" value="${employee.id }"/>
  
	<div class="mt-2">
	<button type="submit" class="btn btn-primary"> Submit</button>
	</div>
  
</form>
  </div>

</div>


</div>

</body>
</html>