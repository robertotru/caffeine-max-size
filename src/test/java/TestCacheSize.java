import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertThat;

public class TestCacheSize {

    @Test
    public void caffeineShouldEvictAfterMaxSizeReached() throws InterruptedException {
        // Arrange
        int maximumSize = 2_000;
        Cache<Key, String> cache = Caffeine.newBuilder()
                // An entry expires after that 7 days are passed from the creation or last access
                .expireAfterAccess(7, TimeUnit.DAYS)
                // Retain up to maximumSize elements
                .maximumSize(maximumSize)
                .build();

        // Act
        IntStream.range(0, maximumSize+1000)
                .forEach(index->cache.put(new Key(index), "Whatever"));
        TimeUnit.SECONDS.sleep(5);
        int numEntries = cache.asMap().size();

        // Assert
        assertThat(numEntries, CoreMatchers.is(maximumSize));
    }

}
