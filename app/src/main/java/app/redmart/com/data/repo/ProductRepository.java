package app.redmart.com.data.repo;

import java.util.Map;

import app.redmart.com.data.model.ProductDetail;
import app.redmart.com.data.model.ProductList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ProductRepository {

    @GET("catalog/products/{id}")
    Call<ProductDetail> getProductDetail(@Path("id") long id);

    @GET("catalog/search")
    Call<ProductList> getProductList(@QueryMap Map<String, Integer> options);
}
