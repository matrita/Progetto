<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      <style>
         body {text-align:center; background-color: lime;}
      </style>
      <meta charset="ISO-8859-1">
      <title>Insert title here</title>
   </head>
   <body>
      <%
         String esiste = (String) request.getParameter("esiste");
         String matricola = (String) request.getParameter("matricola");
         
         if (esiste.equals("si")) {
             out.println("<center>");
          out.println("<h1>");
          out.println("la matricola " + matricola +" è stata trovata" );
          out.println("<br>");
          out.println("</h1>");
          out.println("</center>");
         } else if (esiste.equals("no")){
         	out.println("<center>");
         	out.println("<h1>");
         	out.println("Matricola non trovata" );
         	out.println("<br>");
         	out.println("</h1>");
         	out.println("</center>");
         }
         %>
      <a href="./MenuSemplice.jsp">Torna al Menù</a><br><br>
   </body>
</html>