package PoketGem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lingyanjiang on 17/2/18.
 */
public class ParseLogMyversion {

    /**
     * Tests the method parseFile with an example test-case.
     * This method is completely for your own testing and is NOT
     * called/used while grading your answer.
     */
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "input2.txt";
        if (args.length > 0) {
            filename = args[0];
        }

        String answer = parseFile(filename);
        System.out.println(answer);
    }

    static String parseFile(String filename)
            throws FileNotFoundException, IOException {
        /*
         *  Don't modify this function
    	 */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();

        return parseLines(allLines.toArray(new String[allLines.size()]));
    }

    static String parseLines(String[] lines) {
        long startTime = 0;
        long contStartTime = 0;
        long contCounts = 0;
        long sessionCounts = 0;
        boolean isConnect = false;
        boolean isStart = false;

        for (String line : lines) {
            String[] splited = line.trim().split("::");
            splited[0] = splited[0].replaceAll("[(]", "").replaceAll("[)]", "").trim();
            SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
            Date d = null;
            try {
                d = f.parse(splited[0]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //Get time and status
            long tmstp = d.getTime();
            String status = splited[1].trim();

            switch (status) {
                case "START":
                    isStart = true;
                    startTime = tmstp;
                    break;
                case "CONNECTED":
                    contStartTime = tmstp;
                    isConnect = true;
                    break;
                case "DISCONNECTED":
                    if (isConnect) {
                        contCounts += tmstp - contStartTime;
                    }
                    isConnect = !isConnect;
                    break;
                case "SHUTDOWN":
                    if (isConnect) {
                        contCounts += tmstp - contStartTime;
                        isConnect = !isConnect;
                    }
                    if (isStart) {
                        sessionCounts += tmstp - startTime;
                        isStart = !isStart;
                    }
                    break;
            }

        }
        double percent = (double) contCounts / sessionCounts;
        return (int) (percent * 100) + "%";
    }

}
