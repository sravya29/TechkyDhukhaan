package sravya.example.com.project1;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceException;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.sync.MobileServiceSyncContext;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.ColumnDataType;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.MobileServiceLocalStoreException;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.SQLiteLocalStore;
import com.microsoft.windowsazure.mobileservices.table.sync.synchandler.SimpleSyncHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class SearchResultsActivity extends Activity {
    private MobileServiceClient mClient;
    private MobileServiceTable<Product> mProductTable;
    private MyProductAdapter mAdapter;
    private EditText mTextProdName;
    private EditText mTextProdPrice;
    private FloatingActionButton floatbutton;
    Fragment fragment1=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myproductlist);

        try {

            AzureMobileServiceAdapter.Initialize(SearchResultsActivity.this);
            mClient = AzureMobileServiceAdapter.getInstance().getClient();

            mProductTable = mClient.getTable(Product.class);


            mAdapter = new MyProductAdapter(this, R.layout.product_mylist);
            mAdapter.setmActivity(this);
            ListView listViewProduct = (ListView) findViewById(R.id.lvProducts);
            listViewProduct.setAdapter(mAdapter);
            floatbutton=(FloatingActionButton)findViewById(R.id.floatbutton);
            refreshItemsFromTable();
            floatbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment1=new NewProductFragment();
                    if(fragment1!=null)
                    {
                        FragmentManager fragmentManager=getSupportFragmentManager();
                        FragmentTransaction ft1=fragmentManager.beginTransaction();
                        ft1.replace(R.id.content_frame,fragment1);
                        ft1.commit();
                    }

                }
            });

        } catch (Exception e){
            createAndShowDialog(e, "Error");
        }
    }


    public void addItem(View view) {
        if (mClient == null) {
            return;
        }

        final Product item = new Product();



        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    final Product retProd = addItemInTable(item);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.add(retProd);
                        }
                    });
                } catch (final Exception e) {
                    createAndShowDialogFromTask(e, "Error");
                }
                return null;
            }
        };

        runAsyncTask(task);

        mTextProdPrice.setText("");
        mTextProdName.setText("");
        mTextProdName.requestFocus();
    }

    public Product addItemInTable(Product item) throws ExecutionException, InterruptedException {
        return mProductTable.insert(item).get();
    }

    private void refreshItemsFromTable() {

        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<Product> results = refreshItemsFromMobileServiceTable();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.clear();

                            for (Product item : results) {
                                mAdapter.add(item);
                            }
                        }
                    });
                } catch (final Exception e){
                    createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }
        };

        runAsyncTask(task);
    }

    private List<Product> refreshItemsFromMobileServiceTable() throws ExecutionException, InterruptedException {
        try {
            return mProductTable.execute().get();
        } catch (MobileServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void createAndShowDialogFromTask(final Exception exception, String title) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                createAndShowDialog(exception, "Error");
            }
        });
    }

    private void createAndShowDialog(Exception exception, String title) {
        Throwable ex = exception;
        if(exception.getCause() != null){
            ex = exception.getCause();
        }
        createAndShowDialog(ex.getMessage(), title);
    }

    private void createAndShowDialog(final String message, final String title) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message);
        builder.setTitle(title);
        builder.create().show();
    }

    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

}