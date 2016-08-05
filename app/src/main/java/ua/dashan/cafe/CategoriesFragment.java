package ua.dashan.cafe;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
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

        drinks = (ImageView) v.findViewById(R.id.drinks);
        sushi = (ImageView) v.findViewById(R.id.sushi);
        hamburguer = (ImageView) v.findViewById(R.id.hamburguer);
        steak = (ImageView) v.findViewById(R.id.steak);
        spaguetti = (ImageView) v.findViewById(R.id.spaguetti);
        pizza = (ImageView) v.findViewById(R.id.pizza);

        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new DetailCategoriesFragment();
                Bundle bundle = new Bundle();
                bundle.putString("category", "Напитки");
                fragment.setArguments(bundle);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.categories_container, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        sushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoriesOnclick("category", "Суши");
            }
        });
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoriesOnclick("category", "Пицца");
            }
        });

        hamburguer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoriesOnclick("category", "Бургер");
            }
        });

        steak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoriesOnclick("category", "Стейк");
            }
        });

        spaguetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoriesOnclick("category", "Паста");
            }
        });


        return v;
    }

    private void categoriesOnclick(String tag, String info) {
        Fragment fragment = new DetailCategoriesFragment();
        Bundle bundle = new Bundle();
        bundle.putString(tag, info);
        fragment.setArguments(bundle);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.categories_container, fragment,"detailTeg");
        ft.addToBackStack(null);
        ft.commit();
    }
}

