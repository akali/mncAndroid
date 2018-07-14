package kz.tasbaque.geoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import kz.tasbaque.geoquiz.model.Question;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button trueButton, falseButton;

    private ArrayList<Question> questions = new ArrayList<>();
    private int i = 0;
    private Random rand = new Random(System.nanoTime());
    private Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.questionTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);

        questions.add(new Question("Is Astana the capital of KZ?", true));
        questions.add(new Question("Is Almaty located in China?", false));
        questions.add(new Question("Does Abylay live in Shymkent?", false));

        changeToTheNext();

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onQuestionAnswered(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onQuestionAnswered(false);
            }
        });
    }

    private void onQuestionAnswered(boolean answered) {
        if (answered == question.isAnswer()) {
            Toast.makeText(this, "U r right", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "U wrong", Toast.LENGTH_SHORT).show();
        }
        changeToTheNext();
    }

    private void changeToTheNext() {
        i = rand.nextInt(questions.size());
        question = questions.get(i);
        textView.setText(question.getText());
    }
}
