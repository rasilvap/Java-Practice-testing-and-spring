package username.validation.exceptions;

/**
 * This class is a subclass from  Exception are and
 * provides a form of Throwable that indicates conditions that the
 * application might want to catch
 * @author Rodolfo Silva
 */
public class UserNameException extends Exception{

    /**
     * Class constructor
     * @param msg
     */
    public UserNameException(String msg) {
        super(msg);
    }
}
