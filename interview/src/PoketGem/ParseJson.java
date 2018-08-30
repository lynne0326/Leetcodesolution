package PoketGem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lingyanjiang on 17/2/27.
 */
class Solution {
    class JSON {  // base class for json data type
        public JSON(String json) {
        }

        ;  // constructor

        public String toString() {
            return null;
        }

        ;  // convert json data type to string that can be printed

        public String type() {
            return null;
        }

        ;  // return type
    }

    class JSONMapping extends JSON {
        public JSONMapping(String json) {
            super(json);
        }

        public JSON get(String key) {
            return null;
        } // return value corresponding to the key

        public String[] keys() {
            return null;
        } // return all the keys

        public String type() {
            return "JSONMapping";
        }
    }

    class JSONString extends JSON {
        public JSONString(String json) {
            super(json);
        }

        public String value() {
            return null;
        }

        ; // return the string

        public String type() {
            return "JSONString";
        }
    }


    private List<Map<String, String>> list = new ArrayList<>();
    private HashMap<String, String> map = new HashMap<>();

    public List<Map<String, String>> parseJSon(JSON data, String[] columns) {
        helper(data, columns, 0);
        return list;
    }

    private void helper(JSON data, String[] columns, int depth) {
        // Assume input alwyas valid,
        // i.e. depth will never exceed columns.length();

        if (data.type().equals("JSONMapping")) {

            // Down casting
            JSONMapping dataMap = (JSONMapping) data;
            for (String key : dataMap.keys()) {

                JSON childJSON = dataMap.get(key);

                // backtracking
                map.put(columns[depth], key);
                helper(childJSON, columns, depth + 1);
                map.remove(columns[depth]);
            }
        } else if (data.type().equals("JSONString")) {

            // base unit of JSON, so depth == columns.length() - 1
            // Down casting
            JSONString dataString = (JSONString) data;
            String val = dataString.value();

            map.put(columns[depth], val);
//            list.add(flatten(map));
            list.add((Map<String, String>) map.clone());
            map.remove(columns[depth]);
        }
    }
}