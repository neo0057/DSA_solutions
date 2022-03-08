package practice.array;

public class WaterAndJugProblem {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;
        if ((targetCapacity / gcd(jug1Capacity, jug2Capacity)) - Math.floor((targetCapacity / gcd(jug1Capacity, jug2Capacity))) == 0) return true;
        return false;
    }

    private double gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
