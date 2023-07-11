package sg.edu.rp.c346.id22012027.demodatabasecrudl9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    TextView textViewID;
    TextView textViewEditContent;
    EditText editTextContent2;
    Button buttonUpdate, buttonDelete;
    Note data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //initialize the variables with UI here
        textViewID = findViewById(R.id.textViewID);
        textViewEditContent = findViewById(R.id.textViewEditContent);
        editTextContent2 = findViewById(R.id.editTextContent2);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);

        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");

        textViewID.setText("ID: " + data.getId());
        editTextContent2.setText(data.getNoteContent());

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setNoteContent(editTextContent2.getText().toString());
                dbh.updateNote(data);
                dbh.close();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteNote(data.getId());

            }
        });

    }
}
