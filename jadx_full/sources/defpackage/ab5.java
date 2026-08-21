package defpackage;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ab5 implements lb5, v65 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ ab5(ib5 ib5Var, AtomicReference atomicReference, ie5 ie5Var) {
        this.b = 0;
        this.f = ib5Var;
        this.z = atomicReference;
        this.A = ie5Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032 A[Catch: all -> 0x0027, TryCatch #1 {all -> 0x0027, blocks: (B:6:0x0024, B:19:0x006b, B:22:0x008f, B:13:0x0032, B:15:0x0058, B:17:0x0063, B:18:0x0067), top: B:54:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067 A[Catch: all -> 0x0027, TryCatch #1 {all -> 0x0027, blocks: (B:6:0x0024, B:19:0x006b, B:22:0x008f, B:13:0x0032, B:15:0x0058, B:17:0x0063, B:18:0x0067), top: B:54:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0179 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
    @Override // defpackage.lb5, defpackage.v65
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str, int i, Throwable th, byte[] bArr, Map map) {
        int i2;
        ob5 ob5Var;
        AtomicReference atomicReference;
        switch (this.b) {
            case 0:
                ib5 ib5Var = (ib5) this.f;
                ib5Var.V0();
                ie5 ie5Var = (ie5) this.A;
                if (i != 200 && i != 204) {
                    i2 = 304;
                    if (i != 304) {
                        i2 = i;
                    }
                    t65 t65Var = ((k85) ib5Var.f).Y;
                    k85.h(t65Var);
                    t65Var.C0.d("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(ie5Var.b), Integer.valueOf(i2), th);
                    ob5Var = !Arrays.asList(((String) r55.u.a(null)).split(",")).contains(String.valueOf(i2)) ? ob5.BACKOFF : ob5.FAILURE;
                    atomicReference = (AtomicReference) this.z;
                    dd5 dd5VarJ = ((k85) ib5Var.f).j();
                    long j = ie5Var.b;
                    k15 k15Var = new k15(j, ie5Var.Y, ob5Var.b);
                    dd5VarJ.V0();
                    dd5VarJ.W0();
                    dd5VarJ.j1(new g33(dd5VarJ, dd5VarJ.l1(true), k15Var, 12, false));
                    t65 t65Var2 = ((k85) ib5Var.f).Y;
                    k85.h(t65Var2);
                    t65Var2.H0.c("[sgtm] Updated status for row_id", Long.valueOf(j), ob5Var);
                    synchronized (atomicReference) {
                        atomicReference.set(ob5Var);
                        atomicReference.notifyAll();
                        break;
                    }
                    return;
                }
                i2 = i;
                if (th == null) {
                    t65 t65Var3 = ((k85) ib5Var.f).Y;
                    k85.h(t65Var3);
                    t65Var3.H0.b(Long.valueOf(ie5Var.b), "[sgtm] Upload succeeded for row_id");
                    ob5Var = ob5.SUCCESS;
                } else {
                    t65 t65Var4 = ((k85) ib5Var.f).Y;
                    k85.h(t65Var4);
                    t65Var4.C0.d("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(ie5Var.b), Integer.valueOf(i2), th);
                    if (!Arrays.asList(((String) r55.u.a(null)).split(",")).contains(String.valueOf(i2))) {
                    }
                }
                atomicReference = (AtomicReference) this.z;
                dd5 dd5VarJ2 = ((k85) ib5Var.f).j();
                long j2 = ie5Var.b;
                k15 k15Var2 = new k15(j2, ie5Var.Y, ob5Var.b);
                dd5VarJ2.V0();
                dd5VarJ2.W0();
                dd5VarJ2.j1(new g33(dd5VarJ2, dd5VarJ2.l1(true), k15Var2, 12, false));
                t65 t65Var22 = ((k85) ib5Var.f).Y;
                k85.h(t65Var22);
                t65Var22.H0.c("[sgtm] Updated status for row_id", Long.valueOf(j2), ob5Var);
                synchronized (atomicReference) {
                }
                break;
            case 1:
                ((ff5) this.A).u(true, i, th, bArr, (String) this.f, (ArrayList) this.z);
                return;
            default:
                long j3 = ((if5) this.z).a;
                ff5 ff5Var = (ff5) this.A;
                String str2 = (String) this.f;
                ff5Var.C().V0();
                ff5Var.j0();
                if (bArr == null) {
                    try {
                        bArr = new byte[0];
                    } catch (Throwable th2) {
                        ff5Var.L0 = false;
                        ff5Var.L();
                        throw th2;
                    }
                }
                if (i != 200) {
                    if (i == 204) {
                        i = 204;
                        if (th != null) {
                        }
                    }
                    String str3 = new String(bArr, StandardCharsets.UTF_8);
                    String strSubstring = str3.substring(0, Math.min(32, str3.length()));
                    q65 q65Var = ff5Var.n().E0;
                    Integer numValueOf = Integer.valueOf(i);
                    Object obj = th;
                    if (th == null) {
                    }
                    q65Var.d("Network upload failed. Will retry later. appId, status, error", str2, numValueOf, obj);
                    m25 m25Var = ff5Var.z;
                    ff5.R(m25Var);
                    m25Var.h1(Long.valueOf(j3));
                    ff5Var.K();
                } else if (th != null) {
                    m25 m25Var2 = ff5Var.z;
                    ff5.R(m25Var2);
                    m25Var2.c1(Long.valueOf(j3));
                    ff5Var.n().H0.c("Successfully uploaded batch from upload queue. appId, status", str2, Integer.valueOf(i));
                    z65 z65Var = ff5Var.f;
                    ff5.R(z65Var);
                    if (z65Var.p1()) {
                        m25 m25Var3 = ff5Var.z;
                        ff5.R(m25Var3);
                        if (m25Var3.b1(str2)) {
                            ff5Var.p(str2);
                        } else {
                            ff5Var.K();
                        }
                    }
                } else {
                    String str32 = new String(bArr, StandardCharsets.UTF_8);
                    String strSubstring2 = str32.substring(0, Math.min(32, str32.length()));
                    q65 q65Var2 = ff5Var.n().E0;
                    Integer numValueOf2 = Integer.valueOf(i);
                    Object obj2 = th;
                    if (th == null) {
                        obj2 = strSubstring2;
                    }
                    q65Var2.d("Network upload failed. Will retry later. appId, status, error", str2, numValueOf2, obj2);
                    m25 m25Var4 = ff5Var.z;
                    ff5.R(m25Var4);
                    m25Var4.h1(Long.valueOf(j3));
                    ff5Var.K();
                }
                ff5Var.L0 = false;
                ff5Var.L();
                return;
        }
    }

    public /* synthetic */ ab5(ff5 ff5Var, String str, Object obj, int i) {
        this.b = i;
        this.f = str;
        this.z = obj;
        this.A = ff5Var;
    }
}
