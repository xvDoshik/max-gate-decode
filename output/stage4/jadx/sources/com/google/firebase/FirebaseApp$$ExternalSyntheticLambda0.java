package com.google.firebase;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.content.ContextCompat$Api24Impl;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.messaging.Store;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import okhttp3.Request;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class FirebaseApp$$ExternalSyntheticLambda0 implements Provider {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ FirebaseApp$$ExternalSyntheticLambda0(Context context, String str) {
        this.$r8$classId = 2;
        this.f$1 = context;
        this.f$0 = str;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        switch (this.$r8$classId) {
            case 0:
                FirebaseApp firebaseApp = (FirebaseApp) this.f$0;
                Context context = (Context) this.f$1;
                String persistenceKey = firebaseApp.getPersistenceKey();
                DataCollectionConfigStorage dataCollectionConfigStorage = new DataCollectionConfigStorage();
                Context contextCreateDeviceProtectedStorageContext = ContextCompat$Api24Impl.createDeviceProtectedStorageContext(context);
                SharedPreferences sharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences("com.google.firebase.common.prefs:" + persistenceKey, 0);
                boolean z = true;
                if (sharedPreferences.contains("firebase_data_collection_default_enabled")) {
                    z = sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
                } else {
                    try {
                        PackageManager packageManager = contextCreateDeviceProtectedStorageContext.getPackageManager();
                        if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(contextCreateDeviceProtectedStorageContext.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                            z = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                        }
                        break;
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                dataCollectionConfigStorage.dataCollectionDefaultEnabled = z;
                return dataCollectionConfigStorage;
            case 1:
                ComponentRuntime componentRuntime = (ComponentRuntime) this.f$0;
                Component component = (Component) this.f$1;
                ComponentFactory componentFactory = component.factory;
                Request.Builder builder = new Request.Builder();
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                HashSet hashSet3 = new HashSet();
                HashSet hashSet4 = new HashSet();
                HashSet hashSet5 = new HashSet();
                Set<Dependency> set = component.dependencies;
                Set set2 = component.publishedEvents;
                for (Dependency dependency : set) {
                    int i = dependency.injection;
                    int i2 = dependency.type;
                    boolean z2 = i == 0;
                    Qualified qualified = dependency.anInterface;
                    if (z2) {
                        if (i2 == 2) {
                            hashSet4.add(qualified);
                        } else {
                            hashSet.add(qualified);
                        }
                    } else if (i == 2) {
                        hashSet3.add(qualified);
                    } else if (i2 == 2) {
                        hashSet5.add(qualified);
                    } else {
                        hashSet2.add(qualified);
                    }
                }
                if (!set2.isEmpty()) {
                    hashSet.add(Qualified.unqualified(Publisher.class));
                }
                builder.url = Collections.unmodifiableSet(hashSet);
                builder.method = Collections.unmodifiableSet(hashSet2);
                Collections.unmodifiableSet(hashSet3);
                builder.headers = Collections.unmodifiableSet(hashSet4);
                builder.body = Collections.unmodifiableSet(hashSet5);
                builder.tags = componentRuntime;
                return componentFactory.create(builder);
            default:
                return new Store((Context) this.f$1, (String) this.f$0);
        }
    }

    public /* synthetic */ FirebaseApp$$ExternalSyntheticLambda0(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
