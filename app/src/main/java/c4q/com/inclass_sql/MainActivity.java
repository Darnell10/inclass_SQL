package c4q.com.inclass_sql;

import android.support.annotation.AnyRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bridge_DB_helper bridge_db_helper = new Bridge_DB_helper(getApplicationContext());

        bridge_db_helper.addbridge(new Bridge("Darnell ","Otto","Anywhere"));
        bridge_db_helper.addbridge(new Bridge("Ashley","Joachim","Anywhere"));
        bridge_db_helper.addbridge(new Bridge("Anne","K","Anywhere"));
        bridge_db_helper.addbridge(new Bridge("Jervon","","Anywhere"));
        bridge_db_helper.addbridge(new Bridge("Kevin","Toro","Anywhere"));
        bridge_db_helper.addbridge(new Bridge("Matin","M","Anywhere"));
        bridge_db_helper.addbridge(new Bridge("Amy","N/A","Anywhere"));
        bridge_db_helper.addbridge(new Bridge("Victoria","leon","Anywhere"));
        bridge_db_helper.addbridge(new Bridge("Tatiana","Moronta","Anywhere"));
        bridge_db_helper.addbridge(new Bridge("Daniel","N/A", "Anywhere"));


        List<Bridge> bridges = bridge_db_helper.getBridgeList();

        for(Bridge b : bridges){
            Log.d("What about Bridge?",b.getFirstName()+ "" + b.getLastName()+ "" + b.getCompany());
        }
    }
}
