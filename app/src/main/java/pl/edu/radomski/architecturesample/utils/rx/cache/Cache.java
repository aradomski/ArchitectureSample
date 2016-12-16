package pl.edu.radomski.architecturesample.utils.rx.cache;

public interface Cache {
    void invalidate();

    boolean isValid();
}
