package okhttp3.internal.platform;

import android.util.Log;
import androidx.work.impl.AutoMigration_14_15;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.text.CharsKt;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.platform.android.AndroidLogHandler;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.TrustRootIndex;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class Platform {
    public static final Logger logger;
    public static volatile Platform platform;

    /* JADX WARN: Code duplicated, block: B:25:0x0070 A[PHI: r0
      0x0070: PHI (r0v32 okhttp3.internal.platform.Platform) = 
      (r0v15 okhttp3.internal.platform.Platform)
      (r0v17 okhttp3.internal.platform.Platform)
      (r0v22 okhttp3.internal.platform.Platform)
      (r0v26 okhttp3.internal.platform.Platform)
      (r0v30 okhttp3.internal.platform.Platform)
      (r0v41 okhttp3.internal.platform.Platform)
     binds: [B:54:0x0110, B:66:0x01f0, B:48:0x0101, B:40:0x00d0, B:32:0x009f, B:21:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:47:0x0100  */
    /* JADX WARN: Code duplicated, block: B:50:0x0105  */
    /* JADX WARN: Code duplicated, block: B:52:0x0109  */
    /* JADX WARN: Code duplicated, block: B:53:0x010f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0114  */
    /* JADX WARN: Code duplicated, block: B:61:0x0146  */
    /* JADX WARN: Code duplicated, block: B:66:0x01f0  */
    static {
        Platform platform2;
        Platform jdk8WithJettyBootPlatform = null;
        if (AutoMigration_14_15.isAndroid()) {
            for (Map.Entry entry : AndroidLog.knownLoggers.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                Logger logger2 = Logger.getLogger(str);
                if (AndroidLog.configuredLoggers.add(logger2)) {
                    logger2.setUseParentHandlers(false);
                    logger2.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
                    logger2.addHandler(AndroidLogHandler.INSTANCE);
                }
            }
            platform2 = Android10Platform.isSupported ? new Android10Platform() : null;
            if (platform2 != null) {
                jdk8WithJettyBootPlatform = platform2;
            } else if (AndroidPlatform.isSupported) {
                jdk8WithJettyBootPlatform = new AndroidPlatform();
            }
        } else if (C0000.decode(new byte[]{115, 90, 10, 18, 81, 74, 72, 64, 76}, "05da2810869e", false).equals(Security.getProviders()[0].getName())) {
            platform2 = ConscryptPlatform.isSupported ? new ConscryptPlatform() : null;
            if (platform2 != null) {
                jdk8WithJettyBootPlatform = platform2;
            } else if (!C0000.decode(new byte[]{119, 112}, "53042b8e", 0.0f).equals(Security.getProviders()[0].getName())) {
                if (BouncyCastlePlatform.isSupported) {
                    platform2 = new BouncyCastlePlatform();
                } else {
                    platform2 = null;
                }
                if (platform2 != null) {
                    jdk8WithJettyBootPlatform = platform2;
                } else if (C0000.decode(new byte[]{124, 70, 81, 95, 120, 50, 100, 39}, "36412a7bf10e5e", 1).equals(Security.getProviders()[0].getName())) {
                    if (OpenJSSEPlatform.isSupported) {
                        platform2 = new OpenJSSEPlatform();
                    } else {
                        platform2 = null;
                    }
                    if (platform2 != null) {
                        jdk8WithJettyBootPlatform = platform2;
                    } else {
                        if (Jdk9Platform.isAvailable) {
                            platform2 = new Jdk9Platform();
                        } else {
                            platform2 = null;
                        }
                        if (platform2 != null) {
                            jdk8WithJettyBootPlatform = platform2;
                        } else {
                            if (Integer.parseInt(System.getProperty(C0000.decode(new byte[]{92, 4, 78, 83, 26, 75, 22, 7, 2, 10, 4, 90, 85, 86, 66, 12, 87, 92, 26, 78, 3, 16, 18, 10, 13, 93}, "6e8248fbacb367", 0.0f), C0000.decode(new byte[]{70, 89, 94, 93, 89, 66, 13}, "375365c06e4620", 0.0f))) < 9) {
                                Class<?> cls = Class.forName(C0000.decode(new byte[]{9, 71, 6, 22, 85, 7, 92, 12, 22, 70, 4, 22, 90, 1, 68, 17, 31, 27, 0, 84, 64, 10, 30, 36, 42, 101, 47}, "f5a80d0e", 0.0f), true, null);
                                jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls.getMethod(C0000.decode(new byte[]{70, 70, 68}, "630e170bfd"), SSLSocket.class, Class.forName(C0000.decode(new byte[]{94, 69, 3, 24, 84, 1, 8, 93, 71, 67, 3, 25, 14, 93, 69, 67, 29, 24, 80, 14, 20, 90, 25, 113, 42, 103, 42, 28, 97, 69, 11, 64, 88, 6, 1, 70}, "17d61bd470f7d8", 4), true, null)), cls.getMethod(C0000.decode(new byte[]{84, 0, 22}, "3eb582a8f94d34", 0.0f), SSLSocket.class), cls.getMethod(C0000.decode(new byte[]{64, 80, 15, 90, 21, 6}, "25b5cc115eb07e", 6), SSLSocket.class), Class.forName(C0000.decode(new byte[]{13, 74, 94, 31, 7, 5, 89, 81, 67, 69, 82, 76, 83, 82, 22, 76, 64, 31, 3, 10, 69, 86, 29, 119, 123, 50, 119, 19, 33, 84, 80, 84, 12, 18, 101, 74, 92, 64, 94, 6, 92, 69}, "b891bf58367b97", 0.0f), true, null), Class.forName(C0000.decode(new byte[]{86, 19, 86, 79, 4, 6, 93, 81, 64, 75, 3, 76, 83, 1, 23, 64, 64, 79, 80, 13, 17, 11, 31, 121, 124, 104, 40, 70, 106, 1, 17, 66, 92, 19, 97, 19, 14, 19, 88, 92, 85, 74}, "9a1aae1808fb9dc4", false), true, null));
                            }
                            if (jdk8WithJettyBootPlatform == null) {
                                platform2 = new Platform();
                                jdk8WithJettyBootPlatform = platform2;
                            }
                        }
                    }
                } else {
                    if (Jdk9Platform.isAvailable) {
                        platform2 = new Jdk9Platform();
                    } else {
                        platform2 = null;
                    }
                    if (platform2 != null) {
                        jdk8WithJettyBootPlatform = platform2;
                    } else {
                        if (Integer.parseInt(System.getProperty(C0000.decode(new byte[]{92, 4, 78, 83, 26, 75, 22, 7, 2, 10, 4, 90, 85, 86, 66, 12, 87, 92, 26, 78, 3, 16, 18, 10, 13, 93}, "6e8248fbacb367", 0.0f), C0000.decode(new byte[]{70, 89, 94, 93, 89, 66, 13}, "375365c06e4620", 0.0f))) < 9) {
                            Class<?> cls2 = Class.forName(C0000.decode(new byte[]{9, 71, 6, 22, 85, 7, 92, 12, 22, 70, 4, 22, 90, 1, 68, 17, 31, 27, 0, 84, 64, 10, 30, 36, 42, 101, 47}, "f5a80d0e", 0.0f), true, null);
                            jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls2.getMethod(C0000.decode(new byte[]{70, 70, 68}, "630e170bfd"), SSLSocket.class, Class.forName(C0000.decode(new byte[]{94, 69, 3, 24, 84, 1, 8, 93, 71, 67, 3, 25, 14, 93, 69, 67, 29, 24, 80, 14, 20, 90, 25, 113, 42, 103, 42, 28, 97, 69, 11, 64, 88, 6, 1, 70}, "17d61bd470f7d8", 4), true, null)), cls2.getMethod(C0000.decode(new byte[]{84, 0, 22}, "3eb582a8f94d34", 0.0f), SSLSocket.class), cls2.getMethod(C0000.decode(new byte[]{64, 80, 15, 90, 21, 6}, "25b5cc115eb07e", 6), SSLSocket.class), Class.forName(C0000.decode(new byte[]{13, 74, 94, 31, 7, 5, 89, 81, 67, 69, 82, 76, 83, 82, 22, 76, 64, 31, 3, 10, 69, 86, 29, 119, 123, 50, 119, 19, 33, 84, 80, 84, 12, 18, 101, 74, 92, 64, 94, 6, 92, 69}, "b891bf58367b97", 0.0f), true, null), Class.forName(C0000.decode(new byte[]{86, 19, 86, 79, 4, 6, 93, 81, 64, 75, 3, 76, 83, 1, 23, 64, 64, 79, 80, 13, 17, 11, 31, 121, 124, 104, 40, 70, 106, 1, 17, 66, 92, 19, 97, 19, 14, 19, 88, 92, 85, 74}, "9a1aae1808fb9dc4", false), true, null));
                        }
                        if (jdk8WithJettyBootPlatform == null) {
                            platform2 = new Platform();
                            jdk8WithJettyBootPlatform = platform2;
                        }
                    }
                }
            } else if (C0000.decode(new byte[]{124, 70, 81, 95, 120, 50, 100, 39}, "36412a7bf10e5e", 1).equals(Security.getProviders()[0].getName())) {
                if (Jdk9Platform.isAvailable) {
                    platform2 = new Jdk9Platform();
                } else {
                    platform2 = null;
                }
                if (platform2 != null) {
                    jdk8WithJettyBootPlatform = platform2;
                } else {
                    if (Integer.parseInt(System.getProperty(C0000.decode(new byte[]{92, 4, 78, 83, 26, 75, 22, 7, 2, 10, 4, 90, 85, 86, 66, 12, 87, 92, 26, 78, 3, 16, 18, 10, 13, 93}, "6e8248fbacb367", 0.0f), C0000.decode(new byte[]{70, 89, 94, 93, 89, 66, 13}, "375365c06e4620", 0.0f))) < 9) {
                        Class<?> cls3 = Class.forName(C0000.decode(new byte[]{9, 71, 6, 22, 85, 7, 92, 12, 22, 70, 4, 22, 90, 1, 68, 17, 31, 27, 0, 84, 64, 10, 30, 36, 42, 101, 47}, "f5a80d0e", 0.0f), true, null);
                        jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls3.getMethod(C0000.decode(new byte[]{70, 70, 68}, "630e170bfd"), SSLSocket.class, Class.forName(C0000.decode(new byte[]{94, 69, 3, 24, 84, 1, 8, 93, 71, 67, 3, 25, 14, 93, 69, 67, 29, 24, 80, 14, 20, 90, 25, 113, 42, 103, 42, 28, 97, 69, 11, 64, 88, 6, 1, 70}, "17d61bd470f7d8", 4), true, null)), cls3.getMethod(C0000.decode(new byte[]{84, 0, 22}, "3eb582a8f94d34", 0.0f), SSLSocket.class), cls3.getMethod(C0000.decode(new byte[]{64, 80, 15, 90, 21, 6}, "25b5cc115eb07e", 6), SSLSocket.class), Class.forName(C0000.decode(new byte[]{13, 74, 94, 31, 7, 5, 89, 81, 67, 69, 82, 76, 83, 82, 22, 76, 64, 31, 3, 10, 69, 86, 29, 119, 123, 50, 119, 19, 33, 84, 80, 84, 12, 18, 101, 74, 92, 64, 94, 6, 92, 69}, "b891bf58367b97", 0.0f), true, null), Class.forName(C0000.decode(new byte[]{86, 19, 86, 79, 4, 6, 93, 81, 64, 75, 3, 76, 83, 1, 23, 64, 64, 79, 80, 13, 17, 11, 31, 121, 124, 104, 40, 70, 106, 1, 17, 66, 92, 19, 97, 19, 14, 19, 88, 92, 85, 74}, "9a1aae1808fb9dc4", false), true, null));
                    }
                    if (jdk8WithJettyBootPlatform == null) {
                        platform2 = new Platform();
                        jdk8WithJettyBootPlatform = platform2;
                    }
                }
            } else {
                if (OpenJSSEPlatform.isSupported) {
                    platform2 = new OpenJSSEPlatform();
                } else {
                    platform2 = null;
                }
                if (platform2 != null) {
                    jdk8WithJettyBootPlatform = platform2;
                } else {
                    if (Jdk9Platform.isAvailable) {
                        platform2 = new Jdk9Platform();
                    } else {
                        platform2 = null;
                    }
                    if (platform2 != null) {
                        jdk8WithJettyBootPlatform = platform2;
                    } else {
                        if (Integer.parseInt(System.getProperty(C0000.decode(new byte[]{92, 4, 78, 83, 26, 75, 22, 7, 2, 10, 4, 90, 85, 86, 66, 12, 87, 92, 26, 78, 3, 16, 18, 10, 13, 93}, "6e8248fbacb367", 0.0f), C0000.decode(new byte[]{70, 89, 94, 93, 89, 66, 13}, "375365c06e4620", 0.0f))) < 9) {
                            Class<?> cls4 = Class.forName(C0000.decode(new byte[]{9, 71, 6, 22, 85, 7, 92, 12, 22, 70, 4, 22, 90, 1, 68, 17, 31, 27, 0, 84, 64, 10, 30, 36, 42, 101, 47}, "f5a80d0e", 0.0f), true, null);
                            jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls4.getMethod(C0000.decode(new byte[]{70, 70, 68}, "630e170bfd"), SSLSocket.class, Class.forName(C0000.decode(new byte[]{94, 69, 3, 24, 84, 1, 8, 93, 71, 67, 3, 25, 14, 93, 69, 67, 29, 24, 80, 14, 20, 90, 25, 113, 42, 103, 42, 28, 97, 69, 11, 64, 88, 6, 1, 70}, "17d61bd470f7d8", 4), true, null)), cls4.getMethod(C0000.decode(new byte[]{84, 0, 22}, "3eb582a8f94d34", 0.0f), SSLSocket.class), cls4.getMethod(C0000.decode(new byte[]{64, 80, 15, 90, 21, 6}, "25b5cc115eb07e", 6), SSLSocket.class), Class.forName(C0000.decode(new byte[]{13, 74, 94, 31, 7, 5, 89, 81, 67, 69, 82, 76, 83, 82, 22, 76, 64, 31, 3, 10, 69, 86, 29, 119, 123, 50, 119, 19, 33, 84, 80, 84, 12, 18, 101, 74, 92, 64, 94, 6, 92, 69}, "b891bf58367b97", 0.0f), true, null), Class.forName(C0000.decode(new byte[]{86, 19, 86, 79, 4, 6, 93, 81, 64, 75, 3, 76, 83, 1, 23, 64, 64, 79, 80, 13, 17, 11, 31, 121, 124, 104, 40, 70, 106, 1, 17, 66, 92, 19, 97, 19, 14, 19, 88, 92, 85, 74}, "9a1aae1808fb9dc4", false), true, null));
                        }
                        if (jdk8WithJettyBootPlatform == null) {
                            platform2 = new Platform();
                            jdk8WithJettyBootPlatform = platform2;
                        }
                    }
                }
            }
        } else if (!C0000.decode(new byte[]{119, 112}, "53042b8e", 0.0f).equals(Security.getProviders()[0].getName())) {
            if (BouncyCastlePlatform.isSupported) {
                platform2 = new BouncyCastlePlatform();
            } else {
                platform2 = null;
            }
            if (platform2 != null) {
                jdk8WithJettyBootPlatform = platform2;
            } else if (C0000.decode(new byte[]{124, 70, 81, 95, 120, 50, 100, 39}, "36412a7bf10e5e", 1).equals(Security.getProviders()[0].getName())) {
                if (Jdk9Platform.isAvailable) {
                    platform2 = new Jdk9Platform();
                } else {
                    platform2 = null;
                }
                if (platform2 != null) {
                    jdk8WithJettyBootPlatform = platform2;
                } else {
                    if (Integer.parseInt(System.getProperty(C0000.decode(new byte[]{92, 4, 78, 83, 26, 75, 22, 7, 2, 10, 4, 90, 85, 86, 66, 12, 87, 92, 26, 78, 3, 16, 18, 10, 13, 93}, "6e8248fbacb367", 0.0f), C0000.decode(new byte[]{70, 89, 94, 93, 89, 66, 13}, "375365c06e4620", 0.0f))) < 9) {
                        Class<?> cls5 = Class.forName(C0000.decode(new byte[]{9, 71, 6, 22, 85, 7, 92, 12, 22, 70, 4, 22, 90, 1, 68, 17, 31, 27, 0, 84, 64, 10, 30, 36, 42, 101, 47}, "f5a80d0e", 0.0f), true, null);
                        jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls5.getMethod(C0000.decode(new byte[]{70, 70, 68}, "630e170bfd"), SSLSocket.class, Class.forName(C0000.decode(new byte[]{94, 69, 3, 24, 84, 1, 8, 93, 71, 67, 3, 25, 14, 93, 69, 67, 29, 24, 80, 14, 20, 90, 25, 113, 42, 103, 42, 28, 97, 69, 11, 64, 88, 6, 1, 70}, "17d61bd470f7d8", 4), true, null)), cls5.getMethod(C0000.decode(new byte[]{84, 0, 22}, "3eb582a8f94d34", 0.0f), SSLSocket.class), cls5.getMethod(C0000.decode(new byte[]{64, 80, 15, 90, 21, 6}, "25b5cc115eb07e", 6), SSLSocket.class), Class.forName(C0000.decode(new byte[]{13, 74, 94, 31, 7, 5, 89, 81, 67, 69, 82, 76, 83, 82, 22, 76, 64, 31, 3, 10, 69, 86, 29, 119, 123, 50, 119, 19, 33, 84, 80, 84, 12, 18, 101, 74, 92, 64, 94, 6, 92, 69}, "b891bf58367b97", 0.0f), true, null), Class.forName(C0000.decode(new byte[]{86, 19, 86, 79, 4, 6, 93, 81, 64, 75, 3, 76, 83, 1, 23, 64, 64, 79, 80, 13, 17, 11, 31, 121, 124, 104, 40, 70, 106, 1, 17, 66, 92, 19, 97, 19, 14, 19, 88, 92, 85, 74}, "9a1aae1808fb9dc4", false), true, null));
                    }
                    if (jdk8WithJettyBootPlatform == null) {
                        platform2 = new Platform();
                        jdk8WithJettyBootPlatform = platform2;
                    }
                }
            } else {
                if (OpenJSSEPlatform.isSupported) {
                    platform2 = new OpenJSSEPlatform();
                } else {
                    platform2 = null;
                }
                if (platform2 != null) {
                    jdk8WithJettyBootPlatform = platform2;
                } else {
                    if (Jdk9Platform.isAvailable) {
                        platform2 = new Jdk9Platform();
                    } else {
                        platform2 = null;
                    }
                    if (platform2 != null) {
                        jdk8WithJettyBootPlatform = platform2;
                    } else {
                        if (Integer.parseInt(System.getProperty(C0000.decode(new byte[]{92, 4, 78, 83, 26, 75, 22, 7, 2, 10, 4, 90, 85, 86, 66, 12, 87, 92, 26, 78, 3, 16, 18, 10, 13, 93}, "6e8248fbacb367", 0.0f), C0000.decode(new byte[]{70, 89, 94, 93, 89, 66, 13}, "375365c06e4620", 0.0f))) < 9) {
                            Class<?> cls6 = Class.forName(C0000.decode(new byte[]{9, 71, 6, 22, 85, 7, 92, 12, 22, 70, 4, 22, 90, 1, 68, 17, 31, 27, 0, 84, 64, 10, 30, 36, 42, 101, 47}, "f5a80d0e", 0.0f), true, null);
                            jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls6.getMethod(C0000.decode(new byte[]{70, 70, 68}, "630e170bfd"), SSLSocket.class, Class.forName(C0000.decode(new byte[]{94, 69, 3, 24, 84, 1, 8, 93, 71, 67, 3, 25, 14, 93, 69, 67, 29, 24, 80, 14, 20, 90, 25, 113, 42, 103, 42, 28, 97, 69, 11, 64, 88, 6, 1, 70}, "17d61bd470f7d8", 4), true, null)), cls6.getMethod(C0000.decode(new byte[]{84, 0, 22}, "3eb582a8f94d34", 0.0f), SSLSocket.class), cls6.getMethod(C0000.decode(new byte[]{64, 80, 15, 90, 21, 6}, "25b5cc115eb07e", 6), SSLSocket.class), Class.forName(C0000.decode(new byte[]{13, 74, 94, 31, 7, 5, 89, 81, 67, 69, 82, 76, 83, 82, 22, 76, 64, 31, 3, 10, 69, 86, 29, 119, 123, 50, 119, 19, 33, 84, 80, 84, 12, 18, 101, 74, 92, 64, 94, 6, 92, 69}, "b891bf58367b97", 0.0f), true, null), Class.forName(C0000.decode(new byte[]{86, 19, 86, 79, 4, 6, 93, 81, 64, 75, 3, 76, 83, 1, 23, 64, 64, 79, 80, 13, 17, 11, 31, 121, 124, 104, 40, 70, 106, 1, 17, 66, 92, 19, 97, 19, 14, 19, 88, 92, 85, 74}, "9a1aae1808fb9dc4", false), true, null));
                        }
                        if (jdk8WithJettyBootPlatform == null) {
                            platform2 = new Platform();
                            jdk8WithJettyBootPlatform = platform2;
                        }
                    }
                }
            }
        } else if (C0000.decode(new byte[]{124, 70, 81, 95, 120, 50, 100, 39}, "36412a7bf10e5e", 1).equals(Security.getProviders()[0].getName())) {
            if (Jdk9Platform.isAvailable) {
                platform2 = new Jdk9Platform();
            } else {
                platform2 = null;
            }
            if (platform2 != null) {
                jdk8WithJettyBootPlatform = platform2;
            } else {
                try {
                    if (Integer.parseInt(System.getProperty(C0000.decode(new byte[]{92, 4, 78, 83, 26, 75, 22, 7, 2, 10, 4, 90, 85, 86, 66, 12, 87, 92, 26, 78, 3, 16, 18, 10, 13, 93}, "6e8248fbacb367", 0.0f), C0000.decode(new byte[]{70, 89, 94, 93, 89, 66, 13}, "375365c06e4620", 0.0f))) < 9) {
                        try {
                            Class<?> cls7 = Class.forName(C0000.decode(new byte[]{9, 71, 6, 22, 85, 7, 92, 12, 22, 70, 4, 22, 90, 1, 68, 17, 31, 27, 0, 84, 64, 10, 30, 36, 42, 101, 47}, "f5a80d0e", 0.0f), true, null);
                            jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls7.getMethod(C0000.decode(new byte[]{70, 70, 68}, "630e170bfd"), SSLSocket.class, Class.forName(C0000.decode(new byte[]{94, 69, 3, 24, 84, 1, 8, 93, 71, 67, 3, 25, 14, 93, 69, 67, 29, 24, 80, 14, 20, 90, 25, 113, 42, 103, 42, 28, 97, 69, 11, 64, 88, 6, 1, 70}, "17d61bd470f7d8", 4), true, null)), cls7.getMethod(C0000.decode(new byte[]{84, 0, 22}, "3eb582a8f94d34", 0.0f), SSLSocket.class), cls7.getMethod(C0000.decode(new byte[]{64, 80, 15, 90, 21, 6}, "25b5cc115eb07e", 6), SSLSocket.class), Class.forName(C0000.decode(new byte[]{13, 74, 94, 31, 7, 5, 89, 81, 67, 69, 82, 76, 83, 82, 22, 76, 64, 31, 3, 10, 69, 86, 29, 119, 123, 50, 119, 19, 33, 84, 80, 84, 12, 18, 101, 74, 92, 64, 94, 6, 92, 69}, "b891bf58367b97", 0.0f), true, null), Class.forName(C0000.decode(new byte[]{86, 19, 86, 79, 4, 6, 93, 81, 64, 75, 3, 76, 83, 1, 23, 64, 64, 79, 80, 13, 17, 11, 31, 121, 124, 104, 40, 70, 106, 1, 17, 66, 92, 19, 97, 19, 14, 19, 88, 92, 85, 74}, "9a1aae1808fb9dc4", false), true, null));
                        } catch (ClassNotFoundException | NoSuchMethodException unused) {
                        }
                    }
                } catch (NumberFormatException unused2) {
                }
                if (jdk8WithJettyBootPlatform == null) {
                    platform2 = new Platform();
                    jdk8WithJettyBootPlatform = platform2;
                }
            }
        } else {
            if (OpenJSSEPlatform.isSupported) {
                platform2 = new OpenJSSEPlatform();
            } else {
                platform2 = null;
            }
            if (platform2 != null) {
                jdk8WithJettyBootPlatform = platform2;
            } else {
                if (Jdk9Platform.isAvailable) {
                    platform2 = new Jdk9Platform();
                } else {
                    platform2 = null;
                }
                if (platform2 != null) {
                    jdk8WithJettyBootPlatform = platform2;
                } else {
                    if (Integer.parseInt(System.getProperty(C0000.decode(new byte[]{92, 4, 78, 83, 26, 75, 22, 7, 2, 10, 4, 90, 85, 86, 66, 12, 87, 92, 26, 78, 3, 16, 18, 10, 13, 93}, "6e8248fbacb367", 0.0f), C0000.decode(new byte[]{70, 89, 94, 93, 89, 66, 13}, "375365c06e4620", 0.0f))) < 9) {
                        Class<?> cls8 = Class.forName(C0000.decode(new byte[]{9, 71, 6, 22, 85, 7, 92, 12, 22, 70, 4, 22, 90, 1, 68, 17, 31, 27, 0, 84, 64, 10, 30, 36, 42, 101, 47}, "f5a80d0e", 0.0f), true, null);
                        jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls8.getMethod(C0000.decode(new byte[]{70, 70, 68}, "630e170bfd"), SSLSocket.class, Class.forName(C0000.decode(new byte[]{94, 69, 3, 24, 84, 1, 8, 93, 71, 67, 3, 25, 14, 93, 69, 67, 29, 24, 80, 14, 20, 90, 25, 113, 42, 103, 42, 28, 97, 69, 11, 64, 88, 6, 1, 70}, "17d61bd470f7d8", 4), true, null)), cls8.getMethod(C0000.decode(new byte[]{84, 0, 22}, "3eb582a8f94d34", 0.0f), SSLSocket.class), cls8.getMethod(C0000.decode(new byte[]{64, 80, 15, 90, 21, 6}, "25b5cc115eb07e", 6), SSLSocket.class), Class.forName(C0000.decode(new byte[]{13, 74, 94, 31, 7, 5, 89, 81, 67, 69, 82, 76, 83, 82, 22, 76, 64, 31, 3, 10, 69, 86, 29, 119, 123, 50, 119, 19, 33, 84, 80, 84, 12, 18, 101, 74, 92, 64, 94, 6, 92, 69}, "b891bf58367b97", 0.0f), true, null), Class.forName(C0000.decode(new byte[]{86, 19, 86, 79, 4, 6, 93, 81, 64, 75, 3, 76, 83, 1, 23, 64, 64, 79, 80, 13, 17, 11, 31, 121, 124, 104, 40, 70, 106, 1, 17, 66, 92, 19, 97, 19, 14, 19, 88, 92, 85, 74}, "9a1aae1808fb9dc4", false), true, null));
                    }
                    if (jdk8WithJettyBootPlatform == null) {
                        platform2 = new Platform();
                        jdk8WithJettyBootPlatform = platform2;
                    }
                }
            }
        }
        platform = jdk8WithJettyBootPlatform;
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static void log(String str, int i, Throwable th) {
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public CharsKt buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public Object getStackTraceForCloseable() {
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(C0000.decode(new byte[]{23, 87, 69, 19, 92, 12, 17, 3, 25, 7, 13, 93, 74, 29, 76, 31, 6, 94, 89, 16, 86, 74, 75}, "e26c3bbf7eb935e1", 0.0f));
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        return true;
    }

    public void logCloseableLeak(Object obj, String str) {
        if (obj == null) {
            str = str.concat(C0000.decode(new byte[]{25, 99, 88, 25, 66, 83, 3, 68, 22, 91, 92, 69, 82, 25, 69, 94, 15, 23, 65, 68, 88, 68, 23, 88, 93, 90, 9, 7, 0, 71, 92, 83, 27, 25, 66, 83, 18, 68, 21, 91, 92, 23, 120, 82, 121, 66, 18, 20, 34, 95, 80, 82, 89, 77, 17, 90, 9, 3, 6, 86, 75, 23, 91, 92, 71, 83, 10, 68, 21, 92, 25, 113, 126, 119, 116, 12, 70, 40, 14, 84, 94, 82, 69, 23, 86, 83, 18, 40, 14, 84, 94, 82, 69, 17, 126, 93, 46, 16, 21, 67, 122, 91, 94, 92, 95, 66, 72, 7, 13, 82, 74, 68, 25, 94, 84, 66, 40, 5, 12, 86, 17, 30, 30, 23, 66, 83, 18, 40, 4, 69, 92, 91, 31, 117, 84, 64, 3, 8, 79, 117, 112, 121, 114, 16, 10}, "977916fda3", true));
        }
        log(str, 5, (Throwable) obj);
    }

    public SSLContext newSSLContext() {
        return SSLContext.getInstance(C0000.decode(new byte[]{97, 47, 54}, "5cef9b8ac2", true));
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContextNewSSLContext = newSSLContext();
            sSLContextNewSSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextNewSSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError(C0000.decode(new byte[]{119, 86, 21, 48, 64, 23, 77, 92, 89, 17, 99, 124, 106, 3, 21}, "995c9d994170") + e, e);
        }
    }

    public X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        throw new IllegalStateException(C0000.decode(new byte[]{103, 93, 1, 28, 68, 7, 83, 21, 87, 87, 68, 0, 81, 4, 81, 20, 94, 71, 68, 16, 70, 23, 67, 21, 18, 94, 5, 10, 85, 5, 85, 19, 65, 9, 68}, "23dd4b0a", 0.0f).concat(Arrays.toString(trustManagers)).toString());
    }

    public final String toString() {
        return getClass().getSimpleName();
    }
}
