package username.validation.dao.username;


import username.validation.model.UsernameStored;

import java.util.List;

/**
 * This interface contains the methods fot the management of the usernames
 * @author  Rodolfo Silva
 */
public interface UserNameDao {

    /**
     * Look for the restricted usernames stored and cast it to a UsernameStored Collection
     * @return the list of the usernames stored
     */
    public List<UsernameStored> getAllUserNames();

}
