package com.google.firebase.components;

import androidx.work.impl.AutoMigration_14_15;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.firebase.FirebaseApp$$ExternalSyntheticLambda0;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ResultKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ComponentRuntime implements ComponentContainer {
    public static final ComponentRuntime$$ExternalSyntheticLambda0 EMPTY_PROVIDER = new ComponentRuntime$$ExternalSyntheticLambda0(0);
    public final AutoMigration_14_15 componentRegistrarProcessor;
    public final HashMap components;
    public final AtomicReference eagerComponentsInitializedWith;
    public final EventBus eventBus;
    public final HashMap lazyInstanceMap;
    public final HashMap lazySetMap;
    public final HashSet processedCoroutineDispatcherInterfaces;

    public ComponentRuntime(ArrayList arrayList, ArrayList arrayList2, AutoMigration_14_15 autoMigration_14_15) {
        UiExecutor uiExecutor = UiExecutor.INSTANCE;
        this.components = new HashMap();
        this.lazyInstanceMap = new HashMap();
        this.lazySetMap = new HashMap();
        this.processedCoroutineDispatcherInterfaces = new HashSet();
        this.eagerComponentsInitializedWith = new AtomicReference();
        EventBus eventBus = new EventBus();
        this.eventBus = eventBus;
        this.componentRegistrarProcessor = autoMigration_14_15;
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(Component.of(eventBus, EventBus.class, Subscriber.class, Publisher.class));
        int i = 0;
        arrayList3.add(Component.of(this, ComponentRuntime.class, new Class[0]));
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            Component component = (Component) obj;
            if (component != null) {
                arrayList3.add(component);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList4.add(obj2);
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((Provider) it.next()).get();
                    if (componentRegistrar != null) {
                        arrayList3.addAll(this.componentRegistrarProcessor.processRegistrar(componentRegistrar));
                        it.remove();
                    }
                } catch (InvalidRegistrarException unused) {
                    it.remove();
                }
            }
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                for (Object obj3 : ((Component) it2.next()).providedInterfaces.toArray()) {
                    if (obj3.toString().contains(C0000.decode(new byte[]{8, 87, 17, 15, 95, 87, 78, 27, 90, 90, 70, 89, 23, 16, 10, 86, 0, 16, 24, 122, 89, 71, 86, 64, 64, 95, 12, 1, 39, 81, 22, 19, 87, 77, 85, 93, 92, 71}, "c8ec69659546bd", 3))) {
                        if (this.processedCoroutineDispatcherInterfaces.contains(obj3.toString())) {
                            it2.remove();
                            break;
                        }
                        this.processedCoroutineDispatcherInterfaces.add(obj3.toString());
                    }
                }
            }
            if (this.components.isEmpty()) {
                ResultKt.detect(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.components.keySet());
                arrayList6.addAll(arrayList3);
                ResultKt.detect(arrayList6);
            }
            int size3 = arrayList3.size();
            int i4 = 0;
            while (i4 < size3) {
                Object obj4 = arrayList3.get(i4);
                i4++;
                Component component2 = (Component) obj4;
                this.components.put(component2, new Lazy(new FirebaseApp$$ExternalSyntheticLambda0(this, 1, component2)));
            }
            arrayList5.addAll(processInstanceComponents(arrayList3));
            arrayList5.addAll(processSetComponents());
            processDependencies();
        }
        int size4 = arrayList5.size();
        while (i < size4) {
            Object obj5 = arrayList5.get(i);
            i++;
            ((Runnable) obj5).run();
        }
        Boolean bool = (Boolean) this.eagerComponentsInitializedWith.get();
        if (bool != null) {
            doInitializeEagerComponents(this.components, bool.booleanValue());
        }
    }

    public final void doInitializeEagerComponents(HashMap map, boolean z) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : map.entrySet()) {
            Component component = (Component) entry.getKey();
            Provider provider = (Provider) entry.getValue();
            int i = component.instantiation;
            if (i == 1 || (i == 2 && z)) {
                provider.get();
            }
        }
        EventBus eventBus = this.eventBus;
        synchronized (eventBus) {
            try {
                arrayDeque = eventBus.pendingEvents;
                if (arrayDeque != null) {
                    eventBus.pendingEvents = null;
                } else {
                    arrayDeque = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        }
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final synchronized Provider getProvider(Qualified qualified) {
        return (Provider) this.lazyInstanceMap.get(qualified);
    }

    public final void processDependencies() {
        for (Component component : this.components.keySet()) {
            for (Dependency dependency : component.dependencies) {
                if (dependency.type == 2 && !this.lazySetMap.containsKey(dependency.anInterface)) {
                    HashMap map = this.lazySetMap;
                    Qualified qualified = dependency.anInterface;
                    Set set = Collections.EMPTY_SET;
                    LazySet lazySet = new LazySet();
                    lazySet.actualSet = null;
                    lazySet.providers = Collections.newSetFromMap(new ConcurrentHashMap());
                    lazySet.providers.addAll(set);
                    map.put(qualified, lazySet);
                } else if (this.lazyInstanceMap.containsKey(dependency.anInterface)) {
                    continue;
                } else {
                    int i = dependency.type;
                    if (i == 1) {
                        throw new DependencyCycleException(C0000.decode(new byte[]{103, 92, 75, 83, 70, 95, 70, 85, 80, 85, 83, 18, 86, 87, 72, 87, 92, 82, 80, 93, 90, 73, 23, 84, 93, 64, 24, 81, 93, 91, 69, 92, 87, 85, 89, 70, 18}, "228226539072", true) + component + C0000.decode(new byte[]{11, 67}, "1c36e25a747d", 7) + dependency.anInterface);
                    }
                    if (i != 2) {
                        HashMap map2 = this.lazyInstanceMap;
                        Qualified qualified2 = dependency.anInterface;
                        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = OptionalProvider.NOOP_HANDLER;
                        ComponentRuntime$$ExternalSyntheticLambda0 componentRuntime$$ExternalSyntheticLambda0 = OptionalProvider.EMPTY_PROVIDER;
                        OptionalProvider optionalProvider = new OptionalProvider();
                        optionalProvider.handler = transportImpl$$ExternalSyntheticLambda0;
                        optionalProvider.delegate = componentRuntime$$ExternalSyntheticLambda0;
                        map2.put(qualified2, optionalProvider);
                    }
                }
            }
        }
    }

    public final ArrayList processInstanceComponents(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Component component = (Component) obj;
            if (component.type == 0) {
                Provider provider = (Provider) this.components.get(component);
                for (Qualified qualified : component.providedInterfaces) {
                    HashMap map = this.lazyInstanceMap;
                    if (map.containsKey(qualified)) {
                        arrayList2.add(new Processor$$ExternalSyntheticLambda2((OptionalProvider) ((Provider) map.get(qualified)), 13, provider));
                    } else {
                        map.put(qualified, provider);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList processSetComponents() {
        HashMap map = this.lazySetMap;
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        for (Map.Entry entry : this.components.entrySet()) {
            Component component = (Component) entry.getKey();
            if (component.type != 0) {
                Provider provider = (Provider) entry.getValue();
                for (Qualified qualified : component.providedInterfaces) {
                    if (!map2.containsKey(qualified)) {
                        map2.put(qualified, new HashSet());
                    }
                    ((Set) map2.get(qualified)).add(provider);
                }
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (map.containsKey(entry2.getKey())) {
                LazySet lazySet = (LazySet) map.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new Processor$$ExternalSyntheticLambda2(lazySet, 14, (Provider) it.next()));
                }
            } else {
                Qualified qualified2 = (Qualified) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                LazySet lazySet2 = new LazySet();
                lazySet2.actualSet = null;
                lazySet2.providers = Collections.newSetFromMap(new ConcurrentHashMap());
                lazySet2.providers.addAll(set);
                map.put(qualified2, lazySet2);
            }
        }
        return arrayList;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final synchronized Provider setOfProvider(Qualified qualified) {
        LazySet lazySet = (LazySet) this.lazySetMap.get(qualified);
        if (lazySet != null) {
            return lazySet;
        }
        return EMPTY_PROVIDER;
    }
}
