package radomski.edu.pl.architecturesample.api;

public abstract class BaseApiClient<T> {


    private T apiWorker;

    public void setApiWorker(T apiWorker) {
        this.apiWorker = apiWorker;
    }

    public T getApiWorker() {
        return apiWorker;
    }

}
