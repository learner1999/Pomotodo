package cn.zheteng123.pomotodo.ui.todolist;

import java.util.List;

import cn.zheteng123.pomotodo.db.entity.TodoEntity;
import cn.zheteng123.pomotodo.ui.base.BasePresenter;
import cn.zheteng123.pomotodo.ui.base.BaseView;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2017/04/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class TodoContract {

    interface View extends BaseView {

        void showData(List<TodoEntity> todoEntityList0, List<TodoEntity> todoEntityList1, List<TodoEntity> todoEntityList2, List<TodoEntity> todoEntityList3);
    }

    interface Presenter extends BasePresenter<View> {

        void addTodo();

        void readData();
    }
}
