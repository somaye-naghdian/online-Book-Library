<!DOCTYPE html>
<html>
<body>
<%! int n1,n2,n3;
 String op; %>
<%  n1 = Integer.parseInt( request.getParameter("number1"));
     n2 = Integer.parseInt( request.getParameter("number2"));
	op = request.getParameter("operations");
	%>
	
	
<% if(op.equals( "Add")) { 
n3= n1+n2; } 
 else if(	op.equals( "Subtraction")) { 
 n3= n1-n2; } 
 else if(	op.equals("Multiple")) { 
 n3= n1*n2; }
 else if(	op.equals("Devide")) {
 n3= n1/n2; } %>

<%= n3 %>

</body>
</html>