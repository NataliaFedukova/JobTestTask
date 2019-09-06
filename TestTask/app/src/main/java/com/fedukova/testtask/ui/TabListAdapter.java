package com.fedukova.testtask.ui;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fedukova.testtask.R;
import com.fedukova.testtask.entity.Animal;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TabListAdapter extends RecyclerView.Adapter<TabListAdapter.TabListItemViewHolder> {

    private List<Animal> mItemsList;
    private Context      mContext;
    private OnListItemClickListener mOnItemClickListener;

    public TabListAdapter(List<Animal> items){
        mItemsList = items;
    }

    @NonNull
    @Override
    public TabListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_list_item_view,parent,false);
        mContext = parent.getContext();
        return new TabListItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TabListItemViewHolder holder, int position) {

        holder.mTitle.setText(Integer.toString(position + 1));

        Animal item = mItemsList.get(position);
        holder.mText.setText(item.getText());
        Picasso.get()
               .load(item.getUrl())
               .fit()
               .into(holder.mIcon);

    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }

    public void setOnItemClickListener(OnListItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnListItemClickListener{
        void onListItemClicked(int position);
    }

    public void setItems(List<Animal> newItems){
        mItemsList = newItems;
        notifyDataSetChanged();
    }

    public class TabListItemViewHolder extends RecyclerView.ViewHolder{

        public final ImageView mIcon;
        public final TextView  mTitle;
        public final TextView  mText;

        public TabListItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.icon_view);
            mTitle = itemView.findViewById(R.id.title_text_view);
            mText = itemView.findViewById(R.id.description_text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnItemClickListener != null)
                        mOnItemClickListener.onListItemClicked(getAdapterPosition());
                }
            });
        }
    }
}
