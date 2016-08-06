package ua.dashan.cafe;





import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


import android.os.Bundle;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.BottomBarFragment;
import com.roughike.bottombar.OnMenuTabSelectedListener;

import ua.dashan.cafe.database.DatabaseHelpher;
import ua.dashan.cafe.database.DatabaseModel;

public class MainActivity extends FragmentActivity {
 private DatabaseHelpher helpher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.slider_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
           FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             ImageSlider slider=new ImageSlider();
            fragmentTransaction.add(R.id.slider_container, slider, null);
            fragmentTransaction.commit();
        }


        BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);

        bottomBar.setFragmentItems(getSupportFragmentManager(), R.id.categories_container,
                new BottomBarFragment(new CategoriesFragment(), R.drawable.home, "Домой"),
                new BottomBarFragment(new CategoriesFragment(), R.drawable.share, "Акции"),
                new BottomBarFragment(new BuyFoodFragment(), R.drawable.bucket, "Корзина"));

        // Setting colors for different tabs when there's more than three of them.
      /*  bottomBar.mapColorForTab(0, "#3B494C");
        bottomBar.mapColorForTab(1, "#00796B");
        bottomBar.mapColorForTab(2, "#7B1FA2");
*/
        // Make a Badge for the first tab, with red background color and a value of "4".
        helpher=new DatabaseHelpher(this);
        int countBuysItem=helpher.getBuyFoodCount();
        //helpher.close();
        BottomBarBadge unreadMessages = bottomBar.makeBadgeForTabAt(2, "#E91E63", countBuysItem);
        unreadMessages.show();

        unreadMessages.setAnimationDuration(200);

        // If you want the badge be shown always after unselecting the tab that contains it.
       unreadMessages.setAutoShowAfterUnSelection(true);

      /*  bottomBar.setItemsFromMenu(R.menu.buttons_menu, new OnMenuTabSelectedListener() {
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
                        *//*Toast toast2 = Toast.makeText(getApplicationContext(),
                                "корзина", Toast.LENGTH_SHORT);
                        toast2.show();*//*
                        Fragment fragment = new BuyFoodFragment();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.categories_container, fragment);
                        ft.addToBackStack(null);
                        ft.commit();







                        break;
                }
            }
        });*/
        //устанавливаем розовый цвет на нажатую иконку
        //bottomBar.setActiveTabColor("#C2185B");
    }
}
