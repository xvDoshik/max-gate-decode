package org.jetbrains.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface TestOnly {
}
