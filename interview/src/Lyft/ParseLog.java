package Lyft;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lingyanjiang on 16/12/4.
 */
public class ParseLog {

    private static final Pattern logPattern = Pattern.compile("\\[.*?\\].*(PUT|POST|GET|DELETE|HEAD)(.*?)(HTTP1.1).*?([0-9]{3}).*");
    private static final Pattern userPattern = Pattern.compile(".*/user/([0-9]{0,})/.*");
    private HashMap<String, Integer> count = new HashMap<>();
    private HashSet<String> userIds = new HashSet<>();
    private PriorityQueue queue;

    protected void readLog(File file) {
        try(BufferedReader bufIn = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ( (line = bufIn.readLine()) != null) {
                parseLog(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        convertToOrdered();
    }

    protected void parseLog(String log) {
        Matcher matcher = logPattern.matcher(log);
        String userId = null;
        String requestType = null;
        String statusCode = null;
        String mapping = null;

        if (matcher.matches()) {
            requestType = matcher.group(1);
            mapping = matcher.group(2);
            if (mapping.indexOf("user") != -1) {
                Matcher matcher1 = userPattern.matcher(mapping);
                if (matcher1.matches()) {
                    userId = matcher1.group(1);
                }
            }
            statusCode = matcher.group(4);
        }
        if (count.containsKey(requestType)) {
            count.put(requestType, count.get(requestType) + 1);
        } else {
            count.put(requestType, 1);
        }
        userIds.add(userId);
    }

    private void convertToOrdered() {
        queue = new PriorityQueue(10, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if ((int)((Map.Entry) o1).getValue() == (int)((Map.Entry) o2).getValue()) {
                    return 0;
                }
                return (int)((Map.Entry) o1).getValue() > (int)((Map.Entry) o2).getValue() ? -1 : 1;
            }
        });

        for (Map.Entry entry: count.entrySet()) {
            queue.add(entry);
        }
    }

    public static void main(String[] args) {
        ParseLog psl = new ParseLog();
        psl.readLog(new File("test"));
        System.out.println("Unique Id: " + psl.userIds.size());
        System.out.println("Request Count:");
        while(!psl.queue.isEmpty()) {
            Map.Entry entry = (Map.Entry)psl.queue.poll();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}

class Log {
    private String requestType;
    private String userId;
    private String code;
    private String mapping;

    public Log(String requestType, String userId, String code, String mapping) {
        this.requestType = requestType;
        this.userId = userId;
        this.code = code;
        this.mapping = mapping;
    }

    public Log(){}

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }
}