package co.mhmt.gridtest.ui.activities;

import android.os.Bundle;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.mhmt.gridtest.R;
import co.mhmt.gridtest.adapters.AlbumsRecyclerViewAdapter;
import co.mhmt.gridtest.domain.Album;
import co.mhmt.gridtest.events.AlbumViewHolderClicked;
import co.mhmt.gridtest.events.AlbumsDownloaded;
import co.mhmt.gridtest.jobs.DownloadAlbums;

public class AlbumsActivity extends BaseActivity {

  @BindView(R.id.recycler_view_albums)
  protected RecyclerView albumsRecyclerView;
  private AlbumsRecyclerViewAdapter albumsAdapter;

  private List<Album> albums;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    albums = new ArrayList<>();

    AsyncTaskCompat.executeParallel(new DownloadAlbums(), retrofit);
    initiateUI();
  }

  private void initiateUI() {
    albumsAdapter = new AlbumsRecyclerViewAdapter(albums);
    albumsRecyclerView.setHasFixedSize(true);
    albumsRecyclerView.setLayoutManager(new LinearLayoutManager(AlbumsActivity.this));
    albumsRecyclerView.setAdapter(albumsAdapter);

//    albumsRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
//    albumsRecyclerView.setEmptyView(emptyView);
//    albumsRecyclerView.setFloatingActionButton(fabAddImage);
  }

  @SuppressWarnings("UnusedDeclaration")
  @Subscribe public void albumsDonwloaded(final AlbumsDownloaded event) {
    if (event.getAlbums() != null) {
      albumsAdapter.update(event.getAlbums());
    }
    eventBus.removeStickyEvent(event);
  }

  @SuppressWarnings("UnusedDeclaration")
  @Subscribe public void albumViewHolderClicked(final AlbumViewHolderClicked event) {
    //launch album activity
  }
}
