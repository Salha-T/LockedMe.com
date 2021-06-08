package lockme.com;
import java.io.*;
import java.util.*; 



public class LockMeCom {

        static Scanner in = new Scanner (System.in);
        static Scanner readDB;
        static Scanner newIn;

        static users user;
        static userCredintials newAccount;
        
        static PrintWriter writer;
        
        static File dataFile;
        
        static File userFile; 
        static PrintWriter newWriter; 

        
        
    public static void main(String[] args) throws IOException {
        
        fileOpen();
        welcome(); 
        options();        

    }
    
    
    
    public static void fileOpen() throws IOException
    {
        dataFile = new File("database.txt");

        readDB = new Scanner (dataFile);
           
        writer = new PrintWriter(new FileWriter (dataFile, true));   

    }
   
    
    
    public static void welcome () 
    {    
        
        line();
        
        System.out.println("           Welcome to LockedMe.com           ");
        System.out.println("Developer Details: \n"
                         + "Salha Alghoraibi \n"
                         + "Software Engineer");
        
        line();
        
    }
    
    public static void options () throws IOException
    {
        System.out.println("LockedMe Options: \n"
                         + "1. Return current file names in ascending order. \n"
                         + "2. Return the options for lockedMe app. \n"
                         + "3. Close LockedMe app. ");
        String input = in.next();
        
        line();
        
        
        switch (input)
        {
            case "1":
                ascending();
                break; 
                
                
            case "2":
                signInOptions();
                break;
                
                
            case "3":
                System.out.println("Thank you for using LockMe.com!");
                System.exit(0);
                
                
            default:
            {
                System.out.println("Your input is incorrect, do you want to "
                        + "continue this program?");
                
                String ans=in.next().toUpperCase();

                line();

                if(ans.contains("Y"))
                {
                    options();
                }

                else 
                {
                    System.out.println("Thank you for using LockMe.com!");
                }
                System.exit(0);
            }
        }
        
        
        
        
    }
    
    public static void ascending ()
    {
        File dr = new File("C:\\Users\\HP\\Desktop\\LockMe.com");

        File[] filesList = dr.listFiles();

        Arrays.sort(filesList, (f1, f2) -> f1.compareTo(f2));

        for (File f : filesList) 
        {
           if (!f.isHidden()) 
           {
              if (f.isDirectory()) 
              {
                 System.out.println("DIR \t" + f.getName());
              } 
              else 
              {
                 System.out.println("FILE\t" + f.getName());
              }
           }
        }
    }
    
    public static void signInOptions () throws IOException
    {
        
        System.out.print("1. Registration \n"
                         + "2. Login \n"
                         + "3. Close LockedMe app. \n"
                         + "   Choose 1, 2, or 3: ");
        
        
        String choice = in.next();
        line();
        
        
        switch (choice)
        {
            
            case "1":
                registration();
                break; 
                
                
            case "2": 
                login();
                break;
                
               
            case "3":
                System.out.println("Thank you for using LockMe.com!");
                System.exit(0);
                    
                
            default:
            {
                System.out.println("Your input is incorrect, do you want to "
                        + "continue this program?");
                
                String ans = in.next().toUpperCase();

                line();

                if(ans.contains("Y"))
                {
                    signInOptions();
                }

                else 
                {
                    System.out.println("Thank you for using LockMe.com!");
                }
                System.exit(0);
            }
            
        }
        
    }
    
    
    
    public static void registration () throws IOException
    {
        
        System.out.println("        This is the registration page       ");
        line();
        
        in.nextLine();
        System.out.print("Please enter your preferred username: ");
        String username = in.nextLine();
        
        
        System.out.print("Please enter your preferred password: ");
        String password = in.nextLine();
        
        
        line();
        
        user = new users(username, password);
        System.out.println(user);
        
        line();
        
        writer.println(user.getUserName());
        writer.println(user.getPassword());
        

        System.out.println("     **You are successfully registered**");
        
        line();
        writer.close();
    }
    
    
    
