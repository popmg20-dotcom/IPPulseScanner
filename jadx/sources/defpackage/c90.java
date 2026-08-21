package defpackage;

import android.os.Bundle;
import androidx.fragment.app.p;
import androidx.fragment.app.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c90 implements gp3 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c90(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.gp3
    public final Bundle a() {
        e03[] e03VarArr;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Bundle bundle = new Bundle();
                g90 g90Var = ((p) obj).z0;
                g90Var.getClass();
                LinkedHashMap linkedHashMap = g90Var.b;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(g90Var.d));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(g90Var.g));
                return bundle;
            case 1:
                ca caVar = (ca) obj;
                while (p.v(caVar.u())) {
                }
                caVar.N0.f(p92.ON_STOP);
                return new Bundle();
            case 2:
                return ((u) obj).b0();
            default:
                v92 v92Var = (v92) obj;
                for (Map.Entry entry : fh2.Y((LinkedHashMap) v92Var.A).entrySet()) {
                    v92Var.o(((m24) entry.getValue()).i(), (String) entry.getKey());
                }
                for (Map.Entry entry2 : fh2.Y((LinkedHashMap) v92Var.f).entrySet()) {
                    v92Var.o(((gp3) entry2.getValue()).a(), (String) entry2.getKey());
                }
                LinkedHashMap linkedHashMap2 = (LinkedHashMap) v92Var.b;
                if (linkedHashMap2.isEmpty()) {
                    e03VarArr = new e03[0];
                } else {
                    ArrayList arrayList = new ArrayList(linkedHashMap2.size());
                    for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                        arrayList.add(new e03((String) entry3.getKey(), entry3.getValue()));
                    }
                    e03VarArr = (e03[]) arrayList.toArray(new e03[0]);
                }
                return n12.e((e03[]) Arrays.copyOf(e03VarArr, e03VarArr.length));
        }
    }
}
