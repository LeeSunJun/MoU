package raydom.use_map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

/**
 * Created by LeeSunjun on 2017-09-18.
 */

public class AddBoardingActivity extends Activity {

    String userID;
    String lt;
    String lg;

    EditText title;
    EditText content;

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_board);

        Intent intent = getIntent();
        userID = intent.getStringExtra("userID");
        lt = intent.getStringExtra("LT");
        lg = intent.getStringExtra("LG");

        title = (EditText)findViewById(R.id.board_title);
        content = (EditText)findViewById(R.id.board_content);

        url = "http://52.79.121.208/board/board_write.php";
    }

    public void add_board(View v) {
        String t_data = title.getText().toString();
        String c_data = content.getText().toString();

        SendData send_board = new SendData();
        send_board.sendData10(url,lt,lg,t_data,userID,c_data);

        initialize();
    }

    public void cancel_board(View v) {
        initialize();
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