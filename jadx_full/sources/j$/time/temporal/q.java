package j$.time.temporal;

import j$.time.format.v;
import j$.time.format.w;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public interface q {
    boolean h(TemporalAccessor temporalAccessor);

    u i(TemporalAccessor temporalAccessor);

    boolean isDateBased();

    TemporalAccessor j(Map map, v vVar, w wVar);

    u k();

    long m(TemporalAccessor temporalAccessor);

    m p(m mVar, long j);
}
