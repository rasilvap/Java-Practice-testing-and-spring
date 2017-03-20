package username.validation.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class provides an unique instance of the ApplicationContext
 *
 * @author Rodolfo Silva
 */
public class ApplicationContextProvider {

    /**
     * private static method in order to make sure the singleton patter implementation
     */
    private static ApplicationContext context;

    /**
     * Private constructor in order to make sure the singleton patter implementation
     */
    private ApplicationContextProvider() {
    }

    /**
     * Take the context definition files from the class path
     * @return the application context
     */
    public static ApplicationContext getApplicationContext() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("/application-context.xml");
        }
        return context;
    }
}

