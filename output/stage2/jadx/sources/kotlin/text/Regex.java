package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 22\u00060\u0001j\u0002`\u0002:\u000212B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB\u001f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0004\b\u0005\u0010\u000fJ\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0086\u0004J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010 \u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010!\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001dH\u0007J\u0018\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001dH\u0007J\u0016\u0010$\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\bJ\"\u0010$\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00180'J\u0016\u0010(\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\bJ\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0*2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\u001dJ \u0010,\u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\u001dH\u0007J\b\u0010-\u001a\u00020\bH\u0016J\u0006\u0010.\u001a\u00020\u0004J\b\u0010/\u001a\u000200H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00063"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "nativePattern", "Ljava/util/regex/Pattern;", "<init>", "(Ljava/util/regex/Pattern;)V", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "getPattern", "()Ljava/lang/String;", "_options", "getOptions", "()Ljava/util/Set;", "matches", "", "input", "", "containsMatchIn", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matchAt", "index", "matchesAt", "replace", "replacement", "transform", "Lkotlin/Function1;", "replaceFirst", "split", "", "limit", "splitToSequence", "toString", "toPattern", "writeReplace", "", "Serialized", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Regex implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    /* JADX INFO: renamed from: kotlin.text.Regex$findAll$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, MatchResult.class, C0000.decode(new byte[]{87, 92, 78, 18}, "996f1e8c13", 7), C0000.decode(new byte[]{15, 84, 74, 70, 75, 79, 121, 93, 14, 65, 10, 90, 95, 24, 17, 1, 25, 69, 29, ByteCompanionObject.MAX_VALUE, 2, 18, 86, 94, 51, 80, 21, 70, 93, 67, 94}, "a122cf56a5f317ed"), 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final MatchResult invoke(MatchResult matchResult) {
            Intrinsics.checkNotNullParameter(matchResult, C0000.decode(new byte[]{72, 7}, "87340d7044c008"));
            return matchResult.next();
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$splitToSequence$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {279, 287, 291}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CharSequence charSequence, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$input = charSequence;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = Regex.this.new AnonymousClass1(this.$input, this.$limit, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super String> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0082 A[PHI: r1 r6 r13
          0x0082: PHI (r1v8 int) = (r1v7 int), (r1v13 int) binds: [B:19:0x007f, B:10:0x002c] A[DONT_GENERATE, DONT_INLINE]
          0x0082: PHI (r6v2 kotlin.sequences.SequenceScope) = (r6v1 kotlin.sequences.SequenceScope), (r6v4 kotlin.sequences.SequenceScope) binds: [B:19:0x007f, B:10:0x002c] A[DONT_GENERATE, DONT_INLINE]
          0x0082: PHI (r13v7 java.util.regex.Matcher) = (r13v6 java.util.regex.Matcher), (r13v13 java.util.regex.Matcher) binds: [B:19:0x007f, B:10:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:23:0x008c  */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
        
            if (r6.yield(r13.subSequence(r5, r13.length()).toString(), r12) == r0) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00c3, code lost:
        
            if (r13.yield(r12.$input.toString(), r12) == r0) goto L32;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007f -> B:21:0x0082). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 230
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{17, 84, 64, 70, 6, 17, 91}, "a542cc58b4e6f0", false));
        Pattern patternCompile = Pattern.compile(str);
        Intrinsics.checkNotNullExpressionValue(patternCompile, C0000.decode(new byte[]{83, 90, 88, 70, 91, 10, 85, 76, 22, 29, 22, 17}, "05562f0d8388f6", 0));
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str, Set<? extends RegexOption> set) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{17, 3, 67, 16, 82, 65, 15}, "ab7d73", 6));
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{94, 20, 71, 95, 91, 89, 16}, "1d3647c4", false));
        Pattern patternCompile = Pattern.compile(str, INSTANCE.ensureUnicodeCase(RegexKt.toInt(set)));
        Intrinsics.checkNotNullExpressionValue(patternCompile, C0000.decode(new byte[]{6, 94, 93, 73, 95, 93, 87, 29, 22, 74, 75, 24}, "e10961258d", 4));
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str, RegexOption regexOption) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{19, 5, 69, 23, 82, 64, 94}, "cd1c72096db266bc", 0));
        Intrinsics.checkNotNullParameter(regexOption, C0000.decode(new byte[]{10, 64, 70, 11, 11, 15}, "e02bda", true));
        Pattern patternCompile = Pattern.compile(str, INSTANCE.ensureUnicodeCase(regexOption.getValue()));
        Intrinsics.checkNotNullExpressionValue(patternCompile, C0000.decode(new byte[]{5, 88, 8, 67, 88, 13, 87, 24, 22, 74, 72, 30}, "f7e31a208d", false));
        this(patternCompile);
    }

    public Regex(Pattern pattern) {
        Intrinsics.checkNotNullParameter(pattern, C0000.decode(new byte[]{15, 80, 71, 11, 68, 85, 54, 86, 21, 69, 86, 16, 92}, "a13b20f7", 0.0f));
        this.nativePattern = pattern;
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(strPattern, C0000.decode(new byte[]{68, 3, 70, 76, 6, 70, 93, 25, 23, 76, 30, 79}, "4b28c4319b0fab", 0));
        return new Serialized(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{95, 88, 72, 70, 65}, "66835683", 0.0f));
        return this.nativePattern.matcher(input).find();
    }

    public final MatchResult find(CharSequence input, int startIndex) {
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{11, 12, 66, 76, 23}, "bb29ca9302b53434"));
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, C0000.decode(new byte[]{14, 2, 66, 7, 9, 87, 17, 75, 24, 74, 79, 27}, "cc6da2"));
        return RegexKt.findNext(matcher, startIndex, input);
    }

    public final Sequence<MatchResult> findAll(final CharSequence input, final int startIndex) {
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{90, 15, 65, 69, 68}, "3a100362a89760"));
        if (startIndex < 0 || startIndex > input.length()) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{100, 67, 81, 22, 66, 21, 8, 15, 81, 0, 27, 17, 91, 69, 67, 23, 95, 2, 22, 87, 14, 20, 91, 1, 16, 11, 20}, "770d65aa5ec140") + startIndex + C0000.decode(new byte[]{29, 23, 81, 10, 66, 22, 66, 23, 84, 86, 15, 84, 65, 11, 11, 23}, "178d2c6783a35c", 3) + input.length());
        }
        return SequencesKt.generateSequence(new Function0() { // from class: kotlin.text.Regex$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.find(input, startIndex);
            }
        }, (Function1) AnonymousClass2.INSTANCE);
    }

    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        final int iFlags = this.nativePattern.flags();
        EnumSet enumSetAllOf = EnumSet.allOf(RegexOption.class);
        Intrinsics.checkNotNull(enumSetAllOf);
        CollectionsKt.retainAll(enumSetAllOf, new Function1<RegexOption, Boolean>() { // from class: kotlin.text.Regex$special$$inlined$fromInt$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(RegexOption regexOption) {
                RegexOption regexOption2 = regexOption;
                return Boolean.valueOf((iFlags & regexOption2.getMask()) == regexOption2.getValue());
            }
        });
        Set<RegexOption> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, C0000.decode(new byte[]{68, 11, 11, 14, 80, 88, 82, 80, 80, 7, 10, 4, 103, 84, 64, 17, 31, 75, 72, 72}, "1efa4149", 5));
        this._options = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    public final String getPattern() {
        String strPattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(strPattern, C0000.decode(new byte[]{17, 81, 66, 21, 1, 68, 15, 24, 24, 79, 74, 31}, "a06ad6"));
        return strPattern;
    }

    public final MatchResult matchAt(CharSequence input, int index) {
        MatcherMatchResult matcherMatchResult;
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{92, 94, 66, 76, 67}, "5029740ffa6ebeb8", 0.0f));
        Matcher matcherRegion = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length());
        if (matcherRegion.lookingAt()) {
            Intrinsics.checkNotNull(matcherRegion);
            matcherMatchResult = new MatcherMatchResult(matcherRegion, input);
        } else {
            matcherMatchResult = null;
        }
        return matcherMatchResult;
    }

    public final MatchResult matchEntire(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{80, 91, 72, 71, 71}, "958237", 2));
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, C0000.decode(new byte[]{15, 2, 69, 6, 13, 80, 65, 24, 22, 22, 23, 17}, "bc1ee5308898f9", 0.0f));
        return RegexKt.matchEntire(matcher, input);
    }

    public final boolean matches(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{89, 91, 64, 68, 64}, "05014ae617"));
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean matchesAt(CharSequence input, int index) {
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{91, 8, 21, 20, 67}, "2fea7bb38e89", false));
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length()).lookingAt();
    }

    public final String replace(CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{92, 90, 66, 19, 22}, "542fbec7", 0.0f));
        Intrinsics.checkNotNullParameter(replacement, C0000.decode(new byte[]{64, 82, 73, 84, 86, 80, 87, 12, 82, 88, 22}, "2798732a76b38be1", 1));
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        Intrinsics.checkNotNullExpressionValue(strReplaceAll, C0000.decode(new byte[]{22, 4, 17, 95, 81, 0, 3, 118, 8, 13, 73, 29, 30, 77, 79}, "daa30cf7", false));
        return strReplaceAll;
    }

    public final String replace(CharSequence input, Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{95, 10, 73, 64, 22}, "6d95b2c2"));
        Intrinsics.checkNotNullParameter(transform, C0000.decode(new byte[]{21, 75, 86, 93, 64, 0, 86, 68, 11}, "a9733f96f3cf1ec3", true));
        int iIntValue = 0;
        MatchResult matchResultFind$default = find$default(this, input, 0, 2, null);
        if (matchResultFind$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(input, iIntValue, matchResultFind$default.getRange().getStart().intValue());
            sb.append(transform.invoke(matchResultFind$default));
            iIntValue = matchResultFind$default.getRange().getEndInclusive().intValue() + 1;
            matchResultFind$default = matchResultFind$default.next();
            if (iIntValue >= length) {
                break;
            }
        } while (matchResultFind$default != null);
        if (iIntValue < length) {
            sb.append(input, iIntValue, length);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{76, 89, 106, 77, 66, 15, 93, 94, 16, 24, 23, 23, 25}, "86990f39", true));
        return string;
    }

    public final String replaceFirst(CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{15, 87, 64, 17, 21}, "f90da4fe"));
        Intrinsics.checkNotNullParameter(replacement, C0000.decode(new byte[]{65, 3, 22, 9, 86, 6, 86, 11, 3, 11, 67}, "3ffe7e", 0));
        String strReplaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        Intrinsics.checkNotNullExpressionValue(strReplaceFirst, C0000.decode(new byte[]{74, 3, 64, 89, 83, 6, 6, 36, 11, 23, 17, 17, 76, 29, 25, 72, 17}, "8f052ecbbebed37f", 0.0f));
        return strReplaceFirst;
    }

    public final List<String> split(CharSequence input, int limit) {
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{95, 15, 18, 64, 23}, "6ab5c06a", 0.0f));
        StringsKt.requireNonNegativeLimit(limit);
        Matcher matcher = this.nativePattern.matcher(input);
        if (limit == 1 || !matcher.find()) {
            return CollectionsKt.listOf(input.toString());
        }
        ArrayList arrayList = new ArrayList(limit > 0 ? RangesKt.coerceAtMost(limit, 10) : 10);
        int i = limit - 1;
        int iEnd = 0;
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i >= 0 && arrayList.size() == i) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    public final Sequence<String> splitToSequence(CharSequence input, int limit) {
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{11, 10, 72, 20, 70}, "bd8a2a9e"));
        StringsKt.requireNonNegativeLimit(limit);
        return SequencesKt.sequence(new AnonymousClass1(input, limit, null));
    }

    public String toString() {
        String string = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{16, 88, 98, 18, 71, 94, 92, 81, 16, 74, 22, 72, 75}, "d71f57268d8fbced", 5));
        return string;
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    /* JADX INFO: renamed from: toPattern, reason: from getter */
    public final Pattern getNativePattern() {
        return this.nativePattern;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00060\u0001j\u0002`\u0002:\u0001\u000fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "<init>", "(Ljava/lang/String;I)V", "getPattern", "()Ljava/lang/String;", "getFlags", "()I", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Serialized implements Serializable {
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        public Serialized(String str, int i) {
            Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{19, 0, 18, 22, 7, 17, 11}, "cafbbce8", 0.0f));
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(patternCompile, C0000.decode(new byte[]{2, 87, 88, 18, 8, 88, 4, 77, 31, 22, 79, 17}, "a85ba4ae18", 0.0f));
            return new Regex(patternCompile);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "<init>", "()V", "fromLiteral", "Lkotlin/text/Regex;", "literal", "", "escape", "escapeReplacement", "ensureUnicodeCase", "", "flags", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int ensureUnicodeCase(int flags) {
            return (flags & 2) != 0 ? flags | 64 : flags;
        }

        public final String escape(String literal) {
            Intrinsics.checkNotNullParameter(literal, C0000.decode(new byte[]{8, 15, 22, 87, 22, 2, 8}, "dfb2dcd5", false));
            String strQuote = Pattern.quote(literal);
            Intrinsics.checkNotNullExpressionValue(strQuote, C0000.decode(new byte[]{66, 23, 94, 71, 82, 75, 72, 30, 29, 75}, "3b137cf0"));
            return strQuote;
        }

        public final String escapeReplacement(String literal) {
            Intrinsics.checkNotNullParameter(literal, C0000.decode(new byte[]{13, 8, 70, 85, 69, 88, 9}, "aa2079ed3cb9a5", 0.0f));
            String strQuoteReplacement = Matcher.quoteReplacement(literal);
            Intrinsics.checkNotNullExpressionValue(strQuoteReplacement, C0000.decode(new byte[]{16, 68, 91, 70, 80, 107, 81, 65, 88, 82, 91, 3, 90, 0, 13, 16, 73, 31, 26, 28, 28}, "a1425941438f7ecd", false));
            return strQuoteReplacement;
        }

        public final Regex fromLiteral(String literal) {
            Intrinsics.checkNotNullParameter(literal, C0000.decode(new byte[]{91, 12, 71, 81, 68, 85, 90}, "7e34646bbe"));
            return new Regex(literal, RegexOption.LITERAL);
        }

        private Companion() {
        }
    }
}
