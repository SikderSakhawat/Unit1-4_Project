/** PRE-CONDITIONS
 * ALL real numbers are fair game (negatives, positives, rational numbers, etc.)
 * your number cannot be irrational (e.g. 2/3, pi, etc.)
 */
public class SigFigCalc {
    private double input; // sets input from user input of a number

    // adds the number the user inputs as an attribute to the sigFigCalc object
    public SigFigCalc(double number){
        input = number;
    }

    // Based on the number given, we will find out if the number has trailing zeros
    /** CONDITIONS
     * The first number has to be significant (over 0)
     * every digit afterwards must be 0 */
    public boolean trailingZeros(double number){
        String str = "" + number;
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(1) == 0){
                return false;
            } else if()
        }

    }

    public boolean leadingZeros(double number){
        String str = "" + number;
        if(str.indexOf("1") != )
    }
    // Based on the number given, if a 0 exists in the number, and it is between significant numbers, it returns true
    /** CONDITIONS
     * The first and last numbers given must be significant
     * If there are multiple zeros between significant numbers (e.g. 10001), it returns true
     * if there are multiple separate zeros between significant numbers (e.g. 1010101), it returns true */
    public boolean betweenSigNum(double number){

    }

    // Using the booleans above, we can count how many significant figures are found within the input number
    // This is kind of the "main" method that will determine the number of significant figures, the other booleans are there as a helper class of sorts.
    public int countSigFigs(){

    }

    public String toString(){
        String rules = "To determine the number of significant figures in a number use the following three rules: \n" +
                "1. Non-zero numbers are always significant.\n" +
                "2. Any zeros between two significant digits are significant\n" +
                "3. A final zero or trailing zeros are ONLY significant in decimals.";
        return rules;
    }
}
