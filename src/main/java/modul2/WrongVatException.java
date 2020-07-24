package modul2;

public class WrongVatException extends Exception {
    public WrongVatException() {
        super("Wrong VAT amount");
    }
}
