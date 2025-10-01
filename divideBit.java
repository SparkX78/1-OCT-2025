class divideBit {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        while (a >= b) {
            long temp = b;
            int multiply = 1;

            while (a >= (temp << 1)) {
                temp <<= 1;
                multiply <<= 1;
            }

            a -= temp;
            result += multiply;
        }

        result = negative ? -result : result;
        return result;
    }

    public static void main(String[] args) {
        int dividend = 43;
        int divisor = -5;
        System.out.println(divide(dividend, divisor)); 
    }
}