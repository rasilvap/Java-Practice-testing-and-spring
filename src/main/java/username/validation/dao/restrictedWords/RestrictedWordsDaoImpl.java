package username.validation.dao.restrictedWords;

import username.validation.model.RestrictedUserName;
import username.validation.util.Constants;
import username.validation.util.ReadFile;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  Rodolfo Silva
 */
public class RestrictedWordsDaoImpl implements RestrictedWordsDao{
    @Override
    public List<RestrictedUserName> getAllRestrictedWords() {
        List<RestrictedUserName> restrictedWords = new ArrayList<RestrictedUserName>();
        List<String> resulset = ReadFile.readFile(Constants.INPUT_PATH_FILES, Constants.INPUT_FILE_RESTRICTED_WORDS);
        for (String row : resulset) {
            RestrictedUserName restrictedWord = new RestrictedUserName();
            restrictedWord.setWord(row);
            restrictedWords.add(restrictedWord);
        }
        return restrictedWords;
    }
}
