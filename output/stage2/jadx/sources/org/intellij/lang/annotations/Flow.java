package org.intellij.lang.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface Flow {
    public static final String DEFAULT_SOURCE = C0000.decode(new byte[]{54, 88, 83, 21, 94, 7, 65, 90, 89, 0, 19, 7, 70, 83, 23, 93, 83, 91, 71, 66, 29, 91, 80, 68, 67, 7, 70, 85, 15, 85, 66, 80, 65, 66, 66, 83, 69, 68, 82, 8, 90, 91, 22, 81, 66, 80, 87, 75, 21, 93, 68, 68, 71, 14, 93, 71, 66, 83, 89, 91, 71, 3, 92, 92, 83, 22, 19, 78, 93, 82, 66, 89, 88, 70, 71, 3, 91, 81, 83, 68, 94, 3, 64, 92, 13, 84, 22, 66, 82, 17, 21, 83, 88, 10, 92, 18, 85, 64, 7, 84, 31}, "b0653b526d3f44");
    public static final String DEFAULT_TARGET = C0000.decode(new byte[]{97, 94, 81, 17, 21, 2, 93, 88, 16, 87, 92, 15, 6, 19, 21, 30, 81, 4, 21, 21, 90, 83, 68, 70, 84, 19, 2, 12, 80, 66, 93, 16, 21, 22, 83, 69, 68, 87, 91, 15, 12, 21, 84, 66, 93, 6, 28, 65, 93, 68, 68, 66, 93, 4, 67, 19, 80, 66, 77, 16, 91, 65, 68, 87, 8, 67, 80, 65, 75, 8, 83, 22, 81, 12, 70, 21, 83, 88, 7, 83, 21, 12, 6, 21, 93, 89, 92, 66, 66, 0, 65, 22, 5, 88, 91, 14, 23, 0, 65, 83, 92, 75}, "568b5a26d65aca", 0);
    public static final String RETURN_METHOD_TARGET = C0000.decode(new byte[]{101, 80, 93, 67, 16, 1, 71, 69, 67, 12, 23, 18, 84, 14, 68, 93, 24, 12, 4, 68, 71, 88, 88, 17, 23, 9, 80, 22, 89, 87, 92}, "188cbd301b7d5b");
    public static final String THIS_SOURCE = C0000.decode(new byte[]{18, 14, 89, 74}, "ff0961", 0);
    public static final String THIS_TARGET = C0000.decode(new byte[]{70, 13, 89, 21}, "2e0fe34ba881a908");

    String source() default "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    boolean sourceIsContainer() default false;

    String target() default "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    boolean targetIsContainer() default false;
}
