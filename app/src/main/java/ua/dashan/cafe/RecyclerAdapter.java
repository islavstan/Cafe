package ua.dashan.cafe;



import android.app.Fragment;
import android.app.FragmentTransaction;


import android.content.Context;

import android.os.Bundle;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ua.dashan.cafe.database.DatabaseModel;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    static   List<DatabaseModel> dbList;
    static  Context context;
    RecyclerAdapter(Context context, List<DatabaseModel> dbList ){
        this.dbList = new ArrayList<DatabaseModel>();
        this.context = context;
        this.dbList = dbList;

    }



    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        holder.name.setText(dbList.get(position).getName());
        holder.weight.setText(Integer.toString(dbList.get(position).getWeight()));
        holder.image.setImageResource(dbList.get(position).getPhoto());
        holder.price.setText(Integer.toString(dbList.get(position).getPrice())+"грн.");
    }

    @Override
    public int getItemCount() {
        return dbList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView image;
        public TextView name;
        public TextView weight;
        public TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.image);
            name=(TextView)itemView.findViewById(R.id.name);
            weight=(TextView)itemView.findViewById(R.id.weight);
            price=(TextView)itemView.findViewById(R.id.price);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            Fragment fragment = new FullInfoFragment();
            Bundle bundle = new Bundle();
            String name =dbList.get(getAdapterPosition()).getName();
            bundle.putString("name",name);
            fragment.setArguments(bundle);
            if(fragment != null)
                ((MainActivity) context).  getFragmentManager().beginTransaction().remove(fragment).commit();
            FragmentTransaction ft = ((MainActivity) context).getFragmentManager().beginTransaction();
            ft.replace(R.id.categories_container, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

        }


