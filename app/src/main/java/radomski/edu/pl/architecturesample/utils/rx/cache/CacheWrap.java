package radomski.edu.pl.architecturesample.utils.rx.cache;

class CacheWrap<T> implements CacheWrapper<T> {
    private boolean isValid = true;
    private T value;

    public CacheWrap(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void invalidate() {
        isValid = false;
    }

    @Override
    public boolean isValid() {
        return isValid;
    }
}
