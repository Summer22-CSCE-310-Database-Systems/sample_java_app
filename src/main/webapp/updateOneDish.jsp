<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
    	<form action="updateDishInDb"> 
	    	<div class="form-group">
				<p><h5>Modify and click update </h2></p>
				<div class="form-group">
				<label for="id" class="form-group">Id</label>
				<input class="form-control" type="text" name="id" value="<c:out value="${dish.id}"/>" id="id" readonly="readonly" />
				</div>
				<div class="form-group">
				<label for="dishname" class="form-group">Dish name</label>
				<input class="form-control" type="text" name="dishname" value="<c:out value="${dish.dname}"/>" id="chefname" readonly="readonly" />
				</div>
				<div class="form-group">				
				<label for="ddetail" class="form-group">Dish details</label>
				<input class="form-control" type="text" name="ddetail" value="<c:out value="${dish.ddetail}"/>" id="address" required>
				</div>
				<div class="form-group">
				<label for="cname" class="form-group">Chef Name</label>
				<input class="form-control" type="text" name="cname" value="<c:out value="${chef.cname}"/>" id="phone" readonly="readonly" required>
				</div>
				<input class="form-control" type="hidden" name="cid" value="<c:out value="${dish.cid}"/>" id="phone" readonly="readonly" required>
				<button type="submit" class="btn btn-primary">Update</button>
			</div>
		</form>
</tag:layout>