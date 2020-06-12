package benchmark;

import hashMap.HashMap;
import org.openjdk.jmh.annotations.* ;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BenchmarkLoop {

    private static final int N = 1000000;


    public static void main(String[]args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkLoop.class.getSimpleName())
                .forks(5)
                .build();

        new Runner(opt).run();
    }

    @Warmup(iterations = 5)
    @Measurement(iterations = 100)
    @Benchmark
    public void addToCustomHashMap() {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < N; i++) {
            hashMap.put(i, i);
        }
    }

    @Warmup(iterations = 5)
    @Measurement(iterations = 100)
    @Benchmark
    public void addToHashMap() {
        java.util.HashMap<Integer, Long> hashMap = new java.util.HashMap<Integer, Long>();
        for (int i = 0; i < N; i++) {
            hashMap.put(i, (long)i);
        }
    }



    //Benchmark code

}
