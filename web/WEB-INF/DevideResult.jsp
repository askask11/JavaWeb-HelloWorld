<%-- 
    Document   : DevideResult
    Created on : 2020-1-25, 18:49:08
    Author     : Johnson Gao
    Description : This page is for showing user the result of dividing operation.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <title>Division Result</title>
    </head>
    <body class="resultBody" ${onunload}>
          <div class="popup" id="audioIcon">
            <img src="images/musicIcon.png" alt="music" ${showPopupCode}>
            <div class="popupArea" id="audioAreaId" title="click to close me">
                <audio id="audio" controls ${musicSrc}>Audio Area</audio>
            </div>
        </div>
            ${audioPlay}
    <center><h1>Division Result</h1></center>
    <center><h5>${message}</h5></center>
    <center><h4>Result = ${result}</h4></center>
    <br>
    <form action="InputDevide" method="GET">
        <button type="submit" class="arrowbutton"><img src="images/redstar.svg" alt=""><span>Redo</span></button>
    </form>
    <br>
    <form action="index" method="GET">
        <button type="submit" class="arrowbutton"><img src="images/house32.svg"><span>Home</span></button>
    </form>
</body>
</html>
