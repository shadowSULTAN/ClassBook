package akhil1.mpad.akhilonfire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    LinearLayout layout2;
    RelativeLayout layout;
    FirebaseAuth mAuth;
    Handler handler  = new Handler();
    Runnable run = new Runnable() {
        @Override
        public void run() {

            layout.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.VISIBLE);
        }
    };
    public ProgressDialog loginprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        mAuth=FirebaseAuth.getInstance();
        EditText emailB = findViewById(R.id.et11);
        EditText pass = findViewById(R.id.et12);
        Button main = findViewById(R.id.mainBtn);
        TextView forgetpass=findViewById(R.id.forr);
        loginprogress=new ProgressDialog(this);

        layout = (RelativeLayout) findViewById(R.id.mainlay);
        layout2 = (LinearLayout) findViewById(R.id.lay2);

        TextView txt = (TextView) findViewById(R.id.regsterrr);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });

        handler.postDelayed(run,2000);

        ImageView codeimage = (ImageView) findViewById(R.id.imgcodee);
        codeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,homepage.class);
                intent.putExtra("key","<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<RelativeLayout\n" +
                        "    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                        "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                        "    android:layout_width=\"match_parent\"\n" +
                        "    android:background=\"@color/white\"\n" +
                        "    android:animateLayoutChanges=\"true\"\n" +
                        "    android:layout_height=\"match_parent\"\n" +
                        "    tools:context=\".MainActivity\">\n" +
                        "\n" +
                        "\n" +
                        "    <ImageView\n" +
                        "        android:layout_width=\"60dp\"\n" +
                        "        android:layout_height=\"60dp\"\n" +
                        "        android:id=\"@+id/imgcodee\"\n" +
                        "        android:src=\"@drawable/ic_code\"\n" +
                        "        android:layout_marginLeft=\"350dp\"/>\n" +
                        "    <RelativeLayout\n" +
                        "        android:id=\"@+id/lay1\"\n" +
                        "        android:layout_width=\"wrap_content\"\n" +
                        "        android:layout_height=\"wrap_content\"\n" +
                        "\n" +
                        "        android:layout_centerInParent=\"true\"\n" +
                        "        android:layout_marginRight=\"40dp\"\n" +
                        "        android:layout_marginLeft=\"40dp\">\n" +
                        "\n" +
                        "        <androidx.cardview.widget.CardView\n" +
                        "            android:layout_width=\"120dp\"\n" +
                        "            android:id=\"@+id/imgg\"\n" +
                        "            app:cardCornerRadius=\"100dp\"\n" +
                        "            android:layout_height=\"120dp\">\n" +
                        "\n" +
                        "            <com.google.android.material.imageview.ShapeableImageView\n" +
                        "                android:layout_width=\"120dp\"\n" +
                        "                android:layout_height=\"120dp\"\n" +
                        "                android:layout_gravity=\"center\"\n" +
                        "                android:adjustViewBounds=\"true\"\n" +
                        "                android:scaleType=\"centerCrop\"\n" +
                        "                android:src=\"@drawable/fox\" />\n" +
                        "\n" +
                        "        </androidx.cardview.widget.CardView>\n" +
                        "\n" +
                        "\n" +
                        "        <RelativeLayout\n" +
                        "            android:id=\"@+id/mainlay\"\n" +
                        "            android:layout_width=\"wrap_content\"\n" +
                        "            android:layout_height=\"wrap_content\"\n" +
                        "            android:layout_below=\"@+id/imgg\"\n" +
                        "            android:visibility=\"gone\">\n" +
                        "\n" +
                        "            <TextView\n" +
                        "                android:layout_width=\"wrap_content\"\n" +
                        "                android:layout_height=\"wrap_content\"\n" +
                        "                android:layout_marginTop=\"15dp\"\n" +
                        "                android:id=\"@+id/txt11\"\n" +
                        "                android:text=\"@string/logname\"\n" +
                        "                android:textColor=\"@color/black\"\n" +
                        "                android:textSize=\"24dp\" />\n" +
                        "\n" +
                        "            <EditText\n" +
                        "                android:layout_width=\"match_parent\"\n" +
                        "                android:layout_height=\"wrap_content\"\n" +
                        "                android:layout_marginTop=\"30dp\"\n" +
                        "                android:layout_below=\"@+id/txt11\"\n" +
                        "                android:id=\"@+id/et11\"\n" +
                        "                android:background=\"@drawable/outline\"\n" +
                        "                android:drawableLeft=\"@drawable/ic_baseline_perm_identity_24\"\n" +
                        "                android:drawablePadding=\"5dp\"\n" +
                        "                android:hint=\"@string/usrhint\"\n" +
                        "                android:paddingLeft=\"15dp\" />\n" +
                        "\n" +
                        "            <EditText\n" +
                        "                android:id=\"@+id/et12\"\n" +
                        "                android:layout_width=\"match_parent\"\n" +
                        "                android:layout_height=\"wrap_content\"\n" +
                        "                android:layout_below=\"@+id/et11\"\n" +
                        "                android:layout_marginTop=\"10dp\"\n" +
                        "                android:background=\"@drawable/outline\"\n" +
                        "                android:drawableLeft=\"@drawable/ic_baseline_lock\"\n" +
                        "                android:drawablePadding=\"5dp\"\n" +
                        "                android:hint=\"@string/password\"\n" +
                        "                android:paddingLeft=\"15dp\" />\n" +
                        "\n" +
                        "            <androidx.appcompat.widget.AppCompatButton\n" +
                        "                android:layout_width=\"wrap_content\"\n" +
                        "                android:layout_height=\"wrap_content\"\n" +
                        "                android:layout_below=\"@+id/et12\"\n" +
                        "                android:layout_centerInParent=\"true\"\n" +
                        "                android:layout_gravity=\"center_vertical\"\n" +
                        "                android:layout_marginTop=\"24dp\"\n" +
                        "                android:background=\"@drawable/gradient\"\n" +
                        "                android:gravity=\"center\"\n" +
                        "                android:text=\"@string/login\"\n" +
                        "                android:textColor=\"@color/white\" />\n" +
                        "\n" +
                        "\n" +
                        "        </RelativeLayout>\n" +
                        "\n" +
                        "    </RelativeLayout>\n" +
                        "    <LinearLayout\n" +
                        "        android:id=\"@+id/lay2\"\n" +
                        "        android:layout_below=\"@+id/lay1\"\n" +
                        "        android:layout_width=\"match_parent\"\n" +
                        "        android:layout_height=\"wrap_content\"\n" +
                        "        android:orientation=\"vertical\"\n" +
                        "        android:visibility=\"gone\">\n" +
                        "\n" +
                        "        <TextView\n" +
                        "            android:layout_width=\"wrap_content\"\n" +
                        "            android:layout_height=\"wrap_content\"\n" +
                        "            android:layout_gravity=\"center\"\n" +
                        "            android:layout_marginTop=\"20dp\"\n" +
                        "            android:text=\"@string/forget\"\n" +
                        "            android:textColor=\"@color/vio\" />\n" +
                        "\n" +
                        "        <LinearLayout\n" +
                        "            android:layout_width=\"match_parent\"\n" +
                        "            android:layout_height=\"wrap_content\"\n" +
                        "            android:layout_gravity=\"center\"\n" +
                        "            android:layout_marginTop=\"50dp\"\n" +
                        "            android:gravity=\"center\"\n" +
                        "            android:orientation=\"horizontal\">\n" +
                        "\n" +
                        "\n" +
                        "            <TextView\n" +
                        "                android:layout_width=\"wrap_content\"\n" +
                        "                android:layout_height=\"wrap_content\"\n" +
                        "                android:layout_gravity=\"right\"\n" +
                        "                android:gravity=\"right\"\n" +
                        "                android:text=\"@string/register\"\n" +
                        "                android:textColor=\"@color/black\" />\n" +
                        "\n" +
                        "            <TextView\n" +
                        "                android:layout_width=\"wrap_content\"\n" +
                        "                android:layout_height=\"wrap_content\"\n" +
                        "                android:layout_gravity=\"right\"\n" +
                        "                android:gravity=\"right\"\n" +
                        "                android:id=\"@+id/regsterrr\"\n" +
                        "                android:text=\"@string/create\"\n" +
                        "                android:textColor=\"@color/vio\" />\n" +
                        "\n" +
                        "        </LinearLayout>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "    </LinearLayout>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "</RelativeLayout>");
                startActivity(intent);
            }
        });
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRecoverPasswordDialog();
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = emailB.getText().toString().trim();
                password = pass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Please enter email!!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Please enter password!!", Toast.LENGTH_LONG).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login successful!!", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(MainActivity.this,showActivity.class));
                        }

                        else {

                            Toast.makeText(getApplicationContext(), "Login failed!!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    private void showRecoverPasswordDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Recover Password");
        LinearLayout linearLayout=new LinearLayout(this);
        final EditText emailet= new EditText(this);

        // write the email using which you registered
        emailet.setText("Email");
        emailet.setMinEms(16);
        emailet.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        linearLayout.addView(emailet);
        linearLayout.setPadding(10,10,10,10);
        builder.setView(linearLayout);

        builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String email=emailet.getText().toString().trim();
                beginRecovery(email);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    ProgressDialog loadingBar;

    private void  beginRecovery(String email){
        loadingBar=new ProgressDialog(this);
        loadingBar.setMessage("Sending Email....");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                loadingBar.dismiss();
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"Done sent",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error Occured",Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loadingBar.dismiss();
                Toast.makeText(getApplicationContext(),"Error Failed",Toast.LENGTH_LONG).show();
            }
        });

    }
}