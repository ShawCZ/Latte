package com.shaw.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.util.Patterns;
import android.view.View;

import com.shaw.latte.delegates.LatteDelegate;
import com.shaw.latte.ec.R;
import com.shaw.latte.ec.R2;
import com.shaw.latte.net.RestClient;
import com.shaw.latte.net.callback.ISuccess;
import com.shaw.latte.util.log.LatteLogger;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by shaw on 2017/9/2.
 */

public class SignUpDelegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText mName = null;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText mPhone = null;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText mPassword = null;
    @BindView(R2.id.edit_sign_up_re_password)
    TextInputEditText mRePassword = null;

    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener){
            mISignListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp(){
        if (checkForm()){
            RestClient.builder()
                    .url("")
                    .params("name",mName.getText().toString())
                    .params("email",mEmail.getText().toString())
                    .params("phone",mPhone.getText().toString())
                    .params("password",mPassword.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatteLogger.json("USER_PROFILE",response);
                            Log.d("fuck",response);
                            //将服务器返回的数据存进数据库
                            SignHandler.onSignUp(response,mISignListener);
                        }
                    })
                    .build()
                    .post();
        }
    }

    @OnClick(R2.id.tv_link_sign_in)
    void onClickLink(){
        getSupportDelegate().start(new SignInDelegate());
    }


    private boolean checkForm(){
        final String name = mName.getText().toString();
        final String email = mEmail.getText().toString();
        final String phone = mPhone.getText().toString();
        final String password = mPassword.getText().toString();
        final String rePassword = mRePassword.getText().toString();

        boolean isPass = true;

        if (name.isEmpty()){
            mName.setError("请输入用户名");
            isPass = false;
        }else {
            mName.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("邮箱格式错误");
            isPass = false;
        }else {
            mEmail.setError(null);
        }

        if (phone.isEmpty() || phone.length()!=11){
            mPhone.setError("手机号码格式错误");
            isPass = false;
        }else {
            mPhone.setError(null);
        }

        if (password.isEmpty() || password.length()<6){
            mPassword.setError("请至少填写6位数密码");
            isPass = false;
        }else {
            mPassword.setError(null);
        }

        if (rePassword.isEmpty() || rePassword.length()<6 || !(rePassword.equals(password))){
            mRePassword.setError("密码验证错误");
            isPass = false;
        }else {
            mRePassword.setError(null);
        }

        return isPass;
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootview) {

    }
}
