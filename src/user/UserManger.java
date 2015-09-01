package user;

import java.util.List;

import mou.mongodb.MongoCollectionUtil;
import mou.mongodb.util.JsonUtil;

import org.mou.common.DateUtil;
import org.mou.common.security.EncryptMou;

import System.SystemInitor;

public class UserManger {

	private static final String COLLECTION_NAME_USER = "user";// 系统用户Collection

	public static void addUser(User user) {

		// 加密
		String passwordIn = user.getPassword();
		String passwordHashed = EncryptMou.encrypt(passwordIn);
		user.setPassword(passwordHashed);

		MongoCollectionUtil.insertObj(COLLECTION_NAME_USER, user);
	}

	private static User createUser() {

		User user = new User();

		user.setCdate(DateUtil.getCurdate());
		user.setEmail("25662996@qq.com");
		user.setNick("系统管理员");
		user.setPhone("15010200000");
		user.setUsername("admin");
		user.setPassword("admin");
		user.setState(UserState.ACTIVE);
		user.setCharacter(UserCharacter.BOTH_MANAGE_AND_FRONTUSER);
		user.setSex(Sex.MAN);

		return user;
	}

	public static void main(String[] args) {

		SystemInitor.init(true, false);

		MongoCollectionUtil.clearCollection(COLLECTION_NAME_USER);

		User user = createUser();
		addUser(user);

		List list = MongoCollectionUtil.findBatchDBObject(COLLECTION_NAME_USER,
				null, null);

		System.out.println(JsonUtil.toJsonStr(list));

	}
}
