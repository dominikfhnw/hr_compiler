public class Ident extends Base {
    private final String ident;

    Ident (String ident) {
        super(Terminals.IDENT);
        this.ident = ident;
    }

}
