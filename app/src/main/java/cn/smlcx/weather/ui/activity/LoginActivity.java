package cn.smlcx.weather.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import butterknife.BindView;
import butterknife.OnClick;
import cn.smlcx.weather.Base.BaseActivity;
import cn.smlcx.weather.R;
import cn.smlcx.weather.utils.ToastUtil;

/**
 * Created by Administrator on 2017/5/13.
 */

public class LoginActivity extends BaseActivity {
    protected final String TAG = this.getClass().getSimpleName();
    @BindView(R.id.userName)
    EditText mUserName;
    @BindView(R.id.passWord)
    EditText mPassWord;
    @BindView(R.id.msg)
    TextView mMsg;
    ProgressDialog pd;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.login)
    void click(View view) {
        if (mUserName.getText().toString().equals("")) {
            ToastUtil.show(mContext, "请输入用户名");
            return;
        } else if (mPassWord.getText().toString().equals("")) {
            ToastUtil.show(mContext, "请输入密码");
            return;
        } else {
            pd = ProgressDialog.show(this, "", "正在登录中...",
                    false, true);
            EMClient.getInstance().login(mUserName.getText().toString(), mPassWord.getText().toString(), new EMCallBack() {//回调
                @Override
                public void onSuccess() {
                    EMClient.getInstance().groupManager().loadAllGroups();
                    EMClient.getInstance().chatManager().loadAllConversations();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    pd.dismiss();
                    finish();
                }

                @Override
                public void onProgress(int progress, String status) {
                }

                @Override
                public void onError(int code, String message) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            mMsg.setText("登录聊天服务器失败！");
                            pd.dismiss();
                        }
                    });
                }
            });
        }
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void createPresenter() {

    }

    @Override
    protected void initInjector() {

    }

}
