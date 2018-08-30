package PoketGem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by lingyanjiang on 17/2/18.
 */
public class FindPathMyversion {

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

        List<String> answer = parseFile(filename);
        System.out.println(answer);
    }

    static List<String> parseFile(String filename)
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

        return parseLines(allLines);
    }

    static List<String> parseLines(List<String> lines) {
        HashMap<String, Set<String>> neighbors = new HashMap<>();
        List<String> res = new ArrayList<>();
        if (lines.size() == 0) return res;
        String[] splitFirstLine = lines.get(0).split("\\s+");
        final String source = splitFirstLine[0].trim();
        String dest = splitFirstLine[1].trim();

        for (String line : lines) {
            String[] tmp = line.split(":");
            if (tmp.length < 2) continue;
            String parent = tmp[0].trim();
            String[] children = tmp[1].split("\\s+");
            for (String child : children) {
                child = child.trim();
                if (child.isEmpty()) continue;
                if (!neighbors.containsKey(parent)) {
                    neighbors.put(parent, new HashSet<String>());
                }
                neighbors.get(parent).add(child);
            }
        }
        dfs(source, dest, new StringBuilder(source), new HashSet<String>(){{add(source);}}, neighbors, res);
        return res;
    }

    private static void dfs(String source, String dest, StringBuilder sb, Set<String> visited, HashMap<String, Set<String>> neighbors, List<String> res) {
        if (sb.length() >= 1 && source.equals(dest)) {
            res.add(sb.toString());
            return;
        }
        if (!neighbors.containsKey(source)) return;
        for (String child: neighbors.get(source)) {
            if (visited.contains(child)) continue;
            visited.add(child);
            sb.append(child);
            dfs(child, dest, sb, visited, neighbors, res);
            visited.remove(child);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
