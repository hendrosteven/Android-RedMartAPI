package app.redmart.com.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import app.redmart.com.adapter.RecycleViewAdapter;
import app.redmart.com.contract.ProductListContract;
import app.redmart.com.data.model.Product;
import app.redmart.com.presenter.ProductListPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListActivity extends AppCompatActivity implements ProductListContract.View{

    @BindView(R.id.recyclerview_id)
    RecyclerView mRecycleView;

    @BindView(R.id.avi)
    AVLoadingIndicatorView avi;

    RecycleViewAdapter myAdapter;
    ProductListContract.Presenter presenter;

    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        presenter = new ProductListPresenter(this);

        mRecycleView.setLayoutManager(new GridLayoutManager(this,3));

        mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                 if(dy>0){
                     if(!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)){
                         presenter.onLoadMoreProduct(++page, new Loading(avi));
                     }
                }
            }
        });

        presenter.onLoadProduct(new Loading(avi));
    }

    @Override
    public void setProduct(List<Product> products) {
        myAdapter = new RecycleViewAdapter(ProductListActivity.this, products);
        mRecycleView.setAdapter(myAdapter);
    }

    @Override
    public void addProduct(List<Product> products) {
        myAdapter.addProduct(products);
    }
}
