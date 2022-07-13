<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
   	<form action="viewdetails"> 
    	<div class="form-group col-md-6">
			<p> <h5>Please select a chef to delete</h5> </p>
			<label for="chefname">Chef Name:</label>
			<select name="chefid" id="chefid" class="form-control"> 
				<option selected="selected" value="-1">-- Select --</option>
				<c:forEach items="${allchefs}" var="value">
				<option value="<c:out value="${value.id}"/>"><c:out value="${value.cname}"/></option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-primary">View Details</button>
			
		</div>
	</form>
</tag:layout>
