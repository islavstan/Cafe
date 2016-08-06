package ua.dashan.cafe;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ua.dashan.cafe.database.DatabaseHelpher;
import ua.dashan.cafe.database.DatabaseModel;

public class BoughtFoodRecyclerAdapter extends RecyclerView.Adapter<BoughtFoodRecyclerAdapter.ViewHolder> {
    static DatabaseHelpher helpher;
    static   List<DatabaseModel> dbList;
    static  Context context;
    BoughtFoodRecyclerAdapter(Context context, List<DatabaseModel> dbList ){
        this.dbList = new ArrayList<DatabaseModel>();
        this.context = context;
        this.dbList = dbList;
        helpher=new DatabaseHelpher(context);

    }



    @Override
    public BoughtFoodRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.buy_card_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BoughtFoodRecyclerAdapter.ViewHolder holder, final int position) {

        holder.name.setText(dbList.get(position).getName());
        holder.weight.setText(Integer.toString(dbList.get(position).getWeight()));
        holder.image.setImageResource(dbList.get(position).getPhoto());
        holder.price.setText(Integer.toString(dbList.get(position).getPrice())+"грн.");
        holder.garbagebucket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dbList.size()>0) {
                   // String itemLabel = dbList.get(position).getName();
                    helpher.cancelBuyOneFood(dbList.get(position).getName());
                    dbList.remove(position);
                    notifyDataSetChanged();

                }

            }
        });

    }



    public void removeAllBuyFood(){
            dbList.removeAll(dbList);
            notifyDataSetChanged();
        }

    @Override
    public int getItemCount() {
        return dbList.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView image,garbagebucket;
        public TextView name;
        public TextView weight;
        public TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.image);
            garbagebucket=(ImageView)itemView.findViewById(R.id.garbagebucket);
            name=(TextView)itemView.findViewById(R.id.name);
            weight=(TextView)itemView.findViewById(R.id.weight);
            price=(TextView)itemView.findViewById(R.id.price);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

        }



    }

        }


