<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
    	<form action="listchefsfordish"> 
	    	<div class="form-group">
				<p><h5>Please select a dish:</h5></p>
				<label for="dishname">Dish:</label>
				<select name="dishname" id="dishname" class="form-control"> 
					<option selected="selected">-- Select --</option>
					<c:forEach items="${alldishes}" var="value">
					<option><c:out value="${value.dname}"/></option>
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-primary">Show chefs</button>
			</div>
		</form>
</tag:layout>
