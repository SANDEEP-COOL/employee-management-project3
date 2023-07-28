package emart.dao;

import emart.dbutil.DbConnection;
import emart.pojo.ProductPojoTotal;
import emart.pojo.ProductsPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

//    we make a method which generates the new product id , since we will have to talk to the DB(products table) for knowing the last product is added in the table that's  why we write code of generating the new product id in the products table;
    public static String getNewProductId() throws SQLException {
//        get Connection
        Connection conn = DbConnection.getConnection();
//        query is static , that's we create Statement
        Statement st = conn.createStatement();
//        execute query 
        ResultSet rs = st.executeQuery("select max(p_id) from products");
        rs.next();
        String strProdId = rs.getString(1);
        if (strProdId != null) {

            int prodId = Integer.parseInt(strProdId.substring(1));
            //add one to generate new productID
            prodId += 1;
            return "p" + prodId;

        }
        return "p" + 101;
    }

//    method for adding product in the productstable
    public static boolean addProduct(ProductsPojo p) throws SQLException {
//        get connection
        Connection conn = DbConnection.getConnection();
//        query is dynamic , create PreparedStatement
        PreparedStatement ps = conn.prepareStatement(" insert into products values(?,?,?,?,?,?,?,'Y') ");
//        replacing placeholders , call setters of ps
        ps.setString(1, p.getPid());
        ps.setString(2, p.getPname());
        ps.setString(3, p.getPcompany());
        ps.setDouble(4, p.getPprice());
        ps.setDouble(5, p.getOurprice());
        ps.setInt(6, p.getPtax());
        ps.setInt(7, p.getQuantity());
//        execute query to the DB
        int x = ps.executeUpdate();
        return x == 1;
    }

    public static List<ProductsPojo> getAllProductsDetails() throws SQLException {
//        get Connection
        Connection conn = DbConnection.getConnection();
//        query is static , create Statement
        Statement st = conn.createStatement();
//        executing query
        ResultSet rs = st.executeQuery(" select * from products where status='Y' order by p_id ");
//        while(rs.next()){
//            
//            System.out.println(rs.getString(1)+" , "+rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getString(4)+" , "+rs.getString(5)+" , "+rs.getString(6)+" , "+rs.getString(7));
//            
//        }
//        rs.beforeFirst();
//        create a list which will contain ProductsPojo objects
        List<ProductsPojo> productList = new ArrayList();

        while (rs.next()) {
            ProductsPojo p = new ProductsPojo();
            p.setPid(rs.getString(1));
            p.setPname(rs.getString(2));
            p.setPcompany(rs.getString(3));
            p.setPprice(rs.getDouble(4));
            p.setOurprice(rs.getDouble(5));
            p.setPtax(rs.getInt(6));
            p.setQuantity(rs.getInt(7));
            System.out.println(p);
            productList.add(p);
        }

//        System.out.println(p);
        return productList;
    }



public static boolean deleteProduct(String poductId) throws SQLException {
//        get Connection
        Connection conn = DbConnection.getConnection();
//        now if we want to delete any product from the products table , so rather then any delete query we will simply write one update query because we have to delete the product logically not physically and for logically we will have to update the status of product from Y to N
//        query is dynamic , create PreparedStatement
        PreparedStatement ps = conn.prepareStatement(" update products set status='N' where p_id=? ");
//        replacing placeholder
        ps.setString(1, poductId);
//        execute query to the DB
        return ps.executeUpdate() == 1;
    }

    public static boolean updateProduct(ProductsPojo p) throws SQLException {
//        get Connection
        Connection conn = DbConnection.getConnection();
//        query is dynamic , create preparedStatement
        PreparedStatement ps = conn.prepareStatement(" update products set p_name=?,p_comanyname=?,P_price=?,our_price=?,p_tax=?,quantity=? where p_id=? ");
//        replacing placeholders , call setters of ps
        ps.setString(1, p.getPname());
        ps.setString(2, p.getPcompany());
        ps.setDouble(3, p.getPprice());
        ps.setDouble(4, p.getOurprice());
        ps.setInt(5, p.getPtax());
        ps.setInt(6, p.getQuantity());
        ps.setString(7, p.getPid());
//        execute query to the DB
        return ps.executeUpdate() == 1;
    }
    
    
    public static ProductPojoTotal getProductById(String id) throws SQLException{
//        get Connection
        Connection conn = DbConnection.getConnection();
//        the query is dynamic , so we create preparedStatement object
        PreparedStatement ps = conn.prepareStatement(" select * from products where p_id=? and status='Y'");
//        replacing placeholders , call setters of ps
        ps.setString(1, id);
//        execute the query to the DB
        ResultSet rs = ps.executeQuery();
        ProductPojoTotal p = new ProductPojoTotal();
        if ( rs.next() ){  
            p.setPid(rs.getString(1));
            p.setPname(rs.getString(2));
            p.setPcompany(rs.getString(3));
            p.setPprice(rs.getDouble(4));
            p.setOurprice(rs.getDouble(5));
            p.setQuantity(rs.getInt(7));
            System.out.println(rs.getInt(7));
            p.setPtax(rs.getInt(6));
//            return p;
        }
        return p;
    }
    
    public boolean updateStocks( List<ProductPojoTotal> ProductsList ) throws SQLException{
//       get Connection 
        Connection conn = DbConnection.getConnection();
//        query is dynamic so create preparedStatement
        PreparedStatement ps = conn.prepareStatement(" update products set quantity = quantity - ? where p_id = ? ");
//        itrate a loop because in the productList there are multiple products , and since there are multiple products we will have to update quantity for those multiple products , so the query to DB will be fired multiple times that's why we will have to execute this query for multiple times
        int updatedRowsCount = 0;
        for ( ProductPojoTotal p : ProductsList ) {
//            replacing placeholders
            ps.setInt(1, p.getQuantity());
            ps.setString(2, p.getPid());
            int row = ps.executeUpdate();
//            check whether this row has been updated or not
            if ( row!=0 ) {
//                means this row is basically updated , so increase updatedRowsCount
                updatedRowsCount++;
            }
        } 
//        now we compare the length of productList with updatedRowsCount , so if they are eqaul means all the products are updated , return true
        return ProductsList.size()==updatedRowsCount;
    }
}
