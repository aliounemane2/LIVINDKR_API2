package qualshore.livindkr.main.models;

/**
 * Created by User on 09/01/2018.
 */
public class MessageResult {
    private String message;
    private String corps;

    public MessageResult(String message, String corps) {
        this.message = message;
        this.corps = corps;
    }

    public MessageResult() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }
}
