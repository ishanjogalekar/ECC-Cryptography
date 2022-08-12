package DSA;


import java.security.*;
import java.util.Scanner;

public class DSA {
    public static void main(String[] args) throws Exception {
        System.out.println("------------------DSA Algorithm------------------");
        System.out.println();

        //Accepting text from user
        long startTime = System.nanoTime();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some text to encrypt:");
        String msg = sc.nextLine();
        int n = msg.length();

        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generate the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Getting the private key from the key pair
        PrivateKey privKey = pair.getPrivate();

        long t1 = System.nanoTime();
        //Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withDSA");

        //Initialize the signature
        sign.initSign(privKey);
        byte[] bytes = "msg".getBytes();

        //Adding data to the signature
        sign.update(bytes);

        //Calculating the signature
        byte[] signature = sign.sign();

        long t2 = System.nanoTime();
        long t3 = t2-t1;


        //Printing the signature
        System.out.println("Digital signature for given text: "+new String(signature, "UTF8"));

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("**--------------------------Signature---------------------------------**");
        System.out.println("Execution time : " + timeElapsed / 1000);
        System.out.println("Encryption time: "+ t3 / 1000);
        System.out.println("String length:"+n);
        System.out.println("Total size = "+signature.length);
    }
}