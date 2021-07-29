import java.util.Scanner;

public class Helper {

    private static Scanner s = new Scanner(System.in);

    public static int takeInput(int start, int end)
    {
        int choice = start - 1;

        do {
            System.out.print("Şu anki sayı: ");
            Calculator.show();
            System.out.println("0 - Sayı gir\n1 - Toplama\n2 - Çıkarma\n3 - Çarpma\n4 - Bölme\n5 - İntegral\n6 - Türev\n7 - Faktoriyel\n8 - Mod\n9 - Mutlak Değer");
            System.out.print("Yapmak istediğiniz işlemi seçin: ");
            try {
                choice = s.nextInt();
            } catch (Exception ignore) {
                s.next();
            }
        } while (choice < start || choice > end);

        return choice;
    }

    public static double enterNumber()
    {
        Double enter = null;
        do {
            try {
                enter = s.nextDouble();
            } catch (Exception ignore) {
                System.out.println("Hatalı giriş!");
                s.next();
            }
        } while (enter == null);

        return enter;
    }

    public static double[] takeDerivativeInput()
    {

        int choice = 0;

        do {
            System.out.print("Denklemin kaçıncı derece olduğunu giriniz: ");
            try {
                choice = s.nextInt();
            } catch (Exception ignore) {
                s.next();
            }
        } while (choice <= 0);

        int k = choice;



        double[] coefficients = new double[choice + 1];

        for (int i = 0; i <= choice;i++)
        {
            Double coefficient = null;
            do {
                System.out.print(choice - i + ". dereceden bilinmeyenin katsayısını giriniz: ");
                try {
                    coefficient = s.nextDouble();
                    coefficients[i] = coefficient;
                    k--;
                } catch (Exception ignore) {
                    s.next();
                }
            } while (coefficient == null);
        }
        return coefficients;
    }

    public static void doMath(int transaction, double number)
    {
        switch(transaction)
        {
            case 0 -> {
                Calculator.setCurrent(number);
            }
            case 1 -> {
                Calculator.add(number);
            }
            case 2 -> {
                Calculator.extract(number);
            }
            case 3 -> {
                Calculator.multiply(number);
            }
            case 4 -> {
                Calculator.divide(number);
            }
            case 5 -> {
                double[] array = takeDerivativeInput();
                Calculator.integral(array.length - 1,array);
            }
            case 6 -> {
                double[] array = takeDerivativeInput();
                Calculator.derivative(array.length - 1,array);
            }
            case 7 -> {
                Calculator.factorial(number);
            }
            case 8 -> {
                Calculator.modulus(number);
            }
            case 9 -> {
                Calculator.abs(number);
            }
        }
    }
}
