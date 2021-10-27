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
         String nome = (String) request.getParameter("nome");
         String cognome = (String) request.getParameter("cognome");
         String matricola = (String) request.getParameter("matricola");
         
         String s = (String) request.getAttribute("s");
         
         out.println("<center>");
         out.println("<h1>");
         out.println("E' stata inserita la seguente anagrafica: ");
         out.println("<br>");
         out.println(nome);
         out.println("<br>");
         out.println(cognome);
         out.println("<br>");
         out.println(matricola);
         out.println("<br>");
         out.println("</h1>");
         out.println("</center>");
         out.println("<a href='MenuSemplice.jsp'>Torna al Menù</a><br><br>");
         %>  
   </body>
</html>