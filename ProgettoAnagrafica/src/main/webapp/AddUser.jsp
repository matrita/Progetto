<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<HTML>
   <head>
      <style>
         body {text-align:center; background-color: lime;}
         .center {margin-left: auto; margin-right: auto;}
      </style>
   <body>
      <a href="./ServletController?action=2">View All Records</a><br/>
      <h1>Add New User</h1>
      <form method="POST" action="./ServletController?action=1">
         <table class="center">
            <tr>
               <td>Nome:</td>
               <td><input type="text" name="nome"/></td>
            </tr>
            <tr>
               <td>Cognome:</td>
               <td><input type="text" name="cognome"/></td>
            </tr>
            <tr>
               <td>Matricola:</td>
               <td><input type="text" name="matricola"/></td>
            </tr>
            <tr>
               <td colspan="2"><input type="submit" value="Add User"/></td>
            </tr>
         </table>
      </form>
   </body>
   </head>
</HTML>