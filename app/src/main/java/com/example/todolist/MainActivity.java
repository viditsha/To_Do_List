package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTask;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        ListView listViewTasks = findViewById(R.id.listViewTasks);

        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listViewTasks.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask();
            }
        });
    }

    private void addTask() {
        String taskName = editTextTask.getText().toString().trim();

        if (!taskName.isEmpty()) {
            taskList.add(taskName);
            adapter.notifyDataSetChanged();
            editTextTask.getText().clear();
        }
    }
}
