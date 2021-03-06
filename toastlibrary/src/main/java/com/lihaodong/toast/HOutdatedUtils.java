package com.lihaodong.toast;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;

/**
 * Created by lihaodong on 2017/12/22.
 */

public class HOutdatedUtils {
    private HOutdatedUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * setBackgroundDrawable过时方法处理
     *
     * @param view
     * @param drawable
     */
    public static void setBackground(@NonNull View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            view.setBackground(drawable);
        else
            view.setBackgroundDrawable(drawable);
    }

    /**
     * getDrawable过时方法处理
     *
     * @param id
     * @return
     */
    public static Drawable getDrawable(@DrawableRes int id) {
        return ContextCompat.getDrawable(HToast.mContext, id);
    }

    /**
     * getDrawable过时方法处理
     *
     * @param id 资源id
     * @param theme 指定主题
     * @return
     */
    public static Drawable getDrawable(@DrawableRes int id,
                                       @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(HToast.mContext.getResources(), id, theme);
    }

    /**
     * getColor过时方法处理
     *
     * @param id
     * @return
     */
    public static int getColor(@ColorRes int id) {
        return ContextCompat.getColor(HToast.mContext, id);
    }

    /**
     * getColor过时方法处理
     *
     * @param id 资源id
     * @param theme 指定主题
     * @return
     */
    public static int getColor(@ColorRes int id, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getColor(HToast.mContext.getResources(), id, theme);
    }

    /**
     * getColorStateList过时方法处理
     *
     * @param id 资源id
     * @return
     */
    public static ColorStateList getColorStateList(@ColorRes int id) {
        return ContextCompat.getColorStateList(HToast.mContext, id);
    }

    /**
     * getColorStateList过时方法处理
     *
     * @param id 资源id
     * @param theme 指定主题
     * @return
     */
    public static ColorStateList getColorStateList(@ColorRes int id, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getColorStateList(HToast.mContext.getResources(), id, theme);
    }
}
