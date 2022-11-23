import java.util.Objects;
/** PRE-CONDITIONS
 * ALL real numbers are fair game (negatives, positives, rational numbers, etc.)
 * your number cannot be irrational (e.g. 2/3, pi, etc.)
 * ALL numbers cannot exceed the max number of integers or doubles; it will produce only the max number of significant figures in that case
 */
public class SigFigCalc {
    private String inputNum; // sets input from user input of a number
    // adds the number the user inputs as an attribute to the sigFigCalc object

    /**
     * used to instantiate the input num attribute to my object
     * @param number represents the number that the user chooses to find the number of significant figures for that number.
     */
    public SigFigCalc(String number){
        this.inputNum = number;
    }
    /**
     * An object used to model two numbers that will be compared to each other to figure out which number is more precise based on the number
     of significant figures it has
     * @param num1 represents one number that will be compared
     * @param num2 represents the other number that is being compared to num1
     */
    public SigFigCalc(String num1, String num2){}
    /**
     * Essentially just counts the number of significant figures a given number has, regardless of whther it is negative, positive, or rational.
     * Only limitations it has is when it exceeds Java's max integer/double values.
     * @param inputNumber this depicts the number that the user inputs in  order to figure out the number of significant figures it contains.
     * @return returns an integer with the number of significant figures. Cannot be a negative number.
     */
    public int countSigFigs(String inputNumber){
        int numAsInt;
        double numAsDouble;
        String numStr = "";
        String noDecNum;
        // variables above initialize what is needed to have the rest of the method to run
        if(Double.parseDouble(inputNumber) % 1 == 0) {
            numAsInt = (int) Math.abs(Double.parseDouble(inputNumber));
            noDecNum = "" + numAsInt;
        } else {
            numAsDouble = Math.abs(Double.parseDouble(inputNumber));
            numStr+= numAsDouble;
            int whereDecPoint = numStr.indexOf(".");
            noDecNum = numStr.substring(0, whereDecPoint) + numStr.substring(whereDecPoint + 1);
        }
        if(Double.parseDouble(inputNumber) == 0){
            return 0;
        } else if (inputNumber.contains(".")){
            int firstSigNum = 0;
            int indexChecker = 0;
            boolean findNonZero = false;
            if(inputNumber.contains(".")){
                while(!findNonZero && indexChecker <= noDecNum.length()){
                    if(Integer.parseInt(noDecNum.substring(indexChecker, indexChecker + 1)) > 0){
                        firstSigNum = indexChecker;
                        findNonZero = true;
                    }
                    indexChecker++;
                }
                noDecNum = noDecNum.substring(firstSigNum);
            } else {
                int lastSigNum = 0;
                while(!findNonZero && indexChecker <= noDecNum.length()){
                    if(Integer.parseInt(noDecNum.substring(indexChecker, indexChecker + 1)) > 0){
                        firstSigNum = indexChecker;
                        findNonZero = true;
                    }
                    indexChecker++;
                }
                indexChecker = noDecNum.length();
                findNonZero = false;
                while(!findNonZero && indexChecker < 0){
                    if(Integer.parseInt(noDecNum.substring(indexChecker, indexChecker + 1)) > 0){
                        lastSigNum = indexChecker;
                        findNonZero = true;
                    }
                    indexChecker--;
                }
                noDecNum = noDecNum.substring(firstSigNum, lastSigNum + 1);
            }
        }
        return noDecNum.length();
    }

    /**
     * used to compare two numbers and see which has more significant numbers. Print statement depends on which is more "precise".
     * @param num1 one of the numbers being compared to
     * @param num2 the other number being compared to
     */
    public void morePreciseNum(String num1, String num2){
        int numSigFig1 = countSigFigs(num1);
        int numSigFig2 = countSigFigs(num2);
        if(numSigFig1 > numSigFig2){
            System.out.println(num1 + " is more precise than " + num2 + "!");
        } else if(numSigFig1 < numSigFig2){
            System.out.println(num2 + " is more precise than " + num1 + "!");
        } else {
            System.out.println("Both numbers are equally as precise!");
        }
    }

    /**
     * Determines if the inputNum has the same number of significant figures as stated in the numSigFig parameter
     * @param numSigFig determines how many significant figures a number should be rounded to
     * @param inputNum determines the number that will be checked
     * @return returns true if inputNum has numSigFig significant figures. Returns false otherwise.
     */
     public boolean equalToNumSigFig(int numSigFig, String inputNum){
        if(countSigFigs(inputNum) == numSigFig){
            return true;
        }
        return false;
     }

    /**
     * Explains the rules of significant figures to the user.
     * @return Returns the rules of significant figures to the player, if they need a refresher for what a significant figure is (Mainly Mr. Das)
     */
    public String toString(){
        return """
                To determine the number of significant figures in a number use the following three rules:\s
                1. Non-zero numbers are always significant.
                2. Any zeros between two significant digits are significant
                3. A final zero or trailing zeros are ONLY significant in decimals.""";
    }
}