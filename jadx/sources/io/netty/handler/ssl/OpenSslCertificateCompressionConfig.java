package io.netty.handler.ssl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.internal.ObjectUtil;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class OpenSslCertificateCompressionConfig implements Iterable<AlgorithmConfig> {
    private final List<AlgorithmConfig> pairList;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class AlgorithmConfig {
        private final OpenSslCertificateCompressionAlgorithm algorithm;
        private final AlgorithmMode mode;

        private AlgorithmConfig(OpenSslCertificateCompressionAlgorithm openSslCertificateCompressionAlgorithm, AlgorithmMode algorithmMode) {
            this.algorithm = (OpenSslCertificateCompressionAlgorithm) ObjectUtil.checkNotNull(openSslCertificateCompressionAlgorithm, "algorithm");
            this.mode = (AlgorithmMode) ObjectUtil.checkNotNull(algorithmMode, RtspHeaders.Values.MODE);
        }

        public OpenSslCertificateCompressionAlgorithm algorithm() {
            return this.algorithm;
        }

        public AlgorithmMode mode() {
            return this.mode;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum AlgorithmMode {
        Compress,
        Decompress,
        Both
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class Builder {
        private final List<AlgorithmConfig> algorithmList;

        private Builder() {
            this.algorithmList = new ArrayList();
        }

        public Builder addAlgorithm(OpenSslCertificateCompressionAlgorithm openSslCertificateCompressionAlgorithm, AlgorithmMode algorithmMode) {
            this.algorithmList.add(new AlgorithmConfig(openSslCertificateCompressionAlgorithm, algorithmMode));
            return this;
        }

        public OpenSslCertificateCompressionConfig build() {
            return new OpenSslCertificateCompressionConfig((AlgorithmConfig[]) this.algorithmList.toArray(new AlgorithmConfig[0]));
        }
    }

    private OpenSslCertificateCompressionConfig(AlgorithmConfig... algorithmConfigArr) {
        this.pairList = DesugarCollections.unmodifiableList(Arrays.asList(algorithmConfigArr));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // java.lang.Iterable
    public Iterator<AlgorithmConfig> iterator() {
        return this.pairList.iterator();
    }
}
