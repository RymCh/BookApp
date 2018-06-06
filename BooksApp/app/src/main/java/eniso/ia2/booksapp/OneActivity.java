package eniso.ia2.booksapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class OneActivity extends AppCompatActivity {
    // String data;
    DatabaseReference rootref, childread, childborrow;
    TextView te, title;
    //  TextView test;

    Button borrowbtn;
    String data2;
    Button readbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        rootref = FirebaseDatabase.getInstance().getReference();
        childborrow = rootref.child("Borrow");
        childread = rootref.child("Read");
        te = (TextView) findViewById(R.id.te);
        title = (TextView) findViewById(R.id.title);
        borrowbtn = (Button) findViewById(R.id.borrow);
        readbtn = (Button) findViewById(R.id.read);
        String data = getIntent().getExtras().getString("details");
        data2 = getIntent().getExtras().getString("Title");

        title.setText("Summary of : " + data2);
        te.setText(data);

        //test.setText(childborrow.toString());
        borrowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                childborrow.setValue(data2);
                // childborrow.setValue(data2);
                  borrowbtn.setBackgroundColor(getResources().getColor(R.color.list_divider));

            }
        });
        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //childborrow.child("Title").setValue("title");
                childread.push().setValue(data2);
                 readbtn.setBackgroundColor(getResources().getColor(R.color.list_divider));
            }
        });
        rootref.addValueEventListener(new ValueEventListener() {

            public void onDataChange(DataSnapshot dataSnapshot) {
                List myList = new ArrayList<>();
                int s = 0;
                int g = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String key = snapshot.getKey().toString();
                    String value = snapshot.getValue().toString();

                    if (key.equals("Borrow")) {



                        if (!value.isEmpty()) {
                            borrowbtn.setBackgroundColor(getResources().getColor(R.color.list_divider));
                        }


                    }




                    }
                }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
           /* if (key.equals("Parking2")) {
                key = "P2";
                p2.setText(key);


                if (value.contains("False")) {
                    value = "False";
                    g=0;
                    p2.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (value.contains("True")) {
                    value = "True";
                    g=1;
                    p2.setBackgroundColor(getResources().getColor(R.color.red));
                }*/


    }}



