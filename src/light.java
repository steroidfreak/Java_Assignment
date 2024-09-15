import java.util.Scanner;

abstract class Light {
    protected String name;
    protected int power;
    protected double price;
    protected String mounting;
    protected String type;

    public Light(){
        name = "N/A";
        power = 0;
        price = 0.0;
    }

    public abstract String displayType();

    public Light(String name,int power, double price){
        this.name = name;
        this.power = power;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public int getPower(){
        return power;
    }
    public double getPrice(){
        return price;
    }



    public void setMounting(String mounting){
        this.mounting=mounting;
    }

    public void setType(String type){
        this.type=type;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPower(int power){
        this.power = power;
    }
    public void setPrice(double price){
        this.price = price;
    }


    public void edit(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the new name: ");
        this.name = sc.nextLine();
        System.out.print("Enter the new power: ");
        this.power = sc.nextInt();
        System.out.print("Enter the new price: ");
        this.price = sc.nextDouble();

    }

}
