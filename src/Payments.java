
public class Payments {
     private int id;
    private String employee_name;
    private String position;
    private float givepays;
    private float totalbalance;
    private float balance;
    
     public Payments(int id, String employeeName, float balance, String position, float givepays, float totalbalance){
         this.id= id;
        this.employee_name= employeeName;
        this.balance = balance;
        this.position= position;
        this.givepays = givepays;
        this.totalbalance= totalbalance;
        
     }public int getid(){
         return id;
     }public String getemployeeName(){
         return employee_name;
     }public float getBalance(){
         return balance;
     }public String getposition(){
         return position;
     }public float getPays(){
         return givepays;
     }public float getTotalbalance(){
         return totalbalance;
     }
}
