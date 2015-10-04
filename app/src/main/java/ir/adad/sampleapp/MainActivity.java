package ir.adad.sampleapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import ir.adad.client.AdListener;
import ir.adad.client.AdView;
import ir.adad.client.Adad;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preInitializeAdad();
        Adad.initialize(getApplicationContext());


        setContentView(R.layout.activity_main);

        findViewById(R.id.button_start_game).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });

        ((AdView) findViewById(R.id.banner_ad_view)).setAdListener(mAdListener);
    }

    private void preInitializeAdad() {
        try {
            JSONObject json = new JSONObject();
            json.put("PublicRelease", false);
            Adad.executeCommand(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private AdListener mAdListener = new BaseAdListener() {

        @Override
        public void onAdLoaded() {
            Toast.makeText(getApplicationContext(),"Ad loaded", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onAdFailedToLoad() {
            Toast.makeText(getApplicationContext(),"Banner ad failed to load", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onMessageReceive(JSONObject message) {

        }

        @Override
        public void onRemoveAdsRequested() {
            Toast.makeText(getApplicationContext(),"User requested to remove ads from app", Toast.LENGTH_LONG).show();
            //Move your user to shopping center of your app
        }


    };
}
