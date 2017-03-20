package username.validation.dao.username;


import username.validation.model.UsernameStored;
import username.validation.util.Constants;
import username.validation.util.ReadFile;
import java.util.ArrayList;
import java.util.List;


public class UserNameDaoImpl implements UserNameDao {

    List<UsernameStored> userNames;

    public UserNameDaoImpl() {
        userNames = new ArrayList<UsernameStored>();
    }

    @Override
    public List<UsernameStored> getAllUserNames() {
        List<UsernameStored> usernameStoreds = new ArrayList<UsernameStored>();
        List<String> resulset = ReadFile.readFile(Constants.INPUT_PATH_FILES, Constants.INPUT_FILE_USERNAMES_NAME);
        for (String row : resulset) {
            UsernameStored usernameStored = new UsernameStored();
            usernameStored.setName(row);
            usernameStoreds.add(usernameStored);
        }
        return usernameStoreds;
    }
}
