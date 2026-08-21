package defpackage;

import android.os.Message;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.channel.internal.ChannelUtils;
import io.sentry.android.core.a1;
import j$.util.Objects;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jf extends Thread {
    public long A;
    public a54 Y;
    public lb Z;
    public volatile boolean f;
    public final qt y0;
    public ld0 z;
    public final /* synthetic */ bc4 z0;
    public final LinkedBlockingQueue b = new LinkedBlockingQueue();
    public final ArrayList X = new ArrayList();

    public jf(bc4 bc4Var) {
        this.z0 = bc4Var;
        this.y0 = new qt(bc4Var, this);
    }

    public final boolean a(Message message) {
        int i;
        int i2;
        try {
            this.A = this.z0.d;
            this.y0.b = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
            switch (message.what) {
                case 11451401:
                    this.z = (ld0) message.obj;
                    if (!this.f && !isInterrupted()) {
                        b();
                    }
                    return true;
                case 11451402:
                    if (this.f || isInterrupted()) {
                        i = 0;
                        i2 = 0;
                    } else {
                        kf kfVar = (kf) message.obj;
                        long j = kfVar.a;
                        i2 = (int) (j >> 32);
                        long j2 = kfVar.b;
                        int i3 = (int) (j2 >> 32);
                        CharSequence charSequence = kfVar.c;
                        ld0 ld0Var = this.z;
                        int i4 = 6;
                        if (charSequence == null) {
                            ld0Var.h(i2, (int) (j & 4294967295L), i3, (int) (j2 & 4294967295L));
                            bo2 bo2Var = i2 == 0 ? null : ((qz1) this.X.get(i2 - 1)).a;
                            int i5 = i2 + 1;
                            if (i3 >= i5) {
                                List listSubList = this.X.subList(i5, i3 + 1);
                                Iterator it = listSubList.iterator();
                                while (it.hasNext()) {
                                    this.z0.D(((qz1) it.next()).a);
                                }
                                listSubList.clear();
                            }
                            lb lbVar = this.Z;
                            lbVar.getClass();
                            cp1 cp1Var = new cp1(i4, lbVar);
                            for (int i6 = i5; i6 <= i3; i6++) {
                                cp1Var.I(i5);
                            }
                            i = i2;
                            while (i < this.z.b.size()) {
                                qz1 qz1VarG = this.z0.G(this.z.o(i), bo2Var);
                                ArrayList arrayList = qz1VarG.b;
                                if (arrayList == null) {
                                    arrayList = null;
                                }
                                cp1Var.i0(i, arrayList);
                                ArrayList arrayList2 = this.X;
                                qz1VarG.b = null;
                                qz1 qz1Var = (qz1) arrayList2.set(i, qz1VarG);
                                if (qz1Var != null) {
                                    this.z0.D(qz1Var.a);
                                }
                                this.z0.E(qz1VarG.a);
                                bo2 bo2Var2 = qz1Var == null ? null : qz1Var.a;
                                bo2 bo2Var3 = qz1VarG.a;
                                if (!((bo2Var2 == null && bo2Var3 == null) ? true : (bo2Var2 == null || bo2Var3 == null) ? false : Objects.equals(bo2Var2.a, bo2Var3.a))) {
                                    bo2Var = qz1VarG.a;
                                    i++;
                                }
                            }
                        } else {
                            ld0Var.r(i2, (int) (j & 4294967295L), charSequence);
                            bo2 bo2Var4 = i2 == 0 ? null : ((qz1) this.X.get(i2 - 1)).a;
                            cp1 cp1Var2 = new cp1(i4, this.Y.a);
                            int i7 = i2;
                            while (i7 <= i3) {
                                qz1 qz1VarG2 = this.z0.G(this.z.o(i7), bo2Var4);
                                ArrayList arrayList3 = qz1VarG2.b;
                                if (i7 == i2) {
                                    if (arrayList3 == null) {
                                        arrayList3 = null;
                                    }
                                    cp1Var2.i0(i7, arrayList3);
                                    ArrayList arrayList4 = this.X;
                                    qz1VarG2.b = null;
                                    qz1 qz1Var2 = (qz1) arrayList4.set(i7, qz1VarG2);
                                    if (qz1Var2 != null) {
                                        this.z0.D(qz1Var2.a);
                                    }
                                } else {
                                    if (arrayList3 == null) {
                                        arrayList3 = null;
                                    }
                                    lb lbVar2 = (lb) cp1Var2.f;
                                    ReentrantLock reentrantLock = (ReentrantLock) lbVar2.f;
                                    reentrantLock.lock();
                                    try {
                                        ((ArrayList) lbVar2.z).add(i7, new hf(arrayList3));
                                        reentrantLock.unlock();
                                        ArrayList arrayList5 = this.X;
                                        qz1VarG2.b = null;
                                        arrayList5.add(i7, qz1VarG2);
                                    } catch (Throwable th) {
                                        reentrantLock.unlock();
                                        throw th;
                                    }
                                }
                                this.z0.E(qz1VarG2.a);
                                bo2Var4 = qz1VarG2.a;
                                i7++;
                            }
                            i = i7;
                            boolean z = true;
                            while (i < this.z.b.size() && z) {
                                qz1 qz1VarG3 = this.z0.G(this.z.o(i), bo2Var4);
                                bo2 bo2Var5 = qz1VarG3.a;
                                bo2 bo2Var6 = ((qz1) this.X.get(i)).a;
                                if ((bo2Var5 == null && bo2Var6 == null) ? true : (bo2Var5 == null || bo2Var6 == null) ? false : Objects.equals(bo2Var5.a, bo2Var6.a)) {
                                    z = false;
                                }
                                ArrayList arrayList6 = qz1VarG3.b;
                                if (arrayList6 == null) {
                                    arrayList6 = null;
                                }
                                cp1Var2.i0(i, arrayList6);
                                ArrayList arrayList7 = this.X;
                                qz1VarG3.b = null;
                                qz1 qz1Var3 = (qz1) arrayList7.set(i, qz1VarG3);
                                if (qz1Var3 != null) {
                                    this.z0.D(qz1Var3.a);
                                }
                                this.z0.E(qz1VarG3.a);
                                bo2Var4 = qz1VarG3.a;
                                i++;
                            }
                        }
                    }
                    ArrayList arrayListA = this.z0.A(this.z, this.y0);
                    if (this.y0.l()) {
                        a54 a54Var = this.Y;
                        a54Var.b = arrayListA;
                        a54Var.a();
                        this.Y.c = this.y0.b;
                    }
                    if (!this.f) {
                        bc4 bc4Var = this.z0;
                        a54 a54Var2 = this.Y;
                        ed4 ed4Var = (ed4) bc4Var.a;
                        if (ed4Var != null) {
                            hm2 hm2Var = new hm2(i2, i, 8);
                            CodeEditor codeEditor = (CodeEditor) ((WeakReference) ed4Var.f).get();
                            if (codeEditor != null && bc4Var == codeEditor.getEditorLanguage().c()) {
                                ed4Var.V(new b0(9, codeEditor, a54Var2, hm2Var));
                                return true;
                            }
                        }
                    }
                    return true;
                default:
                    return true;
            }
        } catch (Exception e) {
            a1.o("AsyncAnalysis", "Thread " + Thread.currentThread().getName() + " failed", e);
            return false;
        }
    }

    public final void b() {
        lb lbVar = new lb(12);
        this.Z = lbVar;
        a54 a54Var = new a54();
        a54Var.c = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        int i = 0;
        a54Var.d = false;
        a54Var.a = lbVar;
        a54Var.b = new ArrayList(128);
        this.Y = a54Var;
        lb lbVar2 = this.Z;
        lbVar2.getClass();
        bo2 bo2Var = null;
        while (i < this.z.b.size() && !this.f && !isInterrupted()) {
            qz1 qz1VarG = this.z0.G(this.z.o(i), bo2Var);
            bo2 bo2Var2 = qz1VarG.a;
            ArrayList arrayList = qz1VarG.b;
            if (arrayList == null) {
                arrayList = null;
            }
            ArrayList arrayList2 = this.X;
            qz1VarG.b = null;
            arrayList2.add(qz1VarG);
            this.z0.E(qz1VarG.a);
            ((ReentrantLock) lbVar2.f).lock();
            try {
                ((ArrayList) lbVar2.z).add(i, new hf(arrayList));
                ((ReentrantLock) lbVar2.f).unlock();
                i++;
                bo2Var = bo2Var2;
            } catch (Throwable th) {
                ((ReentrantLock) lbVar2.f).unlock();
                throw th;
            }
        }
        this.Y.b = this.z0.A(this.z, this.y0);
        a54 a54Var2 = this.Y;
        a54Var2.c = this.y0.b;
        a54Var2.a();
        if (this.f) {
            return;
        }
        this.z0.F(this.Y);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.f && !isInterrupted()) {
            try {
                Message message = (Message) this.b.take();
                if (!a(message)) {
                    return;
                } else {
                    message.recycle();
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }
}
