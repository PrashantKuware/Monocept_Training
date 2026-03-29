package com.ComparatorAndComparable.fifth;

import java.util.Comparator;

class TransactionComparator implements Comparator<Transaction> {

    public int compare(Transaction t1, Transaction t2) {

        int result = Double.compare(t2.getAmount(), t1.getAmount());

        if(result != 0)
            return result;

        return Integer.compare(t1.getId(), t2.getId());
    }
}