
package emart.pojo;

public class ProductPojoTotal {

    @Override
    public String toString() {
        return "ProductPojoTotal{" + "pid=" + pid + ", pname=" + pname + ", pcompany=" + pcompany + ", pprice=" + pprice + ", ourprice=" + ourprice + ", ptax=" + ptax + ", quantity=" + quantity + ", total=" + total + '}';
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    private String pid;
    private String pname;
    private String pcompany;
    private double pprice;
    private double ourprice;
    private int ptax;
    private int quantity;
    private double total;
}
