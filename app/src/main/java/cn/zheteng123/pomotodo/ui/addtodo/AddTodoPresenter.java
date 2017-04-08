package cn.zheteng123.pomotodo.ui.addtodo;

import java.util.UUID;

import cn.zheteng123.pomotodo.db.entity.TodoEntity;
import cn.zheteng123.pomotodo.ui.addtodo.entity.AddTodoEntity;
import io.realm.Realm;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2017/04/08
 *     desc   : AddTodo 页面对应的 Presenter
 *     version: 1.0
 * </pre>
 */
public class AddTodoPresenter implements AddTodoContract.Presenter {

    private AddTodoContract.View  mView;

    @Override
    public void bindView(AddTodoContract.View view) {
        mView = view;
    }

    @Override
    public void addTodo(final AddTodoEntity addTodoEntity) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                TodoEntity todoEntity = realm.createObject(TodoEntity.class, UUID.randomUUID().toString());
                todoEntity.setName(addTodoEntity.getName());
                todoEntity.setCategory(addTodoEntity.getCategory());
            }
        });
    }
}
