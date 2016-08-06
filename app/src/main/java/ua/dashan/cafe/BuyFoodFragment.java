package ua.dashan.cafe;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


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
    private Button cancelButton;
    private BoughtFoodRecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_buy_fragment,container,false);

        recyclerView=(RecyclerView)v.findViewById(R.id.rv_list);


        helper = new DatabaseHelpher(getActivity());
        cancelButton=(Button)v.findViewById(R.id.cancelButton);

        dbList= new ArrayList<DatabaseModel>();
        dbList = helper.getBuyFoodFromDB();

        recyclerView.setHasFixedSize(true);
         layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

          adapter = new BoughtFoodRecyclerAdapter(getActivity(),dbList);

        recyclerView.setAdapter(adapter);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.removeAllBuyFood();
                helper.cancelBuyFood();






            }
        });

        return v;
    }





}




