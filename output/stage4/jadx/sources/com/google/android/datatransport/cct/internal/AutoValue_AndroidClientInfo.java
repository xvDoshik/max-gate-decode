package com.google.android.datatransport.cct.internal;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_AndroidClientInfo extends AndroidClientInfo {
    public final String applicationBuild;
    public final String country;
    public final String device;
    public final String fingerprint;
    public final String hardware;
    public final String locale;
    public final String manufacturer;
    public final String mccMnc;
    public final String model;
    public final String osBuild;
    public final String product;
    public final Integer sdkVersion;

    public AutoValue_AndroidClientInfo(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.sdkVersion = num;
        this.model = str;
        this.hardware = str2;
        this.device = str3;
        this.product = str4;
        this.osBuild = str5;
        this.manufacturer = str6;
        this.fingerprint = str7;
        this.locale = str8;
        this.country = str9;
        this.mccMnc = str10;
        this.applicationBuild = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AndroidClientInfo) {
            AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
            Integer num = this.sdkVersion;
            if (num != null ? num.equals(((AutoValue_AndroidClientInfo) androidClientInfo).sdkVersion) : ((AutoValue_AndroidClientInfo) androidClientInfo).sdkVersion == null) {
                String str = this.model;
                if (str != null ? str.equals(((AutoValue_AndroidClientInfo) androidClientInfo).model) : ((AutoValue_AndroidClientInfo) androidClientInfo).model == null) {
                    String str2 = this.hardware;
                    if (str2 != null ? str2.equals(((AutoValue_AndroidClientInfo) androidClientInfo).hardware) : ((AutoValue_AndroidClientInfo) androidClientInfo).hardware == null) {
                        String str3 = this.device;
                        if (str3 != null ? str3.equals(((AutoValue_AndroidClientInfo) androidClientInfo).device) : ((AutoValue_AndroidClientInfo) androidClientInfo).device == null) {
                            String str4 = this.product;
                            if (str4 != null ? str4.equals(((AutoValue_AndroidClientInfo) androidClientInfo).product) : ((AutoValue_AndroidClientInfo) androidClientInfo).product == null) {
                                String str5 = this.osBuild;
                                if (str5 != null ? str5.equals(((AutoValue_AndroidClientInfo) androidClientInfo).osBuild) : ((AutoValue_AndroidClientInfo) androidClientInfo).osBuild == null) {
                                    String str6 = this.manufacturer;
                                    if (str6 != null ? str6.equals(((AutoValue_AndroidClientInfo) androidClientInfo).manufacturer) : ((AutoValue_AndroidClientInfo) androidClientInfo).manufacturer == null) {
                                        String str7 = this.fingerprint;
                                        if (str7 != null ? str7.equals(((AutoValue_AndroidClientInfo) androidClientInfo).fingerprint) : ((AutoValue_AndroidClientInfo) androidClientInfo).fingerprint == null) {
                                            String str8 = this.locale;
                                            if (str8 != null ? str8.equals(((AutoValue_AndroidClientInfo) androidClientInfo).locale) : ((AutoValue_AndroidClientInfo) androidClientInfo).locale == null) {
                                                String str9 = this.country;
                                                if (str9 != null ? str9.equals(((AutoValue_AndroidClientInfo) androidClientInfo).country) : ((AutoValue_AndroidClientInfo) androidClientInfo).country == null) {
                                                    String str10 = this.mccMnc;
                                                    if (str10 != null ? str10.equals(((AutoValue_AndroidClientInfo) androidClientInfo).mccMnc) : ((AutoValue_AndroidClientInfo) androidClientInfo).mccMnc == null) {
                                                        String str11 = this.applicationBuild;
                                                        if (str11 != null ? str11.equals(((AutoValue_AndroidClientInfo) androidClientInfo).applicationBuild) : ((AutoValue_AndroidClientInfo) androidClientInfo).applicationBuild == null) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.sdkVersion;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.model;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.hardware;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.device;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.product;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.osBuild;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.manufacturer;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.fingerprint;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.locale;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.country;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.mccMnc;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.applicationBuild;
        return (str11 != null ? str11.hashCode() : 0) ^ iHashCode11;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{121, 86, 5, 75, 10, 93, 86, 117, 10, 11, 7, 95, 76, 113, 15, 95, 10, 79, 65, 82, 13, 52, 7, 67, 75, 81, 14, 87, 88}, "88a9e426fbb1", 0.0f));
        sb.append(this.sdkVersion);
        sb.append(C0000.decode(new byte[]{72, 70, 94, 92, 7, 81, 15, 8}, "df33c4c5e768bc"));
        sb.append(this.model);
        sb.append(C0000.decode(new byte[]{20, 19, 13, 0, 23, 6, 66, 89, 20, 7, 4}, "83eaeb58fb9627"));
        sb.append(this.hardware);
        sb.append(C0000.decode(new byte[]{78, 25, 1, 92, 64, 95, 80, 1, 12}, "b9e9663d15ee", 0.0f));
        sb.append(this.device);
        sb.append(C0000.decode(new byte[]{24, 66, 64, 19, 87, 85, 66, 83, 65, 15}, "4b0a817052fe", 2));
        sb.append(this.product);
        sb.append(C0000.decode(new byte[]{25, 70, 89, 18, 119, 70, 81, 14, 0, 11}, "5f6a538bd6ff0b"));
        sb.append(this.osBuild);
        sb.append(C0000.decode(new byte[]{21, 68, 11, 87, 94, 16, 87, 4, 90, 64, 76, 22, 3, 68, 13}, "9df60e1e94", 4));
        sb.append(this.manufacturer);
        sb.append(C0000.decode(new byte[]{28, 25, 80, 11, 12, 87, 85, 75, 70, 16, 11, 94, 68, 4}, "096bb0", 0.0f));
        sb.append(this.fingerprint);
        sb.append(C0000.decode(new byte[]{26, 17, 94, 93, 81, 82, 90, 87, 95}, "61222362b816", 7));
        sb.append(this.locale);
        sb.append(C0000.decode(new byte[]{29, 67, 0, 86, 20, 86, 23, 69, 65, 4}, "1cc9a8c789", true));
        sb.append(this.country);
        sb.append(C0000.decode(new byte[]{73, 70, 93, 86, 82, 41, 91, 90, 5}, "ef051d5984eb"));
        sb.append(this.mccMnc);
        sb.append(C0000.decode(new byte[]{79, 16, 85, 68, 70, 84, 10, 83, 85, 64, 95, 87, 13, 114, 65, 93, 90, 92, 94}, "c04468", false));
        return FileSectionType$EnumUnboxingLocalUtility.m(sb, this.applicationBuild, C0000.decode(new byte[]{25}, "de3c1a32ca", false));
    }
}
