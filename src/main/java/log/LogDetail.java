package log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class LogDetail {
	private Detail update;
	private Detail insert;
	private Detail delete;

	public class Detail {
		private Map<String, List<String>> data = new HashMap<String, List<String>>();

		public void put(String clz, List<String> detail) {
			this.data.put(clz, detail);
		}

		public Map<String, List<String>> getData() {
			return this.data;
		}

		public void addList(String clz, String str) {
			List<String> list = this.getData().get(clz);
			if (list == null) {
				list = new ArrayList<String>();
			}
			list.add(str);
			put(clz, list);
		}

		public void addList(String clz, List<String> l) {
			List<String> list = this.getData().get(clz);
			if (list == null) {
				list = new ArrayList<String>();
			}
			list.addAll(l);
			put(clz, list);
		}
	}

	public void addUpdateList(String clz ,String str){
		if(update == null){
			update = getDetail();
		}
		this.update.addList(clz, str);
	}
	
	public void addUpdateList(String clz ,List<String> l){
		if(update == null){
			update = getDetail();
		}
		this.update.addList(clz, l);
	}
	
	public void addDeleteList(String clz ,String str){
		if(delete == null){
			delete = getDetail();
		}
		this.delete.addList(clz, str);
	}
	
	public void addDeleteList(String clz ,List<String> l){
		if(delete == null){
			delete = getDetail();
		}
		this.delete.addList(clz, l);
	}
	
	public void addInsertList(String clz ,String str){
		if(insert == null){
			insert = getDetail();
		}
		this.insert.addList(clz, str);
	}
	
	public void addInsertList(String clz ,List<String> l){
		if(insert == null){
			insert = getDetail();
		}
		this.insert.addList(clz, l);
	}
	
	public Detail getInsert() {
		return insert;
	}

	public void setInsert(Detail insert) {
		this.insert = insert;
	}

	public Detail getUpdate() {
		return update;
	}

	public void setUpdate(Detail update) {
		this.update = update;
	}

	public Detail getDelete() {
		return delete;
	}

	public void setDelete(Detail delete) {
		this.delete = delete;
	}
	
	public String toString(){
		return JSON.toJSONString(this);
	}
	
	private Detail getDetail(){
		//if(detail == null){
			return new Detail();
		//}else{
		//	return detail;
		//}
	}
}
