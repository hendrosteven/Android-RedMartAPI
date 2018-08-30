package app.redmart.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import app.redmart.com.data.model.Product;
import app.redmart.com.view.ProductDetailActivity;
import app.redmart.com.view.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Product> mData;
    RequestOptions options ;

    public RecycleViewAdapter(Context mContext, List<Product> products){
        this.mContext = mContext;
        this.mData = products;
        options = new RequestOptions()
                .centerCrop();
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_product,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Glide.with(mContext).load(mData.get(position).getImg().getName()).apply(options).into(holder.product_img);
        holder.product_title.setText(mData.get(position).getTitle());
        holder.product_measure.setText(mData.get(position).getMeasure().getWt_or_vol());
        holder.product_price.setText("$"+String.valueOf(mData.get(position).getPricing().getPrice()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ProductDetailActivity.class);
                intent.putExtra("ID",mData.get(position).getId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.product_title)
        TextView product_title;

        @BindView(R.id.product_img)
        ImageView product_img;

        @BindView(R.id.product_measure)
        TextView product_measure;

        @BindView(R.id.product_price)
        TextView product_price;

        @BindView(R.id.cardview_id)
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void addProduct(List<Product> mProducts){
        for (Product product : mProducts) mData.add(product);
        notifyDataSetChanged();
    }
}

