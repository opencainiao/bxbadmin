package cash;

import mou.mongodb.MongoObjectId;

public class Unit {

	private MongoObjectId _id;
	private String name;
	private String _id_m;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String get_id_m() {
		return _id_m;
	}

	public void set_id_m(String _id_m) {
		this._id_m = _id_m;
	}

	public MongoObjectId get_id() {
		return _id;
	}

	public void set_id(MongoObjectId _id) {
		this._id = _id;
	}

	public void set_id(String _id) {
		MongoObjectId _idNew = new MongoObjectId();
		_idNew.set$oid(_id);
		this._id = _idNew;
	}
}
