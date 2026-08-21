package io.sentry;

import java.io.Closeable;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m2 implements f0, Closeable {
    public volatile o0 A = null;
    public final p6 b;
    public final g5 f;
    public final g5 z;

    public m2(p6 p6Var) {
        this.b = p6Var;
        w wVar = new w(p6Var);
        this.z = new g5(wVar);
        this.f = new g5(wVar);
    }

    public final void C(t4 t4Var) {
        if (t4Var.Y == null) {
            t4Var.Y = this.b.getRelease();
        }
        if (t4Var.Z == null) {
            t4Var.Z = this.b.getEnvironment();
        }
        if (t4Var.B0 == null) {
            t4Var.B0 = this.b.getServerName();
        }
        if (this.b.isAttachServerName() && t4Var.B0 == null) {
            if (this.A == null) {
                this.A = o0.a();
            }
            if (this.A != null) {
                o0 o0Var = this.A;
                if (o0Var.c < System.currentTimeMillis() && o0Var.d.compareAndSet(false, true)) {
                    o0Var.b();
                }
                t4Var.B0 = o0Var.b;
            }
        }
        if (t4Var.C0 == null) {
            t4Var.C0 = this.b.getDist();
        }
        if (t4Var.z == null) {
            t4Var.z = this.b.getSdkVersion();
        }
        AbstractMap abstractMap = t4Var.X;
        p6 p6Var = this.b;
        if (abstractMap == null) {
            t4Var.c(p6Var.getTags());
        } else {
            for (Map.Entry<String, String> entry : p6Var.getTags().entrySet()) {
                if (!t4Var.X.containsKey(entry.getKey())) {
                    t4Var.b(entry.getKey(), entry.getValue());
                }
            }
        }
        io.sentry.protocol.j0 j0Var = t4Var.z0;
        if (j0Var == null) {
            j0Var = new io.sentry.protocol.j0();
            t4Var.z0 = j0Var;
        }
        if (j0Var.A == null && this.b.isSendDefaultPii()) {
            j0Var.A = "{{auto}}";
        }
    }

    public final boolean F(t4 t4Var, l0 l0Var) {
        if (io.sentry.util.b.s(l0Var)) {
            return true;
        }
        this.b.getLogger().h(p5.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", t4Var.b);
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.A != null) {
            this.A.f.shutdown();
        }
    }

    @Override // io.sentry.f0
    public final r6 g(r6 r6Var, l0 l0Var) {
        if (r6Var.y0 == null) {
            r6Var.y0 = "java";
        }
        if (F(r6Var, l0Var)) {
            C(r6Var);
            io.sentry.protocol.u uVar = this.b.getSessionReplay().l;
            if (uVar != null) {
                r6Var.z = uVar;
            }
        }
        return r6Var;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.sentry.f0
    public final f5 n(f5 f5Var, l0 l0Var) {
        ArrayList arrayList;
        if (f5Var.y0 == null) {
            f5Var.y0 = "java";
        }
        Throwable th = f5Var.A0;
        if (th != null) {
            AtomicInteger atomicInteger = new AtomicInteger(-1);
            HashSet hashSet = new HashSet();
            ArrayDeque arrayDeque = new ArrayDeque();
            this.z.a(th, atomicInteger, hashSet, arrayDeque, null);
            f5Var.h(new ArrayList(arrayDeque));
        }
        io.sentry.protocol.f fVar = f5Var.E0;
        p6 p6Var = this.b;
        io.sentry.protocol.f fVarA = io.sentry.protocol.f.a(fVar, p6Var);
        if (fVarA != null) {
            f5Var.E0 = fVarA;
        }
        Map mapA = p6Var.getModulesLoader().a();
        if (mapA != null) {
            AbstractMap abstractMap = f5Var.P0;
            if (abstractMap == null) {
                f5Var.P0 = new HashMap(mapA);
            } else {
                abstractMap.putAll(mapA);
            }
        }
        if (F(f5Var, l0Var)) {
            C(f5Var);
            if (f5Var.e() == null) {
                ArrayList<io.sentry.protocol.v> arrayListD = f5Var.d();
                if (arrayListD == null || arrayListD.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = null;
                    for (io.sentry.protocol.v vVar : arrayListD) {
                        if (vVar.Y != null && vVar.A != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(vVar.A);
                        }
                    }
                }
                boolean zIsAttachThreads = p6Var.isAttachThreads();
                boolean zC = false;
                g5 g5Var = this.f;
                if (zIsAttachThreads || io.sentry.hints.a.class.isInstance(l0Var.b("sentry:typeCheckHint"))) {
                    Object objB = l0Var.b("sentry:typeCheckHint");
                    boolean zIsAttachStacktrace = p6Var.isAttachStacktrace();
                    if (objB instanceof io.sentry.hints.a) {
                        zC = ((io.sentry.hints.a) objB).c();
                        zIsAttachStacktrace = true;
                    }
                    f5Var.J0 = new g2(g5Var.b(Thread.getAllStackTraces(), arrayList, zC, zIsAttachStacktrace));
                } else if (p6Var.isAttachStacktrace() && ((arrayListD == null || arrayListD.isEmpty()) && !io.sentry.hints.d.class.isInstance(l0Var.b("sentry:typeCheckHint")))) {
                    boolean zIsAttachStacktrace2 = p6Var.isAttachStacktrace();
                    HashMap map = new HashMap();
                    Thread threadCurrentThread = Thread.currentThread();
                    map.put(threadCurrentThread, threadCurrentThread.getStackTrace());
                    f5Var.J0 = new g2(g5Var.b(map, null, false, zIsAttachStacktrace2));
                    return f5Var;
                }
            }
        }
        return f5Var;
    }

    @Override // io.sentry.f0
    public final io.sentry.protocol.f0 s(io.sentry.protocol.f0 f0Var, l0 l0Var) {
        if (f0Var.y0 == null) {
            f0Var.y0 = "java";
        }
        io.sentry.protocol.f fVarA = io.sentry.protocol.f.a(f0Var.E0, this.b);
        if (fVarA != null) {
            f0Var.E0 = fVarA;
        }
        if (F(f0Var, l0Var)) {
            C(f0Var);
        }
        return f0Var;
    }

    @Override // io.sentry.f0
    public final r5 x(r5 r5Var) {
        return r5Var;
    }
}
