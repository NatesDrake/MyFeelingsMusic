package android.example.com.myfeelingsmusic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * {@link MusicInfoAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link MusicInfo} objects.
 * */
public class MusicInfoAdapter extends ArrayAdapter<MusicInfo> {

    private static final String LOG_TAG = MusicInfoAdapter.class.getSimpleName();

    /**
     * @param context The current context. Used to inflate the layout file.
     * @param showMusic A List of MusicInfo objects to display in a list
     */
    public MusicInfoAdapter(Activity context, ArrayList<MusicInfo> showMusic) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, showMusic);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.musicinfo_item, parent, false);
        }

        // Get the {@link MusicInfo} object located at this position in the list
        MusicInfo currentMusicInfo = getItem(position);

        // Find the TextView in the musicinfo_item.xml layout with the ID song_name_text_view
        TextView songTitleTextView = (TextView) listItemView.findViewById(R.id.song_name_text_view);
        // Get the song title from the current MusicInfo object and
        // set this text on the name TextView
        songTitleTextView.setText(currentMusicInfo.getSongTitle());

        // Find the TextView in the musicinfo_item.xml layout with the ID artist_text_view
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the artist name from the current MusicInfo object and
        // set this text on the name TextView
        artistTextView.setText(currentMusicInfo.getArtistName());

        // Find the TextView in the musicinfo_item.xml layout with the ID album_text_view
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.album_text_view);
        // Get the album name from the current MusicInfo object and
        // set this text on the name TextView
        albumTextView.setText(currentMusicInfo.getAlbumName());

        // Find the ImageView in the musicinfo_item.xml layout with the ID album_cover_image
        ImageView albumCoverView = (ImageView) listItemView.findViewById(R.id.album_cover_image);
        // Get the image resource ID from the current MusicInfo object and
        // set the image to albumView
        albumCoverView.setImageResource(currentMusicInfo.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}