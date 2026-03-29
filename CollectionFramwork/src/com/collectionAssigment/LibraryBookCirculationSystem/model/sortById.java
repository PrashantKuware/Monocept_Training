package com.collectionAssigment.LibraryBookCirculationSystem.model;

import java.util.Comparator;


public class sortById implements Comparator<Product> 
{

    public int compare(Product p1, Product p2) {

       
       return Integer.compare(p1.getId(),p2.getId());

    }
}
