public class CalculatorClass {

    public static void main(String[] args) {
        System.out.println(calculations(90, 33, '8'));

    }

    public static double calculations(double n, double m, char operation){
        double result = 0;
        switch (operation){
            case '/':
                result = n / m;
                break;
            case '*':
                result = n * m;
                break;
            case '+':
                result = n + m;
                break;
            case '-':
                result = n - m;
                break;
            case '%':
                result = (n/100) * m;
                break;
            default:
                System.out.println("This is not a valid operation. " +
                        "Please choose one of the following:'+','-','/','*' or '%'. ");
                break;
        }
        return Math.round(result * 1000.0) / 1000.0;
    }
}
