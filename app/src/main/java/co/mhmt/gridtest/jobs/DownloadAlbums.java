package co.mhmt.gridtest.jobs;


import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

import co.mhmt.gridtest.Constant;
import co.mhmt.gridtest.domain.Album;
import co.mhmt.gridtest.events.AlbumsDownloaded;
import co.mhmt.gridtest.network.AlbumService;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class DownloadAlbums extends AsyncTask<Void, Integer, List<Album>> {

  @Override protected List<Album> doInBackground(final Void... params) {
    final Response<List<Album>> albumResponse;
    try {
      final Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL)
                                                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()))
                                                .build();
      albumResponse = retrofit.create(AlbumService.class).fetchAlbums().execute();
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
