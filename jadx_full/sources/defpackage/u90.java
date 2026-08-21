package defpackage;

import j$.util.Objects;
import j$.util.Optional;
import j$.util.function.Consumer$CC;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class u90 implements Iterator {
    public final ed4 X;
    public final ed4 Y;
    public final s03 b;
    public final u62 f;
    public int Z = 0;
    public final HashMap z = new HashMap();
    public final HashSet A = new HashSet();
    public final w7 y0 = new w7(18, this);

    public u90(uf4 uf4Var, s03 s03Var) {
        this.b = s03Var;
        this.f = (u62) ((v62) uf4Var.g).z;
        this.X = new ed4(s03Var, new int[]{1, 2});
        this.Y = new ed4(s03Var, new int[]{3});
    }

    public final ds2 a(Optional optional) {
        ds2 pp3Var;
        ed4 ed4Var = this.X;
        ed4Var.o();
        final HashSet hashSet = this.A;
        final int i = 0;
        optional.ifPresent(new Consumer() { // from class: s90
            @Override // java.util.function.Consumer
            /* JADX INFO: renamed from: accept */
            public final void n(Object obj) {
                int i2 = i;
                HashSet hashSet2 = hashSet;
                ds2 ds2Var = (ds2) obj;
                switch (i2) {
                    case 0:
                        hashSet2.add(ds2Var);
                        break;
                    default:
                        hashSet2.remove(ds2Var);
                        break;
                }
            }

            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i2 = i;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        s03 s03Var = this.b;
        final int i2 = 1;
        boolean zA = s03Var.a(1);
        ed4 ed4Var2 = this.Y;
        if (zA) {
            w6 w6Var = (w6) s03Var.next();
            f7 f7Var = w6Var.d;
            HashMap map = this.z;
            if (!map.containsKey(f7Var)) {
                throw new v90(0, "found undefined alias " + f7Var, w6Var.a);
            }
            pp3Var = (ds2) map.get(f7Var);
            if (pp3Var.a() != 1) {
                int i3 = this.Z + 1;
                this.Z = i3;
                if (i3 > 50) {
                    throw new hy4("Number of aliases for non-scalar nodes exceeds the specified max=50");
                }
            }
            if (hashSet.remove(pp3Var)) {
                pp3Var.c = true;
            }
            ed4Var.q();
            ed4Var2.o();
            ed4Var2.q();
        } else {
            Optional optional2 = ((fs2) s03Var.e()).c;
            if (s03Var.a(7)) {
                ed4Var.q();
                op3 op3Var = (op3) s03Var.next();
                Optional optional3 = op3Var.d;
                String str = op3Var.f;
                pp3Var = new pp3((optional3.isEmpty() || ((String) optional3.get()).equals("!")) ? this.f.b(str, Boolean.valueOf(op3Var.g.b)) : new oa4((String) optional3.get()), str, op3Var.e, op3Var.a);
                optional2.ifPresent(new t90(0, this, pp3Var));
                ed4Var2.o();
                ed4Var2.q();
            } else if (s03Var.a(9)) {
                vs3 vs3Var = (vs3) s03Var.next();
                Optional optional4 = vs3Var.d;
                int i4 = vs3Var.f;
                oa4 oa4Var = (optional4.isEmpty() || ((String) optional4.get()).equals("!")) ? oa4.j : new oa4((String) optional4.get());
                ArrayList arrayList = new ArrayList();
                Optional optional5 = vs3Var.a;
                Optional.empty();
                us3 us3Var = new us3(oa4Var, arrayList, i4, optional5);
                if (1 == i4) {
                    ed4Var.q();
                }
                optional2.ifPresent(new t90(2, this, us3Var));
                while (!s03Var.a(8)) {
                    ed4Var.o();
                    if (s03Var.a(8)) {
                        break;
                    }
                    arrayList.add(a(Optional.of(us3Var)));
                }
                if (1 == i4) {
                    ed4Var2.o();
                    ed4Var2.q();
                }
                Optional optional6 = s03Var.next().b;
                ed4Var2.o();
                if (!((ArrayList) ed4Var2.f).isEmpty()) {
                    ed4Var2.q();
                }
                pp3Var = us3Var;
            } else {
                eh2 eh2Var = (eh2) s03Var.next();
                Optional optional7 = eh2Var.d;
                int i5 = eh2Var.f;
                oa4 oa4Var2 = (optional7.isEmpty() || ((String) optional7.get()).equals("!")) ? oa4.k : new oa4((String) optional7.get());
                ArrayList arrayList2 = new ArrayList();
                Optional optional8 = eh2Var.a;
                Optional.empty();
                dh2 dh2Var = new dh2(oa4Var2, arrayList2, i5, optional8);
                if (1 == i5) {
                    ed4Var.q();
                }
                optional2.ifPresent(new t90(1, this, dh2Var));
                while (!s03Var.a(5)) {
                    ed4Var.o();
                    if (s03Var.a(5)) {
                        break;
                    }
                    ds2 ds2VarA = a(Optional.of(dh2Var));
                    if (ds2VarA.a() != 1) {
                        throw new hy4("Non scalar key is detected but it is not configured to be allowed.");
                    }
                    if (ds2VarA.b.equals(oa4.b)) {
                        dh2Var.f = true;
                    }
                    arrayList2.add(new hs2(ds2VarA, a(Optional.of(dh2Var))));
                }
                if (1 == i5) {
                    ed4Var2.o();
                    ed4Var2.q();
                }
                Optional optional9 = s03Var.next().b;
                ed4Var2.o();
                if (!((ArrayList) ed4Var2.f).isEmpty()) {
                    ed4Var2.q();
                }
                if (dh2Var.f) {
                    List list = dh2Var.e;
                    List<hs2> list2 = list;
                    boolean z = true;
                    List list3 = list;
                    while (z) {
                        ArrayList arrayList3 = new ArrayList(list2.size());
                        HashSet hashSet2 = new HashSet(list2.size());
                        ArrayList arrayList4 = new ArrayList(2);
                        for (hs2 hs2Var : list2) {
                            ds2 ds2Var = hs2Var.a;
                            if (ds2Var.b.equals(oa4.b)) {
                                arrayList4.add(hs2Var);
                            } else {
                                arrayList3.add(hs2Var);
                                if (ds2Var instanceof pp3) {
                                    hashSet2.add(((pp3) ds2Var).e);
                                }
                            }
                        }
                        Iterator it = arrayList4.iterator();
                        boolean z2 = false;
                        while (it.hasNext()) {
                            ds2 ds2Var2 = ((hs2) it.next()).b;
                            boolean z3 = ds2Var2 instanceof us3;
                            w7 w7Var = this.y0;
                            if (z3) {
                                Iterator it2 = ((us3) ds2Var2).e.iterator();
                                while (it2.hasNext()) {
                                    dh2 dh2VarL = w7Var.l((ds2) it2.next());
                                    z2 = z2 || dh2VarL.f;
                                    e24 e24VarP = w7.p(dh2VarL.e, hashSet2);
                                    arrayList3.addAll((ArrayList) e24VarP.f);
                                    hashSet2.addAll((HashSet) e24VarP.z);
                                }
                            } else {
                                dh2 dh2VarL2 = w7Var.l(ds2Var2);
                                z2 = z2 || dh2VarL2.f;
                                e24 e24VarP2 = w7.p(dh2VarL2.e, hashSet2);
                                arrayList3.addAll((ArrayList) e24VarP2.f);
                                hashSet2.addAll((HashSet) e24VarP2.z);
                            }
                        }
                        if (z2) {
                            list2 = arrayList3;
                        }
                        z = z2;
                        list3 = arrayList3;
                        list2 = list2;
                    }
                    Objects.requireNonNull(list3);
                    dh2Var.e = list3;
                    dh2Var.f = false;
                }
                pp3Var = dh2Var;
            }
        }
        optional.ifPresent(new Consumer() { // from class: s90
            @Override // java.util.function.Consumer
            /* JADX INFO: renamed from: accept */
            public final void n(Object obj) {
                int i22 = i2;
                HashSet hashSet22 = hashSet;
                ds2 ds2Var3 = (ds2) obj;
                switch (i22) {
                    case 0:
                        hashSet22.add(ds2Var3);
                        break;
                    default:
                        hashSet22.remove(ds2Var3);
                        break;
                }
            }

            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i2;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        return pp3Var;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final ds2 next() {
        ed4 ed4Var = this.X;
        ed4Var.o();
        s03 s03Var = this.b;
        if (s03Var.a(10)) {
            Optional optional = ((e80) ((ArrayList) ed4Var.q()).get(0)).a;
            List list = Collections.EMPTY_LIST;
            oa4 oa4Var = oa4.l;
            Optional.empty();
            return new dh2(oa4Var, list, 2, optional);
        }
        s03Var.next();
        ds2 ds2VarA = a(Optional.empty());
        ed4Var.o();
        if (!((ArrayList) ed4Var.f).isEmpty()) {
            ed4Var.q();
        }
        s03Var.next();
        this.z.clear();
        this.A.clear();
        this.Z = 0;
        return ds2VarA;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        s03 s03Var = this.b;
        if (s03Var.a(11)) {
            s03Var.next();
        }
        return !s03Var.a(10);
    }
}
