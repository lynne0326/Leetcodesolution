package PoketGem;
import java.util.*;
/**
 * Created by lingyanjiang on 17/2/21.
 */
////nlogk,
////遍历整个数组是n (item 个数), 遍历同时维护k size的heap是log(k). 所以我觉得是nlog(k).
//class Item {
//    String name;
//    int value;
//    int counts;
//    int maxStackSize;
//    public Item(String name, int value, int counts, int maxStackSize) {
//        this.name = name;
//        this.value = value;
//        this.counts = counts;
//        this.maxStackSize = maxStackSize;
//    }
//}
//
////We can use greedy to do this task, for each current stack, we can just put the maximum value we
////can get currently put into the stack, then update what we have now,
//
////Each time we fill the stack with the maximum value we can get from the items we have ,
//// like if we have 10 diamonds, 10 rubies and 10 equipment, then the best strategy is to stock current stack with 5 diamonds,
//// While if we have 2 diamonds, 10 rubies and 1 equipment, then we choose either 5 rubies or 1 equipment, because they
//// both has the maximum stack unit value of 25. than 20 for the diamonds.
////Thing is how
//public class RubyDiamond{
//    public int getMaxValue(Item [] items, int n ) {
//        if (items == null || items.length == 0) return 0;
//        int total = 0;
//
//        PriorityQueue<Item> pq = new PriorityQueue<>(10, new Comparator<Item>(){
//            public int compare(Item o1, Item o2) {
//                int o2Value = o2.counts <= o2.maxStackSize ? o2.counts * o2.value : o2.maxStackSize * o2.value;
//                int o1Value = o1.counts <= o1.maxStackSize ? o1.counts * o1.value : o1.maxStackSize * o1.value;
//                //decreasing order
//                return o2Value - o1Value;
//            }
//        });
//        //Init
//        for (Item i: items) {
//            pq.add(i);
//        }
//        //Iterate
//        while (!pq.isEmpty() && n > 0) {
//            Item cur = pq.poll();
//            //subtract maxsize*value and add remaining to pq
//            total += cur.counts < cur.maxStackSize ? cur.counts * cur.value : cur.maxStackSize * cur.value;
//            int remaining = cur.counts - cur.maxStackSize;
//            if (remaining > 0) {
//                pq.add(new Item(cur.name, cur.value, remaining, cur.maxStackSize));
//            }
//            n--;
//        }
//        return total;
//    }
//
//    public static void main(String [] args) {
//        RubyDiamond rbd = new RubyDiamond();
//        Item [] items = new Item[]{new Item("Diamond", 10, 100, 5),
//                    new Item("Ruby", 5, 100, 5),
//                    new Item("Equipment", 25, 100, 1)
//        };
//        int res = rbd.getMaxValue(items, 50);
//        System.out.println(res);
//    }
//}
class ItemInfo {
    String name;
    int value;
    int maximum_stack_size;
    public ItemInfo(String name, int value, int maximum_stack_size) {
        this.name = name;
        this.value = value;
        this.maximum_stack_size = maximum_stack_size;
    }
}

class Item {
    String name;
    int value;
    int maximum_stack_size;
    int count;

    public Item (String name, int value, int maximum_stack_size, int count) {
        this.name = name;
        this.value = value;
        this.maximum_stack_size = maximum_stack_size;
        this.count = count;
    }
}
//We can use greedy to do this task, for each current stack, we can just put the maximum value we
//can get currently put into the stack, then update what we have now,

//Each time we fill the stack with the maximum value we can get from the items we have ,
// like if we have 10 diamonds, 10 rubies and 10 equipment, then the best strategy is to stock current stack with 5 diamonds,
// While if we have 2 diamonds, 10 rubies and 1 equipment, then we choose either 5 rubies or 1 equipment, because they
// both has the maximum stack unit value of 25. than 20 for the diamonds.
//Thing is how
////nlogk,
////遍历整个数组是n (item 个数), 遍历同时维护k size的heap是log(k). 所以我觉得是nlog(k).
public class RubyDiamond {
    public static int getMaximumTotalValue(int n, String[] items, ItemInfo[] item_infos) {
        //first we need to count the items and reconstruct the items into my Item class objects
        Map<String, Integer> counts = new HashMap<>();
        //This map is to store the item_info key is the item name, value is the iteminfo object
        Map<String, ItemInfo> map = new HashMap<>();
        for (String itm: items) {
            counts.put(itm, counts.getOrDefault(itm, 0) + 1);
        }
        for (ItemInfo itf: item_infos) {
            map.put(itf.name, itf);
        }

        //Then we need implement the max heap using priorityQueue,
        //Comparing the maximum stack unit value we can stock in current status
        PriorityQueue<Item> pq = new PriorityQueue<>(new Comparator<Item>(){
            public int compare (Item i1, Item i2) {
                int val1 = i1.count < i1.maximum_stack_size ? i1.count * i1.value : i1.maximum_stack_size * i1.value;
                int val2 = i2.count < i2.maximum_stack_size ? i2.count * i2.value : i2.maximum_stack_size * i2.value;
                return val2 - val1;
            }
        });

        //Then we need to construct new item objects and put them into the pq
        for (String key: counts.keySet()) {
            int count = counts.get(key);
            ItemInfo infor = map.get(key);
            pq.offer(new Item(key, infor.value, infor.maximum_stack_size, count));
        }

        //Then we need to fill up the stacks
        int total = 0;
        while (!pq.isEmpty() && n > 0) {
            Item cur = pq.poll();
            int tmpTotal = cur.count;
            //Get the remaining counts after we stock the max value we can get
            int remaining = tmpTotal < cur.maximum_stack_size ? 0 : tmpTotal - cur.maximum_stack_size;
            //then we update total
            total += tmpTotal < cur.maximum_stack_size ? tmpTotal * cur.value : cur.maximum_stack_size * cur.value;
            if (remaining > 0) {
                //if remaining is not 0, then we put updated items with remaining amount into the pq
                pq.offer(new Item(cur.name, cur.value, cur.maximum_stack_size, remaining));
            }
            //不要忘掉
            n--;
        }
        return total;
    }

    public static void main(String[] args) {
        String[] items = {"diamond", "ruby", "armor", "diamond", "diamond", "ruby", "diamond", "diamond", "diamond", "diamond", "diamond", "armor"};
        ItemInfo[] item_infos = {new ItemInfo("diamond", 10, 5), new ItemInfo("ruby", 5, 5), new ItemInfo("armor", 25, 1)};
        System.out.println(getMaximumTotalValue(3, items, item_infos));
    }
}
