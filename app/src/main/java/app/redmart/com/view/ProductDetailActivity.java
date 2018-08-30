package app.redmart.com.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

import app.redmart.com.adapter.ViewPagerAdapter;
import app.redmart.com.contract.ProductDetailContract;
import app.redmart.com.data.model.Product;
import app.redmart.com.data.model.ProductDetail;
import app.redmart.com.presenter.ProductDetailPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailActivity extends AppCompatActivity implements ProductDetailContract.View{

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.avi)
    AVLoadingIndicatorView avi;

    @BindView(R.id.product_title)
    TextView product_title;

    @BindView(R.id.product_measure)
    TextView product_measure;

    @BindView(R.id.product_price)
    TextView product_price;

    @BindView(R.id.horizontal_line)
    TextView line;


    @BindView(R.id.horizontal_line3)
    TextView line3;


    @BindView(R.id.product_about)
    TextView product_about;

    @BindView(R.id.product_delivery)
    TextView product_delivery;

    @BindView(R.id.lbl_about)
    TextView lbl_product_about;

    @BindView(R.id.lbl_delivery)
    TextView lbl_product_delivery;

    @BindView(R.id.add_to_cart_button)
    Button addCartButton;

    ViewPagerAdapter viewPagerAdapter;

    ProductDetailContract.Presenter presenter;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        Intent intent = getIntent();
        long id = intent.getLongExtra("ID",0);

        presenter = new ProductDetailPresenter(this);
        presenter.onLoadProduct(id,new Loading(avi));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id  = item.getItemId();
        if(id== android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    private void viewContent(Product product) {
        getSupportActionBar().setTitle(product.getTitle());
        product_title.setText(product.getTitle());
        product_measure.setText(product.getMeasure().getWt_or_vol());
        product_price.setText("$"+product.getPricing().getPrice());
        product_about.setText(product.getDescription_fields().getPrimary().get(0).getContent());
        product_delivery.setText(product.getDescription_fields().getPrimary().get(1).getContent());
    }

    @Override
    public void setProduct(ProductDetail productDetail) {
        viewPagerAdapter = new ViewPagerAdapter(ProductDetailActivity.this, productDetail.getProduct().getImages());
        viewPager.setAdapter(viewPagerAdapter);
        viewContent(productDetail.getProduct());
        line.setVisibility(View.VISIBLE);
        line3.setVisibility(View.VISIBLE);
        lbl_product_about.setVisibility(View.VISIBLE);
        lbl_product_delivery.setVisibility(View.VISIBLE);
        addCartButton.setVisibility(View.VISIBLE);
    }
}
