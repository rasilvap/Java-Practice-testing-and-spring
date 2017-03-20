package username.validation.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Pojo from the restricted suggestedUserNames
 * @author Rodolfo Silva
 */
public class SuggestedUserNames implements Serializable {

    private static final long serialVersionUID = 8799656478674716627L;

    private String name;


    public String getName() {

        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuggestedUserNames that = (SuggestedUserNames) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "SuggestedUserNames{" +
                "name='" + name + '\'' +
                '}';
    }
}
