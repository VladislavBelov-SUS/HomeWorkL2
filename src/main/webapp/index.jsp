<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Form Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}
        form {border: 3px solid #f1f1f1;}

        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }

        .cancelbutton {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        .container {
            padding: 16px;
        }

        span.psw {
            float: right;
            padding-top: 16px;
        }
        .seldiv {
            background: #04AA6D;
            height: 50px;
            width:200px;
            border-radius: 15px;
            padding:20px;
            font-size:22px;
            color:#fff;
        }

        .optiondiv {
            background: #04AA6D;
            height: 100px;
            width:200px;
            border-radius: 15px;
            padding:20px;
            font-size:15px;
            color:#fff;
        }

        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }
            .cancelbutton {
                width: 100%;
            }
        }
    </style>
</head>

<body>
<form action="registerServlet" method="post">
    <div class="container">
        <label for="userFirstName"><b>First name</b></label>
        <input type="text" placeholder="Please enter your first name" name="userFirstName" id = "userFirstName" required>

        <label for="userLastName"><b>Last Name</b></label>
        <input type="text" placeholder="Please enter your last name" name="userLastName" id = "userLastName" required>

        <label for="userAge"><b>Your Age</b></label>
        <input type="text" placeholder="Please enter your age" name="userAge" id="userAge" required>
        <div class="seldiv">
            <label>Gender: </label>
            <select name = "gender" id="gender">
                <option value="male">Male</option>
                <option value="female">Female</option>
            </select>
        </div>

        <br>

        <div class="optiondiv">
            <p>Do you like this course?:</p>
            <input type="radio" id="yes" name="course" value="yes">
            <label for="yes">Yes</label><br>
            <input type="radio" id="no" name="course" value="no">
            <label for="no">No</label><br>
        </div>
        <button type="submit">Submit</button>
        <label>
            <input type="checkbox" checked="checked" name="rememberme"> Remember me
        </label>
    </div>
</form>
</body>
</html>