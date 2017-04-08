package cn.zheteng123.pomotodo.ui.todolist;

import java.util.ArrayList;
import java.util.List;

import cn.zheteng123.pomotodo.db.entity.TodoEntity;
import cn.zheteng123.pomotodo.ui.addtodo.AddTodoActivity;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2017/04/07
 *     desc   : TodoList 页面对应的 presenter
 *     version: 1.0
 * </pre>
 */
public class TodoPresenter implements TodoContract.Presenter {

    private TodoContract.View mView;

    @Override
    public void bindView(TodoContract.View view) {
        mView = view;
    }

    @Override
    public void addTodo() {
        AddTodoActivity.actionStart(mView.getContext());
    }

    @Override
    public void readData() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<TodoEntity> todoEntityRealmResults = realm.where(TodoEntity.class).findAll();

        List<TodoEntity> todoEntityList0 = new ArrayList<>();
        List<TodoEntity> todoEntityList1 = new ArrayList<>();
        List<TodoEntity> todoEntityList2 = new ArrayList<>();
        List<TodoEntity> todoEntityList3 = new ArrayList<>();
        for (TodoEntity todoEntity : todoEntityRealmResults) {
            switch (todoEntity.getCategory()) {
                case 0:
                    todoEntityList0.add(todoEntity);
                    break;

                case 1:
                    todoEntityList1.add(todoEntity);
                    break;

                case 2:
                    todoEntityList2.add(todoEntity);
                    break;

                case 3:
                    todoEntityList3.add(todoEntity);
                    break;

                default:
            }
        }

        mView.showData(todoEntityList0, todoEntityList1, todoEntityList2, todoEntityList3);
    }
}
