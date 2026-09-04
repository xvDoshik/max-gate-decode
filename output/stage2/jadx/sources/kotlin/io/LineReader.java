package kotlin.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lkotlin/io/LineReader;", "", "<init>", "()V", "BUFFER_SIZE", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "bytes", "", "chars", "", "byteBuf", "Ljava/nio/ByteBuffer;", "charBuf", "Ljava/nio/CharBuffer;", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "decode", "endOfInput", "compactBytes", "decodeEndOfInput", "nBytes", "nChars", "updateCharset", "", "resetAll", "trimStringBuilder", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LineReader {
    private static final int BUFFER_SIZE = 32;
    public static final LineReader INSTANCE = new LineReader();
    private static final ByteBuffer byteBuf;
    private static final byte[] bytes;
    private static final CharBuffer charBuf;
    private static final char[] chars;
    private static CharsetDecoder decoder;
    private static boolean directEOL;
    private static final StringBuilder sb;

    static {
        byte[] bArr = new byte[32];
        bytes = bArr;
        char[] cArr = new char[32];
        chars = cArr;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        String strDecode = C0000.decode(new byte[]{17, 64, 82, 20, 76, 22, 28, 77, 77}, "f23dd82cd8", false);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, strDecode);
        byteBuf = byteBufferWrap;
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr);
        Intrinsics.checkNotNullExpressionValue(charBufferWrap, strDecode);
        charBuf = charBufferWrap;
        sb = new StringBuilder();
    }

    private final int decode(boolean endOfInput) throws CharacterCodingException {
        while (true) {
            CharsetDecoder charsetDecoder = decoder;
            if (charsetDecoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException(C0000.decode(new byte[]{82, 0, 0, 91, 1, 6, 68}, "6ec4ec", 0.0f));
                charsetDecoder = null;
            }
            ByteBuffer byteBuffer = byteBuf;
            CharBuffer charBuffer = charBuf;
            CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, charBuffer, endOfInput);
            Intrinsics.checkNotNullExpressionValue(coderResultDecode, C0000.decode(new byte[]{81, 83, 7, 92, 0, 83, 16, 29, 72, 24, 28}, "56d3d683f6", false));
            if (coderResultDecode.isError()) {
                resetAll();
                coderResultDecode.throwException();
            }
            int iPosition = charBuffer.position();
            if (!coderResultDecode.isOverflow()) {
                return iPosition;
            }
            StringBuilder sb2 = sb;
            char[] cArr = chars;
            int i = iPosition - 1;
            sb2.append(cArr, 0, i);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i]);
        }
    }

    private final int decodeEndOfInput(int nBytes, int nChars) throws CharacterCodingException {
        ByteBuffer byteBuffer = byteBuf;
        byteBuffer.limit(nBytes);
        charBuf.position(nChars);
        int iDecode = decode(true);
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException(C0000.decode(new byte[]{81, 80, 0, 9, 84, 93, 20}, "55cf08f3", false));
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuffer.position(0);
        return iDecode;
    }

    private final void resetAll() {
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException(C0000.decode(new byte[]{1, 80, 5, 14, 86, 85, 66}, "e5fa20004558"));
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        sb.setLength(0);
    }

    private final void updateCharset(Charset charset) {
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, C0000.decode(new byte[]{11, 6, 79, 117, 86, 90, 10, 7, 93, 67, 27, 23, 75, 77, 17}, "ec8139"));
        decoder = charsetDecoderNewDecoder;
        ByteBuffer byteBuffer = byteBuf;
        byteBuffer.clear();
        CharBuffer charBuffer = charBuf;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException(C0000.decode(new byte[]{87, 4, 87, 93, 7, 0, 67}, "3a42ce1c17", true));
            charsetDecoder = null;
        }
        boolean z = false;
        charsetDecoder.decode(byteBuffer, charBuffer, false);
        if (charBuffer.position() == 1 && charBuffer.get(0) == '\n') {
            z = true;
        }
        directEOL = z;
        resetAll();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0050 A[Catch: all -> 0x0104, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0032, B:7:0x0046, B:11:0x0056, B:13:0x0061, B:19:0x0071, B:33:0x00a6, B:35:0x00ae, B:37:0x00b2, B:39:0x00ba, B:41:0x00be, B:43:0x00c9, B:46:0x00d2, B:48:0x00f6, B:49:0x00f9, B:20:0x0076, B:23:0x0081, B:27:0x0088, B:29:0x0098, B:31:0x00a0, B:52:0x00fe, B:9:0x0050), top: B:56:0x0001 }] */
    public final synchronized String readLine(InputStream inputStream, Charset charset) {
        int iDecodeEndOfInput;
        Intrinsics.checkNotNullParameter(inputStream, C0000.decode(new byte[]{89, 15, 19, 64, 23, 107, 66, 71, 82, 83, 93}, "0ac5c86572", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{84, 81, 86, 23, 68, 4, 22}, "797e7ab2", true));
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            updateCharset(charset);
        } else {
            if (charsetDecoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException(C0000.decode(new byte[]{85, 0, 86, 93, 92, 84, 68}, "1e528161", 0.0f));
                charsetDecoder = null;
            }
            if (!Intrinsics.areEqual(charsetDecoder.charset(), charset)) {
                updateCharset(charset);
            }
        }
        int iCompactBytes = 0;
        int iDecode = 0;
        while (true) {
            int i = inputStream.read();
            if (i == -1) {
                if (sb.length() != 0 || iCompactBytes != 0 || iDecode != 0) {
                    iDecodeEndOfInput = decodeEndOfInput(iCompactBytes, iDecode);
                    break;
                }
                return null;
            }
            int i2 = iCompactBytes + 1;
            bytes[iCompactBytes] = (byte) i;
            if (i == 10 || i2 == 32 || !directEOL) {
                ByteBuffer byteBuffer = byteBuf;
                byteBuffer.limit(i2);
                charBuf.position(iDecode);
                iDecode = decode(false);
                if (iDecode > 0 && chars[iDecode - 1] == '\n') {
                    byteBuffer.position(0);
                    iDecodeEndOfInput = iDecode;
                    break;
                }
                iCompactBytes = compactBytes();
            } else {
                iCompactBytes = i2;
            }
        }
        if (iDecodeEndOfInput > 0) {
            char[] cArr = chars;
            if (cArr[iDecodeEndOfInput - 1] == '\n') {
                int i3 = iDecodeEndOfInput - 1;
                iDecodeEndOfInput = (i3 <= 0 || cArr[iDecodeEndOfInput + (-2)] != '\r') ? i3 : iDecodeEndOfInput - 2;
            }
        }
        StringBuilder sb2 = sb;
        if (sb2.length() == 0) {
            return new String(chars, 0, iDecodeEndOfInput);
        }
        sb2.append(chars, 0, iDecodeEndOfInput);
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{18, 11, 55, 16, 64, 11, 90, 5, 78, 74, 74, 74, 27}, "fddd2b4b", 0.0f));
        if (sb2.length() > 32) {
            trimStringBuilder();
        }
        sb2.setLength(0);
        return string;
    }

    private LineReader() {
    }

    private final int compactBytes() {
        ByteBuffer byteBuffer = byteBuf;
        byteBuffer.compact();
        int iPosition = byteBuffer.position();
        byteBuffer.position(0);
        return iPosition;
    }

    private final void trimStringBuilder() {
        StringBuilder sb2 = sb;
        sb2.setLength(32);
        sb2.trimToSize();
    }
}
