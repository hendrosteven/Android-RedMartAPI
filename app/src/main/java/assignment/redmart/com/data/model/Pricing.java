package assignment.redmart.com.data.model;

public class Pricing {
    double on_sale;
    double price;
    double promo_price;
    double savings;
    double savings_type;


    public Pricing(){}

    public double getOn_sale() {
        return on_sale;
    }

    public void setOn_sale(double on_sale) {
        this.on_sale = on_sale;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPromo_price() {
        return promo_price;
    }

    public void setPromo_price(double promo_price) {
        this.promo_price = promo_price;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public double getSavings_type() {
        return savings_type;
    }

    public void setSavings_type(double savings_type) {
        this.savings_type = savings_type;
    }
}
