package defpackage;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.util.SparseIntArray;
import io.github.rosemoe.sora.langs.textmate.registry.model.ThemeModel;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.dns.DnsRecord;
import j$.time.Duration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import org.eclipse.tm4e.languageconfiguration.internal.model.CharacterPair;
import org.eclipse.tm4e.languageconfiguration.internal.model.FoldingRules;
import org.eclipse.tm4e.languageconfiguration.internal.model.LanguageConfiguration;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bc4 extends m0 implements dd4 {
    public static int n;
    public jf c;
    public volatile long d;
    public final nv1 e;
    public bd4 f;
    public final dc4 g;
    public final LanguageConfiguration h;
    public final ed4 i;
    public final tv2 j;
    public final boolean k;
    public final ha1 l;
    public final dm m = new dm();

    public bc4(dc4 dc4Var, nv1 nv1Var, LanguageConfiguration languageConfiguration, ed4 ed4Var) {
        FoldingRules folding;
        this.g = dc4Var;
        this.f = ((ThemeModel) ed4Var.A).getTheme();
        this.e = nv1Var;
        this.i = ed4Var;
        if (!((ArrayList) ed4Var.f).contains(this)) {
            ed4Var.h(this);
        }
        if (languageConfiguration != null) {
            this.h = languageConfiguration;
            List<CharacterPair> brackets = languageConfiguration.getBrackets();
            if (brackets != null && !brackets.isEmpty()) {
                int size = brackets.size();
                for (CharacterPair characterPair : brackets) {
                    if (characterPair.open.length() != 1 || characterPair.close.length() != 1) {
                        size--;
                    }
                }
                char[] cArr = new char[size * 2];
                int i = 0;
                for (CharacterPair characterPair2 : brackets) {
                    if (characterPair2.open.length() == 1 && characterPair2.close.length() == 1) {
                        int i2 = i * 2;
                        cArr[i2] = characterPair2.open.charAt(0);
                        cArr[i2 + 1] = characterPair2.close.charAt(0);
                        i++;
                    }
                }
                this.l = new ha1(cArr);
            }
        } else {
            this.h = null;
        }
        LanguageConfiguration languageConfiguration2 = this.h;
        if (languageConfiguration2 == null || (folding = languageConfiguration2.getFolding()) == null) {
            return;
        }
        this.k = folding.offSide;
        String str = "(" + folding.markersStart + ")|(?:" + folding.markersEnd + ")";
        this.j = aw2.a ? new g42(str, false) : new bp2(str, false);
    }

    public final ArrayList A(ld0 ld0Var, qt qtVar) {
        ed4 ed4Var;
        CodeEditor codeEditor;
        ArrayList arrayList = new ArrayList();
        dc4 dc4Var = this.g;
        tv2 tv2Var = this.j;
        if (tv2Var != null) {
            try {
                dc4Var.getClass();
                wh1 wh1VarC = gb4.C(ld0Var, this.k, this, tv2Var, qtVar);
                SparseIntArray sparseIntArray = wh1VarC.a;
                arrayList.ensureCapacity(sparseIntArray.size());
                for (int i = 0; i < sparseIntArray.size() && qtVar.l(); i++) {
                    int i2 = sparseIntArray.get(i) & 16777215;
                    int i3 = 16777215 & wh1VarC.b.get(i);
                    if (i2 != i3) {
                        j60 j60Var = new j60();
                        j60Var.e = true;
                        j60Var.a = i2;
                        j60Var.c = i3;
                        int i4 = ld0Var.o(i2).f;
                        char[] cArr = ld0Var.o(i2).b;
                        int i5 = 0;
                        int i6 = 0;
                        while (i5 < i4) {
                            char c = cArr[i5];
                            if (c != ' ') {
                                if (c != '\t') {
                                    break;
                                }
                                i6 += 4;
                            } else {
                                i6++;
                            }
                            i5++;
                        }
                        if (i5 == i4) {
                            i6 = -1;
                        }
                        j60Var.b = i6;
                        j60Var.d = i6;
                        arrayList.add(j60Var);
                    }
                }
                Collections.sort(arrayList, j60.f);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread threadCurrentThread = Thread.currentThread();
            if (threadCurrentThread.getClass() != jf.class) {
                throw new IllegalThreadStateException();
            }
            ((jf) threadCurrentThread).Y.d = true;
        }
        if (qtVar.l() && (ed4Var = (ed4) this.a) != null && (codeEditor = (CodeEditor) ((WeakReference) ed4Var.f).get()) != null && this == codeEditor.getEditorLanguage().c()) {
            ha1 ha1Var = (ha1) ed4Var.A;
            ha1 ha1Var2 = this.l;
            if (ha1Var != ha1Var2) {
                ed4Var.A = ha1Var2;
                ed4Var.V(new d4(28, ed4Var));
            }
        }
        return arrayList;
    }

    public final qz1 B(int i) {
        jf jfVar = this.c;
        if (jfVar != Thread.currentThread()) {
            throw new SecurityException("Can not get state from non-analytical or abandoned thread");
        }
        if (i < 0 || i >= jfVar.X.size()) {
            return null;
        }
        return (qz1) jfVar.X.get(i);
    }

    public final synchronized void C() {
        this.d++;
    }

    public final void D(Object obj) {
        this.g.getClass();
        for (String str : ((bo2) obj).c) {
            dm dmVar = this.m;
            HashMap map = (HashMap) dmVar.b;
            ReentrantLock reentrantLock = (ReentrantLock) dmVar.a;
            reentrantLock.lock();
            try {
                ln2 ln2Var = (ln2) map.get(str);
                if (ln2Var != null) {
                    int i = ln2Var.a - 1;
                    ln2Var.a = i;
                    if (i <= 0) {
                        map.remove(str);
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void E(Object obj) {
        this.g.getClass();
        Iterator it = ((bo2) obj).c.iterator();
        while (it.hasNext()) {
            this.m.a((String) it.next());
        }
    }

    public final void F(a54 a54Var) {
        CodeEditor codeEditor;
        ed4 ed4Var = (ed4) this.a;
        if (ed4Var == null || (codeEditor = (CodeEditor) ((WeakReference) ed4Var.f).get()) == null || this != codeEditor.getEditorLanguage().c()) {
            return;
        }
        ed4Var.V(new xy0(2, codeEditor, a54Var));
    }

    public final qz1 G(ud0 ud0Var, Object obj) {
        String string;
        boolean z;
        qz1 qz1Var;
        boolean z2;
        String str;
        int iA;
        bo2 bo2Var = (bo2) obj;
        synchronized (this) {
            try {
                int i = 0;
                boolean z3 = true;
                if (ha0.w(ud0Var)) {
                    int length = ud0Var.b.length;
                    int i2 = ud0Var.f;
                    if (length == i2) {
                        ud0Var.c(i2 + 1);
                    }
                    char[] cArr = ud0Var.b;
                    int i3 = ud0Var.f;
                    cArr[i3] = '\n';
                    string = new String(cArr, 0, i3 + 1);
                } else {
                    string = ud0Var.toString();
                }
                ArrayList arrayList = new ArrayList();
                Pattern pattern = l44.a;
                int i4 = 0;
                while (true) {
                    if (i4 >= string.length()) {
                        z = false;
                        break;
                    }
                    if (Character.isSurrogate(string.charAt(i4))) {
                        z = true;
                        break;
                    }
                    i4++;
                }
                e24 e24VarG = ((xp1) this.e).g(string, bo2Var == null ? null : bo2Var.a, Duration.ofSeconds(2L));
                int length2 = ((int[]) e24VarG.f).length / 2;
                this.g.getClass();
                ArrayList arrayList2 = new ArrayList();
                int i5 = 0;
                while (i5 < length2) {
                    int i6 = i5 * 2;
                    int iA2 = l44.a(((int[]) e24VarG.f)[i6], string, z);
                    if (i5 == 0 && iA2 != 0) {
                        arrayList.add(as2.a(i, 5L));
                    }
                    int i7 = ((int[]) e24VarG.f)[i6 + 1];
                    int i8 = (16744448 & i7) >>> 15;
                    int i9 = (i7 & 30720) >>> 11;
                    int i10 = (i7 & 768) >>> 8;
                    this.g.getClass();
                    if (i10 == 0) {
                        int i11 = i5 + 1;
                        if (i11 == length2) {
                            iA = ud0Var.f;
                            z2 = z3;
                        } else {
                            z2 = z3;
                            iA = l44.a(((int[]) e24VarG.f)[i11 * 2], string, z);
                        }
                        if (iA > iA2) {
                            if (ao2.a(ao2.a, string.charAt(iA2))) {
                                int i12 = iA2 + 1;
                                while (true) {
                                    if (i12 >= iA) {
                                        arrayList2.add(string.substring(iA2, iA));
                                        break;
                                    }
                                    int i13 = i12;
                                    if (!ao2.a(ao2.b, string.charAt(i12))) {
                                        break;
                                    }
                                    i12 = i13 + 1;
                                }
                            }
                        }
                    } else {
                        z2 = z3;
                    }
                    as2 as2VarA = as2.a(iA2, uf2.G(i8 + DnsRecord.CLASS_ANY, (i9 & 2) != 0 ? z2 : false, (i9 & 1) != 0 ? z2 : false));
                    as2VarA.c = Integer.valueOf(i10);
                    if ((i9 & 4) != 0 && (str = (String) this.f.b.c.get(i8)) != null) {
                        if (Color.parseColor(str) == 0) {
                            throw new UnsupportedOperationException();
                        }
                        throw new UnsupportedOperationException();
                    }
                    arrayList.add(as2VarA);
                    i5++;
                    z3 = z2;
                    i = 0;
                }
                t24 t24Var = (t24) e24VarG.z;
                tv2 tv2Var = this.j;
                uv2 uv2VarA = tv2Var == null ? null : tv2Var.a(zv2.c(string));
                char[] cArr2 = ud0Var.b;
                int length3 = string.length() - 1;
                this.g.getClass();
                int i14 = 0;
                int i15 = 0;
                while (i14 < length3) {
                    char c = cArr2[i14];
                    if (c != ' ') {
                        if (c != '\t') {
                            break;
                        }
                        i15 = (i15 - (i15 % 4)) + 4;
                    } else {
                        i15++;
                    }
                    i14++;
                }
                if (i14 == length3) {
                    i15 = -1;
                }
                bo2 bo2Var2 = new bo2();
                bo2Var2.a = t24Var;
                bo2Var2.b = uv2VarA;
                bo2Var2.d = i15;
                bo2Var2.c = arrayList2;
                qz1Var = new qz1();
                qz1Var.a = bo2Var2;
                qz1Var.b = arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qz1Var;
    }

    @Override // defpackage.dd4
    public final void b(ThemeModel themeModel) {
        this.f = themeModel.getTheme();
    }

    @Override // defpackage.m0
    public final void h(q30 q30Var, q30 q30Var2) {
        if (this.c != null) {
            C();
            jf jfVar = this.c;
            kf kfVar = new kf(ez4.M(q30Var.b, q30Var.c), ez4.M(q30Var2.b, q30Var2.c), null);
            jfVar.getClass();
            Message messageObtain = Message.obtain();
            messageObtain.what = 11451402;
            messageObtain.obj = kfVar;
            jfVar.b.offer(messageObtain);
        }
    }

    @Override // defpackage.m0
    public final void i() {
        jf jfVar = this.c;
        if (jfVar != null) {
            if (jfVar.isAlive()) {
                this.c.interrupt();
            }
            this.c.f = true;
        }
        this.c = null;
        super.i();
        ed4 ed4Var = this.i;
        synchronized (ed4Var) {
            ((ArrayList) ed4Var.f).remove(this);
        }
    }

    @Override // defpackage.m0
    public final void m(q30 q30Var, q30 q30Var2, CharSequence charSequence) {
        if (this.c != null) {
            C();
            jf jfVar = this.c;
            kf kfVar = new kf(ez4.M(q30Var.b, q30Var.c), ez4.M(q30Var2.b, q30Var2.c), charSequence);
            jfVar.getClass();
            Message messageObtain = Message.obtain();
            messageObtain.what = 11451402;
            messageObtain.obj = kfVar;
            jfVar.b.offer(messageObtain);
        }
    }

    @Override // defpackage.m0
    public final void s() {
        int i;
        jf jfVar = this.c;
        if (jfVar != null) {
            if (jfVar.isAlive()) {
                this.c.interrupt();
                this.c.f = true;
            }
            this.c = null;
        }
        wd0 wd0Var = (wd0) this.b;
        if (wd0Var != null) {
            ld0 ld0Var = (ld0) wd0Var.b;
            ArrayList arrayList = ld0Var.b;
            ld0Var.u(false);
            try {
                ld0 ld0Var2 = new ld0(null, false);
                ArrayList arrayList2 = ld0Var2.b;
                arrayList2.remove(0);
                arrayList2.ensureCapacity(arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new ud0((ud0) it.next()));
                }
                ld0Var2.A = ld0Var.A;
                ld0Var.F(false);
                ld0Var2.A(false);
                jf jfVar2 = new jf(this);
                this.c = jfVar2;
                StringBuilder sb = new StringBuilder("AsyncAnalyzer-");
                synchronized (bc4.class) {
                    i = n + 1;
                    n = i;
                }
                sb.append(i);
                jfVar2.setName(sb.toString());
                jf jfVar3 = this.c;
                jfVar3.getClass();
                Message messageObtain = Message.obtain();
                messageObtain.what = 11451401;
                messageObtain.obj = ld0Var2;
                jfVar3.b.offer(messageObtain);
                C();
                F(null);
                this.c.start();
            } catch (Throwable th) {
                ld0Var.F(false);
                throw th;
            }
        }
    }

    @Override // defpackage.m0
    public final void t(wd0 wd0Var, Bundle bundle) {
        super.t(wd0Var, bundle);
        dm dmVar = this.m;
        ReentrantLock reentrantLock = (ReentrantLock) dmVar.a;
        reentrantLock.lock();
        try {
            ((HashMap) dmVar.b).clear();
        } finally {
            reentrantLock.unlock();
        }
    }
}
