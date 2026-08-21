package defpackage;

import android.content.SharedPreferences;
import android.view.View;
import com.getsurfboard.backup.model.HostEntry;
import com.getsurfboard.backup.model.MetadataBackup;
import com.getsurfboard.backup.model.ProxyGroupSelectionEntry;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.DesugarCollections;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v92 implements z82 {
    public static final Object Y = new Object();
    public static v92 Z;
    public Object A;
    public Object X;
    public Object b;
    public Object f;
    public Object z;

    public v92(int i) {
        switch (i) {
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                this.X = l41.n;
                this.f = "GET";
                this.z = new m20(1);
                break;
            default:
                this.b = new Object();
                this.f = new HashMap();
                this.z = new HashMap();
                this.A = new ArrayDeque();
                break;
        }
    }

    public void a(pt ptVar, Class cls) {
        ((ArrayList) this.f).add(new e03(ptVar, cls));
    }

    public void b(fd1 fd1Var, Class cls) {
        ((ArrayList) this.A).add(new e03(fd1Var, cls));
    }

    @Override // defpackage.z82
    public boolean c() {
        return ((iq4) this.X) != null;
    }

    public void d(s92 s92Var, r90 r90Var, ow owVar) {
        synchronized (this.b) {
            try {
                boolean z = true;
                r25.e(!((List) r90Var.e).isEmpty());
                this.X = owVar;
                da2 da2VarJ = s92Var.j();
                u92 u92VarI = i(da2VarJ);
                if (u92VarI == null) {
                    return;
                }
                Set set = (Set) ((HashMap) this.z).get(u92VarI);
                ow owVar2 = (ow) this.X;
                if (owVar2 == null || owVar2.b() != 2) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        s92 s92Var2 = (s92) ((HashMap) this.f).get((ah) it.next());
                        s92Var2.getClass();
                        if (!s92Var2.equals(s92Var) && !s92Var2.t().isEmpty()) {
                            s92Var2.v();
                            throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner. Please unbind first.");
                        }
                    }
                }
                try {
                    s92Var.e(r90Var);
                    if (da2VarJ.getLifecycle().b().compareTo(q92.A) < 0) {
                        z = false;
                    }
                    if (z) {
                        p(da2VarJ);
                    }
                } catch (h00 e) {
                    throw new IllegalArgumentException(e);
                }
            } finally {
            }
        }
    }

    public fh e() {
        String strConcat = ((dn0) this.b) == null ? " surface" : "";
        if (((List) this.f) == null) {
            strConcat = strConcat.concat(" sharedSurfaces");
        }
        if (((Integer) this.z) == null) {
            strConcat = strConcat.concat(" mirrorMode");
        }
        if (((Integer) this.A) == null) {
            strConcat = strConcat.concat(" surfaceGroupId");
        }
        if (((oz0) this.X) == null) {
            strConcat = strConcat.concat(" dynamicRange");
        }
        if (strConcat.isEmpty()) {
            return new fh((dn0) this.b, (List) this.f, ((Integer) this.z).intValue(), ((Integer) this.A).intValue(), (oz0) this.X);
        }
        xe.q("Missing required properties:".concat(strConcat));
        return null;
    }

    public void f(ku kuVar) {
        kuVar.getClass();
        String string = kuVar.toString();
        if (string.length() == 0) {
            ((m20) this.z).a("Cache-Control");
        } else {
            l("Cache-Control", string);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void g(mz mzVar, mz mzVar2, c74 c74Var, c74 c74Var2, Map.Entry entry) {
        c74 c74Var3 = (c74) entry.getValue();
        ez4.o("DualSurfaceProcessorNode", "     -> outputEdge = " + c74Var3);
        lh lhVar = new lh(c74Var.g.a, ((rg) entry.getKey()).a.d, c74Var.c ? mzVar : null, ((rg) entry.getKey()).a.f, ((rg) entry.getKey()).a.g);
        lh lhVar2 = new lh(c74Var2.g.a, ((rg) entry.getKey()).b.d, c74Var2.c ? mzVar2 : null, ((rg) entry.getKey()).b.f, ((rg) entry.getKey()).b.g);
        int i = ((rg) entry.getKey()).a.c;
        c74Var3.getClass();
        co4.h();
        c74Var3.a();
        r25.j("Consumer can only be linked once.", !c74Var3.j);
        c74Var3.j = true;
        b74 b74Var = c74Var3.l;
        r20 r20VarW = n12.W(b74Var.c(), new a74(c74Var3, b74Var, i, lhVar, lhVar2), vf2.q());
        r20VarW.a(new um1((int) (0 == true ? 1 : 0), (Object) r20VarW, (Object) new eg0(7, (Object) this, (Object) c74Var3, false)), vf2.q());
    }

    @Override // defpackage.z82
    public Object getValue() {
        iq4 iq4Var = (iq4) this.X;
        if (iq4Var != null) {
            return iq4Var;
        }
        oq4 oq4Var = (oq4) ((pl1) this.f).a();
        mq4 mq4Var = (mq4) ((pl1) this.z).a();
        dg0 dg0Var = (dg0) ((pl1) this.A).a();
        oq4Var.getClass();
        mq4Var.getClass();
        dg0Var.getClass();
        ih4 ih4Var = new ih4(oq4Var, mq4Var, dg0Var);
        j50 j50Var = (j50) this.b;
        String strB = j50Var.b();
        if (strB == null) {
            xe.k("Local and anonymous classes can not be ViewModels");
            return null;
        }
        iq4 iq4VarA = ih4Var.a(j50Var, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strB));
        this.X = iq4VarA;
        return iq4VarA;
    }

    public s92 h(da2 da2Var, j00 j00Var) {
        synchronized (this.b) {
            try {
                r25.f(((HashMap) this.f).get(new ah(System.identityHashCode(da2Var), j00Var.A)) == null, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
                s92 s92Var = new s92(da2Var, j00Var);
                if (((ArrayList) j00Var.C()).isEmpty()) {
                    s92Var.w();
                }
                if (da2Var.getLifecycle().b() == q92.b) {
                    return s92Var;
                }
                n(s92Var);
                return s92Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public u92 i(da2 da2Var) {
        synchronized (this.b) {
            try {
                for (u92 u92Var : ((HashMap) this.z).keySet()) {
                    if (da2Var.equals(u92Var.f)) {
                        return u92Var;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Collection j() {
        Collection collectionUnmodifiableCollection;
        synchronized (this.b) {
            collectionUnmodifiableCollection = DesugarCollections.unmodifiableCollection(((HashMap) this.f).values());
        }
        return collectionUnmodifiableCollection;
    }

    public boolean k(da2 da2Var) {
        synchronized (this.b) {
            try {
                u92 u92VarI = i(da2Var);
                if (u92VarI == null) {
                    return false;
                }
                Iterator it = ((Set) ((HashMap) this.z).get(u92VarI)).iterator();
                while (it.hasNext()) {
                    s92 s92Var = (s92) ((HashMap) this.f).get((ah) it.next());
                    s92Var.getClass();
                    if (!s92Var.t().isEmpty()) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void l(String str, String str2) {
        str2.getClass();
        m20 m20Var = (m20) this.z;
        m20Var.getClass();
        gb4.O(str);
        gb4.P(str2, str);
        m20Var.a(str);
        gb4.x(m20Var, str, str2);
    }

    public void m(String str, ej3 ej3Var) {
        str.getClass();
        if (str.length() <= 0) {
            xe.k("method.isEmpty() == true");
            return;
        }
        if (ej3Var == null) {
            if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("QUERY") || str.equals("REPORT")) {
                e04.f(ha0.o("method ", str, " must have a request body."));
                return;
            }
        } else if (!ek0.z(str)) {
            e04.f(ha0.o("method ", str, " must not have a request body."));
            return;
        }
        this.f = str;
        this.A = ej3Var;
    }

    public void n(s92 s92Var) {
        synchronized (this.b) {
            try {
                da2 da2VarJ = s92Var.j();
                ah ahVar = new ah(System.identityHashCode(da2VarJ), s92Var.z.A);
                u92 u92VarI = i(da2VarJ);
                Set hashSet = u92VarI != null ? (Set) ((HashMap) this.z).get(u92VarI) : new HashSet();
                hashSet.add(ahVar);
                ((HashMap) this.f).put(ahVar, s92Var);
                if (u92VarI == null) {
                    u92 u92Var = new u92(da2VarJ, this);
                    ((HashMap) this.z).put(u92Var, hashSet);
                    da2VarJ.getLifecycle().a(u92Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o(Object obj, String str) {
        str.getClass();
        ((LinkedHashMap) this.b).put(str, obj);
        m24 m24Var = (m24) ((LinkedHashMap) this.z).get(str);
        br1 br1Var = at2.a;
        if (m24Var != null) {
            m24Var.j(null, obj == null ? br1Var : obj);
        }
        m24 m24Var2 = (m24) ((LinkedHashMap) this.A).get(str);
        if (m24Var2 != null) {
            if (obj == null) {
                obj = br1Var;
            }
            m24Var2.j(null, obj);
        }
    }

    public void p(da2 da2Var) {
        synchronized (this.b) {
            try {
                if (k(da2Var)) {
                    if (((ArrayDeque) this.A).isEmpty()) {
                        ((ArrayDeque) this.A).push(da2Var);
                    } else {
                        ow owVar = (ow) this.X;
                        if (owVar == null || owVar.b() != 2) {
                            da2 da2Var2 = (da2) ((ArrayDeque) this.A).peek();
                            if (!da2Var.equals(da2Var2)) {
                                r(da2Var2);
                                ((ArrayDeque) this.A).remove(da2Var);
                                ((ArrayDeque) this.A).push(da2Var);
                            }
                        }
                    }
                    v(da2Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void q(da2 da2Var) {
        synchronized (this.b) {
            try {
                ((ArrayDeque) this.A).remove(da2Var);
                r(da2Var);
                if (!((ArrayDeque) this.A).isEmpty()) {
                    v((da2) ((ArrayDeque) this.A).peek());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void r(da2 da2Var) {
        synchronized (this.b) {
            try {
                u92 u92VarI = i(da2Var);
                if (u92VarI == null) {
                    return;
                }
                Iterator it = ((Set) ((HashMap) this.z).get(u92VarI)).iterator();
                while (it.hasNext()) {
                    s92 s92Var = (s92) ((HashMap) this.f).get((ah) it.next());
                    s92Var.getClass();
                    s92Var.w();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void s(HashSet hashSet) {
        Set setKeySet = hashSet;
        synchronized (this.b) {
            if (hashSet == null) {
                try {
                    setKeySet = ((HashMap) this.f).keySet();
                } catch (Throwable th) {
                    throw th;
                }
            }
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                s92 s92Var = (s92) ((HashMap) this.f).get((ah) it.next());
                if (s92Var != null) {
                    s92Var.x();
                    q(s92Var.j());
                }
            }
        }
    }

    public void t(s92 s92Var) {
        synchronized (this.b) {
            try {
                da2 da2VarJ = s92Var.j();
                ah ahVar = new ah(System.identityHashCode(da2VarJ), s92Var.z.A);
                ((HashMap) this.f).remove(ahVar);
                HashSet hashSet = new HashSet();
                for (u92 u92Var : ((HashMap) this.z).keySet()) {
                    if (da2VarJ.equals(u92Var.f)) {
                        Set set = (Set) ((HashMap) this.z).get(u92Var);
                        set.remove(ahVar);
                        if (set.isEmpty()) {
                            hashSet.add(u92Var.f);
                        }
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    u((da2) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void u(da2 da2Var) {
        synchronized (this.b) {
            try {
                u92 u92VarI = i(da2Var);
                if (u92VarI == null) {
                    return;
                }
                q(da2Var);
                Iterator it = ((Set) ((HashMap) this.z).get(u92VarI)).iterator();
                while (it.hasNext()) {
                    ((HashMap) this.f).remove((ah) it.next());
                }
                ((HashMap) this.z).remove(u92VarI);
                u92VarI.f.getLifecycle().c(u92VarI);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void v(da2 da2Var) {
        synchronized (this.b) {
            try {
                Iterator it = ((Set) ((HashMap) this.z).get(i(da2Var))).iterator();
                while (it.hasNext()) {
                    s92 s92Var = (s92) ((HashMap) this.f).get((ah) it.next());
                    s92Var.getClass();
                    if (!s92Var.t().isEmpty()) {
                        s92Var.y();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void w(String str) {
        str.getClass();
        if (w44.j0(str, "ws:", true)) {
            str = "http:".concat(str.substring(3));
        } else if (w44.j0(str, "wss:", true)) {
            str = "https:".concat(str.substring(4));
        }
        dv1 dv1Var = new dv1();
        dv1Var.c(null, str);
        this.b = dv1Var.a();
    }

    public void x(MetadataBackup metadataBackup, gr3 gr3Var) {
        metadataBackup.getClass();
        os1 os1Var = (os1) this.f;
        List<ls1> listA = os1Var.a();
        pl3 pl3Var = os1Var.a;
        List<HostEntry> hosts = metadataBackup.getHosts();
        ArrayList arrayList = new ArrayList(f70.Q(10, hosts));
        for (HostEntry hostEntry : hosts) {
            arrayList.add(new ls1(hostEntry.getKey(), 0, hostEntry.getValue()));
        }
        gj gjVar = new gj(6, os1Var, arrayList);
        int i = 1;
        ke0.r(pl3Var, false, true, gjVar);
        for (ls1 ls1Var : listA) {
            ls1Var.getClass();
            ke0.r(pl3Var, false, true, new ms1(os1Var, ls1Var, i));
        }
        gr3Var.b = metadataBackup.getHosts().size() + gr3Var.b;
    }

    public void y(MetadataBackup metadataBackup, gr3 gr3Var) {
        ji jiVar = (ji) this.A;
        metadataBackup.getClass();
        List list = gr3Var.c;
        String selectedProfile = metadataBackup.getSelectedProfile();
        if (selectedProfile != null) {
            if (((Boolean) jiVar.g(selectedProfile)).booleanValue()) {
                ((ji) this.X).g(selectedProfile);
                gr3Var.b++;
            } else {
                list.add("metadata: selected profile " + selectedProfile + " does not exist");
            }
        }
        Set<String> pinnedProfiles = metadataBackup.getPinnedProfiles();
        ArrayList arrayList = new ArrayList();
        for (Object obj : pinnedProfiles) {
            if (((Boolean) jiVar.g(obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        Iterator it = yr2.S(metadataBackup.getPinnedProfiles(), d70.C0(arrayList)).iterator();
        while (it.hasNext()) {
            list.add("metadata: pinned profile " + ((String) it.next()) + " does not exist");
        }
        SharedPreferences.Editor editorEdit = ((SharedPreferences) this.z).edit();
        editorEdit.putStringSet("pinned_profile_list", d70.C0(arrayList));
        editorEdit.apply();
        for (ProxyGroupSelectionEntry proxyGroupSelectionEntry : metadataBackup.getProxyGroupSelections()) {
            if (((Boolean) jiVar.g(proxyGroupSelectionEntry.getProfileName())).booleanValue()) {
                ua3 ua3Var = (ua3) this.b;
                ke0.r(ua3Var.a, false, true, new gj(16, ua3Var, new sa3[]{new sa3(proxyGroupSelectionEntry.getProfileName(), proxyGroupSelectionEntry.getGroupName(), proxyGroupSelectionEntry.getSelection())}));
                gr3Var.b++;
            } else {
                list.add("metadata: selections for " + proxyGroupSelectionEntry.getProfileName() + " skipped, profile does not exist");
            }
        }
    }

    public v92(Map map) {
        map.getClass();
        this.b = new LinkedHashMap(map);
        this.f = new LinkedHashMap();
        this.z = new LinkedHashMap();
        this.A = new LinkedHashMap();
        this.X = new c90(3, this);
    }

    public v92(up3 up3Var, fu fuVar, fu fuVar2) {
        this.b = up3Var;
        this.f = fuVar;
        this.z = fuVar2;
    }

    public v92(j50 j50Var, pl1 pl1Var, pl1 pl1Var2, pl1 pl1Var3) {
        this.b = j50Var;
        this.f = pl1Var;
        this.z = pl1Var2;
        this.A = pl1Var3;
    }

    public /* synthetic */ v92(View view, View view2, View view3, View view4, View view5) {
        this.b = view;
        this.f = view2;
        this.z = view3;
        this.A = view4;
        this.X = view5;
    }
}
