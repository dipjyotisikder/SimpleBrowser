package com.example.dipjyoti.browser;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.provider.Browser.*;

public class BrowserActivityHomePage extends AppCompatActivity {

    Button stopLoadingBtn;
    Button reloadBtn;
    Button bookViewBtn;
    WebView webView;
    ProgressBar progressBar;
    EditText editText;
    Button goButton;
    LinearLayout layout;
    Button facebookButton;
    Button youtubeButton;
    Button twitterButton;
    Button gmailButton;
    Button stackoverflowButton;
    Button homeButton;
    Button backwardButton;
    Button forwardButton;
    Button bookmarkButton;
    Button bookmarkDoneButton;
    private int flag;
//    String url;
//    String OriUrl;
//
//    String[] gotdata;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_home_page);

        editText = (EditText) findViewById(R.id.urlBarHomePage);
        goButton = (Button) findViewById(R.id.goButtonHomePage);
        webView = (WebView) findViewById(R.id.webView);
        layout = (LinearLayout) findViewById(R.id.layout);
        facebookButton = (Button) findViewById(R.id.facebookBtn);
        youtubeButton = (Button) findViewById(R.id.youtubeBtn);
        twitterButton = (Button) findViewById(R.id.twitterBtn);
        gmailButton = (Button) findViewById(R.id.gmailBtn);
        stackoverflowButton = (Button) findViewById(R.id.stackOverFlow);
        homeButton = (Button) findViewById(R.id.homeButton);
        backwardButton = (Button) findViewById(R.id.backwardButton);
        forwardButton = (Button) findViewById(R.id.forwardButton);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        bookmarkButton = (Button) findViewById(R.id.bookmarkButton);
        bookmarkDoneButton = (Button) findViewById(R.id.bookmarkDoneButton);
        bookViewBtn = (Button) findViewById(R.id.bookBtn);
        reloadBtn = (Button) findViewById(R.id.reloadbtn);
        stopLoadingBtn = (Button) findViewById(R.id.stoploading);
        flag = 0;
        progressBar.setMax(100);

        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState);
        } else {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webView.setBackgroundColor(Color.WHITE);
            webView.setWebViewClient(new WebViewClient());


            //webview operation
            webView.setWebChromeClient(new WebChromeClient() {


                public void onProgressChanged(WebView view, int progress) {
                    progressBar.setProgress(progress);
                    if (progress < 100 && progressBar.getVisibility() == progressBar.GONE && homeButton.getVisibility() == homeButton.VISIBLE) {
                        progressBar.setVisibility(progressBar.VISIBLE);
                        homeButton.setVisibility(homeButton.GONE);
                    }
                    if (progress == 100 && homeButton.getVisibility() == homeButton.GONE) {
                        progressBar.setVisibility(View.GONE);
                        homeButton.setVisibility(homeButton.VISIBLE);
                    }
                }
            });
        }

//        webView.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (webView.getVisibility() == webView.VISIBLE && webView.isPressed()) {
//                    editText.setText(webView.getUrl());
//                }
//
//                return false;
//            }
//        });

        //go button
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if (webView.getVisibility() == webView.GONE) {
                    webView.setVisibility(View.VISIBLE);
                    layout.setVisibility(View.GONE);
                }

                if (editText.getText().toString().contains(".com")||editText.getText().toString().contains(".net")||editText.getText().toString().contains(".in")||editText.getText().toString().contains(".pk")||editText.getText().toString().contains(".edu")||editText.getText().toString().contains(".edu.bd")||editText.getText().toString().contains(".cc")||editText.getText().toString().contains(".bd")||editText.getText().toString().contains(".me")||editText.getText().toString().contains(".tk")||editText.getText().toString().contains(".be")||editText.getText().toString().contains(".org")||editText.getText().toString().contains(".tv")){
                    webView.loadUrl("https://" + editText.getText().toString());
                }
                else {
                    webView.loadUrl("https://google.com");
                }
//                editText.setText("");
            }
        });

        //facebook button
        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if (webView.getVisibility() == webView.GONE) {
                    webView.setVisibility(View.VISIBLE);
                    layout.setVisibility(View.GONE);
                }
                webView.loadUrl("https://facebook.com");
//                editText.setText(webView.getUrl());
                editText.setText("");
                flag = 1;
            }
        });
//youtube button
        youtubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if (webView.getVisibility() == webView.GONE) {
                    webView.setVisibility(View.VISIBLE);
                    layout.setVisibility(View.GONE);
                }
                webView.loadUrl("https://youtube.com");
//                editText.setText(webView.getUrl());
                flag = 2;
              editText.setText("");
            }
        });
        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if (webView.getVisibility() == webView.GONE) {
                    webView.setVisibility(View.VISIBLE);
                    layout.setVisibility(View.GONE);
                }
                webView.loadUrl("https://twitter.com");
