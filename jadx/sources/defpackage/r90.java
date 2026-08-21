package defpackage;

import android.util.Range;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.getsurfboard.R;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Member;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r90 implements j90 {
    public static final p90 h = new p90(0);
    public static final pm[] i = new pm[0];
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    public r90(ArrayList arrayList, List list) {
        Object next;
        String str;
        String str2;
        String str3;
        boolean zS;
        list.getClass();
        Object obj = ih.h;
        obj.getClass();
        this.a = list;
        this.b = obj;
        this.c = k41.b;
        this.d = g41.b;
        List listY0 = d70.y0(d70.B0(arrayList));
        this.e = listY0;
        this.f = new g10(9);
        ScheduledExecutorService scheduledExecutorServiceQ = vf2.q();
        scheduledExecutorServiceQ.getClass();
        this.g = scheduledExecutorServiceQ;
        if (!obj.equals(obj)) {
            Iterator it = listY0.iterator();
            while (it.hasNext()) {
                if (((in4) it.next()).e.b0()) {
                    xe.k("Can't set target frame rate on a UseCase (by Preview.Builder.setTargetFrameRate() or VideoCapture.Builder.setTargetFrameRate()) if the frame rate range has already been set in the SessionConfig.");
                    throw null;
                }
            }
        }
        List list2 = (List) this.d;
        Set set = (Set) this.c;
        if (set.isEmpty() && list2.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(f70.Q(10, set));
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((eq1) it2.next()).a());
        }
        for (xc1 xc1Var : d70.y0(d70.B0(arrayList2))) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : set) {
                if (((eq1) obj2).a() == xc1Var) {
                    arrayList3.add(obj2);
                }
            }
            if (arrayList3.size() > 1) {
                st4.o(arrayList3, "requiredFeatures has conflicting feature values: ");
                throw null;
            }
        }
        list2.getClass();
        if (d70.y0(d70.B0(list2)).size() != list2.size()) {
            ad0.f(list2, 41, "Duplicate values in preferredFeatures(");
            throw null;
        }
        LinkedHashSet linkedHashSetG0 = d70.g0(set, list2);
        if (!linkedHashSetG0.isEmpty()) {
            st4.o(linkedHashSetG0, "requiredFeatures and preferredFeatures have duplicate values: ");
            throw null;
        }
        for (in4 in4Var : (List) this.e) {
            d84 d84Var = qn4.f;
            d84Var.getClass();
            if (d84.i(in4Var) == qn4.Z) {
                throw new IllegalArgumentException((in4Var + " is not supported with feature group").toString());
            }
            String str4 = in4Var instanceof j43 ? "Preview" : in4Var instanceof xx1 ? "ImageCapture" : in4Var instanceof lx1 ? "ImageAnalysis" : j00.F(in4Var) ? "VideoCapture" : "UseCase";
            Iterator it3 = xc1.Y.iterator();
            while (true) {
                w0 w0Var = (w0) it3;
                if (!w0Var.hasNext()) {
                    next = null;
                    break;
                }
                next = w0Var.next();
                d84Var.getClass();
                int iOrdinal = ((xc1) next).ordinal();
                if (iOrdinal == 0) {
                    zS = in4Var.e.s();
                } else if (iOrdinal == 1) {
                    zS = in4Var.e.b0();
                } else if (iOrdinal == 2) {
                    zS = in4Var.e.K(mn4.l0) || in4Var.e.K(mn4.m0);
                } else {
                    if (iOrdinal != 3) {
                        g.d();
                        throw null;
                    }
                    zS = in4Var.e.K(yx1.X);
                }
                if (zS) {
                    break;
                }
            }
            xc1 xc1Var2 = (xc1) next;
            if (xc1Var2 != null) {
                StringBuilder sb = new StringBuilder("A ");
                sb.append(xc1Var2.name());
                sb.append(" value is set to ");
                sb.append(str4);
                sb.append(" despite using feature groups. Do not use APIs like ");
                sb.append(str4);
                sb.append(".Builder.");
                int iOrdinal2 = xc1Var2.ordinal();
                if (iOrdinal2 == 0) {
                    str = "setDynamicRange";
                } else if (iOrdinal2 == 1) {
                    str = "setTargetFrameRateRange";
                } else if (iOrdinal2 == 2) {
                    str = j00.F(in4Var) ? "setVideoStabilizationEnabled" : "setPreviewStabilizationEnabled";
                } else {
                    if (iOrdinal2 != 3) {
                        g.d();
                        throw null;
                    }
                    str = "setOutputFormat";
                }
                sb.append(str);
                sb.append(" while using feature groups. If ");
                int iOrdinal3 = xc1Var2.ordinal();
                if (iOrdinal3 == 0) {
                    str2 = "HDR";
                } else if (iOrdinal3 == 1) {
                    str2 = "60 FPS";
                } else if (iOrdinal3 == 2) {
                    str2 = "stabilization";
                } else {
                    if (iOrdinal3 != 3) {
                        g.d();
                        throw null;
                    }
                    str2 = "JPEG_R output format";
                }
                sb.append(str2);
                sb.append(" is required, instead set ");
                int iOrdinal4 = xc1Var2.ordinal();
                if (iOrdinal4 == 0) {
                    str3 = "GroupableFeature.HDR_HLG10";
                } else if (iOrdinal4 == 1) {
                    str3 = "GroupableFeature.FPS_60";
                } else if (iOrdinal4 == 2) {
                    str3 = "GroupableFeature.PREVIEW_STABILIZATION";
                } else {
                    if (iOrdinal4 != 3) {
                        g.d();
                        throw null;
                    }
                    str3 = "GroupableFeature.IMAGE_ULTRA_HDR";
                }
                e04.f(fw.y(sb, str3, " as either a required or preferred feature."));
                throw null;
            }
        }
        if (((List) this.a).isEmpty()) {
            return;
        }
        xe.k("Effects aren't supported with feature group yet");
        throw null;
    }

    public static r90 h(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_backup_export, (ViewGroup) null, false);
        int i2 = R.id.password;
        TextInputEditText textInputEditText = (TextInputEditText) vf2.l(viewInflate, R.id.password);
        if (textInputEditText != null) {
            i2 = R.id.password_layout;
            TextInputLayout textInputLayout = (TextInputLayout) vf2.l(viewInflate, R.id.password_layout);
            if (textInputLayout != null) {
                i2 = R.id.section_hosts;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) vf2.l(viewInflate, R.id.section_hosts);
                if (materialCheckBox != null) {
                    i2 = R.id.section_metadata;
                    MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) vf2.l(viewInflate, R.id.section_metadata);
                    if (materialCheckBox2 != null) {
                        i2 = R.id.section_profiles;
                        MaterialCheckBox materialCheckBox3 = (MaterialCheckBox) vf2.l(viewInflate, R.id.section_profiles);
                        if (materialCheckBox3 != null) {
                            i2 = R.id.section_settings;
                            MaterialCheckBox materialCheckBox4 = (MaterialCheckBox) vf2.l(viewInflate, R.id.section_settings);
                            if (materialCheckBox4 != null) {
                                r90 r90Var = new r90();
                                r90Var.a = (LinearLayout) viewInflate;
                                r90Var.b = textInputEditText;
                                r90Var.c = textInputLayout;
                                r90Var.d = materialCheckBox;
                                r90Var.e = materialCheckBox2;
                                r90Var.f = materialCheckBox3;
                                r90Var.g = materialCheckBox4;
                                return r90Var;
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        return null;
    }

    @Override // defpackage.j90
    public Set a(fc3 fc3Var) {
        da3 da3Var;
        synchronized (this) {
            da3Var = (e92) ((HashMap) this.c).get(fc3Var);
            if (da3Var == null) {
                da3Var = h;
            }
        }
        return (Set) da3Var.get();
    }

    @Override // defpackage.j90
    public da3 b(Class cls) {
        return c(fc3.a(cls));
    }

    @Override // defpackage.j90
    public synchronized da3 c(fc3 fc3Var) {
        return (da3) ((HashMap) this.b).get(fc3Var);
    }

    @Override // defpackage.j90
    public Object d(fc3 fc3Var) {
        da3 da3VarC = c(fc3Var);
        if (da3VarC == null) {
            return null;
        }
        return da3VarC.get();
    }

    public ih e() {
        String strConcat = ((Size) this.a) == null ? " resolution" : "";
        if (((Size) this.b) == null) {
            strConcat = strConcat.concat(" originalConfiguredResolution");
        }
        if (((oz0) this.c) == null) {
            strConcat = strConcat.concat(" dynamicRange");
        }
        if (((Integer) this.d) == null) {
            strConcat = strConcat.concat(" sessionType");
        }
        if (((Range) this.e) == null) {
            strConcat = strConcat.concat(" expectedFrameRateRange");
        }
        if (((Boolean) this.g) == null) {
            strConcat = strConcat.concat(" zslDisabled");
        }
        if (strConcat.isEmpty()) {
            return new ih((Size) this.a, (Size) this.b, (oz0) this.c, ((Integer) this.d).intValue(), (Range) this.e, (ka0) this.f, ((Boolean) this.g).booleanValue());
        }
        xe.q("Missing required properties:".concat(strConcat));
        return null;
    }

    public qm f() {
        pm[] pmVarArr;
        if (((c9) this.f) != null && ((bt3) this.b).f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            c9 c9Var = (c9) this.f;
            boolean zF = ((bt3) this.b).f(ah2.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
            Member memberQ = c9Var.Q();
            if (memberQ != null) {
                n50.d(memberQ, zF);
            }
        }
        List list = (List) this.c;
        if (list == null || list.isEmpty()) {
            if (((wt2) this.g) == null) {
                return null;
            }
            pmVarArr = i;
        } else {
            List list2 = (List) this.c;
            pmVarArr = (pm[]) list2.toArray(new pm[list2.size()]);
            if (((bt3) this.b).f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                for (pm pmVar : pmVarArr) {
                    pmVar.h((bt3) this.b);
                }
            }
        }
        pm[] pmVarArr2 = (pm[]) this.d;
        if (pmVarArr2 == null || pmVarArr2.length == ((List) this.c).size()) {
            return new qm((nj4) ((ul) this.a).b, this, pmVarArr, (pm[]) this.d);
        }
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", Integer.valueOf(((List) this.c).size()), Integer.valueOf(((pm[]) this.d).length)));
    }

    public void g(HashMap map, boolean z) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : map.entrySet()) {
            x80 x80Var = (x80) entry.getKey();
            da3 da3Var = (da3) entry.getValue();
            int i2 = x80Var.d;
            if (i2 == 1 || (i2 == 2 && z)) {
                da3Var.get();
            }
        }
        y51 y51Var = (y51) this.e;
        synchronized (y51Var) {
            try {
                arrayDeque = y51Var.b;
                if (arrayDeque != null) {
                    y51Var.b = null;
                } else {
                    arrayDeque = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            if (it.hasNext()) {
                throw dw2.z(it);
            }
        }
    }

    @Override // defpackage.j90
    public Object get(Class cls) {
        return d(fc3.a(cls));
    }

    public void i() {
        for (x80 x80Var : ((HashMap) this.a).keySet()) {
            for (ho0 ho0Var : x80Var.c) {
                if (ho0Var.b == 2 && !((HashMap) this.c).containsKey(ho0Var.a)) {
                    HashMap map = (HashMap) this.c;
                    fc3 fc3Var = ho0Var.a;
                    Set set = Collections.EMPTY_SET;
                    e92 e92Var = new e92();
                    e92Var.b = null;
                    e92Var.a = Collections.newSetFromMap(new ConcurrentHashMap());
                    e92Var.a.addAll(set);
                    map.put(fc3Var, e92Var);
                } else if (((HashMap) this.b).containsKey(ho0Var.a)) {
                    continue;
                } else {
                    int i2 = ho0Var.b;
                    if (i2 == 1) {
                        throw new jo0("Unsatisfied dependency for component " + x80Var + ": " + ho0Var.a);
                    }
                    if (i2 != 2) {
                        HashMap map2 = (HashMap) this.b;
                        fc3 fc3Var2 = ho0Var.a;
                        zo2 zo2Var = pw2.c;
                        p90 p90Var = pw2.d;
                        pw2 pw2Var = new pw2();
                        pw2Var.a = zo2Var;
                        pw2Var.b = p90Var;
                        map2.put(fc3Var2, pw2Var);
                    }
                }
            }
        }
    }

    public ArrayList j(ArrayList arrayList) {
        HashMap map = (HashMap) this.b;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            x80 x80Var = (x80) it.next();
            if (x80Var.e == 0) {
                da3 da3Var = (da3) ((HashMap) this.a).get(x80Var);
                for (fc3 fc3Var : x80Var.b) {
                    if (map.containsKey(fc3Var)) {
                        arrayList2.add(new s7(19, (pw2) ((da3) map.get(fc3Var)), da3Var));
                    } else {
                        map.put(fc3Var, da3Var);
                    }
                }
            }
        }
        return arrayList2;
    }

    public ArrayList k() {
        HashMap map = (HashMap) this.c;
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        for (Map.Entry entry : ((HashMap) this.a).entrySet()) {
            x80 x80Var = (x80) entry.getKey();
            if (x80Var.e != 0) {
                da3 da3Var = (da3) entry.getValue();
                for (fc3 fc3Var : x80Var.b) {
                    if (!map2.containsKey(fc3Var)) {
                        map2.put(fc3Var, new HashSet());
                    }
                    ((Set) map2.get(fc3Var)).add(da3Var);
                }
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (map.containsKey(entry2.getKey())) {
                e92 e92Var = (e92) map.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new s7(20, e92Var, (da3) it.next()));
                }
            } else {
                fc3 fc3Var2 = (fc3) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                e92 e92Var2 = new e92();
                e92Var2.b = null;
                e92Var2.a = Collections.newSetFromMap(new ConcurrentHashMap());
                e92Var2.a.addAll(set);
                map.put(fc3Var2, e92Var2);
            }
        }
        return arrayList;
    }

    public r90() {
        this.d = new AtomicBoolean();
        this.a = null;
        this.b = new HashMap(16, 1.0f);
        this.c = new HashMap(16, 1.0f);
        this.e = new HashMap(16, 1.0f);
        this.f = new HashMap(16, 1.0f);
        this.g = null;
    }
}
