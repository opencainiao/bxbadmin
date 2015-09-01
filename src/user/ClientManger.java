package user;

import java.util.List;

import mou.mongodb.FindOneUtil;
import mou.mongodb.MongoCollectionUtil;
import mou.mongodb.util.JsonUtil;

import org.bson.types.ObjectId;
import org.mou.common.DateUtil;
import org.mou.common.security.EncryptMou;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import System.SystemInitor;

public class ClientManger {

	private static final String COLLECTION_NAME_CLIENT = "client";// 系统用户Collection

	public static void main(String[] args) {

		SystemInitor.init(true, false);

		List list = MongoCollectionUtil.findBatchDBObject(
				COLLECTION_NAME_CLIENT, null, null);

		System.out.println(JsonUtil.toJsonStr(list));

		System.out.println("===============================");

		DBObject query = new BasicDBObject();
		query.put("owner_user_id", "55b08c1d6a94f8b336a4a43d");
		query.put("_id", new ObjectId("55b82dbbcaf8c0570f9f7a4a"));
		
		DBObject dbo = FindOneUtil.findOneByConditionDBObject(COLLECTION_NAME_CLIENT,
				query, null);
		
		System.out.println(JsonUtil.toJsonStr(dbo));

	}
}
