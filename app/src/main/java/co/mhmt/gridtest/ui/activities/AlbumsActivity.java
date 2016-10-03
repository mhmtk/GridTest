package co.mhmt.gridtest.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.mhmt.gridtest.Constant;
import co.mhmt.gridtest.R;
import co.mhmt.gridtest.adapters.BaseRecyclerViewAdapter;
import co.mhmt.gridtest.domain.Album;
import co.mhmt.gridtest.events.AlbumViewHolderClicked;
import co.mhmt.gridtest.events.AlbumsDownloaded;
import co.mhmt.gridtest.jobs.DownloadAlbums;
import co.mhmt.gridtest.ui.viewitems.AlbumsViewHolder;

public class AlbumsActivity extends BaseActivity {

  @BindView(R.id.recycler_view_albums)
  protected RecyclerView albumsRecyclerView;

  private BaseRecyclerViewAdapter<Album> albumsAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_albums);
    setToolbar();
    ButterKnife.bind(this);

    AsyncTaskCompat.executeParallel(new DownloadAlbums());
    initiateUI();
  }

  private void initiateUI() {
    albumsAdapter = new BaseRecyclerViewAdapter<Album>(new ArrayList<Album>()) {
      @Override public AlbumsViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new AlbumsViewHolder(LayoutInflater.from(parent.getContext())
                                                  .inflate(R.layout.item_holder_album, parent, false));
      }
    };
    albumsRecyclerView.setHasFixedSize(true);
    albumsRecyclerView.setLayoutManager(new LinearLayoutManager(AlbumsActivity.this));
    albumsRecyclerView.setAdapter(albumsAdapter);
  }

  @SuppressWarnings("UnusedDeclaration")
  @Subscribe (sticky = true)
  public void albumsDownloaded(final AlbumsDownloaded event) {
    if (event.getAlbums() != null) {
      albumsAdapter.update(event.getAlbums());
    }
    eventBus.removeStickyEvent(event);
  }

  @SuppressWarnings("UnusedDeclaration")
  @Subscribe public void albumViewHolderClicked(final AlbumViewHolderClicked event) {
    Intent intent = new Intent(AlbumsActivity.this, PhotosActivity.class);
    intent.putExtra(Constant.ALBUM_ID, event.getAlbumId());
    startActivity(intent);
  }
}
