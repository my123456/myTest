package db;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class Cache {

	public static LoadingCache<Long, Optional<String>> cache = CacheBuilder.newBuilder().maximumSize(2).expireAfterAccess(1, TimeUnit.MINUTES)
			.build(new CacheLoader<Long, Optional<String>>() {
				
				@Override
				public Optional<String> load(Long autoid) throws Exception {
					return Optional.fromNullable(autoid + "");
				}
			});

	public static void main(String[] args) throws ExecutionException {
		
		for (Long i = 0L; i < 10; i++) {
			System.out.println(cache.get(i));
			ConcurrentMap<Long, Optional<String>> map = cache.asMap();
			System.out.println(JSON.toJSONString(map));

		}
		System.out.println(String.valueOf(cache.stats()));
	}
}
