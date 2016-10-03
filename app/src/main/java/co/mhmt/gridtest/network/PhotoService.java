package co.mhmt.gridtest.network;

import java.util.List;

import co.mhmt.gridtest.domain.Photo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhotoService {

  @GET("photos") Call<List<Photo>> fetchPhotosOfAlbum(@Query("albumId") int albumId);

}