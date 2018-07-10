package android.example.com.myfeelingsmusic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HappyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // Set the top bar message and color according to the selected category
        TextView topBarMessage = findViewById(R.id.header_category);
        topBarMessage.setText(getResources().getString(R.string.happy_topbar));
        topBarMessage.setBackgroundResource(R.drawable.rect_happy_topbar);
        topBarMessage.setTextColor(getResources().getColor(R.color.mainTextColor));

        Button buttonBottom = findViewById(R.id.playing_now_button);
        buttonBottom.setText(getResources().getString(R.string.play_now));
        buttonBottom.setBackgroundResource(R.drawable.rect_happy_topbar);
        buttonBottom.setTextColor(getResources().getColor(R.color.mainTextColor));

        // Create a list of words
        final ArrayList<MusicInfo> musicInfo = new ArrayList<>();
        musicInfo.add(new MusicInfo("You Make My Dreams", "Daryl Hall & John Oates", "Voices", R.drawable.voicealbum_happy));
        musicInfo.add(new MusicInfo("Get Down on It", "Kool & the Gang", "Something Special", R.drawable.something_special));
        musicInfo.add(new MusicInfo("Here Comes the Sun", "The Beatles", "Abbey Road", R.drawable.abbeyroad));
        musicInfo.add(new MusicInfo("Treasure", "Bruno Mars", "Unorthodox Jukebox", R.drawable.unorthodoxjukebox));
        musicInfo.add(new MusicInfo("Sugar", "Maroon 5", "V", R.drawable.marron5_v));
        musicInfo.add(new MusicInfo("Get Lucky", "Daft Punk", "Random Access Memories", R.drawable.ram));
        musicInfo.add(new MusicInfo("Rude", "MAGIC!", "Don't Kill the Magic", R.drawable.dontkill_magic));
        musicInfo.add(new MusicInfo("GANGNAM STYLE", "PSY", "GANGNAM STYLE", R.drawable.psy_gangnam));
        musicInfo.add(new MusicInfo("Party Rock Anthem", "LMFAO", "Sorry for Party Rocking", R.drawable.sorry_partyrock));
        musicInfo.add(new MusicInfo("Happy", "Pharrell Williams", "Happy", R.drawable.happy_ph));

        /** Create an {@link MusicInfoAdapter}, whose data source is a list of {@link musicInfo}
         *  The adapter knows how to create list items for each item in the list.) */
        MusicInfoAdapter adapter = new MusicInfoAdapter(this, musicInfo);

        /** Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
         * There should be a {@link ListView} with the view ID called list, which is declared in the music_list file. */
        final ListView listView = findViewById(R.id.music_list);

        /** Make the {@link ListView} use the {@link MusicInfoAdapter} we created above, so that the
         * {@link ListView} will display list items for each {@link MusicInfo} in the list. */
        listView.setAdapter(adapter);

        /** When a item of the {@link ListView} is clicked, the information of the selected {@link MusicInfo} object
         * is saved in some variables and passed to {@link ReproduceActivity} */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MusicInfo currentMusic = musicInfo.get(position);
                String songTitle = currentMusic.getSongTitle();
                String artistName = currentMusic.getArtistName();
                String albumName = currentMusic.getAlbumName();
                String listening_message = getResources().getString(R.string.listening_message);
                int imageId = currentMusic.getImageResourceId();

                // Show a toast when a music from ListView is clicked
                Toast.makeText(HappyActivity.this, listening_message + " " + songTitle + " – " + artistName,
                        Toast.LENGTH_LONG).show();

                Intent nextActivity = new Intent(HappyActivity.this, ReproduceActivity.class);
                nextActivity.putExtra("songTitle", songTitle);
                nextActivity.putExtra("artistName", artistName);
                nextActivity.putExtra("albumName", albumName);
                nextActivity.putExtra("albumID", imageId);
                nextActivity.putExtra("position", position);
                nextActivity.putExtra("last_activity", "happy");
                startActivity(nextActivity);
            }
        });

        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(HappyActivity.this, ReproduceActivity.class);
                nextActivity.putExtra("last_activity", "happy");
                startActivity(nextActivity);
            }
        });

    }

}
