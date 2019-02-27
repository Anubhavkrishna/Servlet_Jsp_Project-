<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
            <div class="row">
                <div class="col-xs-6 col-xs-offset-3">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                           
                        </div>
                        <div class="panel-body">
                            
                            <form action="product" method="get">
                                                               
                                <div class="form-group">
                                    Enter product id:<input type="text" name="product_id" class="form-control"/>
                                </div>
                                <div class="form-group">
                                  Category<select name="product">
                                                 <option value="volvo">Volvo</option>
  												 <option value="saab">Saab</option>
   											     <option value="fiat">Fiat</option>
   												 <option value="audi">Audi</option>
      															</select></br>
                                	</div>
                              	<div class="form-group " >
                                    Name:<input type="text" name="product_name" class="form-control" />
                                </div>
                                <div class="form-group " >
                                    Price:<input type="text" name="price" class="form-control" />
                                </div>
                                <input type="file" name="myimg">
                                <div class="form-group " >
                                    <button type="submit"  class="btn btn-primary">Add</button>
                                </div> 
                                                                
                            </form>
                            </div>
                    </div>
                </div>
            </div>

</body>
</html>