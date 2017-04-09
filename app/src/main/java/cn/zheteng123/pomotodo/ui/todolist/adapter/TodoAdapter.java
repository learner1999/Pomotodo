package cn.zheteng123.pomotodo.ui.todolist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zheteng123.pomotodo.R;
import cn.zheteng123.pomotodo.db.entity.TodoEntity;
import io.realm.Realm;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2017/04/08
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<TodoEntity> mTodoEntityList;

    public TodoAdapter(List<TodoEntity> todoEntityList) {
        mTodoEntityList = todoEntityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todolist_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TodoEntity todoEntity = mTodoEntityList.get(position);
        holder.cbFinish.setText(todoEntity.getName());
        holder.cbFinish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mTodoEntityList.remove(todoEntity);

                    // 从数据库中删除
                    Realm realm = Realm.getDefaultInstance();
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            todoEntity.deleteFromRealm();
                        }
                    });

                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTodoEntityList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cb_finish)
        CheckBox cbFinish;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
