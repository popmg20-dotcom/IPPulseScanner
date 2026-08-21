package defpackage;

import j$.util.DesugarCollections;
import j$.util.Objects;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class mm2 extends k70 {
    public static final Set Y = DesugarCollections.unmodifiableSet(EnumSet.of(PosixFilePermission.GROUP_WRITE, PosixFilePermission.OTHERS_WRITE));
    public final Path X;

    public mm2(Path path, LinkOption... linkOptionArr) {
        new AtomicReference();
        Objects.requireNonNull(path, "No path to watch");
        this.X = path;
    }

    @Override // defpackage.k70
    public final String toString() {
        return Objects.toString(this.X);
    }
}
