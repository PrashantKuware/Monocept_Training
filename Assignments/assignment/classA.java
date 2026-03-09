
class Parent
{
   Parent(){
	   System.out.println("Parent Constructor: ");
   }
}

class Child extends Parent
{
    int num = 200;

     Child()
    {
    	 super();
        System.out.println("Child num: " + num);
    }
}

 class classA
{
    public static void main(String[] args)
    {
        Child c = new Child();
       
    }
}