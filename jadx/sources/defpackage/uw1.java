package defpackage;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.RouteInfo;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class uw1 implements pl1 {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ Intent f;
    public final /* synthetic */ yw1 z;

    public /* synthetic */ uw1(yw1 yw1Var, Intent intent) {
        this.z = yw1Var;
        this.f = intent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [yw1] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v4, types: [g41] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.List] */
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
    @Override // defpackage.pl1
    public final Object a() throws IOException {
        NetworkInfo networkInfo;
        List<RouteInfo> routes;
        List<RouteInfo> routes2;
        switch (this.b) {
            case 0:
                yw1 yw1Var = this.z;
                Intent intent = this.f;
                ws4.b.i(Boolean.TRUE);
                try {
                    FileInputStream fileInputStream = new FileInputStream(zw1.b());
                    try {
                        t53 t53VarH = k2.h(fileInputStream);
                        fileInputStream.close();
                        yw1Var.c(intent, t53VarH);
                    } finally {
                    }
                } catch (EOFException e) {
                    yw1Var.g(e);
                }
                return xl4.a;
            default:
                Intent intent2 = this.f;
                ?? r2 = this.z;
                ?? arrayList = g41.b;
                ConnectivityManager connectivityManagerB = ContextUtilsKt.b();
                NetworkInfo networkInfo2 = (NetworkInfo) intent2.getParcelableExtra("networkInfo");
                NetworkInfo networkInfo3 = networkInfo2 != null ? connectivityManagerB.getNetworkInfo(networkInfo2.getType()) : null;
                String str = "info: " + networkInfo3;
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("IVpnService", str, null);
                }
                String strConcat = "network change: ".concat(ContextUtilsKt.j());
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("IVpnService", strConcat, null);
                }
                if (!intent2.getBooleanExtra("noConnectivity", false)) {
                    Network networkC = je.C(ContextUtilsKt.b());
                    r2.e().l(networkC);
                    if (networkInfo3 == null || !networkInfo3.isConnected()) {
                        r2.b();
                    } else {
                        try {
                            networkInfo = ContextUtilsKt.b().getNetworkInfo(networkC);
                        } catch (NullPointerException e2) {
                            e2.printStackTrace();
                            networkInfo = null;
                        }
                        Integer numValueOf = networkInfo != null ? Integer.valueOf(networkInfo.getType()) : null;
                        if (numValueOf != null && numValueOf.intValue() == 1) {
                            LinkProperties linkProperties = ContextUtilsKt.b().getLinkProperties(networkC);
                            if (linkProperties != null && (routes2 = linkProperties.getRoutes()) != null) {
                                ArrayList arrayList2 = new ArrayList();
                                for (Object obj : routes2) {
                                    if (((RouteInfo) obj).isDefaultRoute()) {
                                        arrayList2.add(obj);
                                    }
                                }
                                arrayList = new ArrayList();
                                Iterator it = arrayList2.iterator();
                                while (it.hasNext()) {
                                    InetAddress gateway = ((RouteInfo) it.next()).getGateway();
                                    if (gateway != null) {
                                        arrayList.add(gateway);
                                    }
                                }
                            }
                            r2.m(arrayList);
                            r2.l(on3.b);
                            r2.i();
                        } else if (numValueOf != null && numValueOf.intValue() == 0) {
                            r2.b();
                            r2.l(on3.z);
                        } else if (numValueOf != null && numValueOf.intValue() == 9) {
                            LinkProperties linkProperties2 = ContextUtilsKt.b().getLinkProperties(networkC);
                            if (linkProperties2 != null && (routes = linkProperties2.getRoutes()) != null) {
                                ArrayList arrayList3 = new ArrayList();
                                for (Object obj2 : routes) {
                                    if (((RouteInfo) obj2).isDefaultRoute()) {
                                        arrayList3.add(obj2);
                                    }
                                }
                                arrayList = new ArrayList();
                                Iterator it2 = arrayList3.iterator();
                                while (it2.hasNext()) {
                                    InetAddress gateway2 = ((RouteInfo) it2.next()).getGateway();
                                    if (gateway2 != null) {
                                        arrayList.add(gateway2);
                                    }
                                }
                            }
                            r2.m(arrayList);
                            r2.l(on3.f);
                            r2.n(null);
                            r2.k(null);
                        } else {
                            String strN = ha0.n("unknown network type: ", networkInfo != null ? networkInfo.getTypeName() : null);
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d("IVpnService", strN, null);
                            }
                            r2.b();
                        }
                    }
                    break;
                } else {
                    r2.e().l(null);
                    r2.b();
                }
                r2.e().a();
                return xl4.a;
        }
    }

    public /* synthetic */ uw1(Intent intent, yw1 yw1Var) {
        this.f = intent;
        this.z = yw1Var;
    }
}
