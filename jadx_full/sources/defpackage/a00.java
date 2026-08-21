package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a00 implements k12 {
    public final Object a = new Object();
    public final LinkedHashMap b = new LinkedHashMap();
    public final HashSet c = new HashSet();
    public yv d;
    public vv e;
    public rw f;

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
                map.put(str, this.f.c(str));
            }
            synchronized (this.a) {
                try {
                    HashSet hashSet2 = new HashSet(this.b.keySet());
                    hashSet2.removeAll(list);
                    ArrayList<mz> arrayList = new ArrayList();
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        arrayList.add((mz) this.b.get((String) it.next()));
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (String str2 : (ArrayList) list) {
                        if (this.b.containsKey(str2)) {
                            linkedHashMap.put(str2, (mz) this.b.get(str2));
                        } else {
                            linkedHashMap.put(str2, (mz) map.get(str2));
                        }
                    }
                    this.b.clear();
                    this.b.putAll(linkedHashMap);
                    for (mz mzVar : arrayList) {
                        if (mzVar != null) {
                            mzVar.o();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (e00 e) {
            throw new f00("Failed to create CameraInternal", e);
        }
    }

    public final mz b(String str) {
        mz mzVar;
        synchronized (this.a) {
            try {
                mzVar = (mz) this.b.get(str);
                if (mzVar == null) {
                    throw new IllegalArgumentException("Invalid camera: " + str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mzVar;
    }

    public final LinkedHashSet c() {
        LinkedHashSet linkedHashSet;
        synchronized (this.a) {
            linkedHashSet = new LinkedHashSet(this.b.values());
        }
        return linkedHashSet;
    }

    public final void d(rw rwVar) {
        this.f = rwVar;
        synchronized (this.a) {
            try {
                for (String str : rwVar.a()) {
                    ez4.o("CameraRepository", "Added camera: " + str);
                    mz mzVar = (mz) this.b.put(str, rwVar.c(str));
                    if (mzVar != null) {
                        mzVar.release();
                    }
                }
            } catch (e00 e) {
                throw new c02(e);
            }
        }
    }
}
