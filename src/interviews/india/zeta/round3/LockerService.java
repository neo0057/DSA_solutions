package interviews.india.zeta.round3;

import java.util.*;

public class LockerService {
    private static final int NUMBER_OF_LOCKERS = 1000;
    private static final Object lock = new Object();
    private Map<Integer, List<Locker>> usedLockerMap;
    private Map<Integer, List<Locker>> returnLockerMap;
    private Queue<Locker> freeLockers;
    private static final Random otpGenerator = new Random();

    public LockerService() {
        freeLockers = new LinkedList<>();
        this.usedLockerMap = new HashMap<>();
        for (int i = 1; i <= NUMBER_OF_LOCKERS; i++) {
            freeLockers.offer(new Locker(i));
        }
    }

    public int assignLocker(int userId, String itemName) throws Exception {
        int otp = generateOTP();
        Locker locker = null;
        synchronized (lock) {
            if (freeLockers.size() < NUMBER_OF_LOCKERS) {
                locker = freeLockers.poll();
            } else throw new Exception("No locker available");
        }
        assert locker != null;
        locker.itemName = itemName;
        locker.otp = otp;
        putLocker(userId, locker);
        return otp;
    }

    public void unlockLocker(int userId, int otp) {
        if (!usedLockerMap.containsKey(userId)) {
            System.out.println("No locker assign to user: " + userId);
            return;
        }
        List<Locker> assignedLocker = usedLockerMap.get(userId);
        Locker existingLocker = null;
        for (Locker locker : assignedLocker) {
            if (locker.otp == otp) {
                existingLocker = locker;
                break;
            }
        }
        if (existingLocker == null) {
            System.out.println("No locker found with given otp: ");
            return;
        }
        System.out.println("Locker unlocked");
        assignedLocker.remove(existingLocker);
        usedLockerMap.put(userId, assignedLocker);
        freeLockers.offer(existingLocker);
    }

    public int returnItem(int userId, String itemName) throws Exception {
        int otp = generateOTP();
        Locker locker = null;
        synchronized (lock) {
            if (freeLockers.size() < NUMBER_OF_LOCKERS) {
                locker = freeLockers.poll();
            } else throw new Exception("No locker available");
        }
        assert locker != null;
        locker.itemName = itemName;
        locker.otp = otp;
        putItemForReturn(userId, locker);
        return otp;
    }

    private void putLocker(int userId, Locker locker) {
        List<Locker> assignedLockers = (usedLockerMap.containsKey(userId)) ? usedLockerMap.get(userId) : new ArrayList<>();
        assignedLockers.add(locker);
        usedLockerMap.put(userId, assignedLockers);
    }

    private void putItemForReturn(int userId, Locker locker) {
        List<Locker> assignedLockers = (returnLockerMap.containsKey(userId)) ? returnLockerMap.get(userId) : new ArrayList<>();
        assignedLockers.add(locker);
        returnLockerMap.put(userId, assignedLockers);
    }

    private int generateOTP() {
        return otpGenerator.nextInt(100000, 999999);
    }
}
