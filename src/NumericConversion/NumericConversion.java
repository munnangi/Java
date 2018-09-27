package NumericConversion;

import java.util.Scanner;

public class NumericConversion {

    public static long hexStringDecode(String hex)
    {
        if (hex.substring(0,2).equals("0x")) {
            hex = hex.substring(2);
        }

        hex = hex.toUpperCase();
        double result =0;

        // loop through every hexadecimal digit and calculate the result
        for (int i=0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            short value = hexCharDecode(c);
             result += (int)(value) * Math.pow(16, hex.length()-i-1);
        }

        return (long)result;
    }

    public static short hexCharDecode(char digit)
    {
        digit = Character.toUpperCase(digit);
        // getting decimal equivalent of the digit
       switch (digit) {
           case 'F': return 15;
           case 'E': return 14;
           case 'D': return 13;
           case 'C': return 12;
           case 'B': return 11;
           case 'A': return 10;
           case '0': return 0;
           case '1': return 1;
           case '2': return 2;
           case '3': return 3;
           case '4': return 4;
           case '5': return 5;
           case '6': return 6;
           case '7': return 7;
           case '8': return 8;
           case '9': return 9;
           default: return (short)digit;
       }
    }

    public static short binaryStringDecode(String binary)
    {
        if (binary.substring(0,2).equals("0b")) {
            binary = binary.substring(2);
        }

        short result = 0;

        // loop through every binary digit and calculate the result
        for(int i=0; i < binary.length(); i++) {
            int c = Character.getNumericValue(binary.charAt(i));
            result += c * Math.pow(2, binary.length() - i -1);
        }

        return result;
    }
//
//    public static String binaryToHex(String binary)
//    {
//
//    }

    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);

        while (true) {
            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit" + "\n");

            System.out.print("Please enter an option: ");



            int option = reader.nextInt();

            if (option == 4) {
                System.out.print("Goodbye!");
                System.exit(0);
            } else {
                System.out.print("\n" + "Please enter the numeric string to convert: ");
            }

            String value = reader.next();

            switch(option)
            {
                case 1: System.out.println("\nResult: " + hexStringDecode(value) + "\n"); break;
                case 2: System.out.println("\nResult: " + binaryStringDecode(value) + "\n"); break;
//                case 3: binaryToHex(value); break;
            }
        }
    }
}
