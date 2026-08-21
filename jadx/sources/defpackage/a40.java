package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class a40 implements on1 {
    public final Object A;
    public Object X;
    public boolean b;
    public boolean f;
    public final Object z;

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a40(defpackage.ft0 r11, java.lang.String r12, java.lang.Class r13, java.lang.Class r14, java.lang.String r15) {
        /*
            r10 = this;
            r10.<init>()
            kt0 r0 = r11.C0
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L15
            ft0[] r4 = r0.Z
            int r5 = r4.length
            if (r5 != r2) goto L16
            r4 = r4[r3]
            boolean r4 = r4.y0
            if (r4 == 0) goto L16
        L15:
            r0 = r1
        L16:
            if (r0 == 0) goto L1a
            r0 = r2
            goto L1b
        L1a:
            r0 = r3
        L1b:
            r10.b = r0
            boolean r4 = r11.s()
            r10.f = r4
            r90 r5 = new r90
            r5.<init>()
            java.lang.String r6 = "get"
            java.lang.String r7 = defpackage.ha0.n(r6, r12)
            java.lang.Class[] r8 = new java.lang.Class[r3]
            java.lang.reflect.Method r7 = defpackage.yn1.y(r13, r7, r8)
            r5.a = r7
            java.lang.String r8 = defpackage.ha0.n(r6, r12)
            java.lang.Class[] r9 = new java.lang.Class[r3]
            java.lang.reflect.Method r8 = defpackage.yn1.y(r14, r8, r9)
            r5.b = r8
            java.lang.Class r7 = r7.getReturnType()
            java.lang.String r8 = "set"
            java.lang.String r8 = defpackage.ha0.n(r8, r12)
            java.lang.Class[] r2 = new java.lang.Class[r2]
            r2[r3] = r7
            java.lang.reflect.Method r2 = defpackage.yn1.y(r14, r8, r2)
            r5.c = r2
            java.lang.String r2 = "has"
            if (r4 == 0) goto L65
            java.lang.String r7 = defpackage.ha0.n(r2, r12)
            java.lang.Class[] r8 = new java.lang.Class[r3]
            java.lang.reflect.Method r7 = defpackage.yn1.y(r13, r7, r8)
            goto L66
        L65:
            r7 = r1
        L66:
            r5.d = r7
            if (r4 == 0) goto L75
            java.lang.String r2 = defpackage.ha0.n(r2, r12)
            java.lang.Class[] r4 = new java.lang.Class[r3]
            java.lang.reflect.Method r2 = defpackage.yn1.y(r14, r2, r4)
            goto L76
        L75:
            r2 = r1
        L76:
            r5.e = r2
            java.lang.String r2 = "clear"
            java.lang.String r12 = defpackage.ha0.n(r2, r12)
            java.lang.Class[] r2 = new java.lang.Class[r3]
            defpackage.yn1.y(r14, r12, r2)
            java.lang.String r12 = "Case"
            if (r0 == 0) goto L92
            java.lang.String r2 = defpackage.ha0.o(r6, r15, r12)
            java.lang.Class[] r4 = new java.lang.Class[r3]
            java.lang.reflect.Method r13 = defpackage.yn1.y(r13, r2, r4)
            goto L93
        L92:
            r13 = r1
        L93:
            r5.f = r13
            if (r0 == 0) goto La1
            java.lang.String r12 = defpackage.ha0.o(r6, r15, r12)
            java.lang.Class[] r13 = new java.lang.Class[r3]
            java.lang.reflect.Method r1 = defpackage.yn1.y(r14, r12, r13)
        La1:
            r5.g = r1
            r10.A = r11
            java.lang.Object r11 = r5.a
            java.lang.reflect.Method r11 = (java.lang.reflect.Method) r11
            java.lang.Class r11 = r11.getReturnType()
            r10.z = r11
            r10.X = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a40.<init>(ft0, java.lang.String, java.lang.Class, java.lang.Class, java.lang.String):void");
    }

    public boolean a(oi2 oi2Var) {
        int id = oi2Var.getId();
        HashSet hashSet = (HashSet) this.A;
        if (hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        oi2 oi2Var2 = (oi2) ((HashMap) this.z).get(Integer.valueOf(f()));
        if (oi2Var2 != null) {
            k(oi2Var2, false);
        }
        boolean zAdd = hashSet.add(Integer.valueOf(id));
        if (!oi2Var.isChecked()) {
            oi2Var.setChecked(true);
        }
        return zAdd;
    }

    @Override // defpackage.on1
    public boolean b(kn1 kn1Var) {
        ft0 ft0Var = (ft0) this.A;
        r90 r90Var = (r90) this.X;
        return !this.f ? this.b ? ((g12) yn1.B(kn1Var, (Method) r90Var.g, new Object[0])).a() == ft0Var.z.Z : !d(kn1Var).equals(ft0Var.k()) : ((Boolean) yn1.B(kn1Var, (Method) r90Var.e, new Object[0])).booleanValue();
    }

    public ArrayList c(ViewGroup viewGroup) {
        HashSet hashSet = new HashSet((HashSet) this.A);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof oi2) && hashSet.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    @Override // defpackage.on1
    public Object d(kn1 kn1Var) {
        return yn1.B(kn1Var, (Method) ((r90) this.X).b, new Object[0]);
    }

    @Override // defpackage.on1
    public Object e(yn1 yn1Var) {
        return yn1.B(yn1Var, (Method) ((r90) this.X).a, new Object[0]);
    }

    public int f() {
        HashSet hashSet = (HashSet) this.A;
        if (!this.b || hashSet.isEmpty()) {
            return -1;
        }
        return ((Integer) hashSet.iterator().next()).intValue();
    }

    @Override // defpackage.on1
    public boolean g(yn1 yn1Var) {
        ft0 ft0Var = (ft0) this.A;
        r90 r90Var = (r90) this.X;
        return !this.f ? this.b ? ((g12) yn1.B(yn1Var, (Method) r90Var.f, new Object[0])).a() == ft0Var.z.Z : !e(yn1Var).equals(ft0Var.k()) : ((Boolean) yn1.B(yn1Var, (Method) r90Var.d, new Object[0])).booleanValue();
    }

    @Override // defpackage.on1
    public a1 h() {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
    }

    public void i() {
        cp1 cp1Var = (cp1) this.X;
        if (cp1Var != null) {
            new HashSet((HashSet) this.A);
            ChipGroup chipGroup = (ChipGroup) cp1Var.f;
            s40 s40Var = chipGroup.A0;
            if (s40Var != null) {
                chipGroup.B0.c(chipGroup);
                ChipGroup chipGroup2 = (ChipGroup) ((w7) s40Var).f;
                if (chipGroup2.B0.b) {
                    chipGroup2.getCheckedChipId();
                    throw null;
                }
            }
        }
    }

    @Override // defpackage.on1
    public void j(kn1 kn1Var, Object obj) {
        yn1.B(kn1Var, (Method) ((r90) this.X).c, obj);
    }

    public boolean k(oi2 oi2Var, boolean z) {
        int id = oi2Var.getId();
        HashSet hashSet = (HashSet) this.A;
        if (!hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z && hashSet.size() == 1 && hashSet.contains(Integer.valueOf(id))) {
            oi2Var.setChecked(true);
            return false;
        }
        boolean zRemove = hashSet.remove(Integer.valueOf(id));
        if (oi2Var.isChecked()) {
            oi2Var.setChecked(false);
        }
        return zRemove;
    }

    @Override // defpackage.on1
    public void l(kn1 kn1Var, Object obj) {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
    }

    @Override // defpackage.on1
    public a1 o(kn1 kn1Var) {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
    }

    public a40(Context context, String str, t6 t6Var, boolean z, boolean z2) {
        context.getClass();
        t6Var.getClass();
        this.z = context;
        this.A = str;
        this.X = t6Var;
        this.b = z;
        this.f = z2;
    }

    public a40() {
        this.z = new HashMap();
        this.A = new HashSet();
    }
}
