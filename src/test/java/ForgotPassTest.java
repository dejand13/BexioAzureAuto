import org.testng.annotations.Test;
import java.io.IOException;

public class ForgotPassTest extends DriverInit{
    @Test
    public void forgotPass() throws IOException {
        initDriver();
        Selectors forgotPass = new Selectors(driver);
        forgotPass.forgotPassLogInLink.click();
        forgotPass.getEnterEmailForgotPass().sendKeys(prop.getProperty("usernameForgot"));
        log.info("Log4j 2 info logs+");
        log.error("Log4j 2 error logs+");
    }
}
