package assignment.redmart.com.presenter;

import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assignment.redmart.com.contract.ProductListContract;
import assignment.redmart.com.data.model.Product;
import assignment.redmart.com.data.model.ProductList;
import assignment.redmart.com.data.repo.APIClient;
import assignment.redmart.com.data.repo.ProductRepository;
import assignment.redmart.com.view.LoadingInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListPresenter implements ProductListContract.Presenter {

    private final ProductListContract.View view;
    private List<Product> products;

    private ProductRepository repo;

    public ProductListPresenter(ProductListContract.View view) {
        this.view = view;
        repo = APIClient.getClient().create(ProductRepository.class);
    }

    @Override
    public void onLoadProduct(final LoadingInterface loading) {
        Map<String, Integer> data = new HashMap<>();
        data.put("page",0);
        data.put("pageSize", 20);

        loading.start();
        Call<ProductList> call = repo.getProductList(data);
        call.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                if(response.body().getStatus().getCode()==0) {
                    products = response.body().getProducts();
                    view.setProduct(products);
                }
                loading.stop();
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                loading.stop();
                Log.e("ERROR",t.getMessage());
                call.cancel();
            }
        });
    }

    @Override
    public void onLoadMoreProduct(int page, final LoadingInterface loading) {
        Map<String, Integer> data = new HashMap<>();
        data.put("page",page);
        data.put("pageSize", 20);

        loading.start();
        Call<ProductList> call = repo.getProductList(data);
        call.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                if(response.body().getStatus().getCode()==0) {
                    products = response.body().getProducts();
                    view.addProduct(products);
                }
                loading.stop();
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                loading.stop();
                Log.e("ERROR",t.getMessage());
                call.cancel();
            }
        });
    }


}
