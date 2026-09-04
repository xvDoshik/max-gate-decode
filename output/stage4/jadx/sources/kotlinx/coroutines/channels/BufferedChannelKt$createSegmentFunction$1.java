package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class BufferedChannelKt$createSegmentFunction$1 extends FunctionReferenceImpl implements Function2 {
    public static final BufferedChannelKt$createSegmentFunction$1 INSTANCE = new BufferedChannelKt$createSegmentFunction$1(2, BufferedChannelKt.class, C0000.decode(new byte[]{82, 64, 82, 83, 66, 4, 97, 1, 6, 9, 84, 92, 67}, "12726a2dad", 2), C0000.decode(new byte[]{87, 19, 4, 84, 71, 87, 98, 4, 2, 11, 81, 11, 64, 73, 43, 121, 88, 93, 69, 13, 12, 8, 76, 74, 87, 14, 19, 90, 70, 70, 88, 15, 0, 21, 27, 6, 92, 0, 15, 91, 86, 94, 66, 78, 38, 14, 85, 11, 90, 4, 13, 102, 86, 85, 92, 4, 11, 18, 15, 76, 120, 10, 14, 65, 95, 91, 95, 25, 74, 5, 91, 23, 91, 20, 21, 92, 93, 87, 66, 78, 6, 14, 85, 11, 90, 4, 13, 70, 28, 113, 89, 0, 11, 8, 81, 9, 103, 4, 6, 88, 86, 92, 69, 90}, "4aa5321aef4e"), 1);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        long jLongValue = ((Number) obj).longValue();
        ChannelSegment channelSegment = (ChannelSegment) obj2;
        ChannelSegment channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
        return new ChannelSegment(jLongValue, channelSegment, channelSegment._channel, 0);
    }
}