//                editText.setText(webView.getUrl());
                editText.setText("");
                flag = 3;
            }
        });

        gmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if (webView.getVisibility() == webView.GONE) {
                    webView.setVisibility(View.VISIBLE);
                    layout.setVisibility(View.GONE);
                }

                webView.loadUrl("https://gmail.com");
//                editText.setText(webView.getUrl());
                editText.setText("");
                flag = 4;
            }
        });
        stackoverflowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if (webView.getVisibility() == webView.GONE) {
                    webView.setVisibility(View.VISIBLE);
                    layout.setVisibility(View.GONE);
                }
                webView.loadUrl("https://stackoverflow.com");
//                editText.setText(webView.getUrl());
                editText.setText("");
                flag = 5;
            }
        });


//        Back button working here
        //changed

        backwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                editText.setText(webView.getOriginalUrl());
                if (webView.canGoBack()) {
                    webView.goBack();
                    editText.setText(webView.getOriginalUrl());

                } else if (!webView.canGoBack() && layout.getVisibility() == layout.GONE) {
                    layout.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);
                    if (!editText.getText().toString().isEmpty()) {
                        editText.setText("");
                    }
                } else {
                    layout.setVisibility(View.VISIBLE);
                }

            }
        });


        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (webView.canGoForward()) {
                    webView.goForward();
                    editText.setText(webView.getOriginalUrl());
                }

            }
        });


//        back button ends here


        //changed
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.getVisibility() == webView.VISIBLE && layout.getVisibility() == layout.GONE) {
//                    webView.destroy();
                    webView.removeAllViews();
                    webView.clearCache(true);
                    webView.setVisibility(View.GONE);
                    layout.setVisibility(View.VISIBLE);
                    if (!editText.getText().toString().isEmpty()) {
                        editText.setText("");
                    }

                }
            }
        });


        final DatabaseHelperBackup databaseObject = new DatabaseHelperBackup(getApplicationContext());
        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.getVisibility() == webView.VISIBLE && layout.getVisibility() == layout.GONE) {

                    String urlFromWebview = webView.getUrl().toString();
                    DataTemp dataTemp = new DataTemp(urlFromWebview);
                    databaseObject.addingDataToTable(dataTemp);
                    Toast.makeText(BrowserActivityHomePage.this, "Bookmark added successfully.Please Go to bookmark list to View Bookmarks ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(BrowserActivityHomePage.this, "Be in a webpage first!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        bookViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bookIntent = new Intent(BrowserActivityHomePage.this, BookMarkListView.class);
                startActivity(bookIntent);

            }
        });


        reloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.getVisibility() == webView.VISIBLE) {
                    webView.reload();
                } else {
                    Toast.makeText(BrowserActivityHomePage.this, "You are not in a webpage ", Toast.LENGTH_LONG).show();
                }
            }
        });


        stopLoadingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progressBar.getVisibility() == progressBar.VISIBLE) {
                    webView.stopLoading();
                    progressBar.setVisibility(View.GONE);
                }
//                editText.setText(webView.getUrl());
            }
        });


        //changed added
//        bookmarklist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String tableName = "urlTable";
//                String query = "SELECT * FROM " + tableName;
//                SQLiteDatabase db = databaseHelper.getReadableDatabase();
//                Cursor cursor = db.rawQuery(query, null);
//                //notice later
//
//                String[] tableData = null;
//
//                cursor.moveToFirst();
//
//                if(cursor.moveToFirst()){
//                    int counter = 0 ;
//                    do {
//                        tableData[counter] = cursor.getString(cursor.getColumnIndex(url+"")) +"\nURL: "+ cursor.getString(cursor.getColumnIndex(OriUrl+""));
//                        counter = counter+1;
//
//                    } while(cursor.moveToNext());
//
//                }
//
//                gotdata = tableData;
//
//                Toast.makeText(getApplicationContext(), gotdata+ "", Toast.LENGTH_LONG).show();

        //xtra
//                Intent intent = new Intent(BrowserActivityHomePage.this, BookMarkListView.class);
//                startActivity(intent);
//            }
//        });
    }

    //changed added
    @Override
    public void onBackPressed() {
//        editText.setText(webView.getUrl());
        if (webView.isFocused() && webView.canGoBack()) {
            webView.goBack();

        } else if (!(webView.canGoBack()) && layout.getVisibility() == layout.GONE) {
            webView.removeAllViews();
            webView.setVisibility(View.GONE);
            layout.setVisibility(View.VISIBLE);
            if (!editText.getText().toString().isEmpty()) {
                editText.setText("");
            }

        } else {
            Toast.makeText(getApplicationContext(), "Going Back is not possible anymore", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outSate) {
        super.onSaveInstanceState(outSate);
        webView.saveState(outSate);
    }
    //    @Override
//    public boolean onKeyShortcut(int keycode, KeyEvent e) {
//        switch(keycode) {
//            case KeyEvent.KEYCODE_BACK:
//                webView.removeAllViews();
//                return true;
//        }
//        return super.onKeyShortcut(keycode, e);
//    }
}
