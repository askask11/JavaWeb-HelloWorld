<%-- 
    Document   : InputAdd
    Created on : 2020-1-15, 12:48:08
    Author     : Jianqing Gao
    Description : This page is for receiving inputs from the user.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <title>Add Input</title>
    </head>
    <body class="inputBody" ${onunload}>
        <div class="popup" id="audioIcon">
            <img src="images/musicIcon.png" alt="music" ${showPopupCode}>
            <div class="popupArea" id="audioAreaId" title="click to close me">
                <audio id="audio" controls ${musicSrc}>Audio Area</audio>
            </div>
        </div>
            ${audioPlay}
    <center><h1>
            Hello! Welcome to Add page</h1></center>

    <div class="centralized centerText">
    <img src="images/redstar.svg" alt="">Please input number in the form above, use "," to split them out, and we will add them up.
    <br>Example : input 1,1  --> result = 2 ; input = 1,1,1 result = 3;</div>
    <br>
    <!--Add form for user to input information-->
    <form action="AddResult" method="POST">

        <div class="animated-text-input-container centralized" >
            <input type="text" required title="Numbers to add" name="numberField" />
            <label class="label-name"><span class="content-name">Numbers to add</span></label>
        </div>
        
        <div class="animated-text-input-container centralized" >
            <input type="text" required title="feeling" name="feeling" />
            <label class="label-name"><span class="content-name">How are you feeling today?</span></label>
        </div>
        
        <br>
        <button type="submit" class="arrowbutton  block centralized greenBg"><img src="images/add.svg" alt="add"><span>Add Them Up!</span></button>

    </form>
    
    <br>

    <form action="index" method="GET" >
        <button type="submit" class="centralized arrowbutton block"><span>Return Home</span></button>
    </form>

</body>
</html>
