package raydom.use_map;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ChatRoom extends AppCompatActivity {

    ListView listView;
    private String loggedInUserName = "";
    private String room_name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_room);
        //find views by Ids
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        loggedInUserName = getIntent().getStringExtra("user_name");
        room_name = getIntent().getStringExtra("room_name");
        final EditText input = (EditText) findViewById(R.id.input);
        listView = (ListView) findViewById(R.id.list);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().toString().trim().equals("")) {
                    Toast.makeText(ChatRoom.this, "Please enter some texts!", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseDatabase.getInstance()
                            .getReference()
                            .push()
                            .setValue(new ChatMessage(input.getText().toString(),
                                    room_name,
                                    loggedInUserName)
                            );
                    input.setText("");
                }
            }
        });
        showAllOldMessages();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      //  getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_sign_out) {
            AuthUI.getInstance().signOut(this)
                    .addOnCompleteListener(new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            Toast.makeText(MainActivity.this, "You have logged out!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
        }
        return true;
    }*/

    private void showAllOldMessages() {
        Log.d("Main", "user id: " + loggedInUserName);
        MessageAdapter adapter = new MessageAdapter(ChatRoom.this, ChatMessage.class, R.layout.item_in_message, FirebaseDatabase.getInstance().getReference());
        listView.setAdapter(adapter);
    }

    public String getLoggedInUserName() {
        return loggedInUserName;
    }
}
