package cash;

import java.util.List;
import java.util.Set;

import org.mou.common.DateUtil;

import user.User;
import user.UserState;
import mou.mongodb.MongoCollectionUtil;
import mou.mongodb.MongoDbUtil;
import mou.mongodb.util.JsonUtil;
import System.SystemInitor;

public class UnitManage {
	private static final String COLLECTION_NAME_UNIT = "unit";// 单位

	public static void genUnit() {
		SystemInitor.init(false, true);

		for (int i = 0; i < 10; ++i) {
			MongoCollectionUtil.insertObj(COLLECTION_NAME_UNIT,
					createUnit("unit_" + i));
		}
	}

	private static Unit createUnit(String name) {
		Unit obj = new Unit();
		obj.setName(name);
		return obj;
	}

	private static void printAllDatas() {
		List list = MongoCollectionUtil.findBatchDBObject(COLLECTION_NAME_UNIT,
				null, null);

		System.out.println(JsonUtil.toJsonStr(list));
	}

	public static void main(String[] args) {

		UnitManage.genUnit();

		UnitManage.printAllDatas();
	}

}
