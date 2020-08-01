<!DOCTYPE html>
<html>
<body>

<%! int n1 = Integer.parseInt( req.getParameter("number1");
    int n2 = Integer.parseInt( req.getParameter("number2");
	int n3=0 %>
<% n3= n1+n2; %>
<%= n3 %>

</body>
</html>