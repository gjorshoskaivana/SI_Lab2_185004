import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    private SILab2 labs;
    private ArrayList<String> list;
    private User user;

    @Test
    void EveryBranchTest() {
        RuntimeException ex;
        list = new ArrayList<>(Arrays.asList("user1", "user2", "user3"));

        // user = null, list
        user = null;
        ex = assertThrows(RuntimeException.class, () -> labs.function(user, list));
        assertTrue(ex.getMessage().contains("The user argument is not initialized!"));

        // username = null, list
        user = new User(null, "pass", "email@email.com");
        ex = assertThrows(RuntimeException.class, () -> labs.function(user , list));
        assertTrue(ex.getMessage().contains("User already exists!"));

        // list contains username
        user = new User("user1", "pass", "email@email.com");
        ex = assertThrows(RuntimeException.class, () -> labs.function(user, list));
        assertTrue(ex.getMessage().contains("User already exists!"));

        //the email is null
        user = new User("user4", "pass", null);
        assertEquals(false, labs.function(user, list));

        // the email doesn't have a '@' (doesn't matter if it contains . or not)
        user = new User("user4", "pass", "emailemail.com");
        assertEquals(false, labs.function(user, list));

        // the email doesn't have a '.' (but contains @)
        user = new User("user4", "pass", "email@emailcom");
        assertEquals(false, labs.function(user, list));

        // everything ok
        user = new User("user4", "pass", "email@email.com");
        assertEquals(true, labs.function(user, list));
    }

    @Test
    void EveryPathTest(){
        RuntimeException ex;
        list = new ArrayList<>(Arrays.asList("user1", "user2", "user3"));

        // 1, 2, 3, 20 - user=null
        user = null;
        ex = assertThrows(RuntimeException.class, () -> labs.function(user, list));
        assertTrue(ex.getMessage().contains("The user argument is not initialized!"));

        // 1, 2, 4, 5, 20 - username = null
        user = new User(null, "pass", "email@email.com");
        ex = assertThrows(RuntimeException.class, () -> labs.function(user , list));
        assertTrue(ex.getMessage().contains("User already exists!"));

        // 1, 2, 4, 5, 20 - username in list
        user = new User("user1", "pass", "email@email.com");
        ex = assertThrows(RuntimeException.class, () -> labs.function(user, list));
        assertTrue(ex.getMessage().contains("User already exists!"));
        
        // 1, 2, 4, 6, 7, 20 - email = null
        user = new User("user4", "pass", null);
        assertEquals(false, labs.function(user, list));

        // 1, 2, 4, 6, 8, 9.1, 9.2, 14, 15, 16, 20 - not possible, email != null

        // 1, 2, 4, 6, 8, 9.1, 9.2, 14, 15, 17,18, 19, 20 - not possible, email != null

        // 1, 2, 4, 6, 8, 9.1, (9.2, 10, 12, 9.3), 14, 15, 16, 20 - no @
        user = new User("user4", "pass", "emailemail.com");
        assertEquals(false, labs.function(user, list));

        // 1, 2, 4, 6, 8, 9.1, (9.2, 10, 12, 9.3), 14, 15, 17,18, 19, 20 - not possible, no @ in email

        // 1, 2, 4, 6, 8, 9.1, (9.2, 10, 11, 12, 9.3), 14, 15, 16, 20 - no .
        user = new User("user4", "pass", "email@emailcom");
        assertEquals(false, labs.function(user, list));

        // 1, 2, 4, 6, 8, 9.1, (9.2, 10, 11, 12, 9.3), 14, 15, 17,18, 19, 20 - not possible, no . in email

        // 1, 2, 4, 6, 8, 9.1, (9.2, 10, 11, 12, 13, 9.3), 14, 15, 17,18, 19, 20 - everything is valid
        user = new User("user4", "pass", "email@email.com");
        assertEquals(true, labs.function(user, list));
    }
}
