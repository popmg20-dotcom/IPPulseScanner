package defpackage;

import j$.util.Collection;
import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.stream.Collectors;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.spec.ECField;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public enum b01 implements to2, nw2 {
    nistp256("nistp256", "secp256r1", new int[]{1, 2, 840, 10045, 3, 1, 7}, xr.Y),
    nistp384("nistp384", "secp384r1", new int[]{1, 3, 132, 0, 34}, xr.Z),
    nistp521("nistp521", "secp521r1", new int[]{1, 3, 132, 0, 35}, xr.y0);

    public static final Set A0;
    public static final NavigableSet B0;
    public ECParameterSpec A;
    public volatile int X = -1;
    public final xr Y;
    public final String b;
    public final String f;
    public final String z;

    static {
        Set setUnmodifiableSet = DesugarCollections.unmodifiableSet(EnumSet.allOf(b01.class));
        A0 = setUnmodifiableSet;
        Collections.unmodifiableNavigableSet((NavigableSet) ga5.G(setUnmodifiableSet).map(new hl(3)).collect(Collectors.toCollection(new v6(1))));
        B0 = Collections.unmodifiableNavigableSet((NavigableSet) ga5.G(setUnmodifiableSet).map(new hl(4)).collect(Collectors.toCollection(new v6(1))));
        DesugarCollections.unmodifiableList((List) Collection.EL.stream(setUnmodifiableSet).sorted(new i60(3)).collect(Collectors.toList()));
    }

    b01(String str, String str2, int[] iArr, xr xrVar) {
        List list;
        this.b = n12.g(str, "No curve name");
        this.f = n12.g(str2, "No SEC curve name");
        int i = jt2.a;
        n12.i("No OID", iArr.length > 0);
        if (iArr.length > 0) {
            StringBuilder sb = new StringBuilder(iArr.length * 8);
            for (int i2 : iArr) {
                if (sb.length() > 0) {
                    sb.append('.');
                }
                sb.append(i2);
            }
        }
        int length = iArr.length;
        if (length <= 0) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList = new ArrayList(length);
            for (int i3 : iArr) {
                arrayList.add(Integer.valueOf(i3));
            }
            list = arrayList;
        }
        DesugarCollections.unmodifiableList(list);
        this.z = "ecdsa-sha2-".concat(str);
        Objects.requireNonNull(xrVar, "No digestFactory");
        this.Y = xrVar;
    }

    public final int a() {
        ECParameterSpec eCParameterSpec;
        int i = this.X;
        if (i >= 0) {
            return i;
        }
        synchronized (this) {
            try {
                eCParameterSpec = this.A;
                if (eCParameterSpec == null) {
                    String str = this.f;
                    try {
                        AlgorithmParameters algorithmParameters = (AlgorithmParameters) nr3.k(AlgorithmParameters.class, "EC", new sm(11)).a("EC");
                        algorithmParameters.init(new ECGenParameterSpec(str));
                        eCParameterSpec = (ECParameterSpec) algorithmParameters.getParameterSpec(ECParameterSpec.class);
                    } catch (GeneralSecurityException unused) {
                        eCParameterSpec = null;
                    }
                    n12.k(eCParameterSpec != null, "No EC params for %s", this.b);
                    this.A = eCParameterSpec;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Objects.requireNonNull(eCParameterSpec, "No EC params");
        EllipticCurve curve = eCParameterSpec.getCurve();
        Objects.requireNonNull(curve, "No EC curve");
        ECField field = curve.getField();
        Objects.requireNonNull(field, "No EC field");
        int fieldSize = field.getFieldSize();
        this.X = fieldSize;
        return fieldSize;
    }

    @Override // defpackage.nw2
    public final boolean g() {
        return nr3.f() && this.Y.A;
    }

    @Override // defpackage.to2
    public final String getName() {
        return this.b;
    }
}
