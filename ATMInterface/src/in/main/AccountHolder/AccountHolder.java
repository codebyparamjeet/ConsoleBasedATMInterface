package in.main.AccountHolder;

public class AccountHolder {
    private String userId;
    private String userPin;

    public AccountHolder(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserPin() {
        return this.userPin;
    }
}
