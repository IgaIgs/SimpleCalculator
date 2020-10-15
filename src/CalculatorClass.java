public class CalculatorClass {

    public static void main(String[] args) {
        // testing the class
        System.out.println(calculations(90, 33, "8"));

    }

    public static double calculations(double n, double m, String operator){
        double result = 0;
        switch (operator){
            case "/":
                result = n / m;
                break;
            case "*":
                result = n * m;
                break;
            case "+":
                result = n + m;
                break;
            case "-":
                result = n - m;
                break;
            case "%":
                result = (n/100) * m;
                break;
        }
        return result;
    }
}
