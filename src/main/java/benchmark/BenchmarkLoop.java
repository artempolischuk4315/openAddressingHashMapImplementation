package benchmark;

import org.openjdk.jmh.annotations.* ;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BenchmarkLoop {

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(benchmark.BenchmarkRead.class.getSimpleName())
                .include(benchmark.BenchmarkCreation.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
