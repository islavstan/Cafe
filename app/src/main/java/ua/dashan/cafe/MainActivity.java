package ua.dashan.cafe;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.categories_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            CategoriesFragment categoriesFragment =new CategoriesFragment();
            fragmentTransaction.add(R.id.categories_container, categoriesFragment, null);
            fragmentTransaction.commit();
        }





        BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);

       // bottomBar.useDarkTheme(true);
        bottomBar.setItemsFromMenu(R.menu.buttons_menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int itemId) {
                switch (itemId) {
                    case R.id.home:
                        Toast toast = Toast.makeText(getApplicationContext(),
                            "домой", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.share:
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "акции", Toast.LENGTH_SHORT);
                        toast1.show();
                        break;
                    case R.id.bucket:
                        Toast toast2 = Toast.makeText(getApplicationContext(),
                                "корзина", Toast.LENGTH_SHORT);
                        toast2.show();
                        break;
                }
            }
        });
        //устанавливаем розовый цвет на нажатую иконку
        bottomBar.setActiveTabColor("#C2185B");
    }
}
