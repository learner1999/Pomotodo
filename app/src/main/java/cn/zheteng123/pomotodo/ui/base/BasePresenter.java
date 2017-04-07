package cn.zheteng123.pomotodo.ui.base;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2017/04/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public interface BasePresenter<T> {

    void bindView(T view);
}
