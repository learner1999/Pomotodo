package cn.zheteng123.pomotodo.ui.todolist;

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
}
