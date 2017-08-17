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

    private String[] items = {"워너원","태양","쇼미더머니","로꼬"};   // list에 들어갈 내용

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listbtn = (Button)findViewById(R.id.listbtn);
        exitbtn = (Button)findViewById(R.id.exitbtn);

        // list 리스너
        listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);  // alert창 띄우기 (MainActivity에 종속)
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

        // exit 리스너
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                 builder.setMessage("종료할꺼임?");   // builder에 msg 설정
                builder.setTitle("종료 알림창")
                        .setCancelable(false)  // 사용자가 임의로 종료할 수 없도록 함
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();   // 전체 종료
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();  // alert창만 꺼짐
                            }
                        });
                AlertDialog alert = builder.create();  // 객체 할당
                alert.setTitle("종료알림창");
                alert.show();  // 보여주기

            }
        });

    }
}
