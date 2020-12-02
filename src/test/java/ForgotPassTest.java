import org.testng.annotations.Test;
import java.io.IOException;

public class ForgotPassTest extends DriverInit{
    @Test
    public void forgotPass() throws IOException {
        initDriver();
        SelectorsGP forgotPass = new SelectorsGP(driver);
        forgotPass.getForgotPassLogInLink().click();
        forgotPass.getEnterEmailForgotPass().sendKeys(prop.getProperty("usernameForgot"));
        log.info("Log4j 2 info logs+");
    }
}
