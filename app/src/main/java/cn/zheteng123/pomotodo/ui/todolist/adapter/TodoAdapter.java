package cn.zheteng123.pomotodo.ui.todolist.adapter;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;
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
                    final List<TodoEntity> oldDataList = new ArrayList<>(mTodoEntityList);
                    mTodoEntityList.remove(todoEntity);

                    // 通过 DiffUtil 优化数据更新效果
                    DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                        @Override
                        public int getOldListSize() {
                            return oldDataList.size();
                        }

                        @Override
                        public int getNewListSize() {
                            return mTodoEntityList.size();
                        }

                        @Override
                        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                            return oldDataList.get(oldItemPosition).equals(mTodoEntityList.get(newItemPosition));
                        }

                        @Override
                        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                            return oldDataList.get(oldItemPosition).equals(mTodoEntityList.get(newItemPosition));
                        }
                    });
                    diffResult.dispatchUpdatesTo(TodoAdapter.this);

                    // 从数据库中删除
                    Realm realm = Realm.getDefaultInstance();
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            todoEntity.deleteFromRealm();
                        }
                    });
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
