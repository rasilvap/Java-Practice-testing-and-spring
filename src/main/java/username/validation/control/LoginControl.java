package username.validation.control;


import username.validation.dao.restrictedWords.RestrictedWordsDao;
import username.validation.dao.username.UserNameDao;
import username.validation.model.RestrictedWords;
import username.validation.model.Username;
import username.validation.util.ApplicationContextProvider;
import java.util.List;

public class LoginControl {


    public static boolean validateDuplicatedUser(String username) {
        boolean ok = false;
        UserNameDao userNameDao = (UserNameDao) ApplicationContextProvider.getApplicationContext().getBean("userNameDao");
        List<Username> userNames = userNameDao.getAllUserNames();
        for (Username user : userNames) {
            if (user.getName().equals(username)) {
                ok = true;
                break;
            }
        }
        return ok;
    }

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
}
