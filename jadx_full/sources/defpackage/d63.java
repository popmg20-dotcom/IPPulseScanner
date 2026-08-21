package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d63 extends r25 {
    public static final d63 l = new d63(0);
    public final /* synthetic */ int k;

    public /* synthetic */ d63(int i) {
        this.k = i;
    }

    @Override // defpackage.r25
    public final boolean a(Object obj, Object obj2) {
        switch (this.k) {
            case 0:
                zk zkVar = (zk) obj;
                zk zkVar2 = (zk) obj2;
                zkVar.getClass();
                zkVar2.getClass();
                return zkVar.O() == zkVar2.O() && zkVar.W() == zkVar2.W();
            case 1:
                xs xsVar = (xs) obj;
                xs xsVar2 = (xs) obj2;
                xsVar.getClass();
                xsVar2.getClass();
                return xsVar.equals(xsVar2);
            case 2:
                String str = (String) obj;
                String str2 = (String) obj2;
                str.getClass();
                str2.getClass();
                return str.equals(str2);
            case 3:
                aa1 aa1Var = (aa1) obj;
                aa1 aa1Var2 = (aa1) obj2;
                aa1Var.getClass();
                aa1Var2.getClass();
                return aa1Var.equals(aa1Var2);
            case 4:
                ls1 ls1Var = (ls1) obj;
                ls1 ls1Var2 = (ls1) obj2;
                ls1Var.getClass();
                ls1Var2.getClass();
                return ls1Var.equals(ls1Var2);
            case 5:
                ge2 ge2Var = (ge2) obj;
                ge2 ge2Var2 = (ge2) obj2;
                ge2Var.getClass();
                ge2Var2.getClass();
                return ge2Var.equals(ge2Var2);
            case 6:
                f82 f82Var = (f82) obj;
                f82 f82Var2 = (f82) obj2;
                f82Var.getClass();
                f82Var2.getClass();
                return f82Var.equals(f82Var2);
            case 7:
                String str3 = (String) obj;
                String str4 = (String) obj2;
                str3.getClass();
                str4.getClass();
                return str3.equals(str4);
            default:
                pd pdVar = (pd) obj;
                pd pdVar2 = (pd) obj2;
                pdVar.getClass();
                pdVar2.getClass();
                return pdVar.equals(pdVar2);
        }
    }

    @Override // defpackage.r25
    public final boolean b(Object obj, Object obj2) {
        switch (this.k) {
            case 0:
                zk zkVar = (zk) obj;
                zk zkVar2 = (zk) obj2;
                zkVar.getClass();
                zkVar2.getClass();
                return n12.c(zkVar.getName(), zkVar2.getName());
            case 1:
                xs xsVar = (xs) obj;
                xs xsVar2 = (xs) obj2;
                xsVar.getClass();
                xsVar2.getClass();
                return n12.c(xsVar.a.packageName, xsVar2.a.packageName);
            case 2:
                String str = (String) obj;
                String str2 = (String) obj2;
                str.getClass();
                str2.getClass();
                return str.equals(str2);
            case 3:
                aa1 aa1Var = (aa1) obj;
                aa1 aa1Var2 = (aa1) obj2;
                aa1Var.getClass();
                aa1Var2.getClass();
                return n12.c(aa1Var.a, aa1Var2.a);
            case 4:
                ls1 ls1Var = (ls1) obj;
                ls1 ls1Var2 = (ls1) obj2;
                ls1Var.getClass();
                ls1Var2.getClass();
                return ls1Var.b == ls1Var2.b;
            case 5:
                ge2 ge2Var = (ge2) obj;
                ge2 ge2Var2 = (ge2) obj2;
                ge2Var.getClass();
                ge2Var2.getClass();
                return ge2Var == ge2Var2;
            case 6:
                f82 f82Var = (f82) obj;
                f82 f82Var2 = (f82) obj2;
                f82Var.getClass();
                f82Var2.getClass();
                return n12.c(f82Var.z, f82Var2.z);
            case 7:
                String str3 = (String) obj;
                String str4 = (String) obj2;
                str3.getClass();
                str4.getClass();
                return str3.equals(str4);
            default:
                pd pdVar = (pd) obj;
                pd pdVar2 = (pd) obj2;
                pdVar.getClass();
                pdVar2.getClass();
                return pdVar.a == pdVar2.a;
        }
    }
}
