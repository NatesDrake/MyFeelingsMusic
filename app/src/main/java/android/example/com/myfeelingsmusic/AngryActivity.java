package android.example.com.myfeelingsmusic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AngryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // Set the top bar message and color according to the selected category
        TextView topBarMessage = findViewById(R.id.header_category);
        topBarMessage.setText(getResources().getString(R.string.angry_topbar));
        topBarMessage.setBackgroundResource(R.drawable.rect_angry_topbar);

        Button buttonBottom = findViewById(R.id.playing_now_button);
        buttonBottom.setText(getResources().getString(R.string.play_now));
        buttonBottom.setBackgroundResource(R.drawable.rect_angry_topbar);

        // Create a list of words
        final ArrayList<MusicInfo> musicInfo = new ArrayList<>();
        musicInfo.add(new MusicInfo("I Love It", "Icona Pop", "Icona Pop", R.drawable.icona_pop));
        musicInfo.add(new MusicInfo("Free Bird", "Lynyrd Skynyrd", "(Pronounced 'Lĕh-'nérd 'Skin-'nérd)", R.drawable.lynyrd_pronnunced));
        musicInfo.add(new MusicInfo("I Hate Everything About You", "Three Days Grace", "Three Days Grace", R.drawable.threedaysgrace));
        musicInfo.add(new MusicInfo("In The End", "Linkin Park", "Hybrid Theory", R.drawable.link_hybrid));
        musicInfo.add(new MusicInfo("Break Stuff", "Limp Bizkit", "Significant Other", R.drawable.significantother));
        musicInfo.add(new MusicInfo("Look Back In Anger", "David Bowie", "Lodger", R.drawable.lodger));
        musicInfo.add(new MusicInfo("The Kill", "30 Seconds to Mars", "A Beautiful Lie", R.drawable.abeatifullie));
        musicInfo.add(new MusicInfo("Enter Sandman", "Metallica", "Metallica", R.drawable.metallica_black));
        musicInfo.add(new MusicInfo("Complicated", "Avril Lavigne", "Let Go", R.drawable.letgo_arvil));
        musicInfo.add(new MusicInfo("You Make Me Sick", "Pink", "Can't Take Me Home", R.drawable.canthome_pink));

        /** Create an {@link MusicInfoAdapter}, whose data source is a list of {@link musicInfo}
         *  The adapter knows how to create list items for each item in the list.) */
        MusicInfoAdapter adapter = new MusicInfoAdapter(this, musicInfo);

        /** Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
         * There should be a {@link ListView} with the view ID called list, which is declared in the music_list file. */
        ListView listView = (ListView) findViewById(R.id.music_list);

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
                Toast.makeText(AngryActivity.this, listening_message + " " + songTitle + " – " + artistName,
                        Toast.LENGTH_LONG).show();

                Intent nextActivity = new Intent(AngryActivity.this, ReproduceActivity.class);
                nextActivity.putExtra("songTitle", songTitle);
                nextActivity.putExtra("artistName", artistName);
                nextActivity.putExtra("albumName", albumName);
                nextActivity.putExtra("albumID", imageId);
                nextActivity.putExtra("position", position);
                nextActivity.putExtra("last_activity", "angry");
                startActivity(nextActivity);
            }
        });

        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(AngryActivity.this, ReproduceActivity.class);
                nextActivity.putExtra("last_activity", "angry");
                startActivity(nextActivity);
            }
        });

    }

}
