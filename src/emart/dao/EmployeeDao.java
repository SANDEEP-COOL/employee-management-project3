package emart.dao;

//we make employeeDao class because now we interact with employee table
import emart.dbutil.DbConnection;
import emart.pojo.EmployeePojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmployeeDao {

//    when manager will click on add employee button then addEmployee frame will be opened and when the frame is opened , we want to show the new employee id which will be greater then the id of last added employee
    public static String getnextEmployeeId() throws SQLException {

        //get DB connection
        Connection conn = DbConnection.getConnection();

        //query is static
        Statement st = conn.createStatement();

        //execute the query , max(columnName) gives us the maximum value presented in column , and max() spacialty is this , max() can be applied in every type of data type
        ResultSet rs = st.executeQuery("select max(empid) from employees");

        rs.next();
        String empidstr = rs.getString(1);
        int empid = Integer.parseInt(empidstr.substring(1));
        empid += 1;
        return "e" + empid;
    }

    public static boolean addEmployee(EmployeePojo empPojo) throws SQLException {
        //getConnection
        Connection conn = DbConnection.getConnection();
        //query is dynamic , create PreparedStatement
        PreparedStatement ps = conn.prepareStatement("insert into employees values(?,?,?,?)");
        ps.setString(1, empPojo.getEmpId());
        ps.setString(2, empPojo.getEmpName());
        ps.setString(3, empPojo.getJob());
        ps.setDouble(4, empPojo.getSalary());
        //firing query on the DB
        int x = ps.executeUpdate();
        if (x == 0) {
            return false;
        }
        return true;
    }

    //a method which will return all employee details
    public static List<EmployeePojo> getAllEmp() throws SQLException {
//        get Connection
        Connection conn = DbConnection.getConnection();
//        query is static
        Statement st = conn.createStatement();
//        executing query on the DB
        ResultSet rs = st.executeQuery(" select * from employees order by empid ");
//        getting all columns value for each row , and storing those all column values in EmployeePojo object , and storing all these objects into arraylist and finally returing a list
        List<EmployeePojo> emplist = new ArrayList<EmployeePojo>();
        while (rs.next()) {
//            create EmployeePojo object
            EmployeePojo emppojo = new EmployeePojo();
//            getting all columns values for each row
            emppojo.setEmpId(rs.getString(1));
            emppojo.setEmpName(rs.getString(2));
            emppojo.setJob(rs.getString(3));
            emppojo.setSalary(4);
            emplist.add(emppojo);
        }
        return emplist;
    }

//////////////////////////for updating employee , these methods will help/////////////////////////////////////    
//    creating a method which will return all employee's id
    public static List<String> getAllEmpId() throws SQLException {
//        get connection 
        Connection conn = DbConnection.getConnection();
//        query is static
        Statement st = conn.createStatement();
//        execute the query to the DB
        ResultSet rs = st.executeQuery(" select empid from employees order by empid");
//        we are going to return all employee's id into an arraylist
        List<String> emplist = new ArrayList<String>();
//        getting all empid from rs
        while (rs.next()) {
            emplist.add(rs.getString(1));
        }
//        return emplist
        return emplist;
    }

//    this methods returns that employee record which is match with this id
    public static EmployeePojo findEmpById(String empID) throws SQLException {
////       getConnection
//        Connection conn = DbConnection.getConnection();
////        query is dynamic , create PreparedStatement Object
//        PreparedStatement ps = conn.prepareStatement("select * from employeestable where empid=?");
////        replacing the placeholder , and complete ps
//        ps.setString(1, empID);
////        execute the query to the DB
//        ResultSet rs = ps.executeQuery();
//        EmployeePojo emppojo = new EmployeePojo();
//        if (rs.next()) {
//            System.out.println(rs.getString(1)+" , "+rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getString(4));
//            emppojo.setEmpId(rs.getString(1));
//            emppojo.setEmpName(rs.getString(2));
//            emppojo.setJob(rs.getString(3));
//            emppojo.setSalary(rs.getInt(4));
//        }
////        System.out.println(emppojo.toString());
//        return emppojo;

        Connection conn = DbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from employees where empid = ?");
        ps.setString(1, empID);
        ResultSet rs = ps.executeQuery();
        EmployeePojo e = new EmployeePojo();
        if(rs.next()) {
            System.out.println(rs.getString(1)+" , "+rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getInt(4));
            e.setEmpId(rs.getString(1));
            e.setEmpName(rs.getString(2));
            e.setJob(rs.getString(3));
            e.setSalary(rs.getInt(4));
        }
        return e;
    }

    public static boolean updateEmp(EmployeePojo emppojo) throws SQLException {
//        get connection
        Connection conn = DbConnection.getConnection();
//        the query is dynamic , so create PreparedStatement object
        PreparedStatement ps = conn.prepareStatement("update employees set empname=?,job=?,salary=? where empid=?");
//        replacing placeholder , call setters of ps
        ps.setString(1, emppojo.getEmpName());
        ps.setString(2, emppojo.getJob());
        ps.setInt(3, emppojo.getSalary());
        ps.setString(4, emppojo.getEmpId());
//        execute the query which will return you an object of resultSet
        int x = ps.executeUpdate();
        if (x == 0) {
            return false;
        } //        if x value is 1 meaning is that one employee is updated successfully! , but now if that same employee exists in the usertable then update usertable as otherwise don't update userstable
        else {
            
//            check whether this same employee is presented in the userstable or not 
            boolean result = UserDao.isUserPresented(emppojo.getEmpId());
            if(result==false) 
                return true;
//        but if that employee is presented in the userstable then we shoulad also update that employee in users table 
//        again we need to fire a query , and the query is dynamic , create PreparedStatement
            ps = conn.prepareStatement("update users set username=? , usertype=? where empid=?");
            System.out.println("usertable also updated");
//        replacing placeholders , call setters of ps 
            ps.setString(1, emppojo.getEmpName());
            ps.setString(2, emppojo.getJob());
            ps.setString(3, emppojo.getEmpId());
//        now this query has to fired to the DB
            int y = ps.executeUpdate();
            return y == 1;
        }

    }
///////////////////////////////Above  whole code for updating employee/////////////////////////////////////////
    
//////////////////////////////////Deleting an employee from the employeetable//////////////////////////////////
    
//    1 when we will delete any employee record from the employeestable(a record which is prsented in userstable as well) due to foreign key constraint(of userstable in empid) oracle will not let us allow to delete any record from the employeestable(parent table) as long as that same record is presented in the userstable(child table)
//    2 now for performing deletion we will have to use on delete cascade clause , which will automatically delete a record from the child table , which is also deleted from the employeestable
//    3 but in our case , science the constraint is added so we can't use on delete cascade clause
//    4 so firstly we will drop the contraint from the userstable and after that we will applay this clause and then apply constraint
//    important commands fired in oracle
//    ==================================
    
//    5 select constraint_name,constraint_type
//      2  from user_constraints
//      3  where table_name='USERSTABLE'; 
//    6 alter table userstable drop constraint empid_employeestable_fk;
//    7 alter table userstable add constraint EMPID_EMPLOYEESTABLE_FK foreign key(empid) references employeestable(empid) on delete cascade;
    
    public static boolean deleteEmp( String empid ) throws SQLException{
//        get connection
        Connection conn = DbConnection.getConnection();
//        query is dynamic , create PreparedStatement
        PreparedStatement ps = conn.prepareStatement("delete from employees where empid=?");
//        replacing placeholder , call setters of ps
        ps.setString(1, empid);
//        execute query to the DB
        int x = ps.executeUpdate();
        return x == 1;
    }
    
//////////////////////////////////Deleting an employee from the employeetable//////////////////////////////////

}
