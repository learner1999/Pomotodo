package cn.zheteng123.pomotodo.ui.todolist;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import cn.zheteng123.pomotodo.R;
import cn.zheteng123.pomotodo.ui.base.BaseActivity;

public class TodoActivity extends BaseActivity implements TodoContract.View {

    private TodoContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new TodoPresenter();
        mPresenter.bindView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_todo;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_todo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.add:
                mPresenter.addTodo();
                break;

            default:
        }

        return true;
    }

    @Override
    public Context getContext() {
        return this;
    }
}
