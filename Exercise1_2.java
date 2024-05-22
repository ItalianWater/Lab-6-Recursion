public class Exercise1_2 {
    public int mystery(int a, int b) {
        // Checks if b equals 1
        if (b == 1) {

            // if it does returns a
            return a;

        }
        // if b does not equal 1, it would return integer a + (a + b-1) until b equals 1
        else {

            return a + mystery(a, b - 1);

        }
    }


        // Returns n if n = 0, else it would create an infinite loop.
        public int sum(int n) {
            if (n == 0) {
                return 0;
            }
            else {
                return n + sum(n);
            }
        }


    }