import java.io.Serializable;
 
public class User{// implements Serializable {
 
    //private static final long serialVersionUID = 2041275512219239990L;
    private int id;
    private String login;
    private String password;
     
    public User() {
        this.login = "guest";
    }
    /*public User(String login) {
         
        this.login = login;
    }*/

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
 
    public String getLogin() {
        return login;
    }
 
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}