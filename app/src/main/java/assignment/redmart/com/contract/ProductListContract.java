package assignment.redmart.com.contract;

import java.util.List;

import assignment.redmart.com.data.model.Product;
import assignment.redmart.com.view.LoadingInterface;

public class ProductListContract {

    public interface View{
        void setProduct(List<Product> products);
        void addProduct(List<Product> products);
    }

    public interface Presenter{
        void onLoadProduct(LoadingInterface loading);
        void onLoadMoreProduct(int page, LoadingInterface loading);
    }

}
