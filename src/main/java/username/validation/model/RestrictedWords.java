package username.validation.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by rasil on 18/03/2017.
 */
public class RestrictedWords implements Serializable {
    private static final long serialVersionUID = 8799656478674716555L;

    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestrictedWords that = (RestrictedWords) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return "RestrictedWords{" +
                "word='" + word + '\'' +
                '}';
    }
}
