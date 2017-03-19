package username.validation.dao.username;


import username.validation.model.Username;
import username.validation.util.Constants;
import username.validation.util.ReadFile;
import java.util.ArrayList;
import java.util.List;


public class UserNameDaoImpl implements UserNameDao {

    List<Username> userNames;

    public UserNameDaoImpl() {
        userNames = new ArrayList<Username>();
    }

    @Override
    public List<Username> getAllUserNames() {
        List<Username> usernames = new ArrayList<Username>();
        List<String> resulset = ReadFile.readFile(Constants.INPUT_PATH_FILES, Constants.INPUT_FILE_USERNAMES_NAME);
        for (String row : resulset) {
            Username username = new Username();
            username.setName(row);
            usernames.add(username);
        }
        return usernames;
    }
}
