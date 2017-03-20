package username.validation.dao.restrictedWords;

import username.validation.model.RestrictedWords;
import java.util.List;

/**
 * This interface contains the methods fot the management of the restricted words
 * @author  Rodolfo Silva
 */
public interface RestrictedWordsDao {
    /**
     * Look for the restricted words stored and cast it to a RestrictedWords Collection
     * @return the list of the restricted words stored
     */
    public List<RestrictedWords> getAllRestrictedWords();
}
