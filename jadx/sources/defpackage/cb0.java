package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class cb0 {
    public boolean a;
    public boolean b;
    public Object c;
    public Serializable d;

    public cb0(StringBuilder sb, boolean z) {
        this.d = new StringBuilder();
        this.b = false;
        this.c = sb;
        this.a = z;
    }

    public db0 a() {
        return new db0(this.a, this.b, (String[]) this.c, (String[]) this.d);
    }

    public void b(w40... w40VarArr) {
        if (!this.a) {
            xe.k("no cipher suites for cleartext connections");
            return;
        }
        ArrayList arrayList = new ArrayList(w40VarArr.length);
        for (w40 w40Var : w40VarArr) {
            arrayList.add(w40Var.a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        if (!this.a) {
            xe.k("no cipher suites for cleartext connections");
        } else if (strArr2.length != 0) {
            this.c = (String[]) Arrays.copyOf(strArr2, strArr2.length);
        } else {
            xe.k("At least one cipher suite is required");
        }
    }

    public void c() {
        ((StringBuilder) this.c).append((CharSequence) "\n");
        this.b = true;
    }

    public void d() {
        boolean z = this.a;
        StringBuilder sb = (StringBuilder) this.c;
        if (!z) {
            sb.append((CharSequence) " ");
        } else {
            sb.append((CharSequence) " \t ");
            this.a = false;
        }
    }

    public void e() {
        StringBuilder sb = (StringBuilder) this.d;
        int length = sb.length();
        if (length != 0) {
            sb.setLength(length - 2);
        } else {
            xe.k(" Outdent() without matching Indent().");
        }
    }

    public void f(CharSequence charSequence) {
        StringBuilder sb = (StringBuilder) this.c;
        if (this.b) {
            this.b = false;
            sb.append((CharSequence) this.d);
        }
        sb.append(charSequence);
    }

    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.Serializable, java.lang.String[]] */
    public void g(ne4... ne4VarArr) {
        if (!this.a) {
            xe.k("no TLS versions for cleartext connections");
            return;
        }
        ArrayList arrayList = new ArrayList(ne4VarArr.length);
        for (ne4 ne4Var : ne4VarArr) {
            arrayList.add(ne4Var.b);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        if (!this.a) {
            xe.k("no TLS versions for cleartext connections");
        } else if (strArr2.length != 0) {
            this.d = (String[]) Arrays.copyOf(strArr2, strArr2.length);
        } else {
            xe.k("At least one TLS version is required");
        }
    }

    public cb0() {
        this.a = true;
    }
}
