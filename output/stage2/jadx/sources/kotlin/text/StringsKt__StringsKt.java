package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\b\u001a\u00020\u0001*\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\b\u001a\u00020\u0006*\u00020\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\r\u0010\u0000\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0001\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0001\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u001c\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\u000f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a \u0010\u0010\u001a\u00020\u0005*\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010\u0011\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a\n\u0010\u0013\u001a\u00020\u0005*\u00020\u0001\u001a\r\u0010\u0014\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a \u0010\u0015\u001a\u00020\u0005*\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\u0001H\u0086\u0002\u001a\u000f\u0010\u0018\u001a\u00020\u0006*\u0004\u0018\u00010\u0006H\u0087\b\u001aD\u0010\u0019\u001a\u0002H\u001a\"\f\b\u0000\u0010\u001b*\u00020\u0001*\u0002H\u001a\"\u0004\b\u0001\u0010\u001a*\u0002H\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u001e\u001aD\u0010\u001f\u001a\u0002H\u001a\"\f\b\u0000\u0010\u001b*\u00020\u0001*\u0002H\u001a\"\u0004\b\u0001\u0010\u001a*\u0002H\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u001e\u001a\u0012\u0010'\u001a\u00020\u0005*\u00020\u00012\u0006\u0010(\u001a\u00020\r\u001a\u0012\u0010)\u001a\u00020\u0006*\u00020\u00062\u0006\u0010*\u001a\u00020!\u001a\u0012\u0010+\u001a\u00020\u0001*\u00020\u00012\u0006\u0010*\u001a\u00020!\u001a\u001d\u0010+\u001a\u00020\u0001*\u00020\u00062\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\rH\u0087\b\u001a\u001f\u0010)\u001a\u00020\u0006*\u00020\u00012\u0006\u0010.\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u00020\rH\u0087\b\u001a\u0012\u0010)\u001a\u00020\u0006*\u00020\u00012\u0006\u0010*\u001a\u00020!\u001a\u001c\u00100\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00100\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00103\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00103\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00104\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00104\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00105\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00105\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\"\u00106\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00107\u001a\u00020\u0001\u001a%\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00107\u001a\u00020\u0001H\u0087\b\u001a\u001a\u00106\u001a\u00020\u0001*\u00020\u00012\u0006\u0010*\u001a\u00020!2\u0006\u00107\u001a\u00020\u0001\u001a\u001d\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u0010*\u001a\u00020!2\u0006\u00107\u001a\u00020\u0001H\u0087\b\u001a\u001a\u00108\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r\u001a\u001d\u00108\u001a\u00020\u0006*\u00020\u00062\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\rH\u0087\b\u001a\u0012\u00108\u001a\u00020\u0001*\u00020\u00012\u0006\u0010*\u001a\u00020!\u001a\u0015\u00108\u001a\u00020\u0006*\u00020\u00062\u0006\u0010*\u001a\u00020!H\u0087\b\u001a\u0012\u00109\u001a\u00020\u0001*\u00020\u00012\u0006\u0010:\u001a\u00020\u0001\u001a\u0012\u00109\u001a\u00020\u0006*\u00020\u00062\u0006\u0010:\u001a\u00020\u0001\u001a\u0012\u0010;\u001a\u00020\u0001*\u00020\u00012\u0006\u0010<\u001a\u00020\u0001\u001a\u0012\u0010;\u001a\u00020\u0006*\u00020\u00062\u0006\u0010<\u001a\u00020\u0001\u001a\u001a\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u0001\u001a\u001a\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u0010:\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u0001\u001a\u0012\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u0001\u001a$\u0010>\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010>\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010A\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010A\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001d\u0010B\u001a\u00020\u0006*\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0006\u00107\u001a\u00020\u0006H\u0087\b\u001a.\u0010B\u001a\u00020\u0006*\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0014\b\b\u0010E\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\u00010\u0003H\u0087\bø\u0001\u0000\u001a\u001d\u0010G\u001a\u00020\u0006*\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0006\u00107\u001a\u00020\u0006H\u0087\b\u001a)\u0010H\u001a\u00020\u0006*\u00020\u00062\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000¢\u0006\u0002\bI\u001a)\u0010H\u001a\u00020\u0006*\u00020\u00062\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0002\bJ\u001a\u0015\u0010K\u001a\u00020\u0005*\u00020\u00012\u0006\u0010C\u001a\u00020DH\u0087\f\u001a4\u0010L\u001a\u00020\u0005*\u00020\u00012\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u0005H\u0000\u001a\u001c\u0010Q\u001a\u00020\u0005*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010S\u001a\u00020\u0005*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010Q\u001a\u00020\u0005*\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005\u001a$\u0010Q\u001a\u00020\u0005*\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010S\u001a\u00020\u0005*\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010T\u001a\u00020\u0006*\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010U\u001a\u00020\u0006*\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010V\u001a\u00020\r*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010W\u001a\u00020\r*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a;\u0010X\u001a\u00020\r*\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u00052\b\b\u0002\u0010Y\u001a\u00020\u0005H\u0002¢\u0006\u0002\bZ\u001aE\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\u0006\u0010.\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0005H\u0002¢\u0006\u0002\b_\u001a:\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a:\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a,\u0010V\u001a\u00020\r*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a,\u0010W\u001a\u00020\r*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010X\u001a\u00020\r*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010X\u001a\u00020\r*\u00020\u00012\u0006\u0010a\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010b\u001a\u00020\r*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010b\u001a\u00020\r*\u00020\u00012\u0006\u0010a\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001f\u0010c\u001a\u00020\u0005*\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005H\u0086\u0002\u001a\u001f\u0010c\u001a\u00020\u0005*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u0005H\u0086\u0002\u001a\u0015\u0010c\u001a\u00020\u0005*\u00020\u00012\u0006\u0010C\u001a\u00020DH\u0087\n\u001a=\u0010d\u001a\b\u0012\u0004\u0012\u00020!0e*\u00020\u00012\u0006\u0010f\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\rH\u0002¢\u0006\u0002\bh\u001aG\u0010d\u001a\b\u0012\u0004\u0012\u00020!0e*\u00020\u00012\u000e\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060i2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\rH\u0002¢\u0006\u0004\bh\u0010j\u001a\u0010\u0010k\u001a\u00020l2\u0006\u0010g\u001a\u00020\rH\u0000\u001a=\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u00012\u0012\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060i\"\u00020\u00062\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\r¢\u0006\u0002\u0010n\u001a=\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\u0012\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060i\"\u00020\u00062\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\r¢\u0006\u0002\u0010q\u001a0\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u00012\n\u0010f\u001a\u00020\n\"\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\r\u001a0\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\n\u0010f\u001a\u00020\n\"\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\r\u001a/\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\u0006\u00101\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\rH\u0002¢\u0006\u0002\br\u001a%\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010g\u001a\u00020\rH\u0087\b\u001a%\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u00012\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010g\u001a\u00020\rH\u0087\b\u001a\u0010\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u0001\u001a\u0010\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u0001\u001a\u0018\u0010u\u001a\u00020\u0005*\u0004\u0018\u00010\u00012\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0018\u0010v\u001a\u00020\u0005*\u0004\u0018\u00010\u00012\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\f\u0010w\u001a\u00020\u0005*\u00020\u0006H\u0007\u001a\u0013\u0010x\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0007¢\u0006\u0002\u0010y\"\u0015\u0010 \u001a\u00020!*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0015\u0010$\u001a\u00020\r*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b%\u0010&\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006z"}, d2 = {"trim", "", "predicate", "Lkotlin/Function1;", "", "", "", "trimStart", "trimEnd", "chars", "", "padStart", "length", "", "padChar", "padEnd", "isNullOrEmpty", "isEmpty", "isNotEmpty", "isBlank", "isNotBlank", "isNullOrBlank", "iterator", "Lkotlin/collections/CharIterator;", "orEmpty", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifBlank", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "(Ljava/lang/CharSequence;)I", "hasSurrogatePairAt", "index", "substring", "range", "subSequence", "start", "end", "startIndex", "endIndex", "substringBefore", "delimiter", "missingDelimiterValue", "substringAfter", "substringBeforeLast", "substringAfterLast", "replaceRange", "replacement", "removeRange", "removePrefix", "prefix", "removeSuffix", "suffix", "removeSurrounding", "replaceBefore", "replaceAfter", "replaceAfterLast", "replaceBeforeLast", "replace", "regex", "Lkotlin/text/Regex;", "transform", "Lkotlin/text/MatchResult;", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "matches", "regionMatchesImpl", "thisOffset", "other", "otherOffset", "ignoreCase", "startsWith", "char", "endsWith", "commonPrefixWith", "commonSuffixWith", "indexOfAny", "lastIndexOfAny", "indexOf", "last", "indexOf$StringsKt__StringsKt", "findAnyOf", "Lkotlin/Pair;", "strings", "", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "string", "lastIndexOf", "contains", "rangesDelimitedBy", "Lkotlin/sequences/Sequence;", "delimiters", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "requireNonNegativeLimit", "", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "split", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "lineSequence", "lines", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static final String commonPrefixWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{4, 68, 93, 12, 17, 95}, "805eba"));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{90, 64, 89, 84, 20}, "5411fb2102"));
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        int i = 0;
        while (i < iMin && CharsKt.equals(charSequence.charAt(i), charSequence2.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (StringsKt.hasSurrogatePairAt(charSequence, i2) || StringsKt.hasSurrogatePairAt(charSequence2, i2)) {
            i--;
        }
        return charSequence.subSequence(0, i).toString();
    }

    public static final String commonSuffixWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{90, 69, 88, 12, 69, 90}, "f10e6dbe9d213a", true));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{94, 69, 12, 82, 64}, "11d72edcedcd", 0.0f));
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int iMin = Math.min(length, length2);
        int i = 0;
        while (i < iMin && CharsKt.equals(charSequence.charAt((length - i) - 1), charSequence2.charAt((length2 - i) - 1), z)) {
            i++;
        }
        if (StringsKt.hasSurrogatePairAt(charSequence, (length - i) - 1) || StringsKt.hasSurrogatePairAt(charSequence2, (length2 - i) - 1)) {
            i--;
        }
        return charSequence.subSequence(length - i, length).toString();
    }

    public static final boolean contains(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{12, 22, 92, 93, 64, 88}, "0b443ff97da509", 0.0f));
        return StringsKt.indexOf$default(charSequence, c, 0, z, 2, (Object) null) >= 0;
    }

    public static final boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{90, 18, 11, 15, 66, 95}, "ffcf1ad933d7c3aa"));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{91, 64, 10, 7, 65}, "44bb36"));
        if (charSequence2 instanceof String) {
            return StringsKt.indexOf$default(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0;
        }
        return indexOf$StringsKt__StringsKt$default(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0;
    }

    private static final boolean contains(CharSequence charSequence, Regex regex) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{14, 17, 92, 80, 70, 95}, "2e495ab4", 0.0f));
        Intrinsics.checkNotNullParameter(regex, C0000.decode(new byte[]{20, 82, 6, 85, 27}, "f7a0c8", 7));
        return regex.containsMatchIn(charSequence);
    }

    public static final boolean endsWith(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{4, 68, 12, 90, 18, 12}, "80d3a2cd"));
        return charSequence.length() > 0 && CharsKt.equals(charSequence.charAt(StringsKt.getLastIndex(charSequence)), c, z);
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{13, 77, 92, 10, 16, 88}, "194ccf"));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{64, 70, 2, 87, 89, 30}, "33d10f", 0.0f));
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? StringsKt.endsWith$default((String) charSequence, (String) charSequence2, false, 2, (Object) null) : StringsKt.regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{89, 17, 93, 12, 22, 10}, "ee5ee4", true));
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{70, 21, 19, 15, 94, 81, 67}, "5aaf0602d087"));
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, false);
    }

    public static final Pair<Integer, String> findLastAnyOf(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{9, 71, 92, 92, 64, 93}, "53453c68ab", 7));
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{70, 23, 23, 15, 13, 82, 70}, "5cefc5"));
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, true);
    }

    public static final IntRange getIndices(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{11, 18, 81, 90, 66, 8}, "7f9316f0f67c", true));
        return new IntRange(0, charSequence.length() - 1);
    }

    public static final int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{89, 68, 9, 89, 23, 7}, "e0a0d9", 4));
        return charSequence.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{10, 76, 92, 10, 17, 91}, "684cbe24e4e20f", 0.0f));
        return i >= 0 && i <= charSequence.length() + (-2) && Character.isHighSurrogate(charSequence.charAt(i)) && Character.isLowSurrogate(charSequence.charAt(i + 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <C extends CharSequence & R, R> R ifBlank(C c, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{0, 85, 95, 7, 69, 95, 18, 55, 5, 91, 65, 7}, "d09f03fad74b", 0.0f));
        return StringsKt.isBlank(c) ? function0.invoke() : c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <C extends CharSequence & R, R> R ifEmpty(C c, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{84, 6, 81, 4, 69, 91, 77, 50, 86, 95, 64, 92}, "0c7e079d735966ff", 4));
        return c.length() == 0 ? function0.invoke() : c;
    }

    public static final int indexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{9, 17, 93, 95, 18, 10}, "5e56a4", 7));
        return (z || !(charSequence instanceof String)) ? StringsKt.indexOfAny(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{94, 65, 13, 89, 75, 12}, "b5e082ea56ae"));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{71, 65, 68, 93, 10, 86}, "4564d1", 0.0f));
        return (z || !(charSequence instanceof String)) ? indexOf$StringsKt__StringsKt$default(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    public static final int indexOfAny(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{8, 22, 89, 15, 65, 12}, "4b1f22", 2));
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{70, 76, 75, 81, 11, 2, 70}, "5898ee", false));
        Pair<Integer, String> pairFindAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, false);
        if (pairFindAnyOf$StringsKt__StringsKt != null) {
            return pairFindAnyOf$StringsKt__StringsKt.getFirst().intValue();
        }
        return -1;
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{95, 77, 12, 92, 23, 91}, "c9d5dee33af3e9", 0.0f));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{80, 95, 84, 23, 71}, "375e4e484fbf", 4));
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.single(cArr), i);
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        int lastIndex = StringsKt.getLastIndex(charSequence);
        if (iCoerceAtLeast > lastIndex) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iCoerceAtLeast);
            for (char c : cArr) {
                if (CharsKt.equals(c, cCharAt, z)) {
                    return iCoerceAtLeast;
                }
            }
            if (iCoerceAtLeast == lastIndex) {
                return -1;
            }
            iCoerceAtLeast++;
        }
    }

    public static final boolean isBlank(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{10, 64, 9, 95, 22, 10}, "64a6e4f2c6ea20"));
        for (int i = 0; i < charSequence.length(); i++) {
            if (!CharsKt.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static final boolean isEmpty(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{12, 71, 88, 88, 69, 15}, "030161", false));
        return charSequence.length() == 0;
    }

    private static final boolean isNotBlank(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{94, 69, 94, 93, 69, 93}, "b1646c7785813a59", 0.0f));
        return !StringsKt.isBlank(charSequence);
    }

    private static final boolean isNotEmpty(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{15, 68, 9, 12, 17, 6}, "30aeb8528f4f9c8a"));
        return charSequence.length() > 0;
    }

    public static final CharIterator iterator(final CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{89, 16, 10, 15, 16, 10}, "edbfc418"));
        return new CharIterator() { // from class: kotlin.text.StringsKt__StringsKt.iterator.1
            private int index;

            @Override // kotlin.collections.CharIterator
            public char nextChar() {
                CharSequence charSequence2 = charSequence;
                int i = this.index;
                this.index = i + 1;
                return charSequence2.charAt(i);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < charSequence.length();
            }
        };
    }

    public static final int lastIndexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{14, 68, 95, 11, 16, 15}, "207bc1fd04"));
        return (z || !(charSequence instanceof String)) ? StringsKt.lastIndexOfAny(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static final int lastIndexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{11, 16, 11, 80, 69, 9}, "7dc96703", true));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{22, 23, 20, 80, 86, 86}, "ecf981cd3ccfb4c4"));
        return (z || !(charSequence instanceof String)) ? indexOf$StringsKt__StringsKt(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{89, 65, 81, 80, 16, 92}, "e599cb", 0.0f));
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{66, 18, 71, 95, 10, 84, 68}, "1f56d3724c42"));
        Pair<Integer, String> pairFindAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, true);
        if (pairFindAnyOf$StringsKt__StringsKt != null) {
            return pairFindAnyOf$StringsKt__StringsKt.getFirst().intValue();
        }
        return -1;
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{10, 16, 12, 12, 68, 10}, "6dde74", 0.0f));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{6, 81, 3, 64, 21}, "e9b2f0ef4f44e2", 6));
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt.single(cArr), i);
        }
        for (int iCoerceAtMost = RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)); -1 < iCoerceAtMost; iCoerceAtMost--) {
            char cCharAt = charSequence.charAt(iCoerceAtMost);
            for (char c : cArr) {
                if (CharsKt.equals(c, cCharAt, z)) {
                    return iCoerceAtMost;
                }
            }
        }
        return -1;
    }

    public static final Sequence<String> lineSequence(final CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{11, 77, 13, 92, 23, 91}, "79e5def2"));
        return new Sequence<String>() { // from class: kotlin.text.StringsKt__StringsKt$lineSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<String> iterator() {
                return new LinesIterator(charSequence);
            }
        };
    }

    public static final List<String> lines(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{5, 18, 80, 88, 16, 9}, "9f81c7", false));
        return SequencesKt.toList(StringsKt.lineSequence(charSequence));
    }

    private static final boolean matches(CharSequence charSequence, Regex regex) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{11, 69, 88, 91, 70, 15}, "710251d174", true));
        Intrinsics.checkNotNullParameter(regex, C0000.decode(new byte[]{74, 7, 83, 87, 74}, "8b42281b1f", true));
        return regex.matches(charSequence);
    }

    private static final String orEmpty(String str) {
        return str == null ? "" : str;
    }

    public static final CharSequence padEnd(CharSequence charSequence, int i, char c) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{14, 65, 93, 94, 74, 88}, "25579f62fc979f"));
        if (i < 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{39, 84, 64, 80, 71, 82, 93, 65, 15, 84, 93, 94, 65, 95, 25}, "c139579a", true) + i + C0000.decode(new byte[]{17, 15, 16, 23, 9, 84, 64, 18, 17, 18, 11, 86, 11, 17, 73, 4, 67, 9, 77}, "1fc7e13a"));
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append(charSequence);
        int length = i - charSequence.length();
        int i2 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return sb;
    }

    public static final String padEnd(String str, int i, char c) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{88, 23, 88, 93, 69, 8}, "dc0466c197fa", 0.0f));
        return StringsKt.padEnd((CharSequence) str, i, c).toString();
    }

    public static final CharSequence padStart(CharSequence charSequence, int i, char c) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{88, 70, 88, 92, 66, 13}, "d20513", 6));
        if (i < 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{37, 6, 22, 11, 69, 4, 93, 17, 8, 7, 94, 94, 21, 11, 69}, "aceb7a91db09", 1) + i + C0000.decode(new byte[]{65, 91, 17, 67, 10, 81, 18, 69, 17, 23, 9, 4, 15, 18, 24, 6, 20, 91, 79}, "a2bcf4a61cae"));
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        int length = i - charSequence.length();
        int i2 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    public static final String padStart(String str, int i, char c) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{8, 64, 88, 11, 68, 13}, "440b73d4"));
        return StringsKt.padStart((CharSequence) str, i, c).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair rangesDelimitedBy$lambda$14$StringsKt__StringsKt(char[] cArr, boolean z, CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{71, 18, 95, 80, 65, 66, 117, 87, 94, 88, 95, 91, 22, 3, 7, 48, 2, 8, 80, 92, 65, 53, 84, 67, 71, 84, 92, 81, 7}, "cf792f122122bfcb", 3));
        int iIndexOfAny = StringsKt.indexOfAny(charSequence, cArr, i, z);
        if (iIndexOfAny < 0) {
            return null;
        }
        return TuplesKt.to(Integer.valueOf(iIndexOfAny), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair rangesDelimitedBy$lambda$16$StringsKt__StringsKt(List list, boolean z, CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{28, 64, 95, 8, 65, 66, 118, 7, 84, 93, 90, 8, 70, 3, 86, 48, 89, 90, 80, 4, 65, 53, 87, 19, 77, 81, 89, 2, 87}, "847a2f2b", 0.0f));
        Pair<Integer, String> pairFindAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, list, i, z, false);
        if (pairFindAnyOf$StringsKt__StringsKt != null) {
            return TuplesKt.to(pairFindAnyOf$StringsKt__StringsKt.getFirst(), Integer.valueOf(pairFindAnyOf$StringsKt__StringsKt.getSecond().length()));
        }
        return null;
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{93, 18, 95, 92, 22, 11}, "af75e5063995228f", false));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{93, 77, 90, 82, 19}, "2927af63"));
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final CharSequence removePrefix(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{95, 66, 10, 13, 68, 91}, "c6bd7ece86e25c0e", 7));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{64, 64, 0, 82, 13, 76}, "02e4d4c1307996d0"));
        return StringsKt.startsWith$default(charSequence, charSequence2, false, 2, (Object) null) ? charSequence.subSequence(charSequence2.length(), charSequence.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final String removePrefix(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{14, 71, 12, 88, 17, 12}, "23d1b209248c"));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{70, 75, 1, 82, 90, 78}, "69d436d8", 0.0f));
        if (!StringsKt.startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{69, 19, 3, 74, 21, 68, 11, 91, 87, 16, 31, 24, 24, 79}, "6fa9a6b50816", 2));
        return strSubstring;
    }

    public static final CharSequence removeRange(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{9, 18, 91, 88, 69, 90}, "5f316d", true));
        if (i2 < i) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{117, 91, 2, 68, 10, 95, 87, 4, 72, 21, 78}, "05fdc13a", 1) + i2 + C0000.decode(new byte[]{26, 16, 13, 18, 18, 94, 86, 67, 23, 65, 70, 90, 82, 94, 68, 18, 70, 83, 65, 68, 68, 8, 92, 86, 86, 72, 68, 73}, "30da22", false) + i + C0000.decode(new byte[]{74, 22}, "c8bb9629", 0));
        }
        if (i2 == i) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(charSequence.length() - (i2 - i));
        StringBuilder sbAppend = sb.append(charSequence, 0, i);
        String strDecode = C0000.decode(new byte[]{81, 19, 17, 82, 93, 82, 30, 22, 76, 74, 16}, "0ca73668bd9e19");
        Intrinsics.checkNotNullExpressionValue(sbAppend, strDecode);
        Intrinsics.checkNotNullExpressionValue(sb.append(charSequence, i2, charSequence.length()), strDecode);
        return sb;
    }

    public static final CharSequence removeRange(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{13, 77, 11, 91, 17, 10}, "19c2b42e", 0.0f));
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{20, 3, 89, 86, 85}, "fb7107f2", 4));
        return StringsKt.removeRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    private static final String removeRange(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 22, 12, 10, 64, 8}, "abdc3617", 0.0f));
        return StringsKt.removeRange((CharSequence) str, i, i2).toString();
    }

    private static final String removeRange(String str, IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{12, 22, 12, 91, 65, 12}, "0bd22258", 0.0f));
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{19, 89, 88, 87, 4}, "a860a62accaade", true));
        return StringsKt.removeRange((CharSequence) str, intRange).toString();
    }

    public static final CharSequence removeSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{93, 68, 90, 93, 71, 93}, "a0244c05", 0.0f));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{64, 16, 3, 80, 15, 77}, "3ee6f52acd"));
        return StringsKt.endsWith$default(charSequence, charSequence2, false, 2, (Object) null) ? charSequence.subSequence(0, charSequence.length() - charSequence2.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final String removeSuffix(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{11, 18, 13, 12, 67, 8}, "7fee069ed5", 3));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{68, 76, 86, 94, 93, 25}, "79084a"));
        if (!StringsKt.endsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{23, 17, 6, 71, 65, 22, 91, 13, 87, 78, 29, 79, 72, 17}, "ddd45d2c0f3af8", 0.0f));
        return strSubstring;
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{15, 21, 14, 92, 70, 7}, "3af55965", 0.0f));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{81, 6, 91, 95, 15, 10, 65, 6, 69}, "5c76bc", true));
        return StringsKt.removeSurrounding(charSequence, charSequence2, charSequence2);
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{12, 71, 81, 91, 23, 15}, "0392d17096e8", 0.0f));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{22, 66, 1, 7, 91, 74}, "f0da22c2f2", 2));
        Intrinsics.checkNotNullParameter(charSequence3, C0000.decode(new byte[]{74, 66, 0, 85, 92, 73}, "97f351", 4));
        return (charSequence.length() >= charSequence2.length() + charSequence3.length() && StringsKt.startsWith$default(charSequence, charSequence2, false, 2, (Object) null) && StringsKt.endsWith$default(charSequence, charSequence3, false, 2, (Object) null)) ? charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final String removeSurrounding(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 65, 91, 15, 64, 11}, "153f35"));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{1, 86, 85, 81, 94, 15, 66, 6, 20}, "e3983f6cf2", 0.0f));
        return StringsKt.removeSurrounding(str, charSequence, charSequence);
    }

    public static final String removeSurrounding(String str, CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{10, 16, 90, 90, 16, 13}, "6d23c3808738", 4));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{19, 70, 80, 83, 88, 29}, "c4551e5bc712050a"));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{69, 64, 81, 2, 80, 29}, "657d9effb2e84707"));
        if (str.length() < charSequence.length() + charSequence2.length()) {
            return str;
        }
        String str2 = str;
        if (!StringsKt.startsWith$default((CharSequence) str2, charSequence, false, 2, (Object) null) || !StringsKt.endsWith$default((CharSequence) str2, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{18, 64, 81, 17, 77, 22, 8, 91, 84, 74, 23, 74, 79, 28}, "a53b9d"));
        return strSubstring;
    }

    private static final String replace(CharSequence charSequence, Regex regex, String str) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{4, 77, 91, 94, 18, 11}, "8937a534483f32bd", 4));
        Intrinsics.checkNotNullParameter(regex, C0000.decode(new byte[]{19, 0, 6, 85, 75}, "aea035b0600d42", 0.0f));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{19, 84, 73, 91, 4, 6, 81, 90, 0, 10, 21}, "a197ee47ed"));
        return regex.replace(charSequence, str);
    }

    private static final String replace(CharSequence charSequence, Regex regex, Function1<? super MatchResult, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{88, 21, 80, 8, 16, 91}, "da8ace5e", true));
        Intrinsics.checkNotNullParameter(regex, C0000.decode(new byte[]{75, 85, 85, 7, 28}, "902bd663a1ea20a5", 0));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{65, 70, 2, 91, 71, 86, 13, 19, 9}, "54c540bad0abd9", 0));
        return regex.replace(charSequence, function1);
    }

    public static final String replaceAfter(String str, char c, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{14, 21, 9, 11, 74, 88}, "2aab9f1620bf1c", 0.0f));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{23, 87, 67, 15, 82, 90, 80, 9, 81, 91, 17}, "e23c395d45"));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{15, 90, 71, 67, 10, 92, 5, 39, 7, 95, 93, 93, 10, 70, 7, 17, 52, 82, 88, 69, 6}, "b340c2bc", 0.0f));
        String str4 = str;
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str4, c, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? str3 : StringsKt.replaceRange((CharSequence) str4, iIndexOf$default + 1, str.length(), (CharSequence) str2).toString();
    }

    public static final String replaceAfter(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 23, 13, 95, 23, 15}, "ece6d1", 0.0f));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{2, 85, 92, 11, 92, 93, 71, 84, 19}, "f00b1431a9bf"));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{67, 86, 70, 84, 80, 82, 84, 94, 83, 86, 69}, "136811"));
        Intrinsics.checkNotNullParameter(str4, C0000.decode(new byte[]{11, 80, 74, 17, 12, 11, 1, 125, 92, 14, 12, 8, 15, 77, 92, 16, 51, 4, 10, 76, 92}, "f99bee", 0.0f));
        String str5 = str;
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? str4 : StringsKt.replaceRange((CharSequence) str5, iIndexOf$default + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    public static final String replaceAfterLast(String str, char c, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 76, 89, 93, 70, 93}, "88145c1a64fdcd", 0));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{19, 87, 72, 90, 82, 1, 4, 95, 93, 88, 71}, "a2863b", 0.0f));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{84, 12, 22, 21, 11, 8, 87, 118, 83, 84, 8, 90, 94, 16, 92, 23, 51, 7, 14, 19, 85}, "9eefbf0268a77d"));
        String str4 = str;
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str4, c, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str3 : StringsKt.replaceRange((CharSequence) str4, iLastIndexOf$default + 1, str.length(), (CharSequence) str2).toString();
    }

    public static final String replaceAfterLast(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 70, 12, 80, 70, 88}, "12d95f27eb", 0.0f));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{87, 81, 10, 12, 85, 94, 67, 83, 16}, "34fe8776bc", 0));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{22, 87, 72, 9, 87, 5, 1, 95, 93, 11, 66}, "d28e6f", false));
        Intrinsics.checkNotNullParameter(str4, C0000.decode(new byte[]{15, 10, 16, 16, 95, 87, 5, 39, 6, 15, 95, 84, 11, 23, 6, 17, 96, 88, 14, 22, 6}, "bccc69", 0.0f));
        String str5 = str;
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str4 : StringsKt.replaceRange((CharSequence) str5, iLastIndexOf$default + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    public static final String replaceBefore(String str, char c, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{90, 67, 14, 89, 16, 91}, "f7f0ce00", false));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{64, 82, 64, 89, 86, 87, 87, 90, 85, 91, 67}, "270574", 0.0f));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{91, 80, 66, 65, 15, 13, 80, 116, 0, 94, 12, 95, 92, 18, 83, 75, 103, 83, 10, 22, 82}, "6912fc70e2e25f", 5));
        String str4 = str;
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str4, c, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? str3 : StringsKt.replaceRange((CharSequence) str4, 0, iIndexOf$default, (CharSequence) str2).toString();
    }

    public static final String replaceBefore(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 18, 92, 11, 16, 10}, "8f4bc494f5ce87cb", 0.0f));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{2, 93, 91, 11, 85, 88, 18, 93, 69}, "f87b81", 0.0f));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{69, 1, 70, 90, 83, 85, 6, 90, 82, 10, 66}, "7d6626c7", false));
        Intrinsics.checkNotNullParameter(str4, C0000.decode(new byte[]{89, 15, 66, 74, 95, 8, 83, 34, 84, 85, 95, 11, 93, 18, 84, 75, 96, 7, 88, 19, 84}, "4f196f", 4));
        String str5 = str;
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? str4 : StringsKt.replaceRange((CharSequence) str5, 0, iIndexOf$default, (CharSequence) str3).toString();
    }

    public static final String replaceBeforeLast(String str, char c, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{10, 77, 81, 10, 67, 92}, "699c0b5859", 0.0f));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{19, 4, 66, 94, 87, 7, 81, 88, 3, 87, 64}, "aa226d45f94e21", false));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{84, 94, 67, 75, 89, 95, 2, 125, 87, 9, 90, 94, 80, 67, 85, 74, 102, 80, 9, 76, 87}, "970801e92e33", 0.0f));
        String str4 = str;
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str4, c, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str3 : StringsKt.replaceRange((CharSequence) str4, 0, iLastIndexOf$default, (CharSequence) str2).toString();
    }

    public static final String replaceBeforeLast(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{94, 64, 95, 81, 75, 7}, "b47889c487be7942"));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{7, 82, 90, 95, 8, 90, 23, 82, 68}, "c766e3", true));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{67, 83, 64, 88, 84, 81, 86, 8, 1, 15, 64}, "1604523eda468f", 5));
        Intrinsics.checkNotNullParameter(str4, C0000.decode(new byte[]{14, 94, 16, 17, 94, 89, 80, 114, 6, 91, 10, 15, 94, 67, 82, 68, 53, 86, 15, 23, 82}, "c7cb7776", 7));
        String str5 = str;
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str4 : StringsKt.replaceRange((CharSequence) str5, 0, iLastIndexOf$default, (CharSequence) str3).toString();
    }

    private static final String replaceFirst(CharSequence charSequence, Regex regex, String str) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{88, 70, 91, 13, 70, 6}, "d23d584dfede62", 0));
        Intrinsics.checkNotNullParameter(regex, C0000.decode(new byte[]{22, 6, 95, 6, 27}, "dc8ccf252f3d7a27", true));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{64, 83, 71, 93, 0, 82, 3, 95, 0, 89, 66}, "2671a1f2e764b0"));
        return regex.replaceFirst(charSequence, str);
    }

    private static final String replaceFirstCharWithChar(String str, Function1<? super Character, Character> function1) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 77, 81, 80, 70, 93}, "e9995c119ab27f"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{64, 65, 3, 10, 69, 82, 10, 17, 93}, "43bd64ec01b3", false));
        if (str.length() <= 0) {
            return str;
        }
        char cCharValue = function1.invoke(Character.valueOf(str.charAt(0))).charValue();
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{67, 69, 91, 74, 21, 17, 89, 12, 4, 24, 30, 31, 31, 30}, "0099ac0bc00117a8", true));
        return cCharValue + strSubstring;
    }

    private static final String replaceFirstCharWithCharSequence(String str, Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 71, 10, 95, 64, 11}, "e3b635a8ba", 6));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{23, 75, 0, 92, 23, 2, 93, 68, 14}, "c9a2dd26"));
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sbAppend = new StringBuilder().append((Object) function1.invoke(Character.valueOf(str.charAt(0))));
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{65, 71, 90, 16, 66, 69, 91, 92, 95, 75, 24, 25, 28, 27}, "228c67", 7));
        return sbAppend.append(strSubstring).toString();
    }

    public static final CharSequence replaceRange(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{90, 22, 94, 13, 22, 90}, "fb6ded", 0.0f));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{70, 6, 20, 89, 84, 80, 6, 90, 4, 95, 64}, "4cd553c7a1", false));
        if (i2 < i) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{119, 95, 1, 22, 11, 94, 6, 6, 77, 16, 26}, "21e6b0bc50") + i2 + C0000.decode(new byte[]{17, 69, 89, 64, 18, 90, 0, 69, 75, 69, 68, 91, 83, 88, 69, 69, 76, 4, 66, 71, 18, 95, 11, 82, 93, 29, 16, 27}, "8e0326e6", false) + i + C0000.decode(new byte[]{74, 77}, "cca1b8", 1));
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAppend = sb.append(charSequence, 0, i);
        String strDecode = C0000.decode(new byte[]{4, 72, 20, 86, 12, 81, 27, 79, 77, 22, 79}, "e8d3b53ac8f3");
        Intrinsics.checkNotNullExpressionValue(sbAppend, strDecode);
        sb.append(charSequence2);
        Intrinsics.checkNotNullExpressionValue(sb.append(charSequence, i2, charSequence.length()), strDecode);
        return sb;
    }

    public static final CharSequence replaceRange(CharSequence charSequence, IntRange intRange, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{5, 22, 92, 93, 21, 14}, "9b44f00e9f3a3c", 7));
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{69, 4, 95, 85, 4}, "7e12a28baf2915"));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{69, 87, 68, 13, 82, 83, 3, 15, 4, 88, 67}, "724a30fba6", true));
        return StringsKt.replaceRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1, charSequence2);
    }

    private static final String replaceRange(String str, int i, int i2, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 69, 94, 13, 71, 14}, "e16d409bed6111b6", 7));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{67, 85, 20, 9, 5, 5, 81, 9, 84, 94, 16}, "10dedf4d", 7));
        return StringsKt.replaceRange((CharSequence) str, i, i2, charSequence).toString();
    }

    private static final String replaceRange(String str, IntRange intRange, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{94, 67, 94, 12, 68, 88}, "b76e7f75ca37", 0.0f));
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{23, 7, 95, 95, 83}, "ef18668159da93", false));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{68, 1, 72, 92, 7, 0, 0, 92, 92, 93, 66}, "6d80fce193", false));
        return StringsKt.replaceRange((CharSequence) str, intRange, charSequence).toString();
    }

    public static final void requireNonNegativeLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{47, 94, 9, 11, 68, 16, 95, 20, 75, 16, 16, 6, 81, 23, 8, 86, 13, 26, 10, 7, 87, 81, 70, 8, 78, 1, 28, 68, 86, 66, 18, 25, 20, 86, 23, 66}, "c7db002a8d0d47f9") + i).toString());
        }
    }

    private static final List<String> split(CharSequence charSequence, Regex regex, int i) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{11, 21, 92, 94, 68, 95}, "7a477abcf0", true));
        Intrinsics.checkNotNullParameter(regex, C0000.decode(new byte[]{69, 0, 86, 93, 30}, "7e18f4425074"));
        return regex.split(charSequence, i);
    }

    public static final List<String> split(CharSequence charSequence, char[] cArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{12, 21, 91, 89, 23, 15}, "0a30d1f068", true));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{86, 87, 91, 15, 84, 80, 17, 4, 70, 67}, "227f99ea403c7d", 2));
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable iterableAsIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static final List<String> split(CharSequence charSequence, String[] strArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{13, 68, 89, 15, 71, 92}, "101f4b", 0.0f));
        Intrinsics.checkNotNullParameter(strArr, C0000.decode(new byte[]{83, 7, 85, 80, 91, 10, 68, 1, 69, 17}, "7b996c0d", true));
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return split$StringsKt__StringsKt(charSequence, str, z, i);
            }
        }
        Iterable iterableAsIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    static /* synthetic */ List split$default(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{95, 22, 92, 8, 65, 8}, "cb4a26f308c5b9b6", 2));
        Intrinsics.checkNotNullParameter(regex, C0000.decode(new byte[]{70, 81, 94, 86, 27}, "4493c0f8d2f871", 4));
        return regex.split(charSequence, i);
    }

    private static final Sequence<String> splitToSequence(CharSequence charSequence, Regex regex, int i) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{90, 18, 90, 90, 17, 88}, "ff23bff1642dea"));
        Intrinsics.checkNotNullParameter(regex, C0000.decode(new byte[]{66, 83, 2, 7, 65}, "06eb95ec4c8b4e27", true));
        return regex.splitToSequence(charSequence, i);
    }

    public static final Sequence<String> splitToSequence(final CharSequence charSequence, char[] cArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{5, 65, 88, 91, 67, 92}, "95020b060f15f2c1"));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{83, 81, 85, 11, 84, 93, 70, 1, 71, 17}, "749b942d5baa7d", false));
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null), new Function1() { // from class: kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StringsKt__StringsKt.splitToSequence$lambda$20$StringsKt__StringsKt(charSequence, (IntRange) obj);
            }
        });
    }

    public static final Sequence<String> splitToSequence(final CharSequence charSequence, String[] strArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{5, 77, 93, 10, 18, 15}, "995ca1778f", 0.0f));
        Intrinsics.checkNotNullParameter(strArr, C0000.decode(new byte[]{0, 92, 84, 90, 95, 8, 77, 0, 20, 23}, "d9832a9efd", false));
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null), new Function1() { // from class: kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StringsKt__StringsKt.splitToSequence$lambda$18$StringsKt__StringsKt(charSequence, (IntRange) obj);
            }
        });
    }

    static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{88, 18, 80, 91, 75, 6}, "df8288", false));
        Intrinsics.checkNotNullParameter(regex, C0000.decode(new byte[]{70, 81, 1, 84, 64}, "44f18f01e68aecd2"));
        return regex.splitToSequence(charSequence, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String splitToSequence$lambda$18$StringsKt__StringsKt(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{90, 65}, "35af52c44c", 0.0f));
        return StringsKt.substring(charSequence, intRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String splitToSequence$lambda$20$StringsKt__StringsKt(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{92, 64}, "5437b880"));
        return StringsKt.substring(charSequence, intRange);
    }

    public static final boolean startsWith(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{12, 22, 92, 90, 22, 9}, "0b43e7a24227f5f7", 2));
        return charSequence.length() > 0 && CharsKt.equals(charSequence.charAt(0), c, z);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{94, 77, 10, 91, 69, 9}, "b9b26793e0", true));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{69, 67, 86, 95, 90, 27}, "51393c343959c0", 0.0f));
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? StringsKt.startsWith$default((String) charSequence, (String) charSequence2, i, false, 4, (Object) null) : StringsKt.regionMatchesImpl(charSequence, i, charSequence2, 0, charSequence2.length(), z);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{14, 76, 13, 90, 66, 15}, "28e311"));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{69, 17, 85, 5, 81, 79}, "5c0c87", true));
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? StringsKt.startsWith$default((String) charSequence, (String) charSequence2, false, 2, (Object) null) : StringsKt.regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static final CharSequence subSequence(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{90, 21, 10, 94, 22, 93}, "fab7ec328b84", 0.0f));
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{19, 86, 86, 81, 85}, "a7860e0dd3c6dd", 0.0f));
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    private static final CharSequence subSequence(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 76, 13, 8, 71, 93}, "18ea4c63cc0d", 0.0f));
        return str.subSequence(i, i2);
    }

    private static final String substring(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{89, 65, 80, 93, 74, 15}, "e5849173d3e1", 2));
        return charSequence.subSequence(i, i2).toString();
    }

    public static final String substring(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{93, 68, 13, 8, 18, 90}, "a0eaad", true));
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{22, 89, 88, 6, 92}, "d86a9e2ad9", 0.0f));
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1).toString();
    }

    public static final String substring(String str, IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 64, 94, 81, 67, 13}, "146803fdfe7b", 0.0f));
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{65, 88, 90, 82, 85}, "3945043ae9fd230c", false));
        String strSubstring = str.substring(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{68, 20, 0, 75, 18, 64, 90, 94, 83, 74, 22, 74, 29, 29}, "7ab8f2304b8d340e"));
        return strSubstring;
    }

    static /* synthetic */ String substring$default(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{90, 71, 88, 80, 18, 95}, "f309aa", 0.0f));
        return charSequence.subSequence(i, i2).toString();
    }

    public static final String substringAfter(String str, char c, String str2) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{90, 22, 12, 95, 66, 13}, "fbd6138fcd03"));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{89, 8, 64, 66, 15, 8, 2, 32, 81, 13, 90, 92, 15, 18, 0, 22, 98, 0, 95, 68, 3}, "4a31ffed", 0));
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(iIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{65, 71, 83, 23, 16, 74, 88, 91, 4, 28, 23, 22, 28, 27}, "221dd815c498"));
        return strSubstring;
    }

    public static final String substringAfter(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{88, 22, 88, 91, 17, 15}, "db02b1eb", true));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{93, 85, 88, 89, 8, 89, 70, 87, 75}, "9040e022", true));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{93, 11, 71, 21, 90, 13, 81, 39, 0, 85, 15, 88, 89, 22, 81, 20, 101, 2, 90, 22, 0}, "0b4f3c6ce9f5"));
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str3;
        }
        String strSubstring = str.substring(iIndexOf$default + str2.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{18, 76, 3, 68, 16, 66, 11, 12, 83, 78, 23, 72, 76, 30}, "a9a7d0bb4f9fb70e", 0.0f));
        return strSubstring;
    }

    public static final String substringAfterLast(String str, char c, String str2) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{11, 69, 11, 89, 75, 88}, "71c08f3babf6", 3));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{84, 91, 17, 17, 8, 90, 3, 125, 86, 95, 15, 12, 80, 70, 7, 16, 55, 85, 8, 76, 86}, "92bba4d933fa", 0.0f));
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(iLastIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{67, 76, 86, 16, 66, 66, 93, 91, 81, 78, 30, 23, 26, 74}, "094c60456f"));
        return strSubstring;
    }

    public static final String substringAfterLast(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{5, 76, 93, 11, 65, 15}, "985b214bd7", 0));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{6, 93, 14, 13, 92, 90, 23, 82, 64}, "b8bd13c727"));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{12, 88, 22, 22, 91, 11, 6, 117, 0, 9, 91, 8, 8, 69, 0, 23, 100, 4, 13, 68, 0}, "a1ee2e", 1));
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str3;
        }
        String strSubstring = str.substring(iLastIndexOf$default + str2.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{68, 23, 84, 23, 18, 70, 90, 12, 85, 77, 25, 23, 77, 17}, "7b6df43b2e79c8ec", true));
        return strSubstring;
    }

    public static final String substringBefore(String str, char c, String str2) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{8, 22, 93, 89, 21, 8}, "4b50f6e8", 1));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{94, 11, 74, 71, 89, 89, 82, 32, 87, 91, 88, 9, 8, 68, 82, 65, 101, 3, 85, 65, 85}, "3b94075d271da073", false));
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{67, 65, 82, 71, 69, 70, 8, 95, 5, 75, 30, 26, 30, 29}, "040414a1bc", 6));
        return strSubstring;
    }

    public static final String substringBefore(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 77, 91, 15, 75, 8}, "a93f86482d", 0.0f));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{92, 4, 14, 95, 14, 94, 23, 6, 22}, "8ab6c7ccd8", true));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{12, 11, 16, 75, 15, 13, 6, 38, 6, 84, 15, 14, 8, 22, 6, 74, 48, 2, 13, 23, 6}, "abc8fc", 0.0f));
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{17, 16, 82, 64, 67, 19, 11, 11, 87, 27, 25, 79, 76, 76}, "be037a", 0.0f));
        return strSubstring;
    }

    public static final String substringBeforeLast(String str, char c, String str2) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{95, 21, 88, 94, 21, 11}, "ca07f564f8927d", 7));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{91, 12, 18, 23, 89, 86, 87, 118, 83, 9, 8, 9, 89, 76, 85, 64, 96, 4, 13, 17, 85}, "6ead0802", 0.0f));
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{74, 68, 87, 70, 68, 65, 15, 8, 85, 76, 29, 75, 75, 72}, "915503ff2d3eea", 0.0f));
        return strSubstring;
    }

    public static final String substringBeforeLast(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 76, 13, 12, 22, 11}, "88eee59a88bc"));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{92, 92, 8, 92, 11, 15, 68, 80, 67}, "89d5ff051b4abb"));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{9, 15, 71, 71, 8, 11, 85, 32, 1, 10, 93, 89, 8, 17, 87, 22, 50, 7, 88, 65, 4}, "df44ae2d", false));
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{68, 23, 80, 68, 77, 64, 93, 88, 95, 78, 77, 75, 27, 76}, "7b2792468fce5e7a", 4));
        return strSubstring;
    }

    public static final boolean toBooleanStrict(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 21, 9, 15, 75, 92}, "eaaf8bd5ce5e"));
        if (Intrinsics.areEqual(str, C0000.decode(new byte[]{65, 17, 19, 87}, "5cf289457854", 0.0f))) {
            return true;
        }
        if (Intrinsics.areEqual(str, C0000.decode(new byte[]{0, 7, 15, 69, 85}, "ffc60fbde47bf1c9", 5))) {
            return false;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{53, 89, 1, 17, 75, 71, 16, 94, 88, 5, 22, 5, 95, 85, 69, 88, 70, 69, 68, 67, 93, 67, 16, 82, 69, 7, 88, 21, 16, 81, 22, 84, 14, 94, 8, 84, 89, 93, 66, 65, 87, 14, 67, 4, 10, 16}, "a1d183b76b6a0066", 6) + str);
    }

    public static final Boolean toBooleanStrictOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{12, 69, 12, 90, 17, 9}, "01d3b79f98", 0.0f));
        if (Intrinsics.areEqual(str, C0000.decode(new byte[]{17, 70, 22, 93}, "e4c8e36ad3a236", false))) {
            return true;
        }
        return Intrinsics.areEqual(str, C0000.decode(new byte[]{0, 89, 94, 16, 4}, "f82cae7e29c545", 1)) ? false : null;
    }

    public static final CharSequence trim(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{93, 76, 95, 89, 67, 6}, "a8700885ab29cf26", 0));
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zIsWhitespace = CharsKt.isWhitespace(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zIsWhitespace) {
                    break;
                }
                length--;
            } else if (zIsWhitespace) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final CharSequence trim(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{9, 67, 95, 90, 74, 6}, "577398d2", 6));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{22, 23, 81, 81, 10, 91, 7, 17, 81}, "fe45c8"));
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zBooleanValue = function1.invoke(Character.valueOf(charSequence.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final CharSequence trim(CharSequence charSequence, char... cArr) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{5, 76, 12, 88, 17, 11}, "98d1b568039cf8", false));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{86, 91, 82, 68, 67}, "53360fbe1279c5", 4));
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zContains = ArraysKt.contains(cArr, charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zContains) {
                    break;
                }
                length--;
            } else if (zContains) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    private static final String trim(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 70, 13, 94, 74, 9}, "12e797b979c26183", 3));
        return StringsKt.trim((CharSequence) str).toString();
    }

    public static final String trim(String str, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{90, 66, 94, 12, 68, 15}, "f66e7178ee032e", 0));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{71, 64, 85, 0, 10, 87, 82, 77, 3}, "720dc439fe", 0.0f));
        String str2 = str;
        int length = str2.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zBooleanValue = function1.invoke(Character.valueOf(str2.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return str2.subSequence(i, length + 1).toString();
    }

    public static final String trim(String str, char... cArr) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 67, 89, 13, 69, 13}, "871d63dfd0bb4c"));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{0, 12, 2, 20, 70}, "cdcf5e", 0.0f));
        String str2 = str;
        int length = str2.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zContains = ArraysKt.contains(cArr, str2.charAt(!z ? i : length));
            if (z) {
                if (!zContains) {
                    break;
                }
                length--;
            } else if (zContains) {
                i++;
            } else {
                z = true;
            }
        }
        return str2.subSequence(i, length + 1).toString();
    }

    public static final CharSequence trimEnd(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{11, 64, 93, 12, 66, 11}, "745e156a4db54029", 6));
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!CharsKt.isWhitespace(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i >= 0) {
                    length = i;
                }
            }
        }
        return "";
    }

    public static final CharSequence trimEnd(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{90, 22, 89, 92, 67, 13}, "fb1503055156", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{71, 20, 92, 87, 13, 5, 0, 71, 80}, "7f93dfa35b990643"));
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!function1.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i >= 0) {
                    length = i;
                }
            }
        }
        return "";
    }

    public static final CharSequence trimEnd(CharSequence charSequence, char... cArr) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{12, 67, 10, 10, 22, 93}, "07bcec34", 0.0f));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{91, 9, 5, 70, 68}, "8ad47ab621e72300", 1));
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!ArraysKt.contains(cArr, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i >= 0) {
                    length = i;
                }
            }
        }
        return "";
    }

    private static final String trimEnd(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{14, 71, 92, 89, 16, 95}, "2340ca20996f"));
        return StringsKt.trimEnd((CharSequence) str).toString();
    }

    public static final String trimEnd(String str, Function1<? super Character, Boolean> function1) {
        String strSubSequence;
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{11, 70, 95, 88, 67, 10}, "72710488"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{64, 22, 93, 92, 15, 86, 7, 23, 93}, "0d88f5fc89930553", 0.0f));
        String str2 = str;
        int length = str2.length() - 1;
        if (length < 0) {
            break;
        }
        while (true) {
            int i = length - 1;
            if (!function1.invoke(Character.valueOf(str2.charAt(length))).booleanValue()) {
                strSubSequence = str2.subSequence(0, length + 1);
                break;
            }
            if (i < 0) {
                break;
            }
            length = i;
        }
        return strSubSequence.toString();
    }

    public static final String trimEnd(String str, char... cArr) {
        String strSubSequence;
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{10, 21, 14, 88, 67, 13}, "6af10388", false));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{7, 14, 0, 16, 21}, "dfabff6b56987060", 0.0f));
        String str2 = str;
        int length = str2.length() - 1;
        if (length < 0) {
            break;
        }
        while (true) {
            int i = length - 1;
            if (!ArraysKt.contains(cArr, str2.charAt(length))) {
                strSubSequence = str2.subSequence(0, length + 1);
                break;
            }
            if (i < 0) {
                break;
            }
            length = i;
        }
        return strSubSequence.toString();
    }

    public static final CharSequence trimStart(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{5, 77, 10, 13, 68, 8}, "99bd768e175d13f7", 5));
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt.isWhitespace(charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static final CharSequence trimStart(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{95, 18, 12, 11, 18, 9}, "cfdba7fd369d19", true));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{20, 20, 4, 85, 90, 1, 81, 16, 84}, "dfa13b0d106e8eba"));
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!function1.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static final CharSequence trimStart(CharSequence charSequence, char... cArr) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{89, 64, 93, 12, 68, 6}, "e45e780d5663", true));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{90, 14, 89, 67, 16}, "9f81cf21738ed1e3", 0.0f));
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!ArraysKt.contains(cArr, charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    private static final String trimStart(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 70, 13, 12, 67, 7}, "a2ee096417f1dbdf"));
        return StringsKt.trimStart((CharSequence) str).toString();
    }

    public static final String trimStart(String str, Function1<? super Character, Boolean> function1) {
        String strSubSequence;
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 18, 90, 89, 71, 91}, "1f204eade3", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{64, 67, 93, 87, 91, 82, 7, 18, 3}, "018321fff47772", 0.0f));
        String str2 = str;
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            if (!function1.invoke(Character.valueOf(str2.charAt(i))).booleanValue()) {
                strSubSequence = str2.subSequence(i, str2.length());
                return strSubSequence.toString();
            }
        }
        return strSubSequence.toString();
    }

    public static final String trimStart(String str, char... cArr) {
        String strSubSequence;
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{15, 70, 95, 90, 75, 10}, "3273840e2f", 7));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{7, 90, 86, 20, 65}, "d27f2ed6b0cc0a", 0.0f));
        String str2 = str;
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            if (!ArraysKt.contains(cArr, str2.charAt(i))) {
                strSubSequence = str2.subSequence(i, str2.length());
                return strSubSequence.toString();
            }
        }
        return strSubSequence.toString();
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padStart(charSequence, i, c);
    }

    public static /* synthetic */ String padStart$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padStart(str, i, c);
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padEnd(charSequence, i, c);
    }

    public static /* synthetic */ String padEnd$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padEnd(str, i, c);
    }

    private static final boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    private static final boolean isNullOrBlank(CharSequence charSequence) {
        return charSequence == null || StringsKt.isBlank(charSequence);
    }

    public static /* synthetic */ String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringBefore(str, c, str2);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringBefore(str, str2, str3);
    }

    public static /* synthetic */ String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfter(str, c, str2);
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringAfter(str, str2, str3);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringBeforeLast(str, c, str2);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringBeforeLast(str, str2, str3);
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfterLast(str, c, str2);
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringAfterLast(str, str2, str3);
    }

    public static /* synthetic */ String replaceBefore$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceBefore(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceBefore(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceAfter$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceAfter(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceAfter(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceAfterLast(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceAfterLast(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceBeforeLast(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceBeforeLast(str, str2, str3, str4);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, c, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(charSequence, c, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, i, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.commonPrefixWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.commonSuffixWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOfAny(charSequence, cArr, i, z);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, cArr, i, z);
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, z2);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntRange intRangeDownTo;
        if (!z2) {
            intRangeDownTo = new IntRange(RangesKt.coerceAtLeast(i, 0), RangesKt.coerceAtMost(i2, charSequence.length()));
        } else {
            intRangeDownTo = RangesKt.downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), RangesKt.coerceAtLeast(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = intRangeDownTo.getFirst();
            int last = intRangeDownTo.getLast();
            int step = intRangeDownTo.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return -1;
            }
            int i3 = first;
            while (true) {
                String str = (String) charSequence2;
                boolean z3 = z;
                if (StringsKt.regionMatches(str, 0, (String) charSequence, i3, str.length(), z3)) {
                    return i3;
                }
                if (i3 == last) {
                    return -1;
                }
                i3 += step;
                z = z3;
            }
        } else {
            boolean z4 = z;
            int first2 = intRangeDownTo.getFirst();
            int last2 = intRangeDownTo.getLast();
            int step2 = intRangeDownTo.getStep();
            if ((step2 <= 0 || first2 > last2) && (step2 >= 0 || last2 > first2)) {
                return -1;
            }
            int i4 = first2;
            while (true) {
                boolean z5 = z4;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z4 = z5;
                if (StringsKt.regionMatchesImpl(charSequence4, 0, charSequence3, i4, charSequence2.length(), z5)) {
                    return i4;
                }
                if (i4 == last2) {
                    return -1;
                }
                i4 += step2;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        CharSequence charSequence2;
        Object next;
        boolean z3;
        Object next2;
        if (!z && collection.size() == 1) {
            String str = (String) CollectionsKt.single(collection);
            int iIndexOf$default = !z2 ? StringsKt.indexOf$default(charSequence, str, i, false, 4, (Object) null) : StringsKt.lastIndexOf$default(charSequence, str, i, false, 4, (Object) null);
            if (iIndexOf$default < 0) {
                return null;
            }
            return TuplesKt.to(Integer.valueOf(iIndexOf$default), str);
        }
        CharSequence charSequence3 = charSequence;
        IntRange intRange = !z2 ? new IntRange(RangesKt.coerceAtLeast(i, 0), charSequence3.length()) : RangesKt.downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence3)), 0);
        if (charSequence3 instanceof String) {
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int step = intRange.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                int i2 = first;
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z3 = z;
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        z3 = z;
                        if (StringsKt.regionMatches(str2, 0, (String) charSequence3, i2, str2.length(), z3)) {
                            break;
                        }
                        z = z3;
                    }
                    String str3 = (String) next2;
                    if (str3 != null) {
                        return TuplesKt.to(Integer.valueOf(i2), str3);
                    }
                    if (i2 != last) {
                        i2 += step;
                        z = z3;
                    }
                }
            }
        } else {
            boolean z4 = z;
            int first2 = intRange.getFirst();
            int last2 = intRange.getLast();
            int step2 = intRange.getStep();
            if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
                int i3 = first2;
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            charSequence2 = charSequence3;
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        charSequence2 = charSequence3;
                        boolean z5 = z4;
                        z4 = z5;
                        if (StringsKt.regionMatchesImpl(str4, 0, charSequence2, i3, str4.length(), z5)) {
                            break;
                        }
                        charSequence3 = charSequence2;
                    }
                    String str5 = (String) next;
                    if (str5 != null) {
                        return TuplesKt.to(Integer.valueOf(i3), str5);
                    }
                    if (i3 != last2) {
                        i3 += step2;
                        charSequence3 = charSequence2;
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.findAnyOf(charSequence, collection, i, z);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.findLastAnyOf(charSequence, collection, i, z);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOfAny(charSequence, (Collection<String>) collection, i, z);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, (Collection<String>) collection, i, z);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOf(charSequence, c, i, z);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOf(charSequence, str, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOf(charSequence, c, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOf(charSequence, str, i, z);
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.contains(charSequence, charSequence2, z);
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.contains(charSequence, c, z);
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, final char[] cArr, int i, final boolean z, int i2) {
        StringsKt.requireNonNegativeLimit(i2);
        return new DelimitedRangesSequence(charSequence, i, i2, new Function2() { // from class: kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return StringsKt__StringsKt.rangesDelimitedBy$lambda$14$StringsKt__StringsKt(cArr, z, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        StringsKt.requireNonNegativeLimit(i2);
        final List listAsList = ArraysKt.asList(strArr);
        return new DelimitedRangesSequence(charSequence, i, i2, new Function2() { // from class: kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return StringsKt__StringsKt.rangesDelimitedBy$lambda$16$StringsKt__StringsKt(listAsList, z, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.splitToSequence(charSequence, strArr, z, i);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, strArr, z, i);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.splitToSequence(charSequence, cArr, z, i);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, cArr, z, i);
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z, int i) {
        StringsKt.requireNonNegativeLimit(i);
        int length = 0;
        int iIndexOf = StringsKt.indexOf(charSequence, str, 0, z);
        if (iIndexOf == -1 || i == 1) {
            return CollectionsKt.listOf(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? RangesKt.coerceAtMost(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iIndexOf).toString());
            length = str.length() + iIndexOf;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iIndexOf = StringsKt.indexOf(charSequence, str, length, z);
        } while (iIndexOf != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt.equals((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt.equals(charSequence.charAt(i), charSequence2.charAt(i), true)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean contentEqualsImpl(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return Intrinsics.areEqual(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
