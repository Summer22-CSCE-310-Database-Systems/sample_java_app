<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
    	<form action="updateChefInDb"> 
	    	<div class="form-group">
				<p><h5>Modify and click update </h2></p>
				<div class="form-group">
				<label for="id" class="col-form-label">Id</label>
				<input class="form-control" type="text" name="id" value="<c:out value="${chef.id}"/>" id="id" readonly="readonly" />
				</div>
				<div class="form-group">
				<label for="chefname" class="col-form-label">Chef Name</label>
				<input class="form-control" type="text" name="chefname" value="<c:out value="${chef.cname}"/>" id="chefname" readonly="readonly" />
				</div>
				<div class="form-group">				
				<label for="address" class="col-form-label">Address</label>
				<input class="form-control" type="text" name="address" value="<c:out value="${chef.address}"/>" id="address" required>
				</div>
				<div class="form-group">
				<label for="phone" class="col-form-label">Phone</label>
				<input class="form-control" type="number" name="phone" value="<c:out value="${chef.phone}"/>" id="phone" required>
				<small id="phone help" class="form-text text-muted">Phone number should be 10 digits without special characters</small>
			
				</div>
				<button type="submit" class="btn btn-primary">Update</button>
			</div>
		</form>
	<a href="/updateChef"> Back </a>
</tag:layout>