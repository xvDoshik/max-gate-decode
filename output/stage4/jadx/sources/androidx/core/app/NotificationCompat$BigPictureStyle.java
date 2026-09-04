package androidx.core.app;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class NotificationCompat$BigPictureStyle extends NotificationCompat$Style {
    public IconCompat mBigLargeIcon;
    public boolean mBigLargeIconSet;
    public IconCompat mPictureIcon;

    public abstract class Api16Impl {
        public static Notification.BigPictureStyle bigPicture(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
            return bigPictureStyle.bigPicture(bitmap);
        }

        public static Notification.BigPictureStyle createBigPictureStyle(Notification.Builder builder) {
            return new Notification.BigPictureStyle(builder);
        }

        public static Notification.BigPictureStyle setBigContentTitle(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
            return bigPictureStyle.setBigContentTitle(charSequence);
        }

        public static void setBigLargeIcon(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
            bigPictureStyle.bigLargeIcon(bitmap);
        }
    }

    public abstract class Api23Impl {
        public static void setBigLargeIcon(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
            bigPictureStyle.bigLargeIcon(icon);
        }
    }

    public abstract class Api31Impl {
        public static void setBigPicture(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
            bigPictureStyle.bigPicture(icon);
        }

        public static void setContentDescription(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
            bigPictureStyle.setContentDescription(charSequence);
        }

        public static void showBigPictureWhenCollapsed(Notification.BigPictureStyle bigPictureStyle, boolean z) {
            bigPictureStyle.showBigPictureWhenCollapsed(z);
        }
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final void apply(Dispatcher dispatcher) {
        Bitmap bitmap;
        int i = Build.VERSION.SDK_INT;
        Notification.Builder builder = (Notification.Builder) dispatcher.readyAsyncCalls;
        Context context = (Context) dispatcher.executorServiceOrNull;
        Notification.BigPictureStyle bigContentTitle = Api16Impl.setBigContentTitle(Api16Impl.createBigPictureStyle(builder), null);
        IconCompat iconCompat = this.mPictureIcon;
        if (iconCompat != null) {
            if (i >= 31) {
                Api31Impl.setBigPicture(bigContentTitle, IconCompat.Api23Impl.toIcon(iconCompat, context));
            } else if (iconCompat.getType() == 1) {
                IconCompat iconCompat2 = this.mPictureIcon;
                int i2 = iconCompat2.mType;
                if (i2 == -1) {
                    Object obj = iconCompat2.mObj1;
                    bitmap = obj instanceof Bitmap ? (Bitmap) obj : null;
                } else if (i2 == 1) {
                    bitmap = (Bitmap) iconCompat2.mObj1;
                } else {
                    if (i2 != 5) {
                        throw new IllegalStateException(C0000.decode(new byte[]{85, 83, 94, 84, 80, 92, 16, 82, 83, 70, 112, 81, 65, 85, 81, 69, 30, 27, 18, 87, 91, 24}, "62285805", true) + iconCompat2);
                    }
                    Bitmap bitmap2 = (Bitmap) iconCompat2.mObj1;
                    int iMin = (int) (Math.min(bitmap2.getWidth(), bitmap2.getHeight()) * 0.6666667f);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    Paint paint = new Paint(3);
                    float f = iMin;
                    float f2 = 0.5f * f;
                    float f3 = 0.9166667f * f2;
                    float f4 = 0.010416667f * f;
                    paint.setColor(0);
                    paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
                    canvas.drawCircle(f2, f2, f3, paint);
                    paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
                    canvas.drawCircle(f2, f2, f3, paint);
                    paint.clearShadowLayer();
                    paint.setColor(-16777216);
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
                    Matrix matrix = new Matrix();
                    matrix.setTranslate((-(bitmap2.getWidth() - iMin)) / 2.0f, (-(bitmap2.getHeight() - iMin)) / 2.0f);
                    bitmapShader.setLocalMatrix(matrix);
                    paint.setShader(bitmapShader);
                    canvas.drawCircle(f2, f2, f3, paint);
                    canvas.setBitmap(null);
                    bitmap = bitmapCreateBitmap;
                }
                bigContentTitle = Api16Impl.bigPicture(bigContentTitle, bitmap);
            }
        }
        if (this.mBigLargeIconSet) {
            IconCompat iconCompat3 = this.mBigLargeIcon;
            if (iconCompat3 == null) {
                Api16Impl.setBigLargeIcon(bigContentTitle, null);
            } else {
                Api23Impl.setBigLargeIcon(bigContentTitle, IconCompat.Api23Impl.toIcon(iconCompat3, context));
            }
        }
        if (i >= 31) {
            Api31Impl.showBigPictureWhenCollapsed(bigContentTitle, false);
            Api31Impl.setContentDescription(bigContentTitle, null);
        }
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final String getClassName() {
        return C0000.decode(new byte[]{4, 95, 93, 16, 90, 90, 81, 25, 22, 81, 12, 67, 0, 31, 88, 18, 69, 29, 123, 14, 76, 91, 5, 88, 6, 80, 77, 11, 90, 93, 118, 14, 85, 66, 2, 69, 65, 115, 80, 5, 101, 90, 86, 21, 77, 64, 6, 98, 17, 72, 85, 7}, "e19b535a82c1", true);
    }
}
