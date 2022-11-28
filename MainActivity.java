package com.example.liftclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int score = 0;
    private int factor = 1;
    private int money = 0;
    private boolean push1 = true;
    private boolean screen1 = true;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long startTime;
    private long mTimeLeftInMillis;
    private boolean bench2 = true;
    private int maxReps = 0;
    private int benchMax = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Equipment dips = new Equipment("Dips", 5,1,0);
        Equipment barbellBench = new Equipment("Barbell Bench", 10,2,0);
        Equipment inclineBench = new Equipment("Incline Bench", 50,10,0);
        Equipment pecFly = new Equipment("PecFly", 100,20,0);
        Button repButton = findViewById(R.id.repButton);
        Button inclineButton = findViewById(R.id.inclineButton);
        TextView inclineShopText = findViewById(R.id.inclineShopText);
        ImageView inclineShopView = findViewById(R.id.inclineShopView);
        Button equipmentButton = findViewById(R.id.equipmentButton);
        Button homeButton = findViewById(R.id.homeButton);
        TextView scoreView = findViewById(R.id.scoreView);
        TextView moneyView = findViewById(R.id.moneyView);
        TextView gainView = findViewById(R.id.gainView);
        TextView chestShopText = findViewById(R.id.chestShopText);
        ImageView pushView = findViewById(R.id.pushView);
        Button dipButton = findViewById(R.id.dipButton);
        ImageView dipImageVIew = findViewById(R.id.dipView);
        TextView dipText = findViewById(R.id.dipText);
        ImageView dipShopView = findViewById(R.id.dipShopView);
        TextView dipShopText = findViewById(R.id.dipShopText);
        TextView benchShopText = findViewById(R.id.benchShopText);
        TextView pecShopText = findViewById(R.id.pecShopText);
        Button benchButton = findViewById(R.id.benchButton);
        Button pecButton = findViewById(R.id.pecButton);
        ImageView benchShopView = findViewById(R.id.benchShopView);
        ImageView pecShopView = findViewById(R.id.pecShopView);
        ImageView pecView = findViewById(R.id.pecView);
        ImageView inclineView = findViewById(R.id.inclineView);
        ImageView benchView = findViewById(R.id.benchView);
        TextView pecText = findViewById(R.id.pecText);
        TextView inclineText = findViewById(R.id.inclineText);
        TextView benchText = findViewById(R.id.benchText);
        Button maxScreen = findViewById(R.id.maxScreen);
        Button startButton = findViewById(R.id.startButton);
        TextView timerText = findViewById(R.id.timerText);
        Button maxRepButton = findViewById(R.id.maxRepButton);
        ImageView benchMaxView = findViewById(R.id.benchMaxView);
        TextView maxRepCounter  = findViewById(R.id.maxRepCounter);
        TextView maxText = findViewById(R.id.maxText);




        repButton.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             score+=factor;
                                             money += factor;
                                             scoreView.setText("Score: " + score);
                                             moneyView.setText("Money: " + money);
                                             if(push1){
                                                 pushView.setImageResource(R.drawable.pushup2);
                                                 push1 = false;
                                             }else {
                                                 pushView.setImageResource(R.drawable.pushup1);
                                                 push1 = true;

                                             }
                                         }
                                     }


        );

        equipmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushView.setVisibility(View.GONE);
                repButton.setVisibility(View.GONE);
                homeButton.setClickable(true);
                equipmentButton.setClickable(false);
                maxScreen.setClickable(true);
                dipShopText.setVisibility(View.VISIBLE);
                dipShopView.setVisibility(View.VISIBLE);
                dipButton.setVisibility(View.VISIBLE);
                chestShopText.setVisibility(View.VISIBLE);
                inclineShopText.setVisibility(View.VISIBLE);
                inclineButton.setVisibility(View.VISIBLE);
                inclineShopView.setVisibility(View.VISIBLE);
                pecButton.setVisibility(View.VISIBLE);
                pecShopText.setVisibility(View.VISIBLE);
                pecShopView.setVisibility(View.VISIBLE);
                benchShopText.setVisibility(View.VISIBLE);
                benchShopView.setVisibility(View.VISIBLE);
                benchButton.setVisibility(View.VISIBLE);
                dipImageVIew.setVisibility(View.GONE);
                dipText.setVisibility(View.GONE);
                benchView.setVisibility(View.GONE);
                benchText.setVisibility(View.GONE);
                inclineView.setVisibility(View.GONE);
                inclineText.setVisibility(View.GONE);
                pecView.setVisibility(View.GONE);
                pecText.setVisibility(View.GONE);
                timerText.setVisibility(View.GONE);
                startButton.setVisibility(View.GONE);
                maxRepButton.setVisibility(View.GONE);
                benchMaxView.setVisibility(View.GONE);
                maxRepButton.setVisibility(View.GONE);
                maxRepCounter.setVisibility(View.GONE);


            }
        });
        dipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickEquip(dips,moneyView,gainView,dipText);
            }
        });

        inclineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickEquip(inclineBench,moneyView,gainView,inclineText);
            }
        });
        benchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickEquip(barbellBench,moneyView,gainView,benchText);
            }
        });
        pecButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickEquip(pecFly,moneyView,gainView,pecText);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushView.setVisibility(View.VISIBLE);
                repButton.setVisibility(View.VISIBLE);
                homeButton.setClickable(false);
                equipmentButton.setClickable(true);
                maxScreen.setClickable(true);
                dipShopText.setVisibility(View.GONE);
                dipShopView.setVisibility(View.GONE);
                dipButton.setVisibility(View.GONE);
                chestShopText.setVisibility(View.GONE);
                inclineShopText.setVisibility(View.GONE);
                inclineButton.setVisibility(View.GONE);
                inclineShopView.setVisibility(View.GONE);
                pecButton.setVisibility(View.GONE);
                pecShopText.setVisibility(View.GONE);
                pecShopView.setVisibility(View.GONE);
                benchShopText.setVisibility(View.GONE);
                benchShopView.setVisibility(View.GONE);
                benchButton.setVisibility(View.GONE);
                benchMaxView.setVisibility(View.GONE);
                maxRepButton.setVisibility(View.GONE);
                maxRepCounter.setVisibility(View.GONE);


                if(dips.getAmount()>0){
                    dipImageVIew.setVisibility(View.VISIBLE);
                    dipText.setVisibility(View.VISIBLE);
                }
                if(barbellBench.getAmount()>0) {
                    benchView.setVisibility(View.VISIBLE);
                    benchText.setVisibility(View.VISIBLE);
                }
                if(inclineBench.getAmount()>0) {
                    inclineView.setVisibility(View.VISIBLE);
                    inclineText.setVisibility(View.VISIBLE);
                }
                if(pecFly.getAmount()>0) {
                    pecView.setVisibility(View.VISIBLE);
                    pecText.setVisibility(View.VISIBLE);
                }
                timerText.setVisibility(View.GONE);
                startButton.setVisibility(View.GONE);
                maxRepButton.setVisibility(View.GONE);
            }
        });

        maxScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushView.setVisibility(View.GONE);
                repButton.setVisibility(View.GONE);
                homeButton.setClickable(true);
                equipmentButton.setClickable(true);
                maxScreen.setClickable(false);
                dipShopText.setVisibility(View.GONE);
                dipShopView.setVisibility(View.GONE);
                dipButton.setVisibility(View.GONE);
                chestShopText.setVisibility(View.GONE);
                inclineShopText.setVisibility(View.GONE);
                inclineButton.setVisibility(View.GONE);
                inclineShopView.setVisibility(View.GONE);
                pecButton.setVisibility(View.GONE);
                pecShopText.setVisibility(View.GONE);
                pecShopView.setVisibility(View.GONE);
                benchShopText.setVisibility(View.GONE);
                benchShopView.setVisibility(View.GONE);
                benchButton.setVisibility(View.GONE);
                maxRepButton.setVisibility(View.VISIBLE);
                maxRepCounter.setText("Do as many reps as you can!");
                maxRepCounter.setVisibility(View.VISIBLE);

                    dipImageVIew.setVisibility(View.GONE);
                    dipText.setVisibility(View.GONE);


                    benchView.setVisibility(View.GONE);
                    benchText.setVisibility(View.GONE);


                    inclineView.setVisibility(View.GONE);
                    inclineText.setVisibility(View.GONE);


                    pecView.setVisibility(View.GONE);
                    pecText.setVisibility(View.GONE);
                    timerText.setVisibility(View.VISIBLE);
                    startButton.setVisibility(View.VISIBLE);
                maxRepButton.setVisibility(View.VISIBLE);
                benchMaxView.setVisibility(View.VISIBLE);

                    resetTimer(timerText);
                    updateCountDownText(timerText);

            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimerRunning){

                }else{
                    startTimer(timerText,maxText,maxRepCounter);
                }
            }
        });
        maxRepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTimerRunning) {
                    if (bench2) {
                        benchMaxView.setImageResource(R.drawable.inclinebench);
                        bench2 = false;
                    } else {
                        benchMaxView.setImageResource(R.drawable.bench2);
                        bench2 = true;

                    }
                    maxReps ++;
                    maxRepCounter.setText("Reps: " + maxReps);                }
            }
        });



    }

    public void clickEquip(Equipment temp, TextView m, TextView g,TextView mine){
        if(money>temp.getCost()){
            money = money- temp.getCost();
            temp.addAmount();
            factor += temp.getScore();
            m.setText("Money: " + money);
            g.setText("Gains Factor: " + factor);
            mine.setText("x"+temp.getAmount());
            startTime = factor *1000;
            mTimeLeftInMillis = startTime;


        }
    }

    private void startTimer(TextView t,TextView m, TextView r){
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillis = l;
                updateCountDownText(t);
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                checkMax(m,r);
            }
        }.start();

        mTimerRunning = true;
    }

    private void resetTimer(TextView t){
        mTimeLeftInMillis = startTime;
        maxReps = 0;
        updateCountDownText(t);
    }

    private void updateCountDownText(TextView t){
        int minutes = (int) mTimeLeftInMillis/ 1000/ 60;
        int seconds = (int) mTimeLeftInMillis/ 1000% 60;
        String timeLeft = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        t.setText(timeLeft);
    }

    private void checkMax(TextView m, TextView r){
        if(maxReps>benchMax){
            m.setText("Max: " + maxReps);
            benchMax = maxReps;
            r.setText("Congrats you earned a new max!");
        }
    }


}