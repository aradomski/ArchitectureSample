package radomski.edu.pl.architecturesample.utils.tuple;

public class Tuple2<T1, T2> extends Tuple1<T1> {
    public final T2 second;

    public Tuple2(T1 first, T2 second) {
        super(first);
        this.second = second;
    }
}
