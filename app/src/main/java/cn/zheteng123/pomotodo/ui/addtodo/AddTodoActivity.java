package cn.zheteng123.pomotodo.ui.addtodo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;

import butterknife.BindView;
import cn.zheteng123.pomotodo.R;
import cn.zheteng123.pomotodo.ui.addtodo.entity.AddTodoEntity;
import cn.zheteng123.pomotodo.ui.base.BaseActivity;

public class AddTodoActivity extends BaseActivity implements AddTodoContract.View {

    private AddTodoContract.Presenter mPresenter;

    private int mCategory = 0;

    @BindView(R.id.et_name)
    EditText mEtName;

    @BindView(R.id.rg_category)
    RadioGroup mRgCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new AddTodoPresenter();
        mPresenter.bindView(this);

        initListener();
    }

    private void initListener() {
        mRgCategory.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_important_crash:
                        mCategory = 0;
                        break;

                    case R.id.rb_important_uncrash:
                        mCategory = 1;
                        break;

                    case R.id.rb_unimportant_crash:
                        mCategory = 2;
                        break;

                    case R.id.rb_unimportant_uncrash:
                        mCategory = 3;
                        break;

                    default:
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_todo;
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, AddTodoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_add_todo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            case R.id.confirm:
                // TODO: 2017/4/8 数据校验
                AddTodoEntity addTodoEntity = new AddTodoEntity();
                addTodoEntity.setName(mEtName.getText().toString());
                addTodoEntity.setCategory(mCategory);
                mPresenter.addTodo(addTodoEntity);
                finish();
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
