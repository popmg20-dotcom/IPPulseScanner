package defpackage;

import android.os.Build;
import j$.util.Collection;
import j$.util.Map;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class dm {
    public final Object a;
    public final Serializable b;

    public dm(Map map) {
        if (map.isEmpty()) {
            this.a = Collections.EMPTY_MAP;
            this.b = null;
            return;
        }
        this.a = new HashMap(map);
        String[] strArr = (String[]) Collection.EL.stream(map.keySet()).map(new hl(1)).sorted(Collections.reverseOrder()).toArray(new cm(0));
        StringBuilder sb = new StringBuilder("^((");
        StringBuilder sb2 = new StringBuilder();
        if (strArr.length > 0) {
            sb2.append((CharSequence) strArr[0]);
            for (int i = 1; i < strArr.length; i++) {
                sb2.append((CharSequence) ")|(");
                sb2.append((CharSequence) strArr[i]);
            }
        }
        sb.append(sb2.toString());
        sb.append("))($|\\.)");
        this.b = Pattern.compile(sb.toString());
    }

    public void a(String str) {
        HashMap map = (HashMap) this.b;
        ReentrantLock reentrantLock = (ReentrantLock) this.a;
        reentrantLock.lock();
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                ((ln2) Map.EL.computeIfAbsent(map, str, new hl(5))).a++;
            } else {
                ln2 ln2Var = (ln2) map.get(str);
                if (ln2Var == null) {
                    ln2Var = new ln2(0);
                    map.put(str, ln2Var);
                }
                ln2Var.a++;
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public dm() {
        this.a = new ReentrantLock(true);
        this.b = new HashMap();
    }
}
