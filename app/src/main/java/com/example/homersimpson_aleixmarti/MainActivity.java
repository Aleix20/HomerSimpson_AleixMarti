package com.example.homersimpson_aleixmarti;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton title,imgDonut;
    ImageView imgVermell,imgVerd,imgBlau,imgUll;
    MediaPlayer media;
    int visible=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        media = MediaPlayer.create(getApplicationContext(), R.raw.the_simpsons);
        //SET ID
        title=findViewById(R.id.imageViewTitle);
        imgVermell=findViewById(R.id.imgVermell);
        imgVerd= findViewById(R.id.imgVerd);
        imgBlau=findViewById(R.id.imgBlau);
        imgUll=findViewById(R.id.imgUll);
        imgDonut=findViewById(R.id.imgDonut);

        //FINAL ID


        //SET VISIBLE
        imgDonut.setVisibility(View.GONE);
        imgVermell.setVisibility(View.GONE);
        imgVerd.setVisibility(View.GONE);
        imgBlau.setVisibility(View.GONE);
        imgUll.setVisibility(View.GONE);
        //FINAL SET VISIBLE


        //ANIMACIO TITOL INFINITA
        AnimationDrawable animTitle = (AnimationDrawable) title.getDrawable();
        animTitle.start();
        //ACABA ANIMACIO TITOL

        imgDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {

                    if (media != null && media.isPlaying())
                    {
                        Toast.makeText(getApplicationContext(), getString(R.string.parar), Toast.LENGTH_SHORT).show();
                        media.stop();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), getString(R.string.iniciar), Toast.LENGTH_SHORT).show();

                        media.start();
                    }
                } catch(Exception e) {
                    Toast.makeText(getApplicationContext(), getString(R.string.error_audio), Toast.LENGTH_SHORT).show();
                }
            }
        });
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ANIMATIONS
                Animation animRedBlue = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.clock_vermell_blau);
                Animation animVerd = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.clock_verd);
                Animation animUll = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.rotation_ull);
                Animation animDonut = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.anim_donut);
                if(visible==0){
                    //VISIBLE
                    imgDonut.setVisibility(View.VISIBLE);
                    imgVermell.setVisibility(View.VISIBLE);
                    imgVerd.setVisibility(View.VISIBLE);
                    imgBlau.setVisibility(View.VISIBLE);
                    imgUll.setVisibility(View.VISIBLE);
                    visible=1;

                    //ANIMATIONS CRATE/ON

                    imgBlau.startAnimation(animRedBlue);
                    imgVermell.startAnimation(animRedBlue);
                    imgVerd.startAnimation(animVerd);
                    imgUll.startAnimation(animUll);
                    imgDonut.setAnimation(animDonut);

                }
                else{

                    //ANIMATIONS OFF

                    //VISIBLE
                    imgDonut.clearAnimation();
                    imgVermell.clearAnimation();
                    imgVerd.clearAnimation();;
                    imgBlau.clearAnimation();
                    imgUll.clearAnimation();
                    imgDonut.setVisibility(View.GONE);
                    imgVermell.setVisibility(View.GONE);
                    imgVerd.setVisibility(View.GONE);
                    imgBlau.setVisibility(View.GONE);
                    imgUll.setVisibility(View.GONE);

                    visible=0;
                    media.stop();


                }
            }
        });



    }
}
