package com.codepath.apps.restclienttemplate;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by duongthoai on 10/29/16.
 */

public class TweetDialog extends DialogFragment {

    @BindView(R.id.content)
    EditText mContent;

    @BindView(R.id.close)
    ImageView close;

    @BindView(R.id.profile_image)
    CircleImageView imageView;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.submit)
    Button submit;


    public static TweetDialog makeInstance() {
        TweetDialog dialog = new TweetDialog();
//        Bundle b = new Bundle();
//        b.putParcelable("user", user);
//        dialog.setArguments(b);
        return dialog;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tweet_dialog, container);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.submit)
    public void submit() {
        if (!mContent.getText().toString().isEmpty()) {
            Log.e("data", "success");
            OnSubmitClickListener listener = (OnSubmitClickListener) getActivity();
            if (listener != null) {
                listener.onSubmit(mContent.getText().toString());
            }
            dismiss();
        } else {
            Toast.makeText(getActivity(), "input content", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.close)
    public void close() {
        dismiss();
    }

    public interface OnSubmitClickListener {
        public void onSubmit(String content);
    }
}
