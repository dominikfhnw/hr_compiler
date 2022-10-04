public class Literal extends Base {

    private final int value;

    Literal (int value) {
        super(Terminals.LITERAL);
        this.value = value;
    }

}
