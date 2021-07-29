public class Calculator {

    private static double current = 0;
    private static String display = "0";

    public static void divide(double number)
    {
        current /= number;
        display = String.valueOf(current);
    }

    public static void multiply(double number)
    {
        current *= number;
        display = String.valueOf(current);
    }

    public static void extract(double number)
    {
        current -= number;
        display = String.valueOf(current);
    }

    public static void add(double number)
    {
        current += number;
        display = String.valueOf(current);
    }

    public static void setCurrent(double number)
    {
        current = number;
        display = String.valueOf(current);
    }

    public static void derivative(int degree, double[] coefficients)
    {
        String str = "";
        String add = "";
        int j = 0;

        for (int i = degree; i > 0; i--)
        {
            double next = 0;
            if (coefficients[i] == 0) continue;
            if (i > 2)
            {
                add = Math.abs(coefficients[j] * i) + "x^" + (i - 1);
            }
            else if (i == 2)
            {
                add = Math.abs(coefficients[j] * i) + "x";
            }
            else
            {
                add = String.valueOf(Math.abs(coefficients[j] * i));
            }
            int k = 1;
            while (next == 0)
            {
                next = coefficients[j + k++];
            }
            if (j != degree - 1)
            {
                if (next > 0)
                {
                    add += " + ";
                }
                else
                {
                    add += " - ";
                }
            }
            str += add;
            j++;
        }

        display = str;
    }

    public static void integral(int degree, double[] coefficients)
    {
        String str = "";
        String add = "";
        int j = 0;

        for (int i = degree; i >= 0; i--)
        {
            double next = 0;
            if (coefficients[j] == 0)
            {
                j++;continue;
            }
            if (i > 0)
            {
                add = Math.abs(coefficients[j] / (i+1)) + "x^" + (i + 1);
            }
            else
            {
                add = Math.abs(coefficients[j] / (i+1)) + "x";
            }
                if (j < degree)
                {
                    if (coefficients[j + 1] > 0)
                    {
                        add += " + ";
                    }
                    else
                    {
                        add += " - ";
                    }
                }

            str += add;
            j++;
        }

        display = str + " + c";
    }

    public static void factorial(double number)
    {
        long result = 1;

        if (number < 0 || number % 1 != 0)
        {
            System.out.println("Faktoriyel alınamaz!");
            return;
        }

        for (int i = 2; i <= number;i++)
        {
            result *= i;
        }
        display = result + "";
    }

    public static void modulus(double mod)
    {
        current = current % mod;
        display = String.valueOf(current);
    }

    public static void abs(double number)
    {
        display = String.valueOf(Math.abs(number));
    }

    public static void reset()
    {
        current = 0;
        display = "0";
    }

    public static void show()
    {
        System.out.println(display);
    }
}
