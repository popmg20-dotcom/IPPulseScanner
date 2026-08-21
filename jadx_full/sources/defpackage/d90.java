package defpackage;

import android.os.Bundle;
import androidx.fragment.app.p;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d90 implements av2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ p b;

    public /* synthetic */ d90(p pVar, int i) {
        this.a = i;
        this.b = pVar;
    }

    @Override // defpackage.av2
    public final void a(i90 i90Var) {
        int i = this.a;
        p pVar = this.b;
        switch (i) {
            case 0:
                i90Var.getClass();
                Bundle bundleA = pVar.A.b.a("android:support:activity-result");
                if (bundleA != null) {
                    g90 g90Var = pVar.z0;
                    LinkedHashMap linkedHashMap = g90Var.b;
                    LinkedHashMap linkedHashMap2 = g90Var.a;
                    Bundle bundle = g90Var.g;
                    ArrayList<Integer> integerArrayList = bundleA.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList != null && integerArrayList != null) {
                        ArrayList<String> stringArrayList2 = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                        if (stringArrayList2 != null) {
                            g90Var.d.addAll(stringArrayList2);
                        }
                        Bundle bundle2 = bundleA.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                        if (bundle2 != null) {
                            bundle.putAll(bundle2);
                        }
                        int size = stringArrayList.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            String str = stringArrayList.get(i2);
                            if (linkedHashMap.containsKey(str)) {
                                Integer num = (Integer) linkedHashMap.remove(str);
                                if (!bundle.containsKey(str)) {
                                    tj4.b(linkedHashMap2);
                                    linkedHashMap2.remove(num);
                                }
                            }
                            Integer num2 = integerArrayList.get(i2);
                            num2.getClass();
                            int iIntValue = num2.intValue();
                            String str2 = stringArrayList.get(i2);
                            str2.getClass();
                            String str3 = str2;
                            linkedHashMap2.put(Integer.valueOf(iIntValue), str3);
                            g90Var.b.put(str3, Integer.valueOf(iIntValue));
                        }
                        break;
                    }
                }
                break;
            default:
                kj1 kj1Var = (kj1) ((ca) pVar).M0.f;
                kj1Var.A.b(kj1Var, kj1Var, null);
                break;
        }
    }
}
