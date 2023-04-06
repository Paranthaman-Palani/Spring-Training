<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/studentportal/create" method="POST" modelAttribute="student">
	Student Roll No:<form:input path="rollnumber"/><br>
	Student Name:<form:input path="studentname"/><br>
	Student Department:<form:input path="department"/><br>
	Student Address:<form:input path="adderss"/><br>
	
	<input type="submit" value="click...">
	
</form:form>
