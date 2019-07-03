package com.example.tic_tac_toe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView player;
    boolean flag =true;
    ImageView position[] = new ImageView[9];

    public void flip(View v){

         player = (ImageView) v;

         position[0]= findViewById(R.id.image11);
        position[1]= findViewById(R.id.image12);
        position[2]= findViewById(R.id.image13);
        position[3]= findViewById(R.id.image21);
        position[4]= findViewById(R.id.image22);
        position[5]= findViewById(R.id.image23);
        position[6]= findViewById(R.id.image31);
        position[7]= findViewById(R.id.image32);
        position[8]= findViewById(R.id.image33);


        while(player.getDrawable() == null) {

            player.animate().alpha(0).setDuration(500);

            if (flag) {
                player.setImageResource(R.drawable.blue);
                flag = false;
            }
            else {
                player.setImageResource(R.drawable.red);
                flag = true;
            }

            player.animate().alpha(1).rotationBy(180f).setDuration(500);
        }

            //winning check:

               // if (position[0]..toString() == position[1].getResources().toString() && position[0].getResources().toString()==position[2].getResources().toString())
                 //   Toast.makeText(this,player.getResources().toString() ,Toast.LENGTH_SHORT).show();


    }

    public void Reset(View v){

        for (int i=0;i<9;i++) {
            position[i].animate().alpha(0).translationX(-180f).setDuration(500);
            position[i].setImageDrawable(null);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
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
