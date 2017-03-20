package username.validation.util;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Rodolfo Silva
 */
public class ApplicationContextProviderTest {


    @Test
    public void testContext() {
        ApplicationContext context = ApplicationContextProvider.getApplicationContext();
        assertNotNull(context);
    }

}