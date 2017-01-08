package Lyft;

import java.util.Stack;

/**
 * Created by lingyanjiang on 16/12/5.
 */
class Stone {
    int mass;
    boolean isRight;
    public Stone(int mass, boolean isRight) {
        this.mass = mass;
        this.isRight = isRight;
    }
}

public class HitSpaceShip {

    public int numHitSpaceship(Stone [] stones) {
        if (stones == null || stones.length <= 1) {
            return 0;
        }
        Stack<Stone> stack = new Stack<>();

        for (int i = 0; i < stones.length - 1; i++) {
            Stone cur = stones[i];
            if (stack.isEmpty()) {
                stack.push(cur);
            } else {
                Stone lastStone = stack.peek();
                if (!cur.isRight) {
                    while (!stack.isEmpty() && lastStone.mass <= cur.mass) {
                        //last stone gone
                        stack.pop();
                        lastStone = stack.peek();
                        // System.out.println(lastStone.mass + " " + cur.mass);
                    }
                } else {
                    stack.push(cur);
                }
            }

        }
        // System.out.println(stack.peek().mass);
        return stack.size();
    }
    public static void main(String[] args) {
        Stone [] stones = new Stone[6];
        stones[0] = new Stone(11, true);
        stones[1] = new Stone(5, true);
        stones[2] = new Stone(10, true);
        stones[3] = new Stone(6, true);
        stones[4] = new Stone(1, false);
        stones[5] = null;
        HitSpaceShip solution = new HitSpaceShip();
        System.out.println(solution.numHitSpaceship(stones));
    }
}
