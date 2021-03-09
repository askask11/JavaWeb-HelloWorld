<%-- 
    Document   : AddResult
    Created on : 2020-1-15, 12:53:54
    Author     : Johnson Gao
    Description : This is responsible for showing user the result of adding together some numbers.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <title>Result Add</title>
    </head>
    
    <body class="resultBody" ${onunload}>
        
          <div class="popup" id="audioIcon">
            <img src="images/musicIcon.png" alt="music" ${showPopupCode}>
            <div class="popupArea" id="audioAreaId" title="click to close me">
                <audio id="audio" controls ${musicSrc}>Audio Area</audio>
            </div>
        </div>
            ${audioPlay}
            
    <center> <h1><img src="images/add.svg" alt="add">Result<img src="images/add.svg" alt="add"></h1></center>
    <center><h2><!--<img src="../images/smheart.svg">Add user! Congrats! Your result is: -->${addMessage}</h2></center>
        <center><h1>${addResult}</h1></center>
        <form action="index" method="GET">
            <button type="submit" class="arrowbutton"><span>Back to index</span></button>
        </form>

        <form action="InputAdd" method="GET">
            <button type="submit" class="arrowbutton"><span>Redo</span></button>
        </form>

    </body>
</html>
