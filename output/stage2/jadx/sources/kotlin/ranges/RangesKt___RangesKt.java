package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0007\u001a\f\u0010\u0000\u001a\u00020\u0005*\u00020\u0006H\u0007\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\b\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u00020\u0004H\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0007¢\u0006\u0002\u0010\n\u001a\f\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u000b\u001a\u00020\u0003*\u00020\u0004H\u0007\u001a\f\u0010\u000b\u001a\u00020\u0005*\u00020\u0006H\u0007\u001a\u0013\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\b\u001a\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003*\u00020\u0004H\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0007¢\u0006\u0002\u0010\n\u001a\r\u0010\r\u001a\u00020\u0001*\u00020\u000eH\u0087\b\u001a\r\u0010\r\u001a\u00020\u0003*\u00020\u000fH\u0087\b\u001a\r\u0010\r\u001a\u00020\u0005*\u00020\u0010H\u0087\b\u001a\u0014\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\r\u001a\u00020\u0003*\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\r\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\r\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u000eH\u0087\b¢\u0006\u0002\u0010\u0013\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0003*\u00020\u000fH\u0087\b¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0005*\u00020\u0010H\u0087\b¢\u0006\u0002\u0010\u0015\u001a\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0016\u001a\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u0003*\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0017\u001a\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u0005*\u00020\u00102\u0006\u0010\r\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\u00020\u001a*\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0087\n¢\u0006\u0002\u0010\u001c\u001a\u001c\u0010\u0019\u001a\u00020\u001a*\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0087\n¢\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u0019\u001a\u00020\u001a*\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0087\n¢\u0006\u0002\u0010\u001e\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0087\u0002¢\u0006\u0002\b\"\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020!H\u0087\u0002¢\u0006\u0002\b#\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020$0\u001f2\u0006\u0010 \u001a\u00020!H\u0087\u0002¢\u0006\u0002\b%\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020&0\u001f2\u0006\u0010 \u001a\u00020!H\u0087\u0002¢\u0006\u0002\b'\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020(0\u001f2\u0006\u0010 \u001a\u00020!H\u0087\u0002¢\u0006\u0002\b)\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00010*2\u0006\u0010 \u001a\u00020!H\u0087\u0002¢\u0006\u0002\b\"\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00030*2\u0006\u0010 \u001a\u00020!H\u0087\u0002¢\u0006\u0002\b#\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020$0*2\u0006\u0010 \u001a\u00020!H\u0087\u0002¢\u0006\u0002\b%\u001a\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0087\n\u001a\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0087\n\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00010\u001f2\u0006\u0010 \u001a\u00020&H\u0087\u0002¢\u0006\u0002\b\"\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020&H\u0087\u0002¢\u0006\u0002\b#\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010 \u001a\u00020&H\u0087\u0002¢\u0006\u0002\b+\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020$0\u001f2\u0006\u0010 \u001a\u00020&H\u0087\u0002¢\u0006\u0002\b%\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020(0\u001f2\u0006\u0010 \u001a\u00020&H\u0087\u0002¢\u0006\u0002\b)\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00010\u001f2\u0006\u0010 \u001a\u00020(H\u0087\u0002¢\u0006\u0002\b\"\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020(H\u0087\u0002¢\u0006\u0002\b#\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010 \u001a\u00020(H\u0087\u0002¢\u0006\u0002\b+\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020$0\u001f2\u0006\u0010 \u001a\u00020(H\u0087\u0002¢\u0006\u0002\b%\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020&0\u001f2\u0006\u0010 \u001a\u00020(H\u0087\u0002¢\u0006\u0002\b'\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020&0*2\u0006\u0010 \u001a\u00020(H\u0087\u0002¢\u0006\u0002\b'\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020\u0001H\u0087\u0002¢\u0006\u0002\b#\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010 \u001a\u00020\u0001H\u0087\u0002¢\u0006\u0002\b+\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020$0\u001f2\u0006\u0010 \u001a\u00020\u0001H\u0087\u0002¢\u0006\u0002\b%\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020&0\u001f2\u0006\u0010 \u001a\u00020\u0001H\u0087\u0002¢\u0006\u0002\b'\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020(0\u001f2\u0006\u0010 \u001a\u00020\u0001H\u0087\u0002¢\u0006\u0002\b)\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00030*2\u0006\u0010 \u001a\u00020\u0001H\u0087\u0002¢\u0006\u0002\b#\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020!0*2\u0006\u0010 \u001a\u00020\u0001H\u0087\u0002¢\u0006\u0002\b+\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020$0*2\u0006\u0010 \u001a\u00020\u0001H\u0087\u0002¢\u0006\u0002\b%\u001a\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0001H\u0087\n\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00010\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b\"\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b+\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020$0\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b%\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020&0\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b'\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020(0\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b)\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00010*2\u0006\u0010 \u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b\"\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020!0*2\u0006\u0010 \u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b+\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020$0*2\u0006\u0010 \u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b%\u001a\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u000e2\u0006\u0010 \u001a\u00020\u0003H\u0087\n\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00010\u001f2\u0006\u0010 \u001a\u00020$H\u0087\u0002¢\u0006\u0002\b\"\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020$H\u0087\u0002¢\u0006\u0002\b#\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010 \u001a\u00020$H\u0087\u0002¢\u0006\u0002\b+\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020&0\u001f2\u0006\u0010 \u001a\u00020$H\u0087\u0002¢\u0006\u0002\b'\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020(0\u001f2\u0006\u0010 \u001a\u00020$H\u0087\u0002¢\u0006\u0002\b)\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00010*2\u0006\u0010 \u001a\u00020$H\u0087\u0002¢\u0006\u0002\b\"\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00030*2\u0006\u0010 \u001a\u00020$H\u0087\u0002¢\u0006\u0002\b#\u001a \u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020!0*2\u0006\u0010 \u001a\u00020$H\u0087\u0002¢\u0006\u0002\b+\u001a\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u000e2\u0006\u0010 \u001a\u00020$H\u0087\n\u001a\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u000f2\u0006\u0010 \u001a\u00020$H\u0087\n\u001a\u0015\u0010,\u001a\u00020\u0002*\u00020\u00012\u0006\u0010-\u001a\u00020!H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0004*\u00020\u00032\u0006\u0010-\u001a\u00020!H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0002*\u00020!2\u0006\u0010-\u001a\u00020!H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0002*\u00020$2\u0006\u0010-\u001a\u00020!H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0006*\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0002*\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0004*\u00020\u00032\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0002*\u00020!2\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0002*\u00020$2\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0004*\u00020\u00012\u0006\u0010-\u001a\u00020\u0003H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0004*\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0004*\u00020!2\u0006\u0010-\u001a\u00020\u0003H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0004*\u00020$2\u0006\u0010-\u001a\u00020\u0003H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0002*\u00020\u00012\u0006\u0010-\u001a\u00020$H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0004*\u00020\u00032\u0006\u0010-\u001a\u00020$H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0002*\u00020!2\u0006\u0010-\u001a\u00020$H\u0086\u0004\u001a\u0015\u0010,\u001a\u00020\u0002*\u00020$2\u0006\u0010-\u001a\u00020$H\u0086\u0004\u001a\n\u0010.\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010.\u001a\u00020\u0004*\u00020\u0004\u001a\n\u0010.\u001a\u00020\u0006*\u00020\u0006\u001a\u0015\u0010/\u001a\u00020\u0002*\u00020\u00022\u0006\u0010/\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00042\u0006\u0010/\u001a\u00020\u0003H\u0086\u0004\u001a\u0015\u0010/\u001a\u00020\u0006*\u00020\u00062\u0006\u0010/\u001a\u00020\u0001H\u0086\u0004\u001a\u0013\u00100\u001a\u0004\u0018\u00010!*\u00020\u0001H\u0000¢\u0006\u0002\u00101\u001a\u0013\u00100\u001a\u0004\u0018\u00010!*\u00020\u0003H\u0000¢\u0006\u0002\u00102\u001a\u0013\u00100\u001a\u0004\u0018\u00010!*\u00020$H\u0000¢\u0006\u0002\u00103\u001a\u0013\u00100\u001a\u0004\u0018\u00010!*\u00020&H\u0000¢\u0006\u0002\u00104\u001a\u0013\u00100\u001a\u0004\u0018\u00010!*\u00020(H\u0000¢\u0006\u0002\u00105\u001a\u0013\u00106\u001a\u0004\u0018\u00010\u0001*\u00020\u0003H\u0000¢\u0006\u0002\u00107\u001a\u0013\u00106\u001a\u0004\u0018\u00010\u0001*\u00020&H\u0000¢\u0006\u0002\u00108\u001a\u0013\u00106\u001a\u0004\u0018\u00010\u0001*\u00020(H\u0000¢\u0006\u0002\u00109\u001a\u0013\u0010:\u001a\u0004\u0018\u00010\u0003*\u00020&H\u0000¢\u0006\u0002\u0010;\u001a\u0013\u0010:\u001a\u0004\u0018\u00010\u0003*\u00020(H\u0000¢\u0006\u0002\u0010<\u001a\u0013\u0010=\u001a\u0004\u0018\u00010$*\u00020\u0001H\u0000¢\u0006\u0002\u0010>\u001a\u0013\u0010=\u001a\u0004\u0018\u00010$*\u00020\u0003H\u0000¢\u0006\u0002\u0010?\u001a\u0013\u0010=\u001a\u0004\u0018\u00010$*\u00020&H\u0000¢\u0006\u0002\u0010@\u001a\u0013\u0010=\u001a\u0004\u0018\u00010$*\u00020(H\u0000¢\u0006\u0002\u0010A\u001a\u0015\u0010B\u001a\u00020\u000e*\u00020\u00012\u0006\u0010-\u001a\u00020!H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000f*\u00020\u00032\u0006\u0010-\u001a\u00020!H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000e*\u00020!2\u0006\u0010-\u001a\u00020!H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000e*\u00020$2\u0006\u0010-\u001a\u00020!H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u0010*\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000e*\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000f*\u00020\u00032\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000e*\u00020!2\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000e*\u00020$2\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000f*\u00020\u00012\u0006\u0010-\u001a\u00020\u0003H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000f*\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000f*\u00020!2\u0006\u0010-\u001a\u00020\u0003H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000f*\u00020$2\u0006\u0010-\u001a\u00020\u0003H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000e*\u00020\u00012\u0006\u0010-\u001a\u00020$H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000f*\u00020\u00032\u0006\u0010-\u001a\u00020$H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000e*\u00020!2\u0006\u0010-\u001a\u00020$H\u0086\u0004\u001a\u0015\u0010B\u001a\u00020\u000e*\u00020$2\u0006\u0010-\u001a\u00020$H\u0086\u0004\u001a'\u0010C\u001a\u0002HD\"\u000e\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E*\u0002HD2\u0006\u0010F\u001a\u0002HD¢\u0006\u0002\u0010G\u001a\u0012\u0010C\u001a\u00020!*\u00020!2\u0006\u0010F\u001a\u00020!\u001a\u0012\u0010C\u001a\u00020$*\u00020$2\u0006\u0010F\u001a\u00020$\u001a\u0012\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010F\u001a\u00020\u0001\u001a\u0012\u0010C\u001a\u00020\u0003*\u00020\u00032\u0006\u0010F\u001a\u00020\u0003\u001a\u0012\u0010C\u001a\u00020(*\u00020(2\u0006\u0010F\u001a\u00020(\u001a\u0012\u0010C\u001a\u00020&*\u00020&2\u0006\u0010F\u001a\u00020&\u001a'\u0010H\u001a\u0002HD\"\u000e\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E*\u0002HD2\u0006\u0010I\u001a\u0002HD¢\u0006\u0002\u0010G\u001a\u0012\u0010H\u001a\u00020!*\u00020!2\u0006\u0010I\u001a\u00020!\u001a\u0012\u0010H\u001a\u00020$*\u00020$2\u0006\u0010I\u001a\u00020$\u001a\u0012\u0010H\u001a\u00020\u0001*\u00020\u00012\u0006\u0010I\u001a\u00020\u0001\u001a\u0012\u0010H\u001a\u00020\u0003*\u00020\u00032\u0006\u0010I\u001a\u00020\u0003\u001a\u0012\u0010H\u001a\u00020(*\u00020(2\u0006\u0010I\u001a\u00020(\u001a\u0012\u0010H\u001a\u00020&*\u00020&2\u0006\u0010I\u001a\u00020&\u001a3\u0010J\u001a\u0002HD\"\u000e\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E*\u0002HD2\b\u0010F\u001a\u0004\u0018\u0001HD2\b\u0010I\u001a\u0004\u0018\u0001HD¢\u0006\u0002\u0010K\u001a\u001a\u0010J\u001a\u00020!*\u00020!2\u0006\u0010F\u001a\u00020!2\u0006\u0010I\u001a\u00020!\u001a\u001a\u0010J\u001a\u00020$*\u00020$2\u0006\u0010F\u001a\u00020$2\u0006\u0010I\u001a\u00020$\u001a\u001a\u0010J\u001a\u00020\u0001*\u00020\u00012\u0006\u0010F\u001a\u00020\u00012\u0006\u0010I\u001a\u00020\u0001\u001a\u001a\u0010J\u001a\u00020\u0003*\u00020\u00032\u0006\u0010F\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0003\u001a\u001a\u0010J\u001a\u00020(*\u00020(2\u0006\u0010F\u001a\u00020(2\u0006\u0010I\u001a\u00020(\u001a\u001a\u0010J\u001a\u00020&*\u00020&2\u0006\u0010F\u001a\u00020&2\u0006\u0010I\u001a\u00020&\u001a/\u0010J\u001a\u0002HD\"\u000e\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E*\u0002HD2\f\u0010L\u001a\b\u0012\u0004\u0012\u0002HD0MH\u0007¢\u0006\u0002\u0010N\u001a-\u0010J\u001a\u0002HD\"\u000e\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E*\u0002HD2\f\u0010L\u001a\b\u0012\u0004\u0012\u0002HD0\u001f¢\u0006\u0002\u0010O\u001a\u0018\u0010J\u001a\u00020\u0001*\u00020\u00012\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f\u001a\u0018\u0010J\u001a\u00020\u0003*\u00020\u00032\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f¨\u0006P"}, d2 = {"first", "", "Lkotlin/ranges/IntProgression;", "", "Lkotlin/ranges/LongProgression;", "", "Lkotlin/ranges/CharProgression;", "firstOrNull", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "last", "lastOrNull", "random", "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/LongRange;", "Lkotlin/ranges/CharRange;", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "contains", "", "element", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "Lkotlin/ranges/ClosedRange;", "value", "", "intRangeContains", "longRangeContains", "", "shortRangeContains", "", "doubleRangeContains", "", "floatRangeContains", "Lkotlin/ranges/OpenEndRange;", "byteRangeContains", "downTo", "to", "reversed", "step", "toByteExactOrNull", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "toIntExactOrNull", "(J)Ljava/lang/Integer;", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "until", "coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{94, 17, 11, 94, 75, 8}, "bec786f0", 4));
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(d);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{89, 64, 88, 8, 17, 6}, "e40ab89d0621", true));
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(f);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{88, 64, 95, 88, 71, 13}, "d47143d15533cab0", 6));
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(i);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{90, 66, 13, 94, 71, 14}, "f6e7403f"));
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(j);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{14, 64, 10, 95, 74, 95}, "24b69a2c"));
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(s);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean byteRangeContains(OpenEndRange<Byte> openEndRange, int i) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{10, 18, 9, 10, 16, 15}, "6facc179ad", 2));
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(i);
        if (byteExactOrNull != null) {
            return openEndRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean byteRangeContains(OpenEndRange<Byte> openEndRange, long j) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{8, 22, 95, 15, 18, 91}, "4b7faecd68", true));
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(j);
        if (byteExactOrNull != null) {
            return openEndRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean byteRangeContains(OpenEndRange<Byte> openEndRange, short s) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{10, 77, 90, 13, 23, 14}, "692dd016", false));
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(s);
        if (byteExactOrNull != null) {
            return openEndRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final byte coerceAtLeast(byte b, byte b2) {
        return b < b2 ? b2 : b;
    }

    public static final double coerceAtLeast(double d, double d2) {
        return d < d2 ? d2 : d;
    }

    public static final float coerceAtLeast(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static final int coerceAtLeast(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final long coerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static final <T extends Comparable<? super T>> T coerceAtLeast(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{89, 76, 10, 95, 69, 11}, "e8b6658d0999", 0.0f));
        Intrinsics.checkNotNullParameter(t2, C0000.decode(new byte[]{95, 94, 88, 91, 14, 19, 95, 97, 87, 94, 22, 3}, "2762cf", 6));
        return t.compareTo(t2) < 0 ? t2 : t;
    }

    public static final short coerceAtLeast(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    public static final byte coerceAtMost(byte b, byte b2) {
        return b > b2 ? b2 : b;
    }

    public static final double coerceAtMost(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    public static final float coerceAtMost(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static final int coerceAtMost(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final long coerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static final <T extends Comparable<? super T>> T coerceAtMost(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{88, 65, 10, 10, 69, 8}, "d5bc6638b4", 0.0f));
        Intrinsics.checkNotNullParameter(t2, C0000.decode(new byte[]{88, 85, 26, 8, 95, 20, 85, 102, 2, 85, 64, 81}, "54ba2a80c9", true));
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    public static final short coerceAtMost(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    public static final byte coerceIn(byte b, byte b2, byte b3) {
        if (b2 > b3) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{33, 0, 89, 95, 95, 16, 25, 91, 89, 1, 19, 87, 1, 67, 20, 0, 14, 20, 82, 17, 68, 11, 25, 89, 88, 68, 4, 89, 20, 23, 27, 65, 16, 0, 89, 86, 85, 94, 25, 85, 87, 28, 8, 89, 17, 14, 66}, "ba710d986da4dcba", 0.0f) + ((int) b3) + C0000.decode(new byte[]{67, 80, 69, 69, 84, 7, 69, 16, 67, 77, 94, 4, 86, 66, 91, 10, 13, 80, 91, 16, 85, 66}, "c96e8b6c") + ((int) b2) + '.');
        }
        if (b < b2) {
            return b2;
        }
        return b > b3 ? b3 : b;
    }

    public static final double coerceIn(double d, double d2, double d3) {
        if (d2 > d3) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{116, 5, 91, 92, 95, 65, 67, 91, 10, 85, 69, 7, 80, 18, 70, 84, 15, 77, 0, 16, 67, 11, 21, 83, 94, 21, 6, 85, 21, 68, 78, 68, 71, 83, 94, 82, 6, 2, 69, 93, 86, 28, 92, 95, 69, 88, 67}, "7d5205c8e0", 5) + d3 + C0000.decode(new byte[]{65, 93, 65, 67, 88, 86, 65, 71, 16, 70, 9, 85, 92, 67, 89, 90, 92, 93, 93, 71, 12, 20}, "a42c432402", 6) + d2 + '.');
        }
        if (d < d2) {
            return d2;
        }
        return d > d3 ? d3 : d;
    }

    public static final float coerceIn(float f, float f2, float f3) {
        if (f2 > f3) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{116, 2, 13, 95, 94, 22, 17, 2, 95, 87, 75, 7, 83, 19, 65, 2, 15, 68, 84, 66, 69, 14, 16, 83, 87, 68, 83, 94, 71, 23, 26, 17, 67, 3, 95, 6, 85, 8, 25, 9, 87, 75, 94, 14, 22, 92, 17}, "7cc11b1a029d63", 1) + f3 + C0000.decode(new byte[]{67, 15, 18, 68, 88, 4, 23, 67, 69, 18, 12, 3, 13, 70, 12, 13, 90, 8, 9, 69, 8, 70}, "cfad4ad0efdb") + f2 + '.');
        }
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }

    public static final int coerceIn(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{37, 89, 12, 13, 87, 71, 70, 90, 9, 93, 16, 0, 93, 19, 16, 88, 10, 77, 7, 67, 76, 92, 70, 88, 8, 24, 7, 14, 72, 71, 31, 25, 20, 89, 12, 4, 93, 9, 70, 84, 7, 64, 11, 14, 77, 94, 70}, "f8bc83f9", false) + i3 + C0000.decode(new byte[]{65, 8, 67, 25, 9, 86, 67, 65, 66, 22, 88, 86, 94, 65, 12, 8, 94, 80, 8, 70, 93, 18}, "aa09e302bb070a") + i2 + '.');
        }
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    public static final int coerceIn(int i, ClosedRange<Integer> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{20, 85, 11, 86, 84}, "f4e11d903b", 0.0f));
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) RangesKt.coerceIn(Integer.valueOf(i), (ClosedFloatingPointRange<Integer>) closedRange)).intValue();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{38, 81, 90, 91, 13, 17, 16, 86, 95, 87, 70, 1, 1, 20, 64, 2, 9, 69, 81, 21, 22, 10, 16, 84, 94, 18, 81, 15, 20, 64, 79, 67, 23, 81, 90, 82, 7, 95, 16}, "e045be05024bd46c", 0.0f) + closedRange + '.');
        }
        if (i < ((Number) closedRange.getStart()).intValue()) {
            return ((Number) closedRange.getStart()).intValue();
        }
        return i > ((Number) closedRange.getEndInclusive()).intValue() ? ((Number) closedRange.getEndInclusive()).intValue() : i;
    }

    public static final long coerceIn(long j, long j2, long j3) {
        if (j2 > j3) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{112, 4, 94, 94, 92, 65, 18, 7, 95, 87, 20, 87, 6, 16, 69, 4, 92, 69, 86, 21, 70, 11, 16, 83, 8, 20, 6, 93, 67, 17, 73, 16, 65, 84, 92, 3, 85, 8, 70, 89, 2, 72, 90, 8, 69, 93, 19}, "3e00352d02f4c0", 0.0f) + j3 + C0000.decode(new byte[]{16, 13, 74, 16, 94, 87, 70, 16, 20, 17, 80, 3, 11, 24, 93, 13, 87, 89, 95, 71, 88, 67}, "0d90225c4e8be8") + j2 + '.');
        }
        if (j < j2) {
            return j2;
        }
        return j > j3 ? j3 : j;
    }

    public static final long coerceIn(long j, ClosedRange<Long> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{69, 83, 88, 85, 81}, "7262484979f6", false));
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) RangesKt.coerceIn(Long.valueOf(j), (ClosedFloatingPointRange<Long>) closedRange)).longValue();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{115, 4, 88, 95, 11, 21, 16, 87, 95, 0, 68, 82, 1, 65, 70, 85, 92, 16, 83, 17, 16, 14, 16, 85, 94, 69, 83, 92, 20, 21, 73, 20, 66, 4, 88, 86, 1, 91, 16}, "0e61da04", 5) + closedRange + '.');
        }
        if (j < ((Number) closedRange.getStart()).longValue()) {
            return ((Number) closedRange.getStart()).longValue();
        }
        return j > ((Number) closedRange.getEndInclusive()).longValue() ? ((Number) closedRange.getEndInclusive()).longValue() : j;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x007d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x007e A[RETURN] */
    public static final <T extends Comparable<? super T>> T coerceIn(T t, T t2, T t3) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{89, 68, 95, 11, 75, 8}, "e07b861d", false));
        if (t2 == null || t3 == null) {
            if (t2 == null || t.compareTo(t2) >= 0) {
                if (t3 == null || t.compareTo(t3) <= 0) {
                    return t;
                }
                return t3;
            }
            return t2;
        }
        if (t2.compareTo(t3) > 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{37, 83, 95, 8, 14, 66, 70, 81, 94, 3, 19, 85, 3, 18, 71, 7, 13, 67, 3, 18, 69, 9, 65, 87, 8, 18, 84, 11, 17, 66, 31, 18, 67, 7, 15, 81, 3, 8, 17, 11, 0, 78, 15, 95, 68, 11, 65}, "f21fa6", 2) + t3 + C0000.decode(new byte[]{21, 93, 21, 17, 13, 84, 70, 71, 70, 69, 9, 80, 91, 20, 11, 88, 15, 88, 88, 65, 11, 17}, "54f1a1", true) + t2 + '.');
        }
        if (t.compareTo(t2) >= 0) {
            if (t.compareTo(t3) > 0) {
                return t3;
            }
            return t;
        }
        return t2;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{4, 77, 11, 91, 67, 93}, "89c20ce8"));
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, C0000.decode(new byte[]{65, 4, 94, 87, 83}, "3e006feef25bfc2e"));
        if (closedFloatingPointRange.isEmpty()) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{122, 7, 86, 93, 11, 18, 21, 90, 89, 86, 19, 83, 92, 70, 78, 82, 8, 19, 80, 25, 66, 92, 65, 81, 87, 70, 93, 94, 20, 18, 76, 25, 68, 82, 15, 87, 92, 92, 24}, "9f83df5963a0", 3) + closedFloatingPointRange + '.');
        }
        if (!closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getStart()) || closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), t)) {
            return (!closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getEndInclusive(), t) || closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getEndInclusive())) ? t : closedFloatingPointRange.getEndInclusive();
        }
        return closedFloatingPointRange.getStart();
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedRange<T> closedRange) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{5, 16, 94, 92, 66, 88}, "9d651f3fefc17bd7", 0.0f));
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{68, 85, 90, 83, 84}, "64441f17800dd4", 0.0f));
        if (closedRange instanceof ClosedFloatingPointRange) {
            return (T) RangesKt.coerceIn((Comparable) t, (ClosedFloatingPointRange) closedRange);
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{115, 3, 92, 89, 13, 64, 66, 7, 95, 7, 64, 84, 7, 20, 20, 5, 92, 23, 87, 23, 22, 91, 66, 5, 94, 66, 87, 90, 18, 64, 27, 68, 66, 3, 92, 80, 7, 14, 66}, "0b27b4bd", 3) + closedRange + '.');
        }
        if (t.compareTo(closedRange.getStart()) < 0) {
            return (T) closedRange.getStart();
        }
        return t.compareTo(closedRange.getEndInclusive()) > 0 ? (T) closedRange.getEndInclusive() : t;
    }

    public static final short coerceIn(short s, short s2, short s3) {
        if (s2 > s3) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{122, 89, 87, 8, 13, 17, 20, 90, 90, 81, 67, 87, 0, 70, 79, 89, 85, 19, 7, 69, 64, 86, 21, 85, 95, 20, 0, 11, 73, 76, 64, 70, 16, 4, 90, 94, 80, 14, 17, 89, 4, 30, 80, 85, 76, 11, 66}, "989fbe495414ef", true) + ((int) s3) + C0000.decode(new byte[]{67, 10, 69, 21, 15, 0, 17, 66, 22, 17, 10, 86, 89, 65, 84, 11, 13, 10, 91, 64, 14, 69}, "cc65ceb16eb77a9b") + ((int) s2) + '.');
        }
        if (s < s2) {
            return s2;
        }
        return s > s3 ? s3 : s;
    }

    private static final boolean contains(CharRange charRange, Character ch) {
        Intrinsics.checkNotNullParameter(charRange, C0000.decode(new byte[]{93, 64, 9, 10, 74, 7}, "a4ac9922"));
        return ch != null && charRange.contains(ch.charValue());
    }

    private static final boolean contains(IntRange intRange, byte b) {
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{8, 23, 95, 12, 21, 95}, "4c7efac8a985", 0.0f));
        return RangesKt.intRangeContains((ClosedRange<Integer>) intRange, b);
    }

    private static final boolean contains(IntRange intRange, long j) {
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{11, 71, 88, 89, 74, 90}, "73009d59a326", 2));
        return RangesKt.intRangeContains((ClosedRange<Integer>) intRange, j);
    }

    private static final boolean contains(IntRange intRange, Integer num) {
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{11, 68, 13, 91, 65, 95}, "70e22a"));
        return num != null && intRange.contains(num.intValue());
    }

    private static final boolean contains(IntRange intRange, short s) {
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{4, 21, 91, 91, 21, 15}, "8a32f146", 7));
        return RangesKt.intRangeContains((ClosedRange<Integer>) intRange, s);
    }

    private static final boolean contains(LongRange longRange, byte b) {
        Intrinsics.checkNotNullParameter(longRange, C0000.decode(new byte[]{14, 77, 94, 10, 22, 9}, "296ce7f421", 3));
        return RangesKt.longRangeContains((ClosedRange<Long>) longRange, b);
    }

    private static final boolean contains(LongRange longRange, int i) {
        Intrinsics.checkNotNullParameter(longRange, C0000.decode(new byte[]{8, 76, 13, 8, 68, 13}, "48ea736f2a920512"));
        return RangesKt.longRangeContains((ClosedRange<Long>) longRange, i);
    }

    private static final boolean contains(LongRange longRange, Long l) {
        Intrinsics.checkNotNullParameter(longRange, C0000.decode(new byte[]{8, 76, 89, 92, 21, 93}, "4815fc", true));
        return l != null && longRange.contains(l.longValue());
    }

    private static final boolean contains(LongRange longRange, short s) {
        Intrinsics.checkNotNullParameter(longRange, C0000.decode(new byte[]{14, 67, 11, 94, 70, 14}, "27c750cbba61"));
        return RangesKt.longRangeContains((ClosedRange<Long>) longRange, s);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{15, 69, 93, 91, 75, 6}, "315288ea", false));
        return closedRange.contains(Double.valueOf(b));
    }

    public static final boolean doubleRangeContains(ClosedRange<Double> closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{88, 71, 93, 95, 69, 11}, "d35665549a9d071a", 0.0f));
        return closedRange.contains(Double.valueOf(f));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{11, 66, 92, 15, 22, 12}, "764fe2"));
        return closedRange.contains(Double.valueOf(i));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{88, 16, 91, 91, 70, 13}, "dd3253d3135888dc"));
        return closedRange.contains(Double.valueOf(j));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{95, 76, 90, 95, 22, 11}, "c826e52ad039fe", 3));
        return closedRange.contains(Double.valueOf(s));
    }

    public static final boolean doubleRangeContains(OpenEndRange<Double> openEndRange, float f) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{95, 23, 89, 88, 68, 13}, "cc1173dd45", 3));
        return openEndRange.contains(Double.valueOf(f));
    }

    public static final char first(CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, C0000.decode(new byte[]{14, 23, 11, 92, 22, 90}, "2cc5ed", 0.0f));
        if (charProgression.isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{54, 19, 91, 80, 70, 92, 21, 18, 93, 88, 90, 25}, "fa4749", false) + charProgression + C0000.decode(new byte[]{70, 80, 64, 66, 80, 88, 72, 17, 28, 29}, "f93b558ee38afb"));
        }
        return charProgression.getFirst();
    }

    public static final int first(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, C0000.decode(new byte[]{12, 23, 94, 92, 17, 6}, "0c65b8e5f5", 4));
        if (intProgression.isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{50, 20, 9, 87, 75, 81, 68, 71, 91, 87, 86, 18}, "bff09474288288", true) + intProgression + C0000.decode(new byte[]{18, 80, 65, 24, 82, 90, 66, 77, 75, 22}, "292877", false));
        }
        return intProgression.getFirst();
    }

    public static final long first(LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, C0000.decode(new byte[]{13, 65, 90, 88, 22, 12}, "1521e2", true));
        if (longProgression.isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{51, 66, 94, 87, 65, 87, 69, 70, 92, 10, 13, 16}, "c01032655e", 2) + longProgression + C0000.decode(new byte[]{20, 80, 18, 19, 81, 93, 65, 66, 73, 23}, "49a3401609566e", true));
        }
        return longProgression.getFirst();
    }

    public static final Character firstOrNull(CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, C0000.decode(new byte[]{13, 17, 10, 94, 68, 13}, "1eb7733c"));
        if (charProgression.isEmpty()) {
            return null;
        }
        return Character.valueOf(charProgression.getFirst());
    }

    public static final Integer firstOrNull(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, C0000.decode(new byte[]{15, 21, 81, 89, 22, 13}, "3a90e32f6eb0", 0.0f));
        if (intProgression.isEmpty()) {
            return null;
        }
        return Integer.valueOf(intProgression.getFirst());
    }

    public static final Long firstOrNull(LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, C0000.decode(new byte[]{10, 18, 91, 80, 71, 9}, "6f3947a28d69"));
        if (longProgression.isEmpty()) {
            return null;
        }
        return Long.valueOf(longProgression.getFirst());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{88, 64, 90, 89, 21, 95}, "d420fabda0becb73", true));
        return closedRange.contains(Float.valueOf(b));
    }

    public static final boolean floatRangeContains(ClosedRange<Float> closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{14, 70, 88, 90, 17, 10}, "2203b451150724c7"));
        return closedRange.contains(Float.valueOf((float) d));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{95, 70, 91, 12, 70, 91}, "c23e5eb79300ff", false));
        return closedRange.contains(Float.valueOf(i));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{13, 64, 95, 80, 17, 92}, "1479bba48c13fc20", true));
        return closedRange.contains(Float.valueOf(j));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{10, 71, 91, 11, 17, 91}, "633bbe52910d06", false));
        return closedRange.contains(Float.valueOf(s));
    }

    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{89, 71, 80, 92, 71, 91}, "e3854e8cf5"));
        return closedRange.contains(Integer.valueOf(b));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{15, 77, 92, 81, 66, 95}, "39481a2e6f0b"));
        Integer intExactOrNull = RangesKt.toIntExactOrNull(d);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{88, 22, 94, 91, 74, 92}, "db629b", 1));
        Integer intExactOrNull = RangesKt.toIntExactOrNull(f);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{14, 18, 81, 91, 71, 6}, "2f9248", 1));
        Integer intExactOrNull = RangesKt.toIntExactOrNull(j);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{90, 17, 81, 80, 22, 14}, "fe99e0df4a01", true));
        return closedRange.contains(Integer.valueOf(s));
    }

    public static final boolean intRangeContains(OpenEndRange<Integer> openEndRange, byte b) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{10, 18, 9, 8, 22, 92}, "6faaeb", 6));
        return openEndRange.contains(Integer.valueOf(b));
    }

    public static final boolean intRangeContains(OpenEndRange<Integer> openEndRange, long j) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{8, 77, 95, 13, 66, 90}, "497d1da9", 6));
        Integer intExactOrNull = RangesKt.toIntExactOrNull(j);
        if (intExactOrNull != null) {
            return openEndRange.contains(intExactOrNull);
        }
        return false;
    }

    public static final boolean intRangeContains(OpenEndRange<Integer> openEndRange, short s) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{12, 64, 95, 81, 21, 95}, "0478fac45c", 6));
        return openEndRange.contains(Integer.valueOf(s));
    }

    public static final char last(CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, C0000.decode(new byte[]{14, 77, 91, 80, 18, 90}, "2939ad3f368a5a", 5));
        if (charProgression.isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{103, 22, 89, 86, 70, 3, 23, 18, 94, 11, 88, 17}, "7d614fda") + charProgression + C0000.decode(new byte[]{69, 93, 23, 16, 87, 91, 72, 68, 72, 26}, "e4d0268014aca7"));
        }
        return charProgression.getLast();
    }

    public static final int last(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, C0000.decode(new byte[]{12, 67, 13, 80, 65, 9}, "07e927366ce2", 0.0f));
        if (intProgression.isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{54, 65, 9, 82, 68, 6, 65, 74, 89, 93, 8, 19}, "f3f56c2902") + intProgression + C0000.decode(new byte[]{65, 89, 23, 66, 83, 89, 68, 66, 74, 30}, "a0db644630ddecac", 2));
        }
        return intProgression.getLast();
    }

    public static final long last(LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, C0000.decode(new byte[]{10, 66, 80, 89, 22, 10}, "6680e43237ba", false));
        if (longProgression.isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{98, 22, 91, 95, 69, 92, 16, 22, 95, 92, 92, 68}, "2d4879ce63") + longProgression + C0000.decode(new byte[]{65, 94, 66, 18, 80, 90, 22, 70, 73, 31}, "a71257f20103ba6e", 1));
        }
        return longProgression.getLast();
    }

    public static final Character lastOrNull(CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, C0000.decode(new byte[]{95, 77, 90, 11, 70, 12}, "c92b5220e39efca4", 0.0f));
        if (charProgression.isEmpty()) {
            return null;
        }
        return Character.valueOf(charProgression.getLast());
    }

    public static final Integer lastOrNull(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, C0000.decode(new byte[]{11, 21, 91, 13, 69, 13}, "7a3d63cc15", false));
        if (intProgression.isEmpty()) {
            return null;
        }
        return Integer.valueOf(intProgression.getLast());
    }

    public static final Long lastOrNull(LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, C0000.decode(new byte[]{94, 65, 9, 91, 75, 14}, "b5a2801d38", 0.0f));
        if (longProgression.isEmpty()) {
            return null;
        }
        return Long.valueOf(longProgression.getLast());
    }

    public static final boolean longRangeContains(ClosedRange<Long> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{95, 18, 90, 90, 65, 92}, "cf232b"));
        return closedRange.contains(Long.valueOf(b));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{11, 67, 81, 8, 65, 9}, "779a27"));
        Long longExactOrNull = RangesKt.toLongExactOrNull(d);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{89, 18, 92, 94, 69, 14}, "ef47609a679bf7", false));
        Long longExactOrNull = RangesKt.toLongExactOrNull(f);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    public static final boolean longRangeContains(ClosedRange<Long> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{4, 18, 12, 94, 16, 88}, "8fd7cfc113", 3));
        return closedRange.contains(Long.valueOf(i));
    }

    public static final boolean longRangeContains(ClosedRange<Long> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{88, 17, 88, 15, 69, 15}, "de0f61", 0));
        return closedRange.contains(Long.valueOf(s));
    }

    public static final boolean longRangeContains(OpenEndRange<Long> openEndRange, byte b) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{94, 64, 94, 11, 71, 91}, "b46b4e86b0"));
        return openEndRange.contains(Long.valueOf(b));
    }

    public static final boolean longRangeContains(OpenEndRange<Long> openEndRange, int i) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{15, 65, 89, 12, 67, 13}, "351e03", true));
        return openEndRange.contains(Long.valueOf(i));
    }

    public static final boolean longRangeContains(OpenEndRange<Long> openEndRange, short s) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{94, 23, 13, 15, 69, 8}, "bcef663c49099776"));
        return openEndRange.contains(Long.valueOf(s));
    }

    private static final char random(CharRange charRange) {
        Intrinsics.checkNotNullParameter(charRange, C0000.decode(new byte[]{9, 64, 88, 93, 69, 92}, "54046b97de32112a", true));
        return RangesKt.random(charRange, Random.INSTANCE);
    }

    public static final char random(CharRange charRange, Random random) {
        Intrinsics.checkNotNullParameter(charRange, C0000.decode(new byte[]{90, 64, 93, 93, 74, 7}, "f45499ca9b348053", 4));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{20, 83, 93, 80, 89, 12}, "f2346aeb", true));
        try {
            return (char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final int random(IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{94, 70, 80, 12, 17, 91}, "b28ebec2"));
        return RangesKt.random(intRange, Random.INSTANCE);
    }

    public static final int random(IntRange intRange, Random random) {
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{90, 23, 9, 13, 21, 7}, "fcadf937a9", 5));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{64, 82, 12, 1, 94, 92}, "23be11b189", 0.0f));
        try {
            return RandomKt.nextInt(random, intRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final long random(LongRange longRange) {
        Intrinsics.checkNotNullParameter(longRange, C0000.decode(new byte[]{5, 67, 88, 11, 64, 95}, "970b3a8f353a06", 5));
        return RangesKt.random(longRange, Random.INSTANCE);
    }

    public static final long random(LongRange longRange, Random random) {
        Intrinsics.checkNotNullParameter(longRange, C0000.decode(new byte[]{13, 70, 93, 94, 21, 7}, "1257f9146b1f4633", 0));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{70, 81, 13, 7, 93, 84}, "40cc2922"));
        try {
            return RandomKt.nextLong(random, longRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final Character randomOrNull(CharRange charRange) {
        Intrinsics.checkNotNullParameter(charRange, C0000.decode(new byte[]{93, 67, 90, 15, 22, 9}, "a72fe79aaf", 0.0f));
        return RangesKt.randomOrNull(charRange, Random.INSTANCE);
    }

    public static final Character randomOrNull(CharRange charRange, Random random) {
        Intrinsics.checkNotNullParameter(charRange, C0000.decode(new byte[]{15, 17, 91, 93, 65, 8}, "3e3426", 0.0f));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{19, 82, 89, 0, 93, 92}, "a37d21b222"));
        if (charRange.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1));
    }

    private static final Integer randomOrNull(IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{10, 16, 80, 10, 75, 10}, "6d8c840291c8df", 0.0f));
        return RangesKt.randomOrNull(intRange, Random.INSTANCE);
    }

    public static final Integer randomOrNull(IntRange intRange, Random random) {
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{10, 70, 10, 90, 71, 95}, "62b34ad0760197cb", 0.0f));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{65, 0, 86, 81, 86, 90}, "3a8597"));
        if (intRange.isEmpty()) {
            return null;
        }
        return Integer.valueOf(RandomKt.nextInt(random, intRange));
    }

    private static final Long randomOrNull(LongRange longRange) {
        Intrinsics.checkNotNullParameter(longRange, C0000.decode(new byte[]{11, 21, 94, 81, 75, 95}, "7a688a09447164", 3));
        return RangesKt.randomOrNull(longRange, Random.INSTANCE);
    }

    public static final Long randomOrNull(LongRange longRange, Random random) {
        Intrinsics.checkNotNullParameter(longRange, C0000.decode(new byte[]{90, 66, 94, 8, 65, 91}, "f66a2e7a80a0e5", 5));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{64, 0, 88, 92, 9, 14}, "2a68fcf3a4d78785", true));
        if (longRange.isEmpty()) {
            return null;
        }
        return Long.valueOf(RandomKt.nextLong(random, longRange));
    }

    public static final CharProgression reversed(CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, C0000.decode(new byte[]{5, 76, 80, 93, 22, 11}, "9884e571c7256d"));
        return CharProgression.INSTANCE.fromClosedRange(charProgression.getLast(), charProgression.getFirst(), -charProgression.getStep());
    }

    public static final IntProgression reversed(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, C0000.decode(new byte[]{88, 17, 12, 10, 65, 7}, "dedc2983", 0.0f));
        return IntProgression.INSTANCE.fromClosedRange(intProgression.getLast(), intProgression.getFirst(), -intProgression.getStep());
    }

    public static final LongProgression reversed(LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, C0000.decode(new byte[]{95, 70, 14, 10, 74, 92}, "c2fc9bf2b584", 0.0f));
        return LongProgression.INSTANCE.fromClosedRange(longProgression.getLast(), longProgression.getFirst(), -longProgression.getStep());
    }

    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{11, 77, 94, 92, 68, 90}, "79657d", 1));
        return closedRange.contains(Short.valueOf(b));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{88, 16, 94, 80, 70, 88}, "dd695f8806", 3));
        Short shortExactOrNull = RangesKt.toShortExactOrNull(d);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{90, 65, 13, 90, 21, 10}, "f5e3f4525ee2", 0.0f));
        Short shortExactOrNull = RangesKt.toShortExactOrNull(f);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{94, 22, 90, 10, 70, 7}, "bb2c5905", 0.0f));
        Short shortExactOrNull = RangesKt.toShortExactOrNull(i);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{4, 68, 91, 90, 74, 92}, "80339b1c7aa8e3", false));
        Short shortExactOrNull = RangesKt.toShortExactOrNull(j);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final boolean shortRangeContains(OpenEndRange<Short> openEndRange, byte b) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{15, 17, 12, 91, 16, 11}, "3ed2c5", false));
        return openEndRange.contains(Short.valueOf(b));
    }

    public static final boolean shortRangeContains(OpenEndRange<Short> openEndRange, int i) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{14, 65, 91, 13, 69, 93}, "253d6c01c437", true));
        Short shortExactOrNull = RangesKt.toShortExactOrNull(i);
        if (shortExactOrNull != null) {
            return openEndRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final boolean shortRangeContains(OpenEndRange<Short> openEndRange, long j) {
        Intrinsics.checkNotNullParameter(openEndRange, C0000.decode(new byte[]{10, 16, 14, 13, 74, 90}, "6dfd9d25fbd23fb2", true));
        Short shortExactOrNull = RangesKt.toShortExactOrNull(j);
        if (shortExactOrNull != null) {
            return openEndRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final CharProgression step(CharProgression charProgression, int i) {
        Intrinsics.checkNotNullParameter(charProgression, C0000.decode(new byte[]{9, 22, 91, 8, 69, 90}, "5b3a6d37026eea7b", 0.0f));
        RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        CharProgression.Companion companion = CharProgression.INSTANCE;
        char first = charProgression.getFirst();
        char last = charProgression.getLast();
        if (charProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    public static final IntProgression step(IntProgression intProgression, int i) {
        Intrinsics.checkNotNullParameter(intProgression, C0000.decode(new byte[]{89, 67, 94, 94, 23, 90}, "e767dd0aa7"));
        RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        IntProgression.Companion companion = IntProgression.INSTANCE;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    public static final LongProgression step(LongProgression longProgression, long j) {
        Intrinsics.checkNotNullParameter(longProgression, C0000.decode(new byte[]{88, 64, 89, 95, 74, 6}, "d416980d"));
        RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        LongProgression.Companion companion = LongProgression.INSTANCE;
        long first = longProgression.getFirst();
        long last = longProgression.getLast();
        if (longProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.fromClosedRange(first, last, j);
    }

    public static final IntProgression downTo(int i, byte b) {
        return IntProgression.INSTANCE.fromClosedRange(i, b, -1);
    }

    public static final LongProgression downTo(long j, byte b) {
        return LongProgression.INSTANCE.fromClosedRange(j, b, -1L);
    }

    public static final IntProgression downTo(byte b, byte b2) {
        return IntProgression.INSTANCE.fromClosedRange(b, b2, -1);
    }

    public static final IntProgression downTo(short s, byte b) {
        return IntProgression.INSTANCE.fromClosedRange(s, b, -1);
    }

    public static final CharProgression downTo(char c, char c2) {
        return CharProgression.INSTANCE.fromClosedRange(c, c2, -1);
    }

    public static final IntProgression downTo(int i, int i2) {
        return IntProgression.INSTANCE.fromClosedRange(i, i2, -1);
    }

    public static final LongProgression downTo(long j, int i) {
        return LongProgression.INSTANCE.fromClosedRange(j, i, -1L);
    }

    public static final IntProgression downTo(byte b, int i) {
        return IntProgression.INSTANCE.fromClosedRange(b, i, -1);
    }

    public static final IntProgression downTo(short s, int i) {
        return IntProgression.INSTANCE.fromClosedRange(s, i, -1);
    }

    public static final LongProgression downTo(int i, long j) {
        return LongProgression.INSTANCE.fromClosedRange(i, j, -1L);
    }

    public static final LongProgression downTo(long j, long j2) {
        return LongProgression.INSTANCE.fromClosedRange(j, j2, -1L);
    }

    public static final LongProgression downTo(byte b, long j) {
        return LongProgression.INSTANCE.fromClosedRange(b, j, -1L);
    }

    public static final LongProgression downTo(short s, long j) {
        return LongProgression.INSTANCE.fromClosedRange(s, j, -1L);
    }

    public static final IntProgression downTo(int i, short s) {
        return IntProgression.INSTANCE.fromClosedRange(i, s, -1);
    }

    public static final LongProgression downTo(long j, short s) {
        return LongProgression.INSTANCE.fromClosedRange(j, s, -1L);
    }

    public static final IntProgression downTo(byte b, short s) {
        return IntProgression.INSTANCE.fromClosedRange(b, s, -1);
    }

    public static final IntProgression downTo(short s, short s2) {
        return IntProgression.INSTANCE.fromClosedRange(s, s2, -1);
    }

    public static final Byte toByteExactOrNull(int i) {
        if (-128 > i || i >= 128) {
            return null;
        }
        return Byte.valueOf((byte) i);
    }

    public static final Byte toByteExactOrNull(long j) {
        if (-128 > j || j >= 128) {
            return null;
        }
        return Byte.valueOf((byte) j);
    }

    public static final Byte toByteExactOrNull(short s) {
        if (-128 > s || s >= 128) {
            return null;
        }
        return Byte.valueOf((byte) s);
    }

    public static final Byte toByteExactOrNull(double d) {
        if (-128.0d > d || d > 127.0d) {
            return null;
        }
        return Byte.valueOf((byte) d);
    }

    public static final Byte toByteExactOrNull(float f) {
        if (-128.0f > f || f > 127.0f) {
            return null;
        }
        return Byte.valueOf((byte) f);
    }

    public static final Integer toIntExactOrNull(long j) {
        if (-2147483648L > j || j >= 2147483648L) {
            return null;
        }
        return Integer.valueOf((int) j);
    }

    public static final Integer toIntExactOrNull(double d) {
        if (-2.147483648E9d > d || d > 2.147483647E9d) {
            return null;
        }
        return Integer.valueOf((int) d);
    }

    public static final Integer toIntExactOrNull(float f) {
        if (-2.1474836E9f > f || f > 2.1474836E9f) {
            return null;
        }
        return Integer.valueOf((int) f);
    }

    public static final Long toLongExactOrNull(double d) {
        if (-9.223372036854776E18d > d || d > 9.223372036854776E18d) {
            return null;
        }
        return Long.valueOf((long) d);
    }

    public static final Long toLongExactOrNull(float f) {
        if (-9.223372E18f > f || f > 9.223372E18f) {
            return null;
        }
        return Long.valueOf((long) f);
    }

    public static final Short toShortExactOrNull(int i) {
        if (-32768 > i || i >= 32768) {
            return null;
        }
        return Short.valueOf((short) i);
    }

    public static final Short toShortExactOrNull(long j) {
        if (-32768 > j || j >= 32768) {
            return null;
        }
        return Short.valueOf((short) j);
    }

    public static final Short toShortExactOrNull(double d) {
        if (-32768.0d > d || d > 32767.0d) {
            return null;
        }
        return Short.valueOf((short) d);
    }

    public static final Short toShortExactOrNull(float f) {
        if (-32768.0f > f || f > 32767.0f) {
            return null;
        }
        return Short.valueOf((short) f);
    }

    public static final IntRange until(int i, byte b) {
        return new IntRange(i, b - 1);
    }

    public static final LongRange until(long j, byte b) {
        return new LongRange(j, ((long) b) - 1);
    }

    public static final IntRange until(byte b, byte b2) {
        return new IntRange(b, b2 - 1);
    }

    public static final IntRange until(short s, byte b) {
        return new IntRange(s, b - 1);
    }

    public static final CharRange until(char c, char c2) {
        return Intrinsics.compare((int) c2, 0) <= 0 ? CharRange.INSTANCE.getEMPTY() : new CharRange(c, (char) (c2 - 1));
    }

    public static final IntRange until(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(i, i2 - 1);
    }

    public static final LongRange until(long j, int i) {
        return new LongRange(j, ((long) i) - 1);
    }

    public static final IntRange until(byte b, int i) {
        if (i <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(b, i - 1);
    }

    public static final IntRange until(short s, int i) {
        if (i <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(s, i - 1);
    }

    public static final LongRange until(int i, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(i, j - 1);
    }

    public static final LongRange until(long j, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(j, j2 - 1);
    }

    public static final LongRange until(byte b, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(b, j - 1);
    }

    public static final LongRange until(short s, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(s, j - 1);
    }

    public static final IntRange until(int i, short s) {
        return new IntRange(i, s - 1);
    }

    public static final LongRange until(long j, short s) {
        return new LongRange(j, ((long) s) - 1);
    }

    public static final IntRange until(byte b, short s) {
        return new IntRange(b, s - 1);
    }

    public static final IntRange until(short s, short s2) {
        return new IntRange(s, s2 - 1);
    }
}
