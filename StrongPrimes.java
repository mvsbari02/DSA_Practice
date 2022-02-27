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

    Approach : First we get all prime numbers using idea of Sieve of Eratosthenes.

                //Sieve of Eratoshtenes
               -> In Sieve of Eatosthenes approach, firstly we take an array (primeStatus) of max size 
               and initialize with 1.
               -> Now starting from 2 for every prime number less than or equal to square root of the maxi-
               -mum value, multiples of those prime numbers are set to 0.
               -> So by the end in out array we will have 1 at every prime index and 0 for every non-prime
               index.

               
               -> After getting an array with 1's at prime indices, we use three pointers viz prev, cur,
                next and a count variable initialized with 0 to find strong primes.
               -> Now prev is initialized with index 2,cur is initialized with index 3 and next is init
               ialized with index 5.
               -> As we know that 2 cannot be a strong prime we put 0 at index 2.

                // to get the number of strong primes under a number at that index
               ->Now for every triplet of (prev,cur,next) such that cur <= max :
                    -> If the condition 2 * cur > prev + next is satisfied :
                        - count is increased by 1
                        - and the value at the cur index will be the count
                    -> If the above condition fails :
                        - the value at the cur index will be set to the value at the cur-1 index
                    -> Then we update value of prev to cur
                    -> Now we update the values of indices between the cur and next with the value of 
                    their previous indices (all values will be equal to value of cur index) and 
                    eventually the cur will be updated to next
                    -> Now we update the next index by iterating from next + 1 until we find value 1

                

               -> By the end of the process we get an array with values corresponding to the count
                    of strong primes upto that index i.e primeStatus[n] => number of strong primes 
                    upto n (including n).
                
                    Eg : number of strong primes under 5 is primeStatus[5]
                
               ->  So, finding the number of Strong primes upto a number becomes O(1) process (individually)


               -> Finally for every test case, the number of strong primes between two given numbers a,
               b is given by primeStatus[b] - primeStatus[a-1].
                    Eg : number of strong primes between 10 and 20 will be primeStatus[20] - primeStatu
                    s[10-1] which is equal to 2.
    

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
