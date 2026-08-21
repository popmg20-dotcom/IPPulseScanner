package defpackage;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class nd3 extends sd3 {
    public final /* synthetic */ od3 b;

    public nd3(od3 od3Var) {
        this.b = od3Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.sd3
    public final String c() {
        return (String) this.b.get("name");
    }

    @Override // defpackage.sd3
    public final Collection d() {
        return (Collection) this.b.get("patterns");
    }

    @Override // defpackage.sd3
    public final rd3 e() {
        return this.b.b();
    }
}
