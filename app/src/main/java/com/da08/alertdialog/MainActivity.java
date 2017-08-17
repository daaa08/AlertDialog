package com.da08.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button listbtn, exitbtn;

    private String[] items = {"워너원","태양","쇼미더머니","로꼬"};   // list에 들어갈 내

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listbtn = (Button)findViewById(R.id.listbtn);
        exitbtn = (Button)findViewById(R.id.exitbtn);

        listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);  // alert창 띄우기
                builder.setTitle("가수");   // alert창 title
                builder.setItems(items, new DialogInterface.OnClickListener() {   // alert창의 내용 넣기
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {   // click했을때에 대한 이벤트 처리
                        Toast.makeText(getApplicationContext(),items[i],Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();  // 객체 할당
                alertDialog.show();  // 보여주기
            }
        });
    }
}
