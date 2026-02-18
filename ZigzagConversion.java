import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        char[] charS = s.toCharArray();
        List<StringBuilder> listSbs = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            listSbs.add(new StringBuilder());
        }

        int move = 1;
        int currentRow = 0;
        for (int i = 0; i < charS.length; i++) {
            if (currentRow == 0) {
                move = 1;
            } else if (currentRow == numRows - 1) {
                move = -1;
            }

            StringBuilder currentSbItem = listSbs.get(currentRow);
            listSbs.set(currentRow, currentSbItem.append(charS[i]));

            if (currentRow + move <= numRows - 1) {
                currentRow += move;
            }
        }

        for (int i = 1; i < numRows; i++) {
            StringBuilder firstSb = listSbs.get(0);
            firstSb.append(listSbs.get(i));
        }

        return listSbs.get(0).toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zc = new ZigzagConversion();
        String s = "AB";
        int numRows = 1;
        System.out.println(zc.convert(s, numRows));
    }
}
