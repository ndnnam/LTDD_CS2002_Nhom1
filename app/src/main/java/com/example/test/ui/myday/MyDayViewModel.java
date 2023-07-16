package com.example.test.ui.myday;

import android.app.Application;
import android.text.Layout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.MainActivity;
import com.example.test.R;
import com.example.test.adapter.RcVwAdapter;
import com.example.test.model.TaskModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kotlin.reflect.KVisibility;

public class MyDayViewModel extends ViewModel {

    private List<TaskModel> taskModelListFalse;
    private final MutableLiveData<String> txtGreat;
    private RcVwAdapter adapter;
    private static List<TaskModel> taskModelList;

    public MutableLiveData<String> getTxtTime() {
        return txtTime;
    }
    private final MutableLiveData<String> txtTime;

    {
        taskModelListFalse = new ArrayList<>();
        taskModelList = new ArrayList<>();
        adapter = new RcVwAdapter(this.addTaskModelList());
    }

    public MyDayViewModel() {
        txtGreat = new MutableLiveData<>();
        txtGreat.setValue("Good "+ getTime());

        txtTime = new MutableLiveData<>();
        txtTime.setValue(getDate());
    }
    public String getDate(){
        SimpleDateFormat simpleformat = new SimpleDateFormat("MMMM dd, yyyy");
        return simpleformat.format(new Date());
    }

    public String getTime(){
        Date date = new Date();
        int currentHour = date.getHours();
        if (currentHour >=0 && currentHour<= 12)
            return "Morning";
        else if (currentHour <= 17)
            return "Afternoon";
        else if (currentHour <= 20)
            return "Evening";
        else return "Night";
    }

    public List<TaskModel> getTaskModelListFalse(){
        return this.taskModelListFalse;
    }

    public List<TaskModel> addTaskModelListFalse(TaskModel taskModel){
        taskModelListFalse.add(taskModel);
        return taskModelListFalse;
    }

    public List<TaskModel> getTaskModelList()
    {
        return this.taskModelList;
    }

    public RcVwAdapter getAdapter(){
        return adapter;
    }

    public List<TaskModel> addTaskModelList(){
        taskModelList.add(new TaskModel("Home Work A"));
        taskModelList.add(new TaskModel("Home Work B"));
        taskModelList.add(new TaskModel("Home Work C"));
        taskModelList.add(new TaskModel("Home Work D"));
        taskModelList.add(new TaskModel("Home Work E"));
        return taskModelList;
    }

    public LiveData<String> getTxtGrate() {
        return txtGreat;
    }
}