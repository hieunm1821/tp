package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.order.Order;

/**
 * Panel containing the list of orders.
 */
public class OrderListPanel extends ListPanel {
    private static final String FXML = "OrderListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(OrderListPanel.class);

    @FXML
    private ListView<Order> orderListView;

    /**
     * Creates a {@code DishListPanel} with the given {@code ObservableList}.
     */
    public OrderListPanel(ObservableList<Order> orderList) {
        super(FXML);
        orderListView.setItems(orderList);
        orderListView.setCellFactory(listView -> new OrderListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Dish} using a {@code DishCard}.
     */
    class OrderListViewCell extends ListCell<Order> {
        @Override
        protected void updateItem(Order order, boolean empty) {
            super.updateItem(order, empty);

            if (empty || order == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new OrderCard(order, getIndex() + 1).getRoot());
            }
        }
    }

}

