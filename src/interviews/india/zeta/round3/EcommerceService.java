package interviews.india.zeta.round3;

import java.util.Scanner;

public class EcommerceService {
    LockerService lockerService = new LockerService();

    public int assignLocker(int userId, String itemName) throws Exception {
        return lockerService.assignLocker(userId, itemName);
    }

    public int returnItem(int userId, String itemName) throws Exception {
        return lockerService.returnItem(userId, itemName);
    }

    public void unlockLocker(int userId, int otp) {
        lockerService.unlockLocker(userId, otp);
    }

    public static void main(String[] args) {
        EcommerceService ecommerceService = new EcommerceService();
        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("Options:");
//            System.out.println("1: put item in locker");
//            System.out.println("2: return item");
//            System.out.println("3: unlock locker");
//        }
    }
}
