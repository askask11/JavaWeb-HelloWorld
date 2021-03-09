/*Editor: Johnson Gao
 * Date This Project Created:
 * Description Of This Class:
 */

/**
 *
 * @author Johnson Gao
 */
public class Substract
{
    /**
     * Class that is responsible for subracting numbers.
     */
    private Substract(){}//don't let anyone instantiate this class
    
    
    /**
     * Subract one number from another number<br>
     * Ex.a-b=c;.
     * @param biggerOne A
     * @param toSubstract B
     * @return C
     * @throws NumberFormatException 
     */
    public static double substract(String biggerOne, String toSubstract) throws NumberFormatException
    {
        //receive parameter
        double orginalNumber = Double.parseDouble(biggerOne);
        double allToBeSubracted = Adding.addMultiple(toSubstract);
        
        //calculaton
        double result = substract(orginalNumber, allToBeSubracted);
        
        //return 
        
        return result;
        
    }
    
    private static double substract(double big, double small)
    {
        //declear variable
        double result;
        
        //calculaton
        result = big-small;
        
        //return result
        return result;
        
    }
    
    public static void main(String[] args)
    {
        System.out.println(substract("12", "1"));
    }
    
}
