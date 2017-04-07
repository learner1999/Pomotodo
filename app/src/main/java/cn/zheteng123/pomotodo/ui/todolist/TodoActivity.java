package cn.zheteng123.pomotodo.ui.todolist;

import android.os.Bundle;

import cn.zheteng123.pomotodo.R;
import cn.zheteng123.pomotodo.ui.base.BaseActivity;

public class TodoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_todo;
    }
}
