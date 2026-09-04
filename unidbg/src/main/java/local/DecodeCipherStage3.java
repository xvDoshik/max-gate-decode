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

public class DecodeCipherStage3 extends AbstractJni {
    private final AndroidEmulator emulator;
    private final VM vm;

    public DecodeCipherStage3(String soPath) {
        emulator = AndroidEmulatorBuilder.for32Bit().setProcessName("com.coresoft.safe").build();
        Memory memory = emulator.getMemory();
        memory.setLibraryResolver(new AndroidResolver(23));
        vm = emulator.createDalvikVM();
        vm.setJni(this);
        vm.setVerbose(false);
        DalvikModule dm = vm.loadLibrary(Path.of(soPath).toFile(), false);
        dm.callJNI_OnLoad(emulator);
    }

    public byte[] cipher(byte[] data, String key) {
        DvmClass c = vm.resolveClass("com/coresoft/safe/neNfPhzo");
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
        String so = args.length > 3 ? args[0] : "../output/stage3/native/libwvhqefmz.so";
        String in = args.length > 3 ? args[1] : args[0];
        String key = args.length > 3 ? args[2] : args[1];
        String out = args.length > 3 ? args[3] : args[2];
        byte[] data = Files.readAllBytes(Path.of(in));
        DecodeCipherStage3 dc = new DecodeCipherStage3(so);
        byte[] plain = dc.cipher(data, key);
        Files.write(Path.of(out), plain);
        System.out.println("in=" + data.length + " out=" + plain.length);
        int n = Math.min(16, plain.length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(String.format("%02x", plain[i]));
        System.out.println("magic=" + sb);
        dc.destroy();
    }
}
