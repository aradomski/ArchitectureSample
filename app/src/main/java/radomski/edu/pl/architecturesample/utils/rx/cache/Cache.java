package radomski.edu.pl.architecturesample.utils.rx.cache;

public interface Cache {
    void invalidate();

    boolean isValid();
}
