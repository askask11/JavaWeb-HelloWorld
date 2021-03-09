
import java.util.Scanner;

/*Editor: Johnson Gao
 * Date This Project Created:
 * Description Of This Class: This class is for multiplying numbers
 */

/**
 *This class is responsible for multiply process.
 * @author Johnson Gao
 */
public class Multiply
{
    /**
     * Multiply multiple numbers.
     */
    private Multiply(){}//no make object of this class
    
    /**
     * Multiply numbers together ex : 1,2,3 -> 1*2*3 -> 6;
     * @param userInput Number to multiply splited by "*" sign
     * @return The result.
     */
    public static double multiply(String userInput)
    {
        //get splited
        String[] numbersStrings = userInput.split(",");
        
        double result = 1.0;
       // double[] numbers = new double[numbersStrings.length];
       
       ///multiply all numbers together
        for (String numbersString : numbersStrings)
        {
            double number = Double.parseDouble(numbersString);
            result *= number;
        }
        
        //return
        return result;
    }
    
    public static void main(String[] args)
    {
        //variable declear
        Scanner keyboard = new Scanner(System.in);
        String input;
        //prompt input
        System.out.println("Please enter numbers splited bu symble ,");
        //receive input
        input = keyboard.nextLine();
        System.out.println("Multiply.main()");
        System.out.println("result="+multiply(input));
    }
}
