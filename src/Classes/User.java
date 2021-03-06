package Classes;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private int id;
    private String password;
    private String typeOfUser;
    protected OracleDatabase db;
    Connection con; 
    
    public User() throws SQLException {
        
        db = new OracleDatabase();
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

    public String getTypeOfUser(int id) {
        String query = String.format("SELECT ROLE FROM USERS WHERE USERNAME='%s'", String.valueOf(id));
        System.out.println(query);
        ArrayList<HashMap<String,Object>> data = db.execute(query);
                
        if(data == null || data.isEmpty())
        {
            return null;
        }
        else
        {
            return data.get(0).get("ROLE").toString();
        }
        
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }


    public boolean signIn(int id,String password){
        String query = String.format("select PASSWORD from USERS where USERNAME='%s'", id);
        ArrayList<HashMap<String,Object>> data = db.execute(query);
                
        if(data == null || data.isEmpty())
        {
            return false;
        }
        else
        {
            String p=data.get(0).get("PASSWORD").toString();
            if(p.equalsIgnoreCase(password))
            {
                return true;
            }
            
            return false;
        }
        
    }
    public boolean changePassword(int id,String oldPassword,String newPassword){
        String query = String.format("select PASSWORD from USERS where USERNAME='%s'", id);
        ArrayList<HashMap<String,Object>> data = db.execute(query);

        if(data == null || data.isEmpty())
        {
            return false;
        }
        else
        {
            String p=data.get(0).get("PASSWORD").toString();
            if(p.equalsIgnoreCase(oldPassword))
            {
            String updatequery = String.format("update USERS set PASSWORD='%s' where USERNAME='%s'",newPassword,id);
            System.out.println(updatequery);
            db.execute(updatequery);
                return true;
            }
            
            return false;
        }
        
    }
    public void viewSchedule(int id){
        String query = String.format("select * from exam_bookings where id=%d", id);
        ArrayList<HashMap<String,Object>> data = db.execute(query);
    }
}
}

