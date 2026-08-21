package io.netty.handler.codec.serialization;

import defpackage.dw2;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
class CompactObjectInputStream extends ObjectInputStream {
    private final ClassResolver classResolver;

    public CompactObjectInputStream(InputStream inputStream, ClassResolver classResolver) {
        super(inputStream);
        this.classResolver = classResolver;
    }

    @Override // java.io.ObjectInputStream
    public ObjectStreamClass readClassDescriptor() throws IOException {
        int i = read();
        if (i < 0) {
            throw new EOFException();
        }
        if (i == 0) {
            return super.readClassDescriptor();
        }
        if (i != 1) {
            throw new StreamCorruptedException(dw2.A(i, "Unexpected class descriptor type: "));
        }
        return ObjectStreamClass.lookupAny(this.classResolver.resolve(readUTF()));
    }

    @Override // java.io.ObjectInputStream
    public void readStreamHeader() throws StreamCorruptedException {
        int i = readByte() & 255;
        if (i != 5) {
            throw new StreamCorruptedException(dw2.A(i, "Unsupported version: "));
        }
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
        try {
            return this.classResolver.resolve(objectStreamClass.getName());
        } catch (ClassNotFoundException unused) {
            return super.resolveClass(objectStreamClass);
        }
    }
}
