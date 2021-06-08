package lockme.com;

public class userCredintials {
    private String siteName;
    private String logedInUser;
    private String userName;
    private String password;
    
    
    public userCredintials() { }
    
    public userCredintials(String siteName, String logedInUser, String userName, String password) {
        this.siteName = siteName;
        this.logedInUser = logedInUser;
        this.userName = userName;
        this.password = password;
    }

    
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setLogedInUser(String logedInUser) {
        this.logedInUser = logedInUser;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getSiteName() {
        return siteName;
    }

    public String getLogedInUser() {
        return logedInUser;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "New Account info. \n" 
             + "SiteName:       " + siteName 
             + "\nLoged In User:  " + logedInUser 
             + "\nUser Name:      " + userName 
             + "\nPassword:       " + password;
    }
     
}