package com.github.xfalcon.vhosts.vservice;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private CleanupCallback callback;
    private int maxSize;

    public interface CleanupCallback<K, V> {
        void cleanup(Map.Entry<K, V> entry);
    }

    public LRUCache(int maxSize, CleanupCallback callback) {
        super(maxSize + 1, 1.0f, true);
        this.maxSize = maxSize;
        this.callback = callback;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        if (size() > this.maxSize) {
            this.callback.cleanup(eldest);
            return true;
        }
        return false;
    }
}
