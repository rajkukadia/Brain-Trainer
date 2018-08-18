package raj.kukadia.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    int locationOfAnswer;
    int incorrectAns;
    int currentScore;
    TextView timmer;
    TextView comment;
    int totalScore;
    GridLayout gridLayout;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView score;
    ArrayList<Integer>  answers = new ArrayList<>();
    TextView equation;


    public void chooseAnswer(View v){
        if(v.getTag().toString().equals(Integer.toString(locationOfAnswer))){
            setBoard("Correct");
            setScore(1);
        }else{
            setBoard("Wrong");
            setScore(0);

        }

    }

    public void setScore(int i){
        currentScore+=i;
        totalScore++;
        String s = currentScore + "/" + totalScore;
        score.setText(s);
    }



    public void startGame(View v){
        startButton.setVisibility(View.INVISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        startTimer();
        setBoard("Good luck");
    }

    public void startTimer(){
        new CountDownTimer(30100, 1000){

            @Override
            public void onTick(long l) {
                timmer.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                timmer.setText("0s");
                gridLayout.setVisibility(View.INVISIBLE);
                comment.setText("done");
                startButton.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void setBoard(String s){
        comment.setText(s);
        answers.clear();
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        equation.setText(Integer.toString(a) + "+" + Integer.toString(b) );

        locationOfAnswer = rand.nextInt(4);

        for(int i = 0; i<4; i++){
            if(i == locationOfAnswer){
                answers.add(a+b);
            }else{
                incorrectAns = rand.nextInt(41);
                while(incorrectAns == a+b){
                    incorrectAns = rand.nextInt(41);
                }
                answers.add(incorrectAns);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start);
        timmer = findViewById(R.id.timmer);
        score = findViewById(R.id.score);
        equation = findViewById(R.id.equation);
         button0 = findViewById(R.id.button1);
        button1 = findViewById(R.id.button2);
        button2 = findViewById(R.id.button3);
         button3 = findViewById(R.id.button4);
         comment = findViewById(R.id.answer);
        gridLayout = findViewById(R.id.sumTextView);
        currentScore = 0;
        totalScore = 0;
        timmer.setText("00:00");
        score.setText("0/0");

    }

    @Override
    protected void onResume() {
        super.onResume();
        setBoard("Good luck");
        comment.setVisibility(View.VISIBLE);
    }
}
