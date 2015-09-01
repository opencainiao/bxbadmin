package user;

import java.util.List;

import mou.mongodb.MongoClientManager;
import mou.mongodb.MongoCollectionUtil;
import mou.mongodb.util.JsonUtil;
import System.SystemInitor;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class AddressDel {

	private static final String COLLECTION_NAME_ADDRESS = "address";// 系统用户Collection

	public static void main(String[] args) {

		SystemInitor.init(true, false);

		DBObject query = new BasicDBObject();
		query.put("owner_id", "55b73d17caf8e8134bc298ee");

		List list = MongoCollectionUtil.findBatchDBObject(
				COLLECTION_NAME_ADDRESS, query, null);

		System.out.println(JsonUtil.toJsonStr(list));

		System.out.println("===============================");

		DBCollection collection = MongoClientManager
				.getCollection(COLLECTION_NAME_ADDRESS);

		WriteResult wr = collection.remove(query);

		System.out.println("===================================");
		System.out.println(wr);

		list = MongoCollectionUtil.findBatchDBObject(COLLECTION_NAME_ADDRESS,
				query, null);

		System.out.println("===============================");
		System.out.println(JsonUtil.toJsonStr(list));

	}

}
