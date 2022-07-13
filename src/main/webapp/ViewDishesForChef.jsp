<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
    	<p><h5> All dishes: </h5></p>
    	<hr>
		<table border="1">
		  <thead>
		    <tr>
		      <th>Dish id</th>
		      <th>Dish Name</th>
		      <th>Dish Detail</th>
		    </tr>
		  </thead>
		  <tbody>
		     <c:forEach items="${dishes}" var="value">
		      <tr>
		        <td>
		          <c:out value="${value.id}"/>
		        </td>
		       	<td>
		          <c:out value="${value.dname}"/>
		        </td>
		       	<td>
		          <c:out value="${value.ddetail}"/>
		        </td>
		      </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<a href="/listchefsfordishes">Back</a><br>
</tag:layout>