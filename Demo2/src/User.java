
public class User {
    private String userName;
    private int userID;
    private  int userType;
    private String userPass;


    public User(String userName, int userID, int userType, String userPass) {
        this.userName = userName;
        this.userID = userID;
        this.userType = userType;
        this.userPass = userPass;
    }


    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }



}
