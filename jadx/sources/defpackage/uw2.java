package defpackage;

import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class uw2 {
    public static final List a;
    public static final sm b;
    public static final AtomicReference c;
    public static final AtomicReference d;
    public static final AtomicReference e;

    static {
        DesugarCollections.unmodifiableList(Arrays.asList("/bin/sh", "-i", "-l"));
        DesugarCollections.unmodifiableList(Collections.singletonList("cmd.exe"));
        a = DesugarCollections.unmodifiableList(Arrays.asList("java.vendor", "java.specification.vendor", "java.vm.vendor", "java.vm.specification.vendor"));
        b = new sm(10);
        DesugarCollections.unmodifiableList(Arrays.asList("java.specification.name", "java.vm.name", "java.vm.specification.name"));
        c = new AtomicReference(null);
        new AtomicReference(null);
        d = new AtomicReference(null);
        e = new AtomicReference(null);
        new AtomicReference(null);
        new AtomicReference();
    }

    public static String a() {
        AtomicReference atomicReference = d;
        synchronized (atomicReference) {
            try {
                String str = (String) atomicReference.get();
                if (str != null) {
                    return str;
                }
                String property = System.getProperty("org.apache.sshd.osType", System.getProperty("os.name"));
                String lowerCase = (property == null ? "" : property.trim()).toLowerCase();
                atomicReference.set(lowerCase);
                return lowerCase;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean b() {
        AtomicReference atomicReference = e;
        List list = a;
        sm smVar = b;
        synchronized (atomicReference) {
            try {
                Boolean bool = (Boolean) atomicReference.get();
                if (bool != null) {
                    return bool.booleanValue();
                }
                if (smVar.test(System.getProperty("org.apache.sshd.androidMode"))) {
                    atomicReference.set(Boolean.TRUE);
                    return true;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (smVar.test(System.getProperty((String) it.next()))) {
                        atomicReference.set(Boolean.TRUE);
                        return true;
                    }
                }
                atomicReference.set(Boolean.FALSE);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
