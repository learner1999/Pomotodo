package cn.zheteng123.pomotodo.ui.addtodo;

import cn.zheteng123.pomotodo.ui.addtodo.entity.AddTodoEntity;
import cn.zheteng123.pomotodo.ui.base.BasePresenter;
import cn.zheteng123.pomotodo.ui.base.BaseView;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2017/04/08
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class AddTodoContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

        void addTodo(AddTodoEntity addTodoEntity);
    }
}
