package com.example.trupti.myjsonwithrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Modal> arraylistdata=new ArrayList<Modal>();

    String jsonstr="{\n" +
            "    \"response\": {\n" +
            "        \"result\": \"success\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"title\": \"HEADER 1\",\n" +
            "                \"description\": \"Lorem Ipsum Dummy Data\",\n" +
            "                \"image\": \"https://s.w.org/about/images/wordpress-logo-notext-bg.png\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"title\": \"HEADER 2\",\n" +
            "                \"description\": \"Dummy Data and Testing\",\n" +
            "                \"image\": \"https://s.w.org/about/images/wordpress-logo-notext-bg.png\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"title\": \"HEADER 3\",\n" +
            "                \"description\": \"Lorem Ipsum Dummy Data\",\n" +
            "                \"image\": \"https://s.w.org/about/images/wordpress-logo-notext-bg.png\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String title=null, description=null;
        String image =null;


        RecyclerView rv=(RecyclerView)findViewById(R.id.rview);
        Myadapter adpter=new Myadapter(arraylistdata,this);
        rv.setAdapter(adpter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);


        try {

            JSONObject rootjsonObject=new JSONObject(jsonstr);

            JSONObject response=rootjsonObject.getJSONObject("response");

            // String rootresult=response.getString("result");




            JSONArray jsonArray= response.getJSONArray("data");
            for (int i=0; i< jsonArray.length() ; i++) {

                JSONObject myobj=jsonArray.getJSONObject(i);

                title=myobj.getString("title");
                description=myobj.getString("description");
                image=myobj.getString("image");


                Modal md=new Modal();
                md.setAtitle(title);
                md.setAdescription(description);
                md.setAimage(image);

                arraylistdata.add(md);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
