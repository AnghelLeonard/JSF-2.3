package beans;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelEvent;
import javax.faces.model.DataModelListener;
import javax.faces.model.FacesDataModel;

@FacesDataModel(forClass = ArraySet.class)
public final class SortDataModel<T> extends DataModel<T> {

    private static final Logger LOG = Logger.getLogger(SortDataModel.class.getName());
    private int index = -1;
    private ArraySet list;
    private Integer[] rows;

    public SortDataModel() {
        LOG.info("Using the SortDataModel !");
    }

    public SortDataModel(List<T> list) {
        super();
        LOG.info("Using the SortDataModel 2 !");
        setWrappedData(list);
    }

    @Override
    public boolean isRowAvailable() {
        if (list == null) {
            return (false);
        } else if ((index >= 0) && (index < list.size())) {
            return (true);
        } else {
            return (false);
        }
    }

    @Override
    public int getRowCount() {
        if (list == null) {
            return (-1);
        }
        return (list.size());
    }

    @Override
    public T getRowData() {

        if (list == null) {
            return (null);
        } else if (!isRowAvailable()) {
            try {
                throw new Exception();
            } catch (Exception ex) {
                Logger.getLogger(SortDataModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return ((T) list.get(index));
        }
        return (null);
    }

    @Override
    public int getRowIndex() {
        return (index);
    }

    @Override
    public void setRowIndex(int rowIndex) {

        if (rowIndex < -1) {
            throw new IllegalArgumentException();
        }
        int old = index;

        if ((0 <= rowIndex) && (rowIndex < rows.length)) {
            index = rows[rowIndex];
        } else {
            index = rowIndex;
        }

        if (list == null) {
            return;
        }

        DataModelListener[] listeners = getDataModelListeners();
        if ((old != index) && (listeners != null)) {
            Object rowData = null;
            if (isRowAvailable()) {
                rowData = getRowData();
            }
            DataModelEvent event
                    = new DataModelEvent(this, index, rowData);
            int n = listeners.length;
            for (int i = 0; i < n; i++) {
                if (null != listeners[i]) {
                    listeners[i].rowSelected(event);
                }
            }
        }
    }

    @Override
    public Object getWrappedData() {
        return (this.list);
    }

    @Override
    public void setWrappedData(Object data) {

        if (data == null) {
            list = null;
            setRowIndex(-1);
        } else {
            list = (ArraySet) data;

            initRows();

            index = -1;
            setRowIndex(0);
            sortThis((T key_1, T key_2) -> {
                if (key_1 == null ? key_2 == null : key_1.equals(key_2)) {
                    return 1;
                }
                if (key_1 == null) {
                    return -1;
                }
                if (key_2 == null) {
                    return 1;
                }
                return String.valueOf(key_1).compareTo(String.valueOf(key_2));
            });
        }
    }

    public void sortThis(final Comparator<T> comparator) {
        Comparator<Integer> rowc = (Integer key_1, Integer key_2) -> {
            T key_1_data = getData(key_1);
            T key_2_data = getData(key_2);
            return comparator.compare(key_1_data, key_2_data);
        };
        Arrays.sort(rows, rowc);
    }

    private T getData(int row) {
        int baseRowIndex = getRowIndex();

        setRowIndex(row);
        T newRowData = getRowData();
        setRowIndex(baseRowIndex);

        return newRowData;
    }

    private void initRows() {
        int rowCount = getRowCount();
        if (rowCount != -1) {
            this.rows = new Integer[rowCount];
            for (int i = 0; i < rowCount; ++i) {
                rows[i] = i;
            }
        }
    }
}
