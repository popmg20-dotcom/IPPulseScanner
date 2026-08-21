package defpackage;

import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.getsurfboard.ui.activity.ExitDetailActivity;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.internal.StringUtil;
import io.sentry.android.core.a1;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class uf2 {
    public static volatile Handler b;
    public static Method y0;
    public static boolean z0;
    public static final uo4 f = uo4.z;
    public static final double[][] z = {new double[]{0.001200833568784504d, 0.002389694492170889d, 2.795742885861124E-4d}, new double[]{5.891086651375999E-4d, 0.0029785502573438758d, 3.270666104008398E-4d}, new double[]{1.0146692491640572E-4d, 5.364214359186694E-4d, 0.0032979401770712076d}};
    public static final double[][] A = {new double[]{1373.2198709594231d, -1100.4251190754821d, -7.278681089101213d}, new double[]{-271.815969077903d, 559.6580465940733d, -32.46047482791194d}, new double[]{1.9622899599665666d, -57.173814538844006d, 308.7233197812385d}};
    public static final double[] X = {0.2126d, 0.7152d, 0.0722d};
    public static final double[] Y = {0.015176349177441876d, 0.045529047532325624d, 0.07588174588720938d, 0.10623444424209313d, 0.13658714259697685d, 0.16693984095186062d, 0.19729253930674434d, 0.2276452376616281d, 0.2579979360165119d, 0.28835063437139563d, 0.3188300904430532d, 0.350925934958123d, 0.3848314933096426d, 0.42057480301049466d, 0.458183274052838d, 0.4976837250274023d, 0.5391024159806381d, 0.5824650784040898d, 0.6277969426914107d, 0.6751227633498623d, 0.7244668422128921d, 0.775853049866786d, 0.829304845476233d, 0.8848452951698498d, 0.942497089126609d, 1.0022825574869039d, 1.0642236851973577d, 1.1283421258858297d, 1.1946592148522128d, 1.2631959812511864d, 1.3339731595349034d, 1.407011200216447d, 1.4823302800086415d, 1.5599503113873272d, 1.6398909516233677d, 1.7221716113234105d, 1.8068114625156377d, 1.8938294463134073d, 1.9832442801866852d, 2.075074464868551d, 2.1693382909216234d, 2.2660538449872063d, 2.36523901573795d, 2.4669114995532007d, 2.5710888059345764d, 2.6777882626779785d, 2.7870270208169257d, 2.898822059350997d, 3.0131901897720907d, 3.1301480604002863d, 3.2497121605402226d, 3.3718988244681087d, 3.4967242352587946d, 3.624204428461639d, 3.754355295633311d, 3.887192587735158d, 4.022731918402185d, 4.160988767090289d, 4.301978482107941d, 4.445716283538092d, 4.592217266055746d, 4.741496401646282d, 4.893568542229298d, 5.048448422192488d, 5.20615066083972d, 5.3666897647573375d, 5.5300801301023865d, 5.696336044816294d, 5.865471690767354d, 6.037501145825082d, 6.212438385869475d, 6.390297286737924d, 6.571091626112461d, 6.7548350853498045d, 6.941541251256611d, 7.131223617812143d, 7.323895587840543d, 7.5195704746346665d, 7.7182615035334345d, 7.919981813454504d, 8.124744458384042d, 8.332562408825165d, 8.543448553206703d, 8.757415699253682d, 8.974476575321063d, 9.194643831691977d, 9.417930041841839d, 9.644347703669503d, 9.873909240696694d, 10.106627003236781d, 10.342513269534024d, 10.58158024687427d, 10.8238400726681d, 11.069304815507364d, 11.317986476196008d, 11.569896988756009d, 11.825048221409341d, 12.083451977536606d, 12.345119996613247d, 12.610063955123938d, 12.878295467455942d, 13.149826086772048d, 13.42466730586372d, 13.702830557985108d, 13.984327217668513d, 14.269168601521828d, 14.55736596900856d, 14.848930523210871d, 15.143873411576273d, 15.44220572664832d, 15.743938506781891d, 16.04908273684337d, 16.35764934889634d, 16.66964922287304d, 16.985093187232053d, 17.30399201960269d, 17.62635644741625d, 17.95219714852476d, 18.281524751807332d, 18.614349837764564d, 18.95068293910138d, 19.290534541298456d, 19.633915083172692d, 19.98083495742689d, 20.331304511189067d, 20.685334046541502d, 21.042933821039977d, 21.404114048223256d, 21.76888489811322d, 22.137256497705877d, 22.50923893145328d, 22.884842241736916d, 23.264076429332462d, 23.6469514538663d, 24.033477234264016d, 24.42366364919083d, 24.817520537484558d, 25.21505769858089d, 25.61628489293138d, 26.021211842414342d, 26.429848230738664d, 26.842203703840827d, 27.258287870275353d, 27.678110301598522d, 28.10168053274597d, 28.529008062403893d, 28.96010235337422d, 29.39497283293396d, 29.83362889318845d, 30.276079891419332d, 30.722335150426627d, 31.172403958865512d, 31.62629557157785d, 32.08401920991837d, 32.54558406207592d, 33.010999283389665d, 33.4802739966603d, 33.953417292456834d, 34.430438229418264d, 34.911345834551085d, 35.39614910352207d, 35.88485700094671d, 36.37747846067349d, 36.87402238606382d, 37.37449765026789d, 37.87891309649659d, 38.38727753828926d, 38.89959975977785d, 39.41588851594697d, 39.93615253289054d, 40.460400508064545d, 40.98864111053629d, 41.520882981230194d, 42.05713473317016d, 42.597404951718396d, 43.141702194811224d, 43.6900349931913d, 44.24241185063697d, 44.798841244188324d, 45.35933162437017d, 45.92389141541209d, 46.49252901546552d, 47.065252796817916d, 47.64207110610409d, 48.22299226451468d, 48.808024568002054d, 49.3971762874833d, 49.9904556690408d, 50.587870934119984d, 51.189430279724725d, 51.79514187861014d, 52.40501387947288d, 53.0190544071392d, 53.637271562750364d, 54.259673423945976d, 54.88626804504493d, 55.517063457223934d, 56.15206766869424d, 56.79128866487574d, 57.43473440856916d, 58.08241284012621d, 58.734331877617365d, 59.39049941699807d, 60.05092333227251d, 60.715611475655585d, 61.38457167773311d, 62.057811747619894d, 62.7353394731159d, 63.417162620860914d, 64.10328893648692d, 64.79372614476921d, 65.48848194977529d, 66.18756403501224d, 66.89098006357258d, 67.59873767827808d, 68.31084450182222d, 69.02730813691093d, 69.74813616640164d, 70.47333615344107d, 71.20291564160104d, 71.93688215501312d, 72.67524319850172d, 73.41800625771542d, 74.16517879925733d, 74.9167682708136d, 75.67278210128072d, 76.43322770089146d, 77.1981124613393d, 77.96744375590167d, 78.74122893956174d, 79.51947534912904d, 80.30219030335869d, 81.08938110306934d, 81.88105503125999d, 82.67721935322541d, 83.4778813166706d, 84.28304815182372d, 85.09272707154808d, 85.90692527145302d, 86.72564993000343d, 87.54890820862819d, 88.3767072518277d, 89.2090541872801d, 90.04595612594655d, 90.88742016217518d, 91.73345337380438d, 92.58406282226491d, 93.43925555268066d, 94.29903859396902d, 95.16341895893969d, 96.03240364439274d, 96.9059996312159d, 97.78421388448044d, 98.6670533535366d, 99.55452497210776d};
    public static final Object Z = new Object();

    public uf2(int i) {
        switch (i) {
            case 23:
                new ConcurrentHashMap();
                break;
        }
    }

    public static final ei A(int i) {
        if (i == 0) {
            return ei.b;
        }
        if (i == 1) {
            return ei.f;
        }
        xe.k(ha0.k("Could not convert ", i, " to BackoffPolicy"));
        return null;
    }

    public static final pr2 B(int i) {
        if (i == 0) {
            return pr2.b;
        }
        if (i == 1) {
            return pr2.f;
        }
        if (i == 2) {
            return pr2.z;
        }
        if (i == 3) {
            return pr2.A;
        }
        if (i == 4) {
            return pr2.X;
        }
        if (Build.VERSION.SDK_INT >= 30 && i == 5) {
            return pr2.Y;
        }
        xe.k(ha0.k("Could not convert ", i, " to NetworkType"));
        return null;
    }

    public static final ww2 C(int i) {
        if (i == 0) {
            return ww2.b;
        }
        if (i == 1) {
            return ww2.f;
        }
        xe.k(ha0.k("Could not convert ", i, " to OutOfQuotaPolicy"));
        return null;
    }

    public static final ww4 D(int i) {
        if (i == 0) {
            return ww4.b;
        }
        if (i == 1) {
            return ww4.f;
        }
        if (i == 2) {
            return ww4.z;
        }
        if (i == 3) {
            return ww4.A;
        }
        if (i == 4) {
            return ww4.X;
        }
        if (i == 5) {
            return ww4.Y;
        }
        xe.k(ha0.k("Could not convert ", i, " to State"));
        return null;
    }

    public static double E(double d) {
        double dAbs = Math.abs(d);
        return Math.pow(Math.max(0.0d, (27.13d * dAbs) / (400.0d - dAbs)), 2.380952380952381d) * ((double) (d < 0.0d ? -1 : d == 0.0d ? 0 : 1));
    }

    public static boolean F(double d) {
        return 0.0d <= d && d <= 100.0d;
    }

    public static long G(int i, boolean z2, boolean z3) {
        if (i > 524287 || i < 0) {
            xe.k("color id must be positive and bit count is less than 19");
            return 0L;
        }
        return (z2 ? 274877906944L : 0L) | ((long) i) | (z3 ? 549755813888L : 0L);
    }

    public static final int H(pr2 pr2Var) {
        int iOrdinal = pr2Var.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3) {
                    i = 4;
                    if (iOrdinal != 4) {
                        if (Build.VERSION.SDK_INT >= 30 && pr2Var == pr2.Y) {
                            return 5;
                        }
                        st4.p("Could not convert ", pr2Var, " to int");
                        return 0;
                    }
                }
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ku I(lr1 lr1Var) {
        int i;
        int i2;
        int i3;
        String string;
        lr1 lr1Var2 = lr1Var;
        lr1Var2.getClass();
        int size = lr1Var2.size();
        int i4 = 0;
        boolean z2 = true;
        String str = null;
        boolean z3 = false;
        boolean z4 = false;
        int iN = -1;
        int iN2 = -1;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int iN3 = -1;
        int iN4 = -1;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (i4 < size) {
            String strZ = gb4.z(lr1Var2, i4);
            String strB = gb4.B(lr1Var2, i4);
            if (strZ.equalsIgnoreCase("Cache-Control")) {
                if (str == null) {
                    str = strB;
                }
                i = 0;
                while (i < strB.length()) {
                    int length = strB.length();
                    int length2 = i;
                    while (true) {
                        if (length2 >= length) {
                            i2 = size;
                            length2 = strB.length();
                            break;
                        }
                        i2 = size;
                        if (p44.p0("=,;", strB.charAt(length2))) {
                            break;
                        }
                        length2++;
                        size = i2;
                    }
                    String string2 = p44.U0(strB.substring(i, length2)).toString();
                    if (length2 == strB.length() || strB.charAt(length2) == ',' || strB.charAt(length2) == ';') {
                        i3 = length2 + 1;
                        string = null;
                    } else {
                        int length3 = length2 + 1;
                        byte[] bArr = hz4.a;
                        int length4 = strB.length();
                        while (true) {
                            if (length3 < length4) {
                                char cCharAt = strB.charAt(length3);
                                if (cCharAt != ' ' && cCharAt != '\t') {
                                    break;
                                }
                                length3++;
                            } else {
                                length3 = strB.length();
                                break;
                            }
                        }
                        if (length3 >= strB.length() || strB.charAt(length3) != '\"') {
                            int length5 = strB.length();
                            int length6 = length3;
                            while (true) {
                                if (length6 >= length5) {
                                    length6 = strB.length();
                                    break;
                                }
                                int i5 = length5;
                                if (p44.p0(",;", strB.charAt(length6))) {
                                    break;
                                }
                                length6++;
                                length5 = i5;
                            }
                            int i6 = length6;
                            string = p44.U0(strB.substring(length3, length6)).toString();
                            i3 = i6;
                        } else {
                            int i7 = length3 + 1;
                            int iU0 = p44.u0(strB, StringUtil.DOUBLE_QUOTE, i7, 4);
                            string = strB.substring(i7, iU0);
                            i3 = iU0 + 1;
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(string2)) {
                        i = i3;
                        z3 = true;
                    } else if (HttpHeaders.Values.NO_STORE.equalsIgnoreCase(string2)) {
                        i = i3;
                        z4 = true;
                    } else {
                        if ("max-age".equalsIgnoreCase(string2)) {
                            iN = hz4.n(-1, string);
                        } else if (HttpHeaders.Values.S_MAXAGE.equalsIgnoreCase(string2)) {
                            iN2 = hz4.n(-1, string);
                        } else if ("private".equalsIgnoreCase(string2)) {
                            i = i3;
                            z5 = true;
                        } else if ("public".equalsIgnoreCase(string2)) {
                            i = i3;
                            z6 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(string2)) {
                            i = i3;
                            z7 = true;
                        } else if ("max-stale".equalsIgnoreCase(string2)) {
                            iN3 = hz4.n(ChannelUtils.WRITE_STATUS_SNDBUF_FULL, string);
                        } else if ("min-fresh".equalsIgnoreCase(string2)) {
                            iN4 = hz4.n(-1, string);
                        } else if ("only-if-cached".equalsIgnoreCase(string2)) {
                            i = i3;
                            z8 = true;
                        } else if ("no-transform".equalsIgnoreCase(string2)) {
                            i = i3;
                            z9 = true;
                        } else if ("immutable".equalsIgnoreCase(string2)) {
                            i = i3;
                            z10 = true;
                        }
                        i = i3;
                    }
                    size = i2;
                }
                i4++;
                lr1Var2 = lr1Var;
                size = size;
            } else if (!strZ.equalsIgnoreCase(HttpHeaders.Names.PRAGMA)) {
                i4++;
                lr1Var2 = lr1Var;
                size = size;
            }
            z2 = false;
            i = 0;
            while (i < strB.length()) {
            }
            i4++;
            lr1Var2 = lr1Var;
            size = size;
        }
        return new ku(z3, z4, iN, iN2, z5, z6, z7, iN3, iN4, z8, z9, z10, !z2 ? null : str);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0066 A[PHI: r2
      0x0066: PHI (r2v6 int) = (r2v5 int), (r2v5 int), (r2v13 int) binds: [B:32:0x006a, B:37:0x0077, B:29:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object J(wz2 wz2Var, sl3 sl3Var, int i, sp spVar, ie0 ie0Var) {
        rl3 rl3Var;
        int i2;
        int iMax;
        Object obj;
        int i3;
        int i4 = i;
        if (ie0Var instanceof rl3) {
            rl3Var = (rl3) ie0Var;
            int i5 = rl3Var.y0;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                rl3Var.y0 = i5 - Integer.MIN_VALUE;
            } else {
                rl3Var = new rl3(ie0Var);
            }
        }
        Object objE = rl3Var.Z;
        int i6 = rl3Var.y0;
        Integer num = null;
        if (i6 == 0) {
            n12.S(objE);
            Integer num2 = (Integer) wz2Var.a();
            int iIntValue = num2 != null ? num2.intValue() : 0;
            boolean z2 = wz2Var instanceof uz2;
            if (z2) {
                i2 = ((uz2) wz2Var).a;
                if (iIntValue < i2) {
                    i2 = iIntValue;
                }
            } else {
                i2 = wz2Var.a;
            }
            if (z2) {
                int i7 = ((uz2) wz2Var).a;
                if (iIntValue < i7) {
                    iMax = 0;
                    int i8 = i2 + iMax > i4 ? i4 - iMax : i2;
                    Object sl3Var2 = new sl3("SELECT * FROM ( " + sl3Var.a + " ) LIMIT " + i2 + " OFFSET " + iMax, sl3Var.b);
                    Object num3 = new Integer(i8);
                    rl3Var.A = i4;
                    rl3Var.X = i2;
                    rl3Var.Y = iMax;
                    rl3Var.y0 = 1;
                    objE = spVar.e(sl3Var2, num3, rl3Var);
                    obj = mf0.b;
                    if (objE == obj) {
                        return obj;
                    }
                    i3 = i2;
                } else {
                    iIntValue -= i7;
                    if (i2 + iMax > i4) {
                    }
                    Object sl3Var22 = new sl3("SELECT * FROM ( " + sl3Var.a + " ) LIMIT " + i2 + " OFFSET " + iMax, sl3Var.b);
                    Object num32 = new Integer(i8);
                    rl3Var.A = i4;
                    rl3Var.X = i2;
                    rl3Var.Y = iMax;
                    rl3Var.y0 = 1;
                    objE = spVar.e(sl3Var22, num32, rl3Var);
                    obj = mf0.b;
                    if (objE == obj) {
                    }
                }
            } else if (!(wz2Var instanceof tz2)) {
                if (!(wz2Var instanceof vz2)) {
                    g.d();
                    return null;
                }
                int i9 = i4 - ((vz2) wz2Var).a;
                iMax = iIntValue >= i9 ? Math.max(0, i9) : iIntValue;
                if (i2 + iMax > i4) {
                }
                Object sl3Var222 = new sl3("SELECT * FROM ( " + sl3Var.a + " ) LIMIT " + i2 + " OFFSET " + iMax, sl3Var.b);
                Object num322 = new Integer(i8);
                rl3Var.A = i4;
                rl3Var.X = i2;
                rl3Var.Y = iMax;
                rl3Var.y0 = 1;
                objE = spVar.e(sl3Var222, num322, rl3Var);
                obj = mf0.b;
                if (objE == obj) {
                }
            }
        } else {
            if (i6 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            iMax = rl3Var.Y;
            i3 = rl3Var.X;
            i4 = rl3Var.A;
            n12.S(objE);
        }
        int i10 = iMax;
        List list = (List) objE;
        int size = list.size() + i10;
        Integer num4 = (list.isEmpty() || list.size() < i3 || size >= i4) ? null : new Integer(size);
        if (i10 > 0 && !list.isEmpty()) {
            num = new Integer(i10);
        }
        return new zz2(list, num, num4, i10, Math.max(0, i4 - size));
    }

    public static final int K(int i, String str) {
        char cCharAt = str.charAt(i);
        return (cCharAt << 7) + str.charAt(i + 1);
    }

    public static void L(ViewGroup viewGroup, float f2) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof yi2) {
            ((yi2) background).o(f2);
        }
    }

    public static final byte[] M(Set set) throws IOException {
        if (set.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeInt(set.size());
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    lc0 lc0Var = (lc0) it.next();
                    objectOutputStream.writeUTF(lc0Var.a.toString());
                    objectOutputStream.writeBoolean(lc0Var.b);
                }
                objectOutputStream.close();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray.getClass();
                return byteArray;
            } finally {
            }
        } finally {
        }
    }

    public static void N(View view, yi2 yi2Var) {
        f21 f21Var = yi2Var.f.b;
        if (f21Var == null || !f21Var.a) {
            return;
        }
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ((View) parent).getElevation();
        }
        wi2 wi2Var = yi2Var.f;
        if (wi2Var.l != elevation) {
            wi2Var.l = elevation;
            yi2Var.y();
        }
    }

    public static void O(ViewGroup viewGroup) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof yi2) {
            N(viewGroup, (yi2) background);
        }
    }

    public static final void P(View view, long j, int i) {
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        Intent intentPutExtra = new Intent(view.getContext(), (Class<?>) ExitDetailActivity.class).putExtra("timestamp", j).putExtra("pid", i);
        intentPutExtra.getClass();
        view.getContext().startActivity(intentPutExtra, l72.z(view));
    }

    public static final int Q(ww4 ww4Var) {
        ww4Var.getClass();
        int iOrdinal = ww4Var.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3) {
                    i = 4;
                    if (iOrdinal != 4) {
                        if (iOrdinal == 5) {
                            return 5;
                        }
                        g.d();
                        return 0;
                    }
                }
            }
        }
        return i;
    }

    public static final hr2 R(byte[] bArr) throws IOException {
        bArr.getClass();
        if (Build.VERSION.SDK_INT < 28 || bArr.length == 0) {
            return new hr2(null);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                int i = objectInputStream.readInt();
                int[] iArr = new int[i];
                for (int i2 = 0; i2 < i; i2++) {
                    iArr[i2] = objectInputStream.readInt();
                }
                int i3 = objectInputStream.readInt();
                int[] iArr2 = new int[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    iArr2[i4] = objectInputStream.readInt();
                }
                hr2 hr2VarD = u9.d(iArr2, iArr);
                objectInputStream.close();
                byteArrayInputStream.close();
                return hr2VarD;
            } finally {
            }
        } finally {
        }
    }

    public static double S(double d) {
        double d2 = d / 100.0d;
        return (d2 <= 0.0031308d ? d2 * 12.92d : (Math.pow(d2, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d;
    }

    public static boolean T(byte b2) {
        return b2 > -65;
    }

    public static xp a(int i, jp jpVar, ji jiVar, int i2) {
        int i3 = i2 & 2;
        jp jpVar2 = jp.b;
        if (i3 != 0) {
            jpVar = jpVar2;
        }
        if ((i2 & 4) != 0) {
            jiVar = null;
        }
        if (i == -2) {
            if (jpVar != jpVar2) {
                return new pa0(1, jpVar, jiVar);
            }
            y20.m.getClass();
            return new xp(x20.b, jiVar);
        }
        if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? jpVar == jpVar2 ? new xp(i, jiVar) : new pa0(i, jpVar, jiVar) : new xp(ChannelUtils.WRITE_STATUS_SNDBUF_FULL, jiVar) : jpVar == jpVar2 ? new xp(0, jiVar) : new pa0(1, jpVar, jiVar);
        }
        if (jpVar == jpVar2) {
            return new pa0(1, jp.f, jiVar);
        }
        xe.k("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        return null;
    }

    public static boolean b(double d, double d2, double d3) {
        return ((d2 - d) + 25.132741228718345d) % 6.283185307179586d < ((d3 - d) + 25.132741228718345d) % 6.283185307179586d;
    }

    public static xf c() throws InterruptedException {
        t6 t6Var = xf.h;
        xf xfVar = ((xf[]) t6Var.z)[1];
        if (xfVar == null) {
            long jNanoTime = System.nanoTime();
            xf.k.await(xf.l, TimeUnit.MILLISECONDS);
            if (((xf[]) t6Var.z)[1] != null || System.nanoTime() - jNanoTime < xf.m) {
                return null;
            }
            return xf.i;
        }
        long jNanoTime2 = xfVar.g - System.nanoTime();
        if (jNanoTime2 > 0) {
            xf.k.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        t6Var.o(xfVar);
        xfVar.e = 2;
        return xfVar;
    }

    public static String d(bu buVar, bu[] buVarArr, int i) {
        int i2;
        boolean z2;
        int i3;
        int i4;
        int iD = buVar.d();
        int i5 = 0;
        while (i5 < iD) {
            int i6 = (i5 + iD) / 2;
            while (i6 > -1 && buVar.i(i6) != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (buVar.i(i2) == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z3 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z3) {
                    i3 = 46;
                    z2 = false;
                } else {
                    byte bI = buVarArr[i10].i(i11);
                    byte[] bArr = hz4.a;
                    int i13 = bI & 255;
                    z2 = z3;
                    i3 = i13;
                }
                byte bI2 = buVar.i(i7 + i12);
                byte[] bArr2 = hz4.a;
                i4 = i3 - (bI2 & 255);
                if (i4 != 0) {
                    break;
                }
                i12++;
                i11++;
                if (i12 == i9) {
                    break;
                }
                if (buVarArr[i10].d() != i11) {
                    z3 = z2;
                } else {
                    if (i10 == buVarArr.length - 1) {
                        break;
                    }
                    i10++;
                    i11 = -1;
                    z3 = true;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i14 = i9 - i12;
                    int iD2 = buVarArr[i10].d() - i11;
                    int length = buVarArr.length;
                    for (int i15 = i10 + 1; i15 < length; i15++) {
                        iD2 += buVarArr[i15].d();
                    }
                    if (iD2 >= i14) {
                        if (iD2 <= i14) {
                            return buVar.o(i7, i9 + i7).n(y30.a);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            iD = i6;
        }
        return null;
    }

    public static final LinkedHashSet e(byte[] bArr) throws IOException {
        bArr.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bArr.length == 0) {
            return linkedHashSet;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    int i = objectInputStream.readInt();
                    for (int i2 = 0; i2 < i; i2++) {
                        Uri uri = Uri.parse(objectInputStream.readUTF());
                        boolean z2 = objectInputStream.readBoolean();
                        uri.getClass();
                        linkedHashSet.add(new lc0(uri, z2));
                    }
                    objectInputStream.close();
                } finally {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            byteArrayInputStream.close();
            return linkedHashSet;
        } finally {
        }
    }

    public static void f(Context context, Object obj, am1 am1Var) {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "VersionChecker", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "checkNewVersion");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("VersionChecker", "checkNewVersion", null);
        }
        boolean z2 = nj3.a;
        y3 y3Var = nj3.e;
        ap1 ap1Var = new ap1(new e24(14, context, am1Var, false));
        ap1Var.C0 = obj;
        y3Var.a(ap1Var);
    }

    public static void g(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            zo2.j(i3, fw.A(i, i2, "fromIndex: ", ", toIndex: ", ", size: "));
        } else {
            if (i <= i2) {
                return;
            }
            xe.k(fw.s(i, i2, "fromIndex: ", " > toIndex: "));
        }
    }

    public static int h(Context context, String str) {
        int iNoteProxyOpNoThrow;
        int iMyPid = Process.myPid();
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, iMyPid, iMyUid) != -1) {
            String strPermissionToOp = AppOpsManager.permissionToOp(str);
            if (strPermissionToOp != null) {
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                int iMyUid2 = Process.myUid();
                String packageName2 = context.getPackageName();
                if (iMyUid2 == iMyUid && Objects.equals(packageName2, packageName) && Build.VERSION.SDK_INT >= 29) {
                    AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
                    iNoteProxyOpNoThrow = appOpsManager == null ? 1 : appOpsManager.checkOpNoThrow(strPermissionToOp, Binder.getCallingUid(), packageName);
                    if (iNoteProxyOpNoThrow == 0) {
                        iNoteProxyOpNoThrow = appOpsManager != null ? appOpsManager.checkOpNoThrow(strPermissionToOp, iMyUid, v9.j(context)) : 1;
                    }
                } else {
                    iNoteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(strPermissionToOp, packageName);
                }
                if (iNoteProxyOpNoThrow != 0) {
                    return -2;
                }
            }
            return 0;
        }
        return -1;
    }

    public static double i(double d) {
        double dPow = Math.pow(Math.abs(d), 0.42d);
        return ((((double) (d < 0.0d ? -1 : d == 0.0d ? 0 : 1)) * 400.0d) * dPow) / (dPow + 27.13d);
    }

    public static final double j(int i, int i2, int i3, int i4, sp3 sp3Var) {
        double d = ((double) i3) / ((double) i);
        double d2 = ((double) i4) / ((double) i2);
        int iOrdinal = sp3Var.ordinal();
        if (iOrdinal == 0) {
            return Math.max(d, d2);
        }
        if (iOrdinal == 1) {
            return Math.min(d, d2);
        }
        g.d();
        return 0.0d;
    }

    public static fx3 k(int i) {
        return i != 0 ? i != 1 ? new cm3() : new ug0() : new cm3();
    }

    public static ki1 p(ki1[] ki1VarArr, int i) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z2 = (i & 2) != 0;
        ki1 ki1Var = null;
        int i3 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        for (ki1 ki1Var2 : ki1VarArr) {
            int iAbs = (Math.abs(ki1Var2.c - i2) * 2) + (ki1Var2.d == z2 ? 0 : 1);
            if (ki1Var == null || i3 > iAbs) {
                ki1Var = ki1Var2;
                i3 = iAbs;
            }
        }
        return ki1Var;
    }

    public static final byte[] q(hr2 hr2Var) throws IOException {
        int[] iArrX0;
        int[] iArrX02;
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            return new byte[0];
        }
        NetworkRequest networkRequest = (NetworkRequest) hr2Var.a;
        if (networkRequest == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                if (i >= 31) {
                    iArrX0 = ut0.h(networkRequest);
                } else {
                    int[] iArr = {2, 0, 3, 6, 10, 9, 8, 4, 1, 5};
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < 10; i2++) {
                        int i3 = iArr[i2];
                        if (u9.w(networkRequest, i3)) {
                            arrayList.add(Integer.valueOf(i3));
                        }
                    }
                    iArrX0 = d70.x0(arrayList);
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    iArrX02 = ut0.a(networkRequest);
                } else {
                    int[] iArr2 = {17, 5, 2, 10, 29, 19, 3, 32, 7, 4, 12, 36, 23, 0, 33, 20, 11, 13, 18, 21, 15, 35, 34, 8, 1, 25, 14, 16, 6, 9};
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < 30; i4++) {
                        int i5 = iArr2[i4];
                        if (u9.v(networkRequest, i5)) {
                            arrayList2.add(Integer.valueOf(i5));
                        }
                    }
                    iArrX02 = d70.x0(arrayList2);
                }
                objectOutputStream.writeInt(iArrX0.length);
                for (int i6 : iArrX0) {
                    objectOutputStream.writeInt(i6);
                }
                objectOutputStream.writeInt(iArrX02.length);
                for (int i7 : iArrX02) {
                    objectOutputStream.writeInt(i7);
                }
                objectOutputStream.close();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray.getClass();
                return byteArray;
            } finally {
            }
        } finally {
        }
    }

    public static String r(d31 d31Var) {
        return r21.f + Integer.toHexString(d31Var.hashCode());
    }

    public static Handler s() {
        if (b != null) {
            return b;
        }
        synchronized (uf2.class) {
            try {
                if (b == null) {
                    b = tj4.s(Looper.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    public static final w92 t(da2 da2Var) {
        da2Var.getClass();
        r92 lifecycle = da2Var.getLifecycle();
        lifecycle.getClass();
        AtomicReference atomicReference = (AtomicReference) lifecycle.a.f;
        while (true) {
            w92 w92Var = (w92) atomicReference.get();
            if (w92Var != null) {
                return w92Var;
            }
            r54 r54VarD = gb4.d();
            gm0 gm0Var = qv0.a;
            w92 w92Var2 = new w92(lifecycle, tj4.W(r54VarD, qf2.a.X));
            do {
                ge0 ge0Var = null;
                if (atomicReference.compareAndSet(null, w92Var2)) {
                    gm0 gm0Var2 = qv0.a;
                    ji0.B(w92Var2, qf2.a.X, null, new gd(w92Var2, ge0Var, 9), 2);
                    return w92Var2;
                }
            } while (atomicReference.get() == null);
        }
    }

    public static Intent u(ca caVar) {
        Intent parentActivityIntent = caVar.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String strW = w(caVar, caVar.getComponentName());
            if (strW == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(caVar, strW);
            try {
                return w(caVar, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                a1.d("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strW + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Intent v(ca caVar, ComponentName componentName) {
        String strW = w(caVar, componentName);
        if (strW == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strW);
        return w(caVar, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String w(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i = Build.VERSION.SDK_INT;
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i >= 29 ? 269222528 : i >= 24 ? 787072 : 640);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static as2 x(a54 a54Var, q30 q30Var, int i) {
        int i2 = q30Var.b;
        int i3 = q30Var.c;
        if (a54Var != null) {
            int i4 = 0;
            lb lbVar = new lb(11, (Object) a54Var.a, (boolean) (0 == true ? 1 : 0));
            try {
                lbVar.d(i2);
                int iL = lbVar.l() - 1;
                if (iL == -1) {
                    try {
                        lbVar.d(-1);
                        return null;
                    } catch (Exception e) {
                        a1.e("StylesUtils", "failed to close " + lbVar, e);
                        return null;
                    }
                }
                while (true) {
                    if (i4 >= lbVar.l()) {
                        break;
                    }
                    if (lbVar.z(i4).a > i3) {
                        iL = i4 - 1;
                        break;
                    }
                    i4++;
                }
                int i5 = iL + i;
                if (i5 >= 0 && i5 < lbVar.l()) {
                    as2 as2VarZ = lbVar.z(i5);
                    try {
                        lbVar.d(-1);
                        return as2VarZ;
                    } catch (Exception e2) {
                        a1.e("StylesUtils", "failed to close " + lbVar, e2);
                        return as2VarZ;
                    }
                }
                try {
                    lbVar.d(-1);
                    return null;
                } catch (Exception e3) {
                    a1.e("StylesUtils", "failed to close " + lbVar, e3);
                    return null;
                }
            } catch (Exception e4) {
                try {
                    lbVar.d(-1);
                } catch (Exception e5) {
                    e4.addSuppressed(e5);
                }
                a1.e("StylesUtils", "failed to get spans from " + lbVar + " at " + q30Var, e4);
            } catch (Throwable th) {
                try {
                    lbVar.d(-1);
                } catch (Exception e6) {
                    a1.e("StylesUtils", "failed to close " + lbVar, e6);
                }
                throw th;
            }
        }
        return null;
    }

    public static double y(double[] dArr) {
        double[] dArrR = yr2.R(dArr, z);
        double dI = i(dArrR[0]);
        double dI2 = i(dArrR[1]);
        double dI3 = i(dArrR[2]);
        return Math.atan2(((dI + dI2) - (dI3 * 2.0d)) / 9.0d, ((((-12.0d) * dI2) + (dI * 11.0d)) + dI3) / 11.0d);
    }

    public static void z(xf xfVar) {
        if (xf.i == null) {
            xf.i = new xf();
            wf wfVar = new wf("Okio Watchdog");
            wfVar.setDaemon(true);
            wfVar.start();
        }
        long jNanoTime = System.nanoTime();
        long j = xfVar.c;
        boolean z2 = xfVar.a;
        if (j != 0 && z2) {
            xfVar.g = Math.min(j, xfVar.c() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            xfVar.g = jNanoTime + j;
        } else {
            if (!z2) {
                throw new AssertionError();
            }
            xfVar.g = xfVar.c();
        }
        t6 t6Var = xf.h;
        int i = t6Var.f + 1;
        t6Var.f = i;
        xf[] xfVarArr = (xf[]) t6Var.z;
        if (i == xfVarArr.length) {
            xf[] xfVarArr2 = new xf[i * 2];
            qe.f0(0, 0, 14, xfVarArr, xfVarArr2);
            t6Var.z = xfVarArr2;
        }
        t6Var.l(i, xfVar);
        if (xfVar.f == 1) {
            xf.k.signal();
        }
    }

    public abstract Typeface l(Context context, hi1 hi1Var, Resources resources, int i);

    public abstract Typeface m(Context context, ki1[] ki1VarArr, int i);

    public Typeface n(Context context, List list, int i) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface o(Context context, Resources resources, int i, String str, int i2) {
        File fileS = vf2.s(context);
        if (fileS == null) {
            return null;
        }
        try {
            if (vf2.g(fileS, resources, i)) {
                return Typeface.createFromFile(fileS.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileS.delete();
        }
    }
}
