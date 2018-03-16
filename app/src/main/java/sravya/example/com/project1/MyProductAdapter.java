package sravya.example.com.project1;
/**
 * Created by SRAVYA on 11-03-2018.
 */
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import java.util.concurrent.ExecutionException;
/**
 * Created by SRAVYA on 11-03-2018.
 */

public class MyProductAdapter extends ArrayAdapter<Product> {
    Context mContext;
    int mLayoutResourceId;
    View row;
    private MobileServiceClient mClient;
    private MobileServiceTable<Product> mProductTable;
    private MyProductAdapter mAdapter;
    private Activity mActivity;

    public MyProductAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;

        mClient = AzureMobileServiceAdapter.getInstance().getClient();
        mProductTable = mClient.getTable(Product.class);

        mAdapter = this;
    }

    public void setmActivity(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        row = convertView;

        final Product currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        return row;
    }

    public void deleteItem(final Product item) {
        if (mClient == null) {
            return;
        }

        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    deleteItemInTable(item);

                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.remove(item);
                        }
                    });

                } catch (final Exception e) {
                    createAndShowDialogFromTask(e, "Error");
                }
                return null;
            }
        };

        runAsyncTask(task);

    }

    public void deleteItemInTable(Product item) throws ExecutionException, InterruptedException {
        mProductTable.delete(item);
    }

    public void updateItem(final Product item) {
        if (mClient == null) {
            return;
        }

        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    final Product p =  updateItemInTable(item);

                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ;
                        }
                    });

                } catch (final Exception e) {
                    createAndShowDialogFromTask(e, "Error");
                }
                return null;
            }
        };

        runAsyncTask(task);

    }

    public Product updateItemInTable(Product item) throws ExecutionException, InterruptedException {
        return mProductTable.update(item).get();
    }

    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private void createAndShowDialogFromTask(final Exception exception, String title) {
        mActivity.runOnUiThread(new Runnable() {
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
        final AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);

        builder.setMessage(message);
        builder.setTitle(title);
        builder.create().show();
    }

}

