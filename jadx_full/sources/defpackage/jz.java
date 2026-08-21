package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jz {
    public final ArrayList a;
    public final vg b;

    public jz(ArrayList arrayList, vg vgVar) {
        this.a = arrayList;
        this.b = vgVar;
        r25.f(!arrayList.isEmpty(), "Camera ID set cannot be empty.");
    }

    public final String a() {
        ArrayList arrayList = this.a;
        r25.j("getInternalId() is only available for single-camera identifiers.", arrayList.size() == 1);
        return (String) d70.d0(arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jz)) {
            return false;
        }
        jz jzVar = (jz) obj;
        return this.a.equals(jzVar.a) && n12.c(this.b, jzVar.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        vg vgVar = this.b;
        return iHashCode + (vgVar != null ? vgVar.hashCode() : 0);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("CameraIdentifier{cameraIds=");
        sb.append(d70.j0(this.a, ",", null, null, null, 62));
        vg vgVar = this.b;
        if (vgVar != null) {
            str = ", compatId=" + vgVar;
        } else {
            str = "";
        }
        return fw.x(sb, str, '}');
    }
}
