package username.validation.control;


import username.validation.dao.restrictedWords.RestrictedWordsDao;
import username.validation.dao.username.UserNameDao;
import username.validation.exceptions.UserNameException;
import username.validation.model.RestrictedWords;
import username.validation.model.UsernameStored;
import username.validation.util.ApplicationContextProvider;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import static username.validation.util.Constants.ERROR_MESSAGE_INVALID_CHARACTERS_NUMBER;
import static username.validation.util.Constants.ALPHANUMERICAL_STRING;
import static username.validation.util.Constants.INFO_SUGGESTED_USERS;

/**
 * This class consists exclusively of static methods that operate on the validation
 * of the username entered
 *
 * @author Rodolfo Silva
 */
public class LoginControl {

    /**
     * Validate if the userName already exist
     *
     * @param username username to validate
     * @return true if the user already exist in the list of
     * active users, otherwise return false
     */
    public static boolean validateDuplicatedUser(String username) {
        boolean ok = false;
        UserNameDao userNameDao = (UserNameDao) ApplicationContextProvider.getApplicationContext().getBean("userNameDao");
        List<UsernameStored> userNames = userNameDao.getAllUserNames();
        for (UsernameStored user : userNames) {
            if (user.getName().equals(username)) {
                ok = true;
                break;
            }
        }
        return ok;
    }

    /**
     * Validate if the userName contains a restricted word
     * @param username username to validate
     * @return true if the user contains a restricted word
     * in the list of restricted words defined, otherwise return false
     */
    public static boolean validateRestrictedWords(String username) {
        boolean ok = false;
        RestrictedWordsDao restrictedWordsDao = (RestrictedWordsDao) ApplicationContextProvider.getApplicationContext().getBean("restrictedWordDao");
        List<RestrictedWords> restrictedWords = restrictedWordsDao.getAllRestrictedWords();
        for (RestrictedWords RestrictedWord : restrictedWords) {
            if (RestrictedWord.getWord().equals(username)) {
                ok = true;
                break;
            }
        }
        return ok;
    }

    /**
     * Validate if the userName has at least 6 characters
     * @param username username to validate
     * @return throws UserNameException if if the userName has not at least 6 characters
     */
    public static void validateUserName(String username) throws UserNameException {
        if ((null != username) && username.length() < 6) {
            throw new UserNameException(ERROR_MESSAGE_INVALID_CHARACTERS_NUMBER);
        }
    }

    /**
     * Return a random words serie in order to
     * concataete to the username suggestions
     * @return the random word
     */
    private static String randomString(int len) {
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(ALPHANUMERICAL_STRING.charAt(rnd.nextInt(ALPHANUMERICAL_STRING.length())));
        return sb.toString();
    }

    /**
     * Return a list of the suggestions users
     * @param username
     * @return the list of the suggestions users
     */
    public static List<String> getSuggestions(String username,int len) {
        List<String> suggestionsList = new ArrayList<String>();
        for (int i = 0; i < 13; i++) {
            suggestionsList.add(username+randomString(len));
        }
        return suggestionsList;
    }

    /**
     * Return a String with the suggestion's users
     * @param username
     * @return String with the list of the suggestion Users
     */
    public static String printSuggestionUsers(String username,int len){
        StringBuffer stringBuffer = new StringBuffer();
        List<String> suggestionsList = getSuggestions(username,len);
        stringBuffer.append(System.getProperty( "line.separator" )+INFO_SUGGESTED_USERS);
        stringBuffer.append(username+System.getProperty( "line.separator" ));
        for (String suggestionUser:suggestionsList) {
            stringBuffer.append(suggestionUser);
            stringBuffer.append(System.getProperty( "line.separator" ));
        }
        return stringBuffer.toString();
    }
}





