package co.mhmt.gridtest.events;

import java.util.List;

import co.mhmt.gridtest.domain.Album;

public class AlbumsDownloaded {

  private List<Album> albums;

  public AlbumsDownloaded(final List<Album> albums) {

    this.albums = albums;
  }

  public List<Album> getAlbums() {
    return albums;
  }
}
