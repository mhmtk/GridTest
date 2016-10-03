package co.mhmt.gridtest.events;

import java.util.List;

import co.mhmt.gridtest.domain.Photo;

public class PhotosDownloaded {

  private List<Photo> photos;

  public PhotosDownloaded(final List<Photo> photos) {

    this.photos = photos;
  }

  public List<Photo> getPhotos() {
    return photos;
  }
}
