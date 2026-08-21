package io.netty.handler.ssl;

import defpackage.l0;
import defpackage.vp1;
import io.netty.util.CharsetUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLParameters;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class Java8SslUtils {
    private Java8SslUtils() {
    }

    public static boolean checkSniHostnameMatch(Collection<?> collection, byte[] bArr) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        SNIHostName sNIHostNameB = l0.b(bArr);
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            SNIMatcher sNIMatcherD = vp1.d(it.next());
            if (sNIMatcherD.getType() == 0 && sNIMatcherD.matches(sNIHostNameB)) {
                return true;
            }
        }
        return false;
    }

    public static List getSniHostName(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? Collections.EMPTY_LIST : Collections.singletonList(l0.t(bArr));
    }

    public static List<String> getSniHostNames(SSLParameters sSLParameters) {
        List<SNIServerName> serverNames = sSLParameters.getServerNames();
        if (serverNames == null || serverNames.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(serverNames.size());
        Iterator<SNIServerName> it = serverNames.iterator();
        while (it.hasNext()) {
            SNIServerName sNIServerNameF = vp1.f(it.next());
            if (!(sNIServerNameF instanceof SNIHostName)) {
                vp1.k("Only ", SNIHostName.class.getName(), " instances are supported, but found: ", sNIServerNameF);
                return null;
            }
            arrayList.add(vp1.c(sNIServerNameF).getAsciiName());
        }
        return arrayList;
    }

    public static boolean getUseCipherSuitesOrder(SSLParameters sSLParameters) {
        return sSLParameters.getUseCipherSuitesOrder();
    }

    public static boolean isValidHostNameForSNI(String str) {
        try {
            l0.c();
            l0.q(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static void setSNIMatchers(SSLParameters sSLParameters, Collection<?> collection) {
        sSLParameters.setSNIMatchers(collection);
    }

    public static void setSniHostNames(SSLParameters sSLParameters, List<String> list) {
        sSLParameters.setServerNames(getSniHostNames(list));
    }

    public static void setUseCipherSuitesOrder(SSLParameters sSLParameters, boolean z) {
        sSLParameters.setUseCipherSuitesOrder(z);
    }

    public static List getSniHostNames(List<String> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                l0.c();
                arrayList.add(l0.b(str.getBytes(CharsetUtil.UTF_8)));
            }
            return arrayList;
        }
        return Collections.EMPTY_LIST;
    }
}
