package practice.array;

import java.util.*;

public class InvalidTransactions {

    static class Transaction {
        String name, city, transaction;
        int time, amount;

        public Transaction(String transaction) {
            this.transaction = transaction;
            String[] arr = transaction.split(",");
            this.name = arr[0];
            this.time = Integer.parseInt(arr[1]);
            this.amount = Integer.parseInt(arr[2]);
            this.city = arr[3];
        }

        public boolean isValidAmount() {
            return this.amount > 1000;
        }

        public boolean isInvalidCity(Transaction t) {
            return Math.abs(this.time - t.time) <= 60 && !this.city.equalsIgnoreCase(t.city);
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();
        Map<String, List<Transaction>> transactionMap = new HashMap<>();
        for (String transaction : transactions) {
            transactionMap.compute(transaction.split(",")[0], (key, value) -> value == null ? new ArrayList<>() : value).add(new Transaction(transaction));
        }
        for (List<Transaction> userTransactionList : transactionMap.values()) {
            for (Transaction transaction : userTransactionList) {
                if (transaction.isValidAmount()) result.add(transaction.transaction);
                else {
                    for (Transaction otherTransaction : userTransactionList) {
                        if (transaction.isInvalidCity(otherTransaction)) {
                            result.add(transaction.transaction);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] transactions = {"alice,20,800,mtv", "alice,50,1200,mtv"};
        InvalidTransactions invalidTransactions = new InvalidTransactions();
        System.out.println(invalidTransactions.invalidTransactions(transactions));
    }
}
