package username.validation.util;

import username.validation.model.Username;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rodolfo Silva on 18/03/2017.
 * Utiliy userd to read a File
 */
public class ReadFile {


    public static List<String> readFile(String path,String fileName) {
        List<String> records = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path + fileName)));
            String inputLine = null;
            Map<String, Integer> dictionary = new HashMap<String, Integer>();
            while ((inputLine = reader.readLine()) != null) {
                String[] words = inputLine.split("\\s+");
                if (inputLine.equals(""))
                    continue;
                for (String word : words) {
                    word = word.replace(".", "");
                    word = word.replace(",", "");
                    records.add(word);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
