package HackerRank;

import java.util.*;

public class codility {

    public static int solution(int N) {
        // write your code in Java SE 8
        String binaryString = Integer.toBinaryString(N);
        int[] arr = new int[]{0};
        for(int i=0; i < arr.length; i++) {
            System.out.println("inital array "+ arr[i]);
        }

        for(int i=0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);


            if (c == '1' ){
                System.out.println("this is the value of c " + c);
               try {
                   arr[arr.length+1] = 0;
               } catch ( ArrayIndexOutOfBoundsException e) {
                   System.out.println(" in there");
                   arr[0] = 0;
               }

            } else {
                System.out.println("this is the value of c in else "+ c);
                System.out.println("this is the array length " + arr.length);
                arr[arr.length - 1] = arr[arr.length - 1] + 1;
                System.out.println(arr[arr.length-1]);
            }
        }
        for(int i=0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        return Arrays.stream(arr).summaryStatistics().getMax();
    }

    public static void main(String[] args) {
        System.out.println(solution(9));
    }
}
