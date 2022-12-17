package restaurant.repositories.interfaces;

import restaurant.entities.tables.interfaces.Table;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class TableRepositoryImpl implements TableRepository<Table>{

    private Map<String, Table> tables;


    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(tables.values());
    }

    @Override
    public void add(Table entity) {
        tables.put(entity.getClass().getSimpleName(), entity);
    }

    @Override
    public Table byNumber(int number) {
        Table table = tables.values().stream()
                .filter(t -> t.getTableNumber() == number)
                .findAny()
                .orElse(null);

        return table;
    }
}
