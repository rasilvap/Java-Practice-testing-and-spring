package username.validation.util;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by rasil on 18/03/2017.
 */
public class ApplicationContextProviderTest {


    @Test
    public void testContext() {
        ApplicationContext context = ApplicationContextProvider.getApplicationContext();
        assertNotNull(context);
    }

}