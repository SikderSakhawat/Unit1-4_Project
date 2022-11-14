import java.math.*;
/** PRE-CONDITIONS
 * ALL real numbers are fair game (negatives, positives, rational numbers, etc.)
 * your number cannot be irrational (e.g. 2/3, pi, etc.)
 */
public class SigFigCalc {
    private String input; // sets input from user input of a number

    // adds the number the user inputs as an attribute to the sigFigCalc object
    public SigFigCalc(String number){
        input = number;
    }


    // We can count how many significant figures are found within the input number
    // This is kind of the "main" method that will determine the number of significant figures.
    public int countSigFigs(String number){
        String noDecNum = number.substring(0, number.indexOf(".")) + number.substring(number.indexOf(".") + 1);
        int returnNum = 0;
        if(number.indexOf(".") > -1){
            boolean findNonZero = false;
            int indexChecker = 0;
            while(!findNonZero){
                if((noDecNum.indexOf(indexChecker) > 0) && (indexChecker < noDecNum.length())){
                    noDecNum = noDecNum.substring(noDecNum.indexOf(indexChecker));
                    findNonZero = true;
                }
                indexChecker++;
            }

        } else{
            // count sigfigs but reject the trailing zeros
        }
        return 1; // just something random to help model this thing out
    }
    public void giveAnswer(){

    }
    public String toString(){
        String rules = "To determine the number of significant figures in a number use the following three rules: \n" +
                "1. Non-zero numbers are always significant.\n" +
                "2. Any zeros between two significant digits are significant\n" +
                "3. A final zero or trailing zeros are ONLY significant in decimals.";
        return rules;
    }
}
