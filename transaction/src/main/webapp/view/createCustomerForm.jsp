<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/customer/create" method="POST" modelAttribute="customer">
	UID:<form:input path="uid"/><br>
	Name:<form:input path="name"/><br>
	Amount:<form:input path="amount"/><br>
	
	<input type="submit" value="click...">
	
</form:form>
