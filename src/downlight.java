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

    public void setMounting(String mounting){
        this.mounting = mounting;
    }

    @Override
    public String displayType(){
        System.out.println("This is a downlight");
        return "downlight";
    }
    public void edit(){
        super.edit();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the new mounting: ");
        this.mounting = sc.nextLine();

    }
}
