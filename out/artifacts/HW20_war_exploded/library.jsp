<%--
  Created by IntelliJ IDEA.
  User: Ehsan
  Date: 6/29/2020
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title style="color: darkblue">BOOK DETAILS</title>
    <style>
        input[type=text] {
            width: auto;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            background-color: white;

            background-position: inherit;
            background-repeat: no-repeat;
            padding: 3px 7px 4px 15px;
        }
        div {
            width: 500px;
            border: 8px solid midnightblue;
            padding: 40px;
            text-align: center;
            align-self: center;
        }
    </style>

</head>
<body style="background-color:powderblue;">
<center>
<div>
<form action="/LibraryManagement" method="get" >
<h1 style="text-align: center; color: darkblue"> BOOK  DETAILS </h1>
    <label style="color: darkblue">BOOK ID</label>
    <input type="number" name="bookId" id="bookId" required><br><br>
    <label style="color: darkblue">BOOK NAME</label>
    <input type="text" name="bookName" id ="bookName" ><br><br>
    <label style="color: darkblue">AUTHOR</label>
    <input type="text" name="author" id="author"><br><br>
    <label style="color: darkblue">MEMBER ID</label>
    <input type="text" name="memberId" id="memberId"><br><br>
    <br>

    <input type="submit" name="button"  value="ADD" >
    <input type="submit" name="button" value="DELETE"  >
    <input type="submit" name="button"  value="UPDATE"  >
    <input type="submit" name="button"  value="DISPLAY" >
</form>


</div>
    <form action="/LogOut" method="get">
        <button style="margin:5px;color: midnightblue; cursor: pointer; background-color: powderblue;" type="submit"
                value="CANCEL" href="index.jsp">LOGOUT
        </button>
    </form>
</center>

</body>
</html>
