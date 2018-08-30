

public class SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void swap(int [] nums, int i,int  j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //O(n)
    public void sortColor(int [] nums) {
        if (nums == null) return;
        int s = 0, e = nums.length - 1;
        for (int i = 0; i <= e; i++) {
            if (nums[i] == 0) swap(i, s++, nums);
            else if (nums[i] == 2) swap(i--, e--, nums);
        }
    }

    private void swap (int i, int j, int [] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public void sortColorGeneral(int [] nums, int n) {
        int [] endPos = new int[]{0,nums.length - 1};
        int counts = 0;
        while (counts < n - counts - 1) {
            endPos = helper(nums, endPos[0], endPos[1], counts, n - counts - 1);
            counts++;
        }
    }

    private int [] helper(int [] nums, int start, int end, int color1, int color2) {
        if (nums == null || start >= end) return nums;
        for (int i = start; i <= end; i++) {
            if (nums[i] == color1) swap(nums, i, start++);
            else if (nums[i] == color2) swap(nums, i--, end--);
        }
        return new int[]{start, end};
    }

    ////
    class PocketColor{
        char c;
        public PocketColor(char c) {
            this.c = c;
        }
    }

    public void sortColor(PocketColor [] colors) {
        if (colors == null || colors.length == 0) return;
        int start = 0, end = colors.length - 1;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i].c == 'r') swap(start++, i, colors);
            else if (colors[i].c == 'b') swap(end--, i--, colors);
        }
    }

    private void swap(int i, int j, PocketColor [] colors) {
        PocketColor tmp = colors[i];
        colors[i] = colors[j];
        colors[j] = tmp;
    }


    public static void main(String[] args) {
        int [] test = new int[]{2,3,3,0,3,2,1,0,0,1,2,1,2,3};
        new SortColors().sortColorGeneral(test, 4);
        for (int i: test) System.out.print(i);
        System.out.println();
    }
}