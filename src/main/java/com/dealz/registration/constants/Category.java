package com.dealz.registration.constants;


public enum Category {
	TKK(1), TIK(2), BTK(3), ATK(4), CAB(5);

	private int id;

	Category(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public static Category findByValue(int value) {
		switch (value) {
		case 1:
			return TKK;
		case 2:
			return TIK;
		case 3:
			return BTK;
		case 4:
			return ATK;
		case 5:
			return CAB;
		default:
			return null;
		}
	}
}
