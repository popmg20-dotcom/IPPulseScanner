package defpackage;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class d70 extends h70 {
    public static final List A0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return new ArrayList((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        w0(iterable, arrayList);
        return arrayList;
    }

    public static Set B0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        w0(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static Set C0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size == 1) {
                    return yr2.k0(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(fh2.U(collection.size()));
                w0(iterable, linkedHashSet);
                return linkedHashSet;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            w0(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                return size2 != 1 ? linkedHashSet2 : yr2.k0(linkedHashSet2.iterator().next());
            }
        }
        return k41.b;
    }

    public static void U(Iterable iterable, AbstractCollection abstractCollection) {
        abstractCollection.getClass();
        iterable.getClass();
        if (iterable instanceof Collection) {
            abstractCollection.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static void V(Collection collection, Object[] objArr) {
        collection.getClass();
        objArr.getClass();
        List listAsList = Arrays.asList(objArr);
        listAsList.getClass();
        collection.addAll(listAsList);
    }

    public static boolean W(Object obj, Iterable iterable) {
        int iIndexOf;
        iterable.getClass();
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                Object next = it.next();
                if (i < 0) {
                    e70.P();
                    throw null;
                }
                if (n12.c(obj, next)) {
                    iIndexOf = i;
                    break;
                }
                i++;
            }
        } else {
            iIndexOf = ((List) iterable).indexOf(obj);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int X(b12 b12Var) {
        b12Var.getClass();
        if (b12Var instanceof Collection) {
            return ((Collection) b12Var).size();
        }
        Iterator it = b12Var.iterator();
        int i = 0;
        while (((a12) it).z) {
            ((a12) it).next();
            i++;
            if (i < 0) {
                e70.O();
                throw null;
            }
        }
        return i;
    }

    public static List Y(Iterable iterable) {
        ArrayList arrayList;
        Object objK0;
        iterable.getClass();
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - 1;
            if (size <= 0) {
                return g41.b;
            }
            if (size == 1) {
                if (iterable instanceof List) {
                    objK0 = k0((List) iterable);
                } else {
                    Iterator it = iterable.iterator();
                    if (!it.hasNext()) {
                        e04.h("Collection is empty.");
                        return null;
                    }
                    Object next = it.next();
                    while (it.hasNext()) {
                        next = it.next();
                    }
                    objK0 = next;
                }
                return p95.x(objK0);
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    for (int i = 1; i < size2; i++) {
                        arrayList.add(list.get(i));
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(1);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= 1) {
                arrayList.add(obj);
            } else {
                i2++;
            }
        }
        return e70.M(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object Z(AbstractCollection abstractCollection, int i) {
        boolean z = abstractCollection instanceof List;
        if (z) {
            return ((List) abstractCollection).get(i);
        }
        int i2 = 0;
        i70 i70Var = new i70(i, i2);
        if (z) {
            List list = (List) abstractCollection;
            if (i >= 0 && i < list.size()) {
                return list.get(i);
            }
            i70Var.g(Integer.valueOf(i));
            throw null;
        }
        if (i < 0) {
            i70Var.g(Integer.valueOf(i));
            throw null;
        }
        for (Object obj : abstractCollection) {
            int i3 = i2 + 1;
            if (i == i2) {
                return obj;
            }
            i2 = i3;
        }
        i70Var.g(Integer.valueOf(i));
        throw null;
    }

    public static final boolean a0(Collection collection, am1 am1Var, boolean z) {
        Iterator it = collection.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (((Boolean) am1Var.g(it.next())).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static ArrayList b0(Class cls, List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (cls.isInstance(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object c0(Collection collection) {
        collection.getClass();
        if (collection instanceof List) {
            return d0((List) collection);
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        e04.h("Collection is empty.");
        return null;
    }

    public static Object d0(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.get(0);
        }
        e04.h("List is empty.");
        return null;
    }

    public static Object e0(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object f0(int i, List list) {
        list.getClass();
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static LinkedHashSet g0(Iterable iterable, Iterable iterable2) {
        iterable.getClass();
        iterable2.getClass();
        Collection collectionY0 = iterable2 instanceof Collection ? (Collection) iterable2 : y0(iterable2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : iterable) {
            if (collectionY0.contains(obj)) {
                linkedHashSet.add(obj);
            }
        }
        return linkedHashSet;
    }

    public static final void h0(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, am1 am1Var) {
        iterable.getClass();
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            n12.a(sb, obj, am1Var);
        }
        sb.append(charSequence3);
    }

    public static String j0(Iterable iterable, String str, String str2, String str3, am1 am1Var, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            am1Var = null;
        }
        iterable.getClass();
        StringBuilder sb = new StringBuilder();
        h0(iterable, sb, str4, str5, str6, "...", am1Var);
        return sb.toString();
    }

    public static Object k0(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        e04.h("List is empty.");
        return null;
    }

    public static Object l0(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static ArrayList m0(Collection collection, Iterable iterable) {
        collection.getClass();
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            U(iterable, arrayList);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static ArrayList n0(Collection collection, Object obj) {
        collection.getClass();
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static void o0(List list, am1 am1Var) {
        int size;
        list.getClass();
        if (!(list instanceof RandomAccess)) {
            if (!(list instanceof z72) || (list instanceof a82)) {
                a0(list, am1Var, true);
                return;
            } else {
                tj4.h0(list, "kotlin.collections.MutableIterable");
                throw null;
            }
        }
        int size2 = list.size() - 1;
        int i = 0;
        if (size2 >= 0) {
            int i2 = 0;
            while (true) {
                Object obj = list.get(i);
                if (!((Boolean) am1Var.g(obj)).booleanValue()) {
                    if (i2 != i) {
                        list.set(i2, obj);
                    }
                    i2++;
                }
                if (i == size2) {
                    break;
                } else {
                    i++;
                }
            }
            i = i2;
        }
        if (i >= list.size() || i > (size = list.size() - 1)) {
            return;
        }
        while (true) {
            list.remove(size);
            if (size == i) {
                return;
            } else {
                size--;
            }
        }
    }

    public static Object p0(AbstractList abstractList) {
        if (!abstractList.isEmpty()) {
            return abstractList.remove(abstractList.size() - 1);
        }
        e04.h("List is empty.");
        return null;
    }

    public static final int q0(gl3 gl3Var, int i) {
        if (i >= 0 && i <= gl3Var.size() - 1) {
            return (gl3Var.size() - 1) - i;
        }
        StringBuilder sbD = dw2.D("Element index ", i, " must be in range [");
        sbD.append(new b12(0, gl3Var.size() - 1, 1));
        sbD.append("].");
        throw new IndexOutOfBoundsException(sbD.toString());
    }

    public static final int r0(int i, List list) {
        if (i >= 0 && i <= list.size()) {
            return list.size() - i;
        }
        StringBuilder sbD = dw2.D("Position index ", i, " must be in range [");
        sbD.append(new b12(0, list.size(), 1));
        sbD.append("].");
        throw new IndexOutOfBoundsException(sbD.toString());
    }

    public static List s0(List list) {
        list.getClass();
        if (list.size() <= 1) {
            return y0(list);
        }
        List listA0 = A0(list);
        Collections.reverse(listA0);
        return listA0;
    }

    public static List t0(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List listA0 = A0(iterable);
            h70.S(listA0);
            return listA0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return y0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        comparableArr.getClass();
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        array.getClass();
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        return listAsList;
    }

    public static List u0(Iterable iterable, Comparator comparator) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List listA0 = A0(iterable);
            h70.T(listA0, comparator);
            return listA0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return y0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        array.getClass();
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        return listAsList;
    }

    public static List v0(int i, List list) {
        if (i < 0) {
            e04.f(ha0.k("Requested element count ", i, " is less than zero."));
            return null;
        }
        if (i == 0) {
            return g41.b;
        }
        if (i >= list.size()) {
            return y0(list);
        }
        if (i == 1) {
            return p95.x(c0(list));
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return e70.M(arrayList);
    }

    public static final void w0(Iterable iterable, AbstractCollection abstractCollection) {
        iterable.getClass();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static int[] x0(ArrayList arrayList) {
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List y0(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            return e70.M(A0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return g41.b;
        }
        if (size != 1) {
            return new ArrayList(collection);
        }
        return p95.x(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static ArrayList z0(Collection collection) {
        collection.getClass();
        return new ArrayList(collection);
    }
}
