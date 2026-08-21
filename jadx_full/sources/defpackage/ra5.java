package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ra5 {
    public static final ie a = new ie(0);

    public static synchronized void a() {
        ie ieVar = a;
        Iterator it = ((he) ieVar.values()).iterator();
        if (it.hasNext()) {
            ((ra5) it.next()).getClass();
            throw null;
        }
        ieVar.clear();
    }
}
