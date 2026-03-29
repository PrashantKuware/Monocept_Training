package com.collectionAssigment.LibraryBookCirculationSystem.model;

import java.util.Comparator;


public class sortByName implements Comparator<Product> 
{

    public int compare(Product p1, Product p2) 
    {

        return p1.getName().compareTo(p2.getName());

    }
}
