package radomski.edu.pl.architecturesample.utils.tuple;

public class Tuple {
    private Tuple() {

    }

    public static <T1, T2> Tuple2<T1, T2> make(T1 first, T2 second) {
        return new Tuple2<>(first, second);
    }

    public static <T1, T2, T3> Tuple3<T1, T2, T3> make(T1 first, T2 second, T3 third) {
        return new Tuple3<>(first, second, third);
    }

    public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> make(T1 first, T2 second, T3 third, T4 fourth) {
        return new Tuple4<>(first, second, third, fourth);
    }

    public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> make(T1 first, T2 second, T3 third, T4 fourth, T5 fifth) {
        return new Tuple5<>(first, second, third, fourth, fifth);
    }
    public static <T1, T2, T3, T4, T5,T6> Tuple6<T1, T2, T3, T4, T5,T6> make(T1 first, T2 second, T3 third, T4 fourth, T5 fifth, T6 sixth) {
        return new Tuple6<>(first, second, third, fourth, fifth,sixth);
    }

}
