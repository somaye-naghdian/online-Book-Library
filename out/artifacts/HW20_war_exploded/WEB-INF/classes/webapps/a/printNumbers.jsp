<!DOCTYPE html>
<html>
<body>
<%! int n; %>
<%  n = Integer.parseInt( request.getParameter("number1"));   %>
	


<% for (int i=0;i<n; i++) {%>
<%= i%> 
<br>
<%}%>

</body>
</html>