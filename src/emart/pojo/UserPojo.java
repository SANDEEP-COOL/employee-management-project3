/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.pojo;

/**
 *
 * @author sande
 */
public class UserPojo {

    private String userid;
    private String empid;
    private String password;
    private String usertype;
    private String username;

    //creating getters
    public String getUserId() {
        return userid;
    }

    public String getEmpId() {
        return empid;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return usertype;
    }

    public String getuserName() {
        return username;
    }

//    creating setters
    public void setUserId(String userid) {
        this.userid = userid;
    }

    public void setEmpId(String empid) {
        this.empid = empid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String usertype) {
        this.usertype = usertype;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    //creating toString method
    public String toString() {
        return userid + " , " + empid + " , " + password + " , " + usertype + " , " + username;
    }
}
