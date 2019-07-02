package example.projectbaru.angrychicken;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import example.projectbaru.angrychicken.Server.AppVar;
import example.projectbaru.angrychicken.Server.JSONParser;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        sharedPreferences = getSharedPreferences(AppVar.PREF, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String login = sharedPreferences.getString(AppVar.CEK_LOGIN, null);

        if(login!=null){
            if(login.equals("1")){
                Intent i = new Intent(Login.this,InputPesanan.class);
                startActivity(i);
                finish();
            }
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(username.getText().toString(),password.getText().toString());
            }
        });

    }

    public void Login(String mUsername, String mPassword) {
        new LoginAsync().execute(
                AppVar.KEY_Login,
                mUsername,
                mPassword
        );
    }

    class LoginAsync extends AsyncTask<String, String, JSONObject> {
        JSONParser jsonParser = new JSONParser();
        private final String API_URL = AppVar.URL_API;

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected JSONObject doInBackground(String... args) {

            try {

                HashMap<String, String> params = new HashMap<>();
                params.put(AppVar.function, args[0]);
                params.put(AppVar.username, args[1]);
                params.put(AppVar.password, args[2]);
                Log.d("request", "starting");

                JSONObject json = jsonParser.makeHttpRequest(
                        API_URL, "POST", params);

                if (json != null) {
                    Log.d("JSON result", json.toString());
                    return json;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(JSONObject json) {
            if (json != null) {
                try {
                    JSONObject parentObject = new JSONObject(json.toString());
                    JSONObject userDetails = parentObject.getJSONObject("hasil");
                    String success = userDetails.getString("success");
                    if (success.equals("1")) {

                        editor.remove(AppVar.CEK_LOGIN );

                        editor.putString(AppVar.CEK_LOGIN, "1");

                        editor.commit();

                        Intent i = new Intent(Login.this, MainActivity.class);
                        startActivity(i);
                        finish();

                    } else {
                        AlertDialog.Builder noticeLogin = new AlertDialog.Builder(Login.this);
                        noticeLogin.setTitle("Login gagal");
                        noticeLogin.setMessage("\nSilakan periksa kembali Nomor HP dan Password anda.");
                        noticeLogin.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        noticeLogin.create();
                        noticeLogin.show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Login.this, e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        }
    }
    //[Selesai] -----------------------------------------------------------------------------------
}
