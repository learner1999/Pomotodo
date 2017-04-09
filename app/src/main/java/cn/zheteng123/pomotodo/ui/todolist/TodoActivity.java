package cn.zheteng123.pomotodo.ui.todolist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.zheteng123.pomotodo.R;
import cn.zheteng123.pomotodo.db.entity.TodoEntity;
import cn.zheteng123.pomotodo.ui.base.BaseActivity;
import cn.zheteng123.pomotodo.ui.todolist.adapter.TodoAdapter;

public class TodoActivity extends BaseActivity implements TodoContract.View {

    private TodoContract.Presenter mPresenter;

    private List<TodoEntity> mTodoEntityList0 = new ArrayList<>();
    private List<TodoEntity> mTodoEntityList1 = new ArrayList<>();
    private List<TodoEntity> mTodoEntityList2 = new ArrayList<>();
    private List<TodoEntity> mTodoEntityList3 = new ArrayList<>();

    private TodoAdapter mTodoAdapter0, mTodoAdapter1, mTodoAdapter2, mTodoAdapter3;

    @BindView(R.id.rv_important_crash)
    RecyclerView mRvImportantCrash;

    @BindView(R.id.rv_important_uncrash)
    RecyclerView mRvImportantUncrash;

    @BindView(R.id.rv_unimportant_crash)
    RecyclerView mRvUnimportantCrash;

    @BindView(R.id.rv_unimportant_uncrash)
    RecyclerView mRvUnimportantUncrash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new TodoPresenter();
        mPresenter.bindView(this);

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.readData();
    }

    private void initView() {
        LinearLayoutManager layoutManager0 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRvImportantCrash.setLayoutManager(layoutManager0);
        mRvImportantUncrash.setLayoutManager(layoutManager1);
        mRvUnimportantCrash.setLayoutManager(layoutManager2);
        mRvUnimportantUncrash.setLayoutManager(layoutManager3);

        mTodoAdapter0 = new TodoAdapter(mTodoEntityList0);
        mTodoAdapter1 = new TodoAdapter(mTodoEntityList1);
        mTodoAdapter2 = new TodoAdapter(mTodoEntityList2);
        mTodoAdapter3 = new TodoAdapter(mTodoEntityList3);
        mRvImportantCrash.setAdapter(mTodoAdapter0);
        mRvImportantUncrash.setAdapter(mTodoAdapter1);
        mRvUnimportantCrash.setAdapter(mTodoAdapter2);
        mRvUnimportantUncrash.setAdapter(mTodoAdapter3);
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

    @Override
    public void showData(List<TodoEntity> todoEntityList0, List<TodoEntity> todoEntityList1, List<TodoEntity> todoEntityList2, List<TodoEntity> todoEntityList3) {
        mTodoEntityList0.clear();
        mTodoEntityList1.clear();
        mTodoEntityList2.clear();
        mTodoEntityList3.clear();
        mTodoEntityList0.addAll(todoEntityList0);
        mTodoEntityList1.addAll(todoEntityList1);
        mTodoEntityList2.addAll(todoEntityList2);
        mTodoEntityList3.addAll(todoEntityList3);
        mTodoAdapter0.notifyDataSetChanged();
        mTodoAdapter1.notifyDataSetChanged();
        mTodoAdapter2.notifyDataSetChanged();
        mTodoAdapter3.notifyDataSetChanged();
    }
}
