<%-- 
    Document   : MultiplyInput
    Created on : 2020-1-25, 13:08:08
    Author     : Jianqing Gao
    Description : This page is for receiving user's input numbers for multiply.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <title>Multiply Input</title>
    </head>
    <body class="inputBody" ${onunload}>
        <div class="popup" id="audioIcon">
            <img src="images/musicIcon.png" alt="music" ${showPopupCode}>
            <div class="popupArea" id="audioAreaId" title="click to close me">
                <audio id="audio" controls ${musicSrc}>Audio Area</audio>
            </div>
        </div>
            ${audioPlay}
    <h1 class="centerText"><img src="images/multiply.svg" alt="">Multiply<img src="images/multiply.svg" alt=""> </h1>
    <div class="centralized centerText">Please enter numbers to multiply, use "," to split them. <br>
    Ex. input = 2,2 -(2x2)-> result = 4</div>
    <form action="MultiplyResult" method="POST">

        <div class="animated-text-input-container centralized">
            <input type="text" required title="multiply" name="multiply" />
            <label class="label-name"><span class="content-name">Numbers to multiply</span></label>
        </div> 
        
        <div class="animated-text-input-container centralized" >
            <input type="text" required title="feeling" name="feeling" />
            <label class="label-name"><span class="content-name">How are you?</span></label>
        </div>
        
        
        <button type="submit" class="arrowbutton greenBg centralized block"><img src="images/calculator32.svg" alt=""><span>Calculate</span></button>
    </form>
    <br>
    <form action="index" method="GET">
        <button type="submit" class="arrowbutton centralized block"><%@include file="../images/house32.svg" %><span>Return To Index</span></button>
    </form>
</body>
</html>
