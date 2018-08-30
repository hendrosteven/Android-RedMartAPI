package app.redmart.com.contract;

import app.redmart.com.data.model.ProductDetail;
import app.redmart.com.view.LoadingInterface;

public class ProductDetailContract {

    public interface View{
        void setProduct(ProductDetail productDetail);
    }

    public interface Presenter{
        void onLoadProduct(long id, LoadingInterface loading);
    }
}
