package polynomial;

/**
 * immutable class Poly which uses an array to represent single variable polynomial
 * @author Ishita_Mathur
 *
 */
public final class Poly 
{
    private int[][] polynomial;
    private static final int COEFFICIENT = 0;
    private static final int POWER = 1;
    private static final int COLUMN = 2;
    
    public int[][] getPolynomial() 
    {
        int[][] newPolynomial = new int[size()][COLUMN];
        
        for(int i = 0; i < size(); i++)
        {
            newPolynomial[i][COEFFICIENT] = polynomial[i][COEFFICIENT];
            newPolynomial[i][POWER] = polynomial[i][POWER];
        }
        
        return newPolynomial;
    }
    
    
    /**
     * constructor of the class
     * @param inputPolynomial a 2-d array having coefficients and corresponding powers,
     * assumes coefficient will be integer
     */
    public Poly(int[][] inputPolynomial)
    {
        int noOfRows, duplicateTerm;
    	if(inputPolynomial == null || inputPolynomial.length == 0)
    		throw new AssertionError("Invalid input");
    	 
    	 noOfRows = inputPolynomial.length;

         this.polynomial = new int[noOfRows][COLUMN];
        
    	 for(int i = 0; i < noOfRows; i++)
    	 {
    		 duplicateTerm = checkPower(polynomial, inputPolynomial[i][POWER]);
            
    		 if(duplicateTerm != -1)
    			 polynomial[duplicateTerm][COEFFICIENT] += inputPolynomial[i][COEFFICIENT];
    		 else
    		 {
    			 if(inputPolynomial[i][COEFFICIENT] != 0)
    			 {
    				 this.polynomial[i][COEFFICIENT] = inputPolynomial[i][COEFFICIENT];
    				 this.polynomial[i][POWER] = inputPolynomial[i][POWER];
    			 }
    		 }            
    	 }
    }
    
    
    /**
     * evaluates the value of the polynomial for the given value of the variable
     * @param value, value of variable
     * @return the result after evaluation, throws AssertionError if value is infinity
     */
    public double evaluate(float value)
    {
    	double result = 0;
        
        for(int i = 0; i < polynomial.length; i++)
        {
            result += polynomial[i][COEFFICIENT] * Math.pow(value, polynomial[i][POWER]);
        }
        
        if(result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY)
            throw new AssertionError("Result is too large");
        
        return result;
    }
    
    
    /**
     * computes the degree of the polynomial
     * @return degree of the polynomial
     */
    public int degree()
    {
        int degree = 0;
        
        for(int i = 0; i < polynomial.length; i++)
        {
            if(polynomial[i][POWER] > degree)
                degree = polynomial[i][POWER];
        }
        
        return degree;
    }
    
    
    /**
     * calculates the sum of the polynomials p1 and p2
     * @param firstPoly
     * @param secondPoly
     * @return the resulting polynomial after addition
     */
    public static Poly addPoly(Poly firstPoly, Poly secondPoly)
    {
        int maxDegree = (firstPoly.degree() > secondPoly.degree()) ? firstPoly.degree() : secondPoly.degree();
        int[][] addition = new int[maxDegree + 1][COLUMN];
        int term = 0, firstCoefficient, secondCoefficient;
        
        for(int i = 0; i <= maxDegree; i++)
        {
            firstCoefficient = firstPoly.getCoefficientOfX(i);
            secondCoefficient = secondPoly.getCoefficientOfX(i);
            
            if(firstCoefficient != 0 || secondCoefficient != 0)
            {
                addition[term][COEFFICIENT] = firstCoefficient + secondCoefficient;
                addition[term][POWER] = i;
                term++;
            }
                
        }
        
        return new Poly(addition);
    }
    
    
    /**
     * calculates the product of polynomials p1 and p2
     * @param firstPoly
     * @param secondPoly
     * @return the resulting polynomial after multiplication
     */
    public static Poly multiplyPoly(Poly firstPoly, Poly secondPoly)
    {
        int maxDegree = firstPoly.degree() + secondPoly.degree();
        int term = 0, powerTerm, duplicateTerm;
        int[][] multiplication = new int[maxDegree + 1][COLUMN];
        int[][] firstPolyArray = firstPoly.getPolynomial();
        int[][] secondPolyArray = secondPoly.getPolynomial();
        
        for(int i = 0; i < firstPolyArray.length; i++)
        {
            for(int j = 0; j < secondPolyArray.length; j++)
            {
                powerTerm = firstPolyArray[i][POWER] + secondPolyArray[j][POWER];
                duplicateTerm = checkPower(multiplication, powerTerm);
                
                if(duplicateTerm != -1)
                {
                    multiplication[duplicateTerm][COEFFICIENT] += firstPolyArray[i][COEFFICIENT] * secondPolyArray[j][COEFFICIENT];
                }
                else
                {
                    multiplication[term][COEFFICIENT] = firstPolyArray[i][COEFFICIENT] * secondPolyArray[j][COEFFICIENT];
                    multiplication[term][POWER] = powerTerm;
                    term++;
                }
            }
        }
        
        return new Poly(multiplication);
        
    }
    
    
    /**
     * helper method to get the coefficient for the given power of the polynomial
     * @param powerOfX
     * @return coefficientOfX
     */
    private int getCoefficientOfX(int powerOfX)
    {
        int coefficientOfX = 0;
        
        for(int i = 0; i < polynomial.length; i++)
        {
            if(polynomial[i][POWER] == powerOfX)
                coefficientOfX = polynomial[i][COEFFICIENT];
        }
        
        return coefficientOfX;
    }
    
    
    /**
     * helper method to check if a term with given power exists in the polynomial 
     * @param array, array representation of the polynomial
     * @param powerTerm
     * @return term index with same power (-1 if not found)
     */
    private static int checkPower(int[][] array, int powerTerm)
    {
        int duplicateTerm = -1;
        
        for(int i = 0; i < array.length; i++)
        {
            if(array[i][POWER] == powerTerm)
            {
                duplicateTerm = i;
                break;
            }
        }
        
        return duplicateTerm;
    }
    
    
    /**
     * helper method to find the length of the polynomial
     * @return
     */
    private int size()
    {
        int i = 0;
        
        while(i < polynomial.length && polynomial[i][COEFFICIENT] != 0)
            i++;
        
        return i;
    }
}
