import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        while (true)
        {
            int input = Helper.takeInput(0,9);
            if (input == 5 || input ==6 )Helper.doMath(input, -1);
            else Helper.doMath(input, Helper.enterNumber());
        }

    }


}
