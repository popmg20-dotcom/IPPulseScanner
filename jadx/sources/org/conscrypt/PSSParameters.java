package org.conscrypt;

import defpackage.dw2;
import defpackage.vp1;
import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class PSSParameters extends AlgorithmParametersSpi {
    private PSSParameterSpec spec = PSSParameterSpec.DEFAULT;

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws Throwable {
        long jAsn1_write_init;
        long jAsn1_write_sequence;
        long jAsn1_write_tag = 0;
        try {
            jAsn1_write_init = NativeCrypto.asn1_write_init();
            try {
                jAsn1_write_sequence = NativeCrypto.asn1_write_sequence(jAsn1_write_init);
            } catch (IOException e) {
                e = e;
                jAsn1_write_sequence = 0;
            } catch (Throwable th) {
                th = th;
                NativeCrypto.asn1_write_free(jAsn1_write_tag);
                NativeCrypto.asn1_write_free(jAsn1_write_init);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            jAsn1_write_sequence = 0;
        } catch (Throwable th2) {
            th = th2;
            jAsn1_write_init = 0;
        }
        try {
            OAEPParameters.writeHashAndMgfHash(jAsn1_write_sequence, this.spec.getDigestAlgorithm(), (MGF1ParameterSpec) this.spec.getMGFParameters());
            if (this.spec.getSaltLength() != 20) {
                try {
                    jAsn1_write_tag = NativeCrypto.asn1_write_tag(jAsn1_write_sequence, 2);
                    NativeCrypto.asn1_write_uint64(jAsn1_write_tag, this.spec.getSaltLength());
                    NativeCrypto.asn1_write_flush(jAsn1_write_sequence);
                    NativeCrypto.asn1_write_free(jAsn1_write_tag);
                } catch (Throwable th3) {
                    NativeCrypto.asn1_write_flush(jAsn1_write_sequence);
                    NativeCrypto.asn1_write_free(jAsn1_write_tag);
                    throw th3;
                }
            }
            byte[] bArrAsn1_write_finish = NativeCrypto.asn1_write_finish(jAsn1_write_init);
            NativeCrypto.asn1_write_free(jAsn1_write_sequence);
            NativeCrypto.asn1_write_free(jAsn1_write_init);
            return bArrAsn1_write_finish;
        } catch (IOException e3) {
            e = e3;
            jAsn1_write_tag = jAsn1_write_init;
            try {
                NativeCrypto.asn1_write_cleanup(jAsn1_write_tag);
                throw e;
            } catch (Throwable th4) {
                th = th4;
                jAsn1_write_init = jAsn1_write_tag;
                jAsn1_write_tag = jAsn1_write_sequence;
                NativeCrypto.asn1_write_free(jAsn1_write_tag);
                NativeCrypto.asn1_write_free(jAsn1_write_init);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            jAsn1_write_tag = jAsn1_write_sequence;
            NativeCrypto.asn1_write_free(jAsn1_write_tag);
            NativeCrypto.asn1_write_free(jAsn1_write_init);
            throw th;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls == null || cls != PSSParameterSpec.class) {
            throw new InvalidParameterSpecException(dw2.B(cls, "Unsupported class: "));
        }
        return this.spec;
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws Throwable {
        Throwable th;
        long jAsn1_read_init;
        long jAsn1_read_tagged;
        int iAsn1_read_uint64;
        long jAsn1_read_tagged2 = 0;
        try {
            jAsn1_read_init = NativeCrypto.asn1_read_init(bArr);
            try {
                long jAsn1_read_sequence = NativeCrypto.asn1_read_sequence(jAsn1_read_init);
                try {
                    String hash = OAEPParameters.readHash(jAsn1_read_sequence);
                    String mgfHash = OAEPParameters.readMgfHash(jAsn1_read_sequence);
                    if (NativeCrypto.asn1_read_next_tag_is(jAsn1_read_sequence, 2)) {
                        try {
                            jAsn1_read_tagged = NativeCrypto.asn1_read_tagged(jAsn1_read_sequence);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            iAsn1_read_uint64 = (int) NativeCrypto.asn1_read_uint64(jAsn1_read_tagged);
                            NativeCrypto.asn1_read_free(jAsn1_read_tagged);
                        } catch (Throwable th3) {
                            th = th3;
                            jAsn1_read_tagged2 = jAsn1_read_tagged;
                            throw th;
                        }
                    } else {
                        iAsn1_read_uint64 = 20;
                    }
                    int i = iAsn1_read_uint64;
                    if (NativeCrypto.asn1_read_next_tag_is(jAsn1_read_sequence, 3)) {
                        try {
                            jAsn1_read_tagged2 = NativeCrypto.asn1_read_tagged(jAsn1_read_sequence);
                            long jAsn1_read_uint64 = (int) NativeCrypto.asn1_read_uint64(jAsn1_read_tagged2);
                            NativeCrypto.asn1_read_free(jAsn1_read_tagged2);
                            if (jAsn1_read_uint64 != 1) {
                                throw new IOException("Error reading ASN.1 encoding");
                            }
                        } finally {
                            NativeCrypto.asn1_read_free(jAsn1_read_tagged2);
                        }
                    }
                    if (!NativeCrypto.asn1_read_is_empty(jAsn1_read_sequence) || !NativeCrypto.asn1_read_is_empty(jAsn1_read_init)) {
                        throw new IOException("Error reading ASN.1 encoding");
                    }
                    this.spec = new PSSParameterSpec(hash, "MGF1", new MGF1ParameterSpec(mgfHash), i, 1);
                    NativeCrypto.asn1_read_free(jAsn1_read_sequence);
                    NativeCrypto.asn1_read_free(jAsn1_read_init);
                } catch (Throwable th4) {
                    th = th4;
                    jAsn1_read_tagged2 = jAsn1_read_sequence;
                    NativeCrypto.asn1_read_free(jAsn1_read_tagged2);
                    NativeCrypto.asn1_read_free(jAsn1_read_init);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            jAsn1_read_init = 0;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "Conscrypt PSS AlgorithmParameters";
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        if (str != null && !str.equals("ASN.1") && !str.equals("X.509")) {
            vp1.i("Unsupported format: ".concat(str));
            return null;
        }
        return engineGetEncoded();
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof PSSParameterSpec) {
            this.spec = (PSSParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("Only PSSParameterSpec is supported");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws Throwable {
        if (str != null && !str.equals("ASN.1") && !str.equals("X.509")) {
            vp1.i("Unsupported format: ".concat(str));
        } else {
            engineInit(bArr);
        }
    }
}
