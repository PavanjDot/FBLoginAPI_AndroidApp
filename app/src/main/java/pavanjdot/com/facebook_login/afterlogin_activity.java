package pavanjdot.com.facebook_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class afterlogin_activity extends AppCompatActivity {


    private Button mLogoutBtn;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterlogin_activity);

        mLogoutBtn =  findViewById(R.id.mLogoutBtn);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mAuth.signOut();

                LoginManager.getInstance().logOut();
                updateUI();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null){

            updateUI();

        }

    }

    private void updateUI() {

        Toast.makeText(afterlogin_activity.this, "You are Logged Out ", Toast.LENGTH_SHORT).show();

        Intent change_activity = new Intent(afterlogin_activity.this, MainActivity.class );
        startActivity(change_activity);
    }
}
