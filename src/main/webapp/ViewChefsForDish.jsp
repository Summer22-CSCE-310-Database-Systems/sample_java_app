<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
    	<p><h5> All Chefs for dish: ${dishname} </h5></p>
    	<hr>
		<table border="1">
		  <thead>
		    <tr>
		      <th>Chef Name</th>
		      <th>Address</th>
		    </tr>
		  </thead>
		  <tbody>
		     <c:forEach items="${chefsfordish}" var="value">
		      <tr>
		        <td>
		          <c:out value="${value.cname}"/>
		        </td>
		       	<td>
		          <c:out value="${value.address}"/>
		        </td>
		      </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<a href="/listdishesforchef">Back</a><br>
</tag:layout>