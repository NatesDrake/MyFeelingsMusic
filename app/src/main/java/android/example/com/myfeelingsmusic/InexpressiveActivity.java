package android.example.com.myfeelingsmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class InexpressiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // Set the top bar message and color according to the selected category
        TextView topBarMessage = findViewById(R.id.header_category);
        topBarMessage.setText(getResources().getString(R.string.inexpressive_topbar));
        topBarMessage.setBackgroundResource(R.drawable.rect_inexpressive_topbar);

        Button buttonBottom = findViewById(R.id.playing_now_button);
        buttonBottom.setText(getResources().getString(R.string.play_now));
        buttonBottom.setBackgroundResource(R.drawable.rect_inexpressive_topbar);

        // Create a list of words
        final ArrayList<MusicInfo> musicInfo = new ArrayList<>();
        musicInfo.add(new MusicInfo("Exile Vilify", "The National", "Sleep Well Beast", R.drawable.thenational));
        musicInfo.add(new MusicInfo("I Feel It Coming", "The Weeknd ft. Daft Punk", "Starboy", R.drawable.starboy));
        musicInfo.add(new MusicInfo("Everybody Wants To Rule The World", "Tears For Fears", "Songs from the Big Chair", R.drawable.tearsforfears));
        musicInfo.add(new MusicInfo("Wonderwall", "Oasis", "(What's the Story) Morning Glory?", R.drawable.oasis));
        musicInfo.add(new MusicInfo("Ode To My Family", "The Cranberries", "No Need to Argue", R.drawable.needcranberries));
        musicInfo.add(new MusicInfo("Sultans of Swing", "Dire Straits", "Dire Straits", R.drawable.dire_straits));
        musicInfo.add(new MusicInfo("Eye in the Sky", "Alan Parsons", "Eye in the Sky", R.drawable.eye_sky));
        musicInfo.add(new MusicInfo("Every Breath You Take", "The Police", "Synchronicity", R.drawable.thepolice));
        musicInfo.add(new MusicInfo("I say a little prayer", "Aretha Franklin", "Aretha Now", R.drawable.aretha_now));
        musicInfo.add(new MusicInfo("Budapest", "George Ezra", "Wanted on Voyage", R.drawable.george_ezra));

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
                Toast.makeText(InexpressiveActivity.this, listening_message + " " + songTitle + " – " + artistName,
                        Toast.LENGTH_LONG).show();

                Intent nextActivity = new Intent(InexpressiveActivity.this, ReproduceActivity.class);
                nextActivity.putExtra("songTitle", songTitle);
                nextActivity.putExtra("artistName", artistName);
                nextActivity.putExtra("albumName", albumName);
                nextActivity.putExtra("albumID", imageId);
                nextActivity.putExtra("position", position);
                nextActivity.putExtra("last_activity", "inexpressive");
                startActivity(nextActivity);
            }
        });

        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(InexpressiveActivity.this, ReproduceActivity.class);
                nextActivity.putExtra("last_activity", "inexpressive");
                startActivity(nextActivity);
            }
        });
    }

}
