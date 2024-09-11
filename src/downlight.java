import java.util.Scanner;

class Downlight extends Light{

    protected String mounting;

    public String Downlight(){
        return mounting = "N/A";
    }

    public Downlight(String name, int power, double price, String mounting){
        super(name, power, price);
        this.mounting = mounting;
    }

    public String getMounting() {
        return mounting;
    }

    @Override
    public void displayType(){
        System.out.println("This is a downlight");
    }
    public void edit(){
        super.edit();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the new mounting: ");
        this.mounting = sc.nextLine();

    }
}
