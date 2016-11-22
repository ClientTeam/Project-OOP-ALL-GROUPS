
package nameOfPackage;

public class Admin extends Instructor {
	// EMPTY ADMIN CLASS [FINAL COPY WILL DEFINETLY VARY]
    public Admin(){    
    }
    
    public boolean changePassword(int userId, String newPassword){
        return true;
    }
    
    public int addUser (UserType typeOfUser , String password){
        return 0;
    }
    
    public boolean modifyUser(int userId, UserType typeOfUser){
        return true;
    }
    
	public boolean deleteUser(int userId){
		return true;
	}
	
    public int generateId(){
        return 0;
    }
    
}
