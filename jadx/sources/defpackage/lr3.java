package defpackage;

import java.security.Provider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class lr3 implements mr3 {
    public final String b;
    public final /* synthetic */ String f;

    public lr3(String str) {
        this.f = str;
        this.b = fw.z(new StringBuilder(mr3.class.getSimpleName()), "[", str, "]");
    }

    @Override // defpackage.mr3
    public final boolean Z() {
        return true;
    }

    @Override // defpackage.to2
    public final String getName() {
        return this.f;
    }

    @Override // defpackage.mr3
    public final Provider i0() {
        return null;
    }

    public final String toString() {
        return this.b;
    }

    @Override // defpackage.mr3
    public final String x0() {
        return this.f;
    }
}
