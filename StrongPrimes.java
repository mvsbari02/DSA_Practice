import java.util.*;
public class StrongPrimes {
    public static int[] strongPrimes() {
        int max = 1000004;
        int[] primeStatus = new int[max];
        for (int i = 2;i < max;i++) {
            primeStatus[i] = 1;
        }
        for (int i = 2;i*i <= max;i++) {
            if (primeStatus[i] == 1) {
                for (int j = i*i;j<max;j+=i) {
                    primeStatus[j] = 0;
                }
            }
        }
        primeStatus[2] = 0;
        int cur = 3;
        int prev = 2;
        int next = 5;
        int count = 0;
        while (cur <= max - 4) {
            if (2*cur > prev + next) {
                count += 1;
                primeStatus[cur] = count; 
            }else {
                primeStatus[cur] = primeStatus[cur-1];
            }
            prev = cur;
            while (cur != next) {
                cur += 1;
                primeStatus[cur] = primeStatus[cur-1];
            }
            next += 1;
            while (next < max && primeStatus[next] != 1) {
                next += 1;
            }
        }
        return primeStatus;
    }

    public static void main(String[] args) {
        int[] stropri = strongPrimes();
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0;i < q;i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            System.out.println(stropri[end] - stropri[start-1]);
        }
        in.close();
    }
}
