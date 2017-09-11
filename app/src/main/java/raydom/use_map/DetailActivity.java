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
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by LeeSunjun on 2017-08-16.
 */

public class DetailActivity extends Activity {

    Context context = this;

    String UserID;
    String MarkID;
    String Category;
    String UserPic;

    String star_point;
    String review;

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
        ImageView profile = (ImageView)findViewById(R.id.user_icon) ;

        Intent intent = getIntent();
        String url = intent.getStringExtra("Url");
        UserID = intent.getStringExtra("UserID");
        MarkID = intent.getStringExtra("MarkID");
        Category = intent.getStringExtra("Category");
        UserPic = intent.getStringExtra("UserPic");

        Toast.makeText(this, UserID + " / " + MarkID + " / " + Category, Toast.LENGTH_SHORT).show();

        setResult(RESULT_OK,intent);

        Log.d("url_arrived",url);

        Picasso.with(context)
                .load(url)
                .into(main_image);

        Picasso.with(context)
                .load(UserPic)
                .transform(new CropCircleTransformation())
                .into(profile);

        TextView name = (TextView)findViewById(R.id.text_userID);
        name.setText(UserID);

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
        EditText cm = (EditText)findViewById(R.id.comment);
        review = cm.getText().toString();

        Log.d("cm",review);

        if(MarkID.equals("Guest")) {
            SendData sendReview = new SendData();

            if (!get_url(Integer.parseInt(Category)).isEmpty())
                sendReview.sendData6(get_url(Integer.parseInt(Category)), MarkID, UserID, star_point, review);

            this.finish();
        } else {
            Toast.makeText(this, "You have to Login for Reviewing", Toast.LENGTH_SHORT).show();
        }
    }

    public String get_url(int category) {
        if(category == 1)
            return "http://52.79.121.208/review/toilet/toilet_review_write.php";
        else if (category == 2)
            return "http://52.79.121.208/review/wifi/wifi_review_write.php";
        else if (category == 3)
            return "http://52.79.121.208/review/smoke/smoke_review_write.php";
        else if (category == 4)
            return "http://52.79.121.208/review/statue/statue_review_write.php";

        return "";
    }
}
