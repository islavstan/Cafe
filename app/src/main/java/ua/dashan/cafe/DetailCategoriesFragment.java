package ua.dashan.cafe;

import android.app.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.List;

import ua.dashan.cafe.database.DatabaseHelpher;
import ua.dashan.cafe.database.DatabaseModel;


public class DetailCategoriesFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<DatabaseModel> dbList;
    private DatabaseHelpher helper;
    private String drinkCategory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_categories_fragment,container,false);
        recyclerView=(RecyclerView)v.findViewById(R.id.rv_list);
        Bundle bundle = getArguments();
       // if (bundle != null) {
             drinkCategory = bundle.getString("category");
     //   sushiCategory = bundle.getString("Напитки");
       // }

        helper = new DatabaseHelpher(getActivity());

        dbList= new ArrayList<DatabaseModel>();
        dbList = helper.getFoodFromDB(drinkCategory );
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(),dbList);
        recyclerView.setAdapter(adapter);
        return v;
    }


}

