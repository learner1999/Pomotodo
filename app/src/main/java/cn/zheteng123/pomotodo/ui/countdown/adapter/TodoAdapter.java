package cn.zheteng123.pomotodo.ui.countdown.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import cn.zheteng123.pomotodo.R;
import cn.zheteng123.pomotodo.ui.countdown.entity.TodoEntity;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2017/04/06
 *     desc   : 倒计时页面的 to do 列表适配器
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_countdown_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TodoEntity todoEntity = mTodoEntityList.get(position);
        holder.tvName.setText(todoEntity.getName());
        holder.tvPomoNum.setText(String.format(Locale.getDefault(), "%d/%d", todoEntity.getCompletedNum(), todoEntity.getExpectNum()));
    }

    @Override
    public int getItemCount() {
        return mTodoEntityList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvPomoNum;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPomoNum = (TextView) itemView.findViewById(R.id.tv_pomo_num);
        }
    }
}
