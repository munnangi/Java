package TimeComplexity;

public class Analyzer {

    public static void main(String[] args) {

        String[] data = StringData.getData();

        System.out.println("Linear Search\n");
        linearSearch(data, "not_here");
        linearSearch(data, "mzzzz");
        linearSearch(data, "aaaaa");

        System.out.println("\nBinary Search\n");
        binarySearch(data, "not_here");
        binarySearch(data, "mzzzz");
        binarySearch(data, "aaaaa");
    }

    // Linear Sort Method
    public static int linearSearch(String ourString[], String key) {
        long beginTime = System.nanoTime();
        int index = -1;
        for (int i = 0; i < ourString.length - 1; ++i) {
            if (ourString[i].compareTo(key) == 0) {
                index = i;
                break;
            }
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - beginTime + "ns");
        return index;
    }

    // Binary Sort Method
    public static int binarySearch(String[] a, String x) {
        long beginTime = System.nanoTime();
        // Sort the binary array

        int low = 0;
        int high = a.length - 1;
        int mid;
        int index = -1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                index = mid; break;
            }
        }

        long endTime = System.nanoTime();
        System.out.println(endTime - beginTime + "ns");
        return index;
    }
}
