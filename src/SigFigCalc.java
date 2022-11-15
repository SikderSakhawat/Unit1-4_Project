/** PRE-CONDITIONS
 * ALL real numbers are fair game (negatives, positives, rational numbers, etc.)
 * your number cannot be irrational (e.g. 2/3, pi, etc.)
 */
public class SigFigCalc {
    private String inputNum; // sets input from user input of a number
    // adds the number the user inputs as an attribute to the sigFigCalc object
    public SigFigCalc(String number){
        this.inputNum = number;
    }
    public SigFigCalc(String num1, String num2){}

    // We can count how many significant figures are found within the input number
    // This is kind of the "main" method that will determine the number of significant figures.
    public int countSigFigs(){
        double numAsInt = Double.parseDouble(inputNum);
        if(numAsInt < 1){ inputNum = "" + numAsInt * -1; } // for the case our number is negative
        String noDecNum = inputNum.substring(0, inputNum.indexOf(".")) + inputNum.substring(inputNum.indexOf(".") + 1); // takes out the decimal in our string
        if(containsDecimal(inputNum)){
            boolean findNonZero = false;
            int indexChecker = 0;
            while(!findNonZero){
                if((Integer.parseInt(String.valueOf(noDecNum.charAt(indexChecker))) > 0) && (indexChecker < noDecNum.length())){
                    noDecNum = noDecNum.substring(noDecNum.indexOf(indexChecker));
                    findNonZero = true;
                }
                indexChecker++;
            }
        }else{
            boolean findNonZero = false;
            int firstNonZeroNum = 0;
            int lastNonZeroNum = 0;
            int indexChecker = noDecNum.length();
            while(!findNonZero){
                if((Integer.parseInt(String.valueOf(noDecNum.charAt(indexChecker))) > 0) && (indexChecker >= 0)){
                    lastNonZeroNum = indexChecker;
                    findNonZero = true;
                }
                indexChecker--;
            }
            indexChecker = 0;
            while(!findNonZero){
                if((Integer.parseInt(String.valueOf(noDecNum.charAt(indexChecker))) > 0) && (indexChecker < noDecNum.length())){
                    firstNonZeroNum = indexChecker;
                    findNonZero = true;
                }
                indexChecker++;
            }
            noDecNum.substring(firstNonZeroNum, lastNonZeroNum + 1);// count sigfigs but reject the trailing zeros
        }
        return noDecNum.length();
    }

    public boolean containsDecimal(String num) {
        String indexChecker = "";
        for (int i = 0; i <= num.length() - 1; i++) {
            indexChecker = "" + num.charAt(i);
            if(indexChecker == "."){
                return true;
            }
        }
        return false;
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
