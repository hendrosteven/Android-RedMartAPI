package assignment.redmart.com.contract;

import assignment.redmart.com.data.model.ProductDetail;
import assignment.redmart.com.view.LoadingInterface;

public class ProductDetailContract {

    public interface View{
        void setProduct(ProductDetail productDetail);
    }

    public interface Presenter{
        void onLoadProduct(long id, LoadingInterface loading);
    }
}
