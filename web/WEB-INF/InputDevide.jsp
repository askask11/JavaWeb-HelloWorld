<%-- 
    Document   : InputDevide
    Created on : 2020-1-25, 18:40:44
    Author     : Jianqing Gao
    Description : This page is created for receiving user's input for division.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <title>Input for division</title>
    </head>
    <body class="inputBody" ${onunload}>
        <div class="popup" id="audioIcon">
            <img src="images/musicIcon.png" alt="music" ${showPopupCode}>
            <div class="popupArea" id="audioAreaId" title="click to close me">
                <audio id="audio" controls ${musicSrc}>Audio Area</audio>
            </div>
        </div>
            ${audioPlay}
        <!--Title-->
   <h1 class="centerText"><img src="images/devide.svg" alt="">Devision input</h1><img src="images/devide.svg" alt="">

    <!--Input area-->
    <div class="centralized">
        <form action="DevideResult" method="POST">
            <div class="animated-text-input-container centralized">
                <input type="number" required title="To Be Divided" name="toBeDevided" />
                <label class="label-name"><span class="content-name">Numerator</span></label>
            </div> 
            <strong>/</strong> 
            <div class="animated-text-input-container centralized">
                <input type="number" required title="To divide" name="toDevide" />
                <label class="label-name"><span class="content-name">Denominator</span></label>
            </div>
            <br>
            <button type="submit" class="arrowbutton centralized block greenBg"><span>Calculate</span></button>
        </form>
    </div>


    <br>
    <!--Return Home-->
    <form action="index" method="GET">
        <button type="submit" class="arrowbutton centralized block"><img src="images/house32.svg"><span>Home</span></button>
    </form>


</body>
</html>
