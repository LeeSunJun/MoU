package raydom.use_map;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * php server로 데이터를 전송
 */

public class SendData {
    int type = -1; // 1 : toilet
                   // 2 : wifi
                   // 3 : smoking
                   // 4 : landmark

    String LT_TAG = "longitude"; //longitude
    String LG_TAG = "latitude"; //latitude

    String ID_TAG = "keyid";

    String uID_TAG = "ID"; //id
    String uPW_TAG = "PW"; //pw

    String mark_name_TAG = "space_name"; //name
    String mark_option1_TAG = ""; //option1
    String mark_option2_TAG = ""; //option2
    String mark_image_TAG = "image"; //file

    String comment_TAG = ""; //comment
    String grade_TAG = ""; //grade

    String sign_name_TAG = "name";
    String sign_id_TAG = "id";
    String sign_pw_TAG = "pwd";
    String sign_mail_TAG = "email";
    String sign_birth_TAG = "birthDay";
    String sign_gender_TAG = "sex";
    String sign_phone_TAG = "PhoneNumber";

    int check = -1;

    void reset_checking() {
        check = -1;
    }

    SendData(){}

    SendData(int type) {
        this.type = type;
    }

    public int get_check(){
        return check;
    }

    //send ID,PW data
    public String sendData1(String url, String id, String pw){

        class HttpUtil extends AsyncTask<String, Void, Void> {

            String res = " ";

            int rcode = -1;

            public String get_result() {
                return res;
            }

            @Override
            public Void doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;

                try {

                    URL url = new URL(uri);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setConnectTimeout(2000);
                    conn.setReadTimeout(2000);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setRequestProperty("Content-Type","application/json");

                    Log.d("Ray","result4 : " + params[1]);
                    byte[] outputInBytes = params[1].getBytes("UTF-8");

                    Log.d("Ray","result5 : " + outputInBytes);

                    OutputStream os = conn.getOutputStream();

                    os.write(outputInBytes);
                    os.flush();
                    os.close();

                    int retCode = conn.getResponseCode();

                    check = retCode;
                    Log.d("Ray","result1 : "+retCode);

                    InputStream is = conn.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while((line = br.readLine()) != null) {
                        response.append(line);
                        response.append('\r');
                    }
                    br.close();

                    res = response.toString();
                    Log.d("Ray","result 2 : "+res);

                    rcode = retCode;

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }
        }

        HttpUtil util = new HttpUtil();

        try {
            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put(uID_TAG, id);
                jsonObject.put(uPW_TAG, pw);
            }catch (JSONException e){

            }

            String json = jsonObject.toString();

            Log.d("Ray","result 3 : "+json);

            util.execute(url,json);

            while(util.rcode == -1) {
                ;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return util.get_result();
    }

    //send LT,LG data
    public void sendData2(String url, String latitude, String longitude){

        class HttpUtil extends AsyncTask<String, Void, Void> {

            @Override
            public Void doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;

                try {

                    URL url = new URL(uri);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setConnectTimeout(2000);
                    conn.setReadTimeout(2000);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setRequestProperty("Content-Type","application/json");

                    byte[] outputInBytes = params[1].getBytes("UTF-8");
                    OutputStream os = conn.getOutputStream();
                    os.write( outputInBytes );
                    os.close();

                    int retCode = conn.getResponseCode();

                    check = retCode;
                    Log.d("Ray","result1 : "+retCode);

                    InputStream is = conn.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while((line = br.readLine()) != null) {
                        response.append(line);
                        response.append('\r');
                    }
                    br.close();

                    String res = response.toString();

                    Log.d("Ray","result 2 : "+res);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }
        }

        try {
            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put(LT_TAG, latitude);
                jsonObject.put(LG_TAG, longitude);
            }catch (JSONException e){

            }

            String json = jsonObject.toString();

            new HttpUtil().execute(url,json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //send LT,LG and options for adding marker
    public void sendData3(String url, String latitude, String longitude, String name, String op1, String op2, String file){

        class HttpUtil extends AsyncTask<String, Void, Void> {

            @Override
            public Void doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;

                try {

                    URL url = new URL(uri);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setConnectTimeout(2000);
                    conn.setReadTimeout(2000);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setRequestProperty("Content-Type","application/json");

                    Log.d("Ray","result_url : " + params[1] );

                    byte[] outputInBytes = params[1].getBytes("UTF-8");
                    OutputStream os = conn.getOutputStream();
                    os.write( outputInBytes );
                    os.flush();
                    os.close();

                    Log.d("Ray","result_url2 : " + params[1].getBytes("UTF-8") );

                    int retCode = conn.getResponseCode();

                    check = retCode;
                    Log.d("Ray","result1 : "+retCode);

                    InputStream is = conn.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while((line = br.readLine()) != null) {
                        response.append(line);
                        response.append('\r');
                    }
                    br.close();

                    String res = response.toString();

                    Log.d("Ray","result 2 : "+res);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }
        }

        try {
            JSONObject jsonObject = new JSONObject();

            try {

                Log.d("Url","2");
                jsonObject.put(LT_TAG, latitude);
                jsonObject.put(LG_TAG, longitude);
                jsonObject.put(mark_name_TAG, name);

                mark_option1_TAG = "agency";
                mark_option2_TAG = "locked";

                jsonObject.put(mark_option1_TAG, op1);
                jsonObject.put(mark_option2_TAG, op2);
                Log.d("Url","5");

                Log.d("Url","3");
                if(type == 1) {
                    mark_option1_TAG = "disabled";
                    mark_option2_TAG = "unisex";

                    jsonObject.put(mark_option1_TAG, op1);
                    jsonObject.put(mark_option2_TAG, op2);
                    Log.d("Url","4");
                } else if(type == 2) {
                    mark_option1_TAG = "agency";
                    mark_option2_TAG = "locked";

                    jsonObject.put(mark_option1_TAG, op1);
                    jsonObject.put(mark_option2_TAG, op2);
                    Log.d("Url","5");
                } else if(type == 3) {
                    mark_option1_TAG = "ashytray";
                    mark_option2_TAG = "booth";

                    jsonObject.put(mark_option1_TAG, op1);
                    jsonObject.put(mark_option2_TAG, op2);
                    Log.d("Url","6");
                } else if(type == 4) {
                    mark_option1_TAG = "explanation";

                    jsonObject.put(mark_option1_TAG, op1);
                    Log.d("Url","7");
                }

                Log.d("Url","4");
                jsonObject.put(mark_image_TAG,file);
                Log.d("Url","5");

            }catch (JSONException e){

            }

            String json = jsonObject.toString();

            new HttpUtil().execute(url,json);
            Log.d("Url","10");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //send LT,LG,CT for getting gpa
    public String sendData4(String url, int id){

        String rt;

        class HttpUtil extends AsyncTask<String, Void, Void> {

            String res = " ";
            int rcode = -1;

            public String get_result() {
                return res;
            }

            @Override
            public Void doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;

                try {

                    URL url = new URL(uri);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setConnectTimeout(2000);
                    conn.setReadTimeout(2000);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setRequestProperty("Content-Type","application/json");

                    byte[] outputInBytes = params[1].getBytes("UTF-8");
                    OutputStream os = conn.getOutputStream();
                    os.write( outputInBytes );
                    os.close();

                    int retCode = conn.getResponseCode();

                    check = retCode;

                    Log.d("Ray","result1 : "+retCode);

                    InputStream is = conn.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while((line = br.readLine()) != null) {
                        response.append(line);
                        response.append('\r');
                    }
                    br.close();

                    res = response.toString();

                    Log.d("Ray","result 2 : "+res);

                    rcode = retCode;

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }
        }

        HttpUtil util = new HttpUtil();

        try {
            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put(ID_TAG, id);
            }catch (JSONException e){

            }

            String json = jsonObject.toString();

            util.execute(url,json);

            while(util.rcode == -1) {
                ;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return util.get_result();
    }

    //send information about users for sign up
    public void sendData5(String url, String name, String id, String pw, String mail, String birth, String gender, String phone){

        class HttpUtil extends AsyncTask<String, Void, Void> {

            @Override
            public Void doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;

                try {

                    URL url = new URL(uri);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setConnectTimeout(2000);
                    conn.setReadTimeout(2000);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setRequestProperty("Content-Type","application/json");

                    Log.d("Ray","result_url : " + params[1] );

                    byte[] outputInBytes = params[1].getBytes("UTF-8");
                    OutputStream os = conn.getOutputStream();
                    os.write( outputInBytes );
                    os.flush();
                    os.close();

                    Log.d("Ray","result_url2 : " + params[1].getBytes("UTF-8") );

                    int retCode = conn.getResponseCode();

                    check = retCode;
                    Log.d("Ray","result1 : "+retCode);

                    InputStream is = conn.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while((line = br.readLine()) != null) {
                        response.append(line);
                        response.append('\r');
                    }
                    br.close();

                    String res = response.toString();

                    Log.d("Ray","result 2 : "+res);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }
        }

        try {
            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put(sign_name_TAG, name);
                jsonObject.put(sign_id_TAG, id);
                jsonObject.put(sign_pw_TAG, pw);
                jsonObject.put(sign_mail_TAG, mail);
                jsonObject.put(sign_birth_TAG, birth);
                jsonObject.put(sign_gender_TAG, gender);
                jsonObject.put(sign_phone_TAG, phone);
            }catch (JSONException e){

            }

            String json = jsonObject.toString();

            new HttpUtil().execute(url,json);
            Log.d("Url","10 : " + json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
