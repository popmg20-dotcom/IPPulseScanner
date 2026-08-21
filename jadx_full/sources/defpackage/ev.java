package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ev {
    public final LinkedHashSet a;
    public final ArrayList b;
    public final ArrayList c;
    public final ArrayList d;
    public final ArrayList e;
    public final z34 f;
    public final in4 g;
    public final HashMap h;
    public final b44 i;
    public final b44 j;

    public ev(LinkedHashSet linkedHashSet, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, z34 z34Var, in4 in4Var, HashMap map, b44 b44Var, b44 b44Var2) {
        b44Var.getClass();
        this.a = linkedHashSet;
        this.b = arrayList;
        this.c = arrayList2;
        this.d = arrayList3;
        this.e = arrayList4;
        this.f = z34Var;
        this.g = in4Var;
        this.h = map;
        this.i = b44Var;
        this.j = b44Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ev)) {
            return false;
        }
        ev evVar = (ev) obj;
        return this.a.equals(evVar.a) && this.b.equals(evVar.b) && this.c.equals(evVar.c) && this.d.equals(evVar.d) && this.e.equals(evVar.e) && n12.c(this.f, evVar.f) && n12.c(this.g, evVar.g) && this.h.equals(evVar.h) && n12.c(this.i, evVar.i) && n12.c(this.j, evVar.j);
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        z34 z34Var = this.f;
        int iHashCode2 = (iHashCode + (z34Var == null ? 0 : z34Var.hashCode())) * 31;
        in4 in4Var = this.g;
        int iHashCode3 = (this.i.hashCode() + ((this.h.hashCode() + ((iHashCode2 + (in4Var == null ? 0 : in4Var.hashCode())) * 31)) * 31)) * 31;
        b44 b44Var = this.j;
        return iHashCode3 + (b44Var != null ? b44Var.hashCode() : 0);
    }

    public final String toString() {
        return "CalculatedUseCaseInfo(appUseCases=" + this.a + ", cameraUseCases=" + this.b + ", cameraUseCasesToAttach=" + this.c + ", cameraUseCasesToKeep=" + this.d + ", cameraUseCasesToDetach=" + this.e + ", streamSharing=" + this.f + ", placeholderForExtensions=" + this.g + ", useCaseConfigs=" + this.h + ", primaryStreamSpecResult=" + this.i + ", secondaryStreamSpecResult=" + this.j + ')';
    }
}
