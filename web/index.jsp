<%--
  Created by IntelliJ IDEA.
  User: Ehsan
  Date: 6/28/2020
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
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
            width: 500px;
            border: 8px solid midnightblue;
            padding: 40px;
            text-align: center;
        }

        .otherDiv {
            width: 200px;
            border: 2px solid dodgerblue;
            padding: 40px;
            text-align: center;
            align-items: center;
        }


    </style>

</head>

<title>service.Login Page</title>
<head>

</head>
<body style="background-color:powderblue;">
<center>
    <div>
        <form action="Login" method="post">
            <h1 style="text-align: center; color: darkblue">USER LOGIN</h1>
            <label style="color: darkblue">username :</label><br>
            <input type="text" name="username" required><br><br>
            <label style="color: darkblue"> password :</label><br>
            <input type="password" name="password" required><br><br>

            <button style="margin:5px; color: midnightblue; cursor: pointer; background-color: powderblue" type="submit"
                    value="LOGIN">LOGIN
            </button>

            <br/>
            <br/>
            <center>
                <div class="otherDiv">
                    <p style="color: darkblue ; margin:4px">You are not a member ? </p>

                    <button style="margin:5px; color: midnightblue; cursor: pointer; background-color: powderblue" onclick="document.location='Register.jsp'">REGISTER NOW</button>
                </div>

            </center>
        </form>
    </div>
    <form action="LogOut" method="get">
        <button style="margin:5px;color: midnightblue; cursor: pointer; background-color: powderblue;" type="submit"
                value="CANCEL" href="index.jsp">LOGOUT
        </button>
    </form>
    </div>

</center>
</body>
</html>
