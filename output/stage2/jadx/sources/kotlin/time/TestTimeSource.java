package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.LongCompanionObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "<init>", "()V", "reading", "", "read", "plusAssign", "", "duration", "Lkotlin/time/Duration;", "plusAssign-LRDsOJo", "(J)V", "overflow", "overflow-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    /* JADX INFO: renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m1482overflowLRDsOJo(long duration) {
        throw new IllegalStateException(C0000.decode(new byte[]{108, 92, 66, 70, 102, 13, 85, 3, 99, 91, 66, 67, 7, 87, 24, 78, 88, 94, 94, 68, 87, 16, 85, 70, 81, 93, 11, 69, 24, 80, 87, 18, 91, 16, 75, 70, 66, 81, 86, 85, 13, 92, 95, 25}, "89122d8f0471d2", 6) + this.reading + DurationUnitKt.shortName(getUnit()) + C0000.decode(new byte[]{65, 95, 74, 24, 87, 93, 18, 84, 92, 80, 4, 7, 19, 3, 24, 22}, "a69869d523ac3a", 0.0f) + ((Object) Duration.m1411toStringimpl(duration)) + '.');
    }

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.time.AbstractLongTimeSource
    /* JADX INFO: renamed from: read, reason: from getter */
    public long getReading() {
        return this.reading;
    }

    /* JADX INFO: renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m1483plusAssignLRDsOJo(long duration) {
        long jM1410toLongimpl = Duration.m1410toLongimpl(duration, getUnit());
        if (((jM1410toLongimpl - 1) | 1) != LongCompanionObject.MAX_VALUE) {
            long j = this.reading;
            long j2 = j + jM1410toLongimpl;
            if ((jM1410toLongimpl ^ j) >= 0 && (j ^ j2) < 0) {
                m1482overflowLRDsOJo(duration);
            }
            this.reading = j2;
            return;
        }
        long jM1374divUwyO8pc = Duration.m1374divUwyO8pc(duration, 2);
        if ((1 | (Duration.m1410toLongimpl(jM1374divUwyO8pc, getUnit()) - 1)) != LongCompanionObject.MAX_VALUE) {
            long j3 = this.reading;
            try {
                m1483plusAssignLRDsOJo(jM1374divUwyO8pc);
                m1483plusAssignLRDsOJo(Duration.m1399minusLRDsOJo(duration, jM1374divUwyO8pc));
                return;
            } catch (IllegalStateException e) {
                this.reading = j3;
                throw e;
            }
        }
        m1482overflowLRDsOJo(duration);
    }
}
