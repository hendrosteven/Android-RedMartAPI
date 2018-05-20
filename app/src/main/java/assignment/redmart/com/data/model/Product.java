package assignment.redmart.com.data.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private long id;
    private String title;
    private String desc;
    private Image img;
    private List<Image> images = new ArrayList<>();
    private Measure measure;
    private Pricing pricing;
    private DescriptionFields description_fields;
    private List<Promotion> promotions = new ArrayList<>();

    public Product(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public DescriptionFields getDescription_fields() {
        return description_fields;
    }

    public void setDescription_fields(DescriptionFields description_fields) {
        this.description_fields = description_fields;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }
}
