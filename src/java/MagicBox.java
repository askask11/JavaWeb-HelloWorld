/*Editor: Johnson Gao
 * Date This Project Created: Jan 15 2020
 * Description Of This Class:This is the core servlet of the application, which processes HTTP requests.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.Clip;

/**
 * This is the core servlet class of this application.
 *
 * @author Jianqing Gao
 */
@WebServlet(name = "MagicBox",
        loadOnStartup = 1,
        urlPatterns =
        {
            //use get methods
            "/InputAdd",
            "/InputSubstract", "/InputMultiply", "/InputDevide",
            "/AddResult", "/SubstractResult", "/MultiplyResult", "/DevideResult", "/index","/newjsp"
        })
public class MagicBox extends HttpServlet
{

    //@Resource(name = "Main")
    //private javax.mail.Session main1;
    private boolean isAudioSet = false;

    private Clip clip;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //get http session
        HttpSession session = request.getSession();

        String userPath = request.getServletPath();

        if (!isAudioSet)
        {
            processAudio(session);
        }

        switch (userPath)
        {
            //if is one of them, go
            //those onc in the web-inf
            case "/InputAdd":
            case "/InputSubstract":
            case "/InputMultiply":
            case "/InputDevide":
                request.getRequestDispatcher("/WEB-INF" + userPath + ".jsp").forward(request, response);
                break;
            //not in WEB-INF
            case "/index":
                //processAudio(session);
                request.getRequestDispatcher(userPath + ".jsp").forward(request, response);
                break;
            case "/newjsp":
                request.getRequestDispatcher("/WEB-INF/" + userPath + ".jsp").forward(request, response);
                break;
            default:
                processRequest(request, response);
                System.out.println("GET : unexpected request : " + userPath);
                break;
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //get the destination session
        //HttpSession session = request.getSession();
        //get where the user wants to go
        String userPath = request.getServletPath();

        switch (userPath)
        {
            case "/AddResult":
                processAdd(request, response);
                break;
            case "/SubstractResult":
                processSubstract(request, response);
                break;

            case "/MultiplyResult":
                processMultiply(request, response);
                break;

            case "/DevideResult":
                processDevide(request, response);
                break;

            default:
                processRequest(request, response);
                System.out.println("DO-POST Unexpected user path: " + userPath);
                break;
        }

    }

