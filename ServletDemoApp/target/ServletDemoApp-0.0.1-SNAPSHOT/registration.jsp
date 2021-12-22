<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
<div class="card mt-3">
 <div class="card-header">
    Registration
  </div>
  <div class="card-body">
  <form action="registration" method="post">

<div class="row">
    <div class="col">
    <label for="inputEmail4">First Name</label>
      <input type="text" class="form-control" name="firstName" placeholder="First name">
    </div>
    <div class="col">
    <label for="inputEmail4">Last Name</label>
      <input type="text" class="form-control" name="lastName" placeholder="Last name">
    </div> 
  </div>
  <div class="row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" name="email" id="inputEmail4" placeholder="Email">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Password</label>
      <input type="password" class="form-control" name="password" id="inputPassword4" placeholder="Password">
    </div>
  </div>
  <div class="row">
    <div class="col">
    <label for="inputAddress">Address 1</label>
    <input type="text" class="form-control" name="addressLine1" id="inputAddress" placeholder="1234 Main St">
  </div>
  <div class="col">
    <label for="inputAddress2">Address 2</label>
    <input type="text" class="form-control" name="addressLine2" id="inputAddress2" placeholder="Apartment, studio, or floor">
  </div>
  </div>
  <div class="row">
  	<div class="col">
      <label for="inputCity">City</label>
      <input type="text" class="form-control" name="city" id="inputCity">
    </div>
     <div class="col">
      <label for="inputState">State</label>
      <select id="inputState" name="state" class="form-control">
        <option selected>Choose...</option>
        <option value="usa">USA</option>
      </select>
    </div>
    <div class="col">
      <label for="inputZip">Zip</label>
      <input type="text" name="zip" class="form-control" id="inputZip">
    </div>
  </div>
	<div class="mt-2">
	<button type="submit" class="btn btn-primary">Sign in</button>
	</div>
  
</form>
  </div>

</div>


</div>
</body>
</html>