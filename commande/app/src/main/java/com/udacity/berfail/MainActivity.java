package com.udacity.berfail;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        int a=0;
        TextView quantityTextView = (TextView) findViewById(R.id.dollars);
        a=this.num * 10;
        quantityTextView.setText(""+a+"$");

    }
    public void submitPlus(View view) {
        display(1);
    }
    public void submitMinus(View view) {
        display(0);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        if(number==1){
            TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
            this.num+=1;
            quantityTextView.setText("" + this.num);
        }
        else if(number==0){
            TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
            if(this.num>0){
            this.num-=1;
            quantityTextView.setText("" + this.num);}
        }
    }
}
