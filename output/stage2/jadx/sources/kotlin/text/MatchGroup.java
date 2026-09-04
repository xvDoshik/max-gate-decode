package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "<init>", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getValue", "()Ljava/lang/String;", "getRange", "()Lkotlin/ranges/IntRange;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class MatchGroup {
    private final IntRange range;
    private final String value;

    public MatchGroup(String str, IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{19, 80, 94, 66, 92}, "e12792521d63d337", 5));
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{66, 3, 10, 2, 83}, "0bde667ecf38"));
        this.value = str;
        this.range = intRange;
    }

    public static /* synthetic */ MatchGroup copy$default(MatchGroup matchGroup, String str, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            str = matchGroup.value;
        }
        if ((i & 2) != 0) {
            intRange = matchGroup.range;
        }
        return matchGroup.copy(str, intRange);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IntRange getRange() {
        return this.range;
    }

    public final MatchGroup copy(String value, IntRange range) {
        Intrinsics.checkNotNullParameter(value, C0000.decode(new byte[]{23, 7, 15, 68, 4}, "afc1a5a1ae2c", true));
        Intrinsics.checkNotNullParameter(range, C0000.decode(new byte[]{65, 83, 94, 5, 0}, "320bef3d7fd4dcbb", 0.0f));
        return new MatchGroup(value, range);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) other;
        return Intrinsics.areEqual(this.value, matchGroup.value) && Intrinsics.areEqual(this.range, matchGroup.range);
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.range.hashCode();
    }

    public String toString() {
        return C0000.decode(new byte[]{125, 85, 71, 2, 95, 113, 66, 91, 70, 17, 31, 64, 81, 88, 70, 4, 10}, "043a76", 1) + this.value + C0000.decode(new byte[]{26, 65, 75, 88, 12, 80, 83, 14}, "6a99b763") + this.range + ')';
    }

    public final IntRange getRange() {
        return this.range;
    }

    public final String getValue() {
        return this.value;
    }
}
