package readfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        long start = System.nanoTime();

        System.out.println((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576 + " Mb");

        /*Random randNumber = new Random();
        int iNumber;
        try (FileWriter fr = new FileWriter("numbers.txt")) {
            for (int i = 1; i < 1_000_000; i++) {
                iNumber = randNumber.nextInt(1_000_000_000);
                fr.write(((Math.random() * 10) > 5 && iNumber != 0 ? "-" : "") + iNumber + " ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

        boolean[] seq = new boolean[1_000_001];

        try (FileReader fr = new FileReader("numbers.txt")) {
            int intTmp, i = 0, c;
            char tmp[] = new char[12];
            do {
                c = fr.read();
                if ((char) c == ' ' || c == -1) {
                    intTmp = charArrToInt(tmp);
                    if (intTmp > 0 && intTmp <= 1_000_000) {
                        seq[intTmp] = true;
                    }
                    i = 0;
                    tmp = new char[12];
                } else {
                    tmp[i++] = (char) c;
                }
            }
            while (c != -1);

            boolean allFieldsFill = true;
            for (int d = 1; d < seq.length; d++) {
                if (!seq[d]) {
                    System.out.println("MIN NATURAL: " + d);
                    allFieldsFill = false;
                    break;
                }
            }
            if (allFieldsFill) {
                System.out.println("MIN NATURAL: 1000001");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long stop = System.nanoTime();
        System.out.println(((stop - start) / 1000) / 1e3 + " ms");

        System.out.println((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576 + " Mb");
    }

    private static int charArrToInt(char[] data) {
        int result = 0;

        if (data[0] == '-') {
            return -1;
        }
        for (char aData : data) {
            if (aData == '\u0000') {
                continue;
            }
            int digit = (int) aData - (int) '0';
            result *= 10;
            result += digit;
        }
        return result;
    }
}
