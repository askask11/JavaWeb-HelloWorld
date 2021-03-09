<%-- 
    Document   : InputSubstract
    Created on : 2020-1-21, 21:34:01
    Author     : Jianqing Gao
    Description : This page is created for receiving user's substract param.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <title>Substract</title>
    </head>
    <body class="inputBody" ${onunload}>
        <div class="popup" id="audioIcon">
            <img src="images/musicIcon.png" alt="music" ${showPopupCode}>
            <div class="popupArea" id="audioAreaId" title="click to close me">
                <audio id="audio" controls ${musicSrc}>Audio Area</audio>
            </div>
        </div>
            ${audioPlay}
    <h1 class="centerText">Substraction</h1>

    
        <form action="SubstractResult" method="POST">

            <div class="animated-text-input-container centralized">
                <input type="number" required title="" name="toBeSubstracted" />
                <label class="label-name"><span class="content-name">Number to be substracted</span></label>
            </div> - 
            
            <div class="animated-text-input-container centralized">
                <input type="number" required title="" name="toSubstract" />
                <label class="label-name"><span class="content-name">Number to substract</span></label>
            </div>
            <button type="submit" class="arrowbutton greenBg centralized block"><span>Go!</span></button>
        </form> 


    <form action="index" method="GET">
        <button type="submit" class="arrowbutton centralized block"> <%@include file="../images/smrdflag.svg" %><span>Go Home</span
        ></button>
    </form>
        
</body>
</html>
