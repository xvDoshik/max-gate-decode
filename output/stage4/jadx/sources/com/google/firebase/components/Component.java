package com.google.firebase.components;

import androidx.tracing.Trace;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Component {
    public final Set dependencies;
    public final ComponentFactory factory;
    public final int instantiation;
    public final String name;
    public final Set providedInterfaces;
    public final Set publishedEvents;
    public final int type;

    public final class Builder {
        public final HashSet dependencies;
        public ComponentFactory factory;
        public int instantiation;
        public String name = null;
        public final HashSet providedInterfaces;
        public final HashSet publishedEvents;
        public final int type;

        public Builder(Qualified qualified, Qualified[] qualifiedArr) {
            HashSet hashSet = new HashSet();
            this.providedInterfaces = hashSet;
            this.dependencies = new HashSet();
            this.instantiation = 0;
            this.type = 0;
            this.publishedEvents = new HashSet();
            hashSet.add(qualified);
            for (Qualified qualified2 : qualifiedArr) {
                Trace.checkNotNull(qualified2, C0000.decode(new byte[]{42, 23, 13, 84, 66, 81, 93, 69, 84, 16, 4, 3, 2, 80}, "dba8b8311bbba5", 0.0f));
            }
            Collections.addAll(this.providedInterfaces, qualifiedArr);
        }

        public Builder(Class cls, Class[] clsArr) {
            HashSet hashSet = new HashSet();
            this.providedInterfaces = hashSet;
            this.dependencies = new HashSet();
            this.instantiation = 0;
            this.type = 0;
            this.publishedEvents = new HashSet();
            hashSet.add(Qualified.unqualified(cls));
            for (Class cls2 : clsArr) {
                Trace.checkNotNull(cls2, C0000.decode(new byte[]{119, 69, 10, 91, 65, 80, 95, 22, 84, 17, 80, 0, 90, 85}, "90f7a91b1c6a"));
                this.providedInterfaces.add(Qualified.unqualified(cls2));
            }
        }

        public final void add(Dependency dependency) {
            if (this.providedInterfaces.contains(dependency.anInterface)) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{113, 86, 9, 65, 89, 86, 87, 87, 16, 66, 22, 89, 64, 92, 68, 95, 89, 76, 18, 88, 8, 93, 89, 79, 87, 93, 68, 69, 89, 24, 86, 92, 20, 84, 88, 92, 18, 86, 10, 17, 95, 86, 70, 92, 22, 87, 87, 91, 87, 74, 68, 69, 94, 93, 75, 25, 16, 89, 83, 85, 65, 92, 8, 71, 83, 75, 18, 73, 22, 94, 64, 81, 86, 92, 74}, "29d168", 0.0f));
            }
            this.dependencies.add(dependency);
        }

        public final Component build() {
            if (this.factory != null) {
                return new Component(this.name, new HashSet(this.providedInterfaces), new HashSet(this.dependencies), this.instantiation, this.type, this.factory, this.publishedEvents);
            }
            throw new IllegalStateException(C0000.decode(new byte[]{124, 12, 16, 68, 88, 93, 1, 65, 67, 0, 18, 66, 88, 65, 3, 5, 17, 21, 17, 88, 65, 86, 20, 21, 72, 95, 67, 81, 80, 80, 18, 14, 67, 28, 77}, "1ec713fa", 0.0f));
        }
    }

    public Component(String str, Set set, Set set2, int i, int i2, ComponentFactory componentFactory, Set set3) {
        this.name = str;
        this.providedInterfaces = Collections.unmodifiableSet(set);
        this.dependencies = Collections.unmodifiableSet(set2);
        this.instantiation = i;
        this.type = i2;
        this.factory = componentFactory;
        this.publishedEvents = Collections.unmodifiableSet(set3);
    }

    public static Builder builder(Qualified qualified) {
        return new Builder(qualified, new Qualified[0]);
    }

    public static Component of(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(Qualified.unqualified(cls));
        for (Class cls2 : clsArr) {
            Trace.checkNotNull(cls2, C0000.decode(new byte[]{126, 23, 95, 9, 18, 89, 94, 22, 86, 23, 84, 81, 83, 7}, "0b3e20", 0.0f));
            hashSet.add(Qualified.unqualified(cls2));
        }
        return new Component(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new CctTransportBackend$$ExternalSyntheticLambda0(8, obj), hashSet3);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{112, 10, 15, 17, 95, 95, 86, 11, 22, 93}, "3eba01", 0.0f));
        sb.append(Arrays.toString(this.providedInterfaces.toArray()));
        sb.append(C0000.decode(new byte[]{88, 77}, "f63dbc5abe3103", 2));
        sb.append(this.instantiation);
        sb.append(C0000.decode(new byte[]{74, 20, 70, 29, 18, 92, 5}, "f42db981950bd62d", 4));
        sb.append(this.type);
        sb.append(C0000.decode(new byte[]{25, 17, 7, 7, 18, 17, 10}, "51cbbb71", true));
        sb.append(Arrays.toString(this.dependencies.toArray()));
        sb.append(C0000.decode(new byte[]{68}, "92656f3e63", 4));
        return sb.toString();
    }
}
