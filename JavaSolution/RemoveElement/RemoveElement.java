/**
 * Created by lingyanjiang on 16/6/6.
 */
public class RemoveElement {
    //指针遍历,判断相同时,和数组最后一个element换位置,同时length pointer--
    public int removeElement(int[] array, int val) {
        int pointer = array.length-1;
        int i = 0;
        while(i<pointer) {
            if(array[i] == val) {
                //if equals element
                array[i] = array[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer;
    }
}
