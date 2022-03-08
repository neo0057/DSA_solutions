package interviews.deliverr;

import java.time.LocalDate;
import java.time.YearMonth;

public class Challenge {
    public static double billFor(String month, Subscription activeSubscription, User[] users) {
        if (activeSubscription == null) return 0;
        if (users.length <= 0) return 0;
        int perMonthCost = activeSubscription.monthlyPriceInDollars;
        String[] str = month.split("-");
        Integer currentYear = Integer.valueOf(str[0]);
        Integer currentMonthNumber = Integer.valueOf(str[1]);
        double totalBill = 0;
        for (User user : users) {
            LocalDate activatedOn = user.activatedOn;
            LocalDate deactivatedOn = user.deactivatedOn;
            int activationYear = activatedOn.getYear();
            int activationMonth = activatedOn.getMonthValue();
            int activationDay = activatedOn.getDayOfMonth();
            if (activationYear <= currentYear && activationMonth <= currentMonthNumber) {
                YearMonth yearMonth = YearMonth.of(currentYear, currentMonthNumber);
                int daysInMonth = yearMonth.lengthOfMonth();
                if (deactivatedOn == null) {
                    int totalDaysUsed = Math.abs(activationMonth - currentMonthNumber) > 0 ? daysInMonth : (Math.abs(daysInMonth - activationDay + 1));
                    if (totalDaysUsed == daysInMonth) totalBill += perMonthCost * 1.0;
                    else totalBill += ((perMonthCost*1.0) / daysInMonth) * totalDaysUsed * 1.0;
                } else if (deactivatedOn.getMonthValue() > currentMonthNumber) totalBill += perMonthCost;
                else {
                    int totalDaysUsed = Math.abs(daysInMonth - deactivatedOn.getDayOfMonth() + 1);
                    totalBill += ((perMonthCost*1.0) / daysInMonth) * totalDaysUsed * 1.0;
                }
            }
        }
        totalBill = (double) Math.round(totalBill * 100) / 100;
        return totalBill;
    }

    public static double billFor2(String month, Subscription activeSubscription, User[] users) {
        if (activeSubscription == null) return 0;
        if (users.length <= 0) return 0;
        int perMonthCost = activeSubscription.monthlyPriceInDollars;

        String[] str = month.split("-");
        Integer currentYear = Integer.valueOf(str[0]);
        Integer currentMonthNumber = Integer.valueOf(str[1]);
        double totalBill = 0;
        for (User user : users) {
            LocalDate activatedOn = user.activatedOn;
            LocalDate deactivatedOn = user.deactivatedOn;
            int activationYear = activatedOn.getYear();
            int activationMonth = activatedOn.getMonthValue();
            int activationDay = activatedOn.getDayOfMonth();
            if (activationYear <= currentYear && activationMonth <= currentMonthNumber) {
                YearMonth yearMonth = YearMonth.of(currentYear, currentMonthNumber);
                int daysInMonth = yearMonth.lengthOfMonth();
                if (deactivatedOn == null) {
                    int totalDaysUsed = Math.abs(activationMonth - currentMonthNumber) > 0 ? daysInMonth : (Math.abs(daysInMonth - activationDay + 1));
                    if (totalDaysUsed == daysInMonth) totalBill += perMonthCost * 1.0;
                    else totalBill += ((perMonthCost*1.0) / daysInMonth) * totalDaysUsed * 1.0;
                } else if (deactivatedOn.getMonthValue() > currentMonthNumber) totalBill += perMonthCost;
                else {
                    int totalDaysUsed = Math.abs(daysInMonth - deactivatedOn.getDayOfMonth() + 1);
                    totalBill += ((perMonthCost*1.0) / daysInMonth) * totalDaysUsed * 1.0;
                }
            }
        }
        totalBill = (double) Math.round(totalBill * 100) / 100;
        return totalBill;
    }

    public static void main(String[] args) {
        String month = "2019-01";
        Subscription activeSubscription = new Subscription(1, 1, 4);
        User[] users = new User[2];
        LocalDate activatedOn = LocalDate.of(2018, 11, 4);
        users[0] = new User(1, "e1", activatedOn, null, 1);
        users[1] = new User(2, "e2", LocalDate.of(2019, 1, 10), null, 1);
        System.out.println(billFor(month, activeSubscription, users));
    }
}