    public static void login () throws IOException 
    {
        System.out.println("          Welcome to the Login page           ");
        line();
        
        System.out.print("To login please enter your user name: ");
        String username = in.next();
        
        System.out.print("Enter your password: ");
        String password = in.next();
                                           
        boolean found = false;
        while (readDB.hasNext() && !found)
        {
            if (readDB.next().equals(username))
                if (readDB.next().equals(password))
                {
                    System.out.println("\nYou are successfuly loged in!");
            found = true;
                
            userFile = new File(username + ".txt");
            newWriter = new PrintWriter(new FileWriter(userFile, true)); 
            newIn = new Scanner (userFile);

            if (userFile.exists() == false)
            {
                newWriter.println("LockMe.com");
                newWriter.println(username);
                newWriter.println(password);
                newWriter.println("\n");
            
                newWriter.close();
                               
            }
            lockerOptions(username, newIn, userFile);
            break;
                }        

        }
        if(!found)
        {
            System.out.println("Your account is not found, please try again or register.");
        }
    }
    
    
    
    public static void lockerOptions (String username, Scanner newIn, File userFile) throws IOException 
    {
        line();
        System.out.println("             Locker Options page     ");
        line();
        
        System.out.print("1. Store Credentials \n"
                         + "2. Fetch Credentials \n"
                         + "3. Delete user credential \n"
                         + "4. Search user \n"
                         + "   Choose from 1 to 4: ");
        
        String choice = in.next();
        line();
        
        switch (choice)
        {
            case "1":
                storeCred(username, newIn);
                break; 
            case "2":                                 
                fetchCred(username, newIn); 
                break;
                
            case "3":
                deleteFile(username, userFile);
                break;
                
            case "4":
                searchUser();
                break;
                
            default:
                System.out.println("Your input is incorrect, program ended.");
        }
        
    }
    
    
    
    public static void storeCred (String username, Scanner newIn) throws IOException
    {
        
        System.out.println("       Store Credentials page       ");
        
        line();
        
        in.nextLine();
        
        System.out.print("Enter the site name: ");
        String site = in.nextLine();
        
        System.out.print("Enter your username: ");
        String userName;
        userName = in.nextLine();
        
        System.out.print("Enter your password: ");
        String password = in.nextLine();
        
        newAccount = new userCredintials(site, username, userName, password);
                
        
        newWriter.println(newAccount.getSiteName());
        newWriter.println(newAccount.getUserName());
        newWriter.println(newAccount.getPassword());
        newWriter.println();

        System.out.println("Your credentials are successfully stored!");
        line();
        
        System.out.println(newAccount);

        System.out.println("Do you want to store more credentials? ");
        String ans=in.next().toUpperCase();
        
        line();
        
        if(ans.contains("Y"))
        {
            storeCred(username, newIn); 
        }
        
        else 
        {
            System.out.println("Thank you for using LockMe.com!");
        }
            
        newWriter.close();
    }
    

    
    public static void fetchCred (String username, Scanner newIn) throws IOException
    {        
        System.out.println("           Fetch Credentials page  ");
        
        line();
        
        System.out.println("Passwords stored for " + username);
        
		while(newIn.hasNext()) {
                        {
				System.out.println("Site Name: " +newIn.next());
				System.out.println("User Name: " +newIn.next());
				System.out.println("User Password: " +newIn.next());
                                System.out.println("__________________________");
			}
		}
            newIn.close();
    }
    
    
    
    public static void deleteFile (String username, File userFile) throws IOException
    {
     
        System.out.println("       Delete Credentials page  ");
        
        line();
        
        
        System.out.println("Passwords stored for " + username + " will be deleted.");
        
		File dir = new File("C:\\Users\\HP\\Desktop\\LockMe.com");

                for (File i: dir.listFiles()) 
                   {
                       if (i.getName().contains(username + ".txt"))
                       {
                           userFile.delete();                
                           
                           System.out.println("** Passwords were successfully deleted. **");
                       }
                   }

    }
    
    
    
    public static void searchUser ()
    {
        System.out.println("        Search Credentials page  ");
        
        line();
        
        System.out.print("Enter the username you are looking for: ");
        String username = in.next();
                
        boolean f = searchResult(username);
        
        if (f == true)
        {
            System.out.println("The file \"" + username + "\" exist.");
        }
       
        if (f == false)
        {
        System.out.println("The file \"" + username + "\" do not exist or "
                + "is not a directory.");
        }
    }
    
    
    
    public static boolean searchResult (String username)
    {
        
        File dir = new File("C:\\Users\\HP\\Desktop\\LockMe.com");
        
        boolean f = false;
        for (File i: dir.listFiles()) 
           {
               if (i.getName().contains(username + ".txt"))
               {
                   f = true;        
               }
           }
        
        return f;
    }
    
    
    
    public static void line ()
    {
        System.out.println("---------------------------------------------");
    }
 
    
}