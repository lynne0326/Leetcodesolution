package quantcast;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 17/5/9.
 */
public class Paypal {

    /**
     * This method is to parse string to result
     * @param str array of digits input
     * @param cnt number of prices need to return
     * @return
     */
    public static List<Integer> parse(String str, int cnt) {
        List<Integer> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        String[] splited = str.split("\\s+");
        for (String s : splited) {
            if (s.isEmpty()) continue;
            tmp.add(Integer.parseInt(s.trim()));
        }
        while (tmp.size() > 0) {
            //Get the smallest one and its original price
            int curNum = tmp.get(0);
            int origin = (int) ((int) curNum * 4.0/3);
            //remove processed int from array
            tmp.remove(new Integer(curNum));
            tmp.remove(new Integer(origin));
            //add result to final output
            res.add(curNum);
            //decrement cnt by one
            cnt--;
            if (cnt == 0) break;
        }
        return res;
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("input.txt")));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("large_output.txt")))) {
            int caseCnt = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < caseCnt; i++) {
                int curCnt = Integer.parseInt(bufferedReader.readLine());
                String array = bufferedReader.readLine();
                List<Integer> list = parse(array, curCnt);
                //write output to file
                bufferedWriter.write("Case #" + (i + 1) + ": ");
                for (int tmp : list) {
                    bufferedWriter.write(tmp + " ");
                }
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
