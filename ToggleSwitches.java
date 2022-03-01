/*

        -> Problem Statement :
          We are given n bulbs (initially turned off)and a toggle operation turns off the bulb if it's 
          turned on and vice-versa. We have to return numbr of bulbs that a re turned on after performing
          n rounds of specific operation. In ith round we will toggle every ith bulb.

        -> Eg: 
              if n = 4,
                (Let 0 be turned off and 1 be turned on)

                    round/bulb    b1     b2     b3     b4
                     
                     initial (0)  0      0      0      0    
                     round-1      1      1      1      1    (every bulb is toggled (1,2,3,4))
                     round-2      1      0      1      0    (every 2nd bulb is toggled (2,4))
                     round-3      1      0      0      0    (every 3rd bulb is toggled (3))
                     round-4      1      0      0      1    (every 4th bulb is toggled (4))

                So, after 4 rounds we have 2 bulbs turned on.
    
        -> Approach :
            -> If we observe, since all bulbs are initially turned off, any bulb will be turned on after
            odd number of toggles.
                Eg : bulb-n, initially  -  0
                      after 1st toggle  -  1
                      after 2nd toggle  -  0
                      after 3rd toggle  -  1
                      after 4th toggle  -  0
                      after 5th toggle  -  1
            -> In ith round, every bulb of index which is divisible by is i is toggled.
            -> So, if a bulb Bi is to be turned on after n rounds, then it shoud be divisible by odd 
            number of factors. (it should have odd number of factors)

            -> We know that, if a number is prime factorized as N = p1^r1 * p2^r2 * p3^r3
            then number of factors will be (r1 + 1)*(r2 + 1)*(r3 + 1) and this product should be odd.
            -> For a product should be odd, each and every term should be odd.
            -> If r+1 must be odd then r should be even. So, every r1,r2,r3 should be even.
                So, N which is equal to p1^r1 * p2^r2 * p3^r3 
                       will be equal to p1^(2*k1) * p2^(2*k2) * p3^(2*k3)
                       is in the form of (p1^k1 * p2^k2 * p3^k3) ^ 2 which is a perfect square.
            
            -> So a number having odd number of factors should always be a perfect square.

            -> So the bulb of index which is perfect square will be turned on after n rounds of 
            operations.
            -> So number of perfect squares upto the given number of bulbs will be our answer and is 
            given by the integral part of square root of the number .
            
            Eg: if we have 10 bulbs, after 10 rounds of operations we have integral part of square root
            of 10 which is equal to 3 bulbs will be turned on.
            



*/

import java.util.*;
public class ToggleSwitches {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no.of bulbs : ");
        int n = in.nextInt();
        int result = (int) Math.floor(Math.sqrt(n));
        System.out.println(result);
        in.close(); 
    }
}
