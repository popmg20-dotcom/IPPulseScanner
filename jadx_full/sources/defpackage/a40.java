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
    */
    public a40(ft0 ft0Var, String str, Class cls, Class cls2, String str2) {
        kt0 kt0Var = ft0Var.C0;
        if (kt0Var != null) {
            ft0[] ft0VarArr = kt0Var.Z;
            if (ft0VarArr.length == 1 && ft0VarArr[0].y0) {
                kt0Var = null;
            }
        }
        boolean z = kt0Var != null;
        this.b = z;
        boolean zS = ft0Var.s();
        this.f = zS;
        r90 r90Var = new r90();
        Method methodY = yn1.y(cls, ha0.n("get", str), new Class[0]);
        r90Var.a = methodY;
        r90Var.b = yn1.y(cls2, ha0.n("get", str), new Class[0]);
        r90Var.c = yn1.y(cls2, ha0.n("set", str), methodY.getReturnType());
        r90Var.d = zS ? yn1.y(cls, ha0.n("has", str), new Class[0]) : null;
        r90Var.e = zS ? yn1.y(cls2, ha0.n("has", str), new Class[0]) : null;
        yn1.y(cls2, ha0.n("clear", str), new Class[0]);
        r90Var.f = z ? yn1.y(cls, ha0.o("get", str2, "Case"), new Class[0]) : null;
        r90Var.g = z ? yn1.y(cls2, ha0.o("get", str2, "Case"), new Class[0]) : null;
        this.A = ft0Var;
        this.z = ((Method) r90Var.a).getReturnType();
        this.X = r90Var;
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
