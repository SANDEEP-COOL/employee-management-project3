package emart.pojo;

public class UserProfile {

//    To access the current logged user in another frame we are creating this class , it is static because we don't want to 
//    create object again , 
    private static String username;
    private static String usertype;
    private static String userid;

    //getters
    public static String getUserName() {
        return username;
    }

    public static String getUserType() {
        return usertype;
    }

    public static String getUserId() {
        return userid;
    }

    //setters
    public static void setUserName(String name) {
        username = name;
    }

    public static void setUserType(String type) {
        usertype = type;
    }

    public static void setUserId(String id) {
        userid = id;
    }
}
