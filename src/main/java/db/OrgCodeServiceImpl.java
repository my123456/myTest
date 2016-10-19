package db;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class OrgCodeServiceImpl {
	private StringBuffer sb = new StringBuffer();
	private LoadingCache<Long, String> orgCodeCache = CacheBuilder.newBuilder().build(new CacheLoader<Long, String>() {
		@Override
		public String load(Long userId) throws Exception {
			System.out.println("loading...");
			sb=new StringBuffer();
			if(userId < 999L){
				sb.append("abc");
				return sb.toString();
			}
			return sb.toString();
		}
	});

	public String getOrgCode(Long userId) {
		try {
			System.out.println("orgCodeCache.size="+orgCodeCache.size());
			return orgCodeCache.get(userId);
		} catch (ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		OrgCodeServiceImpl obj = new OrgCodeServiceImpl();
		for(int i = 0 ;i<1000 ;i++){
			System.out.println(i+"---"+obj.getOrgCode(Long.valueOf(i+"")));
		}
//		System.out.println(obj.getOrgCode(10L));
//		System.out.println(obj.getOrgCode(null));
//		System.out.println(obj.getOrgCode(999L));
		
	}
}
