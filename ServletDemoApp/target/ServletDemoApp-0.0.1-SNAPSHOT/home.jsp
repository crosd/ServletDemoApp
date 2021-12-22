<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Employee Management System</h2>
<div class="container">
<a>Add Employee</a>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Position</th>
      <th scope="col">Company</th>
       <th scope="col">Department</th>
       <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${employees}" var="item" varStatus="loop">
    <tr>
      <th scope="row">1</th>
      <td>${item.name}</td>
      <td>${item.position}</td>
      <td>${item.company}</td>
      <td>${item.department }</td>
      <td><a>Edit</a> <a>Delete</a></td>
    </tr>
    </c:forEach>
      </tbody>
</table>
</div>

</body>
</html>
