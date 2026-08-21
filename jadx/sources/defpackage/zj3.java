package defpackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class zj3 extends ge1 {
    public static final u03 X;
    public final n84 A;
    public final ClassLoader f;
    public final ge1 z;

    static {
        String str = u03.f;
        X = pr1.q("/");
    }

    public zj3(ClassLoader classLoader) {
        x72 x72Var = ge1.b;
        x72Var.getClass();
        this.f = classLoader;
        this.z = x72Var;
        this.A = new n84(new fn(17, this));
    }

    @Override // defpackage.ge1
    public final List I(u03 u03Var) throws FileNotFoundException {
        u03 u03Var2 = X;
        u03Var2.getClass();
        String strR = f.a(u03Var2, u03Var, true).c(u03Var2).b.r();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (e03 e03Var : (List) this.A.getValue()) {
            ge1 ge1Var = (ge1) e03Var.b;
            u03 u03Var3 = (u03) e03Var.f;
            try {
                List listI = ge1Var.I(u03Var3.d(strR));
                ArrayList<u03> arrayList = new ArrayList();
                for (Object obj : listI) {
                    if (ke0.l((u03) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(f70.Q(10, arrayList));
                for (u03 u03Var4 : arrayList) {
                    u03Var4.getClass();
                    String strReplace = p44.F0(u03Var4.b.r(), u03Var3.b.r()).replace('\\', '/');
                    strReplace.getClass();
                    arrayList2.add(u03Var2.d(strReplace));
                }
                d70.U(arrayList2, linkedHashSet);
                z = true;
            } catch (IOException unused) {
            }
        }
        if (z) {
            return d70.y0(linkedHashSet);
        }
        a71.f(u03Var, "file not found: ");
        return null;
    }

    @Override // defpackage.ge1
    public final no0 N(u03 u03Var) {
        u03Var.getClass();
        if (!ke0.l(u03Var)) {
            return null;
        }
        u03 u03Var2 = X;
        u03Var2.getClass();
        String strR = f.a(u03Var2, u03Var, true).c(u03Var2).b.r();
        for (e03 e03Var : (List) this.A.getValue()) {
            no0 no0VarN = ((ge1) e03Var.b).N(((u03) e03Var.f).d(strR));
            if (no0VarN != null) {
                return no0VarN;
            }
        }
        return null;
    }

    @Override // defpackage.ge1
    public final w72 Q(u03 u03Var) throws FileNotFoundException {
        if (!ke0.l(u03Var)) {
            a71.f(u03Var, "file not found: ");
            return null;
        }
        u03 u03Var2 = X;
        u03Var2.getClass();
        String strR = f.a(u03Var2, u03Var, true).c(u03Var2).b.r();
        Iterator it = ((List) this.A.getValue()).iterator();
        while (it.hasNext()) {
            e03 e03Var = (e03) it.next();
            try {
                return ((ge1) e03Var.b).Q(((u03) e03Var.f).d(strR));
            } catch (FileNotFoundException unused) {
            }
        }
        a71.f(u03Var, "file not found: ");
        return null;
    }

    @Override // defpackage.ge1
    public final vx3 U(u03 u03Var) throws IOException {
        u03Var.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // defpackage.ge1
    public final lz3 X(u03 u03Var) throws IOException {
        u03Var.getClass();
        if (!ke0.l(u03Var)) {
            a71.f(u03Var, "file not found: ");
            return null;
        }
        u03 u03Var2 = X;
        u03Var2.getClass();
        URL resource = this.f.getResource(f.a(u03Var2, u03Var, false).c(u03Var2).b.r());
        if (resource == null) {
            a71.f(u03Var, "file not found: ");
            return null;
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        if (uRLConnectionOpenConnection instanceof JarURLConnection) {
            ((JarURLConnection) uRLConnectionOpenConnection).setUseCaches(false);
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        inputStream.getClass();
        return tj4.d0(inputStream);
    }

    @Override // defpackage.ge1
    public final vx3 g(u03 u03Var) throws IOException {
        throw new IOException(this + " is read-only");
    }

    @Override // defpackage.ge1
    public final void n(u03 u03Var, u03 u03Var2) throws IOException {
        u03Var2.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // defpackage.ge1
    public final void s(u03 u03Var) throws IOException {
        u03Var.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // defpackage.ge1
    public final void x(u03 u03Var) throws IOException {
        u03Var.getClass();
        throw new IOException(this + " is read-only");
    }
}
