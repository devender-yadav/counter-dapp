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
      <h4>Please provide your Ethereum wallet details to continue.</h4>
      <br>
      <form id=uploadContract action="searchcounter.do"
         class="form-horizontal well " method="post"
         enctype="multipart/form-data">
         <div class="form-group">
            <input class="form-control" name="password" placeholder="password"
               type="password" required>
         </div>
         <div class="form-group">
            <input name="wallet" type="file">
            <p class="help-block">Browse Ethereum wallet file</p>
         </div>
         <div class="form-group">
            <input class="form-control" name="contractAddress" placeholder="contract address"
               type="text" required>
         </div>
         <div class="form-group">
            <button class="btn btn-info btn-lg" type="submit">Search Counter</button>
         </div>
      </form>
      <!-- Latest compiled and minified JavaScript -->
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
   </body>
</html>
