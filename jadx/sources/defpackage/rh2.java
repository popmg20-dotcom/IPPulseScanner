package defpackage;

import io.sentry.android.core.a1;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class rh2 {
    public static final ve2 e = ve2.a(rh2.class.getName());
    public final ArrayList a = new ArrayList();
    public final qh2 b;
    public final jo2 c;
    public String d;

    public rh2(String str) {
        qh2 qh2Var = new qh2(str);
        this.b = qh2Var;
        this.c = ko2.a;
        String strA = qh2Var.a();
        this.d = strA;
        while (strA != null) {
            int i = 0;
            if (strA.length() == 2 && strA.charAt(1) == ':') {
                char cCharAt = strA.charAt(0);
                if (cCharAt == 'L') {
                    i = -1;
                } else if (cCharAt != 'R') {
                    a1.n(e.a, "Unknown priority " + strA + " in scope selector " + str);
                } else {
                    i = 1;
                }
                this.d = this.b.a();
            }
            this.a.add(new vh2(b(), i));
            if (!",".equals(this.d)) {
                return;
            }
            strA = this.b.a();
            this.d = strA;
        }
    }

    public static boolean a(String str) {
        if (!str.isEmpty()) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '.' || cCharAt == ':' || cCharAt == '_' || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= '0' && cCharAt <= '9')))) {
                }
            }
            return true;
        }
        return false;
    }

    public final oh2 b() {
        ArrayList arrayList = new ArrayList();
        nh2 nh2VarC = c();
        while (nh2VarC != null) {
            arrayList.add(nh2VarC);
            nh2VarC = c();
        }
        return new oh2(0, arrayList);
    }

    public final nh2 c() {
        boolean zEquals = "-".equals(this.d);
        qh2 qh2Var = this.b;
        if (zEquals) {
            this.d = qh2Var.a();
            return new oh2(2, c());
        }
        if (!"(".equals(this.d)) {
            String strA = this.d;
            if (strA == null || !a(strA)) {
                return null;
            }
            final ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(strA);
                strA = qh2Var.a();
                this.d = strA;
                if (strA == null) {
                    break;
                }
            } while (a(strA));
            return new nh2() { // from class: ph2
                @Override // defpackage.nh2
                public final boolean a(Object obj) {
                    return this.a.c.a(obj, arrayList);
                }
            };
        }
        this.d = qh2Var.a();
        ArrayList arrayList2 = new ArrayList();
        oh2 oh2VarB = b();
        while (true) {
            arrayList2.add(oh2VarB);
            if (!"|".equals(this.d) && !",".equals(this.d)) {
                break;
            }
            while (true) {
                String strA2 = qh2Var.a();
                this.d = strA2;
                if ("|".equals(strA2) || ",".equals(this.d)) {
                }
            }
            oh2VarB = b();
        }
        oh2 oh2Var = new oh2(1, arrayList2);
        if (")".equals(this.d)) {
            this.d = qh2Var.a();
        }
        return oh2Var;
    }
}
