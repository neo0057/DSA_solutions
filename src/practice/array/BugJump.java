package practice.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/minimum-jumps-to-reach-home/
public class BugJump {
    static class Jump {
        int pos;
        int backCount;

        public Jump(int pos, int backCount) {
            this.pos = pos;
            this.backCount = backCount;
        }
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        for (int j : forbidden) visitedMap.put(j, true);
        Queue<Jump> queue = new LinkedList<>();
        queue.offer(new Jump(0, 0));
        int jumpCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Jump jump = queue.poll();
                if (jump.pos == x) return jumpCount;
                if (visitedMap.containsKey(jump.pos)) continue;
                visitedMap.put(jump.pos, true);
                System.out.println("curr position: " + jump.pos);
                if (jump.pos + a < 10000) queue.offer(new Jump(jump.pos + a, 0));
                if (jump.pos - b >= 0 && jump.backCount == 0 && !visitedMap.containsKey(jump.pos - b)) queue.offer(new Jump(jump.pos - b, 1));
            }
            jumpCount++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] forbidden = {14, 4, 18, 1, 15};
        int[] forbidden1 = {8, 3, 16, 6, 12, 20};
        int[] forbidden2 = {162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98};
        BugJump bugJump = new BugJump();
//        System.out.println(bugJump.minimumJumps(forbidden, 3, 15, 9));
//        System.out.println(bugJump.minimumJumps(forbidden1, 15, 13, 11));
        System.out.println(bugJump.minimumJumps(forbidden2, 29, 98, 80));
    }
}
