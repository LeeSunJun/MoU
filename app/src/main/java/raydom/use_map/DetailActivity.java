package raydom.use_map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by LeeSunjun on 2017-08-16.
 */

public class DetailActivity extends Activity {

    Context context = this;

    String user_id;
    String star_point;
    String review;

    EditText cm;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        ImageButton star;

        star = (ImageButton) findViewById(R.id.star1);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));
        star = (ImageButton) findViewById(R.id.star2);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));
        star = (ImageButton) findViewById(R.id.star3);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));
        star = (ImageButton) findViewById(R.id.star4);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));
        star = (ImageButton) findViewById(R.id.star5);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));

        ImageView main_image = (ImageView)findViewById(R.id.main_image);

        Intent intent = getIntent();
        String url = intent.getStringExtra("Url");

        setResult(RESULT_OK,intent);

        Log.d("url_arrived",url);

        Picasso.with(context)
                .load(url)
                .into(main_image);

        cm = (EditText)findViewById(R.id.comment);

        //initialize();
    }

    private void initialize(){
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                finish();
            }
        };

        handler.sendEmptyMessageDelayed(0,1500);
    }

    public void star1_clicked(View v) {
        ImageButton star;

        star = (ImageButton) findViewById(R.id.star1);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star2);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));
        star = (ImageButton) findViewById(R.id.star3);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));
        star = (ImageButton) findViewById(R.id.star4);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));
        star = (ImageButton) findViewById(R.id.star5);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));

        star_point = "1";
    }

    public void star2_clicked(View v) {
        ImageButton star;

        star = (ImageButton) findViewById(R.id.star1);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star2);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star3);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));
        star = (ImageButton) findViewById(R.id.star4);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));
        star = (ImageButton) findViewById(R.id.star5);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));

        star_point = "2";
    }

    public void star3_clicked(View v) {
        ImageButton star;

        star = (ImageButton) findViewById(R.id.star1);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star2);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star3);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star4);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));
        star = (ImageButton) findViewById(R.id.star5);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));

        star_point = "3";
    }

    public void star4_clicked(View v) {
        ImageButton star;

        star = (ImageButton) findViewById(R.id.star1);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star2);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star3);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star4);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star5);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.blank_star));

        star_point = "4";
    }

    public void star5_clicked(View v) {
        ImageButton star;

        star = (ImageButton) findViewById(R.id.star1);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star2);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star3);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star4);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));
        star = (ImageButton) findViewById(R.id.star5);
        star.setBackgroundDrawable(getResources().getDrawable(R.drawable.filled_star));

        star_point = "5";
    }

    public void review_submit_clicked(View v) {
        review = cm.toString();

        this.finish();
    }
}
