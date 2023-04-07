<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/customer/moneytransfer" method="POST" modelAttribute="trans">
	Credit UID:<form:input path="crid"/><br>
	Debit UID:<form:input path="deid"/><br>
	Amount To be sent:<form:input path="amt"/><br>
	
	<input type="submit" value="click...">
	
</form:form>
