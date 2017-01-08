import java.util.Arrays;

/**
 * Created by lingyanjiang on 16/6/11.
 */
public class Intersection {
    //i,j当指针,比较大小增
    //copy到另一个array中
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(nums1.length<nums2.length) {
            int [] temp;
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int [] array = new int[Math.min(nums1.length,nums2.length)];
        int i = 0,j = 0,k = 0;
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] == nums2[j]){
                array[k] = nums1[i];
                k++;
                j++;
                i++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int [] result = new int[k];
        for(int m=0;m<result.length;m++) {
            result[m] = array[m];
        }
        return result;
    }

}
