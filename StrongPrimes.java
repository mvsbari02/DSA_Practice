/*
      
    
    This program gives the count of strong primes between two given numbers a and b.

    Constraints : 1 <= a,b <= 10^6
                  1 <= t <= 10^4

    Eg: Input : 10 20
        Output : 2

    A number is called a Strong prime if two times the number is greater than the sum of the previous 
     prime number and the next prime number.

    Eg: Consider 11.
            2 * 11 > 7 + 13
            2 times 11 is greater than the sum of the previous prime number(7) and the next prime number
            (13). So 11 is a Strong Prime.

    Approach : 

    

*/


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
