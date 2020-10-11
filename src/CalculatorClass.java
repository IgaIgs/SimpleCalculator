public class CalculatorClass {

    public static void main(String[] args) {
        System.out.println(calculations(50, 4, '%'));

    }

    public static long calculations(long n, long m, char operation){
        long result = 0;
        switch (operation){
            case '/':
                // this won't work properly cuz the result is a long - just pitching ideas
                double nn = ((double) n);
                double mm = ((double)m);
                result = (long) (nn/mm);
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
                // same as in the case of division
                result = (n/100) * m;
                break;
        }

        return result;
    }
}
