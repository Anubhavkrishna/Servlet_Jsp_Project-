<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>                <!--  
                         <li> <input type="text" placeholder="Search.."></li>
                        
                        <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                      -->
 
<nav class="navbar ">
  <div class="container-fluid">
    <div class="navbar-header">
    
    <ul class="nav navbar-nav">
      <li>GRIZZLY  <img src="grizzly2.png"> STORE</li>
      <li><input type="text" class="input-medium search-query" name="s" placeholder="Search" value="">
        <button type="submit" class="add-on"><i class="icon-search"></i></button>
      </li>
      <li> </li> 
       <li>Welcome Admin <% out.print(request.getAttribute("name1")); %></li>
       <li><a href="logout">logout</a></li>
    </ul>
  </div>
</nav>



<div>
<div>

<div class="row">
  <div class="col-sm-3">
<img src="product-add.jpg">
  
  </div>
  
  <div class="col-sm-3">
  
  <ul class="nav nav-tabs nav-justified">
  <li><a href="#">Products</a></li>
  </ul>
  <a href="product_info.jsp">Add_Product</a>
  
  </div>
  <div class="col-sm-3">

   <ul class="nav nav-tabs nav-justified">
    <li><a href="#">Vendors</a></li>
  </ul>

 </div>
 <div class="col-sm-3">    </div>
 </div>

</div>
</div>


</body>
</html>