<!DOCTYPE html>
<html>
<body>
<%! int n1,n2,n3; %>
<%  n1 = Integer.parseInt( request.getParameter("number1"));
     n2 = Integer.parseInt( request.getParameter("number2"));
	 %>
	
<% n3= n1+n2; %>

<%= n3 %>

</body>
</html>