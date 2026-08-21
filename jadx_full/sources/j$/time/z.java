package j$.time;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.time.temporal.TemporalAccessor;
import j$.util.Objects;
import j$.util.function.BiConsumer$CC;
import j$.util.function.BiFunction$CC;
import j$.util.function.Function$CC;
import j$.util.r1;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class z implements j$.time.temporal.n, IntFunction, Supplier, BiConsumer, BinaryOperator, Function {
    public final /* synthetic */ int a;

    public /* synthetic */ z(int i) {
        this.a = i;
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        switch (this.a) {
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                ((Collection) obj).add(obj2);
                break;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                ((List) obj).add(obj2);
                break;
            case 18:
                ((Set) obj).add(obj2);
                break;
            case 22:
                ((r1) obj).a((CharSequence) obj2);
                break;
            case 27:
                ((LinkedHashSet) obj).add(obj2);
                break;
            case 28:
                ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
                break;
            default:
                ((j$.util.w) obj).a((j$.util.w) obj2);
                break;
        }
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.a) {
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                break;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                break;
            case 18:
                break;
            case 22:
                break;
            case 27:
                break;
            case 28:
                break;
        }
        return BiConsumer$CC.$default$andThen(this, biConsumer);
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        switch (this.a) {
            case 13:
                Collection collection = (Collection) obj;
                Set set = Collectors.a;
                collection.addAll((Collection) obj2);
                return collection;
            case 20:
                List list = (List) obj;
                Set set2 = Collectors.a;
                list.addAll((List) obj2);
                return list;
            case 23:
                r1 r1Var = (r1) obj;
                r1 r1Var2 = (r1) obj2;
                r1Var.getClass();
                Objects.requireNonNull(r1Var2);
                if (r1Var2.d != null) {
                    r1Var2.b();
                    r1Var.a(r1Var2.d[0]);
                }
                return r1Var;
            default:
                Set set3 = (Set) obj;
                Set set4 = (Set) obj2;
                Set set5 = Collectors.a;
                if (set3.size() < set4.size()) {
                    set4.addAll(set3);
                    return set4;
                }
                set3.addAll(set4);
                return set3;
        }
    }

    public /* synthetic */ Function compose(Function function) {
        switch (this.a) {
        }
        return Function$CC.$default$compose(this, function);
    }

    public Object g(TemporalAccessor temporalAccessor) {
        int i = this.a;
        z zVar = j$.time.temporal.r.a;
        switch (i) {
            case 0:
                if (temporalAccessor instanceof ZonedDateTime) {
                    return (ZonedDateTime) temporalAccessor;
                }
                try {
                    ZoneId zoneIdA = ZoneId.A(temporalAccessor);
                    j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
                    temporalAccessor = temporalAccessor.e(aVar) ? ZonedDateTime.k(temporalAccessor.s(aVar), temporalAccessor.h(j$.time.temporal.a.NANO_OF_SECOND), zoneIdA) : ZonedDateTime.A(LocalDateTime.D(i.C(temporalAccessor), l.C(temporalAccessor)), zoneIdA, null);
                    return temporalAccessor;
                } catch (c e) {
                    throw new c("Unable to obtain ZonedDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e);
                }
            case 1:
                ZoneId zoneId = (ZoneId) temporalAccessor.m(zVar);
                if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                    return null;
                }
                return zoneId;
            case 2:
            default:
                j$.time.temporal.a aVar2 = j$.time.temporal.a.NANO_OF_DAY;
                if (temporalAccessor.e(aVar2)) {
                    return l.F(temporalAccessor.s(aVar2));
                }
                return null;
            case 3:
                return (ZoneId) temporalAccessor.m(zVar);
            case 4:
                return (j$.time.chrono.a) temporalAccessor.m(j$.time.temporal.r.b);
            case 5:
                return (j$.time.temporal.s) temporalAccessor.m(j$.time.temporal.r.c);
            case 6:
                j$.time.temporal.a aVar3 = j$.time.temporal.a.OFFSET_SECONDS;
                if (temporalAccessor.e(aVar3)) {
                    return ZoneOffset.J(temporalAccessor.h(aVar3));
                }
                return null;
            case 7:
                ZoneId zoneId2 = (ZoneId) temporalAccessor.m(zVar);
                return zoneId2 != null ? zoneId2 : (ZoneId) temporalAccessor.m(j$.time.temporal.r.d);
            case 8:
                j$.time.temporal.a aVar4 = j$.time.temporal.a.EPOCH_DAY;
                if (temporalAccessor.e(aVar4)) {
                    return i.L(temporalAccessor.s(aVar4));
                }
                return null;
        }
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.a) {
            case 11:
                return new j$.util.w();
            case FileClientSessionCache.MAX_SIZE /* 12 */:
            case 13:
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
            case 18:
            default:
                return new LinkedHashSet();
            case 14:
                return new ArrayList();
            case 16:
                return new j$.util.x();
            case 17:
                return new HashSet();
            case 19:
                return new j$.util.z();
        }
    }

    @Override // j$.time.temporal.n
    public j$.time.temporal.m k(j$.time.temporal.m mVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.DAY_OF_MONTH;
        return mVar.c(mVar.j(aVar).d, aVar);
    }

    public String toString() {
        switch (this.a) {
            case 3:
                return "ZoneId";
            case 4:
                return "Chronology";
            case 5:
                return "Precision";
            case 6:
                return "ZoneOffset";
            case 7:
                return "Zone";
            case 8:
                return "LocalDate";
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return "LocalTime";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        switch (this.a) {
            case 13:
                break;
            case 20:
                break;
            case 23:
                break;
        }
        return BiFunction$CC.$default$andThen(this, function);
    }

    /* JADX INFO: renamed from: andThen, reason: collision with other method in class */
    public /* synthetic */ Function m13andThen(Function function) {
        switch (this.a) {
        }
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (this.a) {
            case 21:
                Set set = Collectors.a;
                return obj;
            default:
                return ((r1) obj).toString();
        }
    }

    @Override // java.util.function.IntFunction
    public Object apply(int i) {
        return new Object[i];
    }
}
