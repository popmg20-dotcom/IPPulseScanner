package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bf3 extends if2 {
    public final /* synthetic */ int h = 0;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf3(x75 x75Var) {
        super(20);
        this.i = x75Var;
    }

    @Override // defpackage.if2
    public Object c(Object obj) throws Throwable {
        LinkedHashMap linkedHashMap;
        switch (this.h) {
            case 1:
                String str = (String) obj;
                tj4.f(str);
                x75 x75Var = (x75) this.i;
                x75Var.W0();
                tj4.f(str);
                m25 m25Var = x75Var.X.z;
                ff5.R(m25Var);
                n02 n02VarB2 = m25Var.b2(str);
                if (n02VarB2 == null) {
                    return null;
                }
                t65 t65Var = ((k85) x75Var.f).Y;
                k85.h(t65Var);
                t65Var.H0.b(str, "Populate EES config from database on cache miss. appId");
                x75Var.d1(str, x75Var.e1(str, (byte[]) n02VarB2.f));
                bf3 bf3Var = x75Var.D0;
                synchronized (((d7) bf3Var.g)) {
                    Set setEntrySet = ((jf2) bf3Var.f).a.entrySet();
                    setEntrySet.getClass();
                    linkedHashMap = new LinkedHashMap(setEntrySet.size());
                    Set<Map.Entry> setEntrySet2 = ((jf2) bf3Var.f).a.entrySet();
                    setEntrySet2.getClass();
                    for (Map.Entry entry : setEntrySet2) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                        break;
                    }
                }
                return (l35) linkedHashMap.get(str);
            default:
                return super.c(obj);
        }
    }

    @Override // defpackage.if2
    public void d(Object obj, Object obj2, Object obj3) {
        switch (this.h) {
            case 0:
                af3 af3Var = (af3) obj2;
                ((t6) ((v62) this.i).f).p((tj2) obj, af3Var.a, af3Var.b, af3Var.c);
                break;
            default:
                super.d(obj, obj2, obj3);
                break;
        }
    }

    @Override // defpackage.if2
    public int o(Object obj, Object obj2) {
        switch (this.h) {
            case 0:
                return ((af3) obj2).c;
            default:
                return super.o(obj, obj2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf3(int i, v62 v62Var) {
        super(i);
        this.i = v62Var;
    }
}
