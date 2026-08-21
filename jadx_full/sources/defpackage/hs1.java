package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Range;
import android.util.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hs1 {
    public static final Range e = new Range(120, 120);
    public final sy a;
    public final n84 b;
    public final n84 c;
    public final n84 d;

    public hs1(sy syVar) {
        syVar.getClass();
        this.a = syVar;
        final int i = 0;
        this.b = new n84(new pl1(this) { // from class: gs1
            public final /* synthetic */ hs1 f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i2 = i;
                hs1 hs1Var = this.f;
                switch (i2) {
                    case 0:
                        int[] iArr = (int[]) hs1Var.a.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
                        boolean z = false;
                        if (iArr != null) {
                            int length = iArr.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 < length) {
                                    if (iArr[i3] == 9) {
                                        z = true;
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                        }
                        return Boolean.valueOf(z);
                    case 1:
                        List list = (List) hs1Var.d.getValue();
                        if (list.isEmpty()) {
                            list = null;
                        }
                        if (list == null) {
                            return null;
                        }
                        Iterator it = list.iterator();
                        if (!it.hasNext()) {
                            vp1.g();
                            return null;
                        }
                        Object next = it.next();
                        if (it.hasNext()) {
                            int iA = yx3.a((Size) next);
                            do {
                                Object next2 = it.next();
                                int iA2 = yx3.a((Size) next2);
                                if (iA < iA2) {
                                    next = next2;
                                    iA = iA2;
                                }
                            } while (it.hasNext());
                        }
                        return (Size) next;
                    default:
                        Size[] highSpeedVideoSizes = ((StreamConfigurationMap) ((oj1) hs1Var.a.c().f).f).getHighSpeedVideoSizes();
                        return highSpeedVideoSizes != null ? qe.l0(highSpeedVideoSizes) : g41.b;
                }
            }
        });
        final int i2 = 1;
        this.c = new n84(new pl1(this) { // from class: gs1
            public final /* synthetic */ hs1 f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i22 = i2;
                hs1 hs1Var = this.f;
                switch (i22) {
                    case 0:
                        int[] iArr = (int[]) hs1Var.a.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
                        boolean z = false;
                        if (iArr != null) {
                            int length = iArr.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 < length) {
                                    if (iArr[i3] == 9) {
                                        z = true;
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                        }
                        return Boolean.valueOf(z);
                    case 1:
                        List list = (List) hs1Var.d.getValue();
                        if (list.isEmpty()) {
                            list = null;
                        }
                        if (list == null) {
                            return null;
                        }
                        Iterator it = list.iterator();
                        if (!it.hasNext()) {
                            vp1.g();
                            return null;
                        }
                        Object next = it.next();
                        if (it.hasNext()) {
                            int iA = yx3.a((Size) next);
                            do {
                                Object next2 = it.next();
                                int iA2 = yx3.a((Size) next2);
                                if (iA < iA2) {
                                    next = next2;
                                    iA = iA2;
                                }
                            } while (it.hasNext());
                        }
                        return (Size) next;
                    default:
                        Size[] highSpeedVideoSizes = ((StreamConfigurationMap) ((oj1) hs1Var.a.c().f).f).getHighSpeedVideoSizes();
                        return highSpeedVideoSizes != null ? qe.l0(highSpeedVideoSizes) : g41.b;
                }
            }
        });
        final int i3 = 2;
        this.d = new n84(new pl1(this) { // from class: gs1
            public final /* synthetic */ hs1 f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i22 = i3;
                hs1 hs1Var = this.f;
                switch (i22) {
                    case 0:
                        int[] iArr = (int[]) hs1Var.a.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
                        boolean z = false;
                        if (iArr != null) {
                            int length = iArr.length;
                            int i32 = 0;
                            while (true) {
                                if (i32 < length) {
                                    if (iArr[i32] == 9) {
                                        z = true;
                                    } else {
                                        i32++;
                                    }
                                }
                            }
                        }
                        return Boolean.valueOf(z);
                    case 1:
                        List list = (List) hs1Var.d.getValue();
                        if (list.isEmpty()) {
                            list = null;
                        }
                        if (list == null) {
                            return null;
                        }
                        Iterator it = list.iterator();
                        if (!it.hasNext()) {
                            vp1.g();
                            return null;
                        }
                        Object next = it.next();
                        if (it.hasNext()) {
                            int iA = yx3.a((Size) next);
                            do {
                                Object next2 = it.next();
                                int iA2 = yx3.a((Size) next2);
                                if (iA < iA2) {
                                    next = next2;
                                    iA = iA2;
                                }
                            } while (it.hasNext());
                        }
                        return (Size) next;
                    default:
                        Size[] highSpeedVideoSizes = ((StreamConfigurationMap) ((oj1) hs1Var.a.c().f).f).getHighSpeedVideoSizes();
                        return highSpeedVideoSizes != null ? qe.l0(highSpeedVideoSizes) : g41.b;
                }
            }
        });
    }

    public static List a(List list) {
        if (list.isEmpty()) {
            return g41.b;
        }
        ArrayList arrayListZ0 = d70.z0((Collection) d70.d0(list));
        Iterator it = d70.Y(list).iterator();
        while (it.hasNext()) {
            arrayListZ0.retainAll((List) it.next());
        }
        return arrayListZ0;
    }

    public final Range[] b(List list) {
        list.getClass();
        int size = list.size();
        if (1 <= size && size < 3 && d70.y0(d70.B0(list)).size() == 1) {
            List listC = c((Size) list.get(0));
            if (listC.isEmpty()) {
                listC = null;
            }
            if (listC != null) {
                if (list.size() == 2) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listC) {
                        Range range = (Range) obj;
                        if (n12.c(range.getLower(), range.getUpper())) {
                            arrayList.add(obj);
                        }
                    }
                    listC = arrayList;
                }
                return (Range[]) listC.toArray(new Range[0]);
            }
        }
        return null;
    }

    public final List c(Size size) {
        Object tk3Var;
        try {
            tk3Var = ((StreamConfigurationMap) ((oj1) this.a.c().f).f).getHighSpeedVideoFpsRangesFor(size);
        } catch (Throwable th) {
            tk3Var = new tk3(th);
        }
        if (tk3Var instanceof tk3) {
            tk3Var = null;
        }
        Range[] rangeArr = (Range[]) tk3Var;
        return rangeArr != null ? d70.y0(qe.l0(rangeArr)) : g41.b;
    }
}
