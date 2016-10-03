package co.mhmt.gridtest.events;

public class AlbumViewHolderClicked {

  private int albumId;

  public AlbumViewHolderClicked(final int albumId) {
    this.albumId = albumId;
  }

  public int getAlbumId() {
    return albumId;
  }
}
