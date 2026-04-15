package tick_tac_toe_using_facade.model.validation;

public class CellMapper {
    public static int map(int pos) {
        return pos - 1;
    }
}