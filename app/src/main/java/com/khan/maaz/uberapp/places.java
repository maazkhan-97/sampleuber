package com.khan.maaz.uberapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class places extends AppCompatActivity{
    Spinner user;
    ArrayAdapter<CharSequence> adapteruser;
    String[] titles;
    String[] descriptions;
    ListView locations;
    int[] images = {R.drawable.loc,R.drawable.loc,R.drawable.loc};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        user = (Spinner) findViewById(R.id.user);
        adapteruser= ArrayAdapter.createFromResource(this,R.array.for_user,android.R.layout.simple_spinner_item);
        adapteruser.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        user.setAdapter(adapteruser);

        Resources rs = getResources();
        titles= rs.getStringArray(R.array.titles_of_list);
        descriptions= rs.getStringArray(R.array.descriptions_of_list);



        locations = (ListView) findViewById(R.id.list_view);
        khan adapter=new khan(this,titles,images,descriptions);
        locations.setAdapter(adapter);
        locations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent it = new Intent(view.getContext(),MapsActivity.class);
                    startActivityForResult(it,0);

                }
                if(position==1){
                    Intent it = new Intent(view.getContext(),MapsActivity.class);
                    startActivityForResult(it,0);
                }
                if(position==2){
                    Intent it = new Intent(view.getContext(),MapsActivity.class);
                    startActivityForResult(it,0);
                }
            }
        });

    }
}
class khan extends ArrayAdapter<String>
{
    int[] images;
    Context context;
    String[] titlearray;
    String[] descriptionarray;
    khan(Context c, String[] titles, int[] imgs, String[] descriptions)
    {
        super(c,R.layout.single,R.id.title_of_list,titles);
        this.context=c;
        this.images=imgs;
        this.titlearray=titles;
        this.descriptionarray=descriptions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single,parent,false);

        ImageView img=(ImageView)row.findViewById(R.id.image_for_list);
        TextView tt=(TextView)row.findViewById(R.id.title_of_list);
        TextView tt1=(TextView)row.findViewById(R.id.description_of_list);

        img.setImageResource(images[position]);
        tt.setText(titlearray[position]);
        tt1.setText(descriptionarray[position]);


        return row;
    }

}
