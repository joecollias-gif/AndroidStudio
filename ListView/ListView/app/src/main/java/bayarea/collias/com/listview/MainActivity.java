
package bayarea.collias.com.listview;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    String[] items;
    String[] prices;
    String[] descriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);
        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);
        myListView.setAdapter(itemAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent showDetailActivity =
                        new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("bayarea.collias.com.ITEM_INDEX", i);
                startActivity(showDetailActivity);
            }
        });



        //myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_listview_detail, items));

    }
}
