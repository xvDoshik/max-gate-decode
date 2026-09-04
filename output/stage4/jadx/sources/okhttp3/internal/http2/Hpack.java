package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.RealBufferedSource;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Hpack {
    public static final Map NAME_TO_FIRST_INDEX;
    public static final Header[] STATIC_HEADER_TABLE;

    public final class Reader {
        public int dynamicTableByteCount;
        public int headerCount;
        public final RealBufferedSource source;
        public int maxDynamicTableByteCount = 4096;
        public final ArrayList headerList = new ArrayList();
        public Header[] dynamicTable = new Header[8];
        public int nextHeaderIndex = 7;

        public Reader(Http2Reader.ContinuationSource continuationSource) {
            this.source = new RealBufferedSource(continuationSource);
        }

        public final int evictToRecoverBytes(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.dynamicTable[length].hpackSize;
                    i -= i4;
                    this.dynamicTableByteCount -= i4;
                    this.headerCount--;
                    i3++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i2 + 1, headerArr, i2 + 1 + i3, this.headerCount);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        public final ByteString getName(int i) throws IOException {
            if (i >= 0) {
                Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                if (i <= headerArr.length - 1) {
                    return headerArr[i].name;
                }
            }
            int length = this.nextHeaderIndex + 1 + (i - Hpack.STATIC_HEADER_TABLE.length);
            if (length >= 0) {
                Header[] headerArr2 = this.dynamicTable;
                if (length < headerArr2.length) {
                    return headerArr2[length].name;
                }
            }
            throw new IOException(C0000.decode(new byte[]{124, 81, 85, 80, 6, 75, 68, 81, 15, 0, 4, 65, 20, 64, 91, 91, 67, 85, 5, 74, 6, 1, 65}, "4444c9d8ada9", 1) + (i + 1));
        }

        public final void insertIntoDynamicTable(Header header) {
            this.headerList.add(header);
            int i = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                Header[] headerArr = this.dynamicTable;
                Arrays.fill(headerArr, 0, headerArr.length, (Object) null);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            Header[] headerArr2 = this.dynamicTable;
            if (i3 > headerArr2.length) {
                Header[] headerArr3 = new Header[headerArr2.length * 2];
                System.arraycopy(headerArr2, 0, headerArr3, headerArr2.length, headerArr2.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr3;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        public final ByteString readByteString() {
            RealBufferedSource realBufferedSource = this.source;
            byte b = realBufferedSource.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            int i = b & 255;
            int i2 = 0;
            boolean z = (b & 128) == 128;
            long j = readInt(i, 127);
            if (!z) {
                return realBufferedSource.readByteString(j);
            }
            Buffer buffer = new Buffer();
            Huffman.Node node = Huffman.root;
            Huffman.Node node2 = node;
            int i3 = 0;
            for (long j2 = 0; j2 < j; j2++) {
                byte b2 = realBufferedSource.readByte();
                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                i2 = (i2 << 8) | (b2 & 255);
                i3 += 8;
                while (i3 >= 8) {
                    node2 = ((Huffman.Node[]) node2.children)[(i2 >>> (i3 - 8)) & 255];
                    if (((Huffman.Node[]) node2.children) == null) {
                        buffer.m23writeByte(node2.symbol);
                        i3 -= node2.terminalBitCount;
                        node2 = node;
                    } else {
                        i3 -= 8;
                    }
                }
            }
            while (i3 > 0) {
                Huffman.Node node3 = ((Huffman.Node[]) node2.children)[(i2 << (8 - i3)) & 255];
                Huffman.Node[] nodeArr = (Huffman.Node[]) node3.children;
                int i4 = node3.terminalBitCount;
                if (nodeArr != null || i4 > i3) {
                    break;
                }
                buffer.m23writeByte(node3.symbol);
                i3 -= i4;
                node2 = node;
            }
            return buffer.readByteString(buffer.size);
        }

        public final int readInt(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                byte b = this.source.readByte();
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                int i5 = b & 255;
                if ((b & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (b & 127) << i4;
                i4 += 7;
            }
        }
    }

    public final class Writer {
        public int dynamicTableByteCount;
        public boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public final Buffer out;
        public int smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
        public int maxDynamicTableByteCount = 4096;
        public Header[] dynamicTable = new Header[8];
        public int nextHeaderIndex = 7;

        public Writer(Buffer buffer) {
            this.out = buffer;
        }

        public final void evictToRecoverBytes(int i) {
            int i2;
            if (i > 0) {
                int length = this.dynamicTable.length - 1;
                int i3 = 0;
                while (true) {
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.dynamicTable[length].hpackSize;
                    i -= i4;
                    this.dynamicTableByteCount -= i4;
                    this.headerCount--;
                    i3++;
                    length--;
                }
                Header[] headerArr = this.dynamicTable;
                int i5 = i2 + 1;
                System.arraycopy(headerArr, i5, headerArr, i5 + i3, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i6 = this.nextHeaderIndex + 1;
                Arrays.fill(headerArr2, i6, i6 + i3, (Object) null);
                this.nextHeaderIndex += i3;
            }
        }

        public final void insertIntoDynamicTable(Header header) {
            int i = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                Header[] headerArr = this.dynamicTable;
                Arrays.fill(headerArr, 0, headerArr.length, (Object) null);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            Header[] headerArr2 = this.dynamicTable;
            if (i3 > headerArr2.length) {
                Header[] headerArr3 = new Header[headerArr2.length * 2];
                System.arraycopy(headerArr2, 0, headerArr3, headerArr2.length, headerArr2.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr3;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        public final void writeByteString(ByteString byteString) throws EOFException {
            int[] iArr = Huffman.CODES;
            int size$okio = byteString.getSize$okio();
            long j = 0;
            long j2 = 0;
            for (int i = 0; i < size$okio; i++) {
                byte bInternalGet$okio = byteString.internalGet$okio(i);
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                j2 += (long) Huffman.CODE_BIT_COUNTS[bInternalGet$okio & 255];
            }
            int i2 = (int) ((j2 + ((long) 7)) >> 3);
            int size$okio2 = byteString.getSize$okio();
            Buffer buffer = this.out;
            if (i2 >= size$okio2) {
                writeInt(byteString.getSize$okio(), 127, 0);
                byteString.write$okio(buffer, byteString.getSize$okio());
                return;
            }
            Buffer buffer2 = new Buffer();
            int[] iArr2 = Huffman.CODES;
            int size$okio3 = byteString.getSize$okio();
            int i3 = 0;
            for (int i4 = 0; i4 < size$okio3; i4++) {
                byte bInternalGet$okio2 = byteString.internalGet$okio(i4);
                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                int i5 = bInternalGet$okio2 & 255;
                int i6 = Huffman.CODES[i5];
                byte b = Huffman.CODE_BIT_COUNTS[i5];
                j = (j << b) | ((long) i6);
                i3 += b;
                while (i3 >= 8) {
                    i3 -= 8;
                    buffer2.m23writeByte((int) (j >> i3));
                }
            }
            if (i3 > 0) {
                buffer2.m23writeByte((int) ((j << (8 - i3)) | (255 >>> i3)));
            }
            ByteString byteString2 = buffer2.readByteString(buffer2.size);
            writeInt(byteString2.getSize$okio(), 127, 128);
            byteString2.write$okio(buffer, byteString2.getSize$okio());
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0069  */
        public final void writeHeaders(ArrayList arrayList) throws EOFException {
            int length;
            int length2;
            if (this.emitDynamicTableSizeUpdate) {
                int i = this.smallestHeaderTableSizeSetting;
                if (i < this.maxDynamicTableByteCount) {
                    writeInt(i, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Header header = (Header) arrayList.get(i2);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Integer num = (Integer) Hpack.NAME_TO_FIRST_INDEX.get(asciiLowercase);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (2 > length2 || length2 >= 8) {
                        length = length2;
                        length2 = -1;
                    } else {
                        Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                        if (Intrinsics.areEqual(headerArr[iIntValue].value, byteString)) {
                            length = length2;
                        } else if (Intrinsics.areEqual(headerArr[length2].value, byteString)) {
                            length2 = iIntValue + 2;
                            length = length2;
                        } else {
                            length = length2;
                            length2 = -1;
                        }
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length2 == -1) {
                    int length3 = this.dynamicTable.length;
                    for (int i3 = this.nextHeaderIndex + 1; i3 < length3; i3++) {
                        if (Intrinsics.areEqual(this.dynamicTable[i3].name, asciiLowercase)) {
                            if (Intrinsics.areEqual(this.dynamicTable[i3].value, byteString)) {
                                length2 = Hpack.STATIC_HEADER_TABLE.length + (i3 - this.nextHeaderIndex);
                                break;
                            } else if (length == -1) {
                                length = (i3 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    writeInt(length2, 127, 128);
                } else if (length == -1) {
                    this.out.m23writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else {
                    ByteString byteString2 = Header.PSEUDO_PREFIX;
                    asciiLowercase.getClass();
                    if (!asciiLowercase.rangeEquals(byteString2.getSize$okio(), byteString2) || Intrinsics.areEqual(Header.TARGET_AUTHORITY, asciiLowercase)) {
                        writeInt(length, 63, 64);
                        writeByteString(byteString);
                        insertIntoDynamicTable(header);
                    } else {
                        writeInt(length, 15, 0);
                        writeByteString(byteString);
                    }
                }
            }
        }

        public final void writeInt(int i, int i2, int i3) {
            Buffer buffer = this.out;
            if (i < i2) {
                buffer.m23writeByte(i | i3);
                return;
            }
            buffer.m23writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                buffer.m23writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            buffer.m23writeByte(i4);
        }
    }

    static {
        Header header = new Header(Header.TARGET_AUTHORITY, "");
        ByteString byteString = Header.TARGET_METHOD;
        Header header2 = new Header(byteString, C0000.decode(new byte[]{126, 113, 102}, "94262d088d9de82a", 7));
        Header header3 = new Header(byteString, C0000.decode(new byte[]{97, 46, 101, 100}, "1a60652a73", 0.0f));
        ByteString byteString2 = Header.TARGET_PATH;
        Header header4 = new Header(byteString2, C0000.decode(new byte[]{22}, "961dc69a", 7));
        Header header5 = new Header(byteString2, C0000.decode(new byte[]{22, 12, 10, 81, 86, 65, 27, 90, 21, 94, 85}, "9ed53952a3"));
        ByteString byteString3 = Header.TARGET_SCHEME;
        Header header6 = new Header(byteString3, C0000.decode(new byte[]{11, 66, 71, 70}, "c636cbcb", true));
        Header header7 = new Header(byteString3, C0000.decode(new byte[]{88, 68, 22, 67, 21}, "00b3f3650cd8c299", 6));
        ByteString byteString4 = Header.RESPONSE_STATUS;
        Header[] headerArr = {header, header2, header3, header4, header5, header6, header7, new Header(byteString4, C0000.decode(new byte[]{3, 4, 5}, "145ce8bbb6aa")), new Header(byteString4, C0000.decode(new byte[]{81, 3, 4}, "c30a3dda47e71806", 0.0f)), new Header(byteString4, C0000.decode(new byte[]{83, 81, 85}, "aac379")), new Header(byteString4, C0000.decode(new byte[]{5, 84, 82}, "6dfbd9321460", false)), new Header(byteString4, C0000.decode(new byte[]{7, 86, 4}, "3f46779c6d")), new Header(byteString4, C0000.decode(new byte[]{5, 85, 82}, "1ef97f")), new Header(byteString4, C0000.decode(new byte[]{80, 5, 3}, "e530801ac91aa8", 5)), new Header(C0000.decode(new byte[]{86, 86, 1, 86, 72, 64, 20, 86, 95, 87, 69, 70, 7, 71}, "75b3849576", 0.0f), ""), new Header(C0000.decode(new byte[]{5, 1, 81, 84, 18, 77, 20, 3, 13, 82, 14, 1, 13, 12, 85}, "db21b99fc1ae", false), C0000.decode(new byte[]{4, 30, 81, 20, 24, 19, 7, 1, 94, 8, 85, 71, 6}, "cd8d43", 0.0f)), new Header(C0000.decode(new byte[]{2, 0, 5, 92, 73, 77, 26, 95, 2, 13, 1, 76, 88, 94, 82}, "ccf99973", 0.0f), ""), new Header(C0000.decode(new byte[]{81, 83, 7, 87, 73, 22, 20, 64, 82, 92, 83, 7, 64}, "00d29b92324b32", 5), ""), new Header(C0000.decode(new byte[]{5, 5, 86, 84, 72, 76}, "df5188ef18", 0.0f), ""), new Header(C0000.decode(new byte[]{84, 82, 91, 6, 18, 64, 30, 2, 94, 94, 70, 67, 9, 15, 75, 87, 89, 93, 87, 20, 76, 92, 65, 8, 86, 89, 92}, "518ca33a1021fcf6", false), ""), new Header(C0000.decode(new byte[]{85, 84, 0}, "43e28c763f", 0.0f), ""), new Header(C0000.decode(new byte[]{0, 8, 13, 95, 71}, "ada003ad01fd", 0.0f), ""), new Header(C0000.decode(new byte[]{87, 77, 77, 92, 88, 16, 11, 74, 87, 77, 90, 94, 88}, "68947bb06931", 0.0f), ""), new Header(C0000.decode(new byte[]{0, 5, 1, 93, 85, 20, 85, 94, 88, 21, 16, 12, 15}, "cdb509616abc", 5), ""), new Header(C0000.decode(new byte[]{91, 13, 12, 23, 93, 89, 18, 27, 81, 88, 17, 72, 12, 65, 88, 65, 81, 13, 12}, "8bbc87f651b8c215", true), ""), new Header(C0000.decode(new byte[]{1, 12, 88, 71, 86, 15, 77, 25, 80, 88, 91, 90, 6, 10, 88, 84}, "bc633a945685", 0.0f), ""), new Header(C0000.decode(new byte[]{7, 87, 95, 69, 86, 10, 16, 21, 93, 80, 93, 3, 17, 89, 86, 84}, "d8113d"), ""), new Header(C0000.decode(new byte[]{80, 11, 90, 21, 86, 87, 17, 75, 85, 1, 89, 1, 17, 9}, "3d4a39ef9d7fea2e", true), ""), new Header(C0000.decode(new byte[]{80, 10, 90, 69, 0, 13, 18, 31, 95, 10, 87, 80, 17, 10, 9, 92}, "3e41ecf2", 0.0f), ""), new Header(C0000.decode(new byte[]{0, 86, 11, 71, 81, 94, 64, 27, 17, 88, 11, 84, 81}, "c9e34046"), ""), new Header(C0000.decode(new byte[]{6, 10, 91, 65, 4, 88, 65, 72, 67, 29, 67, 80}, "ee55a65e7d35", 1), ""), new Header(C0000.decode(new byte[]{80, 86, 92, 89, 11, 92}, "3932b9e1c3fd", 5), ""), new Header(C0000.decode(new byte[]{86, 5, 66, 3}, "2d6fbce7"), ""), new Header(C0000.decode(new byte[]{86, 18, 82, 83}, "3f34309ae2a46ebc", 4), ""), new Header(C0000.decode(new byte[]{0, 78, 70, 92, 90, 16}, "e6699d4933", 6), ""), new Header(C0000.decode(new byte[]{6, 25, 72, 13, 17, 4, 71}, "ca8dca4774a322"), ""), new Header(C0000.decode(new byte[]{4, 19, 88, 88}, "ba7536ef936b08", 0.0f), ""), new Header(C0000.decode(new byte[]{14, 14, 16, 16}, "facd0f59c94e40", 4), ""), new Header(C0000.decode(new byte[]{94, 81, 27, 14, 89, 21, 80, 80}, "776c8a38821a", 0.0f), ""), new Header(C0000.decode(new byte[]{93, 0, 79, 89, 89, 83, 95, 0, 8, 84, 80, 75, 17, 93, 88, 84, 83}, "4fb4676fa1", 0.0f), ""), new Header(C0000.decode(new byte[]{91, 3, 27, 90, 87, 90, 7, 30, 8, 83, 22, 85, 93}, "2e6484b3e2b65f1f"), ""), new Header(C0000.decode(new byte[]{13, 84, 26, 67, 81, 10, 1, 84}, "d2710df1c8aa0967", 0.0f), ""), new Header(C0000.decode(new byte[]{92, 85, 72, 77, 13, 85, 88, 82, 92, 85, 12, 93, 7, 21, 68, 95, 91, 80, 0}, "53e8c876", 0.0f), ""), new Header(C0000.decode(new byte[]{13, 85, 65, 68, 75, 85, 10, 93, 8, 82, 91, 85, 2}, "a420f8e9"), ""), new Header(C0000.decode(new byte[]{85, 93, 8, 89}, "94f2ce885197", false), ""), new Header(C0000.decode(new byte[]{93, 13, 0, 82, 70, 81, 94, 12}, "1bc328"), ""), new Header(C0000.decode(new byte[]{88, 81, 30, 75, 86, 88, 71, 19, 2, 16, 81, 67}, "50ff075dcb"), ""), new Header(C0000.decode(new byte[]{17, 23, 12, 77, 79, 25, 0, 16, 23, 93, 83, 90, 21, 12, 0, 84, 66, 81}, "aec564", 0.0f), ""), new Header(C0000.decode(new byte[]{71, 16, 12, 64, 28, 73, 88, 64, 66, 13, 92, 69, 91, 66, 86, 22, 10, 87, 11}, "7bc8ed956e3728"), ""), new Header(C0000.decode(new byte[]{75, 7, 10, 81, 1}, "9fd6d523b0f2", 4), ""), new Header(C0000.decode(new byte[]{66, 92, 4, 1, 65, 7, 66}, "09bd3b"), ""), new Header(C0000.decode(new byte[]{67, 81, 87, 20, 0, 74, 89}, "141fe9", false), ""), new Header(C0000.decode(new byte[]{19, 82, 65, 16, 73, 21, 0, 5, 21, 82, 71}, "a75b08ac", 2), ""), new Header(C0000.decode(new byte[]{17, 85, 75, 79, 82, 75}, "b09979482e354c", true), ""), new Header(C0000.decode(new byte[]{22, 85, 69, 29, 83, 88, 9, 95, 12, 85}, "e01007f4", 7), ""), new Header(C0000.decode(new byte[]{66, 17, 71, 90, 6, 18, 29, 17, 75, 5, 95, 22, 69, 92, 23, 18, 29, 22, 92, 7, 68, 23, 92, 71, 28}, "1e53ef0e9d", 0), ""), new Header(C0000.decode(new byte[]{70, 16, 87, 89, 16, 84, 86, 69, 25, 82, 92, 1, 89, 83, 10, 92, 84}, "2b67c23747", true), ""), new Header(C0000.decode(new byte[]{66, 71, 82, 74, 73, 87, 80, 92, 86, 67}, "7478d67987", 0.0f), ""), new Header(C0000.decode(new byte[]{79, 81, 68, 26}, "906cd23cf496", 0.0f), ""), new Header(C0000.decode(new byte[]{18, 92, 88}, "d592c55f9e59", 2), ""), new Header(C0000.decode(new byte[]{69, 68, 78, 76, 87, 68, 21, 95, 92, 87, 22, 91, 90, 7, 70, 86}, "239a61a799b29f", 0.0f), "")};
        STATIC_HEADER_TABLE = headerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i = 0; i < 61; i++) {
            if (!linkedHashMap.containsKey(headerArr[i].name)) {
                linkedHashMap.put(headerArr[i].name, Integer.valueOf(i));
            }
        }
        NAME_TO_FIRST_INDEX = Collections.unmodifiableMap(linkedHashMap);
    }

    public static void checkLowercase(ByteString byteString) throws IOException {
        int size$okio = byteString.getSize$okio();
        for (int i = 0; i < size$okio; i++) {
            byte bInternalGet$okio = byteString.internalGet$okio(i);
            if (65 <= bInternalGet$okio && bInternalGet$okio < 91) {
                throw new IOException(C0000.decode(new byte[]{97, 97, 121, 109, 120, 116, 126, 121, 104, 112, 55, 102, 119, 107, 17, 65, 83, 74, 71, 88, 95, 70, 82, 21, 8, 85, 84, 95, 94, 65, 91, 92, 83, 13, 17, 88, 94, 77, 0, 80, 24, 90, 80, 64, 83, 25, 89, 86, 92, 80, 13, 21}, "1369771575e489", 0.0f).concat(byteString.utf8()));
            }
        }
    }
}
