package com.mobilex.hub;

public class IRGXHKLL {
    static {
        System.load("/Users/xv/pin2/max-gate-apk/output/raw/lib/arm64-v8a/libcybqacsq.so");
    }

    public static native byte[] nativeCipher(byte[] bArr, String str);

    public static void main(String[] args) throws Exception {
        byte[] data = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(args[0]));
        String key = args[1];
        byte[] out = nativeCipher(data, key);
        java.nio.file.Files.write(java.nio.file.Paths.get(args[2]), out);
        System.out.println("in=" + data.length + " out=" + out.length + " magic=" + bytesToHex(out, 0, 8));
    }

    private static String bytesToHex(byte[] b, int off, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = off; i < off + n && i < b.length; i++) {
            sb.append(String.format("%02x", b[i]));
        }
        return sb.toString();
    }
}
