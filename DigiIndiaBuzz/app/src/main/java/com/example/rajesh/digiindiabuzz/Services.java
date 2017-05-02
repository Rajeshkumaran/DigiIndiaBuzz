package com.example.rajesh.digiindiabuzz;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Services extends AppCompatActivity {
Animation animation1,animation2;
    LinearLayout l1,l2,l3,l4,l5,l6;
    ImageView img1,img2,img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        this.setTitle("                       Services");

        animation1= AnimationUtils.loadAnimation(this,R.anim.zoomin);
        animation2=AnimationUtils.loadAnimation(this,R.anim.zoomout);
        img1=(ImageView)findViewById(R.id.androidapp);
        l1=(LinearLayout)findViewById(R.id.branding);
        l2=(LinearLayout)findViewById(R.id.website);
        l3=(LinearLayout)findViewById(R.id.i3);
        l4=(LinearLayout)findViewById(R.id.l4);
        l5=(LinearLayout)findViewById(R.id.l5);
        l6=(LinearLayout)findViewById(R.id.ecommerce);

        //  img2=(ImageView)findViewById(R.id.webapp);
       // img3=(ImageView)findViewById(R.id.cms);
        final ObjectAnimator animStage1 = (ObjectAnimator) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip1);
        final ObjectAnimator animStage2 = (ObjectAnimator) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip2);

        animStage1.setTarget(l1);
        animStage1.setDuration(2000);
        animStage2.setTarget(l1);
        animStage2.setDuration(2000);
        animStage1.start();
        animStage1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                animStage2.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                animStage1.setTarget(l2);
                animStage1.setDuration(2000);
                animStage2.setTarget(l2);
                animStage2.setDuration(2000);
                animStage1.start();
                animStage1.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                        animStage2.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        }.start();

        new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                animStage1.setTarget(l3);
                animStage1.setDuration(2000);
                animStage2.setTarget(l3);
                animStage2.setDuration(2000);
                animStage1.start();
                animStage1.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                        animStage2.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        }.start();

        new CountDownTimer(17000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                animStage1.setTarget(l4);
                animStage1.setDuration(2000);
                animStage2.setTarget(l4);
                animStage2.setDuration(2000);
                animStage1.start();
                animStage1.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                        animStage2.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        }.start();

        new CountDownTimer(23000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                animStage1.setTarget(l5);
                animStage1.setDuration(2000);
                animStage2.setTarget(l5);
                animStage2.setDuration(2000);
                animStage1.start();
                animStage1.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                        animStage2.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        }.start();


        new CountDownTimer(29000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                animStage1.setTarget(l6);
                animStage1.setDuration(2000);
                animStage2.setTarget(l6);
                animStage2.setDuration(2000);
                animStage1.start();
                animStage1.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                        animStage2.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        }.start();




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(Services.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
