package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import j$.util.Objects;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lv3 implements CookieStore {
    public final SharedPreferences a;
    public final Object b;
    public final LinkedHashMap c;
    public final iq1 d;

    public lv3(Context context) {
        context.getClass();
        SharedPreferences sharedPreferences = context.getSharedPreferences("persistent_cookies", 0);
        sharedPreferences.getClass();
        this.a = sharedPreferences;
        this.b = new Object();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.c = linkedHashMap;
        this.d = new iq1();
        linkedHashMap.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Type[] typeArr = {oe0.class};
        TypeVariable[] typeParameters = List.class.getTypeParameters();
        int length = typeParameters.length;
        if (1 != length) {
            throw new IllegalArgumentException(List.class.getName() + " requires " + length + " type arguments, but got 1");
        }
        if (!Modifier.isStatic(List.class.getModifiers()) && List.class.getDeclaringClass() != null) {
            xe.r("Raw type ", List.class.getName(), " is not supported because it requires specifying an owner type");
            throw null;
        }
        for (int i = 0; i < length; i++) {
            Type type = typeArr[i];
            Objects.requireNonNull(type, "Type argument must not be null");
            Type type2 = type;
            Class<?> clsB = l72.B(type2);
            TypeVariable typeVariable = typeParameters[i];
            Type[] bounds = typeVariable.getBounds();
            int length2 = bounds.length;
            int i2 = 0;
            while (i2 < length2) {
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (!l72.B(bounds[i2]).isAssignableFrom(clsB)) {
                    throw new IllegalArgumentException("Type argument " + type2 + " does not satisfy bounds for type variable " + typeVariable + " declared by " + List.class);
                }
                i2++;
                sharedPreferences = sharedPreferences2;
            }
        }
        SharedPreferences sharedPreferences3 = sharedPreferences;
        Type type3 = new bk4(new lq1(null, List.class, typeArr)).b;
        Map<String, ?> all = sharedPreferences3.getAll();
        all.getClass();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            key.getClass();
            if (w44.j0(key, "cookie:", false) && (value instanceof String)) {
                try {
                    URI uriCreate = URI.create(p44.F0(key, "cookie:"));
                    iq1 iq1Var = this.d;
                    iq1Var.getClass();
                    List list = (List) iq1Var.c((String) value, new bk4(type3));
                    if (list != null) {
                        ArrayList arrayList3 = new ArrayList(f70.Q(10, list));
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList3.add(((oe0) it.next()).a());
                        }
                        linkedHashMap.put(uriCreate, new ArrayList(arrayList3));
                    }
                } catch (Exception unused) {
                    arrayList.add(key);
                }
            } else if (!w44.j0(key, "cookie:", false)) {
                arrayList2.add(key);
            }
        }
        if (arrayList2.isEmpty() && arrayList.isEmpty()) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences3.edit();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            editorEdit.remove((String) it2.next());
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            editorEdit.remove((String) it3.next());
        }
        editorEdit.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(URI uri) {
        boolean zBooleanValue;
        SharedPreferences.Editor editorEdit = this.a.edit();
        String str = "cookie:" + uri;
        LinkedHashMap linkedHashMap = this.c;
        List list = (List) linkedHashMap.get(uri);
        if (list == null || list.isEmpty()) {
            editorEdit.remove(str);
            linkedHashMap.remove(uri);
        } else {
            ArrayList arrayList = new ArrayList(f70.Q(10, list));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                HttpCookie httpCookie = (HttpCookie) it.next();
                String name = httpCookie.getName();
                name.getClass();
                String value = httpCookie.getValue();
                value.getClass();
                String domain = httpCookie.getDomain();
                String path = httpCookie.getPath();
                long maxAge = httpCookie.getMaxAge();
                boolean secure = httpCookie.getSecure();
                Iterator it2 = it;
                try {
                    Object objInvoke = HttpCookie.class.getMethod("isHttpOnly", null).invoke(httpCookie, null);
                    objInvoke.getClass();
                    zBooleanValue = ((Boolean) objInvoke).booleanValue();
                } catch (Exception unused) {
                    zBooleanValue = false;
                }
                arrayList.add(new oe0(name, value, domain, path, maxAge, secure, zBooleanValue));
                it = it2;
            }
            editorEdit.putString(str, this.d.h(arrayList));
        }
        editorEdit.apply();
    }

    @Override // java.net.CookieStore
    public final void add(URI uri, HttpCookie httpCookie) {
        uri.getClass();
        httpCookie.getClass();
        synchronized (this.b) {
            try {
                LinkedHashMap linkedHashMap = this.c;
                Object arrayList = linkedHashMap.get(uri);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(uri, arrayList);
                }
                ((List) arrayList).add(httpCookie);
                a(uri);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.net.CookieStore
    public final List get(URI uri) {
        uri.getClass();
        synchronized (this.b) {
            String host = uri.getHost();
            if (host == null) {
                return g41.b;
            }
            ArrayList arrayListR = f70.R(this.c.values());
            ArrayList arrayList = new ArrayList();
            for (Object obj : arrayListR) {
                HttpCookie httpCookie = (HttpCookie) obj;
                if (!httpCookie.hasExpired()) {
                    String domain = httpCookie.getDomain();
                    boolean zJ0 = true;
                    if ((domain == null || domain.length() == 0) ? host.length() == 0 : HttpCookie.domainMatches(domain, host)) {
                        String path = uri.getPath();
                        String path2 = httpCookie.getPath();
                        if (path2 != null && path2.length() != 0 && !path2.equals("/")) {
                            if (path == null) {
                                path = "/";
                            }
                            zJ0 = w44.j0(path, path2, false);
                        }
                        if (zJ0) {
                            arrayList.add(obj);
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    @Override // java.net.CookieStore
    public final List getCookies() {
        ArrayList arrayList;
        synchronized (this.b) {
            ArrayList arrayListR = f70.R(this.c.values());
            arrayList = new ArrayList();
            for (Object obj : arrayListR) {
                if (!((HttpCookie) obj).hasExpired()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    @Override // java.net.CookieStore
    public final List getURIs() {
        List listY0;
        synchronized (this.b) {
            listY0 = d70.y0(this.c.keySet());
        }
        return listY0;
    }

    @Override // java.net.CookieStore
    public final boolean remove(URI uri, HttpCookie httpCookie) {
        uri.getClass();
        httpCookie.getClass();
        synchronized (this.b) {
            try {
                List list = (List) this.c.get(uri);
                boolean z = false;
                if (list == null) {
                    return false;
                }
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    HttpCookie httpCookie2 = (HttpCookie) it.next();
                    if (w44.f0(httpCookie2.getName(), httpCookie.getName()) && n12.c(httpCookie2.getValue(), httpCookie.getValue()) && w44.f0(httpCookie2.getDomain(), httpCookie.getDomain()) && n12.c(httpCookie2.getPath(), httpCookie.getPath())) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    a(uri);
                }
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.net.CookieStore
    public final boolean removeAll() {
        boolean z;
        synchronized (this.b) {
            try {
                z = !this.c.isEmpty();
                this.c.clear();
                SharedPreferences.Editor editorEdit = this.a.edit();
                Set<String> setKeySet = this.a.getAll().keySet();
                ArrayList arrayList = new ArrayList();
                for (Object obj : setKeySet) {
                    String str = (String) obj;
                    str.getClass();
                    if (w44.j0(str, "cookie:", false)) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    editorEdit.remove((String) it.next());
                }
                editorEdit.apply();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
