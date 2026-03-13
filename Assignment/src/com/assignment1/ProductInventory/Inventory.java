package assignment1.ProductInventory;

class Inventory {

    private Product[] products;
    private int count = 0;

    public Inventory(int size) 
    {
        products = new Product[size];
    }

    public void addProducts(Product product) 
    {

        if(count < products.length) 
        {
            products[count] = product;
            count++;
        }
        else {
            System.out.println("Inventory Full");
        }
    }

    public void displayDetails() {

        for(int i = 0; i < count; i++) 
        {
            products[i].display();
        }
    }
}