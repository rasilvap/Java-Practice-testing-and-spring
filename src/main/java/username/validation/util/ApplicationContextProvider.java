package username.validation.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rasil on 18/03/2017.
 */
public class ApplicationContextProvider  {

    private static ApplicationContext context;

    private ApplicationContextProvider() {}

    public static ApplicationContext getApplicationContext() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("/application-context.xml");
        }
        return context;
    }
}

