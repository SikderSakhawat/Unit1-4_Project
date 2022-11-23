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
        int numAsInt = 0;
        double numAsDouble = 0;
        String numStr = "";
        String noDecNum = "";
        // variables above initialize what is needed to have the rest of the method to run
        if(Double.parseDouble(inputNum) % 1 == 0) {
            numAsInt = (int) Math.abs(Double.parseDouble(inputNum));
            numStr += numAsInt;
            noDecNum = "" + numAsInt;
        } else {
            numAsDouble = Math.abs(Double.parseDouble(inputNum));
            numStr+= numAsDouble;
            int whereDecPoint = numStr.indexOf(".");
            noDecNum = numStr.substring(0, whereDecPoint) + numStr.substring(whereDecPoint + 1);
        }
        if(Double.parseDouble(inputNum) == 0){
            return 0;
        } else if (inputNum.contains(".")){
            int firstSigNum = 0;
            int indexChecker = 0;
            boolean findNonZero = false;
            if(inputNum.contains(".")){
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
