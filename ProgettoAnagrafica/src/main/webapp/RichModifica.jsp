<!DOCTYPE html>
<html>
   <head>
      <style>
         body {text-align:center; background-color: lime;}
         .center {margin-left: auto; margin-right: auto;}
      </style>
      <meta charset="ISO-8859-1" />
      <title>Insert title here</title>
   </head>
   <body>
      <form method="post" action="./ServletController?action=4">
         Digita la matricola dell'utente che vuoi modificare:<BR>
       <table class="center">
       <tr>
               <td>Matricola:</td>
               <td><input type="text" name="matricola"/></td>
            </tr>
            <tr>
               <td>Digita i dati del nuovo utente</td>
            </tr>
            <tr>
               <td>Nome:</td>
               <td><input type="text" name="nome"/></td>
            </tr>
            <tr>
               <td>Cognome:</td>
               <td><input type="text" name="cognome"/></td>
            </tr>
            <tr>
               <td colspan="2"><input type="submit" value="Add User"/></td>
            </tr>
         </table>
      </form>
   </body>
</html>