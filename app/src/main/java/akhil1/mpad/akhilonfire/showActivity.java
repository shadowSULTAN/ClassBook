package akhil1.mpad.akhilonfire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class showActivity extends AppCompatActivity {


    RecyclerView rv;
    DatabaseReference dr;
    MyAdaptor myAdaptor;
    ArrayList <user>list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        rv= findViewById(R.id.userlist);
        dr = FirebaseDatabase.getInstance().getReference("user");
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list= new ArrayList<>();
        loaddatabase();
    }

    private void loaddatabase() {
        if (list.size()>0)
            list.clear();
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    user User=dataSnapshot.getValue(user.class);
                    list.add(User);
                    myAdaptor= new MyAdaptor(showActivity.this,list);
                    rv.setAdapter(myAdaptor);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}