package com.berfail.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*attribut*/
    private int score=0;
    private int score2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayA(3);
            }
        });

        Button b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayA(2);
            }
        });

        Button teamb1=(Button)findViewById(R.id.button1b);
        teamb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayB(1);
            }
        });



    }
    public void addOneScore(View v){
        this.displayA(1);
    }


    public void displayA(int a){

        TextView text=(TextView)findViewById(R.id.points);

        this.score+=a;
        text.setText(""+this.score);

    }
    public void displayB(int a){

        TextView text=(TextView)findViewById(R.id.pointsb);

        this.score2+=a;
        text.setText(""+this.score2);

    }

    public void addTwoScoreB(View v){
        this.displayB(2);
    }

    public void addThreeScoreB(View v){
        this.displayB(3);
    }

    public void Reset(View v){
        this.score=0;
        this.score2=0;
        this.displayB(this.score);
        this.displayA(this.score2);
    }
}
