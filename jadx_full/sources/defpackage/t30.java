package defpackage;

import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t30 implements CharacterIterator {
    public final CharSequence b;
    public int f;

    public t30(CharSequence charSequence) {
        this.b = charSequence;
    }

    @Override // java.text.CharacterIterator
    public final Object clone() {
        t30 t30Var = new t30(this.b);
        t30Var.f = this.f;
        return t30Var;
    }

    @Override // java.text.CharacterIterator
    public final char current() {
        int i = this.f;
        CharSequence charSequence = this.b;
        if (i == charSequence.length()) {
            return (char) 65535;
        }
        return charSequence.charAt(this.f);
    }

    @Override // java.text.CharacterIterator
    public final char first() {
        this.f = 0;
        return current();
    }

    @Override // java.text.CharacterIterator
    public final int getBeginIndex() {
        return 0;
    }

    @Override // java.text.CharacterIterator
    public final int getEndIndex() {
        return this.b.length();
    }

    @Override // java.text.CharacterIterator
    public final int getIndex() {
        return this.f;
    }

    @Override // java.text.CharacterIterator
    public final char last() {
        int length = this.b.length() - 1;
        this.f = length;
        if (length < 0) {
            this.f = 0;
        }
        return current();
    }

    @Override // java.text.CharacterIterator
    public final char next() {
        this.f++;
        return current();
    }

    @Override // java.text.CharacterIterator
    public final char previous() {
        int i = this.f - 1;
        this.f = i;
        if (i < 0) {
            this.f = 0;
        }
        return current();
    }

    @Override // java.text.CharacterIterator
    public final char setIndex(int i) {
        this.f = i;
        return current();
    }
}
