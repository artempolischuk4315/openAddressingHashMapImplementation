package benchmark;

import hashMap.HashMap;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2)
@Measurement(iterations = 5)
public class BenchmarkCreation {

    @Benchmark
    public void MyHashMap_Create_10_Thousand() {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 10000; i++) {
            hashMap.put(new Random().nextInt(), i);
        }
    }

    @Benchmark
    public void MyHashMap_Create_100_Thousand() {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 100000; i++) {
            hashMap.put(new Random().nextInt(), i);
        }
    }

    @Benchmark
    public void MyHashMap_Create_1_Million() {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 1000000; i++) {
            hashMap.put(new Random().nextInt(), i);
        }
    }

    @Benchmark
    public void MyHashMap_Create_10_Million() {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 10000000; i++) {
            hashMap.put(new Random().nextInt(), i);
        }
    }
}
