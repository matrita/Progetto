<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import = "mvc.controller.*"%>
<%@ page import = "mvc.model.*"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
   <head>
      <style>
         H2 {text-align: center; color: red;}
         body {text-align:center; background-color: lime;}
      </style>
      <meta charset="ISO-8859-1">
      <title>Insert title here</title>
   </head>
   <H2> Anagrafiche </H2>
   <body>
      <% 
         ArrayList<Anagrafica> anagrafiche = (ArrayList<Anagrafica>) request.getAttribute("anagrafiche"); 
         %>
      <%
         out.println("<center>"); 
         out.println("<table border = 1>");
         for(int i=0;i<anagrafiche.size();i++)
         
          out.println("<tr><td>" + anagrafiche.get(i).toString()+ 
         	  "<td> <a href='RichModifica.jsp'>Edit</a> </td>" + 
                  "<td><a href='RichCancellazione.jsp'>Delete</a></td>" +"</td></tr>");
             out.println("</table>");
         
         %>
      <a href="./MenuSemplice.jsp">Torna al Menù</a><br><br>
   </body>
</html>