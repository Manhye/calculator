package back;

public class Token {

    private String type;
    private String value;

    Token(String type, String value){
        this.type = type;
        this.value = value;
    }

    public Object getType() {
        return type;
    }
    public String getValue(){
        return value;
    }
}
