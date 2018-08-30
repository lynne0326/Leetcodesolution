import java.util.List;

/**
 * Created by lingyanjiang on 17/1/10.
 */
public class Triangle {
    //int [] f多一行, 可避免初始化
    //从倒数第一行开始bottom up
    public int minimumTotal(List<List<Integer>> triangle) {
        int sz = triangle.size();
        int[] results = new int[sz+1];

        for(int i=sz-1; i>=0; i--) {
            List<Integer> tmp = triangle.get(i);

            for(int j=0; j<tmp.size(); j++) {
                results[j] = Math.min(results[j], results[j+1]) + tmp.get(j);
            }
        }
        return results[0];
    }
}
