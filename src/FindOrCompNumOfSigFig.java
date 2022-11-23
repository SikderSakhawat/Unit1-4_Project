import java.util.Scanner;
public class FindOrCompNumOfSigFig {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("----COMPARE OR FIND SIGNIFICANT FIGURES----");
        System.out.println(s.toString());
        System.out.println("Would you like to compare how precise two numbers are, or check the number of significant figures of a number?\n" +
                "(1 = comparing two values, 2 = counting the number of significant figures of a number)");
        String response = s.nextLine();
        if (response.equals("1")) {
            System.out.println("What is your first number?");
            String firstNum = s.nextLine();
            System.out.println("What is your second number?");
            String secondNum = s.nextLine();
            SigFigCalc compareNums = new SigFigCalc(firstNum, secondNum);
            compareNums.morePreciseNum(firstNum, secondNum);
        } else if (response.equals("2")) {
            System.out.println("Enter the number that you want to find the significant figures of:");
            String answer = s.nextLine();
            SigFigCalc checkNum = new SigFigCalc(answer);
            int numSigFigs = checkNum.countSigFigs(answer);
            System.out.println("Your number " + answer + " has " + numSigFigs + " significant figures. That is pretty precise!");
        } else {
            System.out.println("Please enter the correct number next time you use this. Goodbye.");
        }
        int randNum = (int) (Math.random() * 10) + 1;
        System.out.println("I'm not done with you yet! Can you give me a number with " + randNum + " significant figure(s)?");
        String guessAns = s.nextLine();
        SigFigCalc guessNum = new SigFigCalc(guessAns);
        if (guessNum.equalToNumSigFig(randNum, guessAns))
            System.out.println("Wow, you truly are a significant numbers master!");
        else {
            System.out.println("No you didn't get it right! :(");
        }
    }
}
