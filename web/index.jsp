<%-- 
    Document   : index
    Created on : 2020-1-15, 12:30:22
    Author     : Jianqing Gao
    Description : This is the index page of the web application.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <title>JSP Page</title>
        
    </head>
    <body class="indexBody" ${onunload} >

        <%--<img src="images/smrdflag.svg" alt="flag"><img src="images/smrdflag.svg" alt="flag"></center></h4>--%>
        <!--Audio Player-->
        <div class="popup" id="audioIcon">
            <img src="images/musicIcon.png" alt="music" ${showPopupCode}>
            <div class="popupArea indexVoice" id="audioAreaId" title="click to close me">
                <audio id="audio" controls ${musicSrc}>Audio Area</audio>
            </div>
        </div>


        <table class="centralized" id="mainSelectionTable">
            <tr>
                <td>
                    <form action="InputAdd" method="GET">
                        <button type="submit" class="arrowbutton pinkBg"><span><img src="images/add.svg" alt="add"></span></button>
                    </form>
                </td>

                <td>
                    <form action="InputMultiply" method="GET">
                        <button type="submit" class="arrowbutton pinkBg"><span><img src="images/multiply.svg" alt="multiply"></span></button>
                    </form>
                </td>

                <td>
                    <form action="InputDevide" method="GET">
                        <button type="submit" class="arrowbutton pinkBg"><span><img src="images/devide.svg" alt="devide"></span></button>
                    </form>

                </td>

                <td>
                    <form action="InputSubstract" method="GET">
                        <button type="submit" class="arrowbutton pinkBg"><span><img src="images/-.svg" alt="minus"></span></button>
                    </form>
                </td>
            </tr>
        </table>
${audioPlay}


    </body>
</html>
