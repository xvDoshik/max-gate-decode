package androidx.lifecycle;

import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class LifecycleRegistry {
    public int addingObserverCounter;
    public final boolean enforceMainThread;
    public boolean handlingEvent;
    public final WeakReference lifecycleOwner;
    public boolean newEventOccurred;
    public FastSafeIterableMap observerMap;
    public final ArrayList parentStates;
    public Lifecycle$State state;

    public final class ObserverWithState {
        public LifecycleEventObserver lifecycleObserver;
        public Lifecycle$State state;

        public final void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
            Lifecycle$State targetState = lifecycle$Event.getTargetState();
            Lifecycle$State lifecycle$State = this.state;
            if (targetState.compareTo(lifecycle$State) < 0) {
                lifecycle$State = targetState;
            }
            this.state = lifecycle$State;
            this.lifecycleObserver.onStateChanged(lifecycleOwner, lifecycle$Event);
            this.state = targetState;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        new AtomicReference();
        this.enforceMainThread = true;
        this.observerMap = new FastSafeIterableMap();
        this.state = Lifecycle$State.INITIALIZED;
        this.parentStates = new ArrayList();
        this.lifecycleOwner = new WeakReference(lifecycleOwner);
    }

    public final void addObserver(LifecycleEventObserver lifecycleEventObserver) {
        Object obj;
        LifecycleOwner lifecycleOwner;
        Lifecycle$Event lifecycle$Event;
        enforceMainThreadIfNeeded(C0000.decode(new byte[]{86, 7, 0, 46, 4, 18, 82, 17, 18, 4, 20}, "7cdafa"));
        Lifecycle$State lifecycle$State = this.state;
        Lifecycle$State lifecycle$State2 = Lifecycle$State.DESTROYED;
        if (lifecycle$State != lifecycle$State2) {
            lifecycle$State2 = Lifecycle$State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState();
        int i = Lifecycling.$r8$clinit;
        observerWithState.lifecycleObserver = lifecycleEventObserver;
        observerWithState.state = lifecycle$State2;
        FastSafeIterableMap fastSafeIterableMap = this.observerMap;
        SafeIterableMap.Entry entry = fastSafeIterableMap.get(lifecycleEventObserver);
        if (entry != null) {
            obj = entry.mValue;
        } else {
            HashMap map = fastSafeIterableMap.mHashMap;
            SafeIterableMap.Entry entry2 = new SafeIterableMap.Entry(lifecycleEventObserver, observerWithState);
            fastSafeIterableMap.mSize++;
            SafeIterableMap.Entry entry3 = fastSafeIterableMap.mEnd;
            if (entry3 == null) {
                fastSafeIterableMap.mStart = entry2;
                fastSafeIterableMap.mEnd = entry2;
            } else {
                entry3.mNext = entry2;
                entry2.mPrevious = entry3;
                fastSafeIterableMap.mEnd = entry2;
            }
            map.put(lifecycleEventObserver, entry2);
            obj = null;
        }
        if (((ObserverWithState) obj) == null && (lifecycleOwner = (LifecycleOwner) this.lifecycleOwner.get()) != null) {
            boolean z = this.addingObserverCounter != 0 || this.handlingEvent;
            Lifecycle$State lifecycle$StateCalculateTargetState = calculateTargetState(lifecycleEventObserver);
            this.addingObserverCounter++;
            while (observerWithState.state.compareTo(lifecycle$StateCalculateTargetState) < 0 && this.observerMap.mHashMap.containsKey(lifecycleEventObserver)) {
                Lifecycle$State lifecycle$State3 = observerWithState.state;
                ArrayList arrayList = this.parentStates;
                arrayList.add(lifecycle$State3);
                Lifecycle$Event.Companion companion = Lifecycle$Event.Companion;
                Lifecycle$State lifecycle$State4 = observerWithState.state;
                companion.getClass();
                int iOrdinal = lifecycle$State4.ordinal();
                if (iOrdinal == 1) {
                    lifecycle$Event = Lifecycle$Event.ON_CREATE;
                } else if (iOrdinal != 2) {
                    lifecycle$Event = iOrdinal != 3 ? null : Lifecycle$Event.ON_RESUME;
                } else {
                    lifecycle$Event = Lifecycle$Event.ON_START;
                }
                if (lifecycle$Event == null) {
                    throw new IllegalStateException(C0000.decode(new byte[]{11, 92, 21, 7, 78, 3, 87, 65, 69, 70, 69, 66, 94, 20, 86, 88, 69}, "e35b8f95", true) + observerWithState.state);
                }
                observerWithState.dispatchEvent(lifecycleOwner, lifecycle$Event);
                arrayList.remove(arrayList.size() - 1);
                lifecycle$StateCalculateTargetState = calculateTargetState(lifecycleEventObserver);
            }
            if (!z) {
                sync();
            }
            this.addingObserverCounter--;
        }
    }

    public final Lifecycle$State calculateTargetState(LifecycleEventObserver lifecycleEventObserver) {
        HashMap map = this.observerMap.mHashMap;
        SafeIterableMap.Entry entry = map.containsKey(lifecycleEventObserver) ? ((SafeIterableMap.Entry) map.get(lifecycleEventObserver)).mPrevious : null;
        Lifecycle$State lifecycle$State = entry != null ? ((ObserverWithState) entry.mValue).state : null;
        ArrayList arrayList = this.parentStates;
        Lifecycle$State lifecycle$State2 = arrayList.isEmpty() ? null : (Lifecycle$State) arrayList.get(arrayList.size() - 1);
        Lifecycle$State lifecycle$State3 = this.state;
        if (lifecycle$State == null || lifecycle$State.compareTo(lifecycle$State3) >= 0) {
            lifecycle$State = lifecycle$State3;
        }
        return (lifecycle$State2 == null || lifecycle$State2.compareTo(lifecycle$State) >= 0) ? lifecycle$State : lifecycle$State2;
    }

    public final void enforceMainThreadIfNeeded(String str) {
        if (this.enforceMainThread) {
            ArchTaskExecutor.getInstance().mDelegate.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{127, 93, 71, 95, 9, 84, 16}, "2837f00799341822"), str, C0000.decode(new byte[]{25, 89, 20, 16, 76, 17, 7, 1, 65, 81, 85, 93, 85, 81, 5, 67, 87, 95, 69, 16, 9, 87, 20, 92, 88, 93, 15, 67, 76, 89, 23, 1, 0, 86}, "94ac81eda241")).toString());
            }
        }
    }

    public final void handleLifecycleEvent(Lifecycle$Event lifecycle$Event) {
        enforceMainThreadIfNeeded(C0000.decode(new byte[]{14, 88, 8, 93, 9, 86, 46, 13, 84, 1, 84, 28, 6, 91, 3, 124, 16, 92, 11, 71}, "f9f9e3bd2d7ee7", 6));
        moveToState(lifecycle$Event.getTargetState());
    }

    public final void moveToState(Lifecycle$State lifecycle$State) {
        Lifecycle$State lifecycle$State2 = this.state;
        if (lifecycle$State2 == lifecycle$State) {
            return;
        }
        Lifecycle$State lifecycle$State3 = Lifecycle$State.INITIALIZED;
        Lifecycle$State lifecycle$State4 = Lifecycle$State.DESTROYED;
        if (lifecycle$State2 == lifecycle$State3 && lifecycle$State == lifecycle$State4) {
            throw new IllegalStateException((C0000.decode(new byte[]{11, 13, 20, 92, 69, 92, 87, 64, 69, 6, 91, 78, 93, 25, 95, 70, 10, 15, 20}, "eb493994", true) + this.state + C0000.decode(new byte[]{67, 81, 87, 23, 7, 9, 14, 72, 86, 89, 1, 8, 23, 24}, "c897df", 0.0f) + this.lifecycleOwner.get()).toString());
        }
        this.state = lifecycle$State;
        if (this.handlingEvent || this.addingObserverCounter != 0) {
            this.newEventOccurred = true;
            return;
        }
        this.handlingEvent = true;
        sync();
        this.handlingEvent = false;
        if (this.state == lifecycle$State4) {
            this.observerMap = new FastSafeIterableMap();
        }
    }

    public final void removeObserver(LifecycleEventObserver lifecycleEventObserver) {
        enforceMainThreadIfNeeded(C0000.decode(new byte[]{70, 84, 14, 9, 20, 1, 43, 81, 75, 80, 65, 21, 7, 22}, "41cfbdd3853cbd", false));
        this.observerMap.remove(lifecycleEventObserver);
    }

    public final void sync() {
        Lifecycle$State lifecycle$State;
        Lifecycle$State lifecycle$State2;
        Lifecycle$Event lifecycle$Event;
        Lifecycle$Event lifecycle$Event2;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.lifecycleOwner.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{121, 11, 85, 4, 86, 74, 6, 85, 80, 45, 68, 15, 80, 65, 69, 86, 83, 66, 71, 9, 92, 64, 69, 117, 92, 4, 86, 2, 76, 80, 9, 92, 103, 7, 84, 8, 70, 71, 23, 64, 21, 11, 64, 65, 84, 95, 23, 92, 84, 6, 74, 65, 82, 82, 23, 91, 84, 5, 86, 65, 86, 92, 9, 85, 80, 1, 71, 4, 81, 29, 69, 112, 65, 66, 90, 18, 21, 71, 10, 86, 21, 14, 82, 21, 80, 19, 17, 86, 21, 1, 91, 0, 91, 84, 0, 25, 89, 11, 85, 4, 86, 74, 6, 85, 80, 66, 64, 21, 84, 71, 0, 23}, "5b3a53e9"));
        }
        while (true) {
            FastSafeIterableMap fastSafeIterableMap = this.observerMap;
            if (fastSafeIterableMap.mSize == 0 || ((lifecycle$State = ((ObserverWithState) fastSafeIterableMap.mStart.mValue).state) == (lifecycle$State2 = ((ObserverWithState) fastSafeIterableMap.mEnd.mValue).state) && this.state == lifecycle$State2)) {
                break;
            }
            this.newEventOccurred = false;
            int iCompareTo = this.state.compareTo(lifecycle$State);
            ArrayList arrayList = this.parentStates;
            if (iCompareTo < 0) {
                FastSafeIterableMap fastSafeIterableMap2 = this.observerMap;
                SafeIterableMap.AscendingIterator ascendingIterator = new SafeIterableMap.AscendingIterator(fastSafeIterableMap2.mEnd, fastSafeIterableMap2.mStart, 1);
                fastSafeIterableMap2.mIterators.put(ascendingIterator, Boolean.FALSE);
                while (ascendingIterator.hasNext() && !this.newEventOccurred) {
                    Map.Entry entry = (Map.Entry) ascendingIterator.next();
                    LifecycleEventObserver lifecycleEventObserver = (LifecycleEventObserver) entry.getKey();
                    ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
                    while (observerWithState.state.compareTo(this.state) > 0 && !this.newEventOccurred && this.observerMap.mHashMap.containsKey(lifecycleEventObserver)) {
                        Lifecycle$Event.Companion companion = Lifecycle$Event.Companion;
                        Lifecycle$State lifecycle$State3 = observerWithState.state;
                        companion.getClass();
                        int iOrdinal = lifecycle$State3.ordinal();
                        if (iOrdinal == 2) {
                            lifecycle$Event2 = Lifecycle$Event.ON_DESTROY;
                        } else if (iOrdinal != 3) {
                            lifecycle$Event2 = iOrdinal != 4 ? null : Lifecycle$Event.ON_PAUSE;
                        } else {
                            lifecycle$Event2 = Lifecycle$Event.ON_STOP;
                        }
                        if (lifecycle$Event2 == null) {
                            throw new IllegalStateException(C0000.decode(new byte[]{92, 92, 67, 82, 64, 80, 91, 16, 18, 5, 12, 67, 15, 65, 82, 64, 93, 94, 67}, "23c7655d2ac4aa42", true) + observerWithState.state);
                        }
                        arrayList.add(lifecycle$Event2.getTargetState());
                        observerWithState.dispatchEvent(lifecycleOwner, lifecycle$Event2);
                        arrayList.remove(arrayList.size() - 1);
                    }
                }
            }
            SafeIterableMap.Entry entry2 = this.observerMap.mEnd;
            if (!this.newEventOccurred && entry2 != null && this.state.compareTo(((ObserverWithState) entry2.mValue).state) > 0) {
                FastSafeIterableMap fastSafeIterableMap3 = this.observerMap;
                fastSafeIterableMap3.getClass();
                SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions();
                fastSafeIterableMap3.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
                while (iteratorWithAdditions.hasNext() && !this.newEventOccurred) {
                    Map.Entry entry3 = (Map.Entry) iteratorWithAdditions.next();
                    LifecycleEventObserver lifecycleEventObserver2 = (LifecycleEventObserver) entry3.getKey();
                    ObserverWithState observerWithState2 = (ObserverWithState) entry3.getValue();
                    while (observerWithState2.state.compareTo(this.state) < 0 && !this.newEventOccurred && this.observerMap.mHashMap.containsKey(lifecycleEventObserver2)) {
                        arrayList.add(observerWithState2.state);
                        Lifecycle$Event.Companion companion2 = Lifecycle$Event.Companion;
                        Lifecycle$State lifecycle$State4 = observerWithState2.state;
                        companion2.getClass();
                        int iOrdinal2 = lifecycle$State4.ordinal();
                        if (iOrdinal2 == 1) {
                            lifecycle$Event = Lifecycle$Event.ON_CREATE;
                        } else if (iOrdinal2 != 2) {
                            lifecycle$Event = iOrdinal2 != 3 ? null : Lifecycle$Event.ON_RESUME;
                        } else {
                            lifecycle$Event = Lifecycle$Event.ON_START;
                        }
                        if (lifecycle$Event == null) {
                            throw new IllegalStateException(C0000.decode(new byte[]{92, 10, 25, 81, 67, 82, 10, 76, 25, 69, 20, 25, 87, 74, 93, 8, 25}, "2e9457d890d918", 0.0f) + observerWithState2.state);
                        }
                        observerWithState2.dispatchEvent(lifecycleOwner, lifecycle$Event);
                        arrayList.remove(arrayList.size() - 1);
                    }
                }
            }
        }
        this.newEventOccurred = false;
    }
}
