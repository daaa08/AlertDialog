# Dialog
-  전체 화면을 다 채우지 않고 일부 화면만 가리는 창
 > 구성요소
- Title - 다이얼로그의 제목입니다.
- Content - 사용자에게 보여줄 내용으로 문자열, 리스트, 커스텀 레이아웃이 가능합니다.
- Button - 버튼 3개까지 가능합니다.  Positive, Negative, Neutral Button 3가지 타입이 있습니다.
  - Positve -> YES 또는 OK 사용자가 허락
  - Negative -> NO 또는 Cancel 사용자가 불허 혹은 취소
  - Neutral -> Later 결정을 연기
  
  - list dialog창 띄우기
  ```java
  Button listbtn;

  private String[] items = {"워너원","태양","쇼미더머니","로꼬"};   // list에 들어갈 내용

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
  ```
  
  - exit dialog창 띄우기
  ```java
   Button exitbtn;
  
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
  ```
