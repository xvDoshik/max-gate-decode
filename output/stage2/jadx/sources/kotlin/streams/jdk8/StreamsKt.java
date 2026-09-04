package kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\u00020\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\u00020\u0005H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\u00020\u0007H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f*\u00020\tH\u0007¨\u0006\r"}, d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "T", "Ljava/util/stream/Stream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", "", "Ljava/util/stream/DoubleStream;", "asStream", "toList", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {2, 1, 0}, pn = "kotlin.streams", xi = 48)
public final class StreamsKt {
    public static final Sequence<Double> asSequence(final DoubleStream doubleStream) {
        Intrinsics.checkNotNullParameter(doubleStream, C0000.decode(new byte[]{15, 70, 88, 91, 64, 93}, "32023c398f7d", true));
        return new Sequence<Double>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$4
            @Override // kotlin.sequences.Sequence
            public Iterator<Double> iterator() {
                Iterator<Double> it = doubleStream.iterator();
                Intrinsics.checkNotNullExpressionValue(it, C0000.decode(new byte[]{80, 66, 87, 69, 89, 17, 13, 67, 78, 74, 31, 23, 31}, "96278eb1fd196fcc"));
                return it;
            }
        };
    }

    public static final Sequence<Integer> asSequence(final IntStream intStream) {
        Intrinsics.checkNotNullParameter(intStream, C0000.decode(new byte[]{13, 70, 92, 91, 69, 12}, "124262", false));
        return new Sequence<Integer>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$2
            @Override // kotlin.sequences.Sequence
            public Iterator<Integer> iterator() {
                Iterator<Integer> it = intStream.iterator();
                Intrinsics.checkNotNullExpressionValue(it, C0000.decode(new byte[]{12, 23, 81, 22, 86, 76, 9, 23, 31, 77, 75, 77, 29}, "ec4d78fe7c", 4));
                return it;
            }
        };
    }

    public static final Sequence<Long> asSequence(final LongStream longStream) {
        Intrinsics.checkNotNullParameter(longStream, C0000.decode(new byte[]{11, 22, 14, 90, 23, 14}, "7bf3d08126d82281", 2));
        return new Sequence<Long>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$3
            @Override // kotlin.sequences.Sequence
            public Iterator<Long> iterator() {
                Iterator<Long> it = longStream.iterator();
                Intrinsics.checkNotNullExpressionValue(it, C0000.decode(new byte[]{10, 69, 92, 22, 87, 64, 9, 68, 16, 28, 75, 27, 74}, "c19d64f682e5cb"));
                return it;
            }
        };
    }

    public static final <T> Sequence<T> asSequence(final Stream<T> stream) {
        Intrinsics.checkNotNullParameter(stream, C0000.decode(new byte[]{5, 71, 9, 12, 74, 13}, "93ae930ea24366"));
        return new Sequence<T>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                Iterator<T> it = stream.iterator();
                Intrinsics.checkNotNullExpressionValue(it, C0000.decode(new byte[]{13, 22, 86, 67, 87, 71, 95, 65, 25, 29, 25, 28, 77}, "db3163031372", 7));
                return it;
            }
        };
    }

    public static final <T> Stream<T> asStream(final Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{14, 67, 10, 93, 64, 8}, "27b436214f17", false));
        Stream<T> stream = StreamSupport.stream(new Supplier() { // from class: kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return StreamsKt.asStream$lambda$4(sequence);
            }
        }, 16, false);
        Intrinsics.checkNotNullExpressionValue(stream, C0000.decode(new byte[]{17, 23, 70, 7, 3, 92, 73, 75, 31, 29, 75}, "bc4bb1ae13"));
        return stream;
    }

    public static final List<Double> toList(DoubleStream doubleStream) {
        Intrinsics.checkNotNullParameter(doubleStream, C0000.decode(new byte[]{94, 76, 10, 89, 69, 88}, "b8b06f3bed0a", 0.0f));
        double[] array = doubleStream.toArray();
        Intrinsics.checkNotNullExpressionValue(array, C0000.decode(new byte[]{67, 95, 118, 74, 75, 3, 31, 31, 77, 27, 76, 17}, "70789bf7c5b8f623"));
        return ArraysKt.asList(array);
    }

    public static final List<Integer> toList(IntStream intStream) {
        Intrinsics.checkNotNullParameter(intStream, C0000.decode(new byte[]{8, 16, 14, 91, 68, 12}, "4df272", true));
        int[] array = intStream.toArray();
        Intrinsics.checkNotNullExpressionValue(array, C0000.decode(new byte[]{23, 88, 36, 68, 19, 89, 26, 31, 75, 24, 79, 17}, "c7e6a8", 0.0f));
        return ArraysKt.asList(array);
    }

    public static final List<Long> toList(LongStream longStream) {
        Intrinsics.checkNotNullParameter(longStream, C0000.decode(new byte[]{89, 69, 81, 92, 65, 8}, "e19526"));
        long[] array = longStream.toArray();
        Intrinsics.checkNotNullExpressionValue(array, C0000.decode(new byte[]{71, 94, 120, 19, 65, 3, 64, 28, 24, 77, 30, 26}, "319a3b946c03", 1));
        return ArraysKt.asList(array);
    }

    public static final <T> List<T> toList(Stream<T> stream) {
        Intrinsics.checkNotNullParameter(stream, C0000.decode(new byte[]{4, 69, 92, 11, 16, 14}, "814bc01544", 0.0f));
        Object objCollect = stream.collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(objCollect, C0000.decode(new byte[]{87, 94, 89, 92, 3, 83, 64, 25, 27, 30, 72, 25}, "4150f0", 0.0f));
        return (List) objCollect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Spliterator asStream$lambda$4(Sequence sequence) {
        return Spliterators.spliteratorUnknownSize(sequence.iterator(), 16);
    }
}
