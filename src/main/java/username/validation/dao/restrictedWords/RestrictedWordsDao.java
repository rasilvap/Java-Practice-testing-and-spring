package username.validation.dao.restrictedWords;

import username.validation.model.RestrictedUserName;

import java.util.List;

/**
 * This interface contains the methods fot the management of the restricted words
 * @author  Rodolfo Silva
 */
public interface RestrictedWordsDao {
    /**
     * Look for the restricted words stored and cast it to a RestrictedUserName Collection
     * @return the list of the restricted words stored
     */
    public List<RestrictedUserName> getAllRestrictedWords();
}
