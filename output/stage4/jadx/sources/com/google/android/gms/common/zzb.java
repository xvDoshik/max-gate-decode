package com.google.android.gms.common;

import android.accounts.Account;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.BackStackState;
import androidx.fragment.app.FragmentManagerState;
import androidx.fragment.app.FragmentState;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.firebase.messaging.RemoteMessage;
import java.util.ArrayList;
import kotlin.io.CloseableKt;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzb implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zzb(int i) {
        this.$r8$classId = i;
    }

    public static void zza(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        int i2 = getServiceRequest.zzc;
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = getServiceRequest.zzd;
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = getServiceRequest.zze;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(i4);
        CloseableKt.writeString(parcel, 4, getServiceRequest.zzf);
        IBinder iBinder = getServiceRequest.zzg;
        if (iBinder != null) {
            int iZza2 = CloseableKt.zza(parcel, 5);
            parcel.writeStrongBinder(iBinder);
            CloseableKt.zzb(parcel, iZza2);
        }
        CloseableKt.writeTypedArray(parcel, 6, getServiceRequest.zzh, i);
        CloseableKt.writeBundle(parcel, 7, getServiceRequest.zzi);
        CloseableKt.writeParcelable(parcel, 8, getServiceRequest.zzj, i);
        CloseableKt.writeTypedArray(parcel, 10, getServiceRequest.zzk, i);
        CloseableKt.writeTypedArray(parcel, 11, getServiceRequest.zzl, i);
        boolean z = getServiceRequest.zzm;
        CloseableKt.zzc(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        int i5 = getServiceRequest.zzn;
        CloseableKt.zzc(parcel, 13, 4);
        parcel.writeInt(i5);
        boolean z2 = getServiceRequest.zzo;
        CloseableKt.zzc(parcel, 14, 4);
        parcel.writeInt(z2 ? 1 : 0);
        CloseableKt.writeString(parcel, 15, getServiceRequest.zzp);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.$r8$classId) {
            case 0:
                int iValidateObjectHeader = CharsKt.validateObjectHeader(parcel);
                int i = 0;
                PendingIntent pendingIntent = null;
                String strCreateString = null;
                int i2 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader) {
                    int i3 = parcel.readInt();
                    char c = (char) i3;
                    if (c == 1) {
                        i = CharsKt.readInt(parcel, i3);
                    } else if (c == 2) {
                        i2 = CharsKt.readInt(parcel, i3);
                    } else if (c == 3) {
                        pendingIntent = (PendingIntent) CharsKt.createParcelable(parcel, i3, PendingIntent.CREATOR);
                    } else if (c != 4) {
                        CharsKt.skipUnknownField(parcel, i3);
                    } else {
                        strCreateString = CharsKt.createString(parcel, i3);
                    }
                }
                CharsKt.ensureAtEnd(parcel, iValidateObjectHeader);
                return new ConnectionResult(i, i2, pendingIntent, strCreateString);
            case 1:
                return new ActivityResult(parcel);
            case 2:
                return new BackStackState(parcel);
            case 3:
                FragmentManagerState fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.mPrimaryNavActiveIndex = -1;
                fragmentManagerState.mActive = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
                fragmentManagerState.mAdded = parcel.createIntArray();
                fragmentManagerState.mBackStack = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
                fragmentManagerState.mPrimaryNavActiveIndex = parcel.readInt();
                fragmentManagerState.mNextFragmentIndex = parcel.readInt();
                return fragmentManagerState;
            case 4:
                return new FragmentState(parcel);
            case 5:
                return new ParcelImpl(parcel);
            case 6:
                int iValidateObjectHeader2 = CharsKt.validateObjectHeader(parcel);
                int i4 = 0;
                String strCreateString2 = null;
                while (parcel.dataPosition() < iValidateObjectHeader2) {
                    int i5 = parcel.readInt();
                    char c2 = (char) i5;
                    if (c2 == 1) {
                        i4 = CharsKt.readInt(parcel, i5);
                    } else if (c2 != 2) {
                        CharsKt.skipUnknownField(parcel, i5);
                    } else {
                        strCreateString2 = CharsKt.createString(parcel, i5);
                    }
                }
                CharsKt.ensureAtEnd(parcel, iValidateObjectHeader2);
                return new Scope(strCreateString2, i4);
            case 7:
                int iValidateObjectHeader3 = CharsKt.validateObjectHeader(parcel);
                int i6 = 0;
                int i7 = 0;
                String strCreateString3 = null;
                PendingIntent pendingIntent2 = null;
                ConnectionResult connectionResult = null;
                while (parcel.dataPosition() < iValidateObjectHeader3) {
                    int i8 = parcel.readInt();
                    char c3 = (char) i8;
                    if (c3 == 1) {
                        i7 = CharsKt.readInt(parcel, i8);
                    } else if (c3 == 2) {
                        strCreateString3 = CharsKt.createString(parcel, i8);
                    } else if (c3 == 3) {
                        pendingIntent2 = (PendingIntent) CharsKt.createParcelable(parcel, i8, PendingIntent.CREATOR);
                    } else if (c3 == 4) {
                        connectionResult = (ConnectionResult) CharsKt.createParcelable(parcel, i8, ConnectionResult.CREATOR);
                    } else if (c3 != 1000) {
                        CharsKt.skipUnknownField(parcel, i8);
                    } else {
                        i6 = CharsKt.readInt(parcel, i8);
                    }
                }
                CharsKt.ensureAtEnd(parcel, iValidateObjectHeader3);
                return new Status(i6, i7, strCreateString3, pendingIntent2, connectionResult);
            case 8:
                int iValidateObjectHeader4 = CharsKt.validateObjectHeader(parcel);
                int i9 = 0;
                while (true) {
                    ArrayList arrayListCreateTypedArrayList = null;
                    while (true) {
                        if (parcel.dataPosition() >= iValidateObjectHeader4) {
                            CharsKt.ensureAtEnd(parcel, iValidateObjectHeader4);
                            return new TelemetryData(i9, arrayListCreateTypedArrayList);
                        }
                        int i10 = parcel.readInt();
                        char c4 = (char) i10;
                        if (c4 == 1) {
                            i9 = CharsKt.readInt(parcel, i10);
                        } else if (c4 != 2) {
                            CharsKt.skipUnknownField(parcel, i10);
                        } else {
                            Parcelable.Creator<MethodInvocation> creator = MethodInvocation.CREATOR;
                            int size = CharsKt.readSize(parcel, i10);
                            int iDataPosition = parcel.dataPosition();
                            if (size == 0) {
                            }
                            arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
                            parcel.setDataPosition(iDataPosition + size);
                        }
                        break;
                    }
                }
                break;
            case 9:
                int iValidateObjectHeader5 = CharsKt.validateObjectHeader(parcel);
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                long j = 0;
                long j2 = 0;
                String strCreateString4 = null;
                String strCreateString5 = null;
                int i15 = -1;
                while (parcel.dataPosition() < iValidateObjectHeader5) {
                    int i16 = parcel.readInt();
                    switch ((char) i16) {
                        case 1:
                            i11 = CharsKt.readInt(parcel, i16);
                            break;
                        case 2:
                            i12 = CharsKt.readInt(parcel, i16);
                            break;
                        case 3:
                            i13 = CharsKt.readInt(parcel, i16);
                            break;
                        case 4:
                            CharsKt.zzb(parcel, i16, 8);
                            j = parcel.readLong();
                            break;
                        case 5:
                            CharsKt.zzb(parcel, i16, 8);
                            j2 = parcel.readLong();
                            break;
                        case 6:
                            strCreateString4 = CharsKt.createString(parcel, i16);
                            break;
                        case 7:
                            strCreateString5 = CharsKt.createString(parcel, i16);
                            break;
                        case '\b':
                            i14 = CharsKt.readInt(parcel, i16);
                            break;
                        case '\t':
                            i15 = CharsKt.readInt(parcel, i16);
                            break;
                        default:
                            CharsKt.skipUnknownField(parcel, i16);
                            break;
                    }
                }
                CharsKt.ensureAtEnd(parcel, iValidateObjectHeader5);
                return new MethodInvocation(i11, i12, i13, j, j2, strCreateString4, strCreateString5, i14, i15);
            case 10:
                int iValidateObjectHeader6 = CharsKt.validateObjectHeader(parcel);
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                boolean z = false;
                boolean z2 = false;
                while (parcel.dataPosition() < iValidateObjectHeader6) {
                    int i20 = parcel.readInt();
                    char c5 = (char) i20;
                    if (c5 == 1) {
                        i17 = CharsKt.readInt(parcel, i20);
                    } else if (c5 == 2) {
                        z = CharsKt.readBoolean(parcel, i20);
                    } else if (c5 == 3) {
                        z2 = CharsKt.readBoolean(parcel, i20);
                    } else if (c5 == 4) {
                        i18 = CharsKt.readInt(parcel, i20);
                    } else if (c5 != 5) {
                        CharsKt.skipUnknownField(parcel, i20);
                    } else {
                        i19 = CharsKt.readInt(parcel, i20);
                    }
                }
                CharsKt.ensureAtEnd(parcel, iValidateObjectHeader6);
                return new RootTelemetryConfiguration(i17, i18, i19, z, z2);
            case 11:
                int iValidateObjectHeader7 = CharsKt.validateObjectHeader(parcel);
                Bundle bundleCreateBundle = null;
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
                int i21 = 0;
                Feature[] featureArr = null;
                while (parcel.dataPosition() < iValidateObjectHeader7) {
                    int i22 = parcel.readInt();
                    char c6 = (char) i22;
                    if (c6 == 1) {
                        bundleCreateBundle = CharsKt.createBundle(parcel, i22);
                    } else if (c6 == 2) {
                        featureArr = (Feature[]) CharsKt.createTypedArray(parcel, i22, Feature.CREATOR);
                    } else if (c6 == 3) {
                        i21 = CharsKt.readInt(parcel, i22);
                    } else if (c6 != 4) {
                        CharsKt.skipUnknownField(parcel, i22);
                    } else {
                        connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) CharsKt.createParcelable(parcel, i22, ConnectionTelemetryConfiguration.CREATOR);
                    }
                }
                CharsKt.ensureAtEnd(parcel, iValidateObjectHeader7);
                com.google.android.gms.common.internal.zzj zzjVar = new com.google.android.gms.common.internal.zzj();
                zzjVar.zza = bundleCreateBundle;
                zzjVar.zzb = featureArr;
                zzjVar.zzc = i21;
                zzjVar.zzd = connectionTelemetryConfiguration;
                return zzjVar;
            case 12:
                int iValidateObjectHeader8 = CharsKt.validateObjectHeader(parcel);
                RootTelemetryConfiguration rootTelemetryConfiguration = null;
                int[] iArrCreateIntArray = null;
                int[] iArrCreateIntArray2 = null;
                boolean z3 = false;
                boolean z4 = false;
                int i23 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader8) {
                    int i24 = parcel.readInt();
                    switch ((char) i24) {
                        case 1:
                            rootTelemetryConfiguration = (RootTelemetryConfiguration) CharsKt.createParcelable(parcel, i24, RootTelemetryConfiguration.CREATOR);
                            break;
                        case 2:
                            z3 = CharsKt.readBoolean(parcel, i24);
                            break;
                        case 3:
                            z4 = CharsKt.readBoolean(parcel, i24);
                            break;
                        case 4:
                            int size2 = CharsKt.readSize(parcel, i24);
                            int iDataPosition2 = parcel.dataPosition();
                            if (size2 != 0) {
                                iArrCreateIntArray = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition2 + size2);
                            } else {
                                iArrCreateIntArray = null;
                            }
                            break;
                        case 5:
                            i23 = CharsKt.readInt(parcel, i24);
                            break;
                        case 6:
                            int size3 = CharsKt.readSize(parcel, i24);
                            int iDataPosition3 = parcel.dataPosition();
                            if (size3 != 0) {
                                iArrCreateIntArray2 = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition3 + size3);
                            } else {
                                iArrCreateIntArray2 = null;
                            }
                            break;
                        default:
                            CharsKt.skipUnknownField(parcel, i24);
                            break;
                    }
                }
                CharsKt.ensureAtEnd(parcel, iValidateObjectHeader8);
                return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z3, z4, iArrCreateIntArray, i23, iArrCreateIntArray2);
            case 13:
                int iValidateObjectHeader9 = CharsKt.validateObjectHeader(parcel);
                Bundle bundle = new Bundle();
                Scope[] scopeArr = GetServiceRequest.zza;
                Feature[] featureArr2 = GetServiceRequest.zzb;
                Feature[] featureArr3 = featureArr2;
                int i25 = 0;
                int i26 = 0;
                int i27 = 0;
                boolean z5 = false;
                int i28 = 0;
                boolean z6 = false;
                String strCreateString6 = null;
                IBinder iBinder = null;
                Account account = null;
                String strCreateString7 = null;
                while (parcel.dataPosition() < iValidateObjectHeader9) {
                    int i29 = parcel.readInt();
                    switch ((char) i29) {
                        case 1:
                            i25 = CharsKt.readInt(parcel, i29);
                            break;
                        case 2:
                            i26 = CharsKt.readInt(parcel, i29);
                            break;
                        case 3:
                            i27 = CharsKt.readInt(parcel, i29);
                            break;
                        case 4:
                            strCreateString6 = CharsKt.createString(parcel, i29);
                            break;
                        case 5:
                            int size4 = CharsKt.readSize(parcel, i29);
                            int iDataPosition4 = parcel.dataPosition();
                            if (size4 != 0) {
                                IBinder strongBinder = parcel.readStrongBinder();
                                parcel.setDataPosition(iDataPosition4 + size4);
                                iBinder = strongBinder;
                            } else {
                                iBinder = null;
                            }
                            break;
                        case 6:
                            scopeArr = (Scope[]) CharsKt.createTypedArray(parcel, i29, Scope.CREATOR);
                            break;
                        case 7:
                            bundle = CharsKt.createBundle(parcel, i29);
                            break;
                        case '\b':
                            account = (Account) CharsKt.createParcelable(parcel, i29, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            CharsKt.skipUnknownField(parcel, i29);
                            break;
                        case '\n':
                            featureArr2 = (Feature[]) CharsKt.createTypedArray(parcel, i29, Feature.CREATOR);
                            break;
                        case 11:
                            featureArr3 = (Feature[]) CharsKt.createTypedArray(parcel, i29, Feature.CREATOR);
                            break;
                        case '\f':
                            z5 = CharsKt.readBoolean(parcel, i29);
                            break;
                        case '\r':
                            i28 = CharsKt.readInt(parcel, i29);
                            break;
                        case 14:
                            z6 = CharsKt.readBoolean(parcel, i29);
                            break;
                        case 15:
                            strCreateString7 = CharsKt.createString(parcel, i29);
                            break;
                    }
                }
                CharsKt.ensureAtEnd(parcel, iValidateObjectHeader9);
                return new GetServiceRequest(i25, i26, i27, strCreateString6, iBinder, scopeArr, bundle, account, featureArr2, featureArr3, z5, i28, z6, strCreateString7);
            case 14:
                int iValidateObjectHeader10 = CharsKt.validateObjectHeader(parcel);
                String strCreateString8 = null;
                int i30 = 0;
                long j3 = -1;
                while (parcel.dataPosition() < iValidateObjectHeader10) {
                    int i31 = parcel.readInt();
                    char c7 = (char) i31;
                    if (c7 == 1) {
                        strCreateString8 = CharsKt.createString(parcel, i31);
                    } else if (c7 == 2) {
                        i30 = CharsKt.readInt(parcel, i31);
                    } else if (c7 != 3) {
                        CharsKt.skipUnknownField(parcel, i31);
                    } else {
                        CharsKt.zzb(parcel, i31, 8);
                        j3 = parcel.readLong();
                    }
                }
                CharsKt.ensureAtEnd(parcel, iValidateObjectHeader10);
                return new Feature(i30, j3, strCreateString8);
            default:
                int iValidateObjectHeader11 = CharsKt.validateObjectHeader(parcel);
                Bundle bundleCreateBundle2 = null;
                while (parcel.dataPosition() < iValidateObjectHeader11) {
                    int i32 = parcel.readInt();
                    if (((char) i32) != 2) {
                        CharsKt.skipUnknownField(parcel, i32);
                    } else {
                        bundleCreateBundle2 = CharsKt.createBundle(parcel, i32);
                    }
                }
                CharsKt.ensureAtEnd(parcel, iValidateObjectHeader11);
                return new RemoteMessage(bundleCreateBundle2);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new ConnectionResult[i];
            case 1:
                return new ActivityResult[i];
            case 2:
                return new BackStackState[i];
            case 3:
                return new FragmentManagerState[i];
            case 4:
                return new FragmentState[i];
            case 5:
                return new ParcelImpl[i];
            case 6:
                return new Scope[i];
            case 7:
                return new Status[i];
            case 8:
                return new TelemetryData[i];
            case 9:
                return new MethodInvocation[i];
            case 10:
                return new RootTelemetryConfiguration[i];
            case 11:
                return new com.google.android.gms.common.internal.zzj[i];
            case 12:
                return new ConnectionTelemetryConfiguration[i];
            case 13:
                return new GetServiceRequest[i];
            case 14:
                return new Feature[i];
            default:
                return new RemoteMessage[i];
        }
    }
}
