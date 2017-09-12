package raydom.use_map;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017-06-15.
 */

public class Setting extends Activity {

    int phase = 1;

    int category = -1 ;

    RelativeLayout tR;

    DBHandler controller;

    SendData send_personal;

    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        ImageButton ib = (ImageButton)findViewById(R.id.help_next);
        ib.setVisibility(View.GONE);

        tR = (RelativeLayout)findViewById(R.id.help_lay);

        controller = new DBHandler(getApplicationContext());

        send_personal = new SendData();

    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {

            Toast.makeText(Setting.this, "결과가 성공이 아님.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (requestCode == 1) { // get the User ID that login
            initialize();
        }
    }

    public void upload_clicked(View view){
        Toast.makeText(Setting.this, "UploadClicked.", Toast.LENGTH_SHORT).show();

        Cursor c;

        if(category != -1) {
            c = controller.select_all_personal();

            while (c.moveToNext()) {
                // c의 int가져와라 ( c의 컬럼 중 id) 인 것의 형태이다.
                double lt = c.getDouble(c.getColumnIndex("latitude"));
                double lg = c.getDouble(c.getColumnIndex("longitude"));
                String name = c.getString(c.getColumnIndex("name"));

                send_personal.sendData8("",Double.toString(lt),Double.toString(lg),name);
            }
        }
    }

    public void logout_clicked(View view){

        /*AuthActivity authActivity = new AuthActivity();
        authActivity.kakaoLogout();;*/
        kakaoActivity kakao = new kakaoActivity();
        kakao.kakaoLogout();

        startActivityForResult(new Intent(this,LoginActivity.class),1);
        initialize();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        //setResult(RESULT_OK,intent);
        finish();
    }
    public void back_clicked(View view){
        Intent intent = new Intent();
        //setResult(RESULT_OK,intent);
        finish();
    }

    public void help_clicked(View view){
        tR.setVisibility(View.GONE);

        ImageView iv = (ImageView)findViewById(R.id.help_view);
        iv.setVisibility(View.VISIBLE);

        ImageButton ib = (ImageButton)findViewById(R.id.help_next);
        ib.setVisibility(View.VISIBLE);
    }

    public void help_next_clicked(View view) {

        ImageView iv = (ImageView)findViewById(R.id.help_view);

        switch (phase) {
            case 1:
                iv.setImageResource(R.drawable.help_background2);
                phase = 2;
                break;
            case 2:
                iv.setImageResource(R.drawable.help_background3);
                phase = 3;
                break;
            case 3:
                iv.setImageResource(R.drawable.help_background4);
                phase = 4;
                break;
            case 4:
                iv.setVisibility(View.GONE);
                iv.setImageResource(R.drawable.help_background1);

                ImageButton ib = (ImageButton)findViewById(R.id.help_next);
                ib.setVisibility(View.GONE);

                tR.setVisibility(View.VISIBLE);

                phase = 1;
                break;
        }
    }

    private void initialize(){
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                finish();
            }
        };

        handler.sendEmptyMessageDelayed(0,0);
    }

}
