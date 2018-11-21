
package RunLengthEncoding;

import java.io.ByteArrayOutputStream;
//import java.math.BigInteger;
import java.util.*;

public class RleProgram {
    public static ByteArrayOutputStream rleData = new ByteArrayOutputStream();

    public static String toHexString(byte[] data)
    {
        // loop through the data array and convert the values to hexadeci
        StringBuilder hexDec =  new StringBuilder();
        for (int i=0; i < data.length; i++) {
            if (i % 2 == 0) {
                hexDec.append(data[i]);
            } else {
                hexDec.append(String.format("%1x", data[i]));
            }
        }

        return hexDec.toString();
    }

    public static int countRuns(byte[] flatData)
    {
        int runs = 0;
        int previousValue=-1;
        // loop through the byte array and calc the counts
        for (int b:flatData) {
            if (previousValue != -1){if (previousValue != b) {
                runs++;
            }
            }
            previousValue = b;
        }
        return runs;
    }

    public static byte[] encodeRLE(byte[] flatData)
    {
        int previousValue = -1;
        int currentValue;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // loop through byte array and calculate the consecutive counts in the array

        for (byte b: flatData) {
            currentValue = b;

            if (previousValue == -1) {
                previousValue = currentValue;
                map.put(currentValue, 1);
            } else {
                //check current value is equal to previous value

                if (currentValue == previousValue) {
                    int count = map.get(currentValue);
                    map.put(currentValue, count+1);
                }
            }
        }
        // convert the map into byte array
        return convertMapIntoByteArray(map);
    }

    public static byte[] convertMapIntoByteArray(HashMap map)
    {
        byte encodedByte[] = new byte[20];

        Iterator entries = map.entrySet().iterator();

        while (entries.hasNext()) {
            HashMap.Entry  entry = (HashMap.Entry)entries.next();
            encodedByte = entry.getKey().toString().getBytes();
        }
        return encodedByte;
    }
    // get the decoded length
    public static int getDecodedLength(byte[] rleData)
    {
        int decodedLength = 0;

        for(int i=0; i< rleData.length; i++) {
            if ( i % 2 == 0) {
                decodedLength += rleData[i];
            }
        }
        return decodedLength;
    }
    // returns the flat data
    public static byte[] decodeRle(byte[] rleData)
    {
        int arrayLength = rleData.length;

        List<Byte> byteArray = new ArrayList<>();

        for (int i=0; i < arrayLength; i++) {
            if (i % 2 == 0) {
                int value = rleData[i];
                for(int j=0; j < value; j++) {
                    byteArray.add(rleData[i+1]);
                }
            }
        }

        byte[] data = new byte[byteArray.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] =  byteArray.get(i);
        }

        return data;
    }
    // converts a string to byte array
    public static byte[] stringToData(String dataString)
    {

       /* int byteArrayLength = dataString.length();
        byte data[] = new byte[byteArrayLength/2];

        for(int i=0; i < byteArrayLength; i+=2) {
            data[i/2] = (byte) ((Character.digit(dataString.charAt(i), 16) << 4) +
                    Character.digit(dataString.charAt(i+1), 16));
        }*/
//        byte[] data = new BigInteger(dataString, 16).toByteArray();


        return dataString.getBytes();
    }
    // converts byte array to rle string
    public static String toRleString(byte[] rleData)
    {
        System.out.println(rleData.toString());
        StringBuilder rleString = new StringBuilder();
        for(int i =0; i < rleData.length; i++) {
            if (i % 2 == 0) {
                rleString.append(rleData[i]);
            } else {
                rleString.append(String.format("%1x", rleData[i]));
                if (!(i == rleData.length-1)){
                    rleString.append(':');
                }
            }
        }
        return rleString.toString();
    }
    // converts rle string to rle hexadecimal string
    public static byte[] stringToRle(String rleString)
    {
        rleString = rleString.replaceAll(":", "");
//        System.out.println(rleString);

        return stringToData(rleString);
    }

    public static String convertByteArrayToFlatData(byte[] data)
    {
        StringBuilder hexDec =  new StringBuilder();
        for (int i=0; i < data.length; i++) {
            hexDec.append(String.format("%1x", data[i]));
        }
        return hexDec.toString();
    }

    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome to the RLE image encoder!");
        System.out.println("Displaying Spectrum Image: ");
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow);

        // loop for the options prompt

        whileLabel: while (true) {


            System.out.println("RLE Menu");
            System.out.println("--------");
            System.out.println("0. Exit");
            System.out.println("1. Load File");
            System.out.println("2. Load Test Image");
            System.out.println("3. Read RLE String");
            System.out.println("4. Read RLE Hex String");
            System.out.println("5. Read Data Hex String");
            System.out.println("6. Display Image");
            System.out.println("7. Display RLE String");
            System.out.println("8. Display Hex RLE Data");
            System.out.println("9. Display Hex Flat Data \n");

            System.out.print("Select a Menu Option: ");

            int option = reader.nextInt();


            // switch for the options selected
            switch(option) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    rleData.reset();
                    System.out.print("Enter name of file to load: ");
                    String fileName = reader.next();
                    byte[] imageData = ConsoleGfx.loadFile(fileName);
                    rleData.write(imageData, 0, imageData.length);
                    break;

                case 2:
                    rleData.reset();
                    rleData.write(ConsoleGfx.testImage,0, ConsoleGfx.testImage.length);
                    System.out.println("Test image data loaded.\n");
                    break;

                case 3:
                    System.out.println("Enter an RLE string to be decoded: ");
                    String rleString = reader.next();
                    byte[] dataThree = stringToRle(rleString);
                    rleData.write(dataThree,0 , dataThree.length);
                    break;
                case 4:
                    System.out.println("Enter the hex string holding RLE data: ");
                    String rleHexString = reader.next();
                    byte[] dataFour = stringToData(rleHexString);
                    rleData.write(dataFour, 0, dataFour.length);
                    break;
                case 5:
                    System.out.println("Enter the hex string holding flat data: ");
                    String rleHexFlatData = reader.next();
                    break;
                case 6:
                    System.out.println("Displaying image...");
                    ConsoleGfx.displayImage(rleData.toByteArray());
                    break;
                case 7:
                    System.out.println("RLE representation: ");
                    System.out.println(toRleString(RleProgram.rleData.toByteArray()));
                    break;
                case 8:
                    System.out.println("RLE hex values: ");
                    System.out.println(toHexString(rleData.toByteArray()));
                    break;
                case 9:
                    System.out.print("Flat hex values: ");
                    System.out.println(convertByteArrayToFlatData(decodeRle(RleProgram.rleData.toByteArray())));

                    break;
                default:
                    // break the while loop if incorrect option is selected
                    break whileLabel;
            }
        }

    }
}

// Sources used are google and stack overflow