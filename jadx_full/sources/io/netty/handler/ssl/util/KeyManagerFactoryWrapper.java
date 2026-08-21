package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import java.security.KeyStore;
import javax.net.ssl.KeyManager;
import javax.net.ssl.ManagerFactoryParameters;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class KeyManagerFactoryWrapper extends SimpleKeyManagerFactory {
    private final KeyManager km;

    public KeyManagerFactoryWrapper(KeyManager keyManager) {
        this.km = (KeyManager) ObjectUtil.checkNotNull(keyManager, "km");
    }

    @Override // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    public KeyManager[] engineGetKeyManagers() {
        return new KeyManager[]{this.km};
    }

    @Override // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    public void engineInit(ManagerFactoryParameters managerFactoryParameters) {
    }

    @Override // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    public void engineInit(KeyStore keyStore, char[] cArr) {
    }
}
