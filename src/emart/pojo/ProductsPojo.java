
package emart.pojo;


public class ProductsPojo {

    @Override
    public String toString() {
        return "ProductsPojo{" + "pid=" + pid + ", pname=" + pname + ", pcompany=" + pcompany + ", pprice=" + pprice + ", ourprice=" + ourprice + ", ptax=" + ptax + ", quantity=" + quantity + '}';
    }

    public ProductsPojo(){
    
    }
    
    public ProductsPojo(String pid, String pname, String pcompany, double pprice, double ourprice, int ptax, int quantity) {
        this.pid = pid;
        this.pname = pname;
        this.pcompany = pcompany;
        this.pprice = pprice;
        this.ourprice = ourprice;
        this.ptax = ptax;
        this.quantity = quantity;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcompany() {
        return pcompany;
    }

    public void setPcompany(String pcompany) {
        this.pcompany = pcompany;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    public double getOurprice() {
        return ourprice;
    }

    public void setOurprice(double ourprice) {
        this.ourprice = ourprice;
    }

    public int getPtax() {
        return ptax;
    }

    public void setPtax(int ptax) {
        this.ptax = ptax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    private String pid;
    private String pname;
    private String pcompany;
    private double pprice;
    private double ourprice;
    private int ptax;
    private int quantity;
    
    //in productspojo class we are not taking status(i don't know the exact reason) but still in know that we will assign status value explicitly , when we will add any product then we will keep status value 'Y' otherwise we will keep status value 'N'
    
    
}
