package defpackage;

import java.nio.file.Path;
import java.nio.file.Paths;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x03 {
    public static final Path a;

    static {
        a = Paths.get(n12.g(System.getProperty("user.home"), uw2.b() ? "No user home folder available. You should call org.apache.sshd.common.util.io.PathUtils.setUserHomeFolderResolver() method to set user home folder as there is no home folder on Android" : "No user home folder available"), new String[0]).toAbsolutePath().normalize();
    }
}
