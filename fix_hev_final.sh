#!/bin/bash
PKG="com.ippulse.scanner"
PKG_DIR="app/src/main/java/$(echo $PKG | tr '.' '/')"

# Fix Gradle Repository
cat << 'GRADLE' > settings.gradle
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
rootProject.name = "IPPulseScanner"
include ':app'
GRADLE

# Update app/build.gradle
cat << 'BUILD' > app/build.gradle
plugins {
    id 'com.android.application'
}

android {
    compileSdkVersion 33
    defaultConfig {
        applicationId "com.ippulse.scanner"
        minSdkVersion 21
        targetSdkVersion 33
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            minifyEnabled false
        }
    }
}

dependencies {
    implementation 'com.github.heiher:hev-socks5-tunnel:2.17.1'
}
BUILD

mkdir -p "$PKG_DIR"

# GamingVpnService.java
cat << EOF > "$PKG_DIR/GamingVpnService.java"
package $PKG;

import android.content.Intent;
import android.net.VpnService;
import android.os.ParcelFileDescriptor;
import java.io.File;

public class GamingVpnService extends VpnService {
    private ParcelFileDescriptor vpnInterface;
    private LocalSocks5Server socks5Server;
    private TProxyService tProxyService;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startVpn();
        return START_STICKY;
    }

    private void startVpn() {
        try {
            socks5Server = new LocalSocks5Server(this, 1080);
            socks5Server.start();

            Builder builder = new Builder();
            builder.setSession("IPPulseScanner")
                   .setMtu(1400)
                   .addAddress("10.0.0.2", 24)
                   .addDnsServer("8.8.8.8")
                   .addRoute("0.0.0.0", 0);

            vpnInterface = builder.establish();
            if (vpnInterface == null) return;
            
            int fd = vpnInterface.getFd();
            tProxyService = new TProxyService(this);
            tProxyService.start(fd, 1400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        if (tProxyService != null) tProxyService.stop();
        if (socks5Server != null) socks5Server.stop();
        try { if (vpnInterface != null) vpnInterface.close(); } catch (Exception ignored) {}
        super.onDestroy();
    }
}
