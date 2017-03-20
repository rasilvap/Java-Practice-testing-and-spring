package username.validation.util;

/**
 * This class cotains the constants of the Application
 * @author Rodolfo Silva
 */
public final class Constants {

    private Constants(){

    }

    public static final String HOME_PANEL_TITLE = "Intertec LoginControl";
    public static final String HOME_BUTTON_LOGIN = "Click to login";
    public static final String PANEL_LOGIN_TITLE = "LoginControl";
    public static final String PANEL_LABEL_USERNAME = "Username: ";
    public static final String BUTTON_LOGIN_LABEL = "Login";

    public static final String INPUT_PATH_FILES = "/inputFiles/";
    public static final String INPUT_FILE_USERNAMES_NAME = "usernamesStored.txt";
    public static final String INPUT_FILE_RESTRICTED_WORDS = "restrictedUserNames.txt";

    public static final String ERROR_MESSAGE_INVALID_CHARACTERS_NUMBER = "UserName must be at least 6 characters";
    public static final String ERROR_MESSAGE_USERNAME_EXIST = "The UserName already exist";
    public static final String ERROR_MESSAGE_USERNAME_RESTRICTED_WORD = "The UserName contains a restricted word";
    public static final String INFO_SUGGESTED_USERS = "Suggested Users for  ";

    public static final String ALPHANUMERICAL_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final int LENGTH_RANDOM_DUPLICATED_USER = 3;
    public static final int LENGTH_RANDOM_RESTRICTED_UER = 9;
    public static final int LENGTH_SUGGESTION_USERS = 14;
}
