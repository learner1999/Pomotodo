package cn.zheteng123.pomotodo.ui.todolist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zheteng123.pomotodo.R;
import cn.zheteng123.pomotodo.db.entity.TodoEntity;

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
        TodoEntity todoEntity = mTodoEntityList.get(position);
        holder.cbFinish.setText(todoEntity.getName());
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
