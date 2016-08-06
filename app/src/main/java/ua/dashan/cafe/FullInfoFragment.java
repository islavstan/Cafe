package ua.dashan.cafe;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ua.dashan.cafe.database.DatabaseHelpher;
import ua.dashan.cafe.database.DatabaseModel;

public class FullInfoFragment extends Fragment {
    DatabaseHelpher helpher;
    List<DatabaseModel> dbList;
    private ImageView detimage;
    private TextView detname;
    private TextView detconsist;
    private TextView detweight;
    private TextView detprice;
    private Button buyButton;
    private String positionName;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.full_info_with_buy,container,false);
        detimage=(ImageView)v.findViewById(R.id.detimage);
        detconsist=(TextView) v.findViewById(R.id.detconsist);
        detname=(TextView) v.findViewById(R.id.detname);
        detweight=(TextView) v.findViewById(R.id.detweight);
        detprice=(TextView) v.findViewById(R.id.detprice);
        buyButton=(Button) v.findViewById(R.id.buyButton);
        Bundle bundle = getArguments();
        positionName = bundle.getString("name");
        helpher = new DatabaseHelpher(getActivity());
        dbList= new ArrayList<DatabaseModel>();
        dbList = helpher.getOneFoodFromDB(positionName);

            String name= dbList.get(0).getName();
            String consist=dbList.get(0).getConsist();
            int photo=dbList.get(0).getPhoto();
            int weight=dbList.get(0).getWeight();
            int price=dbList.get(0).getPrice();


            detname.setText(name);
            detconsist.setText(consist);
            detimage.setImageResource(photo);
            detweight.setText(weight+"г.");
            detprice.setText(price+"грн.");

         buyButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 helpher.buyFood(dbList.get(0));
             }
         });





        return v;
}}
