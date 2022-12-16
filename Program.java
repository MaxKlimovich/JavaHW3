public class Program {
    public static void main(String[] args) {
        int a = 55;
        int b = 555;
        int c = 5;
        int d = 2;
        long[] result = allSteps(a, b, c, d);
        System.out.printf("a: %d b: %d c: %d d: %d -> %d; \n", a, b, c, d, result[b]);
        String result2 = commands(a, b, c, d);
        System.out.printf(result2);
    }

    static long[] allSteps(int a, int b, int c, int d) {
        long[] result = new long[b + 1];
        result[a] = 1;
        for (int i = a; i <= b; i++) {
            if ((i - d >= a)) {
                result[i] = result[i - d];
            }
            if ((i / c >= a) && (i % c == 0)) {
                result[i] += result[i / c];
            }
        }
        return result;
    }

    static String commands(int a, int b, int c, int d) {
        String steps = " -> " + b;
        int count = 0;
        while (a != b) {
            if (b % c == 0 && b / c >= a) {
                steps = " -> (a * c)" + steps;
                b = b / c;
                count++;
            } else if (b - d >= a) {
                steps = " -> (a + d)" + steps;
                b = b - d;
                count++;
            } else {
                steps = "Это сделать невозможно!";
                return steps;
            }
        }
        steps = "Минимально можно сделать за " + count + " шага(ов) " + steps;
        return steps;
    }
}