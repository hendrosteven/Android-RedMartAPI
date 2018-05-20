package assignment.redmart.com.presenter;

import android.util.Log;

import assignment.redmart.com.contract.ProductDetailContract;
import assignment.redmart.com.data.model.ProductDetail;
import assignment.redmart.com.data.repo.APIClient;
import assignment.redmart.com.data.repo.ProductRepository;
import assignment.redmart.com.view.LoadingInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailPresenter implements ProductDetailContract.Presenter {

    private final ProductDetailContract.View view;
    private ProductDetail productDetail;

    private ProductRepository repo;

    public ProductDetailPresenter(ProductDetailContract.View view) {
        this.view = view;
        repo = APIClient.getClient().create(ProductRepository.class);
    }

    @Override
    public void onLoadProduct(long id, final LoadingInterface loading) {
        loading.start();
        Call<ProductDetail> call = repo.getProductDetail(id);
        call.enqueue(new Callback<ProductDetail>() {
            @Override
            public void onResponse(Call<ProductDetail> call, Response<ProductDetail> response) {
                productDetail = response.body();
                view.setProduct(productDetail);
                loading.stop();
            }

            @Override
            public void onFailure(Call<ProductDetail> call, Throwable t) {
                loading.stop();
                Log.e("ERROR",t.getMessage());
                call.cancel();
            }
        });
    }
}
