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
      <form method="POST" action="./ServletController?action=1">
         Nome: <INPUT TYPE="text" NAME="nome" SIZE="20"><BR>
         Cognome: <INPUT TYPE="text" NAME="cognome" SIZE="20"><BR>
         Matricola: <INPUT TYPE="text" NAME="matricola" SIZE="20"><BR>
         <INPUT TYPE="submit" VALUE="Inserimento"> 
      </form>
   </body>
</html>