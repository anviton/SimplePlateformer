package controleurs.util;

import javafx.beans.property.ObjectProperty;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 * @author cedric
 */
public class IntegerSpinnerTableCell<S> extends TableCell<S, Integer> {

    private final Spinner<Integer> spinner;
    private ObjectProperty<Integer> bindedProperty = null;

    public static <S> Callback<TableColumn<S, Integer>, TableCell<S, Integer>> forTableColumn() {
        return p -> new IntegerSpinnerTableCell<>();
    }

    private IntegerSpinnerTableCell() {
        this.spinner = new Spinner<>(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 150, 18, 1));
    }

    @Override
    protected void updateItem(Integer item, boolean empty) {
        super.updateItem(item, empty);

        if (bindedProperty != null) {
            spinner.getValueFactory().valueProperty().unbindBidirectional(bindedProperty);
            bindedProperty = null;
        }

        if (empty) {
            setGraphic(null);
        } else {
            bindedProperty = (ObjectProperty<Integer>) getTableColumn().getCellObservableValue(getIndex());
            spinner.getValueFactory().valueProperty().bindBidirectional(bindedProperty);

            setGraphic(spinner);
        }
    }
}