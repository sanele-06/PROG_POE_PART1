package com.mycompany.prog_poe_part1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    Login login = new Login();

    @Test
    public void testCheckUserName() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserNamePoorly() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexitySuccess() {
        assertTrue(login.checkPasswordComplexity("Ch@se888!"));
    }

    @Test
    public void testCheckPasswordComplexityFailure() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumberCorrect() {
        assertTrue(login.checkCellPhoneNumber("+2783899976"));
    }

    @Test
    public void testCheckCellPhoneNumberIncorrect() {
        assertFalse(login.checkCellPhoneNumber("08966511"));
    }

    @Test
    public void testRegisterUserSuccess() {
        String result = login.registerUser("kyl_1", "Ch@se888!", "+2783899976");
        assertEquals("User registered successfully.", result);
    }

    @Test
    public void testLoginAndReturnMessage() {
        login.registerUser("kyl_1", "Ch@se888!", "+2783899976");
        boolean logged = login.loginUser("kyl_1", "Ch@se888!");
        String msg = login.returnLoginStatus(logged, "Kyle", "Smith");
        assertTrue(msg.contains("Welcome"));
    }
}