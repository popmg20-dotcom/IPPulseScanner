package j$.util;

import com.tencent.mars.xlog.Xlog;
import j$.util.function.Consumer$CC;
import j$.util.function.Function$CC;
import j$.util.function.IntPredicate$CC;
import j$.util.function.Predicate$CC;
import j$.util.stream.Collectors;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import j$.util.stream.a8;
import j$.util.stream.h7;
import j$.util.stream.j5;
import j$.util.stream.j7;
import j$.util.stream.l7;
import j$.util.stream.u6;
import j$.util.stream.v6;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.LongFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class p implements Consumer, IntPredicate, Predicate, Supplier, DoubleFunction, Function, LongFunction, BooleanSupplier {
    public final /* synthetic */ int a;
    public Object b;

    public /* synthetic */ p(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public void a(v6 v6Var) {
        ((EnumMap) ((java.util.Map) this.b)).put(v6Var, 1);
    }

    @Override // java.util.function.Consumer
    public void accept(Object obj) {
        switch (this.a) {
            case 0:
                ((Consumer) this.b).accept(new q((Map.Entry) obj));
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                ((j5) this.b).accept(obj);
                break;
            default:
                ((ArrayList) ((java.util.List) this.b)).add(obj);
                break;
        }
    }

    public /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
        return IntPredicate$CC.$default$and(this, intPredicate);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
            case 0:
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                break;
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Object objApply = ((Function) this.b).apply(obj);
        if (objApply == null) {
            return null;
        }
        if (objApply instanceof Stream) {
            return Stream.Wrapper.convert((Stream) objApply);
        }
        if (objApply instanceof java.util.stream.Stream) {
            return u6.g((java.util.stream.Stream) objApply);
        }
        if (objApply instanceof IntStream) {
            return IntStream.Wrapper.convert((IntStream) objApply);
        }
        if (objApply instanceof java.util.stream.IntStream) {
            return IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) objApply);
        }
        if (objApply instanceof DoubleStream) {
            return j$.util.stream.c0.g((DoubleStream) objApply);
        }
        if (objApply instanceof java.util.stream.DoubleStream) {
            return j$.util.stream.b0.g((java.util.stream.DoubleStream) objApply);
        }
        if (objApply instanceof LongStream) {
            return j$.util.stream.k1.g((LongStream) objApply);
        }
        if (objApply instanceof java.util.stream.LongStream) {
            return j$.util.stream.j1.g((java.util.stream.LongStream) objApply);
        }
        f.a(objApply.getClass(), "java.util.stream.*Stream");
        throw null;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.a) {
            case 3:
                return ((j$.util.stream.a) this.b).K(0);
            case 4:
                return (Spliterator) this.b;
            default:
                CharSequence charSequence = (CharSequence) this.b;
                java.util.Set set = Collectors.a;
                return new r1(charSequence);
        }
    }

    @Override // java.util.function.BooleanSupplier
    public boolean getAsBoolean() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                h7 h7Var = (h7) obj;
                return h7Var.d.tryAdvance(h7Var.e);
            case 13:
                j7 j7Var = (j7) obj;
                return j7Var.d.tryAdvance(j7Var.e);
            case 14:
                l7 l7Var = (l7) obj;
                return l7Var.d.tryAdvance(l7Var.e);
            default:
                a8 a8Var = (a8) obj;
                return a8Var.d.tryAdvance(a8Var.e);
        }
    }

    public /* synthetic */ IntPredicate negate() {
        return IntPredicate$CC.$default$negate(this);
    }

    public /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
        return IntPredicate$CC.$default$or(this, intPredicate);
    }

    @Override // java.util.function.Predicate
    public boolean test(Object obj) {
        return !((Predicate) this.b).test(obj);
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate$CC.$default$and(this, predicate);
    }

    /* JADX INFO: renamed from: negate, reason: collision with other method in class */
    public /* synthetic */ Predicate m14negate() {
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate$CC.$default$or(this, predicate);
    }

    public /* synthetic */ p(int i) {
        this.a = i;
    }

    @Override // java.util.function.IntPredicate
    public boolean test(int i) {
        return !((IntPredicate) this.b).test(i);
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.DoubleFunction
    public Object apply(double d) {
        Object objApply = ((DoubleFunction) this.b).apply(d);
        if (objApply == null) {
            return null;
        }
        if (objApply instanceof DoubleStream) {
            return j$.util.stream.c0.g((DoubleStream) objApply);
        }
        if (objApply instanceof java.util.stream.DoubleStream) {
            return j$.util.stream.b0.g((java.util.stream.DoubleStream) objApply);
        }
        f.a(objApply.getClass(), "java.util.stream.DoubleStream");
        throw null;
    }

    @Override // java.util.function.LongFunction
    public Object apply(long j) {
        Object objApply = ((LongFunction) this.b).apply(j);
        if (objApply == null) {
            return null;
        }
        if (objApply instanceof LongStream) {
            return j$.util.stream.k1.g((LongStream) objApply);
        }
        if (objApply instanceof java.util.stream.LongStream) {
            return j$.util.stream.j1.g((java.util.stream.LongStream) objApply);
        }
        f.a(objApply.getClass(), "java.util.stream.LongStream");
        throw null;
    }
}
