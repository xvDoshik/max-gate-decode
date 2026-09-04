package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    public byte[] mData;
    public int mInt1;
    public int mInt2;
    public Object mObj1;
    public Parcelable mParcelable;
    public String mString1;
    public ColorStateList mTintList;
    public PorterDuff.Mode mTintMode;
    public String mTintModeStr;
    public int mType;

    public abstract class Api23Impl {
        public static Uri getUri(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getUri(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod(C0000.decode(new byte[]{83, 81, 71, 48, 20, 93}, "443ef4", true), null).invoke(obj, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }

        public static Drawable loadDrawable(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        public static Icon toIcon(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            int i = iconCompat.mType;
            String resPackage = null;
            inputStreamOpenInputStream = null;
            InputStream inputStreamOpenInputStream = null;
            switch (i) {
                case -1:
                    return (Icon) iconCompat.mObj1;
                case 0:
                default:
                    throw new IllegalArgumentException(C0000.decode(new byte[]{100, 91, 10, 95, 86, 19, 95, 69, 68, 76, 64, 7}, "15a19d1e050b10", 0.0f));
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.mObj1);
                    break;
                case 2:
                    if (i == -1) {
                        int i2 = Build.VERSION.SDK_INT;
                        Object obj = iconCompat.mObj1;
                        if (i2 >= 28) {
                            resPackage = Api28Impl.getResPackage(obj);
                        } else {
                            try {
                                resPackage = (String) obj.getClass().getMethod(C0000.decode(new byte[]{85, 92, 64, 100, 84, 18, 50, 7, 1, 9, 81, 82, 87}, "29461abfbb05"), null).invoke(obj, null);
                            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                            }
                        }
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException(C0000.decode(new byte[]{5, 81, 88, 89, 3, 1, 65, 87, 6, 68, 98, 83, 64, 102, 0, 6, 13, 81, 83, 80, 78, 76, 65, 95, 13, 16}, "f045fea0c00636ae", 5) + iconCompat);
                        }
                        String str = iconCompat.mString1;
                        resPackage = (str == null || TextUtils.isEmpty(str)) ? ((String) iconCompat.mObj1).split(C0000.decode(new byte[]{13}, "72b4fccd99db", 0.0f), -1)[0] : iconCompat.mString1;
                    }
                    iconCreateWithBitmap = Icon.createWithResource(resPackage, iconCompat.mInt1);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.mObj1, iconCompat.mInt1, iconCompat.mInt2);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.mObj1);
                    break;
                case 5:
                    iconCreateWithBitmap = Api26Impl.createWithAdaptiveBitmap((Bitmap) iconCompat.mObj1);
                    break;
                case 6:
                    if (Build.VERSION.SDK_INT >= 30) {
                        iconCreateWithBitmap = Api30Impl.createWithAdaptiveBitmapContentUri(iconCompat.getUri());
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException(C0000.decode(new byte[]{118, 89, 12, 23, 80, 76, 65, 22, 11, 16, 21, 70, 80, 71, 23, 10, 71, 81, 81, 22, 22, 12, 21, 70, 80, 69, 13, 15, 67, 81, 21, 66, 10, 6, 21, 82, 92, 90, 7, 67, 64, 70, 92, 22, 13, 5, 21, 64, 93, 83, 66, 10, 86, 91, 91, 12, 66}, "56bc54", 3) + iconCompat.getUri());
                        }
                        Uri uri = iconCompat.getUri();
                        String scheme = uri.getScheme();
                        if (C0000.decode(new byte[]{86, 95, 12, 18, 83, 94, 22}, "50bf60b0bc", 0.0f).equals(scheme) || C0000.decode(new byte[]{83, 90, 91, 4}, "537a3afd97f108", 0.0f).equals(scheme)) {
                            try {
                                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                            } catch (Exception unused2) {
                                uri.toString();
                            }
                            break;
                        } else {
                            try {
                                inputStreamOpenInputStream = new FileInputStream(new File((String) iconCompat.mObj1));
                            } catch (FileNotFoundException unused3) {
                                uri.toString();
                            }
                        }
                        if (inputStreamOpenInputStream == null) {
                            throw new IllegalStateException(C0000.decode(new byte[]{39, 80, 94, 95, 92, 18, 16, 88, 91, 85, 2, 68, 4, 81, 5, 65, 68, 88, 69, 3, 16, 93, 87, 91, 8, 68, 3, 71, 11, 92, 16, 68, 65, 15, 10, 20}, "d1013f0444fde5", 2) + iconCompat.getUri());
                        }
                        iconCreateWithBitmap = Api26Impl.createWithAdaptiveBitmap(BitmapFactory.decodeStream(inputStreamOpenInputStream));
                    }
                    break;
            }
            ColorStateList colorStateList = iconCompat.mTintList;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.mTintMode;
            if (mode != IconCompat.DEFAULT_TINT_MODE) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    public abstract class Api26Impl {
        public static Drawable createAdaptiveIconDrawable(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        public static Icon createWithAdaptiveBitmap(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    public abstract class Api28Impl {
        public static int getResId(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String getResPackage(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int getType(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri getUri(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    public abstract class Api30Impl {
        public static Icon createWithAdaptiveBitmapContentUri(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
    }

    public static IconCompat createWithResource(int i) {
        if (i == 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{119, 19, 82, 69, 89, 86, 15, 93, 18, 71, 6, 75, 12, 17, 65, 2, 86, 18, 113, 112, 67, 85, 71, 70, 23, 24, 13, 11, 71, 65, 81, 87, 24, 4}, "3a3284c825c8cd", 7));
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.mInt1 = i;
        iconCompat.mObj1 = "";
        iconCompat.mString1 = "";
        return iconCompat;
    }

    public final int getResId() {
        int i = this.mType;
        if (i != -1) {
            if (i == 2) {
                return this.mInt1;
            }
            throw new IllegalStateException(C0000.decode(new byte[]{80, 86, 95, 9, 85, 1, 24, 81, 86, 67, 97, 0, 67, 44, 92, 30, 26, 23, 92, 11, 16}, "373e0e86") + this);
        }
        int i2 = Build.VERSION.SDK_INT;
        Object obj = this.mObj1;
        if (i2 >= 28) {
            return Api28Impl.getResId(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod(C0000.decode(new byte[]{85, 87, 23, 101, 6, 17, 120, 85}, "22c7cb11ac724658", 0.0f), null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return 0;
        }
    }

    public final int getType() {
        int i = this.mType;
        if (i != -1) {
            return i;
        }
        int i2 = Build.VERSION.SDK_INT;
        Object obj = this.mObj1;
        if (i2 >= 28) {
            return Api28Impl.getType(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod(C0000.decode(new byte[]{84, 7, 68, 53, 65, 19, 85}, "3b0a8c0f3f18a0"), null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException unused) {
            Objects.toString(obj);
            return -1;
        } catch (NoSuchMethodException unused2) {
            Objects.toString(obj);
            return -1;
        } catch (InvocationTargetException unused3) {
            Objects.toString(obj);
            return -1;
        }
    }

    public final Uri getUri() {
        int i = this.mType;
        if (i == -1) {
            return Api23Impl.getUri(this.mObj1);
        }
        if (i == 4 || i == 6) {
            return Uri.parse((String) this.mObj1);
        }
        throw new IllegalStateException(C0000.decode(new byte[]{85, 0, 9, 95, 87, 7, 16, 95, 86, 17, 49, 75, 95, 73, 76, 19, 93, 13, 16}, "6ae32c083ed9") + this);
    }

    public final String toString() {
        String strDecode;
        if (this.mType == -1) {
            return String.valueOf(this.mObj1);
        }
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{122, 7, 92, 95, 30, 18, 72, 71, 94}, "3d316f17cfdb31", false));
        switch (this.mType) {
            case 1:
                strDecode = C0000.decode(new byte[]{118, 121, 48, 124, 112, 49}, "40d11ae8863842", true);
                break;
            case 2:
                strDecode = C0000.decode(new byte[]{96, 124, 100, 123, 49, 96, 119, 116}, "2974d2419750da");
                break;
            case 3:
                strDecode = C0000.decode(new byte[]{32, 120, 102, 117}, "d924caa44d43", true);
                break;
            case 4:
                strDecode = C0000.decode(new byte[]{97, 98, 127}, "406e68c5d2");
                break;
            case 5:
                strDecode = C0000.decode(new byte[]{118, 47, 102, 41, 116, 101, 103, 46, 35, 100, 47, 116, 118, 42, 119}, "4f2d558cb7d5", false);
                break;
            case 6:
                strDecode = C0000.decode(new byte[]{109, 55, 43, 58, 124, 35, 96, 45, 120, 35, 117, 112}, "8ebe1b3f9a9544d5");
                break;
            default:
                strDecode = C0000.decode(new byte[]{98, 120, 126, 120, 127, 53, 121}, "76560b", 0.0f);
                break;
        }
        sb.append(strDecode);
        switch (this.mType) {
            case 1:
            case 5:
                sb.append(C0000.decode(new byte[]{19, 70, 95, 78, 81, 88}, "35644e5828", 0.0f));
                sb.append(((Bitmap) this.mObj1).getWidth());
                sb.append(C0000.decode(new byte[]{76}, "4a3ed69ce2a18522", 0.0f));
                sb.append(((Bitmap) this.mObj1).getHeight());
                break;
            case 2:
                sb.append(C0000.decode(new byte[]{23, 73, 8, 84, 88}, "79c3e9e80742"));
                sb.append(this.mString1);
                sb.append(C0000.decode(new byte[]{17, 81, 5, 11}, "18a6fea478e0"));
                sb.append(String.format(C0000.decode(new byte[]{5, 25, 68, 6, 15, 76}, "5aa674ff", 0.0f), Integer.valueOf(getResId())));
                break;
            case 3:
                sb.append(C0000.decode(new byte[]{18, 92, 87, 94, 91}, "2020f121", 0.0f));
                sb.append(this.mInt1);
                if (this.mInt2 != 0) {
                    sb.append(C0000.decode(new byte[]{17, 92, 0, 80, 14}, "13f636", 2));
                    sb.append(this.mInt2);
                }
                break;
            case 4:
            case 6:
                sb.append(C0000.decode(new byte[]{24, 69, 23, 95, 5}, "80e68df10cf4", true));
                sb.append(this.mObj1);
                break;
        }
        if (this.mTintList != null) {
            sb.append(C0000.decode(new byte[]{19, 76, 93, 93, 67, 15}, "384372", 0.0f));
            sb.append(this.mTintList);
        }
        if (this.mTintMode != DEFAULT_TINT_MODE) {
            sb.append(C0000.decode(new byte[]{19, 84, 10, 2, 81, 94}, "39ef4c700966"));
            sb.append(this.mTintMode);
        }
        sb.append(C0000.decode(new byte[]{31}, "68909f4dcfc5e3"));
        return sb.toString();
    }

    public IconCompat(int i) {
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = i;
    }
}
