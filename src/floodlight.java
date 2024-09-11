import java.util.Scanner;

class Floodlight extends Light{
    private String type;

    public Floodlight(){
        type = "N/A";
    }
    public Floodlight(String name, int power, double price,String type){
        super(name, power, price);
        this.type = type;
    }
    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    @Override
    public void displayType(){
        System.out.println("This is a floodlight");
    }
    public void edit(){
        super.edit();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the new type: ");
        this.type = sc.nextLine();

    }
}
