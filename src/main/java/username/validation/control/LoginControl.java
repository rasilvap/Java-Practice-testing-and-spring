package username.validation.control;


import username.validation.dao.restrictedWords.RestrictedWordsDao;
import username.validation.dao.username.UserNameDao;
import username.validation.exceptions.UserNameException;
import username.validation.model.RestrictedUserName;
import username.validation.model.SuggestedUserNames;
import username.validation.model.UsernameStored;
import username.validation.util.ApplicationContextProvider;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static username.validation.util.Constants.*;

/**
 * This class consists exclusively of static methods that operate on the validation
 * of the username entered
 *
 * @author Rodolfo Silva
 */
public class LoginControl {

    private static List<UsernameStored> userNames = new ArrayList<UsernameStored>();
    private static List<RestrictedUserName> restrictedWords = new ArrayList<RestrictedUserName>();

    /**
     * Validate if the userName already exist
     * @param username username to validate
     * @return true if the user already exist in the list of
     * active users, otherwise return false
     */
    public static boolean validateDuplicatedUser(String username) {
        UserNameDao userNameDao = (UserNameDao) ApplicationContextProvider.getApplicationContext().getBean("userNameDao");
        if(userNames.isEmpty()){
            userNames = userNameDao.getAllUserNames();
        }
        boolean ok = userNames.stream()
                .anyMatch(user -> user.getName().equals(username));
        return ok;
    }

    /**
     * Validate if the userName contains a restricted word
     * @param username username to validate
     * @return true if the user contains a restricted word
     * in the list of restricted words defined, otherwise return false
     */
    public static boolean validateRestrictedWords(String username) {
        RestrictedWordsDao restrictedWordsDao = (RestrictedWordsDao) ApplicationContextProvider.getApplicationContext().getBean("restrictedWordDao");
        if(restrictedWords.isEmpty()){
            restrictedWords = restrictedWordsDao.getAllRestrictedWords();
        }
        boolean ok = restrictedWords.stream()
                .anyMatch(restrictedWord -> restrictedWord.getWord().equals(username));
        return ok;
    }

    /**
     * Validate if the userName has at least 6 characters
     *
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
     *
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
     * @return the list of the suggestions users in alphabetical order
     */
    public static List<SuggestedUserNames> getSuggestions(String username, int len) {
        List<SuggestedUserNames> suggestedUserNamesList = new ArrayList<SuggestedUserNames>();
        for (int i = 0; i < LENGTH_SUGGESTION_USERS; i++) {
            SuggestedUserNames suggestedUserName=new SuggestedUserNames();
            String suggestedWord = randomString(len);
            suggestedUserName.setName(username+suggestedWord);
            if (!validateDuplicatedUser(suggestedWord) && !validateRestrictedWords(suggestedWord)) {
                suggestedUserNamesList.add(suggestedUserName);
            }
        }
        suggestedUserNamesList.sort(Comparator.comparing(suggestedWord -> suggestedWord.getName().toUpperCase()));
        return suggestedUserNamesList;
    }

    /**
     * Return a String with the suggestion's users
     * Attempt 3 times if the suggestions <14 possibles
     * @param username
     * @return String with the list of the suggestion Users
     */
    public static String printSuggestionUsers(String username, int len) {
        List<SuggestedUserNames> suggestionsList = new ArrayList<SuggestedUserNames>();
        int countAttempts = 0;
        StringBuffer stringBuffer = new StringBuffer();
        do {
            suggestionsList = getSuggestions(username, len);
            stringBuffer.append(newLine() + INFO_SUGGESTED_USERS);
            stringBuffer.append(username + newLine());
            for (SuggestedUserNames suggestionUser : suggestionsList) {
                stringBuffer.append(suggestionUser.getName());
                stringBuffer.append(newLine());
            }
            countAttempts++;
        } while (suggestionsList.size() < LENGTH_SUGGESTION_USERS && countAttempts<4);
        return stringBuffer.toString();
    }

    /**
     * Return a new line from according to the OS
     * @return new line
     */
    private static String newLine(){
        return System.getProperty("line.separator");
    }
}





