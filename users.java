package lockme.com;

public class users {
    
    private String userName;
    private String password;
    
    
    public users() {}
    
    public users(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

   
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    
    @Override
    public String toString() {
        return "Your information \n" + "User Name: " + userName 
                + "\nPassword: " + password;
    }
    
}