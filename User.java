/**
 * Created by Petar on 10/19/2016.
 */
public class User {

    private int id;
    private String password;
    private UserType userType;


    /*
    * All methods return true temporarily
    * for the purpose of testing classes with the other teams (Database, Server, Web)
    *
    * */

    public boolean signIn(int id, String password) {
        return true;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        return true;
    }

    public void viewSchedule(ViewScheduleType viewScheduleType, String query) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
