<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
    	<hr>
    	<p><h5>The chef who lives at <b>${address}</b> is <b>${chef}.</b></h5></p>
    	<hr>
		<a href="/getcheffromaddress">Back</a><br>
</tag:layout>