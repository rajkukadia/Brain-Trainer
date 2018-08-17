package raj.kukadia.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    int locationOfAnswer;
    int incorrectAns;
    ArrayList<Integer>  answers;


    public void chooseAnswer(View v){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start);
        TextView timmer = findViewById(R.id.timmer);
        TextView score = findViewById(R.id.score);
        TextView equation = findViewById(R.id.equation);


        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        equation.setText(Integer.toString(a) + "+" + Integer.toString(b) );

        locationOfAnswer = rand.nextInt(4);
        incorrectAns = rand.nextInt(41);

        for(int i = 0; i<4; i++){
            if(i == locationOfAnswer){
                answers.add(a+b);
            }else{
                while(incorrectAns == a+b){
                    incorrectAns = rand.nextInt(41);
                }
                answers.add(incorrectAns);
            }
        }


    }
}
