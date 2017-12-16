package com.example.myapplication4;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button dialogButton;
public TextView text;
private DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int i) {
        Toast.makeText(MainActivity.this,"Button"+i+"was clicked",Toast.LENGTH_SHORT).show();
    }
};
public boolean onCreateOptionsMenu(Menu menu){
    getMenuInflater().inflate(R.menu.menu,menu);
    return true;
}
public boolean onOptionsItemSelected(MenuItem item){
    text=(TextView)findViewById(R.id.text);
    switch (item.getItemId()){
        case R.id.item11:
            text.setTextSize(20);break;
        case R.id.item12:
            text.setTextSize(30);break;
        case R.id.item13:
            text.setTextSize(40);break;
        case R.id.item2:
            Toast.makeText(MainActivity.this,"普通菜单项",Toast.LENGTH_SHORT).show();break;
        case R.id.item31:
            text.setTextColor(Color.RED);break;
        case R.id.item32:
            text.setTextColor(Color.BLACK);break;
         default:
             break;
    }
    return super.onOptionsItemSelected(item);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogButton=(Button)findViewById(R.id.dialog_button);
        dialogButton.setOnClickListener(new View.OnClickListener(){
         //  @Override
           public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                View view1=View.inflate(MainActivity.this,R.layout.login,null);
                final EditText username=(EditText)view1.findViewById(R.id.username);
                final EditText password=(EditText)view1.findViewById(R.id.password);
                final Button button=(Button)view1.findViewById(R.id.btn_sign);
                final Button button2=(Button)view1.findViewById(R.id.btn_cancel);
                builder.setTitle("Andriod App").setView(view1);
                /*builder.setMessage("666");
                builder.setPositiveButton("Positive",listener);
                builder.setNegativeButton("Negative",listener);
                AlertDialog alertDialog=builder.create();
                alertDialog.show();*/
                final AlertDialog alertDialog=builder.create();
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String uname = username.getText().toString().trim();
                        String psd = password.getText().toString().trim();

                            Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();

                    }

                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }

                });
                alertDialog.show();
            }
        });
   }
}
