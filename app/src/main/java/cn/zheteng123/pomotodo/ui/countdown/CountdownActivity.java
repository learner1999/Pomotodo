package cn.zheteng123.pomotodo.ui.countdown;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zheteng123.pomotodo.R;
import cn.zheteng123.pomotodo.ui.base.BaseActivity;
import cn.zheteng123.pomotodo.ui.countdown.adapter.TodoAdapter;
import cn.zheteng123.pomotodo.ui.countdown.entity.TodoEntity;
import cn.zheteng123.pomotodo.ui.custom.CountdownView;

public class CountdownActivity extends BaseActivity {

    private List<TodoEntity> mTodoEntityList = new ArrayList<>();

    private TodoAdapter mTodoAdapter;

    @BindView(R.id.btn_start)
    Button mBtnStart;

    @BindView(R.id.countdown_view)
    CountdownView mCountdownView;

    @BindView(R.id.rv_todo)
    RecyclerView mRvTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }

    private void initData() {
        TodoEntity todoEntity1 = new TodoEntity();
        todoEntity1.setName("看完上午收藏的博文1");
        todoEntity1.setCompletedNum(3);
        todoEntity1.setExpectNum(4);
        mTodoEntityList.add(todoEntity1);
        TodoEntity todoEntity2 = new TodoEntity();
        todoEntity2.setName("看完上午收藏的博文2");
        todoEntity2.setCompletedNum(2);
        todoEntity2.setExpectNum(1);
        mTodoEntityList.add(todoEntity2);
        TodoEntity todoEntity3 = new TodoEntity();
        todoEntity3.setName("看完上午收藏的博文3");
        todoEntity3.setCompletedNum(2);
        todoEntity3.setExpectNum(5);
        mTodoEntityList.add(todoEntity3);
        mTodoAdapter.notifyDataSetChanged();
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRvTodo.setLayoutManager(linearLayoutManager);
        mTodoAdapter = new TodoAdapter(mTodoEntityList);
        mRvTodo.setAdapter(mTodoAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_countdown;
    }

    @OnClick(R.id.btn_start)
    void startCountdown() {
        mCountdownView.startCountdown();
        mBtnStart.setText("停止倒计时");
    }
}
