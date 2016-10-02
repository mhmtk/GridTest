package co.mhmt.gridtest.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import co.mhmt.gridtest.R;
import co.mhmt.gridtest.domain.Album;
import co.mhmt.gridtest.ui.viewitems.AlbumsViewHolder;

public class AlbumsRecyclerViewAdapter extends RecyclerView.Adapter<AlbumsViewHolder> {

  private List<Album> albumList;

  public AlbumsRecyclerViewAdapter(List<Album> albumList) {
    this.albumList = albumList;
  }

  @Override public AlbumsViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
    return new AlbumsViewHolder(LayoutInflater.from(parent.getContext())
                                                .inflate(R.layout.item_holder_album, parent, false));
  }

  @Override public void onBindViewHolder(final AlbumsViewHolder holder, final int position) {
    holder.bind(albumList.get(position));
  }

  @Override public int getItemCount() {
    return albumList.size();
  }

  public void update(final List<Album> albums) {
    albumList = albums;
    notifyDataSetChanged();
  }
}
