package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;
import com.getsurfboard.R;
import com.getsurfboard.backup.model.BackupVersionInfo;
import com.getsurfboard.ui.fragment.settings.AppSettingsFragment;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function2;
import org.conscrypt.FileClientSessionCache;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gd extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public /* synthetic */ Object Y;
    public final /* synthetic */ Object Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gd(Object obj, Object obj2, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Y = obj;
        this.Z = obj2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws Throwable {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
            case 1:
                return ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 2:
                return ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 3:
                return ((gd) n((ge0) obj2, (j24) obj)).p(xl4Var);
            case 4:
                return ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 5:
                ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
            case 6:
                ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
            case 7:
                ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
            case 8:
                return ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
            case 10:
                ((gd) n((ge0) obj2, (String) obj)).p(xl4Var);
                return xl4Var;
            case 11:
                ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                throw null;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 13:
                return ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 14:
                ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 16:
                return ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 17:
                return ((gd) n((ge0) obj2, (rn2) obj)).p(xl4Var);
            case 18:
                ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
            default:
                ((gd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.Z;
        switch (i) {
            case 0:
                return new gd((AppSettingsFragment) this.Y, (Uri) obj2, ge0Var, 0);
            case 1:
                return new gd((qz2) this.Y, (vf) obj2, ge0Var, 1);
            case 2:
                return new gd((jj) this.Y, (Uri) obj2, ge0Var, 2);
            case 3:
                gd gdVar = new gd((j24) obj2, ge0Var, 3);
                gdVar.Y = obj;
                return gdVar;
            case 4:
                return new gd((File) this.Y, (ge2[]) obj2, ge0Var, 4);
            case 5:
                return new gd((ma1) this.Y, (ArrayList) obj2, ge0Var, 5);
            case 6:
                return new gd((on2) this.Y, (zn) obj2, ge0Var, 6);
            case 7:
                return new gd((on2) this.Y, (hu2) obj2, ge0Var, 7);
            case 8:
                gd gdVar2 = new gd((fn) obj2, ge0Var, 8);
                gdVar2.Y = obj;
                return gdVar2;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                gd gdVar3 = new gd((w92) obj2, ge0Var, 9);
                gdVar3.Y = obj;
                return gdVar3;
            case 10:
                gd gdVar4 = new gd((se2) obj2, ge0Var, 10);
                gdVar4.Y = obj;
                return gdVar4;
            case 11:
                gd gdVar5 = new gd((oj2) obj2, ge0Var, 11);
                gdVar5.Y = obj;
                return gdVar5;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                gd gdVar6 = new gd((CharSequence) obj2, ge0Var, 12);
                gdVar6.Y = obj;
                return gdVar6;
            case 13:
                return new gd((String) this.Y, (String) obj2, ge0Var, 13);
            case 14:
                return new gd((p12) this.Y, (String) obj2, ge0Var, 14);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new gd((Context) this.Y, (Uri) obj2, ge0Var, 15);
            case 16:
                gd gdVar7 = new gd((Function2) obj2, ge0Var, 16);
                gdVar7.Y = obj;
                return gdVar7;
            case 17:
                gd gdVar8 = new gd((Set) obj2, ge0Var, 17);
                gdVar8.Y = obj;
                return gdVar8;
            case 18:
                return new gd((LinearProgressIndicator) this.Y, (Long) obj2, ge0Var, 18);
            default:
                return new gd((b84) this.Y, (String) obj2, ge0Var, 19);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [b12, z02] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r6v0, types: [al0, ge0] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v4, types: [g41] */
    /* JADX WARN: Type inference failed for: r7v41, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Iterable] */
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
    @Override // defpackage.kk
    public final Object p(Object obj) throws Throwable {
        ?? arrayList;
        String strA;
        String strA2;
        List listU;
        zk zkVar;
        Object next;
        int i = 2;
        boolean z = false;
        z = false;
        boolean z2 = false;
        z = false;
        boolean z3 = false;
        z = false;
        ?? lowerCase = 0;
        String strT = null;
        Object objA = null;
        lowerCase = 0;
        switch (this.X) {
            case 0:
                n12.S(obj);
                AppSettingsFragment appSettingsFragment = (AppSettingsFragment) this.Y;
                Context contextRequireContext = appSettingsFragment.requireContext();
                contextRequireContext.getClass();
                Uri uri = (Uri) this.Z;
                Set set = appSettingsFragment.pendingExportSections;
                char[] cArr = appSettingsFragment.pendingExportPassword;
                uri.getClass();
                set.getClass();
                OutputStream outputStreamOpenOutputStream = contextRequireContext.getContentResolver().openOutputStream(uri, "wt");
                outputStreamOpenOutputStream.getClass();
                try {
                    iq1 iq1Var = ui.a;
                    ui.b(outputStreamOpenOutputStream, set, fx3.K(), new BackupVersionInfo("mobile-2.34.1 (Build 286)", z ? 1 : 0, i, lowerCase), cArr);
                    outputStreamOpenOutputStream.close();
                    return xl4.a;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        ez4.l(outputStreamOpenOutputStream, th);
                        throw th2;
                    }
                }
            case 1:
                n12.S(obj);
                qz2 qz2Var = (qz2) this.Y;
                ez2 ez2Var = qz2Var.f;
                ez2 ez2Var2 = qz2Var.e;
                ez2Var.getClass();
                ju0 ju0VarN = je.n(new i13(ez2Var, ez2Var2, ez2Var.b, ez2Var2.b));
                ?? D0 = gb4.d0(0, ez2Var.b);
                if (!(D0 instanceof Collection) || !((Collection) D0).isEmpty()) {
                    Iterator it = D0.iterator();
                    while (true) {
                        if (((a12) it).z) {
                            if (ju0VarN.a(((a12) it).nextInt()) != -1) {
                                z = true;
                            }
                        }
                    }
                }
                return new h13(ju0VarN, z);
            case 2:
                n12.S(obj);
                Context contextRequireContext2 = ((jj) this.Y).a.requireContext();
                contextRequireContext2.getClass();
                Uri uri2 = (Uri) this.Z;
                uri2.getClass();
                InputStream inputStreamOpenInputStream = contextRequireContext2.getContentResolver().openInputStream(uri2);
                inputStreamOpenInputStream.getClass();
                try {
                    k03 k03VarB = lj.b(inputStreamOpenInputStream, null);
                    inputStreamOpenInputStream.close();
                    return k03VarB;
                } finally {
                }
            case 3:
                n12.S(obj);
                j24 j24Var = (j24) this.Y;
                if ((j24Var instanceof fi0) && j24Var.a <= ((j24) this.Z).a) {
                    z3 = true;
                }
                return Boolean.valueOf(z3);
            case 4:
                ge2[] ge2VarArr = (ge2[]) this.Z;
                n12.S(obj);
                File file = (File) this.Y;
                if (file == null || file.isFile() || ge2VarArr == null || ge2VarArr.length == 0) {
                    return null;
                }
                File file2 = new File(file, ha0.x(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date()), ".log"));
                if (file2.exists() && !file2.delete()) {
                    return null;
                }
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
                    for (ge2 ge2Var : ge2VarArr) {
                        bufferedWriter.write(ge2Var.g + "\n");
                    }
                    bufferedWriter.close();
                    return file2;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            case 5:
                ArrayList<aa1> arrayList2 = (ArrayList) this.Z;
                n12.S(obj);
                List list = (List) d73.b.d();
                if (list != null) {
                    arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        if (obj2 instanceof t53) {
                            arrayList.add(obj2);
                        }
                    }
                } else {
                    arrayList = g41.b;
                }
                fi4 fi4Var = ((ma1) this.Y).A;
                if (fi4Var == null) {
                    n12.T("type");
                    throw null;
                }
                int iOrdinal = fi4Var.ordinal();
                if (iOrdinal == 0) {
                    for (t53 t53Var : arrayList) {
                        ?? hashSet = new HashSet();
                        Collection<na3> collectionValues = t53Var.H0.values();
                        collectionValues.getClass();
                        for (na3 na3Var : collectionValues) {
                            LinkedHashSet<String> linkedHashSet = na3Var instanceof ka3 ? ((ka3) na3Var).z : na3Var instanceof ma3 ? ((ma3) na3Var).z : na3Var instanceof ia3 ? ((ia3) na3Var).z : na3Var instanceof ja3 ? ((ja3) na3Var).z : na3Var instanceof la3 ? ((la3) na3Var).X : null;
                            if (linkedHashSet != null) {
                                for (String str : linkedHashSet) {
                                    if (!hashSet.contains(str)) {
                                        hashSet.add(str);
                                        if (!arrayList2.isEmpty()) {
                                            Iterator it2 = arrayList2.iterator();
                                            while (it2.hasNext()) {
                                                if (n12.c(((aa1) it2.next()).a, str)) {
                                                    for (aa1 aa1Var : arrayList2) {
                                                        if (n12.c(aa1Var.a, str)) {
                                                            int i2 = aa1Var.d;
                                                            aa1Var.d = i2 + 1;
                                                            new Integer(i2);
                                                        }
                                                    }
                                                    e04.h("Collection contains no element matching the predicate.");
                                                    return null;
                                                }
                                            }
                                        }
                                        n13 n13VarO = fx3.o(str);
                                        if (n13VarO != null) {
                                            String str2 = n13VarO.a;
                                            Uri uri3 = n13VarO.c;
                                            long j = n13VarO.d;
                                            arrayList2.add(new aa1(str2, ez4.S(str2), j, new gx3(str2, uri3, j)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (iOrdinal == 1) {
                    for (t53 t53Var2 : arrayList) {
                        ?? hashSet2 = new HashSet();
                        for (tn3 tn3Var : t53Var2.J0) {
                            if (tn3Var.getType().equals("RULE-SET")) {
                                sm3 sm3Var = tn3Var instanceof sm3 ? (sm3) tn3Var : null;
                                if (sm3Var != null && (strA = sm3Var.a()) != null && !hashSet2.contains(strA)) {
                                    hashSet2.add(strA);
                                    if (!arrayList2.isEmpty()) {
                                        Iterator it3 = arrayList2.iterator();
                                        while (it3.hasNext()) {
                                            if (n12.c(((aa1) it3.next()).a, strA)) {
                                                for (aa1 aa1Var2 : arrayList2) {
                                                    if (n12.c(aa1Var2.a, strA)) {
                                                        int i3 = aa1Var2.d;
                                                        aa1Var2.d = i3 + 1;
                                                        new Integer(i3);
                                                    }
                                                }
                                                e04.h("Collection contains no element matching the predicate.");
                                                return null;
                                            }
                                        }
                                    }
                                    xn3 xn3VarE = tj4.E(strA);
                                    if (xn3VarE != null) {
                                        String str3 = xn3VarE.a;
                                        Uri uri4 = xn3VarE.c;
                                        long j2 = xn3VarE.d;
                                        arrayList2.add(new aa1(str3, ez4.S(str3), j2, new ix3(str3, uri4, j2)));
                                    }
                                }
                            }
                        }
                        Set<ss1> setKeySet = t53Var2.F0.keySet();
                        setKeySet.getClass();
                        for (ss1 ss1Var : setKeySet) {
                            if (ss1Var instanceof rs1) {
                                String str4 = ((rs1) ss1Var).f;
                                if (hashSet2.contains(str4)) {
                                    continue;
                                } else {
                                    hashSet2.add(str4);
                                    if (!arrayList2.isEmpty()) {
                                        Iterator it4 = arrayList2.iterator();
                                        while (it4.hasNext()) {
                                            if (n12.c(((aa1) it4.next()).a, str4)) {
                                                for (aa1 aa1Var3 : arrayList2) {
                                                    if (n12.c(aa1Var3.a, str4)) {
                                                        int i4 = aa1Var3.d;
                                                        aa1Var3.d = i4 + 1;
                                                        new Integer(i4);
                                                    }
                                                }
                                                e04.h("Collection contains no element matching the predicate.");
                                                return null;
                                            }
                                        }
                                    }
                                    xn3 xn3VarE2 = tj4.E(str4);
                                    if (xn3VarE2 != null) {
                                        String str5 = xn3VarE2.a;
                                        Uri uri5 = xn3VarE2.c;
                                        long j3 = xn3VarE2.d;
                                        arrayList2.add(new aa1(str5, ez4.S(str5), j3, new ix3(str5, uri5, j3)));
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (iOrdinal != 2) {
                        g.d();
                        return null;
                    }
                    for (t53 t53Var3 : arrayList) {
                        ?? hashSet3 = new HashSet();
                        for (tn3 tn3Var2 : t53Var3.J0) {
                            if (tn3Var2.getType().equals("DOMAIN-SET")) {
                                sm3 sm3Var2 = tn3Var2 instanceof sm3 ? (sm3) tn3Var2 : null;
                                if (sm3Var2 != null && (strA2 = sm3Var2.a()) != null && !hashSet3.contains(strA2)) {
                                    hashSet3.add(strA2);
                                    if (!arrayList2.isEmpty()) {
                                        Iterator it5 = arrayList2.iterator();
                                        while (it5.hasNext()) {
                                            if (n12.c(((aa1) it5.next()).a, strA2)) {
                                                for (aa1 aa1Var4 : arrayList2) {
                                                    if (n12.c(aa1Var4.a, strA2)) {
                                                        int i5 = aa1Var4.d;
                                                        aa1Var4.d = i5 + 1;
                                                        new Integer(i5);
                                                    }
                                                }
                                                e04.h("Collection contains no element matching the predicate.");
                                                return null;
                                            }
                                        }
                                    }
                                    hx0 hx0VarQ = vo.q(strA2);
                                    if (hx0VarQ != null) {
                                        String str6 = hx0VarQ.a;
                                        Uri uri6 = hx0VarQ.c;
                                        long j4 = hx0VarQ.d;
                                        arrayList2.add(new aa1(str6, ez4.S(str6), j4, new bx3(str6, uri6, j4)));
                                    }
                                }
                            }
                        }
                        Set<ss1> setKeySet2 = t53Var3.F0.keySet();
                        setKeySet2.getClass();
                        for (ss1 ss1Var2 : setKeySet2) {
                            if (ss1Var2 instanceof ps1) {
                                String str7 = ((ps1) ss1Var2).b.b;
                                if (hashSet3.contains(str7)) {
                                    continue;
                                } else {
                                    hashSet3.add(str7);
                                    if (!arrayList2.isEmpty()) {
                                        Iterator it6 = arrayList2.iterator();
                                        while (it6.hasNext()) {
                                            if (n12.c(((aa1) it6.next()).a, str7)) {
                                                for (aa1 aa1Var5 : arrayList2) {
                                                    if (n12.c(aa1Var5.a, str7)) {
                                                        int i6 = aa1Var5.d;
                                                        aa1Var5.d = i6 + 1;
                                                        new Integer(i6);
                                                    }
                                                }
                                                e04.h("Collection contains no element matching the predicate.");
                                                return null;
                                            }
                                        }
                                    }
                                    hx0 hx0VarQ2 = vo.q(str7);
                                    if (hx0VarQ2 != null) {
                                        String str8 = hx0VarQ2.a;
                                        Uri uri7 = hx0VarQ2.c;
                                        long j5 = hx0VarQ2.d;
                                        arrayList2.add(new aa1(str8, ez4.S(str8), j5, new bx3(str8, uri7, j5)));
                                    }
                                }
                            }
                        }
                    }
                }
                if (arrayList2.size() > 1) {
                    h70.T(arrayList2, new e1(12));
                }
                return xl4.a;
            case 6:
                n12.S(obj);
                ((on2) this.Y).f((zn) this.Z);
                return xl4.a;
            case 7:
                n12.S(obj);
                ((on2) this.Y).j((hu2) this.Z);
                return xl4.a;
            case 8:
                n12.S(obj);
                cf0 cf0VarI = ((lf0) this.Y).I();
                fn fnVar = (fn) this.Z;
                try {
                    vd4 vd4Var = new vd4();
                    vd4Var.Y = je.K(je.G(cf0VarI), true, vd4Var);
                    while (true) {
                        Unsafe unsafe = re.a;
                        long j6 = vd4.Z;
                        int intVolatile = unsafe.getIntVolatile(vd4Var, j6);
                        if (intVolatile != 0) {
                            if (intVolatile != 2 && intVolatile != 3) {
                                vd4.o(intVolatile);
                                throw null;
                            }
                        } else if (!unsafe.compareAndSwapInt(vd4Var, j6, intVolatile, 0)) {
                        }
                    }
                    try {
                        return jn.b((jn) fnVar.f);
                    } finally {
                        vd4Var.n();
                    }
                } catch (InterruptedException e2) {
                    throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e2);
                }
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                n12.S(obj);
                lf0 lf0Var = (lf0) this.Y;
                w92 w92Var = (w92) this.Z;
                r92 r92Var = w92Var.b;
                if (r92Var.b().compareTo(q92.f) >= 0) {
                    r92Var.a(w92Var);
                } else {
                    v32 v32Var = (v32) lf0Var.I().Z(pr1.X);
                    if (v32Var != null) {
                        v32Var.g(null);
                    }
                }
                return xl4.a;
            case 10:
                String str9 = (String) this.Y;
                n12.S(obj);
                oe2 oe2Var = ((se2) this.Z).z;
                if (str9.length() <= 0) {
                    str9 = null;
                }
                synchronized (oe2Var.f) {
                    if (str9 != null) {
                        try {
                            if (str9.length() <= 0) {
                                str9 = null;
                            }
                            if (str9 != null) {
                                Locale locale = Locale.getDefault();
                                locale.getClass();
                                lowerCase = str9.toLowerCase(locale);
                                lowerCase.getClass();
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    oe2Var.h = lowerCase;
                    listU = oe2Var.u();
                }
                oe2Var.r(listU);
                return xl4.a;
            case 11:
                n12.S(obj);
                throw null;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                n12.S(obj);
                CharSequence charSequence = (CharSequence) this.Z;
                SystemClock.elapsedRealtime();
                return charSequence;
            case 13:
                n12.S(obj);
                e1 e1Var = d73.a;
                String str10 = (String) this.Y;
                File fileG = d73.g(str10);
                String str11 = (String) this.Z;
                if (fileG.exists()) {
                    List list2 = (List) d73.b.d();
                    if (list2 != null) {
                        Iterator it7 = list2.iterator();
                        while (true) {
                            if (it7.hasNext()) {
                                next = it7.next();
                                if (n12.c(((zk) next).getName(), str10)) {
                                }
                            } else {
                                next = null;
                            }
                        }
                        zkVar = (zk) next;
                    } else {
                        zkVar = null;
                    }
                    if (zkVar instanceof t53) {
                        objA = t53.a((t53) zkVar, str11, 4194302);
                    } else if (zkVar instanceof p12) {
                        objA = p12.a((p12) zkVar, str11);
                    }
                    if (objA != null) {
                        on2 on2Var = d73.b;
                        Collection collection = (List) on2Var.d();
                        if (collection == null) {
                            collection = g41.b;
                        }
                        ArrayList arrayList3 = new ArrayList(collection);
                        arrayList3.add(objA);
                        arrayList3.remove(zkVar);
                        h70.T(arrayList3, d73.a);
                        on2Var.i(arrayList3);
                    }
                    if (n12.c(i73.a(), str10)) {
                        i73.b(str11);
                        if (objA instanceof t53) {
                            d73.c.i(objA);
                        }
                    }
                    str11.getClass();
                    ua3 ua3VarT = oj0.a.t();
                    ua3VarT.getClass();
                    ke0.r(ua3VarT.a, false, true, new ta3(str11, str10, 1));
                    fileG.renameTo(d73.g(str11));
                }
                return fileG;
            case 14:
                n12.S(obj);
                String strN = ha0.n("saveInvalidProfile: ", ((p12) this.Y).b);
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("ProfileManager", strN, null);
                }
                d73.k(true);
                try {
                    File fileG2 = d73.g(((p12) this.Y).b);
                    String str12 = (String) this.Z;
                    File parentFile = fileG2.getParentFile();
                    if ((parentFile == null || !parentFile.exists()) && !fileG2.mkdirs()) {
                        throw new IllegalStateException("saveInvalidProfile mkdirs failed");
                    }
                    if (!fileG2.exists() && !fileG2.createNewFile()) {
                        throw new IllegalStateException("saveInvalidProfile createNewFile failed");
                    }
                    le1.W(fileG2, str12);
                    Collection collection2 = (List) d73.b.d();
                    if (collection2 == null) {
                        collection2 = g41.b;
                    }
                    ArrayList arrayList4 = new ArrayList(collection2);
                    p12 p12Var = (p12) this.Y;
                    Iterator it8 = arrayList4.iterator();
                    int i7 = 0;
                    while (true) {
                        if (!it8.hasNext()) {
                            i7 = -1;
                        } else if (!n12.c(((zk) it8.next()).getName(), p12Var.b)) {
                            i7++;
                        }
                    }
                    p12 p12Var2 = (p12) this.Y;
                    if (i7 != -1) {
                        arrayList4.set(i7, p12Var2);
                    } else {
                        arrayList4.add(p12Var2);
                        h70.T(arrayList4, d73.a);
                    }
                    d73.b.i(arrayList4);
                    d73.k(false);
                    return xl4.a;
                } finally {
                    d73.k(false);
                }
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                n12.S(obj);
                InputStream inputStreamOpenInputStream2 = ((Context) this.Y).getContentResolver().openInputStream((Uri) this.Z);
                if (inputStreamOpenInputStream2 != null) {
                    try {
                        strT = l72.T(new BufferedReader(new InputStreamReader(inputStreamOpenInputStream2, y30.a), 8192));
                        inputStreamOpenInputStream2.close();
                    } finally {
                    }
                } else {
                    xe.k("Failed to read content from Uri");
                }
                return strT;
            case 16:
                n12.S(obj);
                af0 af0VarZ = ((lf0) this.Y).I().Z(pr1.f);
                af0VarZ.getClass();
                ef0 ef0Var = (ef0) af0VarZ;
                o80 o80VarA = vo.a();
                ji0.A(gp1.b, ef0Var, of0.A, new uf(o80VarA, (Function2) this.Z, lowerCase, 23));
                while (!o80VarA.P()) {
                    try {
                        return ke0.z(ef0Var, new mt(o80VarA, lowerCase, 16));
                    } catch (InterruptedException unused) {
                    }
                }
                return o80VarA.A();
            case 17:
                n12.S(obj);
                Set setKeySet3 = ((rn2) this.Y).a().keySet();
                ArrayList arrayList5 = new ArrayList(f70.Q(10, setKeySet3));
                Iterator it9 = setKeySet3.iterator();
                while (it9.hasNext()) {
                    arrayList5.add(((u33) it9.next()).a);
                }
                Set set2 = (Set) this.Z;
                if (set2 == qv3.a) {
                    z2 = true;
                } else if (!set2.isEmpty()) {
                    Iterator it10 = set2.iterator();
                    while (it10.hasNext()) {
                        if (!arrayList5.contains((String) it10.next())) {
                            z2 = true;
                        }
                    }
                }
                return Boolean.valueOf(z2);
            case 18:
                n12.S(obj);
                LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) this.Y;
                linearProgressIndicator.setIndeterminate(((Long) this.Z) == null);
                if (!linearProgressIndicator.isIndeterminate()) {
                    linearProgressIndicator.setProgress(0);
                }
                return xl4.a;
            default:
                n12.S(obj);
                b84 b84Var = (b84) this.Y;
                ed4 ed4Var = b84Var.I0;
                if (ed4Var != null) {
                    ((TextView) ed4Var.A).setText(b84Var.getString(R.string.fetching_media_from_console_template, (String) this.Z));
                    return xl4.a;
                }
                n12.T("binding");
                throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gd(Object obj, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = obj;
    }
}
