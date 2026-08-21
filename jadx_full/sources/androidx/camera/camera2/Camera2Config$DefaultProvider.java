package androidx.camera.camera2;

import defpackage.mx;
import defpackage.nx;
import defpackage.o00;
import defpackage.ox;
import defpackage.p00;
import defpackage.pg;
import defpackage.q00;
import defpackage.qn2;
import defpackage.sw2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2Config$DefaultProvider implements p00 {
    @Override // defpackage.p00
    public q00 getCameraXConfig() {
        mx mxVar = new mx();
        nx nxVar = new nx();
        ox oxVar = new ox();
        o00 o00Var = new o00();
        pg pgVar = q00.f;
        qn2 qn2Var = o00Var.a;
        qn2Var.g(pgVar, mxVar);
        qn2Var.g(q00.z, nxVar);
        qn2Var.g(q00.A, oxVar);
        qn2Var.g(q00.C0, 0);
        qn2Var.g(q00.D0, Boolean.TRUE);
        return new q00(sw2.a(qn2Var));
    }
}
