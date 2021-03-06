package graffiti2020;

import com.google.common.util.concurrent.RateLimiter;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("UnstableApiUsage")
public class RateLimiterTest {

  private static final Percentage percentage = Percentage.withPercentage(1e-7);

  private static void myFunction() { }

  @Test
  public void shouldLimitPermitsWhenLimitedResourceGiven() {

    final RateLimiter rateLimiter = RateLimiter.create(100);

    final long startTime = ZonedDateTime.now().getSecond();
    IntStream.range(0, 1000).forEach(i -> {
      // acquire 1000 times.
      rateLimiter.acquire(); // blocking method
      myFunction();
    });
    final long elapsedTimeSeconds = ZonedDateTime.now().getSecond() - startTime;

    // only can execute 100 units per 1 second, and there are 1000 acquires.
    assertThat(elapsedTimeSeconds).isCloseTo(10, percentage);

  }

}
