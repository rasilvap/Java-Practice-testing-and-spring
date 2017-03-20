package username.validation.control;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import username.validation.dao.restrictedWords.RestrictedWordsDao;
import username.validation.dao.username.UserNameDao;
import username.validation.exceptions.UserNameException;
import username.validation.model.RestrictedUserName;
import username.validation.model.UsernameStored;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static username.validation.util.Constants.*;

/**
 * @author Rodolfo Silva
 */
public class LoginControlTest {


    private final String jsonInRestrictedWords = "[\n" +
            "  {\n" +
            "    \"word\": \"shitings\"\n" +
            "  }, \n" +
            "  {\n" +
            "   \"word\": \"shaggin\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"word\": \"sadist\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"word\": \"masterbat3\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"word\": \"mothafuckin\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"word\": \"knobjocky\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"word\": \"knobead\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"word\": \"cunillingus\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"word\": \"cokmuncher\"\n" +
            "  }\n" +
            "]";

    private final String jsonInUserNamesStored = "[\n" +
            "  {\n" +
            "    \"name\": \"rasilvap22\"\n" +
            "  }, \n" +
            "  {\n" +
            "   \"name\": \"rodolfo\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"name\": \"alexander\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"name\": \"silva32\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"name\": \"pantoja\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"name\": \"inetertec34\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"name\": \"inercontinental33\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"name\": \"godzila98\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"name\": \"chuck_Norris88\"\n" +
            "  }\n" +
            "]";

    private List<UsernameStored> usernameStoredList;
    private List<RestrictedUserName> restrictedUserNameList;
    private ApplicationContext mockApplicationContext;
    private UserNameDao userNameDao;
    private RestrictedWordsDao restrictedWordsDao;
    private String existingUser;
    private String notExistinUser;
    private String restrictedWord;
    private String notRestrictedWord;
    private String notValidUser;
    private LoginControl loginControl;
    private static final int THREE_TIMES = 3;

    @Before
    public void setUp() {
        Gson gson = new Gson();
        loginControl = Mockito.spy(new LoginControl());
        mockApplicationContext = mock(ApplicationContext.class);
        userNameDao = mock(UserNameDao.class);
        restrictedWordsDao = mock(RestrictedWordsDao.class);

        RestrictedUserName[] restrictedUserNameJsonList = gson.fromJson(jsonInRestrictedWords, RestrictedUserName[].class);
        UsernameStored[] usernameStoredJsonList = gson.fromJson(jsonInUserNamesStored, UsernameStored[].class);
        existingUser = "rodolfo";
        notExistinUser = "jackson";
        restrictedWord = "knobead";
        notRestrictedWord = "arthur15";
        notValidUser="silva";

        usernameStoredList = getUserNamesListJsonToObjectList(usernameStoredJsonList);
        restrictedUserNameList = getRestrictedUserNameJsonToObjectList(restrictedUserNameJsonList);

        when(mockApplicationContext.getBean(USER_NAME_DAO, UserNameDao.class)).thenReturn(userNameDao);
        when(mockApplicationContext.getBean(RESTRICTED_WORD_DAO, RestrictedWordsDao.class)).thenReturn(restrictedWordsDao);

        when(userNameDao.getAllUserNames()).thenReturn(usernameStoredList);
        when(restrictedWordsDao.getAllRestrictedWords()).thenReturn(restrictedUserNameList);
    }

    @Test
    public void validateDuplicatedUserTestWhenTheUserNotExist() throws Exception {
        assertFalse(loginControl.validateDuplicatedUser(notExistinUser));
    }

    @Test
    public void validateDuplicatedUserTestWhenTheUserExist() throws Exception {
        assertTrue(loginControl.validateDuplicatedUser(existingUser));
    }

    @Test
    public void validateRestrictedWordsTestWhenNotContainsRestrictedWord() throws Exception {
        assertFalse(loginControl.validateRestrictedWords(notRestrictedWord));
    }

    @Test
    public void validateRestrictedWordsTestWhenContainsRestrictedWord() throws Exception {
        assertTrue(loginControl.validateRestrictedWords(restrictedWord));
    }

    @Test(expected=UserNameException.class)
    public void validateUserNameTestWhenIsNotValid() throws Exception {
        loginControl.validateUserName(notValidUser);
    }

    @Test
    public void validateUserNameTestWhenIsValid() throws Exception {
        loginControl.validateUserName(existingUser);
    }

    @Test
    public void getSuggestionsTestWhenTheReturnedListIsOF14() throws Exception {
       assertTrue(loginControl.getSuggestions(existingUser,LENGTH_RANDOM_DUPLICATED_USER).size() ==LENGTH_SUGGESTION_USERS);;
    }

    /**
     * This test shows how The app should try to generate
     * 14 possible usernames from these rules at least three times, in this case
     * because the randomUserString is always an existing user
     * @throws Exception
     */
    @Test
    public void testWhenTheRandomStringIsDuplicatedThengetSuggestionsMethodIsCalledThreTimes() throws Exception {
        when(loginControl.randomString(LENGTH_RANDOM_DUPLICATED_USER)).thenReturn(existingUser);
        loginControl.printSuggestionUsers(notExistinUser,LENGTH_RANDOM_DUPLICATED_USER);
        verify(loginControl, times(THREE_TIMES)).getSuggestions(notExistinUser,LENGTH_RANDOM_DUPLICATED_USER);
    }

    /**
     * Transfor the userNames jsonList to List<UsernameStored>
     * @param usernameStoredList
     * @return
     */
    private List<UsernameStored> getUserNamesListJsonToObjectList(UsernameStored[] usernameStoredList){
        List<UsernameStored> usernameStoredListObject = new ArrayList<UsernameStored>();
        for (UsernameStored usernameJson:usernameStoredList) {
            usernameStoredListObject.add(usernameJson);
        }
        return usernameStoredListObject;
    }

    /**
     * Transfor the restrictedUserName jsonList to List<RestrictedUserName>
     * @param restrictedUserNamedList
     * @return
     */
    private List<RestrictedUserName> getRestrictedUserNameJsonToObjectList(RestrictedUserName[] restrictedUserNamedList){
        List<RestrictedUserName> restrictedUserNameListObject = new ArrayList<RestrictedUserName>();
        for (RestrictedUserName restrictedUserNameJson:restrictedUserNamedList) {
            restrictedUserNameListObject.add(restrictedUserNameJson);
        }
        return restrictedUserNameListObject;
    }

}