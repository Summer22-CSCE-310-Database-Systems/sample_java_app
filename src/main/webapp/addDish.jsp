<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
	<p></p>	
	<form action="addDishToDb">
	  <div class="form-group">
	    <label for="chefname">&nbspDish name</label>
	    <input type="text" class="form-control" id="chefname" name="chefname" placeholder="enter dish name" required>
	  </div>
	  <div class="form-group">
	    <label for="address">&nbspDish details</label>
	    <input type="text" class="form-control" id="address" name="address" placeholder="enter dish details" required>
	  </div>
	  <div class="form-group">
	    <label for="phone">&nbspSelect Chef</label>
		<select name="chefid" id="chefid" class="form-control"> 
			<option selected="selected" value="-1">-- Select --</option>
			<c:forEach items="${allchefs}" var="value">
			<option value="<c:out value="${value.id}"/>"><c:out value="${value.cname}"/></option>
			</c:forEach>
		</select>
	  </div>
	  <button type="submit" class="btn btn-primary">Add Dish</button>
	</form>
</tag:layout>