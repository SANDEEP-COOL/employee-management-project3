
package emart.dao;

import emart.dbutil.DbConnection;
import emart.pojo.ReceptionistPojo;
import emart.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceptionistDao {
    
//    since we are assuming this Receptionist module as a saperate part in the application , that's why i am maing one receptionist dao saperatly however i can make it's method in the usersDao also but that will not so much effecient
//    firstly we will write the logic of adding Receptionist , and those Receptionist which are only presented in the employees table not in the users table(means till now they are not able to use app they are just employee) but now if manager wanna give rights to use app so manager will have to add Receptionis in the userstable as well
//    now Id and name are value of kay-value-pair , that's why it returns a map , Map is an interface and HasMap is a child class which implements to Map
    
///////////////////////this method will return us receptionists(ID,Name) who are only prsented in the employeestable(not registered to use app) not in userstable///////////////////////////////////////////
    public static Map<String,String> getNonRegisteredReceptionists() throws SQLException{
//        get connection
        Connection conn = DbConnection.getConnection();
//        the query is static , create statement
        Statement st = conn.createStatement();
//        exceuting query to the DB , which extracts getNonRegisteredReceptionists
        ResultSet rs = st.executeQuery("  select empid,empname from employees where job='Receptionist' and not empid in (select empid from users where usertype='Receptionist')  ");
//        now adding empid and name in HashMap using put()
        Map<String,String> receptionistMap = new HashMap();
        while( rs.next() ) {
            String empid = rs.getString(1);
            String empname = rs.getString(2);
            //put empid and empname in HasMap
            receptionistMap.put(empid, empname);
        }
        return receptionistMap;
    }
//////////////////////////////////////////////////////////////Done!///////////////////////////////////////////////////////////////////    

///////////////////////////////////////////Now adding receptionist in userstable/////////////////////////////////////////////////////
    public static boolean addReceptionist(UserPojo upojo) throws SQLException{
//        get connection
        Connection conn = DbConnection.getConnection();
//        query is dynamic , create preparedStatement
        PreparedStatement ps = conn.prepareStatement(" insert into users values(?,?,?,?,?) ");
//        replace placeholders , call setters() of ps
        ps.setString(1 , upojo.getUserId());
        ps.setString(2 , upojo.getEmpId());
        ps.setString(3 , upojo.getPassword());
        ps.setString(4 , upojo.getUserType());
        ps.setString(5 , upojo.getuserName());
//        execute the query to the DB
        int x = ps.executeUpdate();
        return x==1;
    }
///////////////////////////////////////////Now adding receptionist in userstable/////////////////////////////////////////////////////  


    public static List<ReceptionistPojo> getAllReceptionist() throws SQLException{
//        getConnection
        Connection conn = DbConnection.getConnection();
//        query is static , create statement
        Statement st = conn.createStatement();
//        executing the query
        ResultSet rs = st.executeQuery( "select users.empid , empname , userid , job , salary from users,employees where usertype='Receptionist' and users.empid=employees.empid" );
//        create an arraylist
        List<ReceptionistPojo> receptionistlist = new ArrayList();
//        whose else record is fetched now we add those records in the ReceptionistPojo and add in the arraylsit
        while( rs.next() ){
            ReceptionistPojo receppojo = new ReceptionistPojo();
            receppojo.setEmpid(rs.getString(1));
            receppojo.setEmpname(rs.getString(2));
            receppojo.setUserid(rs.getString(3));
            receppojo.setJob(rs.getString(4));
            receppojo.setSalary(Integer.parseInt(rs.getString(5)));
            receptionistlist.add(receppojo);
        }
        return receptionistlist;
    }
    
    public static Map<String , String> getAllReceptionistIdName() throws SQLException{
    
//        getConnection
        Connection conn = DbConnection.getConnection();
//        query is static , create statmenet
        Statement st = conn.createStatement();
//        executeQuery
        ResultSet rs = st.executeQuery( "select userid,username from users where usertype='Receptionist' order by userid" );
//        create HashMap
        Map<String,String> recepList = new HashMap();
//        getting rsultSet Data
        while( rs.next() ) {
            String id = rs.getString(1);
            String name = rs.getString(2);
//            for adding data in HashMap we need to call put() , which takes two argument a : key , b : pair
            recepList.put(id, name);
        }
        return recepList;
    }
    
    public static boolean UpdateRecepPassword( String userid , String password ) throws SQLException{
//        getConnection
        Connection conn = DbConnection.getConnection();
//        query is dynamic , create preparedSTatement
        PreparedStatement ps = conn.prepareStatement( "update users set password=? where userid=?" );
//        replacing placeholders , call setters of ps
        ps.setString(1, password);
        ps.setString(2, userid);
//        now executing query to the DB
        int x = ps.executeUpdate();
        return x==1;
    }
    
    public static List<String> getAllRecepId() throws SQLException{
        List<String> recepIdList = new ArrayList();
//        get Connection
        Connection conn = DbConnection.getConnection();
//        query is static  , create Statement
        Statement st = conn.createStatement();
//        execute query
        ResultSet rs = st.executeQuery( "select userid from users where usertype='Receptionist' order by userid" );
        while( rs.next() ) {
            recepIdList.add(rs.getString(1));
        }
        return recepIdList;
    } 
    
    public static boolean deleteReceptionist(String userid) throws SQLException{
//        get connection
        Connection conn = DbConnection.getConnection();
//        query is dynamic , so create PreparedStatement
        PreparedStatement ps = conn.prepareStatement(" delete from users where userid=? ");
//        replacing placeholders , using setters of ps
        ps.setString(1, userid);
//        now prepared Statement is fully ready , executeQuery to the DB
        int x = ps.executeUpdate();
        return x==1;
    }
}
