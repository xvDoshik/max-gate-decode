package local;

import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.Module;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.AbstractJni;
import com.github.unidbg.linux.android.dvm.DalvikModule;
import com.github.unidbg.linux.android.dvm.DvmClass;
import com.github.unidbg.linux.android.dvm.DvmObject;
import com.github.unidbg.linux.android.dvm.VM;
import com.github.unidbg.linux.android.dvm.array.ByteArray;
import com.github.unidbg.memory.Memory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DecodeCipher extends AbstractJni {
    private final AndroidEmulator emulator;
    private final VM vm;
    private final Module module;

    public DecodeCipher() {
        emulator = AndroidEmulatorBuilder.for64Bit().setProcessName("com.mobilex.hub").build();
        Memory memory = emulator.getMemory();
        memory.setLibraryResolver(new AndroidResolver(23));
        vm = emulator.createDalvikVM();
        vm.setJni(this);
        vm.setVerbose(false);
        DalvikModule dm = vm.loadLibrary(Path.of("../output/raw/lib/arm64-v8a/libcybqacsq.so").toFile(), false);
        module = dm.getModule();
        dm.callJNI_OnLoad(emulator);
    }

    public byte[] cipher(byte[] data, String key) {
        DvmClass c = vm.resolveClass("com/mobilex/hub/IRGXHKLL");
        String objectType = c.getClassName();
        DvmObject<?> arr = new ByteArray(vm, data);
        DvmObject<?> result = c.callStaticJniMethodObject(
                emulator,
                "nativeCipher([BLjava/lang/String;)[B",
                arr,
                key
        );
        return (byte[]) result.getValue();
    }

    public void destroy() throws IOException {
        emulator.close();
    }

    public static void main(String[] args) throws Exception {
        byte[] data = Files.readAllBytes(Path.of(args[0]));
        String key = args[1];
        Path out = Path.of(args[2]);
        DecodeCipher dc = new DecodeCipher();
        byte[] plain = dc.cipher(data, key);
        Files.write(out, plain);
        System.out.println("in=" + data.length + " out=" + plain.length);
        int n = Math.min(16, plain.length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(String.format("%02x", plain[i]));
        System.out.println("magic=" + sb);
        dc.destroy();
    }
}
