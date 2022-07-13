<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
	<p></p>	
	<form action="addChefToDb">
	  <div class="form-group">
	    <label for="chefname">&nbspName</label>
	    <input type="text" class="form-control" id="chefname" name="chefname" placeholder="enter name" required>
	  </div>
	  <div class="form-group">
	    <label for="address">&nbspAddress</label>
	    <input type="text" class="form-control" id="address" name="address" placeholder="enter address" required>
	  </div>
	  <div class="form-group">
	    <label for="phone">&nbspPhone</label>
	    <input type="number" class="form-control" name="phone" id="phone" placeholder="enter phone" required>
	     <small id="phone help" class="form-text text-muted">Enter 10 digit phone number without special characters</small>
	  </div>
	  <button type="submit" class="btn btn-primary">Add Chef</button>
	</form>
</tag:layout>