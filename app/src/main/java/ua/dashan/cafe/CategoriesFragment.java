package ua.dashan.cafe;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class CategoriesFragment extends Fragment {
private ImageView drinks;
private ImageView pizza;
private ImageView sushi;
private ImageView hamburguer;
private ImageView steak;
private ImageView spaguetti;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.categories_fragment, null);

        drinks=(ImageView)v.findViewById(R.id.drinks);
        sushi=(ImageView)v.findViewById(R.id.sushi);
        hamburguer=(ImageView)v.findViewById(R.id.hamburguer);
        steak=(ImageView)v.findViewById(R.id.steak);
        spaguetti=(ImageView)v.findViewById(R.id.spaguetti);

        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast toast = Toast.makeText(getActivity(),
                        "drinks", Toast.LENGTH_SHORT);
                toast.show();*/

                Fragment fragment = new DetailCategoriesFragment();
                FragmentTransaction ft =getFragmentManager().beginTransaction();
                ft.replace(R.id.categories_container,fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return v;
    }
}
