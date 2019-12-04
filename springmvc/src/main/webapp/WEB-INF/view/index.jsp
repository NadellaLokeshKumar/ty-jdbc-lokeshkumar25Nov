
<%
String s = (String)request.getAttribute("msg");   //instead of ModelMap, we can write like this also. But prefferd one is ModelMap.
%>


<html>
<body>
<h2 style="color:red">${msg}</h2>
<h2 style="color:green"><%=s%></h2>
<h2>${name}</h2>
<h2>${id}</h2>
</body>
</html>
