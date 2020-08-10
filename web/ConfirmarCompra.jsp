<html>

<title>Confirm</title>

<body>


<%!
    String t1;

%>
<%
    t1=request.getParameter("Amount");
%>

<h2>Confirm buy</h2>


   <table border="1" align="center">
       <tr>
          <th>Route </th>
          <th>Price</th>
          <th>Amount</th>

       </tr>
            <tr>
                <td><%=t1%></td>
            </tr>

       <h1><%=t1%></h1>


   </table>


</body>



</html>