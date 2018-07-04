package android.example.com.myfeelingsmusic;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ReproduceActivity extends AppCompatActivity {

    Boolean reproduceStatus = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_control_activity);

        // Find the views in the track_control_activity.xml layout with their respective IDs
        TextView currentMusic = findViewById(R.id.current_title_music);
        TextView currentArtist = findViewById(R.id.current_artist_name);
        TextView currentAlbum = findViewById(R.id.current_album_name);
        ImageView currentAlbumCoverImage = findViewById(R.id.cover_album_current);
        ImageView musicList = findViewById(R.id.list_music_items);
        final ImageView playPauseButton = findViewById(R.id.play_pause_buttom);

        // Find the play and pause icons drawables in resources folder
        final Drawable pauseLines = getResources().getDrawable(R.drawable.music_player_pause_lines);
        final Drawable playImage = getResources().getDrawable(R.drawable.music_player_play);

        // Get the music info from the passed from previous activity, and set all the views with respective values
        Intent intent = getIntent();
        currentMusic.setText(intent.getStringExtra("songTitle"));
        currentArtist.setText(intent.getStringExtra("artistName"));
        currentAlbum.setText(intent.getStringExtra("albumName"));
        currentAlbumCoverImage.setImageResource(intent.getIntExtra("albumID", 0));
        playPauseButton.setImageDrawable(pauseLines);

        // Change the play and pause icons according to the reproducing status
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reproduceStatus) {
                    playPauseButton.setImageDrawable(playImage);
                    reproduceStatus = false;
                } else {
                    playPauseButton.setImageDrawable(pauseLines);
                    reproduceStatus = true;
                }
            }
        });

        // Return to the previous activity to show the music list
        musicList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caller = getIntent().getStringExtra("last_activity");
                if (caller.equals("happy")) {
                    Intent intent = new Intent(ReproduceActivity.this, HappyActivity.class);
                    ReproduceActivity.this.startActivity(intent);
                }
                if (caller.equals("sadness")) {
                    Intent intent = new Intent(ReproduceActivity.this, SadnessActivity.class);
                    ReproduceActivity.this.startActivity(intent);
                }
                if (caller.equals("angry")) {
                    Intent intent = new Intent(ReproduceActivity.this, AngryActivity.class);
                    ReproduceActivity.this.startActivity(intent);
                }
                if (caller.equals("inexpressive")) {
                    Intent intent = new Intent(ReproduceActivity.this, InexpressiveActivity.class);
                    ReproduceActivity.this.startActivity(intent);
                }
            }
        });

    }

}

