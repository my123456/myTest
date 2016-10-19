package log;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class LogUtil {
	
	private JSONObject object=new JSONObject();
	
	@SuppressWarnings("rawtypes")
	public void addUpdate(Class clazz,Map<String,Object> map){
		JSONObject update=object.getJSONObject("update");
		if(update==null){
			update=new JSONObject();
			object.put("update",update);
		}
		JSONArray records=update.getJSONArray(clazz.getSimpleName());
		if(records==null){
			records=new JSONArray();
			update.put(clazz.getSimpleName(),records);
		}
		records.add(JSON.toJSON(map));
	}
	
	
	@SuppressWarnings("rawtypes")
	public void addDelete(Class clazz,Map<String,Object> map){
		JSONObject delete=object.getJSONObject("delete");
		if(delete==null){
			delete=new JSONObject();
			object.put("delete",delete);
		}
		JSONArray records=delete.getJSONArray(clazz.getSimpleName());
		if(records==null){
			records=new JSONArray();
			delete.put(clazz.getSimpleName(),records);
		}
		records.add(JSON.toJSON(map));
	}
	
	@SuppressWarnings("rawtypes")
	public void addDInsert(Class clazz,Map<String,Object> map){
		JSONObject insert=object.getJSONObject("insert");
		if(insert==null){
			insert=new JSONObject();
			object.put("insert",insert);
		}
		JSONArray records=insert.getJSONArray(clazz.getSimpleName());
		if(records==null){
			records=new JSONArray();
			insert.put(clazz.getSimpleName(),records);
		}
		records.add(JSON.toJSON(map));
	}
	
	public String toString(){
		return JSON.toJSONString(object);
	}

	public static void main(String[] args) {
		LogUtil log=new LogUtil();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", new Object[]{"z3","l4",true});
		map.put("sex", new Object[]{"z3","l4",true});
		log.addUpdate(Long.class, map);
		log.addUpdate(Long.class, map);
		log.addDelete(Long.class, map);
		System.out.println(log.toString());
	}
}
