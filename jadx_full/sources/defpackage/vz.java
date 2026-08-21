package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vz implements du2 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ vz(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.du2
    public final void a(Object obj) {
        rw rwVar;
        List list;
        switch (this.a) {
            case 0:
                List list2 = (List) obj;
                if (((wz) this.b).h.get() && (rwVar = ((wz) this.b).c) != null) {
                    if (list2 != null) {
                        ArrayList arrayList = new ArrayList(f70.Q(10, list2));
                        Iterator it = list2.iterator();
                        while (true) {
                            list = arrayList;
                            if (it.hasNext()) {
                                arrayList.add(((jz) it.next()).a());
                            }
                        }
                    } else {
                        list = g41.b;
                    }
                    try {
                        rwVar.e(list);
                        LinkedHashSet<String> linkedHashSetA = rwVar.a();
                        ArrayList arrayList2 = new ArrayList(f70.Q(10, linkedHashSetA));
                        for (String str : linkedHashSetA) {
                            str.getClass();
                            arrayList2.add(new jz(e70.L(str), null));
                        }
                        wz wzVar = (wz) this.b;
                        List listY0 = d70.y0(wzVar.g);
                        if (!arrayList2.equals(listY0)) {
                            Set setC0 = d70.C0(listY0);
                            Set setC02 = d70.C0(arrayList2);
                            Set setS = yr2.S(setC02, setC0);
                            Set setS2 = yr2.S(setC0, setC02);
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList(f70.Q(10, arrayList2));
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                arrayList4.add(((jz) it2.next()).a());
                            }
                            try {
                                Iterator it3 = setS2.iterator();
                                while (it3.hasNext()) {
                                    wzVar.c(((jz) it3.next()).a());
                                }
                                a00 a00Var = wzVar.d;
                                if (a00Var != null) {
                                    ez4.o("CameraPresencePrvdr", "Updating CameraRepository...");
                                    a00Var.a(arrayList4);
                                    arrayList3.add(a00Var);
                                    ez4.o("CameraPresencePrvdr", "CameraRepository updated successfully.");
                                }
                                if (!wzVar.i.isEmpty()) {
                                    ez4.o("CameraPresencePrvdr", "Updating " + wzVar.i.size() + " dependent listeners...");
                                    for (k12 k12Var : wzVar.i) {
                                        k12Var.a(arrayList4);
                                        arrayList3.add(k12Var);
                                    }
                                }
                                wzVar.g = arrayList2;
                                Iterator it4 = setS.iterator();
                                while (it4.hasNext()) {
                                    wzVar.a(((jz) it4.next()).a());
                                }
                                wzVar.b(setS, setS2);
                                break;
                            } catch (Exception e) {
                                ez4.r("CameraPresencePrvdr", "A core module failed to update. Rolling back changes.", e);
                                ArrayList arrayList5 = new ArrayList(f70.Q(10, listY0));
                                Iterator it5 = listY0.iterator();
                                while (it5.hasNext()) {
                                    arrayList5.add(((jz) it5.next()).a());
                                }
                                Iterator it6 = new gl3(arrayList3).iterator();
                                while (true) {
                                    fl3 fl3Var = (fl3) it6;
                                    if (!fl3Var.b.hasPrevious()) {
                                        Iterator it7 = setS2.iterator();
                                        while (it7.hasNext()) {
                                            wzVar.a(((jz) it7.next()).a());
                                        }
                                        Iterator it8 = setS.iterator();
                                        while (it8.hasNext()) {
                                            wzVar.c(((jz) it8.next()).a());
                                        }
                                        return;
                                    }
                                    k12 k12Var2 = (k12) fl3Var.b.previous();
                                    try {
                                        k12Var2.a(arrayList5);
                                    } catch (Exception e2) {
                                        ez4.r("CameraPresencePrvdr", "Failed to rollback listener: " + k12Var2, e2);
                                    }
                                }
                            }
                        }
                    } catch (Exception e3) {
                        ez4.r("CameraPresencePrvdr", "CameraFactory failed to update. Triggering refresh.", e3);
                        tx txVar = ((wz) this.b).e;
                        if (txVar != null) {
                            txVar.b();
                            return;
                        }
                        return;
                    }
                }
                break;
            default:
                ((dd0) this.b).accept(obj);
                break;
        }
    }

    @Override // defpackage.du2
    public final void onError(Throwable th) {
        switch (this.a) {
            case 0:
                th.getClass();
                wz wzVar = (wz) this.b;
                if (wzVar.h.get()) {
                    ez4.r("CameraPresencePrvdr", "Error from source camera presence observable. Triggering refresh.", th);
                    tx txVar = wzVar.e;
                    if (txVar != null) {
                        txVar.b();
                    }
                    break;
                }
                break;
            default:
                ez4.r("ObserverToConsumerAdapter", "Unexpected error in Observable", th);
                break;
        }
    }
}
