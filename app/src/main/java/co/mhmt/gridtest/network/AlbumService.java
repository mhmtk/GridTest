package co.mhmt.gridtest.network;

import java.util.List;

import co.mhmt.gridtest.domain.Album;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumService {


  @GET("albums") Call<List<Album>> fetchAlbums();

}
