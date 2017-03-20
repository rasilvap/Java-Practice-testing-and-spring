package username.validation.control;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import username.validation.model.RestrictedUserName;
import username.validation.model.UsernameStored;

import static org.junit.Assert.*;

/**
 * @author Rodolfo Silva
 */
public class LoginControlTest {


    String jsonInRestrictedWords = "[\n" +
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

    String jsonInUserNamesStored = "[\n" +
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


    @Before
    public void setUp() {
        Gson gson = new Gson();
        RestrictedUserName restrictedUserNameList[] = gson.fromJson(jsonInRestrictedWords, RestrictedUserName[].class);
        UsernameStored usernameStoredList[] = gson.fromJson(jsonInUserNamesStored, UsernameStored[].class);
    }

    @Test
    public void validateDuplicatedUser() throws Exception {

    }

    @Test
    public void validateRestrictedWords() throws Exception {

    }

    @Test
    public void validateUserName() throws Exception {

    }

    @Test
    public void getSuggestions() throws Exception {

    }

    @Test
    public void printSuggestionUsers() throws Exception {

    }

}