package username.validation.dao.restrictedWords;

import username.validation.model.RestrictedWords;
import username.validation.util.Constants;
import username.validation.util.ReadFile;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  Rodolfo Silva
 */
public class RestrictedWordsDaoImpl implements RestrictedWordsDao{
    @Override
    public List<RestrictedWords> getAllRestrictedWords() {
        List<RestrictedWords> restrictedWords = new ArrayList<RestrictedWords>();
        List<String> resulset = ReadFile.readFile(Constants.INPUT_PATH_FILES, Constants.INPUT_FILE_RESTRICTED_WORDS);
        for (String row : resulset) {
            RestrictedWords restrictedWord = new RestrictedWords();
            restrictedWord.setWord(row);
            restrictedWords.add(restrictedWord);
        }
        return restrictedWords;
    }
}
