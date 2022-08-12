package keyexchange;

import java.util.*;


public class DHKey {
    // Power function to return value of a ^ b mod P
    private static long power(long a, long b, long p)
    {
        if (b == 1)
            return a;
        else
            return (((long)Math.pow(a, b)) % p);
        }
        // Driver code
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            long P, G, x, a, y, b, ka, kb;


            // public keys G and P

            // A prime number P is taken
            System.out.println("Choose Prime number:");
            P = sc.nextInt();
            System.out.println("The value of P:" + P);

            // A primitive root for P, G is taken
            System.out.println("Primitive root of P");
            G = sc.nextInt();
            System.out.println("The value of G:" + G);

            // Alice will choose the private key a is the chosen private key
            a = 4; //default
            System.out.println("The private key a for Alice:" + a);

            // Gets the generated key
            x = power(G, a, P);

            // Bob will choose the private key b is the chosen private key
            b = 3; // default
            System.out.println("The private key b for Bob:" + b);

            //Generated jey
            y = power(G, b, P);

            // Generating the secret key after the exchange of keys

            ka = power(y, a, P); // Secret key for Alice

            kb = power(x, b, P); // Secret key for Bob

            System.out.println("Secret key for the Alice is:" + ka);
            System.out.println("Secret key for the Bob is:" + kb);
        }
    }


