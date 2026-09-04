package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat$Api19Impl;
import androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WindowInsetsCompat {
    public final Impl mImpl;

    public abstract class Api21ReflectionHolder {
        public static final Field sContentInsets;
        public static final boolean sReflectionSucceeded;
        public static final Field sStableInsets;
        public static final Field sViewAttachInfoField;

        static {
            try {
                Field declaredField = View.class.getDeclaredField(C0000.decode(new byte[]{88, 37, 66, 23, 85, 90, 93, 45, 88, 5, 91}, "5d6c49", 0.0f));
                sViewAttachInfoField = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName(C0000.decode(new byte[]{2, 87, 5, 64, 87, 8, 6, 29, 21, 12, 6, 71, 72, 99, 10, 6, 20, 29, 32, 70, 76, 0, 1, 91, 42, 11, 5, 95}, "c9a28ab3cec0f5cc", true));
                Field declaredField2 = cls.getDeclaredField(C0000.decode(new byte[]{91, 55, 18, 83, 7, 84, 83, 45, 8, 65, 0, 76, 69}, "6df2e8"));
                sStableInsets = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField(C0000.decode(new byte[]{15, 113, 87, 86, 71, 86, 12, 70, 113, 86, 64, 86, 22, 65}, "b28833", 0.0f));
                sContentInsets = declaredField3;
                declaredField3.setAccessible(true);
                sReflectionSucceeded = true;
            } catch (ReflectiveOperationException e) {
                e.getMessage();
            }
        }
    }

    public abstract class BuilderImpl {
        public BuilderImpl() {
            this(new WindowInsetsCompat());
        }

        public final void applyInsetTypes() {
        }

        public abstract WindowInsetsCompat build();

        public abstract void setStableInsets(Insets insets);

        public abstract void setSystemWindowInsets(Insets insets);

        public BuilderImpl(WindowInsetsCompat windowInsetsCompat) {
        }
    }

    public final class BuilderImpl20 extends BuilderImpl {
        public static Constructor sConstructor;
        public static boolean sConstructorFetched;
        public static Field sConsumedField;
        public static boolean sConsumedFieldFetched;
        public WindowInsets mPlatformInsets = createWindowInsetsInstance();
        public Insets mStableInsets;

        /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
            jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:4:0x0007
            	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:280)
            	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:79)
            */
        private static android.view.WindowInsets createWindowInsetsInstance() {
            /*
                boolean r0 = androidx.core.view.WindowInsetsCompat.BuilderImpl20.sConsumedFieldFetched
                r1 = 1
                java.lang.Class<android.view.WindowInsets> r2 = android.view.WindowInsets.class
                if (r0 != 0) goto L1f
            La:
                r5 = 8
                byte[] r5 = new byte[r5]     // Catch: java.lang.ReflectiveOperationException -> L1d
                r5 = {x005a: FILL_ARRAY_DATA , data: [119, 45, 47, 54, 102, 43, 118, 117} // fill-array     // Catch: java.lang.ReflectiveOperationException -> L1d
                java.lang.String r0 = "4bae3f31"
                java.lang.String r0 = p000.C0000.decode(r5, r0)     // Catch: java.lang.ReflectiveOperationException -> L1d
                java.lang.reflect.Field r0 = r2.getDeclaredField(r0)     // Catch: java.lang.ReflectiveOperationException -> L1d
                androidx.core.view.WindowInsetsCompat.BuilderImpl20.sConsumedField = r0     // Catch: java.lang.ReflectiveOperationException -> L1d
            L1d:
                androidx.core.view.WindowInsetsCompat.BuilderImpl20.sConsumedFieldFetched = r1
            L1f:
                java.lang.reflect.Field r0 = androidx.core.view.WindowInsetsCompat.BuilderImpl20.sConsumedField
                r3 = 0
                if (r0 == 0) goto L32
                java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.ReflectiveOperationException -> L32
                android.view.WindowInsets r0 = (android.view.WindowInsets) r0     // Catch: java.lang.ReflectiveOperationException -> L32
                if (r0 == 0) goto L32
                android.view.WindowInsets r4 = new android.view.WindowInsets     // Catch: java.lang.ReflectiveOperationException -> L32
                r4.<init>(r0)     // Catch: java.lang.ReflectiveOperationException -> L32
                return r4
            L32:
                boolean r0 = androidx.core.view.WindowInsetsCompat.BuilderImpl20.sConstructorFetched
                if (r0 != 0) goto L44
                java.lang.Class<android.graphics.Rect> r0 = android.graphics.Rect.class
                java.lang.Class[] r0 = new java.lang.Class[]{r0}     // Catch: java.lang.ReflectiveOperationException -> L42
                java.lang.reflect.Constructor r0 = r2.getConstructor(r0)     // Catch: java.lang.ReflectiveOperationException -> L42
                androidx.core.view.WindowInsetsCompat.BuilderImpl20.sConstructor = r0     // Catch: java.lang.ReflectiveOperationException -> L42
            L42:
                androidx.core.view.WindowInsetsCompat.BuilderImpl20.sConstructorFetched = r1
            L44:
                java.lang.reflect.Constructor r0 = androidx.core.view.WindowInsetsCompat.BuilderImpl20.sConstructor
                if (r0 == 0) goto L58
                android.graphics.Rect r1 = new android.graphics.Rect     // Catch: java.lang.ReflectiveOperationException -> L58
                r1.<init>()     // Catch: java.lang.ReflectiveOperationException -> L58
                java.lang.Object[] r1 = new java.lang.Object[]{r1}     // Catch: java.lang.ReflectiveOperationException -> L58
                java.lang.Object r0 = r0.newInstance(r1)     // Catch: java.lang.ReflectiveOperationException -> L58
                android.view.WindowInsets r0 = (android.view.WindowInsets) r0     // Catch: java.lang.ReflectiveOperationException -> L58
                return r0
            L58:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.WindowInsetsCompat.BuilderImpl20.createWindowInsetsInstance():android.view.WindowInsets");
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets, null);
            Impl impl = windowInsetsCompat.mImpl;
            impl.setOverriddenInsets(null);
            impl.setStableInsets(this.mStableInsets);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(Insets insets) {
            this.mStableInsets = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(Insets insets) {
            WindowInsets windowInsets = this.mPlatformInsets;
            if (windowInsets != null) {
                this.mPlatformInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }
    }

    public class BuilderImpl29 extends BuilderImpl {
        public final WindowInsets.Builder mPlatBuilder = Trace$$ExternalSyntheticApiModelOutline0.m();

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build(), null);
            windowInsetsCompat.mImpl.setOverriddenInsets(null);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(Insets insets) {
            this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(Insets insets) {
            this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
        }
    }

    public final class BuilderImpl30 extends BuilderImpl29 {
    }

    public class Impl {
        public static final /* synthetic */ int $r8$clinit = 0;
        public final WindowInsetsCompat mHost;

        static {
            BuilderImpl builderImpl29;
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                builderImpl29 = new BuilderImpl30();
            } else {
                builderImpl29 = i >= 29 ? new BuilderImpl29() : new BuilderImpl20();
            }
            builderImpl29.build().mImpl.consumeDisplayCutout().mImpl.consumeStableInsets().mImpl.consumeSystemWindowInsets();
        }

        public Impl(WindowInsetsCompat windowInsetsCompat) {
            this.mHost = windowInsetsCompat;
        }

        public WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        public WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        public WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        public void copyRootViewBounds(View view) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            return isRound() == impl.isRound() && isConsumed() == impl.isConsumed() && ObjectsCompat$Api19Impl.equals(getSystemWindowInsets(), impl.getSystemWindowInsets()) && ObjectsCompat$Api19Impl.equals(getStableInsets(), impl.getStableInsets()) && ObjectsCompat$Api19Impl.equals(getDisplayCutout(), impl.getDisplayCutout());
        }

        public DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        public Insets getStableInsets() {
            return Insets.NONE;
        }

        public Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        public int hashCode() {
            return ObjectsCompat$Api19Impl.hash(Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout());
        }

        public boolean isConsumed() {
            return false;
        }

        public boolean isRound() {
            return false;
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
        }

        public void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        }

        public void setStableInsets(Insets insets) {
        }
    }

    public abstract class Impl20 extends Impl {
        public static Class sAttachInfoClass;
        public static Field sAttachInfoField;
        public static Method sGetViewRootImplMethod;
        public static Field sVisibleInsetsField;
        public static boolean sVisibleRectReflectionFetched;
        public final WindowInsets mPlatformInsets;
        public Insets mRootViewVisibleInsets;
        public Insets mSystemWindowInsets;

        public Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = windowInsets;
        }

        private Insets getVisibleInsets(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException(C0000.decode(new byte[]{86, 3, 67, 55, 12, 22, 90, 7, 93, 3, 126, 15, 22, 0, 71, 22, 25, 79, 23, 18, 13, 10, 70, 9, 85, 70, 89, 14, 17, 69, 81, 0, 17, 5, 86, 13, 9, 0, 87, 69, 94, 8, 23, 32, 53, 44, 19, 91, 12, 70, 4, 81, 75, 69, 102, 22, 84, 70, 96, 8, 11, 1, 92, 18, 120, 8, 68, 4, 17, 22, 29, 12, 66, 48, 94, 18, 12, 7, 95, 0, 25, 79, 23, 8, 11, 22, 71, 0, 80, 2, 25}, "1f7aee3e", 0.0f));
            }
            if (!sVisibleRectReflectionFetched) {
                loadReflectionField();
            }
            Method method = sGetViewRootImplMethod;
            if (method != null && sAttachInfoClass != null && sVisibleInsetsField != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke != null) {
                        Rect rect = (Rect) sVisibleInsetsField.get(sAttachInfoField.get(objInvoke));
                        if (rect != null) {
                            return Insets.of(rect.left, rect.top, rect.right, rect.bottom);
                        }
                    }
                } catch (ReflectiveOperationException e) {
                    e.getMessage();
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void loadReflectionField() {
            try {
                sGetViewRootImplMethod = View.class.getDeclaredMethod(C0000.decode(new byte[]{82, 4, 70, 102, 10, 6, 21, 55, 90, 95, 21, 123, 88, 17, 94}, "5a20ccbe50a2", 5), null);
                Class<?> cls = Class.forName(C0000.decode(new byte[]{7, 88, 85, 19, 13, 93, 0, 22, 16, 95, 84, 22, 76, 98, 13, 93, 17, 18, 112, 21, 22, 85, 7, 80, 47, 88, 87, 14}, "f61ab4d8", true));
                sAttachInfoClass = cls;
                sVisibleInsetsField = cls.getDeclaredField(C0000.decode(new byte[]{84, 102, 10, 16, 10, 91, 94, 84, 40, 86, 70, 0, 17, 75}, "90ccc921a85ee8", false));
                sAttachInfoField = Class.forName(C0000.decode(new byte[]{0, 93, 85, 71, 14, 80, 85, 26, 71, 95, 0, 65, 74, 99, 8, 86, 70, 103, 14, 86, 69, 125, 92, 70, 9}, "a315a91416e6d5")).getDeclaredField(C0000.decode(new byte[]{95, 118, 22, 22, 84, 1, 92, 124, 92, 81, 13}, "27bb5b45"));
                sVisibleInsetsField.setAccessible(true);
                sAttachInfoField.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                e.getMessage();
            }
            sVisibleRectReflectionFetched = true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void copyRootViewBounds(View view) {
            Insets visibleInsets = getVisibleInsets(view);
            if (visibleInsets == null) {
                visibleInsets = Insets.NONE;
            }
            setRootViewData(visibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) obj).mRootViewVisibleInsets);
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets == null) {
                WindowInsets windowInsets = this.mPlatformInsets;
                this.mSystemWindowInsets = Insets.of(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setOverriddenInsets(Insets[] insetsArr) {
        }

        public void setRootViewData(Insets insets) {
            this.mRootViewVisibleInsets = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        }
    }

    public class Impl21 extends Impl20 {
        public Insets mStableInsets;

        public Impl21(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.mStableInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets(), null);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets(), null);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public final Insets getStableInsets() {
            if (this.mStableInsets == null) {
                WindowInsets windowInsets = this.mPlatformInsets;
                this.mStableInsets = Insets.of(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(Insets insets) {
            this.mStableInsets = insets;
        }
    }

    public class Impl28 extends Impl21 {
        public Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout(), null);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            return Objects.equals(this.mPlatformInsets, impl28.mPlatformInsets) && Objects.equals(this.mRootViewVisibleInsets, impl28.mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public DisplayCutoutCompat getDisplayCutout() {
            DisplayCutout displayCutout = this.mPlatformInsets.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new DisplayCutoutCompat(displayCutout);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }
    }

    public class Impl29 extends Impl28 {
        public Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(Insets insets) {
        }
    }

    public final class Impl30 extends Impl29 {
        public static final /* synthetic */ int $r8$clinit = 0;

        static {
            WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED, null);
        }

        public Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public final void copyRootViewBounds(View view) {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            int i = Impl30.$r8$clinit;
        } else {
            int i2 = Impl.$r8$clinit;
        }
    }

    public WindowInsetsCompat(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.mImpl = new Impl30(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.mImpl = new Impl29(this, windowInsets);
        } else if (i >= 28) {
            this.mImpl = new Impl28(this, windowInsets);
        } else {
            this.mImpl = new Impl21(this, windowInsets);
        }
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat(windowInsets);
        if (view != null) {
            int i = ViewCompat.$r8$clinit;
            if (ViewCompat.Api19Impl.isAttachedToWindow(view)) {
                WindowInsetsCompat rootWindowInsets = ViewCompat.Api23Impl.getRootWindowInsets(view);
                Impl impl = windowInsetsCompat.mImpl;
                impl.setRootWindowInsets(rootWindowInsets);
                impl.copyRootViewBounds(view.getRootView());
            }
        }
        return windowInsetsCompat;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return ObjectsCompat$Api19Impl.equals(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
        }
        return false;
    }

    public final int hashCode() {
        Impl impl = this.mImpl;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    public WindowInsetsCompat() {
        this.mImpl = new Impl(this);
    }
}
