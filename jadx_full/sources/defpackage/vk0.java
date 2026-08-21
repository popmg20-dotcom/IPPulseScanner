package defpackage;

import java.nio.file.LinkOption;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class vk0 extends mm2 implements tb3 {
    public static final vk0 Z;

    static {
        String property;
        AtomicReference atomicReference = uw2.c;
        synchronized (atomicReference) {
            try {
                property = (String) atomicReference.get();
                if (property == null) {
                    property = System.getProperty("org.apache.sshd.currentUser", System.getProperty("user.name"));
                    if (!ga5.t(property) && uw2.a().contains("windows")) {
                        int iLastIndexOf = property.lastIndexOf(92);
                        if (iLastIndexOf > 0) {
                            property = property.substring(iLastIndexOf + 1);
                        }
                        int iIndexOf = property.indexOf(32);
                        if (iIndexOf > 0) {
                            property = property.substring(0, iIndexOf).trim();
                        }
                    }
                    if (property == null || property.isEmpty()) {
                        throw new IllegalArgumentException("No username available");
                    }
                    atomicReference.set(property);
                }
            } finally {
            }
        }
        vk0 vk0Var = new vk0(cg.a, new LinkOption[0]);
        new AtomicReference(ki3.X);
        if (property.isEmpty()) {
            xe.k("No username provided");
        } else {
            Z = vk0Var;
        }
    }
}
