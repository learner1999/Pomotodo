package cn.zheteng123.pomotodo.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zheteng123.pomotodo.R;
import cn.zheteng123.pomotodo.ui.countdown.CountdownActivity;
import cn.zheteng123.pomotodo.ui.todolist.TodoActivity;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2017/04/06
 *     desc   : Activity 基类，在其中做一些初始化操作
 *     version: 1.0
 * </pre>
 */
public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Nullable
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Nullable
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        initToolbar();
        initNavigationView();
    }

    protected void initNavigationView() {
        if (mNavigationView == null) {
            return;
        }
        mNavigationView.setCheckedItem(getNavCheckItem());
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == getNavCheckItem()) {
                    return false;
                }

                switch (item.getItemId()) {
                    case R.id.nav_todo:
                        mDrawerLayout.closeDrawers();
                        TodoActivity.actionStart(BaseActivity.this);
                        break;

                    case R.id.nav_pomodoro:
                        mDrawerLayout.closeDrawers();
                        CountdownActivity.actionStart(BaseActivity.this);
                        break;

                    default:
                }
                finish();
                return true;
            }
        });
    }

    protected int getNavCheckItem() {
        return 0;
    }

    protected abstract int getLayoutId();

    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;

            default:
        }
        return true;
    }
}
