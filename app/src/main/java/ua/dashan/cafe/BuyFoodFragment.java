package ua.dashan.cafe;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import ua.dashan.cafe.R;
import ua.dashan.cafe.RecyclerAdapter;
import ua.dashan.cafe.database.DatabaseHelpher;
import ua.dashan.cafe.database.DatabaseModel;

public class BuyFoodFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<DatabaseModel> dbList;
    private DatabaseHelpher helper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_buy_fragment,container,false);
        recyclerView=(RecyclerView)v.findViewById(R.id.rv_list);


        helper = new DatabaseHelpher(getActivity());

        dbList= new ArrayList<DatabaseModel>();
        dbList = helper.getBuyFoodFromDB();
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(),dbList);
        recyclerView.setAdapter(adapter);
        return v;
    }


}




