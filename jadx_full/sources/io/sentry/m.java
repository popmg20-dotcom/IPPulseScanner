package io.sentry;

import defpackage.st4;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m implements d1 {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public m(j7 j7Var, Double d) {
        this.a = 1;
        this.b = j7Var;
        this.c = d;
        this.d = Collections.EMPTY_MAP;
    }

    @Override // io.sentry.d1
    public io.sentry.protocol.e A() {
        d1 d1Var = (d1) this.b;
        return new k(d1Var.A(), ((d1) this.c).A(), ((d1) this.d).A(), d1Var.getOptions().getDefaultScopeType());
    }

    @Override // io.sentry.d1
    public x3 B(c4 c4Var) {
        return b(null).B(c4Var);
    }

    @Override // io.sentry.d1
    public String C() {
        String strC = ((d1) this.d).C();
        if (strC != null) {
            return strC;
        }
        String strC2 = ((d1) this.c).C();
        return strC2 != null ? strC2 : ((d1) this.b).C();
    }

    @Override // io.sentry.d1
    public void D(e4 e4Var) {
        b(null).D(e4Var);
    }

    @Override // io.sentry.d1
    public void E(io.sentry.protocol.w wVar) {
        ((d1) this.b).E(wVar);
        ((d1) this.c).E(wVar);
        ((d1) this.d).E(wVar);
    }

    @Override // io.sentry.d1
    public void F(p1 p1Var) {
        b(null).F(p1Var);
    }

    @Override // io.sentry.d1
    public List G() {
        List listG = ((d1) this.d).G();
        if (!listG.isEmpty()) {
            return listG;
        }
        List listG2 = ((d1) this.c).G();
        return !listG2.isEmpty() ? listG2 : ((d1) this.b).G();
    }

    @Override // io.sentry.d1
    public io.sentry.protocol.j0 H() {
        io.sentry.protocol.j0 j0VarH = ((d1) this.d).H();
        if (j0VarH != null) {
            return j0VarH;
        }
        io.sentry.protocol.j0 j0VarH2 = ((d1) this.c).H();
        return j0VarH2 != null ? j0VarH2 : ((d1) this.b).H();
    }

    @Override // io.sentry.d1
    public io.sentry.protocol.r I() {
        io.sentry.protocol.r rVarI = ((d1) this.d).I();
        if (rVarI != null) {
            return rVarI;
        }
        io.sentry.protocol.r rVarI2 = ((d1) this.c).I();
        return rVarI2 != null ? rVarI2 : ((d1) this.b).I();
    }

    @Override // io.sentry.d1
    public List J() {
        return io.sentry.util.b.w((CopyOnWriteArrayList) x());
    }

    @Override // io.sentry.d1
    public String K() {
        String strK = ((d1) this.d).K();
        if (strK != null) {
            return strK;
        }
        String strK2 = ((d1) this.c).K();
        return strK2 != null ? strK2 : ((d1) this.b).K();
    }

    @Override // io.sentry.d1
    public void L(x3 x3Var) {
        b(null).L(x3Var);
    }

    public Object a(Object obj, Object obj2, Object obj3) {
        int i = l.a[((d1) this.b).getOptions().getDefaultScopeType().ordinal()];
        return i != 2 ? i != 3 ? obj3 : obj : obj2;
    }

    public d1 b(j4 j4Var) {
        d1 d1Var = (d1) this.c;
        d1 d1Var2 = (d1) this.d;
        d1 d1Var3 = (d1) this.b;
        if (j4Var != null) {
            int i = l.a[j4Var.ordinal()];
            if (i == 1) {
                return d1Var2;
            }
            if (i == 2) {
                return d1Var;
            }
            if (i == 3) {
                return d1Var3;
            }
            if (i == 4) {
                return this;
            }
        }
        int i2 = l.a[d1Var3.getOptions().getDefaultScopeType().ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? d1Var2 : d1Var3 : d1Var : d1Var2;
    }

    @Override // io.sentry.d1
    public void c(g gVar, l0 l0Var) {
        b(null).c(gVar, l0Var);
    }

    @Override // io.sentry.d1
    public void clear() {
        b(null).clear();
    }

    @Override // io.sentry.d1
    public d1 clone() {
        return new m(0, (d1) this.b, ((d1) this.c).clone(), ((d1) this.d).clone());
    }

    @Override // io.sentry.d1
    public io.sentry.protocol.j d() {
        return n().d();
    }

    @Override // io.sentry.d1
    public io.sentry.protocol.w g() {
        io.sentry.protocol.w wVarG = ((d1) this.d).g();
        io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
        if (!wVar.equals(wVarG)) {
            return wVarG;
        }
        io.sentry.protocol.w wVarG2 = ((d1) this.c).g();
        return !wVar.equals(wVarG2) ? wVarG2 : ((d1) this.b).g();
    }

    @Override // io.sentry.d1
    public Map getAttributes() {
        Map attributes = ((d1) this.b).getAttributes();
        Map attributes2 = ((d1) this.c).getAttributes();
        Map attributes3 = ((d1) this.d).getAttributes();
        boolean zIsEmpty = attributes.isEmpty();
        boolean zIsEmpty2 = attributes2.isEmpty();
        boolean zIsEmpty3 = attributes3.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            return (Map) a(attributes, attributes2, attributes3);
        }
        if (zIsEmpty2 && zIsEmpty3) {
            return attributes;
        }
        if (zIsEmpty && zIsEmpty3) {
            return attributes2;
        }
        if (zIsEmpty && zIsEmpty2) {
            return attributes3;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(attributes);
        concurrentHashMap.putAll(attributes2);
        concurrentHashMap.putAll(attributes3);
        return concurrentHashMap;
    }

    @Override // io.sentry.d1
    public Map getExtras() {
        Map extras = ((d1) this.b).getExtras();
        Map extras2 = ((d1) this.c).getExtras();
        Map extras3 = ((d1) this.d).getExtras();
        boolean zIsEmpty = extras.isEmpty();
        boolean zIsEmpty2 = extras2.isEmpty();
        boolean zIsEmpty3 = extras3.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            return (Map) a(extras, extras2, extras3);
        }
        if (zIsEmpty2 && zIsEmpty3) {
            return extras;
        }
        if (zIsEmpty && zIsEmpty3) {
            return extras2;
        }
        if (zIsEmpty && zIsEmpty2) {
            return extras3;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(extras);
        concurrentHashMap.putAll(extras2);
        concurrentHashMap.putAll(extras3);
        return concurrentHashMap;
    }

    @Override // io.sentry.d1
    public p6 getOptions() {
        return ((d1) this.b).getOptions();
    }

    @Override // io.sentry.d1
    public void h(io.sentry.protocol.w wVar) {
        b(null).h(wVar);
    }

    @Override // io.sentry.d1
    public p1 i() {
        p1 p1VarI = ((d1) this.d).i();
        if (p1VarI != null) {
            return p1VarI;
        }
        p1 p1VarI2 = ((d1) this.c).i();
        return p1VarI2 != null ? p1VarI2 : ((d1) this.b).i();
    }

    @Override // io.sentry.d1
    public void j(String str, String str2) {
        b(null).j(str, str2);
    }

    @Override // io.sentry.d1
    public z6 k() {
        return b(null).k();
    }

    @Override // io.sentry.d1
    public io.sentry.internal.debugmeta.c l() {
        return b(null).l();
    }

    @Override // io.sentry.d1
    public void m() {
        b(null).m();
    }

    @Override // io.sentry.d1
    public io.sentry.featureflags.b n() {
        p6 options = ((d1) this.b).getOptions();
        io.sentry.featureflags.b bVarN = ((d1) this.b).n();
        io.sentry.featureflags.b bVarN2 = ((d1) this.c).n();
        io.sentry.featureflags.b bVarN3 = ((d1) this.d).n();
        io.sentry.featureflags.c cVar = io.sentry.featureflags.c.b;
        int maxFeatureFlags = options.getMaxFeatureFlags();
        if (maxFeatureFlags > 0) {
            io.sentry.featureflags.a aVar = bVarN instanceof io.sentry.featureflags.a ? (io.sentry.featureflags.a) bVarN : null;
            io.sentry.featureflags.a aVar2 = bVarN2 instanceof io.sentry.featureflags.a ? (io.sentry.featureflags.a) bVarN2 : null;
            io.sentry.featureflags.a aVar3 = bVarN3 instanceof io.sentry.featureflags.a ? (io.sentry.featureflags.a) bVarN3 : null;
            CopyOnWriteArrayList copyOnWriteArrayList = aVar == null ? null : aVar.b;
            CopyOnWriteArrayList copyOnWriteArrayList2 = aVar2 == null ? null : aVar2.b;
            CopyOnWriteArrayList copyOnWriteArrayList3 = aVar3 == null ? null : aVar3.b;
            int size = copyOnWriteArrayList == null ? 0 : copyOnWriteArrayList.size();
            int size2 = copyOnWriteArrayList2 == null ? 0 : copyOnWriteArrayList2.size();
            int size3 = copyOnWriteArrayList3 != null ? copyOnWriteArrayList3.size() : 0;
            if (size != 0 || size2 != 0 || size3 != 0) {
                int i = size - 1;
                int i2 = size2 - 1;
                int i3 = size3 - 1;
                if (copyOnWriteArrayList != null && i >= 0 && copyOnWriteArrayList.get(i) != null) {
                    st4.n();
                    return null;
                }
                if (copyOnWriteArrayList2 != null && i2 >= 0 && copyOnWriteArrayList2.get(i2) != null) {
                    st4.n();
                    return null;
                }
                if (copyOnWriteArrayList3 != null && i3 >= 0 && copyOnWriteArrayList3.get(i3) != null) {
                    st4.n();
                    return null;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(maxFeatureFlags);
                linkedHashMap.size();
                ArrayList arrayList = new ArrayList(linkedHashMap.values());
                Collections.reverse(arrayList);
                return new io.sentry.featureflags.a(maxFeatureFlags, new CopyOnWriteArrayList(arrayList));
            }
        }
        return cVar;
    }

    @Override // io.sentry.d1
    public n1 o() {
        n1 n1VarO = ((d1) this.d).o();
        if (n1VarO != null) {
            return n1VarO;
        }
        n1 n1VarO2 = ((d1) this.c).o();
        return n1VarO2 != null ? n1VarO2 : ((d1) this.b).o();
    }

    @Override // io.sentry.d1
    public z6 p() {
        z6 z6VarP = ((d1) this.d).p();
        if (z6VarP != null) {
            return z6VarP;
        }
        z6 z6VarP2 = ((d1) this.c).p();
        return z6VarP2 != null ? z6VarP2 : ((d1) this.b).p();
    }

    @Override // io.sentry.d1
    public Queue q() {
        Queue queueQ = ((d1) this.b).q();
        Queue queueQ2 = ((d1) this.c).q();
        d1 d1Var = (d1) this.d;
        Queue queueQ3 = d1Var.q();
        boolean zIsEmpty = queueQ.isEmpty();
        boolean zIsEmpty2 = queueQ2.isEmpty();
        boolean zIsEmpty3 = queueQ3.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            return (Queue) a(queueQ, queueQ2, queueQ3);
        }
        if (zIsEmpty2 && zIsEmpty3) {
            return queueQ;
        }
        if (zIsEmpty && zIsEmpty3) {
            return queueQ2;
        }
        if (zIsEmpty && zIsEmpty2) {
            return queueQ3;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(queueQ);
        arrayList.addAll(queueQ2);
        arrayList.addAll(queueQ3);
        Collections.sort(arrayList);
        Queue queueA = f4.a(d1Var.getOptions().getMaxBreadcrumbs());
        queueA.addAll(arrayList);
        return queueA;
    }

    @Override // io.sentry.d1
    public p5 r() {
        p5 p5VarR = ((d1) this.d).r();
        if (p5VarR != null) {
            return p5VarR;
        }
        p5 p5VarR2 = ((d1) this.c).r();
        return p5VarR2 != null ? p5VarR2 : ((d1) this.b).r();
    }

    @Override // io.sentry.d1
    public x3 s() {
        return b(null).s();
    }

    @Override // io.sentry.d1
    public z6 t(d4 d4Var) {
        return b(null).t(d4Var);
    }

    @Override // io.sentry.d1
    public void u(String str) {
        b(null).u(str);
    }

    @Override // io.sentry.d1
    public i1 v() {
        i1 i1VarV = ((d1) this.d).v();
        if (!(i1VarV instanceof d3)) {
            return i1VarV;
        }
        i1 i1VarV2 = ((d1) this.c).v();
        return !(i1VarV2 instanceof d3) ? i1VarV2 : ((d1) this.b).v();
    }

    @Override // io.sentry.d1
    public Map w() {
        Map mapW = ((d1) this.b).w();
        Map mapW2 = ((d1) this.c).w();
        Map mapW3 = ((d1) this.d).w();
        boolean zIsEmpty = mapW.isEmpty();
        boolean zIsEmpty2 = mapW2.isEmpty();
        boolean zIsEmpty3 = mapW3.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            return (Map) a(mapW, mapW2, mapW3);
        }
        if (zIsEmpty2 && zIsEmpty3) {
            return mapW;
        }
        if (zIsEmpty && zIsEmpty3) {
            return mapW2;
        }
        if (zIsEmpty && zIsEmpty2) {
            return mapW3;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(mapW);
        concurrentHashMap.putAll(mapW2);
        concurrentHashMap.putAll(mapW3);
        return concurrentHashMap;
    }

    @Override // io.sentry.d1
    public List x() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.addAll(((d1) this.b).x());
        copyOnWriteArrayList.addAll(((d1) this.c).x());
        copyOnWriteArrayList.addAll(((d1) this.d).x());
        Collections.sort(copyOnWriteArrayList);
        return copyOnWriteArrayList;
    }

    @Override // io.sentry.d1
    public List y() {
        List listY = ((d1) this.b).y();
        List listY2 = ((d1) this.c).y();
        List listY3 = ((d1) this.d).y();
        boolean zIsEmpty = listY.isEmpty();
        boolean zIsEmpty2 = listY2.isEmpty();
        boolean zIsEmpty3 = listY3.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            return (List) a(listY, listY2, listY3);
        }
        if (zIsEmpty2 && zIsEmpty3) {
            return listY;
        }
        if (zIsEmpty && zIsEmpty3) {
            return listY2;
        }
        if (zIsEmpty && zIsEmpty2) {
            return listY3;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.addAll(listY);
        copyOnWriteArrayList.addAll(listY2);
        copyOnWriteArrayList.addAll(listY3);
        return copyOnWriteArrayList;
    }

    @Override // io.sentry.d1
    public void z(f5 f5Var) {
        ((d1) this.b).z(f5Var);
    }

    public /* synthetic */ m(int i, Object obj, Object obj2, Object obj3) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8clone() {
        switch (this.a) {
            case 0:
                return clone();
            default:
                return super.clone();
        }
    }
}
