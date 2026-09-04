package kotlin.io.path;

import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0016\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0007\u001a\u0014\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0007\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0007\u001a\u001f\u0010\u001c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0087\b\u001a.\u0010\u001c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"H\u0087\b¢\u0006\u0002\u0010#\u001a&\u0010$\u001a\u00020\u001f*\u00020\u00022\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010&\u001a&\u0010'\u001a\u00020\u001f*\u00020\u00022\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010&\u001a&\u0010(\u001a\u00020\u001f*\u00020\u00022\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010&\u001a&\u0010)\u001a\u00020\u001f*\u00020\u00022\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010&\u001a\r\u0010*\u001a\u00020\u001f*\u00020\u0002H\u0087\b\u001a\r\u0010+\u001a\u00020\u001f*\u00020\u0002H\u0087\b\u001a\r\u0010,\u001a\u00020\u001f*\u00020\u0002H\u0087\b\u001a\r\u0010-\u001a\u00020\u001f*\u00020\u0002H\u0087\b\u001a\r\u0010.\u001a\u00020\u001f*\u00020\u0002H\u0087\b\u001a\u0015\u0010/\u001a\u00020\u001f*\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0087\b\u001a\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u000202*\u00020\u00022\b\b\u0002\u00103\u001a\u00020\u0001H\u0007\u001a?\u00104\u001a\u0002H5\"\u0004\b\u0000\u00105*\u00020\u00022\b\b\u0002\u00103\u001a\u00020\u00012\u0018\u00106\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000208\u0012\u0004\u0012\u0002H507H\u0087\bø\u0001\u0000¢\u0006\u0002\u00109\u001a.\u0010:\u001a\u00020;*\u00020\u00022\b\b\u0002\u00103\u001a\u00020\u00012\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020;07H\u0087\bø\u0001\u0000\u001a\r\u0010=\u001a\u00020>*\u00020\u0002H\u0087\b\u001a\r\u0010?\u001a\u00020;*\u00020\u0002H\u0087\b\u001a\r\u0010@\u001a\u00020\u001f*\u00020\u0002H\u0087\b\u001a.\u0010A\u001a\u00020\u0002*\u00020\u00022\u001a\u0010B\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\b¢\u0006\u0002\u0010D\u001a.\u0010E\u001a\u00020\u0002*\u00020\u00022\u001a\u0010B\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\b¢\u0006\u0002\u0010D\u001a-\u0010F\u001a\u00020\u0002*\u00020\u00022\u001a\u0010B\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0007¢\u0006\u0002\u0010D\u001a.\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"H\u0087\b¢\u0006\u0002\u0010#\u001a\u001f\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0087\b\u001a\r\u0010H\u001a\u00020I*\u00020\u0002H\u0087\b\u001a0\u0010J\u001a\u0004\u0018\u00010K*\u00020\u00022\u0006\u0010L\u001a\u00020\u00012\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010M\u001a8\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00012\b\u0010O\u001a\u0004\u0018\u00010K2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010P\u001a4\u0010Q\u001a\u0004\u0018\u0001HR\"\n\b\u0000\u0010R\u0018\u0001*\u00020S*\u00020\u00022\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010T\u001a2\u0010U\u001a\u0002HR\"\n\b\u0000\u0010R\u0018\u0001*\u00020S*\u00020\u00022\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010T\u001a\u001c\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00022\n\u0010Y\u001a\u0006\u0012\u0002\b\u00030ZH\u0001\u001a2\u0010[\u001a\u0002H\\\"\n\b\u0000\u0010\\\u0018\u0001*\u00020]*\u00020\u00022\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010^\u001a<\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010K0_*\u00020\u00022\u0006\u0010B\u001a\u00020\u00012\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010`\u001a&\u0010a\u001a\u00020b*\u00020\u00022\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010c\u001a\u0015\u0010d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020bH\u0087\b\u001a(\u0010e\u001a\u0004\u0018\u00010f*\u00020\u00022\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010g\u001a\u0015\u0010h\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020fH\u0087\b\u001a,\u0010i\u001a\b\u0012\u0004\u0012\u00020k0j*\u00020\u00022\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\b¢\u0006\u0002\u0010l\u001a\u001b\u0010m\u001a\u00020\u0002*\u00020\u00022\f\u0010O\u001a\b\u0012\u0004\u0012\u00020k0jH\u0087\b\u001a\u0015\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0087\b\u001a6\u0010o\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u001a\u0010B\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\b¢\u0006\u0002\u0010p\u001a\r\u0010q\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a.\u0010r\u001a\u00020\u0002*\u00020\u00022\u001a\u0010B\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\b¢\u0006\u0002\u0010D\u001aB\u0010s\u001a\u00020\u00022\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u00012\u001a\u0010B\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\b¢\u0006\u0002\u0010v\u001aK\u0010s\u001a\u00020\u00022\b\u0010w\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u00012\u001a\u0010B\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0007¢\u0006\u0002\u0010x\u001a6\u0010y\u001a\u00020\u00022\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u00012\u001a\u0010B\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\b¢\u0006\u0002\u0010z\u001a?\u0010y\u001a\u00020\u00022\b\u0010w\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u00012\u001a\u0010B\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0007¢\u0006\u0002\u0010{\u001a\u0015\u0010|\u001a\u00020\u0002*\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0087\n\u001a\u0015\u0010|\u001a\u00020\u0002*\u00020\u00022\u0006\u00100\u001a\u00020\u0001H\u0087\n\u001a\u0011\u0010}\u001a\u00020\u00022\u0006\u0010X\u001a\u00020\u0001H\u0087\b\u001a*\u0010}\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00012\u0012\u0010~\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010!\"\u00020\u0001H\u0087\b¢\u0006\u0002\u0010\u007f\u001a\u000f\u0010\u0080\u0001\u001a\u00020\u0002*\u00030\u0081\u0001H\u0087\b\u001a/\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u000208*\u00020\u00022\u0014\u0010 \u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u0083\u00010!\"\u00030\u0083\u0001H\u0007¢\u0006\u0003\u0010\u0084\u0001\u001a4\u0010\u0085\u0001\u001a\u00020;*\u00020\u00022\u000e\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0087\u00012\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0089\u00012\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u001fH\u0007\u001aM\u0010\u0085\u0001\u001a\u00020;*\u00020\u00022\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0089\u00012\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u001f2\u001a\u0010\u008b\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u008c\u0001\u0012\u0004\u0012\u00020;07¢\u0006\u0003\b\u008d\u0001H\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a9\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0087\u00012\u001a\u0010\u008b\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u008c\u0001\u0012\u0004\u0012\u00020;07¢\u0006\u0003\b\u008d\u0001H\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u001f\u0010\r\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008f\u0001"}, d2 = {"name", "", "Ljava/nio/file/Path;", "getName$annotations", "(Ljava/nio/file/Path;)V", "getName", "(Ljava/nio/file/Path;)Ljava/lang/String;", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "extension", "getExtension$annotations", "getExtension", "pathString", "getPathString$annotations", "getPathString", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "absolute", "absolutePathString", "relativeTo", "base", "relativeToOrSelf", "relativeToOrNull", "copyTo", "target", "overwrite", "", "options", "", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "notExists", "isRegularFile", "isDirectory", "isSymbolicLink", "isExecutable", "isHidden", "isReadable", "isWritable", "isSameFileAs", "other", "listDirectoryEntries", "", "glob", "useDirectoryEntries", "T", "block", "Lkotlin/Function1;", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "forEachDirectoryEntry", "", "action", "fileSize", "", "deleteExisting", "deleteIfExists", "createDirectory", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectories", "createParentDirectories", "moveTo", "fileStore", "Ljava/nio/file/FileStore;", "getAttribute", "", "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "fileAttributesViewOrNull", "V", "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesView", "fileAttributeViewNotAvailable", "", "path", "attributeViewClass", "Ljava/lang/Class;", "readAttributes", "A", "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "setLastModifiedTime", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "setOwner", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "setPosixFilePermissions", "createLinkPointingTo", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "readSymbolicLink", "createFile", "createTempFile", "prefix", "suffix", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "directory", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempDirectory", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "div", "Path", "subpaths", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "toPath", "Ljava/net/URI;", "walk", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "visitFileTree", "visitor", "Ljava/nio/file/FileVisitor;", "maxDepth", "", "followLinks", "builderAction", "Lkotlin/io/path/FileVisitorBuilder;", "Lkotlin/ExtensionFunctionType;", "fileVisitor", "kotlin-stdlib-jdk7"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    private static final Path Path(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{18, 86, 71, 92}, "b7340a3f", 0.0f));
        Path path = Paths.get(str, new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, C0000.decode(new byte[]{5, 6, 65, 31, 26, 26, 76, 30}, "bc5744b7", 3));
        return path;
    }

    private static final Path Path(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{87, 89, 17, 6}, "58bc20bdd1f0", true));
        Intrinsics.checkNotNullParameter(strArr, C0000.decode(new byte[]{18, 23, 0, 21, 81, 18, 9, 17}, "abbe0f", false));
        Path path = Paths.get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        Intrinsics.checkNotNullExpressionValue(path, C0000.decode(new byte[]{6, 80, 70, 75, 29, 77, 29, 26}, "a52c3c339e", 0.0f));
        return path;
    }

    private static final Path absolute(Path path) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{90, 22, 94, 93, 23, 91}, "fb64de5537a18b"));
        Path absolutePath = path.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, C0000.decode(new byte[]{18, 89, 39, 84, 22, 90, 89, 16, 68, 83, 102, 3, 18, 94, 78, 24, 75, 27, 28}, "f6f6e55e066b", false));
        return absolutePath;
    }

    private static final String absolutePathString(Path path) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{12, 67, 88, 93, 71, 93}, "07044c01ab959b5e", false));
        return path.toAbsolutePath().toString();
    }

    private static final Path copyTo(Path path, Path path2, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{89, 22, 10, 92, 75, 7}, "ebb5895ba2009f3b", 7));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{16, 2, 66, 86, 92, 21}, "dc019a", 6));
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathCopy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCopy, C0000.decode(new byte[]{84, 93, 21, 75, 74, 74, 77, 24, 76}, "72e2bdc6e7ded9ff", 0.0f));
        return pathCopy;
    }

    private static final Path copyTo(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{15, 65, 93, 93, 65, 6}, "355428ba3904cc25", 6));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{77, 4, 23, 82, 1, 64}, "9ee5d43d30b7", 0.0f));
        Intrinsics.checkNotNullParameter(copyOptionArr, C0000.decode(new byte[]{90, 21, 17, 12, 93, 88, 22}, "5eee26e8c57f", 3));
        Path pathCopy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCopy, C0000.decode(new byte[]{86, 95, 72, 28, 76, 76, 27, 30, 17}, "508edb", 1));
        return pathCopy;
    }

    static /* synthetic */ Path copyTo$default(Path path, Path path2, boolean z, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{93, 23, 89, 11, 22, 90}, "ac1bedfd"));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{16, 84, 65, 83, 6, 22}, "d534cb", 0));
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathCopy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCopy, C0000.decode(new byte[]{91, 12, 66, 31, 77, 77, 30, 77, 79}, "8c2fec0cffc63d16", false));
        return pathCopy;
    }

    private static final Path createDirectories(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{15, 69, 81, 10, 68, 12}, "319c7235e97a", 6));
        Intrinsics.checkNotNullParameter(fileAttributeArr, C0000.decode(new byte[]{89, 67, 69, 66, 12, 82, 77, 66, 4, 64}, "8710e086a3", false));
        Path pathCreateDirectories = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateDirectories, C0000.decode(new byte[]{7, 22, 87, 86, 22, 81, 119, 91, 66, 93, 7, 16, 93, 69, 11, 81, 64, 26, 30, 22, 74, 77}, "dd27b43208", 1));
        return pathCreateDirectories;
    }

    private static final Path createDirectory(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{88, 21, 10, 95, 69, 14}, "dab660e4d914", 0.0f));
        Intrinsics.checkNotNullParameter(fileAttributeArr, C0000.decode(new byte[]{85, 76, 22, 19, 12, 90, 70, 68, 80, 64}, "48bae83053", 0));
        Path pathCreateDirectory = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateDirectory, C0000.decode(new byte[]{82, 75, 80, 85, 71, 4, 125, 80, 68, 4, 0, 76, 12, 23, 28, 31, 31, 23, 27, 29}, "19543a996ac8cee7", false));
        return pathCreateDirectory;
    }

    private static final Path createFile(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{14, 76, 12, 95, 66, 7}, "28d61988", 3));
        Intrinsics.checkNotNullParameter(fileAttributeArr, C0000.decode(new byte[]{5, 71, 21, 69, 91, 4, 66, 66, 6, 64}, "d3a72f76c3edd661"));
        Path pathCreateFile = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateFile, C0000.decode(new byte[]{81, 75, 87, 81, 65, 87, 35, 94, 95, 3, 74, 25, 31, 77, 27}, "292052e73fb71c", 6));
        return pathCreateFile;
    }

    private static final Path createLinkPointingTo(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{14, 21, 10, 90, 64, 15}, "2ab3319f8eed754d", 0.0f));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{22, 83, 17, 95, 87, 22}, "b2c82b3e36", 0.0f));
        Path pathCreateLink = Files.createLink(path, path2);
        Intrinsics.checkNotNullExpressionValue(pathCreateLink, C0000.decode(new byte[]{85, 23, 82, 80, 22, 6, 41, 11, 95, 10, 31, 26, 28, 30, 31}, "6e71bceb1a7420"));
        return pathCreateLink;
    }

    public static final Path createParentDirectories(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{8, 17, 81, 12, 64, 91}, "4e9e3e", true));
        Intrinsics.checkNotNullParameter(fileAttributeArr, C0000.decode(new byte[]{87, 23, 65, 68, 80, 6, 20, 67, 82, 74}, "6c569da7799d1d", 0.0f));
        Path parent = path.getParent();
        if (parent != null && !Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
            try {
                FileAttribute[] fileAttributeArr2 = (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length);
                Intrinsics.checkNotNullExpressionValue(Files.createDirectories(parent, (FileAttribute[]) Arrays.copyOf(fileAttributeArr2, fileAttributeArr2.length)), C0000.decode(new byte[]{83, 71, 4, 81, 64, 84, 113, 91, 74, 93, 83, 65, 14, 66, 93, 84, 70, 26, 22, 22, 30, 28}, "05a0415288", true));
                return path;
            } catch (FileAlreadyExistsException e) {
                if (!Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                    throw e;
                }
            }
        }
        return path;
    }

    private static final Path createSymbolicLinkPointingTo(Path path, Path path2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{89, 77, 93, 92, 70, 9}, "e955571675", 0.0f));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{22, 81, 16, 6, 81, 16}, "b0ba4d"));
        Intrinsics.checkNotNullParameter(fileAttributeArr, C0000.decode(new byte[]{84, 69, 76, 19, 92, 91, 65, 22, 0, 75}, "518a594be8fac2"));
        Path pathCreateSymbolicLink = Files.createSymbolicLink(path, path2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateSymbolicLink, C0000.decode(new byte[]{81, 75, 83, 87, 66, 85, 97, 64, 91, 84, 89, 92, 91, 90, 122, 95, 88, 91, 26, 23, 24, 24, 31}, "296660"));
        return pathCreateSymbolicLink;
    }

    private static final Path createTempDirectory(String str, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, C0000.decode(new byte[]{80, 21, 21, 20, 89, 81, 68, 21, 4, 21}, "1aaf03", 6));
        Path pathCreateTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempDirectory, C0000.decode(new byte[]{81, 67, 6, 87, 21, 0, 108, 86, 95, 65, 39, 95, 19, 0, 91, 71, 93, 67, 26, 30, 79, 75, 22, 26}, "21c6ae83"));
        return pathCreateTempDirectory;
    }

    public static final Path createTempDirectory(Path path, String str, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, C0000.decode(new byte[]{86, 66, 23, 71, 15, 4, 65, 67, 82, 69}, "76c5ff47"));
        String strDecode = C0000.decode(new byte[]{5, 68, 84, 87, 22, 82, 50, 93, 90, 65, 115, 10, 67, 84, 5, 66, 94, 68, 27, 31, 72, 22, 25, 24}, "f616b7f8717c11", false);
        if (path != null) {
            Path pathCreateTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            Intrinsics.checkNotNullExpressionValue(pathCreateTempDirectory, strDecode);
            return pathCreateTempDirectory;
        }
        Path pathCreateTempDirectory2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempDirectory2, strDecode);
        return pathCreateTempDirectory2;
    }

    static /* synthetic */ Path createTempDirectory$default(String str, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(fileAttributeArr, C0000.decode(new byte[]{5, 70, 67, 22, 81, 91, 64, 66, 1, 65}, "d27d8956", 0.0f));
        Path pathCreateTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempDirectory, C0000.decode(new byte[]{0, 19, 93, 80, 66, 6, 53, 0, 89, 65, 39, 8, 74, 84, 85, 23, 14, 23, 77, 25, 77, 79, 22, 24}, "ca816cae41", true));
        return pathCreateTempDirectory;
    }

    private static final Path createTempFile(String str, String str2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, C0000.decode(new byte[]{0, 69, 70, 68, 89, 80, 76, 22, 4, 66}, "a126029b", false));
        Path pathCreateTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempFile, C0000.decode(new byte[]{80, 67, 82, 5, 69, 82, 100, 92, 91, 21, ByteCompanionObject.MAX_VALUE, 90, 85, 4, 27, 31, 25, 74, 24}, "317d17096e939a", false));
        return pathCreateTempFile;
    }

    public static final Path createTempFile(Path path, String str, String str2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, C0000.decode(new byte[]{0, 16, 17, 17, 12, 81, 70, 71, 6, 65}, "adece333c249", 3));
        String strDecode = C0000.decode(new byte[]{83, 23, 1, 5, 76, 3, 103, 84, 11, 21, 113, 90, 95, 6, 24, 75, 74, 74, 17}, "0edd8f31fe733c", true);
        if (path != null) {
            Path pathCreateTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            Intrinsics.checkNotNullExpressionValue(pathCreateTempFile, strDecode);
            return pathCreateTempFile;
        }
        Path pathCreateTempFile2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempFile2, strDecode);
        return pathCreateTempFile2;
    }

    static /* synthetic */ Path createTempFile$default(String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        Intrinsics.checkNotNullParameter(fileAttributeArr, C0000.decode(new byte[]{87, 21, 64, 67, 91, 1, 66, 66, 83, 18}, "6a412c76", 0.0f));
        Path pathCreateTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempFile, C0000.decode(new byte[]{82, 19, 92, 87, 16, 86, 48, 87, 92, 17, ByteCompanionObject.MAX_VALUE, 95, 8, 86, 76, 28, 31, 79, 16}, "1a96d3d2", false));
        return pathCreateTempFile;
    }

    private static final void deleteExisting(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{10, 77, 90, 11, 68, 7}, "692b79945128", true));
        Files.delete(path);
    }

    private static final boolean deleteIfExists(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{4, 21, 80, 90, 68, 88}, "8a837f410861b352", 0.0f));
        return Files.deleteIfExists(path);
    }

    private static final Path div(Path path, String str) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{14, 65, 95, 90, 16, 9}, "2573c7f7aa577b33", 4));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 66, 91, 81, 75}, "26349031", 0.0f));
        Path pathResolve = path.resolve(str);
        Intrinsics.checkNotNullExpressionValue(pathResolve, C0000.decode(new byte[]{67, 83, 67, 91, 93, 69, 92, 76, 76, 28, 25, 27}, "1604139db272", false));
        return pathResolve;
    }

    private static final Path div(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{10, 64, 14, 88, 16, 7}, "64f1c91842", 0.0f));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{93, 18, 91, 82, 22}, "2f37dfc290f89094", 2));
        Path pathResolve = path.resolve(path2);
        Intrinsics.checkNotNullExpressionValue(pathResolve, C0000.decode(new byte[]{20, 1, 64, 11, 88, 18, 86, 76, 25, 23, 31, 72}, "fd3d4d3d791a7c28", true));
        return pathResolve;
    }

    private static final boolean exists(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{88, 67, 14, 8, 64, 90}, "d7fa3dbaa7", 0.0f));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{95, 20, 22, 8, 89, 91, 18}, "0dba65abe27e26ed"));
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    public static final Void fileAttributeViewNotAvailable(Path path, Class<?> cls) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{67, 5, 65, 94}, "3d568ee9f0b84d85"));
        Intrinsics.checkNotNullParameter(cls, C0000.decode(new byte[]{2, 71, 76, 68, 93, 7, 64, 71, 81, 52, 8, 85, 79, 117, 9, 2, 16, 64}, "c3864e534ba086ec"));
        throw new UnsupportedOperationException(C0000.decode(new byte[]{99, 88, 6, 18, 81, 92, 68, 15, 70, 86, 86, 21, 86, 68, 23, 64, 92, 91, 66, 18, 81, 19, 68, 92, 82, 71, 67, 70, 76, 73, 82, 70}, "70c2597f4325") + cls + C0000.decode(new byte[]{23, 80, 68, 21, 90, 9, 68, 19, 80, 19, 4, 91, 91, 88, 85, 89, 81, 70, 86, 92, 67, 69, 17, 90, 82, 25, 81, 92, 88, 3, 16}, "79754f031ee2", 2) + path + '.');
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesView(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{94, 18, 92, 15, 74, 95}, "bf4f9abc1008a9e6", true));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{10, 17, 16, 15, 94, 13, 65}, "eadf1c26888556"));
        String strDecode = C0000.decode(new byte[]{52}, "bd2f9e");
        Intrinsics.reifiedOperationMarker(4, strDecode);
        V v = (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (v != null) {
            return v;
        }
        Intrinsics.reifiedOperationMarker(4, strDecode);
        PathsKt.fileAttributeViewNotAvailable(path, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesViewOrNull(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{9, 21, 81, 8, 65, 14}, "5a9a2004e719", false));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{89, 22, 22, 11, 89, 8, 69}, "6fbb6f"));
        Intrinsics.reifiedOperationMarker(4, C0000.decode(new byte[]{102}, "085965", 7));
        return (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final long fileSize(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{93, 18, 94, 80, 65, 7}, "af6929c707a0b1"));
        return Files.size(path);
    }

    private static final FileStore fileStore(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{12, 17, 89, 12, 16, 88}, "0e1ecff96300", false));
        FileStore fileStore = Files.getFileStore(path);
        Intrinsics.checkNotNullExpressionValue(fileStore, C0000.decode(new byte[]{6, 86, 17, 112, 13, 92, 4, 96, 17, 89, 22, 85, 73, 29, 75, 24, 77}, "a3e6d0"));
        return fileStore;
    }

    public static final FileVisitor<Path> fileVisitor(Function1<? super FileVisitorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{86, 20, 8, 8, 7, 92, 66, 39, 91, 70, 10, 14, 92}, "4aadc90f82ca27ce"));
        FileVisitorBuilderImpl fileVisitorBuilderImpl = new FileVisitorBuilderImpl();
        function1.invoke(fileVisitorBuilderImpl);
        return fileVisitorBuilderImpl.build();
    }

    private static final void forEachDirectoryEntry(Path path, String str, Function1<? super Path, Unit> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{93, 70, 14, 13, 22, 8}, "a2fde6", 0.0f));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{6, 14, 11, 7}, "abdeb7186758", true));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{80, 7, 76, 10, 89, 87}, "1d8c694d69", true));
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
            Intrinsics.checkNotNull(directoryStream);
            Iterator<Path> it = directoryStream.iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(directoryStreamNewDirectoryStream, th);
                throw th2;
            }
        }
    }

    static /* synthetic */ void forEachDirectoryEntry$default(Path path, String str, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = C0000.decode(new byte[]{73}, "cd51d8b5b527", true);
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{93, 77, 94, 89, 17, 90}, "a960bdb5", 0.0f));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{1, 85, 88, 83}, "f9715bc54d03", false));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{7, 82, 64, 81, 94, 10}, "f1481d1812"));
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
            Intrinsics.checkNotNull(directoryStream);
            Iterator<Path> it = directoryStream.iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(directoryStreamNewDirectoryStream, th);
                throw th2;
            }
        }
    }

    private static final Object getAttribute(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{89, 76, 94, 15, 65, 13}, "e86f235d99", false));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{7, 70, 69, 68, 92, 87, 17, 76, 82}, "f21655d87f"));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{86, 21, 66, 10, 87, 94, 22}, "9e6c80e793bf038f", 0.0f));
        return Files.getAttribute(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    public static final String getExtension(Path path) {
        String string;
        String strSubstringAfterLast;
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{15, 65, 13, 81, 17, 8}, "35e8b66e0a", 0.0f));
        Path fileName = path.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strSubstringAfterLast = StringsKt.substringAfterLast(string, '.', "")) == null) ? "" : strSubstringAfterLast;
    }

    public static /* synthetic */ void getExtension$annotations(Path path) {
    }

    private static final String getInvariantSeparatorsPath(Path path) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{15, 76, 88, 94, 18, 9}, "3807a7208b28579b", 2));
        return PathsKt.getInvariantSeparatorsPathString(path);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path path) {
    }

    public static final String getInvariantSeparatorsPathString(Path path) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{93, 17, 94, 89, 64, 93}, "ae603cdf", true));
        String separator = path.getFileSystem().getSeparator();
        if (Intrinsics.areEqual(separator, C0000.decode(new byte[]{24}, "737e7a", 0.0f))) {
            return path.toString();
        }
        String string = path.toString();
        Intrinsics.checkNotNull(separator);
        return StringsKt.replace$default(string, separator, C0000.decode(new byte[]{77}, "b5e41815c4a3", true), false, 4, (Object) null);
    }

    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path path) {
    }

    private static final FileTime getLastModifiedTime(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{93, 16, 92, 89, 18, 10}, "ad40a453", false));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{88, 20, 21, 11, 10, 86, 18}, "7dabe8a724", 1));
        FileTime lastModifiedTime = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, C0000.decode(new byte[]{82, 80, 67, ByteCompanionObject.MAX_VALUE, 86, 70, 68, 126, 11, 2, 90, 3, 13, 81, 82, 101, 92, 88, 82, 27, 25, 27, 30, 26}, "55737503df3ed461", 0.0f));
        return lastModifiedTime;
    }

    public static final String getName(Path path) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{14, 68, 88, 88, 66, 14}, "200110f4b7320a"));
        Path fileName = path.getFileName();
        String string = fileName != null ? fileName.toString() : null;
        return string == null ? "" : string;
    }

    public static /* synthetic */ void getName$annotations(Path path) {
    }

    public static final String getNameWithoutExtension(Path path) {
        String string;
        String strSubstringBeforeLast$default;
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{11, 67, 10, 8, 74, 8}, "77ba96d90a", 4));
        Path fileName = path.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(string, C0000.decode(new byte[]{24}, "6b0481", false), (String) null, 2, (Object) null)) == null) ? "" : strSubstringBeforeLast$default;
    }

    public static /* synthetic */ void getNameWithoutExtension$annotations(Path path) {
    }

    private static final UserPrincipal getOwner(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{90, 23, 93, 91, 74, 14}, "fc5290", 0.0f));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{88, 18, 21, 88, 88, 94, 65}, "7ba1702249", false));
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final String getPathString(Path path) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{14, 77, 9, 94, 66, 88}, "29a71f", 0.0f));
        return path.toString();
    }

    public static /* synthetic */ void getPathString$annotations(Path path) {
    }

    private static final Set<PosixFilePermission> getPosixFilePermissions(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{11, 68, 90, 90, 66, 12}, "702312b1"));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{90, 19, 71, 89, 11, 15, 70}, "5c30da"));
        Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, C0000.decode(new byte[]{87, 87, 68, 97, 93, 74, 89, 78, 32, 90, 95, 1, 52, 93, 66, 95, 89, 66, 65, 80, 95, 88, 21, 27, 29, 74, 74, 17}, "02012906f33dd8", false));
        return posixFilePermissions;
    }

    private static final boolean isDirectory(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{10, 67, 88, 10, 17, 11}, "670cb5a59ce52f", 0.0f));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{93, 69, 23, 13, 91, 93, 70}, "25cd435033", true));
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean isExecutable(Path path) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{14, 22, 10, 13, 69, 7}, "2bbd69016a"));
        return Files.isExecutable(path);
    }

    private static final boolean isHidden(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{14, 16, 88, 92, 67, 14}, "2d0500", true));
        return Files.isHidden(path);
    }

    private static final boolean isReadable(Path path) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{90, 17, 9, 12, 69, 93}, "feae6c0a", false));
        return Files.isReadable(path);
    }

    private static final boolean isRegularFile(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{95, 23, 93, 95, 71, 13}, "cc5643", 0.0f));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{95, 67, 21, 90, 92, 90, 66}, "03a334132b5b", 0.0f));
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean isSameFileAs(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{15, 65, 10, 11, 17, 9}, "35bbb70e", 0));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{93, 23, 14, 87, 20}, "2cf2f317d06a30", 2));
        return Files.isSameFile(path, path2);
    }

    private static final boolean isSymbolicLink(Path path) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{5, 70, 14, 95, 21, 14}, "92f6f067b000", 3));
        return Files.isSymbolicLink(path);
    }

    private static final boolean isWritable(Path path) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{5, 64, 94, 94, 71, 91}, "94674e30", 4));
        return Files.isWritable(path);
    }

    public static final List<Path> listDirectoryEntries(Path path, String str) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{9, 17, 88, 89, 66, 93}, "5e001c", true));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{3, 95, 91, 7}, "d34ecfe2073f", 5));
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
            Intrinsics.checkNotNull(directoryStream);
            List<Path> list = CollectionsKt.toList(directoryStream);
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            return list;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(directoryStreamNewDirectoryStream, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path path, String str, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = C0000.decode(new byte[]{75}, "abb259e80da7da11", 0.0f);
        }
        return PathsKt.listDirectoryEntries(path, str);
    }

    private static final Path moveTo(Path path, Path path2, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{15, 77, 80, 8, 21, 92}, "398afbbb0fa6", false));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{76, 82, 75, 1, 83, 18}, "839f6f1bfbb2", 0.0f));
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathMove = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathMove, C0000.decode(new byte[]{89, 95, 64, 87, 77, 29, 30, 29, 26}, "4062e3033140", 1));
        return pathMove;
    }

    private static final Path moveTo(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{13, 66, 95, 8, 71, 93}, "167a4c42cfb4", false));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{66, 86, 66, 5, 1, 68}, "670bd0880bf97c", false));
        Intrinsics.checkNotNullParameter(copyOptionArr, C0000.decode(new byte[]{87, 69, 70, 94, 93, 12, 75}, "85272b"));
        Path pathMove = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathMove, C0000.decode(new byte[]{91, 91, 19, 81, 30, 72, 74, 31, 24}, "64e46fd11936f9"));
        return pathMove;
    }

    static /* synthetic */ Path moveTo$default(Path path, Path path2, boolean z, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{5, 70, 95, 88, 68, 11}, "9271756ae9", 0.0f));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{67, 4, 71, 87, 3, 77}, "7e50f9f9", 0.0f));
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathMove = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathMove, C0000.decode(new byte[]{93, 88, 67, 93, 24, 31, 23, 25, 77}, "07580197d191e3", false));
        return pathMove;
    }

    private static final boolean notExists(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{15, 69, 9, 91, 21, 88}, "31a2ffa8c300210c", 0.0f));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{90, 70, 67, 89, 12, 12, 70}, "5670cb", false));
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final /* synthetic */ <A extends BasicFileAttributes> A readAttributes(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{93, 68, 91, 8, 68, 11}, "a03a750c1a"));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{88, 67, 66, 8, 86, 11, 23}, "736a9ed084e8", 1));
        Intrinsics.reifiedOperationMarker(4, C0000.decode(new byte[]{36}, "e5122144306a04"));
        A a = (A) Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a, C0000.decode(new byte[]{16, 92, 5, 7, 114, 69, 68, 65, 89, 7, 67, 18, 7, 74, 76, 77, 29, 31, 25}, "b9dc31030e6f", 2));
        return a;
    }

    private static final Map<String, Object> readAttributes(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{14, 21, 80, 92, 67, 10}, "2a8504f50b", 6));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{7, 77, 21, 75, 92, 82, 19, 77, 4, 74}, "f9a950", 0.0f));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{86, 65, 64, 80, 92, 10, 66}, "91493d1094", false));
        Map<String, Object> attributes = Files.readAttributes(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(attributes, C0000.decode(new byte[]{20, 80, 4, 86, 118, 70, 21, 71, 15, 87, 16, 70, 82, 65, 73, 27, 72, 27, 76}, "f5e272a5", true));
        return attributes;
    }

    private static final Path readSymbolicLink(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{9, 17, 10, 81, 75, 93}, "5eb88c2e33", false));
        Path symbolicLink = Files.readSymbolicLink(path);
        Intrinsics.checkNotNullExpressionValue(symbolicLink, C0000.decode(new byte[]{20, 84, 86, 5, 48, 29, 12, 87, 9, 93, 94, 2, 47, 13, 15, 94, 78, 31, 25, 79, 74}, "f17acda5"));
        return symbolicLink;
    }

    public static final Path relativeTo(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{88, 77, 14, 90, 71, 13}, "d9f343c6b820", false));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{3, 87, 75, 6}, "a68c9940c0f58f06", 3));
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(path, path2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + C0000.decode(new byte[]{Base64.padSymbol, 70, 95, 11, 70, 66, 17, 5, 21, 89, 15, 70}, "727b5bada15f7b") + path + C0000.decode(new byte[]{111, 4, 89, 70, 7, 17, 66, 85, 17, 14, 2, 21}, "ef85b124", 0.0f) + path2, e);
        }
    }

    public static final Path relativeToOrNull(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{8, 70, 90, 12, 75, 8}, "422e86215cc6a578"));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{85, 84, 69, 4}, "756a76b1", true));
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(path, path2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final Path relativeToOrSelf(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{11, 68, 81, 88, 23, 6}, "7091d8", 7));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{83, 2, 69, 3}, "1c6fa6d9e5d5", 0.0f));
        Path pathRelativeToOrNull = PathsKt.relativeToOrNull(path, path2);
        return pathRelativeToOrNull == null ? path : pathRelativeToOrNull;
    }

    private static final Path setAttribute(Path path, String str, Object obj, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{88, 16, 90, 13, 68, 95}, "dd2d7abf5173", 0.0f));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{88, 65, 16, 65, 95, 90, 65, 71, 85}, "95d36843000c8f", true));
        Intrinsics.checkNotNullParameter(linkOptionArr, C0000.decode(new byte[]{11, 73, 66, 92, 94, 94, 23}, "d96510", 6));
        Path attribute = Files.setAttribute(path, str, obj, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(attribute, C0000.decode(new byte[]{23, 3, 64, 121, 70, 21, 22, 15, 86, 77, 70, 4, 76, 72, 26, 22, 27}, "df482a"));
        return attribute;
    }

    private static final Path setLastModifiedTime(Path path, FileTime fileTime) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{8, 66, 81, 91, 22, 15}, "4692e1ed", 0.0f));
        Intrinsics.checkNotNullParameter(fileTime, C0000.decode(new byte[]{18, 83, 95, 77, 81}, "d2384d7a9a67affd", 0.0f));
        Path lastModifiedTime = Files.setLastModifiedTime(path, fileTime);
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, C0000.decode(new byte[]{23, 7, 22, 41, 82, 21, 65, 126, 11, 0, 13, 4, 11, 0, 87, 50, 92, 94, 1, 76, 74, 76, 76, 76}, "dbbe3f53dd", true));
        return lastModifiedTime;
    }

    private static final Path setOwner(Path path, UserPrincipal userPrincipal) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{15, 71, 13, 13, 18, 15}, "33eda118", 0.0f));
        Intrinsics.checkNotNullParameter(userPrincipal, C0000.decode(new byte[]{66, 3, 93, 68, 84}, "4b1114", 0.0f));
        Path owner = Files.setOwner(path, userPrincipal);
        Intrinsics.checkNotNullExpressionValue(owner, C0000.decode(new byte[]{67, 1, 70, 41, 18, 15, 93, 70, 73, 25, 25, 30, 24}, "0d2fea84a770183e", 6));
        return owner;
    }

    private static final Path setPosixFilePermissions(Path path, Set<? extends PosixFilePermission> set) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{89, 17, 81, 8, 74, 9}, "ee9a97d1", 3));
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{23, 84, 10, 71, 93}, "a5f28f609b", 7));
        Path posixFilePermissions = Files.setPosixFilePermissions(path, set);
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, C0000.decode(new byte[]{70, 81, 76, 98, 86, 22, 11, 26, 115, 11, 8, 1, 103, 6, 71, 89, 81, 65, 74, 12, 13, 12, 70, 74, 74, 74, 25, 74}, "54829ebb5bdd7c", 0.0f));
        return posixFilePermissions;
    }

    private static final Path toPath(URI uri) {
        Intrinsics.checkNotNullParameter(uri, C0000.decode(new byte[]{4, 21, 95, 90, 71, 91}, "8a734e5aebdc82ef", 0.0f));
        Path path = Paths.get(uri);
        Intrinsics.checkNotNullExpressionValue(path, C0000.decode(new byte[]{95, 84, 17, 74, 22, 30, 76, 30}, "81eb80b76c6c", 0.0f));
        return path;
    }

    private static final <T> T useDirectoryEntries(Path path, String str, Function1<? super Sequence<? extends Path>, ? extends T> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{4, 18, 13, 92, 66, 8}, "8fe516d0aa10", false));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{80, 14, 12, 3}, "7bcad7fd", 7));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{4, 14, 91, 91, 94}, "fb4855", 3));
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
            Intrinsics.checkNotNull(directoryStream);
            T tInvoke = function1.invoke(CollectionsKt.asSequence(directoryStream));
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            return tInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(directoryStreamNewDirectoryStream, th);
                throw th2;
            }
        }
    }

    static /* synthetic */ Object useDirectoryEntries$default(Path path, String str, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = C0000.decode(new byte[]{76}, "f6ef4c", 4);
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{8, 67, 80, 95, 64, 14}, "47863051724843", 1));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{81, 91, 91, 0}, "674b6c6a", true));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{87, 88, 87, 86, 88}, "54853648"));
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
            Intrinsics.checkNotNull(directoryStream);
            Object objInvoke = function1.invoke(CollectionsKt.asSequence(directoryStream));
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            return objInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(directoryStreamNewDirectoryStream, th);
                throw th2;
            }
        }
    }

    public static final void visitFileTree(Path path, int i, boolean z, Function1<? super FileVisitorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{15, 70, 94, 91, 68, 92}, "32627b6ab13a", 6));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{0, 67, 90, 9, 86, 93, 74, 36, 1, 22, 15, 88, 12}, "b63e288ebbf7"));
        PathsKt.visitFileTree(path, PathsKt.fileVisitor(function1), i, z);
    }

    public static final void visitFileTree(Path path, FileVisitor<Path> fileVisitor, int i, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{11, 22, 14, 81, 64, 14}, "7bf8309d86", true));
        Intrinsics.checkNotNullParameter(fileVisitor, C0000.decode(new byte[]{16, 12, 18, 91, 65, 94, 16}, "fea251b387"));
        Files.walkFileTree(path, z ? SetsKt.setOf(FileVisitOption.FOLLOW_LINKS) : SetsKt.emptySet(), i, fileVisitor);
    }

    public static final Sequence<Path> walk(Path path, PathWalkOption... pathWalkOptionArr) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{90, 67, 13, 15, 17, 6}, "f7efb85d1efd9d"));
        Intrinsics.checkNotNullParameter(pathWalkOptionArr, C0000.decode(new byte[]{10, 17, 16, 94, 91, 94, 74}, "ead7409a96"));
        return new PathTreeWalk(path, pathWalkOptionArr);
    }

    public static /* synthetic */ Path createTempFile$default(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return PathsKt.createTempFile(path, str, str2, fileAttributeArr);
    }

    public static /* synthetic */ Path createTempDirectory$default(Path path, String str, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        return PathsKt.createTempDirectory(path, str, fileAttributeArr);
    }

    public static /* synthetic */ void visitFileTree$default(Path path, FileVisitor fileVisitor, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = IntCompanionObject.MAX_VALUE;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        PathsKt.visitFileTree(path, (FileVisitor<Path>) fileVisitor, i, z);
    }

    public static /* synthetic */ void visitFileTree$default(Path path, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IntCompanionObject.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        PathsKt.visitFileTree(path, i, z, (Function1<? super FileVisitorBuilder, Unit>) function1);
    }
}
