package eniso.ia2.booksapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.service.autofill.Dataset;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import static java.security.AccessController.getContext;

public class VolleyActivity extends AppCompatActivity {
    private TextView text;
   // private ProgressDialog pDialog;
    private List<Book> bookList = new ArrayList<Book>();
    private ListView listView;
    private CustomListAdapter adapter;
    private RequestQueue mQueue;
    Button btn;
    String d;
    int i;
   // static final String url = "https://api.myjson.com/bins/szghz";
   // static final String url= "https://api.myjson.com/bins/13c02y";

    static final String url="https://api.myjson.com/bins/j7umy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        text = (TextView) findViewById(R.id.t);
        listView=(ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, bookList);
        listView.setAdapter(adapter);
        btn= (Button) findViewById(R.id.btn);
        mQueue = Volley.newRequestQueue(this);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                           for (int i = 0; i < jsonArray.length(); i++) {

                                try {
                                    JSONObject books = jsonArray.getJSONObject(i);
                                    Book book = new Book();
                                    book.setTitle(books.getString("Title"));
                                    book.setAuthor(books.getString("Author"));
                                    book.setGenre(books.getString("Genre"));
                                    book.setRating(books.getInt("Rating"));
                                    book.setImageUrl(books.getString("Image"));

                                    d=books.getString("Details");
                                    book.setDetails(d);
                                //    book.setDetails(books.getString("Details"));

                                  //  book.setUserRating(books.getInt("User Rating"));
                                    bookList.add(book);
                                   // listView.getOnItemClickListener(new AdapterView<T> adapter,View view, int i, long l){
                                  /*  listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                                            Intent in =new Intent(VolleyActivity.this,OneActivity.class);
                                            in.putExtra("details",d);
                                            startActivity(in);
                                        }
                                    }); */


                                }
                                catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position,
                                                    long id) {
                                Book book=(Book)listView.getItemAtPosition(position);
                                Intent in= new Intent(view.getContext(),OneActivity.class);
                                in.putExtra("details",book.getDetails());
                                in.putExtra("Title",book.getTitle());

                              //  String item =  listView.getSelectedItemPosition()+"";
                                startActivity(in);

                               // Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

                            }
                        });



                        //text.setText(d);
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}


//String url = "http://192.168.1.5:49530/api/Books/";


// int id = books.getInt("Id");
//String Title = books.getString("Title");
// String Author = books.getString("Author");
//  text.append("  " + Title + "," + Author+ "  ; " );
//mAdapter.notifyDataSetChanged();


