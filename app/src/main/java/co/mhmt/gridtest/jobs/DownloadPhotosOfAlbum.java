package co.mhmt.gridtest.jobs;


import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

import co.mhmt.gridtest.Constant;
import co.mhmt.gridtest.domain.Photo;
import co.mhmt.gridtest.events.PhotosDownloaded;
import co.mhmt.gridtest.network.PhotoService;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class DownloadPhotosOfAlbum extends AsyncTask<Integer, Integer, List<Photo>> {

  @Override protected List<Photo> doInBackground(final Integer... params) {
    final Response<List<Photo>> photoResponse;
    try {
      final Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL)
                                       .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()))
                                       .build();
      photoResponse = retrofit.create(PhotoService.class).fetchPhotosOfAlbum(params[0]).execute();
      if (photoResponse.isSuccessful()) {
        return photoResponse.body();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  protected void onPostExecute(List<Photo> photos) {
    EventBus.getDefault().postSticky(new PhotosDownloaded(photos));
  }
}
