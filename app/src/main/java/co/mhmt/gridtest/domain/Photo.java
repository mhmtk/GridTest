package co.mhmt.gridtest.domain;

import android.support.annotation.NonNull;

public class Photo {

  @NonNull
  private int id;
  private int albumId;
  private String title;
  private String url;
  private String thumbnailUrl;

  public Photo() {
    // no-op
  }

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public int getAlbumId() {
    return albumId;
  }

  public void setAlbumId(final int albumId) {
    this.albumId = albumId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(final String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }
}
