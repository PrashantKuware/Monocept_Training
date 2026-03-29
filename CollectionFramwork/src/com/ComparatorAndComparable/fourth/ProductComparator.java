package com.ComparatorAndComparable.fourth;

import java.util.Comparator;

class ProductComparator implements Comparator<Product> {

    public int compare(Product p1, Product p2) {

        // Comparing category
        int result = p1.getCategory().compareToIgnoreCase(p2.getCategory());

        if(result != 0)
            return result;

        //Comparing price if category same
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}