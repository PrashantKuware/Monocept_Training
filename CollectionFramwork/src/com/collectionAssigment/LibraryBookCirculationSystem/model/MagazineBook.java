package com.collectionAssigment.LibraryBookCirculationSystem.model;

public class MagazineBook extends Product
{
//	String category = "Magazine";
//	STATUS status = STATUS.AVAILABLE;
	
	public MagazineBook(int id, String name, String author )
	{
		super( id,  name, author);
//		this.category = category;
	}
	
	
	
//	public String toString() {
//        return "Product { ID: " + id +
//                ", Book Name: " + name +
//                ", Author: " + author + ", Status : "+ status+" }";
//    }
}
