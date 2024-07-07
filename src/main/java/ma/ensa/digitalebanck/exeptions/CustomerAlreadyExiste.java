package ma.ensa.digitalebanck.exeptions;

public class CustomerAlreadyExiste extends Throwable {
    public CustomerAlreadyExiste(String string) {
        super(string);
    }
}
