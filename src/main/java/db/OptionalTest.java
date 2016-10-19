package db;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class OptionalTest {
	public static LoadingCache<String, Optional<String>> builder = CacheBuilder.newBuilder().maximumSize(10).expireAfterWrite(10, TimeUnit.SECONDS).recordStats()
			.build(new CacheLoader<String, Optional<String>>() {
				@Override
				public Optional<String> load(String key) throws Exception {
					// TODO Auto-generated method stub
					return Optional.fromNullable("123");
				}
			});

	public static void main(String[] args) {
		try {
			System.out.println(OptionalTest.builder.get("123").orNull());
			System.out.println(OptionalTest.builder.get("123").orNull());
			System.out.println("null");
			System.out.println(OptionalTest.builder.stats().hitRate());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
