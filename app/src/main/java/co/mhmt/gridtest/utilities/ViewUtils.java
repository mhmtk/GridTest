package co.mhmt.gridtest.utilities;

import android.app.Activity;
import android.graphics.Point;
import android.support.annotation.DimenRes;

import co.mhmt.gridtest.Constant;

public final class ViewUtils {

  public static int calculateSpanCount(final Activity activity, int totalWidth, @DimenRes int itemWidth) {
    int a = (int) (Constant.IMAGE_SET_GRID_SPACING * activity.getResources().getDisplayMetrics().density);
    float b = a + (int) activity.getResources().getDimension(itemWidth);
    float c = -totalWidth;
    int x1 = (int) (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    int x2 = (int) (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    return (x1 > 0) ? x1 : ((x2 > 0) ? x2 : 1);
  }

  public static int getScreenWidth(Activity activity) {
    Point size = new Point();
    activity.getWindowManager().getDefaultDisplay().getSize(size);
    return size.x;
  }

}
