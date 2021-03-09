/*Editor: Johnson Gao
 * Date This Project Created:Jan 25 2020
 * Description Of This Class:This class is responsible for division operation.
 */

/**
 * Dividing operation.
 * @author Jianqing Gao
 */
public class Division
{
    /**
     * Division class.
     */
    private Division(){}//no make object of this class
    
    /**
     * Dividing method.
     * @param toBeDevided
     * @param toDevide
     * @return result
     */
    public static double devide(double toBeDevided, double toDevide)
    {
        //devide stuff
        return (toBeDevided/toDevide);
    }
    
    /**
     * Main test method/
     * @param args 
     */
    public static void main(String[] args)
    {
        System.out.println(devide(1, 2));
    }
            
}
