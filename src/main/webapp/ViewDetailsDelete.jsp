<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
    	<form action="deleteChefFromDb"> 
	    	<div class="form-group">
				<div class="form-group">
				<label for="id">Id:</label>
				<input class="form-control" type="text" name="id" value="<c:out value="${chef.id}"/>" id="id" readonly="readonly" />
				</div>
				<div class="form-group">
				<label for="chefname">Chef Name:</label>
				<input class="form-control" type="text" name="chefname" value="<c:out value="${chef.cname}"/>" id="chefname" readonly="readonly" />
				</div>
				<div class="form-group">				
				<label for="address">Address:</label>
				<input class="form-control" type="text" name="address" value="<c:out value="${chef.address}"/>" id="address" readonly="readonly">
				</div>
				<div class="form-group">
				<label for="phone">Phone:</label>
				<input class="form-control" type="text" name="phone" value="<c:out value="${chef.phone}"/>" id="phone" readonly="readonly">
				</div>
				<button type="submit" class="btn btn-primary">Delete</button>
			</div>
		</form>
		<a href="/deleteChef"> Back </a>
</tag:layout>
