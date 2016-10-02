package co.mhmt.gridtest.domain;

import android.support.annotation.NonNull;

public class Album {

  @NonNull
  private int id;
  private int userId;
  private String title;

  public Album(final int id, final int userId, final String title) {
    this.id = id;
    this.userId = userId;
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(final int userId) {
    this.userId = userId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }
}
