package app.redmart.com.data.model;

import java.util.ArrayList;
import java.util.List;

public class DescriptionFields {
    private List<Description> primary = new ArrayList<>();
    private List<Description> secondary = new ArrayList<>();

    public DescriptionFields() {
    }

    public List<Description> getPrimary() {
        return primary;
    }

    public void setPrimary(List<Description> primary) {
        this.primary = primary;
    }

    public List<Description> getSecondary() {
        return secondary;
    }

    public void setSecondary(List<Description> secondary) {
        this.secondary = secondary;
    }
}
