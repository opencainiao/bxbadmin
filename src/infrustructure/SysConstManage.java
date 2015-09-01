package infrustructure;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import mou.mongodb.MongoCollectionUtil;
import mou.mongodb.util.JsonUtil;
import System.SystemInitor;

public class SysConstManage {
	private static final String COLLECTION_SYSCONST = "sysconst";//
	private static final String COLLECTION_SYSCONST_TYPE = "sysconsttype";//

	public static void removeSysconst() {
		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("useflg", "0");
		queryCondition.put("delflg", "1");

		MongoCollectionUtil.remove(COLLECTION_SYSCONST, queryCondition);
	}

	public static void removeSysconstType() {
		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("useflg", "0");
		queryCondition.put("delflg", "1");

		MongoCollectionUtil.remove(COLLECTION_SYSCONST_TYPE, queryCondition);
	}

	public static void main(String[] args) {

		SystemInitor.init(true, false);

		removeSysconst();
		removeSysconstType();

		System.out.println("清理完毕");
		System.out.println("==============================SYSCONST");
		List list = MongoCollectionUtil.findBatchDBObject(COLLECTION_SYSCONST,
				null, null);
		System.out.println(JsonUtil.toJsonStr(list));

		System.out.println("==============================SYSCONST_TYPE");
		list = MongoCollectionUtil.findBatchDBObject(COLLECTION_SYSCONST_TYPE,
				null, null);
		System.out.println(JsonUtil.toJsonStr(list));

	}
}
