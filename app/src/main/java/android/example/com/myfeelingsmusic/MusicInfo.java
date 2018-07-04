package android.example.com.myfeelingsmusic;

/**
 * {@link MusicInfo} represents the info about a music of selected category.
 * It contains a title, artist who performed and the album related to the song.
 */
public class MusicInfo {

    /** Title of the music */
    private String mSongTitle;

    /** Artist who performed the music */
    private String mArtistName;

    /** Album related to the music */
    private String mAlbumName;

    private int mImageResourceId;

    /**
     * Create a new MusicInfo object.
     *
     * @param songTitle is the title of the music
     * @param artistName is the artist who performed the song
     * @param albumName is the title of the album related to music
     */
    public MusicInfo(String songTitle, String artistName, String albumName, int imageResourceId) {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mAlbumName = albumName;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the song title of music info
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the artist
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the album
     */
    public String getAlbumName() {
        return mAlbumName;
    }

    /**
     * Get the album cover image
     */
    public int getImageResourceId(){return mImageResourceId;}


}
