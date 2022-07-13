<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
      <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
      <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
      <link href="style.css" rel="stylesheet">
      <link rel="stylesheet" href="https://m.w3newbie.com/you-tube.css">
    <title>Chefs Info</title>
    <script src="collapse.js" defer></script>
  </head>

  <body>
      <!-- Navigation -->
      <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="container-fluid"> 
        <h3 class="font-weight-bold text-light"> Chef's Directory</h3>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
              </li>
              <li class="nav-item">
                <a class="nav-link text-light" href="/" id="home">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link text-light" href="/aboutus" id="aboutus">About us</a>
              </li>  
            </ul>
          </div>
        </div>
      </nav>
    <jsp:doBody/>
    <hr class="my-4">
    <div class="d-flex justify-content-center">
    <h6>Texas A&M University</h6>
    </div>
    <hr class="my-4">
      
  </body>
</html>