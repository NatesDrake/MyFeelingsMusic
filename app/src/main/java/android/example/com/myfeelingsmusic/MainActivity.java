package android.example.com.myfeelingsmusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Set a random welcome question to the user in activity_main.xml
        getRandomWelcomeMessage();

        // Find the View that shows the emotions category
        TextView happy = findViewById(R.id.happy);
        TextView sadness = findViewById(R.id.sadness);
        TextView angry = findViewById(R.id.angry);
        TextView inexpressive = findViewById(R.id.inexpressive);

        // Starts HappyActivity when the respective TextView is clicked
        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent happyIntent = new Intent(MainActivity.this, HappyActivity.class);
                startActivity(happyIntent);
            }
        });

        // Starts SadnessActivity when the respective TextView is clicked
        sadness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sadnessIntent = new Intent(MainActivity.this, SadnessActivity.class);
                startActivity(sadnessIntent);
            }
        });

        // Starts AngryActivity when the respective TextView is clicked
        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent angryIntent = new Intent(MainActivity.this, AngryActivity.class);
                startActivity(angryIntent);
            }
        });

        // Starts InexpressiveActivity when the respective TextView is clicked
        inexpressive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inexpressiveIntent = new Intent(MainActivity.this, InexpressiveActivity.class);
                startActivity(inexpressiveIntent);
            }
        });

    }

    private void getRandomWelcomeMessage() {
        int[] strWelcome = {R.string.welcome_text, R.string.welcome_text2, R.string.welcome_text3};
        int randomIndex = new Random().nextInt(3);
        int resId = strWelcome[randomIndex];
        String RandomWelcomeMessage = getString(resId);
        TextView welcomeMessage = findViewById(R.id.welcomeMessage);
        welcomeMessage.setText(RandomWelcomeMessage);
    }
}
