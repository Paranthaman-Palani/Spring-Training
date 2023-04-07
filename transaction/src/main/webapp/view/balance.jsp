<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/customer/home" method="GET" modelAttribute="bank">
	<h1>Balance is:-</h1>
   
<h3>UID</h3>${bank.uid}
<h3>Name</h3>${bank.name}
<h3>Balance</h3>${bank.amount}
<br><br>
<input type="submit" value="menu">
	
</form:form>