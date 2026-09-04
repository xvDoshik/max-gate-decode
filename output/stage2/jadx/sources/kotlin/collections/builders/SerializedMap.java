package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "map", "", "<init>", "(Ljava/util/Map;)V", "()V", "writeExternal", "", "output", "Ljava/io/ObjectOutput;", "readExternal", "input", "Ljava/io/ObjectInput;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SerializedMap implements Externalizable {
    private static final long serialVersionUID = 0;
    private Map<?, ?> map;

    public SerializedMap(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{88, 5, 18}, "5db497"));
        this.map = map;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) throws InvalidObjectException {
        Intrinsics.checkNotNullParameter(input, C0000.decode(new byte[]{12, 93, 18, 20, 68}, "e3ba07bf8f36", true));
        byte b = input.readByte();
        if (b != 0) {
            throw new InvalidObjectException(C0000.decode(new byte[]{101, 94, 70, 16, 72, 21, 86, 68, 16, 80, 0, 70, 86, 92, 84, 2, 75, 69, 79, 87, 8, 64, 1, 92, 16}, "005e8e96d5df", false) + ((int) b));
        }
        int i = input.readInt();
        if (i < 0) {
            throw new InvalidObjectException(C0000.decode(new byte[]{47, 84, 84, 84, 2, 0, 91, 20, 66, 88, 75, 84, 70, 78, 89, 93, 16, 4, 13, 20}, "f881ea741111") + i + '.');
        }
        Map mapCreateMapBuilder = MapsKt.createMapBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            mapCreateMapBuilder.put(input.readObject(), input.readObject());
        }
        this.map = MapsKt.build(mapCreateMapBuilder);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) throws IOException {
        Intrinsics.checkNotNullParameter(output, C0000.decode(new byte[]{14, 64, 64, 69, 64, 68}, "a54550c16c"));
        output.writeByte(0);
        output.writeInt(this.map.size());
        for (Map.Entry<?, ?> entry : this.map.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }

    public SerializedMap() {
        this(MapsKt.emptyMap());
    }

    private final Object readResolve() {
        return this.map;
    }
}
