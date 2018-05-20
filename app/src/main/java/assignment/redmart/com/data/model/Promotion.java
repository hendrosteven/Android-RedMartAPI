package assignment.redmart.com.data.model;

public class Promotion {
   private long id;
   private int type;
   private String savings_text;
   private String promo_label;

    public Promotion() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSavings_text() {
        return savings_text;
    }

    public void setSavings_text(String savings_text) {
        this.savings_text = savings_text;
    }

    public String getPromo_label() {
        return promo_label;
    }

    public void setPromo_label(String promo_label) {
        this.promo_label = promo_label;
    }
}
