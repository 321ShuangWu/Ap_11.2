package bjut.net.ap.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bjut.net.ap.R;
import bjut.net.ap.model.MeetingSign;
import bjut.net.ap.model.Sign;

/**
 * Created by 张胜凡 on 2017/12/19 15:13.
 */

public class SignRecyclerAdapter extends RecyclerView.Adapter<MySignViewHolder> {
    private static final String TAG = "zhangvalue";
    private LayoutInflater mInflater;
    private Context mContext;
    List<Sign> mCoursesDatas;

    public SignRecyclerAdapter(Context context, List<Sign> datas) {
        this.mContext = context;
        this.mCoursesDatas = datas;
        mInflater = LayoutInflater.from(context);
        Log.i("zhangvalue","come--------------");
    }
    /**
     * Data有多少条获取数据的数量
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mCoursesDatas.size();
    }


    @Override
    public MySignViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MySignViewHolder holder = new MySignViewHolder(mInflater.inflate(R.layout.cell_sign_list, parent,
                false));
        return holder;
    }

    /**
     * 绑定ViewHolder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MySignViewHolder holder, int position) {
        Log.i("zhangvalue","签到时间--------------"+mCoursesDatas.get(position).getSigntime());
        holder.txt_course_name.setText("课程名：" + mCoursesDatas.get(position).getCoursename());
        holder.txt_teacher.setText("授课教师：" + mCoursesDatas.get(position).getTeachername());
        holder.txt_username.setText("签到者:" + mCoursesDatas.get(position).getSname());
        holder.txt_sign_time.setText("签到时间:" + mCoursesDatas.get(position).getSigntime());
    }
}

//自定义的ViewHolder，持有每个Item的的所有界面元素
class MySignViewHolder extends ViewHolder {
    TextView txt_course_name;
    TextView txt_teacher;
    TextView txt_sign_time;
    TextView txt_username;


    public MySignViewHolder(View itemView) {
        super(itemView);

        txt_course_name = itemView.findViewById(R.id.sign_txt_name);
        txt_teacher = itemView.findViewById(R.id.sign_txt_teacher);
        txt_sign_time = itemView.findViewById(R.id.sign_txt_time);
        txt_username= itemView.findViewById(R.id.sign_txt_username);
    }


}
