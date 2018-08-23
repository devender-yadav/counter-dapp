<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
      <title>Counter DApp</title>
      <!-- Latest compiled and minified CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
      <link href="https://afeld.github.io/emoji-css/emoji.css" rel="stylesheet">
   </head>
   <body>
      <div class="container">
      <%@include file="/views/jsp/header.jsp"%>
      <p><font color=green>${message}</font></p>
      <br>
      <h2>Counter value -  ${count}</h2>
      <br>
      <a class="btn btn-success btn-lg" href="./inccounter" role="button">Increase</a>
      <br> <br>
      <a class="btn btn-danger btn-lg" href="./deccounter" role="button">Decrease</a>
      <!-- Latest compiled and minified JavaScript -->
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
   </body>
</html>