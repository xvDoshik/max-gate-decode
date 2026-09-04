package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class SpreadBuilder {
    private final ArrayList<Object> list;

    public void addSpread(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.list;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.list, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.list.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.list.add(it.next());
            }
            return;
        }
        if (!(obj instanceof Iterator)) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{114, 92, 91, 31, 71, 23, 91, 93, 87, 18, 24, 91, 89, 68, 21, 76, 92, 23, 67, 67, 74, 0, 89, 87, 22}, "635837038e83") + obj.getClass());
        }
        Iterator it2 = (Iterator) obj;
        while (it2.hasNext()) {
            this.list.add(it2.next());
        }
    }

    public SpreadBuilder(int i) {
        this.list = new ArrayList<>(i);
    }

    public int size() {
        return this.list.size();
    }

    public void add(Object obj) {
        this.list.add(obj);
    }

    public Object[] toArray(Object[] objArr) {
        return this.list.toArray(objArr);
    }
}
