package okhttp3.internal.cache;

import androidx.work.impl.OperationImpl;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.CacheControl;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ResponseBody$Companion$asResponseBody$1;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealInterceptorChain;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CacheInterceptor implements Interceptor {

    public final class Companion {
        public static final Response access$stripBody(Response response) {
            if ((response != null ? response.body : null) == null) {
                return response;
            }
            Response.Builder builderNewBuilder = response.newBuilder();
            builderNewBuilder.body = null;
            return builderNewBuilder.build();
        }

        public static boolean isEndToEnd(String str) {
            return (C0000.decode(new byte[]{112, 92, 15, 95, 83, 6, 71, 90, 14, 95}, "33a16e", 0.0f).equalsIgnoreCase(str) || C0000.decode(new byte[]{114, 87, 83, 65, 27, 113, 95, 90, 66, 1}, "926160334dda", 2).equalsIgnoreCase(str) || C0000.decode(new byte[]{49, 22, 92, 27, 24, 29, 32, 17, 71, 11, 4, 94, 21, 13, 80, 2, 21, 85}, "ad3ca0", 0).equalsIgnoreCase(str) || C0000.decode(new byte[]{102, 75, 95, 26, 65, 27, 119, 76, 68, 10, 87, 68, 95, 67, 81, 22, 81, 89, 88}, "690b86").equalsIgnoreCase(str) || C0000.decode(new byte[]{98, 115}, "66e1d6efad", 0.0f).equalsIgnoreCase(str) || C0000.decode(new byte[]{50, 74, 86, 13, 94, 4, 19, 65}, "f87d2aa2c8").equalsIgnoreCase(str) || C0000.decode(new byte[]{96, 65, 0, 11, 68, 86, 81, 17, 25, 118, 15, 6, 88, 84, 93, 13, 83}, "43ae704c").equalsIgnoreCase(str) || C0000.decode(new byte[]{54, 17, 87, 74, 4, 6, 92}, "ca08eb9e287b", 0).equalsIgnoreCase(str)) ? false : true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0394  */
    /* JADX WARN: Code duplicated, block: B:118:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:120:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:122:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:125:0x0420  */
    /* JADX WARN: Code duplicated, block: B:145:0x0499  */
    /* JADX WARN: Code duplicated, block: B:158:0x050d  */
    /* JADX WARN: Code duplicated, block: B:160:0x0511  */
    /* JADX WARN: Code duplicated, block: B:177:0x017a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x00ba A[EDGE_INSN: B:180:0x00ba->B:26:0x00ba BREAK  A[LOOP:2: B:20:0x008c->B:24:0x00af], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:187:0x0492 A[EDGE_INSN: B:187:0x0492->B:143:0x0492 BREAK  A[LOOP:5: B:123:0x03dc->B:142:0x048e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x0087  */
    /* JADX WARN: Code duplicated, block: B:21:0x008e  */
    /* JADX WARN: Code duplicated, block: B:24:0x00af A[LOOP:2: B:20:0x008c->B:24:0x00af, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x0158  */
    /* JADX WARN: Code duplicated, block: B:58:0x0178  */
    /* JADX WARN: Code duplicated, block: B:60:0x017f  */
    /* JADX WARN: Code duplicated, block: B:62:0x019d  */
    /* JADX WARN: Code duplicated, block: B:63:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:66:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:68:0x01da  */
    /* JADX WARN: Code duplicated, block: B:69:0x01df  */
    /* JADX WARN: Code duplicated, block: B:71:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:72:0x0201  */
    /* JADX WARN: Code duplicated, block: B:74:0x021c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0220  */
    /* JADX WARN: Code duplicated, block: B:77:0x023a  */
    /* JADX WARN: Code duplicated, block: B:78:0x023e  */
    /* JADX WARN: Code duplicated, block: B:80:0x025a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0263  */
    /* JADX WARN: Code duplicated, block: B:83:0x0280  */
    /* JADX WARN: Code duplicated, block: B:84:0x0287  */
    /* JADX WARN: Code duplicated, block: B:86:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:87:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:89:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:90:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:92:0x02e3  */
    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) {
        OperationImpl operationImpl;
        OperationImpl operationImpl2;
        Request request;
        Response response;
        String strDecode;
        Response responseProceed;
        String strDecode2;
        ResponseBody responseBody;
        Headers headers;
        Headers headers2;
        ArrayList arrayList;
        int size;
        int i;
        String strDecode3;
        String strDecode4;
        String strDecode5;
        int size2;
        int i2;
        String strName;
        String strName2;
        String strValue;
        int i3;
        int length;
        int length2;
        OperationImpl operationImpl3;
        String string;
        String string2;
        System.currentTimeMillis();
        Request request2 = realInterceptorChain.request;
        OperationImpl operationImpl4 = new OperationImpl(request2, null, 7);
        if (request2 != null) {
            CacheControl cacheControl = (CacheControl) request2.lazyCacheControl;
            if (cacheControl == null) {
                int i4 = CacheControl.$r8$clinit;
                Headers headers3 = (Headers) request2.headers;
                int size3 = headers3.size();
                String str = null;
                int i5 = 0;
                boolean z = true;
                boolean z2 = false;
                boolean z3 = false;
                int nonNegativeInt = -1;
                int nonNegativeInt2 = -1;
                boolean z4 = false;
                boolean z5 = false;
                boolean z6 = false;
                int nonNegativeInt3 = -1;
                int nonNegativeInt4 = -1;
                boolean z7 = false;
                boolean z8 = false;
                boolean z9 = false;
                while (i5 < size3) {
                    String strName3 = headers3.name(i5);
                    String strValue2 = headers3.value(i5);
                    if (StringsKt__StringsJVMKt.equals(strName3, C0000.decode(new byte[]{112, 3, 86, 81, 86, 25, 122, 11, 92, 68, 71, 10, 13}, "3b59349d205ea4", 3))) {
                        if (str == null) {
                            str = strValue2;
                        }
                        i3 = 0;
                        while (i3 < strValue2.length()) {
                            length = strValue2.length();
                            length2 = i3;
                            while (true) {
                                if (length2 < length) {
                                    operationImpl3 = operationImpl4;
                                    length2 = strValue2.length();
                                    break;
                                }
                                operationImpl3 = operationImpl4;
                                if (StringsKt.contains$default(C0000.decode(new byte[]{89, 29, 90}, "d1a3b9dda3feeb2f"), strValue2.charAt(length2))) {
                                    break;
                                }
                                length2++;
                                operationImpl4 = operationImpl3;
                            }
                            string = StringsKt.trim(strValue2.substring(i3, length2)).toString();
                            if (length2 != strValue2.length() || strValue2.charAt(length2) == ',' || strValue2.charAt(length2) == ';') {
                                i3 = length2 + 1;
                                string2 = null;
                            } else {
                                int length3 = length2 + 1;
                                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                                int length4 = strValue2.length();
                                while (true) {
                                    if (length3 >= length4) {
                                        length3 = strValue2.length();
                                        break;
                                    }
                                    char cCharAt = strValue2.charAt(length3);
                                    if (cCharAt != ' ' && cCharAt != '\t') {
                                        break;
                                    }
                                    length3++;
                                }
                                if (length3 >= strValue2.length() || strValue2.charAt(length3) != '\"') {
                                    int length5 = strValue2.length();
                                    int length6 = length3;
                                    while (true) {
                                        if (length6 >= length5) {
                                            length6 = strValue2.length();
                                            break;
                                        }
                                        int i6 = length5;
                                        if (StringsKt.contains$default(C0000.decode(new byte[]{72, 89}, "db046f", true), strValue2.charAt(length6))) {
                                            break;
                                        }
                                        length6++;
                                        length5 = i6;
                                    }
                                    string2 = StringsKt.trim(strValue2.substring(length3, length6)).toString();
                                    i3 = length6;
                                } else {
                                    int i7 = length3 + 1;
                                    int iIndexOf$default = StringsKt.indexOf$default((CharSequence) strValue2, '\"', i7, 4);
                                    string2 = strValue2.substring(i7, iIndexOf$default);
                                    i3 = iIndexOf$default + 1;
                                }
                            }
                            if (C0000.decode(new byte[]{92, 14, 21, 87, 82, 1, 93, 82}, "2a843b572fd03821", 0.0f).equalsIgnoreCase(string)) {
                                z2 = true;
                            } else if (C0000.decode(new byte[]{87, 93, 25, 16, 70, 94, 74, 1}, "924c218d24", 2).equalsIgnoreCase(string)) {
                                z3 = true;
                            } else if (C0000.decode(new byte[]{93, 82, 76, 76, 81, 94, 3}, "034a09f3", 0.0f).equalsIgnoreCase(string)) {
                                nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                            } else if (C0000.decode(new byte[]{22, 79, 8, 80, 30, 3, 5, 85}, "ebe1fbb0e7b24138").equalsIgnoreCase(string)) {
                                nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                            } else if (C0000.decode(new byte[]{64, 17, 89, 67, 4, 66, 85}, "0c05e6", 0).equalsIgnoreCase(string)) {
                                z4 = true;
                            } else if (C0000.decode(new byte[]{20, 70, 7, 9, 90, 84}, "d3ee3769e7b7b7a6", false).equalsIgnoreCase(string)) {
                                z5 = true;
                            } else if (C0000.decode(new byte[]{89, 76, 23, 64, 75, 75, 4, 79, 85, 85, 13, 80, 7, 77, 4}, "49d4f9a9").equalsIgnoreCase(string)) {
                                z6 = true;
                            } else if (C0000.decode(new byte[]{91, 85, 78, 21, 74, 17, 5, 15, 83}, "64689edc", false).equalsIgnoreCase(string)) {
                                nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                            } else if (C0000.decode(new byte[]{11, 11, 95, 76, 85, 17, 87, 22, 93}, "fb1a3c2e5b", true).equalsIgnoreCase(string)) {
                                nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                            } else if (C0000.decode(new byte[]{10, 11, 94, 26, 31, 15, 84, 76, 1, 4, 6, 13, 87, 7}, "ee2c2f2abe").equalsIgnoreCase(string)) {
                                z7 = true;
                            } else if (C0000.decode(new byte[]{87, 14, 20, 23, 67, 81, 88, 23, 95, 90, 65, 92}, "9a9c106d95315253").equalsIgnoreCase(string)) {
                                z8 = true;
                            } else if (C0000.decode(new byte[]{11, 93, 94, 22, 65, 82, 0, 92, 86}, "b03c53", 0.0f).equalsIgnoreCase(string)) {
                                z9 = true;
                            }
                            operationImpl4 = operationImpl3;
                        }
                        i5++;
                        operationImpl4 = operationImpl4;
                    } else {
                        if (StringsKt__StringsJVMKt.equals(strName3, C0000.decode(new byte[]{99, 65, 86, 86, 85, 83}, "3371821a42a2", false))) {
                        }
                        i5++;
                        operationImpl4 = operationImpl4;
                    }
                    z = false;
                    i3 = 0;
                    while (i3 < strValue2.length()) {
                        length = strValue2.length();
                        length2 = i3;
                        while (true) {
                            if (length2 < length) {
                                operationImpl3 = operationImpl4;
                                length2 = strValue2.length();
                                break;
                            }
                            operationImpl3 = operationImpl4;
                            if (StringsKt.contains$default(C0000.decode(new byte[]{89, 29, 90}, "d1a3b9dda3feeb2f"), strValue2.charAt(length2))) {
                                break;
                                break;
                            }
                            length2++;
                            operationImpl4 = operationImpl3;
                        }
                        string = StringsKt.trim(strValue2.substring(i3, length2)).toString();
                        if (length2 != strValue2.length()) {
                            i3 = length2 + 1;
                            string2 = null;
                        } else {
                            i3 = length2 + 1;
                            string2 = null;
                        }
                        if (C0000.decode(new byte[]{92, 14, 21, 87, 82, 1, 93, 82}, "2a843b572fd03821", 0.0f).equalsIgnoreCase(string)) {
                            z2 = true;
                        } else if (C0000.decode(new byte[]{87, 93, 25, 16, 70, 94, 74, 1}, "924c218d24", 2).equalsIgnoreCase(string)) {
                            z3 = true;
                        } else if (C0000.decode(new byte[]{93, 82, 76, 76, 81, 94, 3}, "034a09f3", 0.0f).equalsIgnoreCase(string)) {
                            nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                        } else if (C0000.decode(new byte[]{22, 79, 8, 80, 30, 3, 5, 85}, "ebe1fbb0e7b24138").equalsIgnoreCase(string)) {
                            nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                        } else if (C0000.decode(new byte[]{64, 17, 89, 67, 4, 66, 85}, "0c05e6", 0).equalsIgnoreCase(string)) {
                            z4 = true;
                        } else if (C0000.decode(new byte[]{20, 70, 7, 9, 90, 84}, "d3ee3769e7b7b7a6", false).equalsIgnoreCase(string)) {
                            z5 = true;
                        } else if (C0000.decode(new byte[]{89, 76, 23, 64, 75, 75, 4, 79, 85, 85, 13, 80, 7, 77, 4}, "49d4f9a9").equalsIgnoreCase(string)) {
                            z6 = true;
                        } else if (C0000.decode(new byte[]{91, 85, 78, 21, 74, 17, 5, 15, 83}, "64689edc", false).equalsIgnoreCase(string)) {
                            nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                        } else if (C0000.decode(new byte[]{11, 11, 95, 76, 85, 17, 87, 22, 93}, "fb1a3c2e5b", true).equalsIgnoreCase(string)) {
                            nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                        } else if (C0000.decode(new byte[]{10, 11, 94, 26, 31, 15, 84, 76, 1, 4, 6, 13, 87, 7}, "ee2c2f2abe").equalsIgnoreCase(string)) {
                            z7 = true;
                        } else if (C0000.decode(new byte[]{87, 14, 20, 23, 67, 81, 88, 23, 95, 90, 65, 92}, "9a9c106d95315253").equalsIgnoreCase(string)) {
                            z8 = true;
                        } else if (C0000.decode(new byte[]{11, 93, 94, 22, 65, 82, 0, 92, 86}, "b03c53", 0.0f).equalsIgnoreCase(string)) {
                            z9 = true;
                        }
                        operationImpl4 = operationImpl3;
                    }
                    i5++;
                    operationImpl4 = operationImpl4;
                }
                operationImpl = operationImpl4;
                CacheControl cacheControl2 = new CacheControl(z2, z3, nonNegativeInt, nonNegativeInt2, z4, z5, z6, nonNegativeInt3, nonNegativeInt4, z7, z8, z9, !z ? null : str);
                request2.lazyCacheControl = cacheControl2;
                cacheControl = cacheControl2;
            } else {
                operationImpl = operationImpl4;
            }
            if (cacheControl.onlyIfCached) {
                operationImpl2 = new OperationImpl(null, null, 7);
            }
            request = (Request) operationImpl2.mOperationState;
            response = (Response) operationImpl2.mOperationFuture;
            if (request != null && response == null) {
                ArrayList arrayList2 = new ArrayList(20);
                ResponseBody$Companion$asResponseBody$1 responseBody$Companion$asResponseBody$1 = Util.EMPTY_RESPONSE;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (request2 != null) {
                    return new Response(request2, Protocol.HTTP_1_1, C0000.decode(new byte[]{97, 92, 66, 5, 16, 81, 66, 5, 10, 82, 7, 84, 81, 18, 99, 1, 21, 77, 84, 16, 23, 19, 77, 87, 90, 94, 72, 73, 13, 94, 28, 0, 2, 80, 13, 93, 80, 27}, "421dd81cc3e8", 5), 504, null, new Headers((String[]) arrayList2.toArray(new String[0])), responseBody$Companion$asResponseBody$1, null, null, null, -1L, jCurrentTimeMillis, null);
                }
                throw new IllegalStateException(C0000.decode(new byte[]{65, 93, 69, 69, 93, 22, 16, 17, 94, 5, 23, 93, 70, 84, 88}, "38408ed1c873", 3));
            }
            strDecode = C0000.decode(new byte[]{7, 80, 85, 80, 92, 101, 85, 66, 20, 94, 88, 75, 92}, "d1689701", false);
            if (request == null) {
                Response.Builder builderNewBuilder = response.newBuilder();
                Response responseAccess$stripBody = Companion.access$stripBody(response);
                Response.Builder.checkSupportResponse(strDecode, responseAccess$stripBody);
                builderNewBuilder.cacheResponse = responseAccess$stripBody;
                return builderNewBuilder.build();
            }
            responseProceed = realInterceptorChain.proceed(request);
            strDecode2 = C0000.decode(new byte[]{90, 83, 17, 18, 88, 23, 92, 98, 92, 67, 68, 12, 90, 69, 0}, "46ee7e70904c", 3);
            if (response != null) {
                if (responseProceed.code == 304) {
                    Response.Builder builderNewBuilder2 = response.newBuilder();
                    headers = response.headers;
                    headers2 = responseProceed.headers;
                    arrayList = new ArrayList(20);
                    size = headers.size();
                    i = 0;
                    while (true) {
                        strDecode3 = C0000.decode(new byte[]{116, 9, 91, 65, 93, 93, 65, 31, 99, 31, 69, 80}, "7f558352", true);
                        strDecode4 = C0000.decode(new byte[]{115, 14, 94, 64, 82, 94, 68, 30, 119, 89, 83, 14, 84, 93, 89, 87}, "0a04700327");
                        strDecode5 = C0000.decode(new byte[]{119, 88, 8, 71, 92, 95, 16, 31, 126, 85, 10, 2, 64, 95}, "47f391d220de", 5);
                        if (i < size) {
                            break;
                        }
                        strName2 = headers.name(i);
                        strValue = headers.value(i);
                        if ((C0000.decode(new byte[]{96, 81, 71, 88, 8, 86, 80}, "7056a87953d1c2", false).equalsIgnoreCase(strName2) || !strValue.startsWith(C0000.decode(new byte[]{2}, "3950f4ca31a256f4", 6))) && (strDecode5.equalsIgnoreCase(strName2) || strDecode4.equalsIgnoreCase(strName2) || strDecode3.equalsIgnoreCase(strName2) || !Companion.isEndToEnd(strName2) || headers2.get(strName2) == null)) {
                            arrayList.add(strName2);
                            arrayList.add(StringsKt.trim(strValue).toString());
                        }
                        i++;
                    }
                    size2 = headers2.size();
                    for (i2 = 0; i2 < size2; i2++) {
                        strName = headers2.name(i2);
                        if (strDecode5.equalsIgnoreCase(strName) && !strDecode4.equalsIgnoreCase(strName) && !strDecode3.equalsIgnoreCase(strName) && Companion.isEndToEnd(strName)) {
                            String strValue3 = headers2.value(i2);
                            arrayList.add(strName);
                            arrayList.add(StringsKt.trim(strValue3).toString());
                        }
                    }
                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                    ConnectionPool connectionPool = new ConnectionPool(23);
                    ((ArrayList) connectionPool.delegate).addAll(Arrays.asList(strArr));
                    builderNewBuilder2.headers = connectionPool;
                    builderNewBuilder2.sentRequestAtMillis = responseProceed.sentRequestAtMillis;
                    builderNewBuilder2.receivedResponseAtMillis = responseProceed.receivedResponseAtMillis;
                    Response responseAccess$stripBody2 = Companion.access$stripBody(response);
                    Response.Builder.checkSupportResponse(strDecode, responseAccess$stripBody2);
                    builderNewBuilder2.cacheResponse = responseAccess$stripBody2;
                    Response responseAccess$stripBody3 = Companion.access$stripBody(responseProceed);
                    Response.Builder.checkSupportResponse(strDecode2, responseAccess$stripBody3);
                    builderNewBuilder2.networkResponse = responseAccess$stripBody3;
                    builderNewBuilder2.build();
                    responseProceed.body.close();
                    throw null;
                }
                responseBody = response.body;
                if (responseBody != null) {
                    Util.closeQuietly(responseBody);
                }
            }
            Response.Builder builderNewBuilder3 = responseProceed.newBuilder();
            Response responseAccess$stripBody4 = Companion.access$stripBody(response);
            Response.Builder.checkSupportResponse(strDecode, responseAccess$stripBody4);
            builderNewBuilder3.cacheResponse = responseAccess$stripBody4;
            Response responseAccess$stripBody5 = Companion.access$stripBody(responseProceed);
            Response.Builder.checkSupportResponse(strDecode2, responseAccess$stripBody5);
            builderNewBuilder3.networkResponse = responseAccess$stripBody5;
            return builderNewBuilder3.build();
        }
        operationImpl = operationImpl4;
        operationImpl2 = operationImpl;
        request = (Request) operationImpl2.mOperationState;
        response = (Response) operationImpl2.mOperationFuture;
        if (request != null) {
        }
        strDecode = C0000.decode(new byte[]{7, 80, 85, 80, 92, 101, 85, 66, 20, 94, 88, 75, 92}, "d1689701", false);
        if (request == null) {
            Response.Builder builderNewBuilder4 = response.newBuilder();
            Response responseAccess$stripBody6 = Companion.access$stripBody(response);
            Response.Builder.checkSupportResponse(strDecode, responseAccess$stripBody6);
            builderNewBuilder4.cacheResponse = responseAccess$stripBody6;
            return builderNewBuilder4.build();
        }
        responseProceed = realInterceptorChain.proceed(request);
        strDecode2 = C0000.decode(new byte[]{90, 83, 17, 18, 88, 23, 92, 98, 92, 67, 68, 12, 90, 69, 0}, "46ee7e70904c", 3);
        if (response != null) {
            if (responseProceed.code == 304) {
                Response.Builder builderNewBuilder5 = response.newBuilder();
                headers = response.headers;
                headers2 = responseProceed.headers;
                arrayList = new ArrayList(20);
                size = headers.size();
                i = 0;
                while (true) {
                    strDecode3 = C0000.decode(new byte[]{116, 9, 91, 65, 93, 93, 65, 31, 99, 31, 69, 80}, "7f558352", true);
                    strDecode4 = C0000.decode(new byte[]{115, 14, 94, 64, 82, 94, 68, 30, 119, 89, 83, 14, 84, 93, 89, 87}, "0a04700327");
                    strDecode5 = C0000.decode(new byte[]{119, 88, 8, 71, 92, 95, 16, 31, 126, 85, 10, 2, 64, 95}, "47f391d220de", 5);
                    if (i < size) {
                        break;
                        break;
                    }
                    strName2 = headers.name(i);
                    strValue = headers.value(i);
                    if (C0000.decode(new byte[]{96, 81, 71, 88, 8, 86, 80}, "7056a87953d1c2", false).equalsIgnoreCase(strName2)) {
                        arrayList.add(strName2);
                        arrayList.add(StringsKt.trim(strValue).toString());
                    } else {
                        arrayList.add(strName2);
                        arrayList.add(StringsKt.trim(strValue).toString());
                    }
                    i++;
                }
                size2 = headers2.size();
                while (i2 < size2) {
                    strName = headers2.name(i2);
                    if (strDecode5.equalsIgnoreCase(strName)) {
                    }
                }
                String[] strArr2 = (String[]) arrayList.toArray(new String[0]);
                ConnectionPool connectionPool2 = new ConnectionPool(23);
                ((ArrayList) connectionPool2.delegate).addAll(Arrays.asList(strArr2));
                builderNewBuilder5.headers = connectionPool2;
                builderNewBuilder5.sentRequestAtMillis = responseProceed.sentRequestAtMillis;
                builderNewBuilder5.receivedResponseAtMillis = responseProceed.receivedResponseAtMillis;
                Response responseAccess$stripBody7 = Companion.access$stripBody(response);
                Response.Builder.checkSupportResponse(strDecode, responseAccess$stripBody7);
                builderNewBuilder5.cacheResponse = responseAccess$stripBody7;
                Response responseAccess$stripBody8 = Companion.access$stripBody(responseProceed);
                Response.Builder.checkSupportResponse(strDecode2, responseAccess$stripBody8);
                builderNewBuilder5.networkResponse = responseAccess$stripBody8;
                builderNewBuilder5.build();
                responseProceed.body.close();
                throw null;
            }
            responseBody = response.body;
            if (responseBody != null) {
                Util.closeQuietly(responseBody);
            }
        }
        Response.Builder builderNewBuilder6 = responseProceed.newBuilder();
        Response responseAccess$stripBody9 = Companion.access$stripBody(response);
        Response.Builder.checkSupportResponse(strDecode, responseAccess$stripBody9);
        builderNewBuilder6.cacheResponse = responseAccess$stripBody9;
        Response responseAccess$stripBody10 = Companion.access$stripBody(responseProceed);
        Response.Builder.checkSupportResponse(strDecode2, responseAccess$stripBody10);
        builderNewBuilder6.networkResponse = responseAccess$stripBody10;
        return builderNewBuilder6.build();
    }
}
