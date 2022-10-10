<%@ page language="java" contentType="text/html; utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
</head>
<body>
<%
  String gender = (String)session.getAttribute("gender");
  String genderTitle = null;

  if (gender != null && gender.equalsIgnoreCase("female")) {
    genderTitle = "Ms/Mrs.";
  } else {
    genderTitle = "Mr.";
  }
%>
Welcome <%= genderTitle %> <%=session.getAttribute("userLastName") %>
<br>
Your resume has been added
<br>
<a href="/formResult">
  other results
</a>
</body>
</html>