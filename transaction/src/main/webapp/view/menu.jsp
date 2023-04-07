<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/customer/create" method="GET" >
	<input type="submit" value="CreateAccount">
    
	
</form:form>
<form:form action="/customer/findbyid" method="GET" >
	<input type="submit" value="Check Balance">
	
</form:form>

<form:form action="/customer/moneytransfer" method="GET" >
	<input type="submit" value="Transfer Money">
	
</form:form>