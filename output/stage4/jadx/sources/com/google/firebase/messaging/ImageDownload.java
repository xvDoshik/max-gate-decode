package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.google.android.gms.tasks.zzw;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import java.util.concurrent.Future;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ImageDownload implements Closeable {
    public volatile Future future;
    public zzw task;
    public final URL url;

    public ImageDownload(URL url) {
        this.url = url;
    }

    public final Bitmap blockingDownload() throws IOException {
        String strDecode = C0000.decode(new byte[]{118, 11, 64, 7, 86, 88, 67, 7, 127, 7, 71, 74, 81, 5, 91, 12, 83}, "0b2b49", 1);
        boolean zIsLoggable = Log.isLoggable(strDecode, 4);
        URL url = this.url;
        if (zIsLoggable) {
            Objects.toString(url);
        }
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException(C0000.decode(new byte[]{112, 11, 93, 65, 7, 90, 22, 27, 41, 93, 93, 3, 71, 93, 66, 81, 26, 85, 0, 93, 87, 23, 19, 88, 3, 76, 66, 69, 12, 66, 86, 68, 92, 83, 66, 5, 82, 2, 93, 13, 4, 82}, "3d35b4b6e8", 4));
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            byte[] byteArray = Headers.Companion.toByteArray(new ByteStreams$LimitedInputStream(inputStream));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable(strDecode, 2)) {
                int length = byteArray.length;
                Objects.toString(url);
            }
            if (byteArray.length > 1048576) {
                throw new IOException(C0000.decode(new byte[]{122, 90, 0, 95, 6, 22, 6, 77, 80, 85, 87, 87, 66, 65, 91, 82, 75, 23, 18, 81, 25, 83, 67, 90, 85, 16, 3, 3, 5, 89, 3, 4, 5}, "37a8c6c530231a63", 0.0f));
            }
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            if (bitmapDecodeByteArray != null) {
                if (Log.isLoggable(strDecode, 3)) {
                    Objects.toString(url);
                }
                return bitmapDecodeByteArray;
            }
            throw new IOException(C0000.decode(new byte[]{112, 87, 94, 90, 85, 1, 17, 69, 86, 23, 83, 80, 85, 89, 82, 83, 23, 95, 93, 4, 86, 84, 3, 23}, "66760e11977566") + url);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.future.cancel(true);
    }
}
