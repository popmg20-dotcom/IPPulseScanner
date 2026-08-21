package defpackage;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vi0 extends r82 implements pl1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ lj0 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vi0(lj0 lj0Var, int i) {
        super(0);
        this.f = i;
        this.z = lj0Var;
    }

    @Override // defpackage.pl1
    public final Object a() throws IOException {
        switch (this.f) {
            case 0:
                return ((ee1) this.z.A0.getValue()).b;
            default:
                be1 be1Var = this.z.b;
                File canonicalFile = ((File) be1Var.b.a()).getCanonicalFile();
                synchronized (be1.d) {
                    String absolutePath = canonicalFile.getAbsolutePath();
                    LinkedHashSet linkedHashSet = be1.c;
                    if (linkedHashSet.contains(absolutePath)) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + absolutePath + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    absolutePath.getClass();
                    linkedHashSet.add(absolutePath);
                }
                return new ee1(canonicalFile, (nx3) be1Var.a.g(canonicalFile), new v10(1, canonicalFile));
        }
    }
}
