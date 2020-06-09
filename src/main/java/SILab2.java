import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<String> allUsers) {//1
        if (user==null) {//2
            throw new RuntimeException("The user argument is not initialized!"); //3
        }
        else {
            if (user.getUsername()==null || allUsers.contains(user.getUsername())) { //4
                throw new RuntimeException("User already exists!"); //5
            }
            else {
                if (user.getEmail()==null) //6
                    return false; //7
                boolean atChar = false, dotChar = false; //8
                for (int i=0;i<user.getEmail().length();i++) { // 9 (9.1, 9.2, 9.3)
                    if (user.getEmail().charAt(i)=='@') //10
                        atChar = true;  //11
                    if (atChar && user.getEmail().charAt(i)=='.') { //12
                        dotChar = true; //13
                    }
                } //14
                if (!atChar || !dotChar) {  //15
                    return false; //16
                }
            } //17
        } //18
        return true; //19
    } //20
}
