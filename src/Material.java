import java.util.List;
import java.util.regex.Pattern;

import mou.mongodb.MongoCollectionUtil;

import org.mou.common.JsonUtil;

import System.SystemInitor;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Material {
	// 材料类别表
	private static final String COLLECTION_NAME_MATERIAL = "material";

	public static void main(String[] args) {

		// 本地、测试库
		SystemInitor.init(false, true);

		DBObject query = new BasicDBObject();

		Pattern codePattern = RegexPatternUtil.getLikePattern("123");
		query.put("code", codePattern);
		// query.put("status", MaterialTypeStatus.INUSE.toString());
		DBObject sort = new BasicDBObject();
		sort.put("_id", 1);
		DBObject returnFields = null;

		List<DBObject> list = MongoCollectionUtil.findBatchDBObject(
				COLLECTION_NAME_MATERIAL, query, returnFields);

		System.out.println("查询结果");
		System.out.println(JsonUtil.toJsonStr(list));

		System.out.println("===================================");

		list = MongoCollectionUtil.findBatchDBObject(COLLECTION_NAME_MATERIAL,
				null, returnFields);
		System.out.println("查询结果");
		System.out.println(JsonUtil.toJsonStr(list));

	}
}
