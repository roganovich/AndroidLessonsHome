package roganovich.androidlessons;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main extends AppCompatActivity{

    static  String LOGIN = "1";
    static  String PASSWORD = "1";

    Button btnLogin;
    Button btnClear;
    EditText txtLogin;
    EditText txtPassword;
    TextView txtAuth;

    ImageView imgClose;
    ImageView imgOpen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtAuth = (TextView) findViewById(R.id.txtAuth);

        imgClose = (ImageView) findViewById(R.id.imgClose);
        imgOpen = (ImageView) findViewById(R.id.imgOpen);
        imgOpen.setVisibility(View.VISIBLE);
        imgOpen.setVisibility(View.INVISIBLE);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = txtLogin.getText().toString();
                String password = txtPassword.getText().toString();
                System.out.println(login + " == " + LOGIN);
                System.out.println(password + " == " + PASSWORD);

                if(login.equals(LOGIN) && password.equals(PASSWORD)) {// && String.valueOf(password) == String.valueOf(PASSWORD)
                    txtAuth.setText("Успешно");
                    imgClose.setVisibility(View.INVISIBLE);
                    imgOpen.setVisibility(View.VISIBLE);
                }else{
                    txtAuth.setText("ОШИБКА");
                    imgClose.setVisibility(View.VISIBLE);
                    imgOpen.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtLogin.setText("");
                txtPassword.setText("");
                txtAuth.setText("");

                imgClose.setVisibility(View.VISIBLE);
                imgOpen.setVisibility(View.INVISIBLE);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
