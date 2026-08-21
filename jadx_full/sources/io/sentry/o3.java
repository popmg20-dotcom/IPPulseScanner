package io.sentry;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o3 extends z {
    public static final Charset i = Charset.forName("UTF-8");
    public final f1 e;
    public final w0 f;
    public final l1 g;
    public final ILogger h;

    public o3(f1 f1Var, w0 w0Var, l1 l1Var, ILogger iLogger, long j, int i2) {
        super(f1Var, iLogger, j, i2);
        this.e = f1Var;
        io.sentry.util.b.r(w0Var, "Envelope reader is required.");
        this.f = w0Var;
        io.sentry.util.b.r(l1Var, "Serializer is required.");
        this.g = l1Var;
        io.sentry.util.b.r(iLogger, "Logger is required.");
        this.h = iLogger;
    }

    @Override // io.sentry.z
    public final boolean a(String str) {
        return (str == null || str.startsWith("session") || str.startsWith("previous_session") || str.startsWith("startup_crash")) ? false : true;
    }

    @Override // io.sentry.z
    public final void b(File file, l0 l0Var) {
        boolean zA = a(file.getName());
        ILogger iLogger = this.h;
        try {
            if (!zA) {
                iLogger.h(p5.DEBUG, "File '%s' should be ignored.", file.getAbsolutePath());
                return;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    io.sentry.internal.debugmeta.c cVarA = this.f.a(bufferedInputStream);
                    if (cVarA == null) {
                        iLogger.h(p5.ERROR, "Stream from path %s resulted in a null envelope.", file.getAbsolutePath());
                    } else {
                        e(cVarA, l0Var);
                        iLogger.h(p5.DEBUG, "File '%s' is done.", file.getAbsolutePath());
                    }
                    bufferedInputStream.close();
                    Object objB = l0Var.b("sentry:typeCheckHint");
                    if (!io.sentry.hints.h.class.isInstance(l0Var.b("sentry:typeCheckHint")) || objB == null) {
                        io.sentry.util.b.n(io.sentry.hints.h.class, objB, iLogger);
                    } else {
                        d(file, (io.sentry.hints.h) objB);
                    }
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                iLogger.d(p5.ERROR, "Error processing envelope.", e);
                Object objB2 = l0Var.b("sentry:typeCheckHint");
                if (!io.sentry.hints.h.class.isInstance(l0Var.b("sentry:typeCheckHint")) || objB2 == null) {
                    io.sentry.util.b.n(io.sentry.hints.h.class, objB2, iLogger);
                } else {
                    d(file, (io.sentry.hints.h) objB2);
                }
            }
        } catch (Throwable th3) {
            Object objB3 = l0Var.b("sentry:typeCheckHint");
            if (!io.sentry.hints.h.class.isInstance(l0Var.b("sentry:typeCheckHint")) || objB3 == null) {
                io.sentry.util.b.n(io.sentry.hints.h.class, objB3, iLogger);
            } else {
                d(file, (io.sentry.hints.h) objB3);
            }
            throw th3;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final x3 c(h7 h7Var) {
        String str;
        ILogger iLogger = this.h;
        if (h7Var != null && (str = h7Var.Z) != null) {
            try {
                Double dValueOf = Double.valueOf(Double.parseDouble(str));
                if (io.sentry.util.b.m(dValueOf, false)) {
                    String str2 = h7Var.y0;
                    if (str2 != null) {
                        Double dValueOf2 = Double.valueOf(Double.parseDouble(str2));
                        if (io.sentry.util.b.m(dValueOf2, false)) {
                            return new x3(Boolean.TRUE, dValueOf, dValueOf2);
                        }
                    }
                    return io.sentry.util.b.b(new x3(Boolean.TRUE, dValueOf));
                }
                iLogger.h(p5.ERROR, "Invalid sample rate parsed from TraceContext: %s", str);
            } catch (Exception unused) {
                iLogger.h(p5.ERROR, "Unable to parse sample rate from TraceContext: %s", str);
            }
        }
        return new x3(Boolean.TRUE, (Double) null);
    }

    public final /* synthetic */ void d(File file, io.sentry.hints.h hVar) {
        ILogger iLogger = this.h;
        if (hVar.a()) {
            return;
        }
        try {
            if (file.delete()) {
                return;
            }
            iLogger.h(p5.ERROR, "Failed to delete: %s", file.getAbsolutePath());
        } catch (RuntimeException e) {
            iLogger.b(p5.ERROR, e, "Failed to delete: %s", file.getAbsolutePath());
        }
    }

    public final void e(io.sentry.internal.debugmeta.c cVar, l0 l0Var) {
        int size;
        String str;
        BufferedReader bufferedReader;
        f5 f5Var;
        boolean z;
        String str2;
        BufferedReader bufferedReader2;
        io.sentry.protocol.f0 f0Var;
        p5 p5Var = p5.DEBUG;
        Iterable iterable = (Iterable) cVar.z;
        y4 y4Var = (y4) cVar.f;
        io.sentry.protocol.w wVar = y4Var.b;
        boolean z2 = false;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            Iterator it = iterable.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                it.next();
                i2++;
            }
            size = i2;
        }
        int i3 = 1;
        Object[] objArr = {Integer.valueOf(size)};
        ILogger iLogger = this.h;
        iLogger.h(p5Var, "Processing Envelope with %d item(s)", objArr);
        Iterator it2 = iterable.iterator();
        int i4 = 0;
        while (it2.hasNext()) {
            d5 d5Var = (d5) it2.next();
            int i5 = i4 + 1;
            e5 e5Var = d5Var.a;
            e5 e5Var2 = d5Var.a;
            o5 o5Var = e5Var.X;
            boolean zEquals = o5.Event.equals(e5Var.X);
            boolean z3 = z2;
            int i6 = i3;
            l1 l1Var = this.g;
            Iterator it3 = it2;
            Charset charset = i;
            f1 f1Var = this.e;
            if (zEquals) {
                try {
                    str = "Item failed to process.";
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(d5Var.g()), charset));
                        try {
                            f5Var = (f5) l1Var.b(bufferedReader, f5.class);
                        } finally {
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str = "Item failed to process.";
                }
                if (f5Var == null) {
                    p5 p5Var2 = p5.ERROR;
                    Integer numValueOf = Integer.valueOf(i5);
                    o5 o5Var2 = e5Var2.X;
                    Object[] objArr2 = new Object[2];
                    objArr2[z3 ? 1 : 0] = numValueOf;
                    objArr2[i6] = o5Var2;
                    iLogger.h(p5Var2, "Item %d of type %s returned null by the parser.", objArr2);
                } else {
                    io.sentry.protocol.u uVar = f5Var.z;
                    if (uVar != null) {
                        String str3 = uVar.b;
                        if (str3.startsWith("sentry.javascript") || str3.startsWith("sentry.dart") || str3.startsWith("sentry.dotnet")) {
                            l0Var.d(Boolean.TRUE, "sentry:isFromHybridSdk");
                        }
                    }
                    if (wVar == null || wVar.equals(f5Var.b)) {
                        f1Var.B(f5Var, l0Var);
                        p5 p5Var3 = p5.DEBUG;
                        Integer numValueOf2 = Integer.valueOf(i5);
                        Object[] objArr3 = new Object[i6];
                        objArr3[z3 ? 1 : 0] = numValueOf2;
                        iLogger.h(p5Var3, "Item %d is being captured.", objArr3);
                        if (!f(l0Var)) {
                            io.sentry.protocol.w wVar2 = f5Var.b;
                            p5 p5Var4 = p5.WARNING;
                            Object[] objArr4 = new Object[1];
                            objArr4[z3 ? 1 : 0] = wVar2;
                            iLogger.h(p5Var4, "Timed out waiting for event id submission: %s", objArr4);
                            bufferedReader.close();
                            return;
                        }
                    } else {
                        io.sentry.protocol.w wVar3 = f5Var.b;
                        p5 p5Var5 = p5.ERROR;
                        Integer numValueOf3 = Integer.valueOf(i5);
                        io.sentry.protocol.w wVar4 = y4Var.b;
                        Object[] objArr5 = new Object[3];
                        objArr5[z3 ? 1 : 0] = numValueOf3;
                        objArr5[i6] = wVar4;
                        objArr5[2] = wVar3;
                        iLogger.h(p5Var5, "Item %d of has a different event id (%s) to the envelope header (%s)", objArr5);
                        bufferedReader.close();
                        z = z3 ? 1 : 0;
                        i3 = i6;
                        z2 = z;
                        it2 = it3;
                        i4 = i5;
                    }
                    th = th;
                    iLogger.d(p5.ERROR, str, th);
                }
                bufferedReader.close();
            } else if (o5.Transaction.equals(o5Var)) {
                try {
                    str2 = "Item failed to process.";
                    try {
                        bufferedReader2 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(d5Var.g()), charset));
                        try {
                            f0Var = (io.sentry.protocol.f0) l1Var.b(bufferedReader2, io.sentry.protocol.f0.class);
                        } finally {
                            try {
                                bufferedReader2.close();
                                throw th;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str2 = "Item failed to process.";
                }
                if (f0Var == null) {
                    p5 p5Var6 = p5.ERROR;
                    Integer numValueOf4 = Integer.valueOf(i5);
                    o5 o5Var3 = e5Var2.X;
                    Object[] objArr6 = new Object[2];
                    objArr6[z3 ? 1 : 0] = numValueOf4;
                    objArr6[1] = o5Var3;
                    iLogger.h(p5Var6, "Item %d of type %s returned null by the parser.", objArr6);
                } else {
                    if (wVar == null || wVar.equals(f0Var.b)) {
                        h7 h7Var = y4Var.z;
                        if (f0Var.f.i() != null) {
                            f0Var.f.i().a(c(h7Var));
                        }
                        f1Var.n(f0Var, h7Var, l0Var);
                        p5 p5Var7 = p5.DEBUG;
                        Integer numValueOf5 = Integer.valueOf(i5);
                        Object[] objArr7 = new Object[1];
                        objArr7[z3 ? 1 : 0] = numValueOf5;
                        iLogger.h(p5Var7, "Item %d is being captured.", objArr7);
                        if (!f(l0Var)) {
                            io.sentry.protocol.w wVar5 = f0Var.b;
                            p5 p5Var8 = p5.WARNING;
                            Object[] objArr8 = new Object[1];
                            objArr8[z3 ? 1 : 0] = wVar5;
                            iLogger.h(p5Var8, "Timed out waiting for event id submission: %s", objArr8);
                            bufferedReader2.close();
                            return;
                        }
                    } else {
                        io.sentry.protocol.w wVar6 = f0Var.b;
                        p5 p5Var9 = p5.ERROR;
                        Integer numValueOf6 = Integer.valueOf(i5);
                        io.sentry.protocol.w wVar7 = y4Var.b;
                        Object[] objArr9 = new Object[3];
                        objArr9[z3 ? 1 : 0] = numValueOf6;
                        objArr9[1] = wVar7;
                        objArr9[2] = wVar6;
                        iLogger.h(p5Var9, "Item %d of has a different event id (%s) to the envelope header (%s)", objArr9);
                        bufferedReader2.close();
                        z = z3 ? 1 : 0;
                        i3 = 1;
                        z2 = z;
                        it2 = it3;
                        i4 = i5;
                    }
                    th = th4;
                    iLogger.d(p5.ERROR, str2, th);
                }
                bufferedReader2.close();
            } else {
                f1Var.f(new io.sentry.internal.debugmeta.c(wVar, y4Var.f, d5Var), l0Var);
                p5 p5Var10 = p5.DEBUG;
                String itemType = o5Var.getItemType();
                Integer numValueOf7 = Integer.valueOf(i5);
                Object[] objArr10 = new Object[2];
                objArr10[z3 ? 1 : 0] = itemType;
                objArr10[1] = numValueOf7;
                iLogger.h(p5Var10, "%s item %d is being captured.", objArr10);
                if (!f(l0Var)) {
                    p5 p5Var11 = p5.WARNING;
                    Object[] objArr11 = new Object[1];
                    objArr11[z3 ? 1 : 0] = o5Var.getItemType();
                    iLogger.h(p5Var11, "Timed out waiting for item type submission: %s", objArr11);
                    return;
                }
            }
            Object objB = l0Var.b("sentry:typeCheckHint");
            if ((objB instanceof io.sentry.hints.k) && !((io.sentry.hints.k) objB).isSuccess()) {
                p5 p5Var12 = p5.WARNING;
                Object[] objArr12 = new Object[1];
                objArr12[z3 ? 1 : 0] = Integer.valueOf(i5);
                iLogger.h(p5Var12, "Envelope had a failed capture at item %d. No more items will be sent.", objArr12);
                return;
            }
            Object objB2 = l0Var.b("sentry:typeCheckHint");
            if (!io.sentry.android.core.v0.class.isInstance(l0Var.b("sentry:typeCheckHint")) || objB2 == null) {
                z = z3 ? 1 : 0;
                i3 = 1;
            } else {
                io.sentry.android.core.v0 v0Var = (io.sentry.android.core.v0) objB2;
                i3 = 1;
                v0Var.z = new CountDownLatch(1);
                z = z3 ? 1 : 0;
                v0Var.b = z;
                v0Var.f = z;
            }
            z2 = z;
            it2 = it3;
            i4 = i5;
        }
    }

    public final boolean f(l0 l0Var) {
        Object objB = l0Var.b("sentry:typeCheckHint");
        if (objB instanceof io.sentry.hints.f) {
            return ((io.sentry.hints.f) objB).d();
        }
        io.sentry.util.b.n(io.sentry.hints.f.class, objB, this.h);
        return true;
    }
}
