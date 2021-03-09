<%-- 
    Document   : SubstractResult
    Created on : 2020-1-22, 18:15:05
    Author     : Jianqing Gao
    Description : Showing user's result of substraction.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <title>Substract Result</title>
    </head>
    <body class="resultBody" ${onunload}>
          <div class="popup" id="audioIcon">
            <img src="images/musicIcon.png" alt="music" ${showPopupCode}>
            <div class="popupArea" id="audioAreaId" title="click to close me">
                <audio id="audio" controls ${musicSrc}>Audio Area</audio>
            </div>
        </div>
            ${audioPlay}
    <center><h1><img src="images/-.svg" alt="">Result<img src="images/-.svg" alt=""></h1></center>
    <center><h4>${message}</h4></center>
    `   <!--Show user result-->
        <h3>Your answer is : ${result}</h3>
        <br>
        <!--Go to input substract-->
        <form action="InputSubstract" method="GET">
            <button type="submit" class="arrowbutton"><img src="images/redstar.svg"><span>Redo</span></button>
        </form>
        
        <!--Go to home index-->
        <form action="index" method="GET">
            <button type="submit" class="arrowbutton"><img src="images/house32.svg"><span>Return to home</span></button>
        </form>
        
    </body>
    
</html>
