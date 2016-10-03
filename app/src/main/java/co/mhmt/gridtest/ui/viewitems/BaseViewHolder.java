package co.mhmt.gridtest.ui.viewitems;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

  protected final EventBus eventBus;

  public BaseViewHolder(final View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
    eventBus = EventBus.getDefault();
  }

  public abstract void bind(final T data);
}
