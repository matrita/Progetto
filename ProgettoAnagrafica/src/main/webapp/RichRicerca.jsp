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
      <form method="post" action="./ServletController?action=3">
         Digita la matricola dell'utente che vuoi ricercare:
         <INPUT TYPE="text" NAME="matricola" SIZE="20"><BR>
         <INPUT TYPE="submit" VALUE="Cerca"> 
      </form>
   </body>
</html>