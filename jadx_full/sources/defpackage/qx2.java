package defpackage;

import android.util.ArrayMap;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.extensions.embedding.ActivityStack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qx2 {
    public final ActivityEmbeddingComponent a;
    public final ReentrantLock b = new ReentrantLock();
    public final ArrayMap c = new ArrayMap();
    public final ArrayMap d = new ArrayMap();
    public final ArrayMap e = new ArrayMap();

    public qx2(ActivityEmbeddingComponent activityEmbeddingComponent, r21 r21Var) {
        this.a = activityEmbeddingComponent;
        new ArrayMap();
        int iA = y91.a();
        if (iA < 8) {
            vp1.n(fw.s(8, iA, "This API requires extension version ", ", but the device is on "));
            throw null;
        }
        activityEmbeddingComponent.setActivityStackAttributesCalculator(new px2());
        activityEmbeddingComponent.registerActivityStackCallback(new qd(1), new b5(new f0(14, this)));
    }

    public static final void a(qx2 qx2Var, List list) {
        list.getClass();
        ReentrantLock reentrantLock = qx2Var.b;
        ArrayMap arrayMap = qx2Var.e;
        reentrantLock.lock();
        try {
            Set setKeySet = arrayMap.keySet();
            setKeySet.getClass();
            arrayMap.clear();
            List<ActivityStack> listC = c(list);
            ArrayList arrayList = new ArrayList(f70.Q(10, listC));
            for (ActivityStack activityStack : listC) {
                String tag = activityStack.getTag();
                tag.getClass();
                arrayList.add(new e03(tag, activityStack));
            }
            fh2.W(arrayMap, arrayList);
            qx2Var.b(setKeySet);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static List c(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ActivityStack) obj).getTag() != null) {
                arrayList.add(obj);
            }
        }
        return d70.y0(arrayList);
    }

    public final void b(Set set) {
        if (set.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Set setKeySet = this.e.keySet();
        setKeySet.getClass();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!setKeySet.contains(str) && this.a.getActivityStackToken(str) == null) {
                arrayList.add(str);
            }
        }
        Iterator it2 = arrayList.iterator();
        it2.getClass();
        while (it2.hasNext()) {
            Object next = it2.next();
            next.getClass();
            String str2 = (String) next;
            this.c.remove(str2);
            this.d.remove(str2);
        }
    }
}
