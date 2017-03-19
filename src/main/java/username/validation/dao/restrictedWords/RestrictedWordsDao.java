package username.validation.dao.restrictedWords;

import username.validation.model.RestrictedWords;
import java.util.List;

/**
 * Created by rasil on 18/03/2017.
 */
public interface RestrictedWordsDao {

    public List<RestrictedWords> getAllRestrictedWords();
}