    /**
     * Servlet programm for procession division request.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void processDevide(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        //get variable
        HttpSession session = request.getSession();
        String userPath = request.getServletPath();
        String toBeDevided = request.getParameter("toBeDevided");
        String toDevide = request.getParameter("toDevide");
        String result = "";

        try
        {
            //try to calculate
            result = Double.toString(Division.devide(Double.parseDouble(toBeDevided), Double.parseDouble(toDevide)));
            session.setAttribute("message", "Congratulation!");
            session.setAttribute("result", result);
        } catch (NumberFormatException e)
        {

            //not enter a number
            session.setAttribute("message", "Please enter numbers only.");
            session.setAttribute("result", "N/A");
        } catch (ArithmeticException arithmeticException)
        {
            //entered a illegal thing
            session.setAttribute("message", "Please do follow math rule - ex: No devision by 0. Click \"Redo\" and do it again!");
            session.setAttribute("result", "N/A");
        }
        //forward request
        request.getRequestDispatcher("/WEB-INF/" + userPath + ".jsp").forward(request, response);

    }

    /**
     * Processes multiple request. Calculate and displays result for the user.
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void processMultiply(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        //variable declear
        HttpSession session = request.getSession();
        String userPath = request.getServletPath();
        String userInput = request.getParameter("multiply");
        double result;
        //calculate
        try
        {
            result = Multiply.multiply(userInput);
            session.setAttribute("result", Double.toString(result));
            session.setAttribute("message", "Congratulation!");
        } catch (NumberFormatException e)
        {
            session.setAttribute("message", "Please enter numbers, follow the designated format");
            session.setAttribute("result", " - ");
        } catch (Exception ex)
        {
            unexpectedError(ex, response);
        }

        //forward
        request.getRequestDispatcher("/WEB-INF/" + userPath + ".jsp").forward(request, response);

    }

    /**
     * Process add request for the user.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void processAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //get request parameter (numbers to add)

        HttpSession session = request.getSession();
        String numbersToAdd = request.getParameter("numberField");
        String userPath = request.getServletPath();

        double result;

        //try to add numbers together
        try
        {
            result = Adding.addMultiple(numbersToAdd);
            session.setAttribute("addResult", result);
            session.setAttribute("addMessage", "Add user! Congrats! Your result is: ");
        } catch (NumberFormatException e)
        {
            e.printStackTrace();
            session.setAttribute("addMessage", "There is an error, make sure you entered numbers and followed the format.");
            session.setAttribute("addResult", ":( idk");
            //  this.processRequest(request, response);
        } catch (Throwable ex)
        {
            unexpectedError(ex, response);
        }
        request.getRequestDispatcher("/WEB-INF/" + userPath + ".jsp").forward(request, response);
        //farward user (later on we can forward user to warning page/

    }

    /**
     * Process substract request for the user.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void processSubstract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //get HTTP information / declear variables
        HttpSession session = request.getSession();
        String userPath = request.getServletPath();
        String toBeSubstracted = request.getParameter("toBeSubstracted");
        String toSubstract = request.getParameter("toSubstract");

        double result;
        try
        {
            result = Substract.substract(toBeSubstracted, toSubstract);
            session.setAttribute("message", "Congratulation! Successfully calculated your result!");
            session.setAttribute("result", result);
        } catch (NumberFormatException nfe)
        {
            session.setAttribute("message", "Please make sure you entered a correct number.");
            session.setAttribute("result", " - - ");
        } catch (Throwable ex)
        {
            unexpectedError(ex, response);
        }

        request.getRequestDispatcher("/WEB-INF/" + userPath + ".jsp").forward(request, response);
    }

    /**
     * Invokes when there is an unexpected error.
     *
     * @param ex
     * @param response
     * @throws IOException
     */
    private void unexpectedError(Throwable ex, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>An Unexpected Error Happened</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Detail of the error: ");
            ex.printStackTrace(out);
            //out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("<form action=\"index\" method=\"GET\"><button type=\"submit\">return home</button></form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "This is the servlet of the application.";
    }// </editor-fold>

    private void processAudio(HttpSession session)
    {
        session.setAttribute("audioPlay", "<script>\n"
                + "var audio = document.getElementById('audio');\n"
                + "var storedMusic;\n"
                + "storedMusic = JSON.parse(window.localStorage.getItem('musicInfo'));\n"
                + "if(storedMusic !== null)\n"
                + "{\n"
                + "    try{\n"
                + "       //console.log(storedMusic);//\n"
                + "    audio.currentTime = storedMusic;\n"
                + "    }catch(e)\n"
                + "    {\n"
                + "    console.log(e);\n"
                + "    }\n"
                + "}\n"
                + "audio.play();\n"
                + "audio.onended=function(){audio.currentTime=0.0;audio.play();};\n"
                + "</script>");
        session.setAttribute("showPopupCode", "onmouseover=\"document.getElementById(\'audioAreaId\').classList.toggle(\'show\')\"");
        session.setAttribute("onunload", "onunload=\"window.localStorage.setItem('musicInfo', JSON.stringify(audio.currentTime));\"");
        session.setAttribute("musicSrc", "src=\"audio/halfprice.mp3\"");
        isAudioSet = true;
//        try
//        {
//            clip = AudioSystem.getClip();
//            clip.open(AudioSystem.getAudioInputStream(new URL("http://mytrips.villagechemcats.com/audios/senorita%20(mp3cut.net).wav")));
//            clip.start();
//        } catch (LineUnavailableException ex)
//        {
//            Logger.getLogger(MagicBox.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedAudioFileException ex)
//        {
//            Logger.getLogger(MagicBox.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex)
//        {
//            Logger.getLogger(MagicBox.class.getName()).log(Level.SEVERE, null, ex);
//        } 

    }

    /**
     * Test main method
     *
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Please open your netbean to test");
      
    }

    

}
