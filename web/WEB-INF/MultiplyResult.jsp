<%-- 
    Document   : MultiplyResult
    Created on : 2020-1-25, 18:09:56
    Author     : Johnson Gao
    Description : This page is for showing user's result of multiplication.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <title>Multiply Result</title>
    </head>
    <body class="resultBody" ${onunload}>
          <div class="popup" id="audioIcon">
            <img src="images/musicIcon.png" alt="music" ${showPopupCode}>
            <div class="popupArea" id="audioAreaId" title="click to close me">
                <audio id="audio" controls ${musicSrc}>Audio Area</audio>
            </div>
        </div>
            ${audioPlay}
    <center><h1><img src="images/multiply.svg" alt="X">Multiply Result<img src="images/multiply.svg" alt="X"></h1></center>
    <%--Show message and result--%>
    <!--Message / result-->
    <center><h5>${message}</h5></center>
    <center><h4>Result = ${result}</h4></center>
    <br>
    <!--Option to redo-->
    <form action="InputMultiply" method="GET">
        <center><button type="submit" class="arrowbutton"><img src="images/smrdflag.svg" alt="" /><span>Redo</span></button></center>
    </form>
    
    <!--Return to home-->
    <form action="index" method="GET">
        <center><button type="submit" class="arrowbutton"><img src="images/house32.svg" alt="" /><span>Return to home</span></button></center>
    </form>
    
    </body>
</html>
