package cn.kerry.sharestudio.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.Unbinder;
import cn.kerry.sharestudio.global.MyApplication;
import cn.kerry.sharestudio.utils.KL;
import me.yokeyword.fragmentation.SupportActivity;


public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity {


    protected Unbinder mUnbinder;
    protected T mPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KL.d(this.getClass(), this.getClass().getName() + "---OnCreate");

        inits();
    }

    private void inits() {
        setTranslucentStatus(true);//设置沉浸栏
        onPreCreate();//设置主题颜色
        MyApplication.getInstance().registerActivity(this);
    }

    private void setTranslucentStatus(boolean b) {
    }

    private void onPreCreate() {

    }
}
