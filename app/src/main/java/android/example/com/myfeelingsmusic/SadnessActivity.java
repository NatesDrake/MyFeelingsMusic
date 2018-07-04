package android.example.com.myfeelingsmusic;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class SadnessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // Set the top bar message and color according to the selected category
        TextView topBarMessage = findViewById(R.id.header_category);
        topBarMessage.setText(getResources().getString(R.string.sad_topbar));
        topBarMessage.setBackgroundResource(R.drawable.rect_sad_topbar);

        // Create a list of words
        final ArrayList<MusicInfo> musicInfo = new ArrayList<>();
        musicInfo.add(new MusicInfo("If You Leave Me Now", "Chicago", "Chicago X", R.drawable.chicagox));
        musicInfo.add(new MusicInfo("(They Long To Be) Close To You", "Carpenters", "Close to You", R.drawable.closeyou));
        musicInfo.add(new MusicInfo("Someone Like You", "Adele", "21", R.drawable.adele21));
        musicInfo.add(new MusicInfo("Last Kiss", "Pearl Jam", "Last Kiss", R.drawable.lastkiss));
        musicInfo.add(new MusicInfo("Yesterday", "The Beatles", "Help!", R.drawable.helpbeatles));
        musicInfo.add(new MusicInfo("See You Again", "Wiz Khalifa", "Furious 7", R.drawable.furious7));
        musicInfo.add(new MusicInfo("Tears In Heaven", "Eric Clapton", "Rush", R.drawable.rusheric));
        musicInfo.add(new MusicInfo("Wish You Were Here", "Pink Floyd", "Wish You Were Here", R.drawable.pinkfloyd));
        musicInfo.add(new MusicInfo("With or Without You", "U2", "The Joshua Tree", R.drawable.withu2));
        musicInfo.add(new MusicInfo("Hallelujah", "Leonard Cohen", "Various Positions", R.drawable.variouspositions));

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
                Toast.makeText(SadnessActivity.this, listening_message + " " + songTitle + " – " + artistName,
                        Toast.LENGTH_LONG).show();

                Intent nextActivity = new Intent(SadnessActivity.this, ReproduceActivity.class);
                nextActivity.putExtra("songTitle", songTitle);
                nextActivity.putExtra("artistName", artistName);
                nextActivity.putExtra("albumName", albumName);
                nextActivity.putExtra("albumID", imageId);
                nextActivity.putExtra("position", position);
                nextActivity.putExtra("last_activity", "sadness");
                startActivity(nextActivity);
            }
        });

    }

}
