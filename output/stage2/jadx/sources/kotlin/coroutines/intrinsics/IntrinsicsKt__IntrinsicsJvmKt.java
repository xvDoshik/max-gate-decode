package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u001aA\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a=\u0010\u0007\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0006\u001aZ\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\f\u001aV\u0010\u0007\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001¢\u0006\u0002\u0010\f\u001an\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0002*)\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\u0006\u0010\u000f\u001a\u0002H\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aj\u0010\u0007\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0002*)\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\u0006\u0010\u000f\u001a\u0002H\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0010\u001aA\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0013\u001aZ\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0014\u001a\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u001aF\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001c\b\u0004\u0010\u0017\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H\u0083\b¢\u0006\u0002\b\u0018\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002¢\u0006\u0002\b\u001a\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"startCoroutineUninterceptedOrReturn", "", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wrapWithContinuationImpl", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCoroutineUnintercepted", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "createCoroutineFromSuspendFunction", "block", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createSimpleCoroutineForSuspendFunction", "createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
public class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<Unit> createCoroutineUnintercepted(final Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{10, 76, 92, 12, 70, 12}, "684e52b487599f", 4));
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{84, 9, 11, 70, 92, 92, 64, 92, 12, 92}, "7ff60945c2bd94"));
        final Continuation<?> continuationProbeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        if (function1 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function1).create(continuationProbeCoroutineCreated);
        }
        final CoroutineContext context = continuationProbeCoroutineCreated.get$context();
        return context == EmptyCoroutineContext.INSTANCE ? new RestrictedContinuationImpl(continuationProbeCoroutineCreated, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
            final /* synthetic */ Function1 $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(continuationProbeCoroutineCreated);
                this.$this_createCoroutineUnintercepted$inlined = function1;
                Intrinsics.checkNotNull(continuationProbeCoroutineCreated, C0000.decode(new byte[]{89, 64, 92, 84, 17, 83, 5, 89, 8, 11, 69, 23, 85, 80, 16, 91, 80, 67, 16, 23, 18, 11, 17, 89, 88, 91, 29, 86, 68, 92, 8, 23, 18, 29, 65, 82, 23, 94, 95, 76, 93, 89, 10, 25, 5, 11, 67, 88, 66, 65, 89, 86, 84, 67, 74, 116, 9, 10, 69, 94, 89, 64, 81, 76, 88, 95, 10, 11, 13, 11, 69, 91, 94, 91, 30, 121, 95, 73, 91, 9}, "750810d7fd17"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object result) throws Throwable {
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException(C0000.decode(new byte[]{101, 88, 80, 69, 22, 91, 88, 74, 94, 69, 77, 95, 88, 93, 23, 80, 80, 84, 25, 87, 90, 74, 82, 89, 85, 73, 25, 85, 89, 85, 71, 84, 84, 68, 92, 82}, "10966878", 6).toString());
                    }
                    this.label = 2;
                    ResultKt.throwOnFailure(result);
                    return result;
                }
                this.label = 1;
                ResultKt.throwOnFailure(result);
                Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, C0000.decode(new byte[]{88, 23, 10, 88, 69, 83, 5, 90, 88, 87, 66, 66, 4, 81, 69, 83, 5, 71, 66, 24, 66, 13, 70, 90, 10, 94, 73, 90, 67, 84, 90, 66, 18, 77, 21, 85, 68, 95, 89, 76, 90, 11, 8, 26, 35, 69, 10, 87, 66, 81, 89, 12, 87, 8, 14, 95, 16, 88, 95, 86, 24, 1, 9, 70, 10, 69, 16, 93, 88, 93, 69, 76, 37, 91, 11, 68, 13, 90, 67, 89, 66, 11, 9, 90, 89, 100, 68, 91, 80, 24, 93, 13, 18, 88, 12, 94, 74, 87, 89, 74, 89, 23, 18, 93, 11, 85, 23, 26, 95, 86, 66, 16, 15, 90, 22, 89, 7, 71, 24, 113, 88, 22, 20, 93, 11, 67, 13, 87, 69, 115, 66, Base64.padSymbol, 57, 125, 11, 68, 22, 93, 88, 75, 95, 1, 21, 126, 19, 93, 47, 64, 24, 91, 68, 7, 7, 64, 0, 115, 11, 70, 89, 77, 66, 11, 8, 81, 48, 94, 13, 90, 66, 93, 68, 1, 3, 68, 17, 85, 0, 10, 26, 24, 93, 13, 18, 88, 12, 94, 74, 117, 88, 65, 9, 92}, "6bf4e0d468", 6));
                return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
            }
        } : new ContinuationImpl(continuationProbeCoroutineCreated, context, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
            final /* synthetic */ Function1 $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(continuationProbeCoroutineCreated, context);
                this.$this_createCoroutineUnintercepted$inlined = function1;
                Intrinsics.checkNotNull(continuationProbeCoroutineCreated, C0000.decode(new byte[]{13, 67, 84, 15, 19, 0, 5, 89, 92, 11, 65, 21, 1, 81, 16, 80, 2, 69, 76, 67, 71, 12, 68, 89, 93, 10, 24, 91, 22, 88, 92, 19, 23, 79, 72, 6, 19, 8, 11, 67, 94, 13, 91, 27, 0, 91, 66, 92, 22, 66, 81, 13, 86, 16, 74, 116, 93, 10, 65, 92, 13, 65, 81, 71, 10, 89, 86, 95, 88, 12, 16, 91, 91, 10, 27, 116, 13, 77, 15, 13}, "c68c3cd72d55c403", 0));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object result) throws Throwable {
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException(C0000.decode(new byte[]{98, 94, 80, 17, 24, 83, 89, 68, 86, 23, 76, 89, 88, 83, 25, 10, 89, 84, 22, 87, 85, 16, 93, 81, 82, 79, 25, 1, 87, 93, 70, 90, 92, 22, 93, 84}, "669b80").toString());
                    }
                    this.label = 2;
                    ResultKt.throwOnFailure(result);
                    return result;
                }
                this.label = 1;
                ResultKt.throwOnFailure(result);
                Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, C0000.decode(new byte[]{15, 67, 85, 92, 18, 7, 85, 95, 91, 94, 65, 24, 3, 82, 17, 5, 0, 69, 77, 16, 70, 11, 20, 95, 90, 95, 24, 86, 20, 91, 93, 70, 21, 79, 73, 85, 18, 15, 91, 69, 89, 88, 91, 22, 39, 66, 95, 5, 21, 95, 86, 94, 3, 88, 95, 94, 65, 93, 92, 86, 79, 84, 94, 20, 14, 67, 77, 89, 92, 1, 71, 31, 118, 94, 91, 76, 8, 89, 68, 7, 21, 95, 86, 94, 14, 48, 20, 94, 83, 17, 94, 87, 21, 91, 88, 8, 79, 85, 86, 66, 93, 17, 64, 88, 91, 84, 70, 22, 8, 89, 69, 20, 8, 88, 74, 89, 81, 23, 26, 120, 91, 69, 71, 81, 15, 68, 88, 5, 18, 125, 77, 111, 109, 45, 90, 69, 71, 88, 91, 75, 8, 84, 66, 44, 23, 91, 114, 68, 28, 7, 70, 84, 84, 69, 80, 123, 14, 69, 94, 19, 21, 95, 87, 85, 103, 10, 93, 95, 65, 84, 71, 91, 4, 71, 69, 3, 5, 8, 21, 16, 89, 11, 64, 93, 92, 95, 27, 121, 15, 78, 14, 88}, "a6902d415158a71f"));
                return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(final Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, final R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{88, 23, 12, 95, 66, 10}, "dcd6145b84adb05f"));
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{86, 10, 93, 64, 91, 83, 76, 89, 90, 11}, "5e007680", 1));
        final Continuation<?> continuationProbeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r, continuationProbeCoroutineCreated);
        }
        final CoroutineContext context = continuationProbeCoroutineCreated.get$context();
        return context == EmptyCoroutineContext.INSTANCE ? new RestrictedContinuationImpl(continuationProbeCoroutineCreated, function2, r) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
            final /* synthetic */ Object $receiver$inlined;
            final /* synthetic */ Function2 $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(continuationProbeCoroutineCreated);
                this.$this_createCoroutineUnintercepted$inlined = function2;
                this.$receiver$inlined = r;
                Intrinsics.checkNotNull(continuationProbeCoroutineCreated, C0000.decode(new byte[]{91, 66, 90, 93, 67, 6, 7, 93, 90, 10, 21, 17, 3, 83, 21, 84, 87, 66, 23, 69, 18, 92, 20, 11, 14, 95, 76, 88, 64, 91, 90, 17, 23, 28, 22, 86, 20, 14, 14, 69, 13, 95, 91, 25, 85, 94, 17, 10, 19, 71, 93, 11, 4, 66, 79, 117, 90, 89, 66, 88, 13, 16, 7, 71, 93, 10, 15, 13, 10, 89, 65, 91, 95, 95, 77, 36, 8, 74, 11, 91}, "5761cef34ea1a6", 0.0f));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object result) throws Throwable {
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException(C0000.decode(new byte[]{96, 13, 94, 64, 67, 82, 89, 75, 91, 16, 67, 90, 13, 84, 22, 81, 85, 1, 23, 82, 15, 67, 83, 88, 80, 28, 23, 80, 12, 92, 70, 85, 81, 17, 82, 87}, "4e73c169", 0.0f).toString());
                    }
                    this.label = 2;
                    ResultKt.throwOnFailure(result);
                    return result;
                }
                this.label = 1;
                ResultKt.throwOnFailure(result);
                Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, C0000.decode(new byte[]{86, 16, 85, 85, 16, 1, 84, 86, 88, 9, 64, 67, 90, 0, 25, 90, 81, 17, 65, 24, 66, 9, 20, 13, 87, 11, 20, 87, 69, 14, 89, 24, 66, 31, 68, 6, 24, 14, 86, 77, 92, 11, 91, 22, 112, 19, 90, 0, 76, 12, 86, 87, 2, 94, 103, 24, 89, 0, 20, 8, 87, 17, 85, 80, 94, 76, 86, 87, 68, 9, 65, 23, 81, 11, 92, 74, 30, 11, 91, 76, 68, 15, 90, 16, 81, 6, 74, 23, 121, 12, 65, 74, 95, 8, 71, 10, 91, 22, 114, 77, 111, Base64.padSymbol, 124, 86, 66, 20, 93, 13, 75, 12, 90, 74, 122, 20, 88, 115, 66, 72, 87, 17, 93, 4, 77, 92, 115, 13, 71, 87, 67, 18, 93, 13, 93, 48, 87, 80, 94, 22, 80, 74, 85, 3, 68, 23, 93, 1, 21, 25, 91, 13, 65, 84, 95, 8, 26, 0, 87, 23, 86, 76, 68, 11, 91, 93, 69, 72, 119, 12, 86, 17, 80, 87, 69, 3, 65, 81, 89, 8, 8, 55, 24, 10, 95, 25, 91, 13, 65, 84, 95, 8, 26, 0, 87, 23, 86, 76, 68, 11, 91, 93, 69, 72, 93, 13, 76, 23, 80, 87, 67, 11, 86, 75, 24, 47, 90, 23, 74, 12, 87, 74, 89, 1, 70, 115, 66, 57, 107, 42, 86, 17, 75, 80, 94, 17, 92, 91, 69, 44, 66, 14, 115, 17, 23, 90, 66, 7, 84, 76, 83, 37, 91, 17, 87, 16, 77, 80, 94, 7, 96, 86, 95, 8, 64, 6, 74, 6, 92, 73, 68, 7, 81, 6, 26, 70, 95, 12, 76, 9, 80, 87, 30, 35, 91, 65, 9, 88}, "8e990b586f4c"));
                return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
            }
        } : new ContinuationImpl(continuationProbeCoroutineCreated, context, function2, r) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            final /* synthetic */ Object $receiver$inlined;
            final /* synthetic */ Function2 $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(continuationProbeCoroutineCreated, context);
                this.$this_createCoroutineUnintercepted$inlined = function2;
                this.$receiver$inlined = r;
                Intrinsics.checkNotNull(continuationProbeCoroutineCreated, C0000.decode(new byte[]{87, 66, 94, 8, 18, 80, 7, 87, 13, 89, 21, 66, 3, 6, 65, 5, 88, 68, 70, 68, 70, 92, 70, 87, 12, 88, 76, 12, 20, 15, 13, 70, 77, 78, 66, 1, 18, 88, 9, 77, 15, 95, 15, 76, 2, 12, 19, 9, 76, 67, 91, 10, 87, 64, 72, 122, 12, 88, 21, 11, 15, 22, 0, 18, 80, 88, 92, 88, 89, 92, 18, 85, 10, 88, 79, 35, 15, 26, 94, 88}, "972d23f9c6abacaf", 1));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object result) throws Throwable {
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException(C0000.decode(new byte[]{100, 91, 90, 21, 68, 0, 13, 71, 95, 70, 68, 11, 13, 3, 16, 91, 82, 2, 68, 2, 14, 71, 85, 82, 84, 27, 67, 5, 95, 94, 67, 10, 1, 23, 7, 81}, "033fdcb5030bcf").toString());
                    }
                    this.label = 2;
                    ResultKt.throwOnFailure(result);
                    return result;
                }
                this.label = 1;
                ResultKt.throwOnFailure(result);
                Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, C0000.decode(new byte[]{15, 71, 10, 93, 65, 0, 84, 10, 11, 94, 22, 18, 3, 87, 70, 82, 0, 16, 65, 68, 17, 94, 66, 92, 14, 92, 75, 95, 20, 15, 89, 68, 17, 72, 18, 87, 65, 89, 9, 69, 13, 10, 91, 74, 35, 68, 12, 81, 21, 91, 9, 95, 83, 95, 103, 68, 10, 87, 66, 89, 14, 70, 10, 88, 15, 77, 86, 11, 23, 94, 23, 70, 8, 92, 3, 66, 79, 10, 91, 16, 23, 88, 12, 65, 8, 81, 21, 31, 40, 13, 65, 22, 12, 95, 17, 91, 2, 65, 45, 69, 62, 60, 124, 10, 17, 67, 11, 92, 18, 91, 5, 66, 43, 21, 88, 47, 17, 31, 1, 64, 4, 83, 18, 84, 34, 12, 71, 11, 16, 69, 11, 92, 4, 103, 8, 88, 15, 23, 80, 22, 6, 84, 18, 70, 4, 86, 74, 17, 10, 12, 65, 8, 12, 95, 76, 81, 14, 64, 9, 68, 21, 10, 91, 1, 22, 31, 33, 93, 15, 70, 15, 95, 20, 2, 65, 13, 10, 95, 94, 102, 65, 93, 0, 17, 10, 12, 65, 8, 12, 95, 76, 81, 14, 64, 9, 68, 21, 10, 91, 1, 22, 31, 11, 92, 21, 64, 15, 95, 18, 10, 86, 23, 75, 120, 12, 70, 19, 91, 8, 66, 8, 0, 70, 47, 17, 110, Base64.padSymbol, 123, 15, 70, 20, 88, 15, 16, 92, 7, 22, 123, 20, 95, 42, 70, 72, 82, 19, 6, 84, 16, 0, 114, 13, 64, 14, 71, 18, 88, 15, 6, 96, 10, 12, 95, 22, 87, 19, 81, 3, 65, 21, 6, 81, 90, 73, 17, 9, 93, 21, 94, 15, 95, 79, 34, 91, 29, 90, 15}, "a2f1ac5de1b2", true));
                return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> intercepted(Continuation<? super T> continuation) {
        Continuation<T> continuation2;
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{8, 65, 10, 93, 69, 8}, "45b4663c0a12", 0.0f));
        ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
        return (continuationImpl == null || (continuation2 = (Continuation<T>) continuationImpl.intercepted()) == null) ? continuation : continuation2;
    }

    private static final <T> Object startCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{13, 70, 11, 88, 64, 11}, "12c13583cfb4"));
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{82, 90, 92, 20, 10, 1, 71, 91, 94, 92}, "151dfd321281b5a5", true));
        return !(function1 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function1, continuation) : ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(continuation);
    }

    private static final <R, T> Object startCoroutineUninterceptedOrReturn(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{11, 76, 14, 91, 75, 11}, "78f28566"));
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{87, 89, 11, 71, 15, 86, 64, 95, 9, 89}, "46f7c3", 0));
        return !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function2, r, continuation) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, continuation);
    }

    private static final <R, P, T> Object startCoroutineUninterceptedOrReturn(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> function3, R r, P p, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function3, C0000.decode(new byte[]{11, 76, 95, 94, 70, 6}, "7877582a", true));
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{83, 87, 91, 67, 10, 6, 77, 10, 95, 86}, "0863fc9c"));
        return !(function3 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function3, r, p, continuation) : ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3)).invoke(r, p, continuation);
    }

    public static final <T> Object wrapWithContinuationImpl(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{10, 17, 88, 80, 23, 12}, "6e09d2d342"));
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{87, 9, 89, 68, 14, 4, 17, 95, 91, 8}, "4f44bae6", false));
        return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(continuation)));
    }

    public static final <R, T> Object wrapWithContinuationImpl(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{4, 71, 94, 89, 64, 88}, "83603fa46954ef", 0.0f));
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{81, 10, 88, 22, 9, 92, 77, 89, 11, 8}, "2e5fe990df9e5b0e"));
        return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(continuation)));
    }

    public static final <R, P, T> Object wrapWithContinuationImpl(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> function3, R r, P p, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function3, C0000.decode(new byte[]{9, 76, 95, 80, 71, 6}, "587948", false));
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{86, 95, 14, 64, 91, 84, 23, 88, 90, 94}, "50c071c1", false));
        return ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3)).invoke(r, p, createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(continuation)));
    }

    private static final <T> Continuation<Unit> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(final Continuation<? super T> continuation, final Function1<? super Continuation<? super T>, ? extends Object> function1) {
        final CoroutineContext context = continuation.get$context();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(continuation, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
                final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(continuation);
                    this.$block = function1;
                    Intrinsics.checkNotNull(continuation, C0000.decode(new byte[]{88, 19, 10, 9, 19, 7, 80, 94, 15, 93, 67, 18, 83, 4, 66, 6, 87, 21, 18, 69, 71, 11, 17, 94, 14, 92, 26, 92, 68, 13, 14, 69, 66, 31, 22, 0, 19, 15, 94, 68, 13, 91, 89, 28, 82, 14, 16, 10, 67, 18, 15, 11, 86, 23, 31, 115, 14, 92, 67, 91, 95, 20, 3, 17, 95, 9, 8, 89, 88, 11, 69, 92, 8, 92, 25, 115, 95, 24, 93, 91}, "6ffe3d10a2721abe", true));
                }

                /* JADX WARN: Type inference incomplete: some casts might be missing */
                /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1 for r5v1 'this'  java.lang.Object
                    	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                    	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                    	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                    	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                    	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                    */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected java.lang.Object invokeSuspend(java.lang.Object r6) {
                    /*
                        r5 = this;
                        int r0 = r5.label
                        r1 = 1
                        if (r0 == 0) goto L2a
                        if (r0 != r1) goto Le
                        r0 = 2
                        r5.label = r0
                        kotlin.ResultKt.throwOnFailure(r6)
                        return r6
                    Le:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        r2 = 36
                        byte[] r2 = new byte[r2]
                        r2 = {x0036: FILL_ARRAY_DATA , data: [99, 92, 93, 69, 68, 81, 11, 23, 88, 65, 64, 95, 10, 87, 68, 13, 86, 80, 20, 87, 8, 64, 1, 4, 83, 77, 20, 85, 11, 95, 20, 9, 82, 64, 81, 82} // fill-array
                        java.lang.String r0 = "7446d2de"
                        r4 = 2
                        java.lang.String r0 = p000.C0000.decode(r2, r0, r4)
                        java.lang.String r0 = r0.toString()
                        r6.<init>(r0)
                        throw r6
                    L2a:
                        r5.label = r1
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super T>, java.lang.Object> r6 = r5.$block
                        java.lang.Object r6 = r6.invoke(r5)
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            };
        }
        return new ContinuationImpl(continuation, context, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2
            final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(continuation, context);
                this.$block = function1;
                Intrinsics.checkNotNull(continuation, C0000.decode(new byte[]{91, 68, 8, 92, 67, 87, 4, 12, 91, 9, 64, 65, 3, 87, 67, 5, 84, 66, 16, 16, 23, 91, 69, 12, 90, 8, 25, 15, 20, 94, 15, 70, 65, 72, 20, 85, 67, 95, 10, 22, 89, 15, 90, 79, 2, 93, 17, 9, 64, 69, 13, 94, 6, 71, 75, 33, 90, 8, 64, 8, 15, 71, 2, 18, 92, 94, 10, 12, 8, 91, 17, 14, 92, 8, 26, 32, 15, 75, 92, 88}, "51d0c4eb5f4aa2cf"));
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 for r5v1 'this'  java.lang.Object
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    int r0 = r5.label
                    r1 = 1
                    if (r0 == 0) goto L26
                    if (r0 != r1) goto Le
                    r0 = 2
                    r5.label = r0
                    kotlin.ResultKt.throwOnFailure(r6)
                    return r6
                Le:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    r2 = 36
                    byte[] r2 = new byte[r2]
                    r2 = {x0032: FILL_ARRAY_DATA , data: [48, 12, 12, 68, 20, 1, 88, 23, 11, 22, 22, 10, 10, 1, 69, 95, 85, 6, 23, 4, 8, 17, 7, 2, 0, 29, 69, 84, 91, 15, 71, 9, 1, 23, 7, 7} // fill-array
                    java.lang.String r0 = "dde74b7edcbc"
                    r4 = 0
                    java.lang.String r0 = p000.C0000.decode(r2, r0, r4)
                    java.lang.String r0 = r0.toString()
                    r6.<init>(r0)
                    throw r6
                L26:
                    r5.label = r1
                    kotlin.ResultKt.throwOnFailure(r6)
                    kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super T>, java.lang.Object> r6 = r5.$block
                    java.lang.Object r6 = r6.invoke(r5)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        };
    }

    private static final <T> Continuation<T> createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(final Continuation<? super T> continuation) {
        final CoroutineContext context = continuation.get$context();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(continuation) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(continuation);
                    Intrinsics.checkNotNull(continuation, C0000.decode(new byte[]{89, 20, 95, 10, 16, 6, 88, 87, 8, 11, 18, 18, 87, 80, 23, 2, 82, 21, 68, 69, 77, 86, 70, 10, 9, 92, 24, 91, 66, 13, 95, 70, 68, 28, 73, 92, 70, 15, 9, 70, 89, 92, 89, 79, 80, 9, 66, 10, 76, 77, 15, 10, 3, 65, 27, 118, 88, 15, 71, 15, 94, 16, 88, 77, 15, 11, 8, 14, 94, 90, 67, 13, 90, 8, 30, 36, 87, 64, 89, 90}, "7a3f0e99fdf255", 0.0f));
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object result) throws Throwable {
                    ResultKt.throwOnFailure(result);
                    return result;
                }
            };
        }
        return new ContinuationImpl(continuation, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(continuation, context);
                Intrinsics.checkNotNull(continuation, C0000.decode(new byte[]{88, 19, 85, 92, 25, 1, 86, 8, 88, 9, 77, 16, 91, 7, 23, 5, 87, 21, 77, 16, 77, 13, 23, 8, 89, 8, 20, 94, 76, 14, 91, 70, 66, 31, 73, 85, 25, 9, 88, 18, 90, 15, 87, 30, 90, 13, 69, 9, 67, 18, 80, 94, 92, 17, 25, 37, 89, 8, 77, 89, 87, 23, 86, 18, 95, 9, 87, 12, 82, 13, 67, 10, 95, 8, 23, 113, 87, 27, 8, 88}, "6f909b7f", false));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object result) throws Throwable {
                ResultKt.throwOnFailure(result);
                return result;
            }
        };
    }
}
