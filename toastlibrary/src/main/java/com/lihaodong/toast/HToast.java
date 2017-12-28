package com.lihaodong.toast;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lihaodong on 2017/12/22.
 */

public class HToast {
    //全局上下文对象
    public static Context mContext;
    //默认的字体颜色
    private static final int DEFAULT_TEXT_COLOR = R.color.white;
    private static Integer defaultTextColor;
    //成功背景颜色
    private static final int TOAST_SUCCESS_COLOR = R.color.htoast_success;
    private static Integer successBgColor;
    //info背景颜色
    private static final int TOAST_INFO_COLOR = R.color.htoast_info;
    private static Integer infoBgColor;

    private static final int TOAST_NORMAL_COLOR = R.color.htoast_normal;
    private static int normalBgColor=R.color.htoast_normal;

    //失败背景颜色
    private static final int TOAST_ERROR_COLOR = R.color.htoast_error;
    private static Integer errorBgColor;
    //警告背景颜色
    private static final int TOAST_WARNING_COLOR = R.color.htoast_warning;
    private static Integer warningBgColor;

    private static Integer warningIcon;
    private static Integer errorIcon;
    private static Integer infoIcon;
    private static Integer successIcon;

    private static Integer duration;

    private static Boolean isShowIcon;

    private  Builder builder;
    private HToast(Builder builder) {
        this.mContext=builder.mContext;
        this.builder=builder;
        this.defaultTextColor=builder.textColor;
        if(defaultTextColor==null)
            defaultTextColor= DEFAULT_TEXT_COLOR;
        this.successBgColor=builder.successBgColor;
        if(successBgColor==null)
            successBgColor= TOAST_SUCCESS_COLOR;
        this.errorBgColor=builder.errorBgColor;
        if(errorBgColor==null)
            errorBgColor= TOAST_ERROR_COLOR;
        this.warningBgColor=builder.warningBgColor;
        if(warningBgColor==null)
            warningBgColor= TOAST_WARNING_COLOR;
        this.infoBgColor=builder.infoBgColor;
        if(infoBgColor==null)
            infoBgColor= TOAST_INFO_COLOR;

        this.infoIcon=builder.infoIcon;
        if(infoIcon==null)
            infoIcon= R.drawable.htoast_info;
        this.warningIcon=builder.warningIcon;
        if(warningIcon==null)
            warningIcon= R.drawable.htoast_warning;
        this.errorIcon=builder.errorIcon;
        if(errorIcon==null)
            errorIcon= R.drawable.htoast_error;
        this.successIcon=builder.successIcon;
        if(successIcon==null)
            successIcon= R.drawable.htoast_success;
        if(builder.isShowIcon!=null){
            this.isShowIcon=builder.isShowIcon;
        }else{
            this.isShowIcon=true;
        }
        if(builder.duration!=null){
            this.duration=builder.duration;
        }else{
            this.duration=Toast.LENGTH_SHORT;
        }

    }
    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }
    public static class Builder {
        private Context mContext;
        private Integer textColor;
        private Integer successBgColor;
        private Integer infoBgColor;
        private Integer errorBgColor;
        private Integer warningBgColor;
        private Integer warningIcon;
        private Integer errorIcon;
        private Integer infoIcon;
        private Integer successIcon;
        private Boolean isShowIcon;
        private Integer duration;
        public Builder(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public HToast build() {
            return new HToast(this);
        }

        /**
         * 设置字体颜色，智能设置一种
         * @param textColor
         * @return
         */
        public Builder setTextColor(Integer textColor) {
            this.textColor=textColor;
            return this;
        }
        public Builder setSuccessBgColor(Integer successBgColor) {
            this.successBgColor=successBgColor;
            return this;
        }
        public Builder setInfoBgColor(Integer infoBgColor) {
            this.infoBgColor=infoBgColor;
            return this;
        }
        public Builder setErrorBgColor(Integer errorBgColor) {
            this.errorBgColor=errorBgColor;
            return this;
        }
        public Builder setWarningBgColor(Integer warningBgColor) {
            this.warningBgColor=warningBgColor;
            return this;
        }

        public Builder setWarningIcon(int warningIcon) {
            this.warningIcon=warningIcon;
            return this;
        }
        public Builder setErrorIcon(int errorIcon) {
            this.errorIcon=errorIcon;
            return this;
        }
        public Builder setInfoIcon(int infoIcon) {
            this.infoIcon=infoIcon;
            return this;
        }
        public Builder setSuccessIcon(int successIcon) {
            this.successIcon=successIcon;
            return this;
        }

        public Builder setShowIcon(Boolean isShowIcon) {
                this.isShowIcon=isShowIcon;
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration=duration;
            return this;
        }
    }

    private static final String TOAST_TYPEFACE = "sans-serif-condensed";

    /**
     * 上次显示的内容
     */
    private static String oldMsg;
    /**
     * 上次时间
     */
    private static long oldTime = 0;
    /**
     * Toast对象
     */
    private static Toast mToast = null;

    public static Toast normal(@NonNull String message) {
        return normal(message, Toast.LENGTH_SHORT, null);
    }

    public static Toast normal(@NonNull String message, Drawable icon) {
        return normal(message, Toast.LENGTH_SHORT, icon);
    }

    public static Toast normal(@NonNull String message, int duration) {
        return normal(message, duration, null);
    }

    public static Toast normal(@NonNull String message, int duration,
                               Drawable icon) {
        return custom(message, icon, normalBgColor, duration);
    }

    public static Toast warning(@NonNull String message) {
        return warning(message, true);
    }

    public static Toast warning(@NonNull String message, boolean withIcon) {
        Drawable icon = null;
        if(isShowIcon){
            if (withIcon&&warningIcon!=null) {
                icon = HOutdatedUtils.getDrawable(warningIcon);
            }
        }
        if(duration==null)
            duration=Toast.LENGTH_SHORT;
        return custom(message, icon, warningBgColor, duration);
    }

    public static Toast info(@NonNull String message) {
        return info(message, true);
    }

    public static Toast info(@NonNull String message, boolean withIcon) {
        Drawable icon = null;
        if(isShowIcon){
            if (withIcon&&infoIcon!=null) {
                icon = HOutdatedUtils.getDrawable(infoIcon);
            }
        }
        if(duration==null)
            duration=Toast.LENGTH_SHORT;
        return custom(message, icon, infoBgColor, duration);
    }

    public static Toast success(@NonNull String message) {
        return success(message, true);
    }


    public static Toast success(@NonNull String message, boolean withIcon) {
        Drawable icon = null;
        if(isShowIcon){
            if (withIcon&&successIcon!=null) {
                icon = HOutdatedUtils.getDrawable(successIcon);
            }
        }
        if(duration==null)
            duration=Toast.LENGTH_SHORT;
        return custom(message, icon, successBgColor, duration);
    }

    public static Toast error(@NonNull String message) {
        return error(message, true);
    }


    public static Toast error(@NonNull String message, boolean withIcon) {
        Drawable icon = null;
        if(isShowIcon){
            if (withIcon&&errorIcon!=null) {
                icon = HOutdatedUtils.getDrawable(errorIcon);
            }
        }
        if(duration==null)
            duration=Toast.LENGTH_SHORT;
        return custom(message, icon, errorBgColor, duration);
    }

    private Toast custom(@NonNull String message, @ColorInt int tintColor) {
        return custom(message, null, defaultTextColor, tintColor, Toast.LENGTH_SHORT);
    }

    private static Toast custom(@NonNull String message, Drawable icon, @ColorInt int tintColor) {
        return custom(message, icon,  defaultTextColor, tintColor, Toast.LENGTH_SHORT);
    }

    private static Toast custom(@NonNull String message, @ColorInt int tintColor, int duration) {
        return custom(message, null,  defaultTextColor, tintColor, duration);
    }

    private static Toast custom(@NonNull String message, Drawable icon, int tintColor, int duration) {
        return custom(message, icon,  defaultTextColor, tintColor, duration);
    }

    private static Toast custom(@NonNull String message, @DrawableRes int iconRes,
                               @ColorInt int textColor, @ColorInt int tintColor, int duration) {
        return custom(message, HOutdatedUtils.getDrawable(iconRes), textColor, tintColor, duration);
    }

    /**
     * 自定义toast方法
     *
     * @param message   提示消息文本
     * @param icon      提示消息的icon,传入null代表不显示
     * @param textColor 提示消息文本颜色
     * @param tintColor 提示背景颜色
     * @param duration  显示时长
     * @return
     */
    private static Toast custom(@NonNull String message, Drawable icon,
                               int textColor, int tintColor, int duration) {
        View toastLayout = LayoutInflater.from(HToast.mContext).inflate(R.layout.htoast_view, null);
        ImageView toastIcon = (ImageView) toastLayout.findViewById(R.id.htoast_icon);
        TextView toastText = (TextView) toastLayout.findViewById(R.id.htoast_text);

        Drawable drawableFrame = HOutdatedUtils.getDrawable(R.drawable.htoast_frame);
        drawableFrame.setColorFilter(new PorterDuffColorFilter(mContext.getResources().getColor(tintColor), PorterDuff.Mode.SRC_IN));
        HOutdatedUtils.setBackground(toastLayout, drawableFrame);

        if (icon == null) {
            toastIcon.setVisibility(View.GONE);
        } else {
            HOutdatedUtils.setBackground(toastIcon, icon);
        }

        toastText.setTextColor(HToast.mContext.getResources().getColor(textColor));
        toastText.setText(message);
        toastText.setTypeface(Typeface.create(TOAST_TYPEFACE, Typeface.NORMAL));

        if (mToast == null) {
            mToast = new Toast(HToast.mContext);
            mToast.setView(toastLayout);
            mToast.setGravity(Gravity.CENTER,0,0);
            mToast.setDuration(duration);
            mToast.show();
            oldTime = System.currentTimeMillis();
        } else {
            if (message.equals(oldMsg)) {
                if (System.currentTimeMillis() - oldTime > Toast.LENGTH_SHORT) {
                    mToast.show();
                }
            } else {
                oldMsg = message;
                mToast.setView(toastLayout);
                mToast.setDuration(duration);
                mToast.show();
            }
        }

        oldTime = System.currentTimeMillis();
        return mToast;
    }
}
