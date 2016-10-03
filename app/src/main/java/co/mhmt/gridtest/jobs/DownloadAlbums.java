package co.mhmt.gridtest.jobs;


import android.os.AsyncTask;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

import co.mhmt.gridtest.domain.Album;
import co.mhmt.gridtest.events.AlbumsDownloaded;
import co.mhmt.gridtest.network.AlbumService;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DownloadAlbums extends AsyncTask<Retrofit, Integer, List<Album>> {

  @Override protected List<Album> doInBackground(final Retrofit... params) {
    final Response<List<Album>> albumResponse;
    try {
      albumResponse = params[0].create(AlbumService.class).fetchAlbums().execute();
      if (albumResponse.isSuccessful()) {
        return albumResponse.body();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  protected void onPostExecute(List<Album> albums) {
    EventBus.getDefault().postSticky(new AlbumsDownloaded(albums));
  }
}
