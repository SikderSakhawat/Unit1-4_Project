import java.util.Scanner;
public class FindOrCompNumOfSigFig {
    public static void main(String[] args) {
        SigFigCalc n = new SigFigCalc("-0.56");
        int food = n.countSigFigs();
        System.out.println(food);
    }
}

