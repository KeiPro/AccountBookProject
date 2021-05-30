## Android Studio

- ### Activity추가하기( 화면 이동 )

  - 새로운 자바 파일(SubActivity)을 만들고 extends Activity를 진행.
  - onCreate메소드 overriding.
  - res > layout에 서브에 관련된 layout xml파일 추가.
    - 해당 layout xml을 원하는대로 꾸며주고... 
  - java파일에 setContentView(R.layout.activity_sub); oncreate에 추가.
  - AndroidManifest파일에 .SubActivity추가.

![image-20210530151853950](C:\Users\kyw89\AppData\Roaming\Typora\typora-user-images\image-20210530151853950.png)



* ### Activity이동 ( Intent의 활용. )
  * 액티비티와 액티비티 사이를 이동할 땐 인텐트(Intent) 라는 것을 사용한다. 액티비티끼리 데이터를 주고 받기 위한 부분으로 생각하면 될 것 같다.
  * MainActivity에서 Intent를 생성해준다. 두 번째 인자에는 이동할 class를 적어준다.

  ![image-20210530152423088](C:\Users\kyw89\AppData\Roaming\Typora\typora-user-images\image-20210530152423088.png)
  
  * 해당 액티비티를 종료시키려면 finish(); 코드 추가.
  
  
  
* ### Activity간 데이터 주고받기.

  * 액티비티간에 데이터를 주고 받으려면 Intent에 데이터를 넣으면 됨.

  * Key - Value쌍으로 이루어져 있음.

  * intent.putExtra("Key", "Value");

    

  * SubActivity에서는 intent.getIntent();를 통해 intent의 정보를 가져올 수 있으며,

  * intent.getString(타입명)Extra("Key");를 통해 해당 value값을 받을 수 있음.

  * 지정한 키 값에 맞는 데이터가 없으면 null을 반환함.

![image-20210530155017053](C:\Users\kyw89\AppData\Roaming\Typora\typora-user-images\image-20210530155017053.png)



* Toast 메시지 띄우기 >> Toast.makeText(this, "입력한 아이디는 " + id + "입니다.", Toast.LENGTH_SHORT).show();



## Serializable

* 직렬화를 쓰는 이유는 사용하고 있는 데이터들을 파일 저장 혹은 데이터 통신에서 파싱 할 수 있는 유의미한 데이터를 만들기 위함이다.
* 메모리를 디스크에 저장하거나 네트워크 통신에 사용하기 위한 형식으로 변환하는 것을 말함.

* **직렬화를 하게 되면 각 주소값이 가지는 데이터들을 전부 끌어모아서 값 형식(Value Type)데이터로 변환해준다.** 

  

* 사용자 정의 클래스에 대한 정보를 주고 받으려면 사용자 정의 클래스에 implements Serializable을 추가해야 한다.

* 사용자 정의 클래스를 받으려면 getSerializableExtra를 사용한다.

* ```
  Person person = (Person)intent.getSerializableExtra("신상");
  ```



* 실행한 액티비티로부터 응답을 받는 방법?

* 응답을 받으려면 startActivity가 아니라 startActivityForResult를 호출하여 액티비티를 실행해야 한다.

* 첫 번째 인자에는 인텐트를, 두 번째 인자에는 요청코드를 집어 넣으면 됨.

  * 여기서 요청코드란? 실행한 액티비티를 구분하기 위한 숫자. ( 음수 제외 )

    ```
    startActivityForResult("intent", 0);
    ```

![image-20210530170139429](C:\Users\kyw89\AppData\Roaming\Typora\typora-user-images\image-20210530170139429.png)



* 다시 메인 액티비티로 돌아가서 **onActivityResult**함수를 오버라이드 해줍니다.

* onActivityResult는 startActivityForResult로 실행한 액티비티가 종료되면 호출되며,

  종료된 액티비티가 setResult메소드로 설정한 결과 코드와 데이터가 전달된다.

