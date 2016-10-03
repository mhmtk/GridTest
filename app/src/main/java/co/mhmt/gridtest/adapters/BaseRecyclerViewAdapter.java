package co.mhmt.gridtest.adapters;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import co.mhmt.gridtest.ui.viewitems.BaseViewHolder;

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

  private List<T> data;

  public BaseRecyclerViewAdapter(List<T> data) {
    this.data = data;
  }

  @Override public void onBindViewHolder(final BaseViewHolder<T> holder, final int position) {
    holder.bind(data.get(position));
  }

  @Override public int getItemCount() {
    return data.size();
  }

  public void update(final List<T> data) {
    this.data = data;
    notifyDataSetChanged();
  }
}
