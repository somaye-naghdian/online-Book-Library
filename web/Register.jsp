<%--
  Created by IntelliJ IDEA.
  User: Ehsan
  Date: 6/28/2020
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REGISTRATION</title>
    <style>
        input[type=text] {
            width: 30%;
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
            width: 600px;
            border: 8px solid midnightblue;
            padding: 50px;
            text-align: center;
        }
    </style>

</head>

<body style="background-color:powderblue;">

<center>
    <div>
        <form action="Register" method="post">
            <h1 style="color: midnightblue; size: auto"> REGISTRATION </h1>
            <label style="color: darkblue"> First Name : </label>
            <input type="text" name="FirstName" required><br><br>
            <label style="color: darkblue"> Last Name : </label>
            <input type="text" name="LastName" required><br><br>
            <label style="color: darkblue"> Username : </label>
            <input type="text" name="Username" required><br> <br/>
            <label style="color: darkblue"> Email : </label>
            <input type="text" name="Email" required><br><br>
            <label style="color: darkblue"> Password : </label>
            <input type="password" name="Password" required><br><br>
            <label style="color: darkblue"> Confirm Password : </label>
            <input type="password" name="ConfirmPassword" required><br><br>

            <button style="margin:5px;color: midnightblue; cursor: pointer; background-color: powderblue;" type="submit"
                    value="REGISTER">REGISTER
            </button>

        </form>
        <form action="index.jsp" method="get">
            <button style="margin:5px;color: midnightblue; cursor: pointer; background-color: powderblue;" type="submit"
                                   value="CANCEL" href="index.jsp">CANCEL
            </button>
        </form>
    </div>
</center>
</body>
</html>
