package com.iteration2.mark.iteration3loginslides;

        import android.app.Activity;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.TableLayout;
        import android.widget.TextView;

        import com.nostra13.universalimageloader.core.DisplayImageOptions;
        import com.nostra13.universalimageloader.core.ImageLoader;
        import com.nostra13.universalimageloader.core.assist.ImageSize;
        import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

        import java.util.ArrayList;


public class SocietyHome extends Activity {

    String societyName;
    String name;


    ArrayList<String> subscribedSocietyList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Intent intent = getIntent();
//        societyName = intent.getStringExtra("NameOfSociety");

        boolean userInitiallySubscribed;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("socName");
        }


        subscribedSocietyList = new ArrayList<String>();

        userInitiallySubscribed = subscribedSocietyList.contains("testSociety");

        //List userSocietySubscribed = new Array
        super.onCreate(savedInstanceState);
        //Set the layout to the society home page layout
        setContentView(R.layout.activity_society_home);

        setupTextAndBackground(name);
        createImageLinks();
        setupBackButton();


        final Button subscribeButton = (Button) findViewById(R.id.subscribeButton);
        subscribeButton.setOnClickListener(new View.OnClickListener(){
            boolean userSubscribed;
            int societyIndex;

            public void onClick(View v)
            {
                userSubscribed = subscribedSocietyList.contains("testSociety");
                if(userSubscribed)
                {
                    societyIndex = subscribedSocietyList.indexOf("testSociety");
                    subscribedSocietyList.remove(societyIndex);
                    subscribeButton.setText("Subscribe");
                }
                else
                {
                    subscribedSocietyList.add("testSociety");
                    subscribeButton.setText("Unsubscribe");
                }
            }


        });
        if(userInitiallySubscribed)
        {
            subscribeButton.setText("Unsubscribe");
        }
        else
        {
            subscribeButton.setText("Subscribe");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_society_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void createImageLinks()
    {

        ImageButton societyLinkButton1 = (ImageButton) findViewById(R.id.exampleSocietyButton1);
        ImageButton societyLinkButton2 = (ImageButton) findViewById(R.id.exampleSocietyButton2);
        ImageButton societyLinkButton3 = (ImageButton) findViewById(R.id.exampleSocietyButton3);
        ImageButton societyLinkButton4 = (ImageButton) findViewById(R.id.exampleSocietyButton4);


        societyLinkButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //This will be connected to the societies presentation slide pages, for now it
                //goes to the example activity to show the link works
                //To attach this to the presentation slide pages, replace "ExampleActivity" with that
                Intent intent = new Intent(SocietyHome.this, VideoBankHandler.class);
                //Attach the society name
                intent.putExtra("NameOfSociety", societyName);
                //Start the activity
                startActivity(intent);
            }
        });



        societyLinkButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SocietyHome.this, PresentationSlides.class);
                intent.putExtra("NameOfSociety", societyName);
                startActivity(intent);
            }
        });



        societyLinkButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SocietyHome.this, ImageBank.class);
                intent.putExtra("NameOfSociety", societyName);
                startActivity(intent);
            }
        });



        societyLinkButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SocietyHome.this, ExampleActivity.class);
                intent.putExtra("NameOfSociety", societyName);
                startActivity(intent);
            }
        });

    }

    public void setupBackButton()
    {
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SocietyHome.this, UserHome.class);
                startActivity(intent);
            }
        });
    }

    public void setupTextAndBackground(String socName)
    {

        /*String societyTitleStringName = societyName + "Title";
        String societyTitleColorStringName = societyName + "TitleColor";
        String societyDescriptionStringName = societyName + "TitleDescription";
        String societyDescriptionColorStringName = societyName + "TitleDescriptionColor";

        int societyTitleID = getResources().getIdentifier(societyTitleStringName, "string", "com.claritas.anton.socbox");
        int societyTitleColorID = getResources().getIdentifier(societyTitleColorStringName, "string", "com.claritas.anton.socbox");

        int societyDescriptionID = getResources().getIdentifier(societyDescriptionStringName, "string", "com.claritas.anton.socbox");
        int societyDescriptionColorID = getResources().getIdentifier(societyDescriptionColorStringName, "string", "com.claritas.anton.socbox");*/

        String societyTitleString = getResources().getString(R.string.testsocietyTitle);
        String societyTitleColorString = getResources().getString(R.string.testsocietyTitleColor);

        String societyDescriptionString = socName;
        String societyDescriptionColorString = getResources().getString(R.string.testsocietyDescriptionColor);

        TextView societyTitle = (TextView) findViewById(R.id.societyTitle);
        societyTitle.setText(societyTitleString);
        //societyTitle.setTextColor(societyTitleColorID);

        TextView societyDescription = (TextView) findViewById(R.id.societyDescription);
        societyTitle.setText(societyDescriptionString);
        //societyTitle.setTextColor(societyDescriptionColorString);

        TableLayout societyPageBackground = (TableLayout) findViewById(R.id.societyBackground);
        //societyPageBackground.setBackground(R.drawable.test1);*/
    }
}
