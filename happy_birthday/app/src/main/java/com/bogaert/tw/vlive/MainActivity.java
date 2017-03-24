package com.bogaert.tw.vlive;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int num=0;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //ImageView iv = (ImageView)findViewById(R.id.v);
        //iv.setImageResource(R.drawable.android_udacity);
        setContentView(R.layout.activity_main);
        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=MediaPlayer.create(MainActivity.this,R.raw.birthday);

                //player.start();
                if(player.isPlaying()){
                    player.pause();

                } else {
                    player.start();
                    player.pause();
                }

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display();
    }

    /**
     * This method displays the given quantity value on the screen.
     */

    private void display() {
        TextView quantityTextView = (TextView) findViewById(R.id.berfy);
        this.num+=1;
        quantityTextView.setText("" + this.num);
    }
}

