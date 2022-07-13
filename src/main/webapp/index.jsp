<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
    <div class="container-fluid padding">
  	<main id="main">
	    <hr> 	
	    <button type="button" class="collapsible">Create</button>
		<div class="content">
	  		<ul class="ul_a">
				<li><a href="/addChef">Add chef</a></li>
				<li><a href="/addDish">Add dish</a></li>
			</ul>
		</div>	
		<button type="button" class="collapsible">Read/Report</button>
		<div class="content">
	  		<ul class="ul_a">
	  			<li><a href="/allchefs">View all chefs</a></li>
				<li><a href="/listdishesforchef">Name and address of chef from dish</a></li>
				<li><a href="/listchefsfordishes">Dish name from chef</a></li>
				<li><a href="/getcheffromaddress">Chef who lives in an address</a></li>
			</ul>
		</div>   
	
	  	<button type="button" class="collapsible">Update</button>
		<div class="content">
	  		<ul class="ul_a">
				<li><a href="/updateChef">Update chefs info</a></li>
				<li><a href="/updateDish">Update dish details</a></li>
			</ul>
		</div>
		<button type="button" class="collapsible">Delete</button>
		<div class="content">
	  		<ul class="ul_a">
				<li><a href="/deleteChef">Delete chefs </a></li>
			</ul>
		</div>
    </main>
	</div>
</tag:layout>

