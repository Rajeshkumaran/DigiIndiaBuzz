package com.example.rajesh.digiindiabuzz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Career extends AppCompatActivity {
Button submit,upload;
    ProgressDialog pg;
    String username,date,email,epwd,gen,exp,subject;
    private static final int FILE_SELECT_CODE = 0;
    TextView resume;
    TextInputLayout namefloat,genderfloat,dobfloat,mailpwdfloat,mailfloat,messagefloat,freshfloat;
    EditText name,gender,dob,mail,mailpwd,message,fresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("\t\t\tCareer");
        setContentView(R.layout.activity_career);

        submit = (Button) findViewById(R.id.submit);
        upload = (Button) findViewById(R.id.upload);
        resume=(TextView)findViewById(R.id.resume);
        name=(EditText)findViewById(R.id.name);
        gender=(EditText)findViewById(R.id.gender);
        dob=(EditText)findViewById(R.id.dob);
        mail=(EditText)findViewById(R.id.mail);
        fresh=(EditText)findViewById(R.id.fresh);
        message=(EditText)findViewById(R.id.message);
        pg=new ProgressDialog(this,R.style.AppCompatAlertDialogStyle);


        namefloat=(TextInputLayout)findViewById(R.id.namefloat);
        genderfloat=(TextInputLayout)findViewById(R.id.genderfloat);
        dobfloat=(TextInputLayout)findViewById(R.id.dobfloat);
        mailfloat=(TextInputLayout)findViewById(R.id.mailfloat);
        messagefloat=(TextInputLayout)findViewById(R.id.messagefloat);
        freshfloat=(TextInputLayout)findViewById(R.id.freshfloat);


        namefloat.setHint("Name");
        genderfloat.setHint("Gender");
        dobfloat.setHint("Date of Birth");
        mailfloat.setHint("e-mail id");
        messagefloat.setHint("message here");
        freshfloat.setHint("Fresher or experience");









        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                try {
                    startActivityForResult(
                            Intent.createChooser(intent, "Select a File to Upload"),
                            FILE_SELECT_CODE);

                } catch (android.content.ActivityNotFoundException ex) {
                    // Potentially direct the user to the Market with a Dialog
                    Toast.makeText(Career.this, "Please install a File Manager.",Toast.LENGTH_SHORT).show();
                }
            }
        });
final String pwd="banukumaran";
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 username = name.getText().toString();
                gen = gender.getText().toString();
                date = dob.getText().toString();
                subject = message.getText().toString();
                email = mail.getText().toString();
                exp = fresh.getText().toString();
                if (name.getText().length() == 0)
                    name.requestFocus();
                else if (gender.getText().length() == 0) {
                    gender.requestFocus();
                } else if (dob.getText().length() == 0) {
                    dob.requestFocus();
                }
                else if (fresh.length() == 0)
                    fresh.requestFocus();
                else if (mail.length() == 0) {
                    mail.requestFocus();
                }
                else if (message.length() == 0)
                    message.requestFocus();
                else if (resume.length() == 0)
                    resume.setText("please upload your resume");
                else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            try {


                                GMailSender sender = new GMailSender("userdetailsdig@gmail.com","digiindiabuzz2k17");
                               System.out.println(resume.getText().toString());
                                sender.addAttachment(resume.getText().toString());
                         sender.sendMail("Rajesh has sent Test mail","Name:   " + username + "\n\n" + "Gender:   " + gen + "\n\n" + "Date of Birth:   " + date + "\n\n" + "Fresher or Experience: " + exp + "\n\n" + "e-mail id: " + email + "\n\n" + "Message:" + subject + "\n\n" + "I have attached my Resume below...",
                                        "userdetailsdig@gmail.com","digiindiabuzz@gmail.com");



                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                            }

                        }

                    }).start();
                        pg.dismiss();

                }
                new CountDownTimer(4000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        pg.setMessage("Submitting...");
                        pg.show();
                    }

                    @Override
                    public void onFinish() {
                        pg.dismiss();
                        Toast.makeText(getApplicationContext(),"Submitted succesfully",Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }

        });


    }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            switch (requestCode) {
                case FILE_SELECT_CODE:
                    if (resultCode == RESULT_OK) {
                        // Get the Uri of the selected file
                        Uri uri = data.getData();
                        // Get the path
                        String path = uri.getPath();

                       String fullpath=FileUtils.getPath(getApplicationContext(),uri);
                        resume.setText(fullpath.toString());
                        // Get the file instance
                        // File file = new File(path);
                        // Initiate the upload
                    }
                    break;
            }
            super.onActivityResult(requestCode, resultCode, data);
        }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(Career.this,MainActivity.class);
        startActivity(i);
        this.finish();
    }



}


