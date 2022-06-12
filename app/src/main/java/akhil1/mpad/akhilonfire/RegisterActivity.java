package akhil1.mpad.akhilonfire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
 private FirebaseDatabase db=FirebaseDatabase.getInstance();
 private DatabaseReference root= db.getReference("user");
    LinearLayout layout;
    FirebaseAuth fauth;
    String uid;

    EditText name,email,pass,conpass;
    Handler hans = new Handler();
    Runnable run = new Runnable() {
        @Override
        public void run() {
            layout.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        fauth = FirebaseAuth.getInstance();

        layout = (LinearLayout) findViewById(R.id.layout1);
        TextView txt2 = (TextView)findViewById(R.id.signgo);
        name= findViewById(R.id.fn);
        email= findViewById(R.id.en);

        pass= findViewById(R.id.pn);
        conpass= findViewById(R.id.pn2);
        Button register = findViewById(R.id.regBtn);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });

        ImageView imgcode = (ImageView)findViewById(R.id.imacode);
        imgcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regintent = new Intent(RegisterActivity.this,showActivity.class);
                regintent.putExtra("key","<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                        "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                        "    android:layout_width=\"match_parent\"\n" +
                        "    android:layout_height=\"match_parent\"\n" +
                        "    android:orientation=\"vertical\"\n" +
                        "    android:animateLayoutChanges=\"true\"\n" +
                        "    tools:context=\".RegisterActivity\">\n" +
                        "\n" +
                        "\n" +
                        "    <RelativeLayout\n" +
                        "        android:layout_width=\"wrap_content\"\n" +
                        "        android:layout_height=\"wrap_content\">\n" +
                        "\n" +
                        "\n" +
                        "    <androidx.cardview.widget.CardView\n" +
                        "        android:layout_width=\"match_parent\"\n" +
                        "        android:layout_height=\"250dp\"\n" +
                        "        app:cardElevation=\"1dp\">\n" +
                        "\n" +
                        "\n" +
                        "        <FrameLayout\n" +
                        "            android:layout_width=\"match_parent\"\n" +
                        "            android:layout_height=\"match_parent\"\n" +
                        "            android:background=\"@drawable/gradient\">\n" +
                        "\n" +
                        "\n" +
                        "            <ImageView\n" +
                        "                android:layout_width=\"100dp\"\n" +
                        "                android:layout_height=\"100dp\"\n" +
                        "                android:src=\"@drawable/iccon\"\n" +
                        "                android:layout_marginTop=\"40dp\"\n" +
                        "                android:layout_gravity=\"center_horizontal\"/>\n" +
                        "\n" +
                        "\n" +
                        "        </FrameLayout>\n" +
                        "    </androidx.cardview.widget.CardView>\n" +
                        "    </RelativeLayout>\n" +
                        "\n" +
                        "    <LinearLayout\n" +
                        "        android:layout_width=\"match_parent\"\n" +
                        "        android:id=\"@+id/layout1\"\n" +
                        "        android:layout_height=\"wrap_content\"\n" +
                        "        android:layout_marginTop=\"140dp\"\n" +
                        "        android:visibility=\"gone\"\n" +
                        "        android:orientation=\"vertical\">\n" +
                        "\n" +
                        "        <androidx.cardview.widget.CardView\n" +
                        "            android:layout_width=\"350dp\"\n" +
                        "            android:layout_gravity=\"center\"\n" +
                        "            android:layout_height=\"wrap_content\"\n" +
                        "            app:cardBackgroundColor=\"#EFF0F3\"\n" +
                        "            app:cardCornerRadius=\"20dp\"\n" +
                        "            >\n" +
                        "\n" +
                        "            <LinearLayout\n" +
                        "                android:layout_width=\"match_parent\"\n" +
                        "                android:layout_height=\"wrap_content\"\n" +
                        "                android:orientation=\"vertical\"\n" +
                        "                android:paddingLeft=\"30dp\"\n" +
                        "                android:paddingRight=\"30dp\"\n" +
                        "                android:paddingBottom=\"30dp\">\n" +
                        "\n" +
                        "                <TextView\n" +
                        "                    android:layout_width=\"wrap_content\"\n" +
                        "                    android:layout_height=\"wrap_content\"\n" +
                        "                    android:layout_gravity=\"center\"\n" +
                        "                    android:gravity=\"center\"\n" +
                        "                    android:layout_marginTop=\"10dp\"\n" +
                        "                    android:text=\"@string/createacc\"\n" +
                        "                    android:textColor=\"@color/black\"\n" +
                        "                    android:textSize=\"24dp\" />\n" +
                        "                <TextView\n" +
                        "                    android:layout_width=\"wrap_content\"\n" +
                        "                    android:layout_height=\"wrap_content\"\n" +
                        "                    android:text=\"@string/fullname\"\n" +
                        "                    android:textColor=\"@color/vio\"\n" +
                        "                    android:layout_marginTop=\"40dp\"/>\n" +
                        "\n" +
                        "\n" +
                        "                <EditText\n" +
                        "                    android:id=\"@+id/editTextTextPersonName\"\n" +
                        "                    android:layout_width=\"match_parent\"\n" +
                        "                    android:layout_height=\"wrap_content\"\n" +
                        "                    android:layout_marginTop=\"5dp\"\n" +
                        "                    android:ems=\"10\"\n" +
                        "                    android:inputType=\"textPersonName\"\n" +
                        "                    android:hint=\"Your Full name\" />\n" +
                        "\n" +
                        "                <TextView\n" +
                        "                    android:layout_width=\"wrap_content\"\n" +
                        "                    android:layout_height=\"wrap_content\"\n" +
                        "                    android:text=\"@string/email\"\n" +
                        "                    android:textColor=\"@color/vio\"\n" +
                        "                    android:layout_marginTop=\"20dp\"/>\n" +
                        "\n" +
                        "                <EditText\n" +
                        "                    android:id=\"@+id/editTextTextEmailAddress\"\n" +
                        "                    android:layout_width=\"match_parent\"\n" +
                        "                    android:layout_height=\"wrap_content\"\n" +
                        "                    android:layout_marginTop=\"5dp\"\n" +
                        "                    android:hint=\"E-mail\"\n" +
                        "                    android:ems=\"10\"\n" +
                        "                    android:inputType=\"textEmailAddress\" />\n" +
                        "\n" +
                        "                <TextView\n" +
                        "                    android:layout_width=\"wrap_content\"\n" +
                        "                    android:layout_height=\"wrap_content\"\n" +
                        "                    android:text=\"@string/password\"\n" +
                        "                    android:textColor=\"@color/vio\"\n" +
                        "                    android:layout_marginTop=\"20dp\"/>\n" +
                        "\n" +
                        "                <EditText\n" +
                        "                    android:id=\"@+id/editTextTextPassword\"\n" +
                        "                    android:layout_width=\"match_parent\"\n" +
                        "                    android:layout_height=\"wrap_content\"\n" +
                        "                    android:layout_marginTop=\"5dp\"\n" +
                        "                    android:hint=\"@string/password\"\n" +
                        "\n" +
                        "                    android:ems=\"10\"\n" +
                        "                    android:inputType=\"textPassword\" />\n" +
                        "\n" +
                        "                <TextView\n" +
                        "                    android:layout_width=\"wrap_content\"\n" +
                        "                    android:layout_height=\"wrap_content\"\n" +
                        "                    android:text=\"@string/conpass\"\n" +
                        "                    android:textColor=\"@color/vio\"\n" +
                        "                    android:layout_marginTop=\"20dp\"/>\n" +
                        "\n" +
                        "                <EditText\n" +
                        "                    android:id=\"@+id/editTextTextPassword2\"\n" +
                        "                    android:layout_width=\"match_parent\"\n" +
                        "                    android:layout_height=\"wrap_content\"\n" +
                        "                    android:layout_marginTop=\"5dp\"\n" +
                        "                    android:layout_marginBottom=\"30dp\"\n" +
                        "                    android:hint=\"Re-enter Password\"\n" +
                        "                    android:ems=\"10\"\n" +
                        "                    android:inputType=\"textPassword\" />\n" +
                        "\n" +
                        "            </LinearLayout>\n" +
                        "\n" +
                        "\n" +
                        "        </androidx.cardview.widget.CardView>\n" +
                        "        <com.google.android.material.button.MaterialButton\n" +
                        "            android:layout_width=\"wrap_content\"\n" +
                        "            android:layout_height=\"wrap_content\"\n" +
                        "            android:layout_marginTop=\"-30dp\"\n" +
                        "            android:layout_gravity=\"center_horizontal\"\n" +
                        "            android:text=\"Register\"\n" +
                        "            android:backgroundTint=\"@color/vio\"\n" +
                        "            app:cornerRadius=\"10dp\"/>\n" +
                        "\n" +
                        "        <TextView\n" +
                        "            android:layout_width=\"wrap_content\"\n" +
                        "            android:layout_height=\"wrap_content\"\n" +
                        "            android:text=\"Already Have an account!\"\n" +
                        "            android:layout_gravity=\"center_horizontal\"\n" +
                        "            android:id=\"@+id/signgo\"\n" +
                        "            android:textColor=\"@color/vio\"\n" +
                        "            android:layout_marginTop=\"9dp\"/>\n" +
                        "\n" +
                        "    </LinearLayout>\n" +
                        "    \n" +
                        "\n" +
                        "\n" +
                        "</RelativeLayout>");
                startActivity(regintent);
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString().trim();
                String password = conpass.getText().toString().trim();
                String mn = name.getText().toString().trim();
                String TAG="am here";
                HashMap<String,String>usermap=new HashMap<>();
                usermap.put("email",mail);
                usermap.put("name",mn);

                if (email.getText().toString().equals("") || name.getText().toString().equals("") ||
                        pass.getText().toString().equals("")  || conpass.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "Please fill the fields", Toast.LENGTH_SHORT).show();

                } else {
                    if (pass.getText().toString().equals(conpass.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Registration Complete", Toast.LENGTH_SHORT).show();
                        fauth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                      uid=root.push().getKey();
                                   root.child(uid).setValue(usermap);
                                    Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(RegisterActivity.this, showActivity.class);
                                    startActivity(intent);
                                    Log.d(TAG,"am here");
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Registration failed!!" + " Please try again later", Toast.LENGTH_LONG).show();
                                }
                                 }
                        });


                    }else{
                        Toast.makeText(getApplicationContext(), "Confirm your password", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });
        hans.postDelayed(run,400);
    }
}