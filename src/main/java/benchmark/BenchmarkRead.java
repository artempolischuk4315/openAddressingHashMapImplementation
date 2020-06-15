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
@State(Scope.Benchmark)
@Warmup(iterations = 2)
@Measurement(iterations = 5)
public class BenchmarkRead {

    private HashMap hashMap;

    @Setup(Level.Trial)
    public void prepare(){
        hashMap= new HashMap();
        for (int i = 0; i < size; i++) {
            hashMap.put(i, i);
        }
    }

    @Param({"10000","100000", "1000000", "10000000"})
    public int size;

    @Benchmark
    public void MyHashMapReadInARow() {

        for (int i = 0; i <size; i++) {
            hashMap.get(i);
        }
    }

    @Benchmark
    public void MyHashMapReadNotExistingElements() {

        for (int i = 0; i <size; i++) {
            hashMap.get(i+size);
        }
    }

    @Benchmark
    public void MyHashMapReadRandomElements() {

        for (int i = 0; i <size; i++) {
            hashMap.get(new Random().nextInt());
        }
    }
}
