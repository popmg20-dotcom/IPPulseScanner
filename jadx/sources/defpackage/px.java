package defpackage;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class px implements k12 {
    public final Object a;
    public final HashMap b;
    public final t60 c;
    public final pz d;
    public final Context e;

    public px(Context context, Object obj, LinkedHashSet linkedHashSet) throws e00 {
        t60 t60Var = new t60();
        this.a = new Object();
        this.b = new HashMap();
        this.c = t60Var;
        this.e = context;
        if (obj instanceof pz) {
            this.d = (pz) obj;
        } else {
            this.d = pz.a(context, uf2.s());
        }
        try {
            a(new ArrayList(linkedHashSet));
        } catch (f00 e) {
            if (!(e.getCause() instanceof e00)) {
                throw new e00(e);
            }
            throw ((e00) e.getCause());
        }
    }

    @Override // defpackage.k12
    public final void a(List list) throws f00 {
        HashSet<String> hashSet;
        HashMap map = new HashMap();
        synchronized (this.a) {
            hashSet = new HashSet(list);
            hashSet.removeAll(this.b.keySet());
        }
        try {
            for (String str : hashSet) {
                map.put(str, b(str));
            }
            synchronized (this.a) {
                try {
                    HashMap map2 = new HashMap();
                    for (String str2 : (ArrayList) list) {
                        if (this.b.containsKey(str2)) {
                            map2.put(str2, (r64) this.b.get(str2));
                        } else {
                            map2.put(str2, (r64) map.get(str2));
                        }
                    }
                    this.b.clear();
                    this.b.putAll(map2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (e00 | RuntimeException e) {
            throw new f00("Failed to create SupportedSurfaceCombination", e);
        }
    }

    public final r64 b(String str) {
        return new r64(this.e, str, this.d, this.c, Build.VERSION.SDK_INT >= 35 ? new rc1(this.e, str, this.d) : mc1.r);
    }
}
