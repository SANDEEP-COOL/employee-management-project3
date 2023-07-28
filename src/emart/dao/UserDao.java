package emart.dao;

import emart.dbutil.DbConnection;
import emart.pojo.UserPojo;
import emart.pojo.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

//    userDao class is used for login frame , this is public because we access this method from the login frame , static beacause in userDao class there is no instance data member , 
    public static boolean validateUser(UserPojo user) throws SQLException {

        //validate , firstly getting database connection
        Connection conn = DbConnection.getConnection();

//        query is dynamic , that's why we use prepared statement , check based upon userid,password,type
        PreparedStatement ps = conn.prepareStatement("select * from users where userid=? and password=? and usertype=?");

//        System.out.println(user.getUserId());
//        System.out.println(user.getPassword());
//        System.out.println(user.getUserType());
        
        
//        replacing the placeholders , by calling setters of ps
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
//        now the preparedStatement is fully ready
    
//        now we fire the query to the DB
        ResultSet rs = ps.executeQuery();

//        System.out.println(rs.next());
        
//        check wheter the row is selected or not
        if (rs.next()) {
//          assigning username into UserProfile's username , because it has be used
            UserProfile.setUserName(rs.getString(5));
            System.out.println(UserProfile.getUserName());
            return true;
        }
        return false;
    }

    //for knowing whether the user is presented , or not
    public static boolean isUserPresented(String empid) throws SQLException{
//        getConnection
        Connection conn = DbConnection.getConnection();
//        query is dynamic , create PreparedStatement
            PreparedStatement ps = conn.prepareStatement("select 1 from users where empid=?");
//        replacing placeholders , call setters of PreparedStatement
        ps.setString(1, empid);
//        fire query to the DB
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}
