package radomski.edu.pl.architecturesample.utils.rx.cache;

import java.util.Date;

class CacheWrapTime<T> extends CacheWrap<T> {

    private static int DEFAULT_CACHE_TIME = 1 * 60 * 1000;
    private int cacheTime = DEFAULT_CACHE_TIME;
    private Date loadTime;

    public CacheWrapTime(T value) {
        super(value);
        loadTime = new Date();
    }

    public void setCacheTime(int cacheTime) {
        this.cacheTime = cacheTime;
    }

    @Override
    public boolean isValid() {
        return super.isValid() && new Date().getTime() - loadTime.getTime() < cacheTime;
    }
}
