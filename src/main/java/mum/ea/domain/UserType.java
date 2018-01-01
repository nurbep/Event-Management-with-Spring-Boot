package mum.ea.domain;
public enum UserType {
	
	
    OPTION_2(2, "User"),
    OPTION_3(3, "Organizer");

	private int value;
	private String key;

	private UserType(int value, String key) {
		this.value = value;
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}