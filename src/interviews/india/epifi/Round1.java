package interviews.india.epifi;

import java.util.*;

class Round1 {

    static class Combo {
        String combo;
        int moves;

        public Combo(String combo, int moves) {
            this.combo = combo;
            this.moves = moves;
        }
    }


    public static int minMove(String passcode, String[] deadEnds) {
        int res = -1;
        Map<String, Boolean> deadEndMap = new HashMap<>();
        for (String lock : deadEnds) deadEndMap.put(lock, Boolean.TRUE);
        // corner case
        if(deadEndMap.containsKey("0000")) return res;

        Queue<Combo> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(new Combo("0000", 0));
        while (!queue.isEmpty()) {
            Combo c = queue.poll();
            String code = c.combo;
            int moves = c.moves;
            if (set.contains(code)) continue;
//            System.out.println("current code: " + code + ", moves: " + moves);
            if (code.equals(passcode)) {
                if (res == -1) res = moves;
                else res = Math.min(res, moves);
                System.out.println("Match found at move: " + moves);
                continue;
            }
            for (String nextMove: getNextStates(code)) {
                if (!set.contains(nextMove) && !deadEndMap.containsKey(nextMove)) queue.offer(new Combo(nextMove, moves + 1));
            }
            set.add(code);
        }
        return res;
    }

    private static Set<String> getNextStates(String lock) {
        Set<String> newLocks = new HashSet<>();
        char[] lockChar = lock.toCharArray();
        for (int i = 0; i < 4; i++) {

            char c = lockChar[i];
            // moving clockwise
            lockChar[i] = c == '9' ? '0' : (char) (c + 1);
            newLocks.add(new String(lockChar));
            // moving anticlockwise
            lockChar[i] = c == '0' ? '9' : (char) (c -1);
            newLocks.add(new String(lockChar));
            lockChar[i] = c;
        }
        return newLocks;
    }

    public static void main(String[] args) {
        String passcode = "2325";
        String[] deadEnds = {"2324", "2327", "2310", "2300"};
        String passcode1 = "8888";
        String[] deadEnds1 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        System.out.println("Min move required: " + minMove(passcode, deadEnds));
//        System.out.println("Min move required: " + minMove(passcode1, deadEnds1));

    }
}
