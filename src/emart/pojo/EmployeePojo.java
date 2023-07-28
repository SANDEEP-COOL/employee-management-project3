
package emart.pojo;


public class EmployeePojo {
    
    //everytime when we create any pojo class that time we keep those many data members , how many are prsented in that table
    private String empid;
    private String empname;
    private String job;
    private int salary;
    
    //we create setters and getters in pojo class
    public String getEmpId(){
    return empid;
    }
    public String getEmpName(){
    return empname;
    }
    public String getJob(){
    return job;
    }
    public int getSalary(){
    return salary;
    }
    
    //setters
    public void setEmpId(String empid){
    this.empid = empid;
    }
    public void setEmpName(String empname){
    this.empname = empname;
    }
    public void setJob(String job){
    this.job = job;
    }
    public void setSalary(int salary){
    this.salary = salary;
    }
    
    public String toString(){
        return empid+" , "+empname+" , "+job+" , "+salary;
    }
}
