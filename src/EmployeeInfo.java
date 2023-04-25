
public class EmployeeInfo {
    private int id;
    private String employeeName;
    private String gender;
    private String address;
    private Double balance;
    private String position;
    
    public EmployeeInfo(int id, String employeeName, String gender, String address, Double balance, String position){
        this.id=id;
        this.employeeName =employeeName;
        this.gender= gender;
        this.address= address;
        this.balance=balance;
        this.position= position;
    }
    public int getId(){
        return id;
        
    }public String getname(){
        return employeeName;
    }public String getgender(){
        return gender;
        
    }public String getaddress(){
        return address;
        
    }public Double getbalance(){
        return balance;
    }public String getposition(){
        return position;
    }
}
