<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
    	<p><h5> All Chefs </h5></p>
    	<hr>
		<table border="1">
		  <thead>
		    <tr>
		      <th>Chef Id</th>
		      <th>Chef Name</th>
		      <th>Address</th>
		      <th>Phone</th>
		    </tr>
		  </thead>
		  <tbody>
		     <c:forEach items="${allchefs}" var="value">
		      <tr>
		        <td>
		          <c:out value="${value.id}"></c:out>
		        </td>
		        <td>
		          <c:out value="${value.cname}"/>
		        </td>
		       	<td>
		          <c:out value="${value.address}"/>
		        </td>
		       	<td>
		          <c:out value="${value.phone}"/>
		        </td>
		      </tr>
		    </c:forEach>
		  </tbody>
		</table>
</tag:layout>