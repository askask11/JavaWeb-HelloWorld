/*Editor: Johnson Gao
 * Date This Project Created:Jan 25 2020
 * Description Of This Class: This class is for adding numbers together.
 */

/**
 * This class is for adding numbers together.
 * @author Jianqing Gao
 */
public class Adding
{
    private Adding()
    {
        
    }
    
    /**
     * Add multiple numbers together.
     * @param params
     * @return result
     */
    public static double addMultiple(String params)
    {
        //declear
        params = params.trim();
        String[] numbersString = params.split(",");
        double sum = 0.0;
        
        //get sum
        for (String numbersString1 : numbersString)
        {
            sum += Double.parseDouble(numbersString1);
        }
        
        return sum;
    }
    
    /**
     * Test main method.
     * @param args 
     */
    public static void main(String[] args)
    {
        System.out.println("result = " + addMultiple("1,1,1,2,3,4,5,,,,"));
    }
    
    
    
}
